package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
class TrustedListenableFutureTask<V> extends com.google.common.util.concurrent.FluentFuture.TrustedFuture<V> implements java.util.concurrent.RunnableFuture<V> {
    public volatile com.google.common.util.concurrent.InterruptibleTask<?> z;

    public final class TrustedFutureInterruptibleAsyncTask extends com.google.common.util.concurrent.InterruptibleTask<com.google.common.util.concurrent.ListenableFuture<V>> {
        private final com.google.common.util.concurrent.AsyncCallable<V> callable;

        public TrustedFutureInterruptibleAsyncTask(com.google.common.util.concurrent.AsyncCallable<V> asyncCallable) {
            this.callable = (com.google.common.util.concurrent.AsyncCallable) com.google.common.base.Preconditions.checkNotNull(asyncCallable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, java.lang.Throwable th) {
            if (th == null) {
                com.google.common.util.concurrent.TrustedListenableFutureTask.this.setFuture(listenableFuture);
            } else {
                com.google.common.util.concurrent.TrustedListenableFutureTask.this.setException(th);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return com.google.common.util.concurrent.TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public com.google.common.util.concurrent.ListenableFuture<V> runInterruptibly() throws java.lang.Exception {
            return (com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public java.lang.String toPendingString() {
            return this.callable.toString();
        }
    }

    public final class TrustedFutureInterruptibleTask extends com.google.common.util.concurrent.InterruptibleTask<V> {
        private final java.util.concurrent.Callable<V> callable;

        public TrustedFutureInterruptibleTask(java.util.concurrent.Callable<V> callable) {
            this.callable = (java.util.concurrent.Callable) com.google.common.base.Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(V v, java.lang.Throwable th) {
            if (th == null) {
                com.google.common.util.concurrent.TrustedListenableFutureTask.this.set(v);
            } else {
                com.google.common.util.concurrent.TrustedListenableFutureTask.this.setException(th);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return com.google.common.util.concurrent.TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws java.lang.Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public java.lang.String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(com.google.common.util.concurrent.AsyncCallable<V> asyncCallable) {
        this.z = new com.google.common.util.concurrent.TrustedListenableFutureTask.TrustedFutureInterruptibleAsyncTask(asyncCallable);
    }

    public TrustedListenableFutureTask(java.util.concurrent.Callable<V> callable) {
        this.z = new com.google.common.util.concurrent.TrustedListenableFutureTask.TrustedFutureInterruptibleTask(callable);
    }

    public static <V> com.google.common.util.concurrent.TrustedListenableFutureTask<V> w(com.google.common.util.concurrent.AsyncCallable<V> asyncCallable) {
        return new com.google.common.util.concurrent.TrustedListenableFutureTask<>(asyncCallable);
    }

    public static <V> com.google.common.util.concurrent.TrustedListenableFutureTask<V> x(java.lang.Runnable runnable, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new com.google.common.util.concurrent.TrustedListenableFutureTask<>(java.util.concurrent.Executors.callable(runnable, v));
    }

    public static <V> com.google.common.util.concurrent.TrustedListenableFutureTask<V> y(java.util.concurrent.Callable<V> callable) {
        return new com.google.common.util.concurrent.TrustedListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        com.google.common.util.concurrent.InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.z) != null) {
            interruptibleTask.interruptTask();
        }
        this.z = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public java.lang.String pendingToString() {
        com.google.common.util.concurrent.InterruptibleTask<?> interruptibleTask = this.z;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + interruptibleTask + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        com.google.common.util.concurrent.InterruptibleTask<?> interruptibleTask = this.z;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.z = null;
    }
}
