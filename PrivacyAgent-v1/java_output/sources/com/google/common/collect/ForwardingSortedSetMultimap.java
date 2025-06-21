package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingSortedSetMultimap<K, V> extends com.google.common.collect.ForwardingSetMultimap<K, V> implements com.google.common.collect.SortedSetMultimap<K, V> {
    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public abstract com.google.common.collect.SortedSetMultimap<K, V> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.ForwardingSortedSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Set get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.ForwardingSortedSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public java.util.SortedSet<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        return delegate().get((com.google.common.collect.SortedSetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public java.util.SortedSet<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return delegate().removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.ForwardingSortedSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Set replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.ForwardingSortedSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
    public java.util.SortedSet<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
        return delegate().replaceValues((com.google.common.collect.SortedSetMultimap<K, V>) k, (java.lang.Iterable) iterable);
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public java.util.Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }
}
