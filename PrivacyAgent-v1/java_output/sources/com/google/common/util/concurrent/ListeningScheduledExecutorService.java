package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface ListeningScheduledExecutorService extends java.util.concurrent.ScheduledExecutorService, com.google.common.util.concurrent.ListeningExecutorService {
    @Override // java.util.concurrent.ScheduledExecutorService
    com.google.common.util.concurrent.ListenableScheduledFuture<?> schedule(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> com.google.common.util.concurrent.ListenableScheduledFuture<V> schedule(java.util.concurrent.Callable<V> callable, long j, java.util.concurrent.TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    com.google.common.util.concurrent.ListenableScheduledFuture<?> scheduleAtFixedRate(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    com.google.common.util.concurrent.ListenableScheduledFuture<?> scheduleWithFixedDelay(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit);
}
