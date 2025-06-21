package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractSortedSetMultimap<K, V> extends com.google.common.collect.AbstractSetMultimap<K, V> implements com.google.common.collect.SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public AbstractSortedSetMultimap(java.util.Map<K, java.util.Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public java.util.Map<K, java.util.Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public abstract java.util.SortedSet<V> createCollection();

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public java.util.SortedSet<V> createUnmodifiableEmptyCollection() {
        return (java.util.SortedSet<V>) unmodifiableCollectionSubclass((java.util.Collection) createCollection());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.AbstractSortedSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Set get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.AbstractSortedSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public java.util.SortedSet<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        return (java.util.SortedSet) super.get((com.google.common.collect.AbstractSortedSetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.util.SortedSet<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (java.util.SortedSet) super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.AbstractSortedSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.util.Set replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.AbstractSortedSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.util.SortedSet<V> replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.lang.Iterable<? extends V> iterable) {
        return (java.util.SortedSet) super.replaceValues((com.google.common.collect.AbstractSortedSetMultimap<K, V>) k, (java.lang.Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public <E> java.util.SortedSet<E> unmodifiableCollectionSubclass(java.util.Collection<E> collection) {
        return collection instanceof java.util.NavigableSet ? com.google.common.collect.Sets.unmodifiableNavigableSet((java.util.NavigableSet) collection) : java.util.Collections.unmodifiableSortedSet((java.util.SortedSet) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public java.util.Collection<V> wrapCollection(K k, java.util.Collection<V> collection) {
        return collection instanceof java.util.NavigableSet ? new com.google.common.collect.AbstractMapBasedMultimap.WrappedNavigableSet(k, (java.util.NavigableSet) collection, null) : new com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet(k, (java.util.SortedSet) collection, null);
    }
}
