package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
abstract class WrappingScheduledExecutorService extends com.google.common.util.concurrent.WrappingExecutorService implements java.util.concurrent.ScheduledExecutorService {
    public final java.util.concurrent.ScheduledExecutorService t;

    public WrappingScheduledExecutorService(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.t = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final java.util.concurrent.ScheduledFuture<?> schedule(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.t.schedule(a(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> java.util.concurrent.ScheduledFuture<V> schedule(java.util.concurrent.Callable<V> callable, long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.t.schedule(b(callable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final java.util.concurrent.ScheduledFuture<?> scheduleAtFixedRate(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return this.t.scheduleAtFixedRate(a(runnable), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final java.util.concurrent.ScheduledFuture<?> scheduleWithFixedDelay(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return this.t.scheduleWithFixedDelay(a(runnable), j, j2, timeUnit);
    }
}
