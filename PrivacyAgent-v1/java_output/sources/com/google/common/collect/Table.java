package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        C getColumnKey();

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        R getRowKey();

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        V getValue();

        int hashCode();
    }

    java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet();

    void clear();

    java.util.Map<R, V> column(C c);

    java.util.Set<C> columnKeySet();

    java.util.Map<C, java.util.Map<R, V>> columnMap();

    boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("R") java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("C") java.lang.Object obj2);

    boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("C") java.lang.Object obj);

    boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("R") java.lang.Object obj);

    boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("V") java.lang.Object obj);

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("R") java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("C") java.lang.Object obj2);

    int hashCode();

    boolean isEmpty();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V put(R r, C c, V v);

    void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("R") java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("C") java.lang.Object obj2);

    java.util.Map<C, V> row(R r);

    java.util.Set<R> rowKeySet();

    java.util.Map<R, java.util.Map<C, V>> rowMap();

    int size();

    java.util.Collection<V> values();
}
