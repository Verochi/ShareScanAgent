package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingListenableFuture<V> extends com.google.common.util.concurrent.ForwardingFuture<V> implements com.google.common.util.concurrent.ListenableFuture<V> {

    public static abstract class SimpleForwardingListenableFuture<V> extends com.google.common.util.concurrent.ForwardingListenableFuture<V> {
        public final com.google.common.util.concurrent.ListenableFuture<V> n;

        public SimpleForwardingListenableFuture(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
            this.n = (com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(listenableFuture);
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final com.google.common.util.concurrent.ListenableFuture<V> delegate() {
            return this.n;
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        delegate().addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    public abstract com.google.common.util.concurrent.ListenableFuture<? extends V> delegate();
}
