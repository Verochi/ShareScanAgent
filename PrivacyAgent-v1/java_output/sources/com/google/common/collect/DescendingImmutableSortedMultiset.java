package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class DescendingImmutableSortedMultiset<E> extends com.google.common.collect.ImmutableSortedMultiset<E> {
    private final transient com.google.common.collect.ImmutableSortedMultiset<E> forward;

    public DescendingImmutableSortedMultiset(com.google.common.collect.ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.forward.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public com.google.common.collect.ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> firstEntry() {
        return this.forward.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public com.google.common.collect.Multiset.Entry<E> getEntry(int i) {
        return this.forward.entrySet().asList().reverse().get(i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> headMultiset(E e, com.google.common.collect.BoundType boundType) {
        return this.forward.tailMultiset((com.google.common.collect.ImmutableSortedMultiset<E>) e, boundType).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset headMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType) {
        return headMultiset((com.google.common.collect.DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> lastEntry() {
        return this.forward.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.forward.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> tailMultiset(E e, com.google.common.collect.BoundType boundType) {
        return this.forward.headMultiset((com.google.common.collect.ImmutableSortedMultiset<E>) e, boundType).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset tailMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType) {
        return tailMultiset((com.google.common.collect.DescendingImmutableSortedMultiset<E>) obj, boundType);
    }
}
