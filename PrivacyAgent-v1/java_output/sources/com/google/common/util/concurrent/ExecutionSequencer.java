package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ExecutionSequencer {
    public final java.util.concurrent.atomic.AtomicReference<com.google.common.util.concurrent.ListenableFuture<java.lang.Object>> a = new java.util.concurrent.atomic.AtomicReference<>(com.google.common.util.concurrent.Futures.immediateFuture(null));

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$1, reason: invalid class name */
    public class AnonymousClass1<T> implements com.google.common.util.concurrent.AsyncCallable<T> {
        public final /* synthetic */ java.util.concurrent.Callable a;

        public AnonymousClass1(java.util.concurrent.Callable callable) {
            this.a = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public com.google.common.util.concurrent.ListenableFuture<T> call() throws java.lang.Exception {
            return com.google.common.util.concurrent.Futures.immediateFuture(this.a.call());
        }

        public java.lang.String toString() {
            return this.a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$2, reason: invalid class name */
    public class AnonymousClass2<T> implements com.google.common.util.concurrent.AsyncCallable<T> {
        public final /* synthetic */ java.util.concurrent.atomic.AtomicReference a;
        public final /* synthetic */ com.google.common.util.concurrent.AsyncCallable b;

        public AnonymousClass2(java.util.concurrent.atomic.AtomicReference atomicReference, com.google.common.util.concurrent.AsyncCallable asyncCallable) {
            this.a = atomicReference;
            this.b = asyncCallable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public com.google.common.util.concurrent.ListenableFuture<T> call() throws java.lang.Exception {
            return !defpackage.xv0.a(this.a, com.google.common.util.concurrent.ExecutionSequencer.RunningState.NOT_RUN, com.google.common.util.concurrent.ExecutionSequencer.RunningState.STARTED) ? com.google.common.util.concurrent.Futures.immediateCancelledFuture() : this.b.call();
        }

        public java.lang.String toString() {
            return this.b.toString();
        }
    }

    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.Executor {
        public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture n;
        public final /* synthetic */ java.util.concurrent.Executor t;

        public AnonymousClass3(com.google.common.util.concurrent.ListenableFuture listenableFuture, java.util.concurrent.Executor executor) {
            this.n = listenableFuture;
            this.t = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            this.n.addListener(runnable, this.t);
        }
    }

    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture n;
        public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture t;
        public final /* synthetic */ java.util.concurrent.atomic.AtomicReference u;
        public final /* synthetic */ com.google.common.util.concurrent.SettableFuture v;
        public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture w;

        public AnonymousClass4(com.google.common.util.concurrent.ListenableFuture listenableFuture, com.google.common.util.concurrent.ListenableFuture listenableFuture2, java.util.concurrent.atomic.AtomicReference atomicReference, com.google.common.util.concurrent.SettableFuture settableFuture, com.google.common.util.concurrent.ListenableFuture listenableFuture3) {
            this.n = listenableFuture;
            this.t = listenableFuture2;
            this.u = atomicReference;
            this.v = settableFuture;
            this.w = listenableFuture3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.n.isDone() || (this.t.isCancelled() && defpackage.xv0.a(this.u, com.google.common.util.concurrent.ExecutionSequencer.RunningState.NOT_RUN, com.google.common.util.concurrent.ExecutionSequencer.RunningState.CANCELLED))) {
                this.v.setFuture(this.w);
            }
        }
    }

    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static com.google.common.util.concurrent.ExecutionSequencer create() {
        return new com.google.common.util.concurrent.ExecutionSequencer();
    }

    public <T> com.google.common.util.concurrent.ListenableFuture<T> submit(java.util.concurrent.Callable<T> callable, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(callable);
        return submitAsync(new com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass1(callable), executor);
    }

    public <T> com.google.common.util.concurrent.ListenableFuture<T> submitAsync(com.google.common.util.concurrent.AsyncCallable<T> asyncCallable, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(asyncCallable);
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference(com.google.common.util.concurrent.ExecutionSequencer.RunningState.NOT_RUN);
        com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass2 anonymousClass2 = new com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass2(atomicReference, asyncCallable);
        com.google.common.util.concurrent.SettableFuture create = com.google.common.util.concurrent.SettableFuture.create();
        com.google.common.util.concurrent.ListenableFuture<java.lang.Object> andSet = this.a.getAndSet(create);
        com.google.common.util.concurrent.ListenableFuture submitAsync = com.google.common.util.concurrent.Futures.submitAsync(anonymousClass2, new com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass3(andSet, executor));
        com.google.common.util.concurrent.ListenableFuture<T> nonCancellationPropagating = com.google.common.util.concurrent.Futures.nonCancellationPropagating(submitAsync);
        com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass4 anonymousClass4 = new com.google.common.util.concurrent.ExecutionSequencer.AnonymousClass4(submitAsync, nonCancellationPropagating, atomicReference, create, andSet);
        nonCancellationPropagating.addListener(anonymousClass4, com.google.common.util.concurrent.MoreExecutors.directExecutor());
        submitAsync.addListener(anonymousClass4, com.google.common.util.concurrent.MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }
}
