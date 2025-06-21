package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ForwardingListeningExecutorService extends com.google.common.util.concurrent.ForwardingExecutorService implements com.google.common.util.concurrent.ListeningExecutorService {
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, com.google.common.collect.ForwardingObject
    public abstract com.google.common.util.concurrent.ListeningExecutorService delegate();

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public com.google.common.util.concurrent.ListenableFuture<?> submit(java.lang.Runnable runnable) {
        return delegate().submit(runnable);
    }

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.lang.Runnable runnable, T t) {
        return delegate().submit(runnable, (java.lang.Runnable) t);
    }

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.util.concurrent.Callable<T> callable) {
        return delegate().submit((java.util.concurrent.Callable) callable);
    }

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ java.util.concurrent.Future submit(java.lang.Runnable runnable, java.lang.Object obj) {
        return submit(runnable, (java.lang.Runnable) obj);
    }
}
