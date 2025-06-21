package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class FluentFuture<V> extends com.google.common.util.concurrent.GwtFluentFutureCatchingSpecialization<V> {

    public static abstract class TrustedFuture<V> extends com.google.common.util.concurrent.FluentFuture<V> implements com.google.common.util.concurrent.AbstractFuture.Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final V get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final V get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
            return (V) super.get(j, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    public static <V> com.google.common.util.concurrent.FluentFuture<V> from(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof com.google.common.util.concurrent.FluentFuture ? (com.google.common.util.concurrent.FluentFuture) listenableFuture : new com.google.common.util.concurrent.ForwardingFluentFuture(listenableFuture);
    }

    public final void addCallback(com.google.common.util.concurrent.FutureCallback<? super V> futureCallback, java.util.concurrent.Executor executor) {
        com.google.common.util.concurrent.Futures.addCallback(this, futureCallback, executor);
    }

    @com.google.common.util.concurrent.Partially.GwtIncompatible
    public final <X extends java.lang.Throwable> com.google.common.util.concurrent.FluentFuture<V> catching(java.lang.Class<X> cls, com.google.common.base.Function<? super X, ? extends V> function, java.util.concurrent.Executor executor) {
        return (com.google.common.util.concurrent.FluentFuture) com.google.common.util.concurrent.Futures.catching(this, cls, function, executor);
    }

    @com.google.common.util.concurrent.Partially.GwtIncompatible
    public final <X extends java.lang.Throwable> com.google.common.util.concurrent.FluentFuture<V> catchingAsync(java.lang.Class<X> cls, com.google.common.util.concurrent.AsyncFunction<? super X, ? extends V> asyncFunction, java.util.concurrent.Executor executor) {
        return (com.google.common.util.concurrent.FluentFuture) com.google.common.util.concurrent.Futures.catchingAsync(this, cls, asyncFunction, executor);
    }

    public final <T> com.google.common.util.concurrent.FluentFuture<T> transform(com.google.common.base.Function<? super V, T> function, java.util.concurrent.Executor executor) {
        return (com.google.common.util.concurrent.FluentFuture) com.google.common.util.concurrent.Futures.transform(this, function, executor);
    }

    public final <T> com.google.common.util.concurrent.FluentFuture<T> transformAsync(com.google.common.util.concurrent.AsyncFunction<? super V, T> asyncFunction, java.util.concurrent.Executor executor) {
        return (com.google.common.util.concurrent.FluentFuture) com.google.common.util.concurrent.Futures.transformAsync(this, asyncFunction, executor);
    }

    @com.google.common.annotations.GwtIncompatible
    public final com.google.common.util.concurrent.FluentFuture<V> withTimeout(long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        return (com.google.common.util.concurrent.FluentFuture) com.google.common.util.concurrent.Futures.withTimeout(this, j, timeUnit, scheduledExecutorService);
    }
}
