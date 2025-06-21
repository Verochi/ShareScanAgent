package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class RemovalNotification<K, V> extends java.util.AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final com.google.common.cache.RemovalCause cause;

    private RemovalNotification(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, com.google.common.cache.RemovalCause removalCause) {
        super(k, v);
        this.cause = (com.google.common.cache.RemovalCause) com.google.common.base.Preconditions.checkNotNull(removalCause);
    }

    public static <K, V> com.google.common.cache.RemovalNotification<K, V> create(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, com.google.common.cache.RemovalCause removalCause) {
        return new com.google.common.cache.RemovalNotification<>(k, v, removalCause);
    }

    public com.google.common.cache.RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
