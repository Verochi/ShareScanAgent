package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface SetMultimap<K, V> extends com.google.common.collect.Multimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    java.util.Map<K, java.util.Collection<V>> asMap();

    @Override // com.google.common.collect.Multimap
    java.util.Set<java.util.Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.collect.Multimap
    java.util.Set<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k);

    @Override // com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.Set<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.Set<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable);
}
