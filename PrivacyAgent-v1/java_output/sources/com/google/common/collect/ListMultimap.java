package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface ListMultimap<K, V> extends com.google.common.collect.Multimap<K, V> {
    java.util.Map<K, java.util.Collection<V>> asMap();

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.collect.Multimap
    java.util.List<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k);

    @Override // com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.List<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.List<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable);
}
