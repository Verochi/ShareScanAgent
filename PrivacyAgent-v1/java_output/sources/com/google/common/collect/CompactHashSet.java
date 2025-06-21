package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class CompactHashSet<E> extends java.util.AbstractSet<E> implements java.io.Serializable {
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient java.lang.Object[] elements;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient long[] entries;
    transient float loadFactor;
    transient int modCount;
    private transient int size;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    /* renamed from: com.google.common.collect.CompactHashSet$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Iterator<E> {
        public int n;
        public int t;
        public int u = -1;

        public AnonymousClass1() {
            this.n = com.google.common.collect.CompactHashSet.this.modCount;
            this.t = com.google.common.collect.CompactHashSet.this.firstEntryIndex();
        }

        public final void a() {
            if (com.google.common.collect.CompactHashSet.this.modCount != this.n) {
                throw new java.util.ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.t >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            int i = this.t;
            this.u = i;
            com.google.common.collect.CompactHashSet compactHashSet = com.google.common.collect.CompactHashSet.this;
            E e = (E) compactHashSet.elements[i];
            this.t = compactHashSet.getSuccessor(i);
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.collect.CollectPreconditions.e(this.u >= 0);
            this.n++;
            com.google.common.collect.CompactHashSet compactHashSet = com.google.common.collect.CompactHashSet.this;
            compactHashSet.remove(compactHashSet.elements[this.u], com.google.common.collect.CompactHashSet.getHash(compactHashSet.entries[this.u]));
            this.t = com.google.common.collect.CompactHashSet.this.adjustAfterRemove(this.t, this.u);
            this.u = -1;
        }
    }

    public CompactHashSet() {
        init(3, 1.0f);
    }

    public CompactHashSet(int i) {
        init(i, 1.0f);
    }

    public static <E> com.google.common.collect.CompactHashSet<E> create() {
        return new com.google.common.collect.CompactHashSet<>();
    }

    public static <E> com.google.common.collect.CompactHashSet<E> create(java.util.Collection<? extends E> collection) {
        com.google.common.collect.CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public static <E> com.google.common.collect.CompactHashSet<E> create(E... eArr) {
        com.google.common.collect.CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        java.util.Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> com.google.common.collect.CompactHashSet<E> createWithExpectedSize(int i) {
        return new com.google.common.collect.CompactHashSet<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i) {
        long[] jArr = new long[i];
        java.util.Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i) {
        int[] iArr = new int[i];
        java.util.Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            } else {
                add(objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean remove(java.lang.Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && com.google.common.base.Objects.equal(obj, this.elements[i2])) {
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveEntry(i2);
                this.size--;
                this.modCount++;
                return true;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return false;
            }
            i3 = i2;
            i2 = next;
        }
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = java.lang.Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.loadFactor)) + 1;
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int hash = getHash(jArr[i3]);
            int i4 = hash & length;
            int i5 = newTable[i4];
            newTable[i4] = i3;
            jArr[i3] = (hash << 32) | (i5 & 4294967295L);
        }
        this.threshold = i2;
        this.table = newTable;
    }

    private static long swapNext(long j, int i) {
        return (j & HASH_MASK) | (4294967295L & i);
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
        long[] jArr = this.entries;
        java.lang.Object[] objArr = this.elements;
        int d = com.google.common.collect.Hashing.d(e);
        int hashTableMask = hashTableMask() & d;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == d && com.google.common.base.Objects.equal(e, objArr[i2])) {
                    return false;
                }
                int next = getNext(j);
                if (next == -1) {
                    jArr[i2] = swapNext(j, i);
                    break;
                }
                i2 = next;
            }
        }
        if (i == Integer.MAX_VALUE) {
            throw new java.lang.IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i3 = i + 1;
        resizeMeMaybe(i3);
        insertEntry(i, e, d);
        this.size = i3;
        if (i >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return true;
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        java.util.Arrays.fill(this.elements, 0, this.size, (java.lang.Object) null);
        java.util.Arrays.fill(this.table, -1);
        java.util.Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int d = com.google.common.collect.Hashing.d(obj);
        int i = this.table[hashTableMask() & d];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == d && com.google.common.base.Objects.equal(obj, this.elements[i])) {
                return true;
            }
            i = getNext(j);
        }
        return false;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    public void init(int i, float f) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        com.google.common.base.Preconditions.checkArgument(f > 0.0f, "Illegal load factor");
        int a = com.google.common.collect.Hashing.a(i, f);
        this.table = newTable(a);
        this.loadFactor = f;
        this.elements = new java.lang.Object[i];
        this.entries = newEntries(i);
        this.threshold = java.lang.Math.max(1, (int) (a * f));
    }

    public void insertEntry(int i, E e, int i2) {
        this.entries[i] = (i2 << 32) | 4294967295L;
        this.elements[i] = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator<E> iterator() {
        return new com.google.common.collect.CompactHashSet.AnonymousClass1();
    }

    public void moveEntry(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.elements[i] = null;
            this.entries[i] = -1;
            return;
        }
        java.lang.Object[] objArr = this.elements;
        objArr[i] = objArr[size];
        objArr[size] = null;
        long[] jArr = this.entries;
        long j = jArr[size];
        jArr[i] = j;
        jArr[size] = -1;
        int hash = getHash(j) & hashTableMask();
        int[] iArr = this.table;
        int i2 = iArr[hash];
        if (i2 == size) {
            iArr[hash] = i;
            return;
        }
        while (true) {
            long j2 = this.entries[i2];
            int next = getNext(j2);
            if (next == size) {
                this.entries[i2] = swapNext(j2, i);
                return;
            }
            i2 = next;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return remove(obj, com.google.common.collect.Hashing.d(obj));
    }

    public void resizeEntries(int i) {
        this.elements = java.util.Arrays.copyOf(this.elements, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = java.util.Arrays.copyOf(jArr, i);
        if (i > length) {
            java.util.Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public java.lang.Object[] toArray() {
        return java.util.Arrays.copyOf(this.elements, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) com.google.common.collect.ObjectArrays.g(this.elements, 0, this.size, tArr);
    }

    public void trimToSize() {
        int i = this.size;
        if (i < this.entries.length) {
            resizeEntries(i);
        }
        int max = java.lang.Math.max(1, java.lang.Integer.highestOneBit((int) (i / this.loadFactor)));
        if (max < 1073741824 && i / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }
}
