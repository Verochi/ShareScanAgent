package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface ListeningExecutorService extends java.util.concurrent.ExecutorService {
    @Override // java.util.concurrent.ExecutorService
    <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) throws java.lang.InterruptedException;

    @Override // java.util.concurrent.ExecutorService
    <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    com.google.common.util.concurrent.ListenableFuture<?> submit(java.lang.Runnable runnable);

    <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.lang.Runnable runnable, T t);

    <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.util.concurrent.Callable<T> callable);
}
