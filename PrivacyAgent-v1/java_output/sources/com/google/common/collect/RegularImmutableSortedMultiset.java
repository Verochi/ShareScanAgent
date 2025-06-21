package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class RegularImmutableSortedMultiset<E> extends com.google.common.collect.ImmutableSortedMultiset<E> {
    private final transient long[] cumulativeCounts;

    @com.google.common.annotations.VisibleForTesting
    final transient com.google.common.collect.RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    static final com.google.common.collect.ImmutableSortedMultiset<java.lang.Comparable> NATURAL_EMPTY_MULTISET = new com.google.common.collect.RegularImmutableSortedMultiset(com.google.common.collect.Ordering.natural());

    public RegularImmutableSortedMultiset(com.google.common.collect.RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i, int i2) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i;
        this.length = i2;
    }

    public RegularImmutableSortedMultiset(java.util.Comparator<? super E> comparator) {
        this.elementSet = com.google.common.collect.ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i) {
        long[] jArr = this.cumulativeCounts;
        int i2 = this.offset;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public com.google.common.collect.ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public com.google.common.collect.Multiset.Entry<E> getEntry(int i) {
        return com.google.common.collect.Multisets.immutableEntry(this.elementSet.asList().get(i), getCount(i));
    }

    public com.google.common.collect.ImmutableSortedMultiset<E> getSubMultiset(int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, this.length);
        return i == i2 ? com.google.common.collect.ImmutableSortedMultiset.emptyMultiset(comparator()) : (i == 0 && i2 == this.length) ? this : new com.google.common.collect.RegularImmutableSortedMultiset(this.elementSet.getSubSet(i, i2), this.cumulativeCounts, this.offset + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> headMultiset(E e, com.google.common.collect.BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e, com.google.common.base.Preconditions.checkNotNull(boundType) == com.google.common.collect.BoundType.CLOSED));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset headMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType) {
        return headMultiset((com.google.common.collect.RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i = this.offset;
        return com.google.common.primitives.Ints.saturatedCast(jArr[this.length + i] - jArr[i]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> tailMultiset(E e, com.google.common.collect.BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e, com.google.common.base.Preconditions.checkNotNull(boundType) == com.google.common.collect.BoundType.CLOSED), this.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset tailMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType) {
        return tailMultiset((com.google.common.collect.RegularImmutableSortedMultiset<E>) obj, boundType);
    }
}
