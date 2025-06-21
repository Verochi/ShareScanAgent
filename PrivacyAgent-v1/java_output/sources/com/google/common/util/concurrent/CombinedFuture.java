package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class CombinedFuture<V> extends com.google.common.util.concurrent.AggregateFuture<java.lang.Object, V> {

    public final class AsyncCallableInterruptibleTask extends com.google.common.util.concurrent.CombinedFuture<V>.CombinedFutureInterruptibleTask<com.google.common.util.concurrent.ListenableFuture<V>> {
        private final com.google.common.util.concurrent.AsyncCallable<V> callable;

        public AsyncCallableInterruptibleTask(com.google.common.util.concurrent.AsyncCallable<V> asyncCallable, java.util.concurrent.Executor executor) {
            super(executor);
            this.callable = (com.google.common.util.concurrent.AsyncCallable) com.google.common.base.Preconditions.checkNotNull(asyncCallable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public com.google.common.util.concurrent.ListenableFuture<V> runInterruptibly() throws java.lang.Exception {
            this.thrownByExecute = false;
            return (com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
            com.google.common.util.concurrent.CombinedFuture.this.setFuture(listenableFuture);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public java.lang.String toPendingString() {
            return this.callable.toString();
        }
    }

    public final class CallableInterruptibleTask extends com.google.common.util.concurrent.CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final java.util.concurrent.Callable<V> callable;

        public CallableInterruptibleTask(java.util.concurrent.Callable<V> callable, java.util.concurrent.Executor executor) {
            super(executor);
            this.callable = (java.util.concurrent.Callable) com.google.common.base.Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws java.lang.Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v) {
            com.google.common.util.concurrent.CombinedFuture.this.set(v);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public java.lang.String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends com.google.common.util.concurrent.InterruptibleTask<T> {
        private final java.util.concurrent.Executor listenerExecutor;
        boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(java.util.concurrent.Executor executor) {
            this.listenerExecutor = (java.util.concurrent.Executor) com.google.common.base.Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t, java.lang.Throwable th) {
            if (th == null) {
                setValue(t);
                return;
            }
            if (th instanceof java.util.concurrent.ExecutionException) {
                com.google.common.util.concurrent.CombinedFuture.this.setException(th.getCause());
            } else if (th instanceof java.util.concurrent.CancellationException) {
                com.google.common.util.concurrent.CombinedFuture.this.cancel(false);
            } else {
                com.google.common.util.concurrent.CombinedFuture.this.setException(th);
            }
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (java.util.concurrent.RejectedExecutionException e) {
                if (this.thrownByExecute) {
                    com.google.common.util.concurrent.CombinedFuture.this.setException(e);
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return com.google.common.util.concurrent.CombinedFuture.this.isDone();
        }

        public abstract void setValue(T t);
    }

    public final class CombinedFutureRunningState extends com.google.common.util.concurrent.AggregateFuture<java.lang.Object, V>.RunningState {
        public com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask A;

        public CombinedFutureRunningState(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<?>> immutableCollection, boolean z, com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
            super(immutableCollection, z, false);
            this.A = combinedFutureInterruptibleTask;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void l(boolean z, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void n() {
            com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.A;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.execute();
            } else {
                com.google.common.base.Preconditions.checkState(com.google.common.util.concurrent.CombinedFuture.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void r() {
            com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.A;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.interruptTask();
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void t() {
            super.t();
            this.A = null;
        }
    }

    public CombinedFuture(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<?>> immutableCollection, boolean z, java.util.concurrent.Executor executor, com.google.common.util.concurrent.AsyncCallable<V> asyncCallable) {
        A(new com.google.common.util.concurrent.CombinedFuture.CombinedFutureRunningState(immutableCollection, z, new com.google.common.util.concurrent.CombinedFuture.AsyncCallableInterruptibleTask(asyncCallable, executor)));
    }

    public CombinedFuture(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<?>> immutableCollection, boolean z, java.util.concurrent.Executor executor, java.util.concurrent.Callable<V> callable) {
        A(new com.google.common.util.concurrent.CombinedFuture.CombinedFutureRunningState(immutableCollection, z, new com.google.common.util.concurrent.CombinedFuture.CallableInterruptibleTask(callable, executor)));
    }
}
