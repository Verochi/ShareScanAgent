package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class CompactHashMap<K, V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient long[] entries;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<java.util.Map.Entry<K, V>> entrySetView;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<K> keySetView;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient java.lang.Object[] keys;
    transient float loadFactor;
    transient int modCount;
    private transient int size;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient java.lang.Object[] values;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Collection<V> valuesView;

    /* renamed from: com.google.common.collect.CompactHashMap$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.CompactHashMap<K, V>.Itr<K> {
        public AnonymousClass1() {
            super(com.google.common.collect.CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.Itr
        public K b(int i) {
            return (K) com.google.common.collect.CompactHashMap.this.keys[i];
        }
    }

    /* renamed from: com.google.common.collect.CompactHashMap$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.CompactHashMap<K, V>.Itr<java.util.Map.Entry<K, V>> {
        public AnonymousClass2() {
            super(com.google.common.collect.CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.Itr
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> b(int i) {
            return new com.google.common.collect.CompactHashMap.MapEntry(i);
        }
    }

    /* renamed from: com.google.common.collect.CompactHashMap$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.common.collect.CompactHashMap<K, V>.Itr<V> {
        public AnonymousClass3() {
            super(com.google.common.collect.CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.Itr
        public V b(int i) {
            return (V) com.google.common.collect.CompactHashMap.this.values[i];
        }
    }

    public class EntrySetView extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
        public EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            int indexOf = com.google.common.collect.CompactHashMap.this.indexOf(entry.getKey());
            return indexOf != -1 && com.google.common.base.Objects.equal(com.google.common.collect.CompactHashMap.this.values[indexOf], entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return com.google.common.collect.CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            int indexOf = com.google.common.collect.CompactHashMap.this.indexOf(entry.getKey());
            if (indexOf == -1 || !com.google.common.base.Objects.equal(com.google.common.collect.CompactHashMap.this.values[indexOf], entry.getValue())) {
                return false;
            }
            com.google.common.collect.CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.CompactHashMap.this.size;
        }
    }

    public abstract class Itr<T> implements java.util.Iterator<T> {
        public int n;
        public int t;
        public int u;

        public Itr() {
            this.n = com.google.common.collect.CompactHashMap.this.modCount;
            this.t = com.google.common.collect.CompactHashMap.this.firstEntryIndex();
            this.u = -1;
        }

        public /* synthetic */ Itr(com.google.common.collect.CompactHashMap compactHashMap, com.google.common.collect.CompactHashMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a() {
            if (com.google.common.collect.CompactHashMap.this.modCount != this.n) {
                throw new java.util.ConcurrentModificationException();
            }
        }

        public abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.t >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            int i = this.t;
            this.u = i;
            T b = b(i);
            this.t = com.google.common.collect.CompactHashMap.this.getSuccessor(this.t);
            return b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.collect.CollectPreconditions.e(this.u >= 0);
            this.n++;
            com.google.common.collect.CompactHashMap.this.removeEntry(this.u);
            this.t = com.google.common.collect.CompactHashMap.this.adjustAfterRemove(this.t, this.u);
            this.u = -1;
        }
    }

    public class KeySetView extends java.util.AbstractSet<K> {
        public KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return com.google.common.collect.CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int indexOf = com.google.common.collect.CompactHashMap.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            com.google.common.collect.CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.CompactHashMap.this.size;
        }
    }

    public final class MapEntry extends com.google.common.collect.AbstractMapEntry<K, V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final K n;
        public int t;

        public MapEntry(int i) {
            this.n = (K) com.google.common.collect.CompactHashMap.this.keys[i];
            this.t = i;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.n;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            i();
            int i = this.t;
            if (i == -1) {
                return null;
            }
            return (V) com.google.common.collect.CompactHashMap.this.values[i];
        }

        public final void i() {
            int i = this.t;
            if (i == -1 || i >= com.google.common.collect.CompactHashMap.this.size() || !com.google.common.base.Objects.equal(this.n, com.google.common.collect.CompactHashMap.this.keys[this.t])) {
                this.t = com.google.common.collect.CompactHashMap.this.indexOf(this.n);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            i();
            int i = this.t;
            if (i == -1) {
                com.google.common.collect.CompactHashMap.this.put(this.n, v);
                return null;
            }
            java.lang.Object[] objArr = com.google.common.collect.CompactHashMap.this.values;
            V v2 = (V) objArr[i];
            objArr[i] = v;
            return v2;
        }
    }

    public class ValuesView extends java.util.AbstractCollection<V> {
        public ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.collect.CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return com.google.common.collect.CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return com.google.common.collect.CompactHashMap.this.size;
        }
    }

    public CompactHashMap() {
        init(3, 1.0f);
    }

    public CompactHashMap(int i) {
        this(i, 1.0f);
    }

    public CompactHashMap(int i, float f) {
        init(i, f);
    }

    public static <K, V> com.google.common.collect.CompactHashMap<K, V> create() {
        return new com.google.common.collect.CompactHashMap<>();
    }

    public static <K, V> com.google.common.collect.CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new com.google.common.collect.CompactHashMap<>(i);
    }

    private static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int d = com.google.common.collect.Hashing.d(obj);
        int i = this.table[hashTableMask() & d];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == d && com.google.common.base.Objects.equal(obj, this.keys[i])) {
                return i;
            }
            i = getNext(j);
        }
        return -1;
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
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) == i && com.google.common.base.Objects.equal(obj, this.keys[i2])) {
                V v = (V) this.values[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveLastEntry(i2);
                this.size--;
                this.modCount++;
                return v;
            }
            int next = getNext(this.entries[i2]);
            if (next == -1) {
                return null;
            }
            i3 = i2;
            i2 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V removeEntry(int i) {
        return remove(this.keys[i], getHash(this.entries[i]));
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
        for (int i = 0; i < this.size; i++) {
            objectOutputStream.writeObject(this.keys[i]);
            objectOutputStream.writeObject(this.values[i]);
        }
    }

    public void accessEntry(int i) {
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        java.util.Arrays.fill(this.keys, 0, this.size, (java.lang.Object) null);
        java.util.Arrays.fill(this.values, 0, this.size, (java.lang.Object) null);
        java.util.Arrays.fill(this.table, -1);
        java.util.Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (com.google.common.base.Objects.equal(obj, this.values[i])) {
                return true;
            }
        }
        return false;
    }

    public java.util.Set<java.util.Map.Entry<K, V>> createEntrySet() {
        return new com.google.common.collect.CompactHashMap.EntrySetView();
    }

    public java.util.Set<K> createKeySet() {
        return new com.google.common.collect.CompactHashMap.KeySetView();
    }

    public java.util.Collection<V> createValues() {
        return new com.google.common.collect.CompactHashMap.ValuesView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        java.util.Set<java.util.Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        java.util.Set<java.util.Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    public java.util.Iterator<java.util.Map.Entry<K, V>> entrySetIterator() {
        return new com.google.common.collect.CompactHashMap.AnonymousClass2();
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.values[indexOf];
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
        this.keys = new java.lang.Object[i];
        this.values = new java.lang.Object[i];
        this.entries = newEntries(i);
        this.threshold = java.lang.Math.max(1, (int) (a * f));
    }

    public void insertEntry(int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, int i2) {
        this.entries[i] = (i2 << 32) | 4294967295L;
        this.keys[i] = k;
        this.values[i] = v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        java.util.Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    public java.util.Iterator<K> keySetIterator() {
        return new com.google.common.collect.CompactHashMap.AnonymousClass1();
    }

    public void moveLastEntry(int i) {
        int size = size() - 1;
        if (i >= size) {
            this.keys[i] = null;
            this.values[i] = null;
            this.entries[i] = -1;
            return;
        }
        java.lang.Object[] objArr = this.keys;
        objArr[i] = objArr[size];
        java.lang.Object[] objArr2 = this.values;
        objArr2[i] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
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

    @Override // java.util.AbstractMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        long[] jArr = this.entries;
        java.lang.Object[] objArr = this.keys;
        java.lang.Object[] objArr2 = this.values;
        int d = com.google.common.collect.Hashing.d(k);
        int hashTableMask = hashTableMask() & d;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) == d && com.google.common.base.Objects.equal(k, objArr[i2])) {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    accessEntry(i2);
                    return v2;
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
        insertEntry(i, k, v, d);
        this.size = i3;
        if (i >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return remove(obj, com.google.common.collect.Hashing.d(obj));
    }

    public void resizeEntries(int i) {
        this.keys = java.util.Arrays.copyOf(this.keys, i);
        this.values = java.util.Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = java.util.Arrays.copyOf(jArr, i);
        if (i > length) {
            java.util.Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
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

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Collection<V> values() {
        java.util.Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        java.util.Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    public java.util.Iterator<V> valuesIterator() {
        return new com.google.common.collect.CompactHashMap.AnonymousClass3();
    }
}
