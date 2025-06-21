package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingFuture<V> extends com.google.common.collect.ForwardingObject implements java.util.concurrent.Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends com.google.common.util.concurrent.ForwardingFuture<V> {
        public final java.util.concurrent.Future<V> n;

        public SimpleForwardingFuture(java.util.concurrent.Future<V> future) {
            this.n = (java.util.concurrent.Future) com.google.common.base.Preconditions.checkNotNull(future);
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final java.util.concurrent.Future<V> delegate() {
            return this.n;
        }
    }

    public boolean cancel(boolean z) {
        return delegate().cancel(z);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract java.util.concurrent.Future<? extends V> delegate();

    @Override // java.util.concurrent.Future
    public V get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        return delegate().get(j, timeUnit);
    }

    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }
}
