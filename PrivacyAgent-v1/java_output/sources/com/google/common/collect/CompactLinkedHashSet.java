package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class CompactLinkedHashSet<E> extends com.google.common.collect.CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient int[] predecessor;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public CompactLinkedHashSet(int i) {
        super(i);
    }

    public static <E> com.google.common.collect.CompactLinkedHashSet<E> create() {
        return new com.google.common.collect.CompactLinkedHashSet<>();
    }

    public static <E> com.google.common.collect.CompactLinkedHashSet<E> create(java.util.Collection<? extends E> collection) {
        com.google.common.collect.CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public static <E> com.google.common.collect.CompactLinkedHashSet<E> create(E... eArr) {
        com.google.common.collect.CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        java.util.Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> com.google.common.collect.CompactLinkedHashSet<E> createWithExpectedSize(int i) {
        return new com.google.common.collect.CompactLinkedHashSet<>(i);
    }

    private void succeeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            this.successor[i] = i2;
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            this.predecessor[i2] = i;
        }
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int i, int i2) {
        return i == size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
        java.util.Arrays.fill(this.predecessor, -1);
        java.util.Arrays.fill(this.successor, -1);
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int i) {
        return this.successor[i];
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int i, float f) {
        super.init(i, f);
        int[] iArr = new int[i];
        this.predecessor = iArr;
        this.successor = new int[i];
        java.util.Arrays.fill(iArr, -1);
        java.util.Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i, E e, int i2) {
        super.insertEntry(i, e, i2);
        succeeds(this.lastEntry, i);
        succeeds(i, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveEntry(int i) {
        int size = size() - 1;
        super.moveEntry(i);
        succeeds(this.predecessor[i], this.successor[i]);
        if (size != i) {
            succeeds(this.predecessor[size], i);
            succeeds(i, this.successor[size]);
        }
        this.predecessor[size] = -1;
        this.successor[size] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        int[] iArr = this.predecessor;
        int length = iArr.length;
        this.predecessor = java.util.Arrays.copyOf(iArr, i);
        this.successor = java.util.Arrays.copyOf(this.successor, i);
        if (length < i) {
            java.util.Arrays.fill(this.predecessor, length, i, -1);
            java.util.Arrays.fill(this.successor, length, i, -1);
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public java.lang.Object[] toArray() {
        return com.google.common.collect.ObjectArrays.e(this);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) com.google.common.collect.ObjectArrays.f(this, tArr);
    }
}
