package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class FilteredMultimapValues<K, V> extends java.util.AbstractCollection<V> {

    @com.google.j2objc.annotations.Weak
    public final com.google.common.collect.FilteredMultimap<K, V> n;

    public FilteredMultimapValues(com.google.common.collect.FilteredMultimap<K, V> filteredMultimap) {
        this.n = (com.google.common.collect.FilteredMultimap) com.google.common.base.Preconditions.checkNotNull(filteredMultimap);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.n.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.n.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<V> iterator() {
        return com.google.common.collect.Maps.Q(this.n.entries().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> j = this.n.j();
        java.util.Iterator<java.util.Map.Entry<K, V>> it = this.n.i().entries().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<K, V> next = it.next();
            if (j.apply(next) && com.google.common.base.Objects.equal(next.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Iterables.removeIf(this.n.i().entries(), com.google.common.base.Predicates.and(this.n.j(), com.google.common.collect.Maps.S(com.google.common.base.Predicates.in(collection))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Iterables.removeIf(this.n.i().entries(), com.google.common.base.Predicates.and(this.n.j(), com.google.common.collect.Maps.S(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.n.size();
    }
}
