package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class FilteredKeyListMultimap<K, V> extends com.google.common.collect.FilteredKeyMultimap<K, V> implements com.google.common.collect.ListMultimap<K, V> {
    public FilteredKeyListMultimap(com.google.common.collect.ListMultimap<K, V> listMultimap, com.google.common.base.Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
        return get((com.google.common.collect.FilteredKeyListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public java.util.List<V> get(K k) {
        return (java.util.List) super.get((com.google.common.collect.FilteredKeyListMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.FilteredMultimap
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.google.common.collect.ListMultimap<K, V> i() {
        return (com.google.common.collect.ListMultimap) super.i();
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public java.util.List<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (java.util.List) super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.FilteredKeyListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.List<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
        return (java.util.List) super.replaceValues((com.google.common.collect.FilteredKeyListMultimap<K, V>) k, (java.lang.Iterable) iterable);
    }
}
