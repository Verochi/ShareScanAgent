package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class SettableFuture<V> extends com.google.common.util.concurrent.AbstractFuture.TrustedFuture<V> {
    public static <V> com.google.common.util.concurrent.SettableFuture<V> create() {
        return new com.google.common.util.concurrent.SettableFuture<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean set(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return super.set(v);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean setException(java.lang.Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public boolean setFuture(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
