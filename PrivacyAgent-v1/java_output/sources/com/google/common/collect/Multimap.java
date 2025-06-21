package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface Multimap<K, V> {
    java.util.Map<K, java.util.Collection<V>> asMap();

    void clear();

    boolean containsEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("K") java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("V") java.lang.Object obj2);

    boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("K") java.lang.Object obj);

    boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("V") java.lang.Object obj);

    java.util.Collection<java.util.Map.Entry<K, V>> entries();

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    java.util.Collection<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k);

    int hashCode();

    boolean isEmpty();

    java.util.Set<K> keySet();

    com.google.common.collect.Multiset<K> keys();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean putAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.lang.Iterable<? extends V> iterable);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("K") java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("V") java.lang.Object obj2);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.Collection<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("K") java.lang.Object obj);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.util.Collection<V> replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.lang.Iterable<? extends V> iterable);

    int size();

    java.util.Collection<V> values();
}
