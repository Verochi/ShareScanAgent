package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface SortedSetMultimap<K, V> extends com.google.common.collect.SetMultimap<K, V> {
    @Override // com.google.common.collect.SetMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    java.util.Map<K, java.util.Collection<V>> asMap();

    @Override // com.google.common.collect.SetMultimap, com.google.common.collect.Multimap
    java.util.SortedSet<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k);

    @Override // com.google.common.collect.SetMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.SortedSet<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.collect.SetMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.SortedSet<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable);

    java.util.Comparator<? super V> valueComparator();
}
