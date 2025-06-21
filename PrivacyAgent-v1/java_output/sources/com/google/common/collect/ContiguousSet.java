package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class ContiguousSet<C extends java.lang.Comparable> extends com.google.common.collect.ImmutableSortedSet<C> {
    final com.google.common.collect.DiscreteDomain<C> domain;

    public ContiguousSet(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        super(com.google.common.collect.Ordering.natural());
        this.domain = discreteDomain;
    }

    @java.lang.Deprecated
    public static <E> com.google.common.collect.ImmutableSortedSet.Builder<E> builder() {
        throw new java.lang.UnsupportedOperationException();
    }

    @com.google.common.annotations.Beta
    public static com.google.common.collect.ContiguousSet<java.lang.Integer> closed(int i, int i2) {
        return create(com.google.common.collect.Range.closed(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)), com.google.common.collect.DiscreteDomain.integers());
    }

    @com.google.common.annotations.Beta
    public static com.google.common.collect.ContiguousSet<java.lang.Long> closed(long j, long j2) {
        return create(com.google.common.collect.Range.closed(java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)), com.google.common.collect.DiscreteDomain.longs());
    }

    @com.google.common.annotations.Beta
    public static com.google.common.collect.ContiguousSet<java.lang.Integer> closedOpen(int i, int i2) {
        return create(com.google.common.collect.Range.closedOpen(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)), com.google.common.collect.DiscreteDomain.integers());
    }

    @com.google.common.annotations.Beta
    public static com.google.common.collect.ContiguousSet<java.lang.Long> closedOpen(long j, long j2) {
        return create(com.google.common.collect.Range.closedOpen(java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)), com.google.common.collect.DiscreteDomain.longs());
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.ContiguousSet<C> create(com.google.common.collect.Range<C> range, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        com.google.common.base.Preconditions.checkNotNull(range);
        com.google.common.base.Preconditions.checkNotNull(discreteDomain);
        try {
            com.google.common.collect.Range<C> intersection = !range.hasLowerBound() ? range.intersection(com.google.common.collect.Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(com.google.common.collect.Range.atMost(discreteDomain.maxValue()));
            }
            return intersection.isEmpty() || com.google.common.collect.Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new com.google.common.collect.EmptyContiguousSet(discreteDomain) : new com.google.common.collect.RegularContiguousSet(intersection, discreteDomain);
        } catch (java.util.NoSuchElementException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ImmutableSortedSet<C> createDescendingSet() {
        return new com.google.common.collect.DescendingImmutableSortedSet(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public com.google.common.collect.ContiguousSet<C> headSet(C c) {
        return headSetImpl((com.google.common.collect.ContiguousSet<C>) com.google.common.base.Preconditions.checkNotNull(c), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ContiguousSet<C> headSet(C c, boolean z) {
        return headSetImpl((com.google.common.collect.ContiguousSet<C>) com.google.common.base.Preconditions.checkNotNull(c), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract com.google.common.collect.ContiguousSet<C> headSetImpl(C c, boolean z);

    public abstract com.google.common.collect.ContiguousSet<C> intersection(com.google.common.collect.ContiguousSet<C> contiguousSet);

    public abstract com.google.common.collect.Range<C> range();

    public abstract com.google.common.collect.Range<C> range(com.google.common.collect.BoundType boundType, com.google.common.collect.BoundType boundType2);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public com.google.common.collect.ContiguousSet<C> subSet(C c, C c2) {
        com.google.common.base.Preconditions.checkNotNull(c);
        com.google.common.base.Preconditions.checkNotNull(c2);
        com.google.common.base.Preconditions.checkArgument(comparator().compare(c, c2) <= 0);
        return subSetImpl((boolean) c, true, (boolean) c2, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ContiguousSet<C> subSet(C c, boolean z, C c2, boolean z2) {
        com.google.common.base.Preconditions.checkNotNull(c);
        com.google.common.base.Preconditions.checkNotNull(c2);
        com.google.common.base.Preconditions.checkArgument(comparator().compare(c, c2) <= 0);
        return subSetImpl((boolean) c, z, (boolean) c2, z2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract com.google.common.collect.ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public com.google.common.collect.ContiguousSet<C> tailSet(C c) {
        return tailSetImpl((com.google.common.collect.ContiguousSet<C>) com.google.common.base.Preconditions.checkNotNull(c), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ContiguousSet<C> tailSet(C c, boolean z) {
        return tailSetImpl((com.google.common.collect.ContiguousSet<C>) com.google.common.base.Preconditions.checkNotNull(c), z);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract com.google.common.collect.ContiguousSet<C> tailSetImpl(C c, boolean z);

    @Override // java.util.AbstractCollection
    public java.lang.String toString() {
        return range().toString();
    }
}
