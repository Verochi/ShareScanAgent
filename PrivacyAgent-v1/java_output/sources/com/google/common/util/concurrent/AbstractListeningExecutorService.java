package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class AbstractListeningExecutorService extends java.util.concurrent.AbstractExecutorService implements com.google.common.util.concurrent.ListeningExecutorService {
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.lang.Runnable runnable, T t) {
        return com.google.common.util.concurrent.TrustedListenableFutureTask.x(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.util.concurrent.Callable<T> callable) {
        return com.google.common.util.concurrent.TrustedListenableFutureTask.y(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public com.google.common.util.concurrent.ListenableFuture<?> submit(java.lang.Runnable runnable) {
        return (com.google.common.util.concurrent.ListenableFuture) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.lang.Runnable runnable, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (com.google.common.util.concurrent.ListenableFuture) super.submit(runnable, (java.lang.Runnable) t);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.util.concurrent.Callable<T> callable) {
        return (com.google.common.util.concurrent.ListenableFuture) super.submit((java.util.concurrent.Callable) callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ java.util.concurrent.Future submit(java.lang.Runnable runnable, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return submit(runnable, (java.lang.Runnable) obj);
    }
}
