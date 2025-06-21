package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class ImmediateFuture<V> implements com.google.common.util.concurrent.ListenableFuture<V> {
    public static final java.util.logging.Logger n = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.ImmediateFuture.class.getName());

    public static final class ImmediateCancelledFuture<V> extends com.google.common.util.concurrent.AbstractFuture.TrustedFuture<V> {
        public ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class ImmediateFailedCheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.ImmediateFuture<V> implements com.google.common.util.concurrent.CheckedFuture<V, X> {
        public final X t;

        public ImmediateFailedCheckedFuture(X x) {
            this.t = x;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet() throws java.lang.Exception {
            throw this.t;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.Exception {
            com.google.common.base.Preconditions.checkNotNull(timeUnit);
            throw this.t;
        }

        @Override // com.google.common.util.concurrent.ImmediateFuture, java.util.concurrent.Future
        public V get() throws java.util.concurrent.ExecutionException {
            throw new java.util.concurrent.ExecutionException(this.t);
        }

        public java.lang.String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.t + "]]";
        }
    }

    public static final class ImmediateFailedFuture<V> extends com.google.common.util.concurrent.AbstractFuture.TrustedFuture<V> {
        public ImmediateFailedFuture(java.lang.Throwable th) {
            setException(th);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class ImmediateSuccessfulCheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.ImmediateFuture<V> implements com.google.common.util.concurrent.CheckedFuture<V, X> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final V t;

        public ImmediateSuccessfulCheckedFuture(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            this.t = v;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet() {
            return this.t;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet(long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkNotNull(timeUnit);
            return this.t;
        }

        @Override // com.google.common.util.concurrent.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.t;
        }

        public java.lang.String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.t + "]]";
        }
    }

    public static class ImmediateSuccessfulFuture<V> extends com.google.common.util.concurrent.ImmediateFuture<V> {
        public static final com.google.common.util.concurrent.ImmediateFuture.ImmediateSuccessfulFuture<java.lang.Object> u = new com.google.common.util.concurrent.ImmediateFuture.ImmediateSuccessfulFuture<>(null);

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final V t;

        public ImmediateSuccessfulFuture(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            this.t = v;
        }

        @Override // com.google.common.util.concurrent.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.t;
        }

        public java.lang.String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.t + "]]";
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(runnable, "Runnable was null.");
        com.google.common.base.Preconditions.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (java.lang.RuntimeException e) {
            n.log(java.util.logging.Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (java.lang.Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws java.util.concurrent.ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException {
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
