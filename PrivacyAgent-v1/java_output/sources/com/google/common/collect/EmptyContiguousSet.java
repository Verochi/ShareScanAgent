package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class EmptyContiguousSet<C extends java.lang.Comparable> extends com.google.common.collect.ContiguousSet<C> {

    @com.google.common.annotations.GwtIncompatible
    public static final class SerializedForm<C extends java.lang.Comparable> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.DiscreteDomain<C> domain;

        private SerializedForm(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            this.domain = discreteDomain;
        }

        public /* synthetic */ SerializedForm(com.google.common.collect.DiscreteDomain discreteDomain, com.google.common.collect.EmptyContiguousSet.AnonymousClass1 anonymousClass1) {
            this(discreteDomain);
        }

        private java.lang.Object readResolve() {
            return new com.google.common.collect.EmptyContiguousSet(this.domain);
        }
    }

    public EmptyContiguousSet(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public com.google.common.collect.ImmutableList<C> asList() {
        return com.google.common.collect.ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ImmutableSortedSet<C> createDescendingSet() {
        return com.google.common.collect.ImmutableSortedSet.emptySet(com.google.common.collect.Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.UnmodifiableIterator<C> descendingIterator() {
        return com.google.common.collect.Iterators.f();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof java.util.Set) {
            return ((java.util.Set) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        throw new java.util.NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public com.google.common.collect.ContiguousSet<C> headSetImpl(C c, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @com.google.common.annotations.GwtIncompatible
    public int indexOf(java.lang.Object obj) {
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public com.google.common.collect.ContiguousSet<C> intersection(com.google.common.collect.ContiguousSet<C> contiguousSet) {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSet
    @com.google.common.annotations.GwtIncompatible
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<C> iterator() {
        return com.google.common.collect.Iterators.f();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        throw new java.util.NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet
    public com.google.common.collect.Range<C> range() {
        throw new java.util.NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet
    public com.google.common.collect.Range<C> range(com.google.common.collect.BoundType boundType, com.google.common.collect.BoundType boundType2) {
        throw new java.util.NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public com.google.common.collect.ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public com.google.common.collect.ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return this;
    }

    @Override // com.google.common.collect.ContiguousSet, java.util.AbstractCollection
    public java.lang.String toString() {
        return "[]";
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.EmptyContiguousSet.SerializedForm(this.domain, null);
    }
}
