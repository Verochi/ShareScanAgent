package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class FilteredKeySetMultimap<K, V> extends com.google.common.collect.FilteredKeyMultimap<K, V> implements com.google.common.collect.FilteredSetMultimap<K, V> {

    public class EntrySet extends com.google.common.collect.FilteredKeyMultimap<K, V>.Entries implements java.util.Set<java.util.Map.Entry<K, V>> {
        public EntrySet() {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return com.google.common.collect.Sets.b(this);
        }
    }

    public FilteredKeySetMultimap(com.google.common.collect.SetMultimap<K, V> setMultimap, com.google.common.base.Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Set<java.util.Map.Entry<K, V>> entries() {
        return (java.util.Set) super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
        return get((com.google.common.collect.FilteredKeySetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public java.util.Set<V> get(K k) {
        return (java.util.Set) super.get((com.google.common.collect.FilteredKeySetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.FilteredMultimap
    public com.google.common.collect.SetMultimap<K, V> i() {
        return (com.google.common.collect.SetMultimap) this.n;
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.AbstractMultimap
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public java.util.Set<java.util.Map.Entry<K, V>> createEntries() {
        return new com.google.common.collect.FilteredKeySetMultimap.EntrySet();
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public java.util.Set<V> removeAll(java.lang.Object obj) {
        return (java.util.Set) super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.FilteredKeySetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Set<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
        return (java.util.Set) super.replaceValues((com.google.common.collect.FilteredKeySetMultimap<K, V>) k, (java.lang.Iterable) iterable);
    }
}
