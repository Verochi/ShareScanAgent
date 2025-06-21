package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Futures extends com.google.common.util.concurrent.GwtFuturesCatchingSpecialization {

    /* renamed from: com.google.common.util.concurrent.Futures$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.util.concurrent.Future n;

        public AnonymousClass1(java.util.concurrent.Future future) {
            this.n = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.cancel(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [O] */
    /* renamed from: com.google.common.util.concurrent.Futures$2, reason: invalid class name */
    public static class AnonymousClass2<O> implements java.util.concurrent.Future<O> {
        public final /* synthetic */ java.util.concurrent.Future n;
        public final /* synthetic */ com.google.common.base.Function t;

        public AnonymousClass2(java.util.concurrent.Future future, com.google.common.base.Function function) {
            this.n = future;
            this.t = function;
        }

        public final O a(I i) throws java.util.concurrent.ExecutionException {
            try {
                return (O) this.t.apply(i);
            } catch (java.lang.Throwable th) {
                throw new java.util.concurrent.ExecutionException(th);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.n.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public O get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
            return a(this.n.get());
        }

        @Override // java.util.concurrent.Future
        public O get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
            return a(this.n.get(j, timeUnit));
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.n.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.n.isDone();
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.google.common.util.concurrent.Futures.InCompletionOrderState n;
        public final /* synthetic */ com.google.common.collect.ImmutableList t;
        public final /* synthetic */ int u;

        public AnonymousClass3(com.google.common.util.concurrent.Futures.InCompletionOrderState inCompletionOrderState, com.google.common.collect.ImmutableList immutableList, int i) {
            this.n = inCompletionOrderState;
            this.t = immutableList;
            this.u = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.f(this.t, this.u);
        }
    }

    public static final class CallbackListener<V> implements java.lang.Runnable {
        public final java.util.concurrent.Future<V> n;
        public final com.google.common.util.concurrent.FutureCallback<? super V> t;

        public CallbackListener(java.util.concurrent.Future<V> future, com.google.common.util.concurrent.FutureCallback<? super V> futureCallback) {
            this.n = future;
            this.t = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.t.onSuccess(com.google.common.util.concurrent.Futures.getDone(this.n));
            } catch (java.lang.Error e) {
                e = e;
                this.t.onFailure(e);
            } catch (java.lang.RuntimeException e2) {
                e = e2;
                this.t.onFailure(e);
            } catch (java.util.concurrent.ExecutionException e3) {
                this.t.onFailure(e3.getCause());
            }
        }

        public java.lang.String toString() {
            return com.google.common.base.MoreObjects.toStringHelper(this).addValue(this.t).toString();
        }
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtCompatible
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static final class FutureCombiner<V> {
        public final boolean a;
        public final com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<? extends V>> b;

        /* renamed from: com.google.common.util.concurrent.Futures$FutureCombiner$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.Void> {
            public final /* synthetic */ java.lang.Runnable n;

            public AnonymousClass1(java.lang.Runnable runnable) {
                this.n = runnable;
            }

            @Override // java.util.concurrent.Callable
            public java.lang.Void call() throws java.lang.Exception {
                this.n.run();
                return null;
            }
        }

        public FutureCombiner(boolean z, com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<? extends V>> immutableList) {
            this.a = z;
            this.b = immutableList;
        }

        public /* synthetic */ FutureCombiner(boolean z, com.google.common.collect.ImmutableList immutableList, com.google.common.util.concurrent.Futures.AnonymousClass1 anonymousClass1) {
            this(z, immutableList);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <C> com.google.common.util.concurrent.ListenableFuture<C> call(java.util.concurrent.Callable<C> callable, java.util.concurrent.Executor executor) {
            return new com.google.common.util.concurrent.CombinedFuture(this.b, this.a, executor, callable);
        }

        public <C> com.google.common.util.concurrent.ListenableFuture<C> callAsync(com.google.common.util.concurrent.AsyncCallable<C> asyncCallable, java.util.concurrent.Executor executor) {
            return new com.google.common.util.concurrent.CombinedFuture(this.b, this.a, executor, asyncCallable);
        }

        public com.google.common.util.concurrent.ListenableFuture<?> run(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
            return call(new com.google.common.util.concurrent.Futures.FutureCombiner.AnonymousClass1(runnable), executor);
        }
    }

    public static final class InCompletionOrderFuture<T> extends com.google.common.util.concurrent.AbstractFuture<T> {
        public com.google.common.util.concurrent.Futures.InCompletionOrderState<T> z;

        public InCompletionOrderFuture(com.google.common.util.concurrent.Futures.InCompletionOrderState<T> inCompletionOrderState) {
            this.z = inCompletionOrderState;
        }

        public /* synthetic */ InCompletionOrderFuture(com.google.common.util.concurrent.Futures.InCompletionOrderState inCompletionOrderState, com.google.common.util.concurrent.Futures.AnonymousClass1 anonymousClass1) {
            this(inCompletionOrderState);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.z = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            com.google.common.util.concurrent.Futures.InCompletionOrderState<T> inCompletionOrderState = this.z;
            if (!super.cancel(z)) {
                return false;
            }
            inCompletionOrderState.g(z);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public java.lang.String pendingToString() {
            com.google.common.util.concurrent.Futures.InCompletionOrderState<T> inCompletionOrderState = this.z;
            if (inCompletionOrderState == null) {
                return null;
            }
            return "inputCount=[" + inCompletionOrderState.d.length + "], remaining=[" + inCompletionOrderState.c.get() + "]";
        }
    }

    public static final class InCompletionOrderState<T> {
        public boolean a;
        public boolean b;
        public final java.util.concurrent.atomic.AtomicInteger c;
        public final com.google.common.util.concurrent.ListenableFuture<? extends T>[] d;
        public volatile int e;

        public InCompletionOrderState(com.google.common.util.concurrent.ListenableFuture<? extends T>[] listenableFutureArr) {
            this.a = false;
            this.b = true;
            this.e = 0;
            this.d = listenableFutureArr;
            this.c = new java.util.concurrent.atomic.AtomicInteger(listenableFutureArr.length);
        }

        public /* synthetic */ InCompletionOrderState(com.google.common.util.concurrent.ListenableFuture[] listenableFutureArr, com.google.common.util.concurrent.Futures.AnonymousClass1 anonymousClass1) {
            this(listenableFutureArr);
        }

        public final void e() {
            if (this.c.decrementAndGet() == 0 && this.a) {
                for (com.google.common.util.concurrent.ListenableFuture<? extends T> listenableFuture : this.d) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.b);
                    }
                }
            }
        }

        public final void f(com.google.common.collect.ImmutableList<com.google.common.util.concurrent.AbstractFuture<T>> immutableList, int i) {
            com.google.common.util.concurrent.ListenableFuture<? extends T>[] listenableFutureArr = this.d;
            com.google.common.util.concurrent.ListenableFuture<? extends T> listenableFuture = listenableFutureArr[i];
            listenableFutureArr[i] = null;
            for (int i2 = this.e; i2 < immutableList.size(); i2++) {
                if (immutableList.get(i2).setFuture(listenableFuture)) {
                    e();
                    this.e = i2 + 1;
                    return;
                }
            }
            this.e = immutableList.size();
        }

        public final void g(boolean z) {
            this.a = true;
            if (!z) {
                this.b = false;
            }
            e();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class MappingCheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.AbstractCheckedFuture<V, X> {
        public final com.google.common.base.Function<? super java.lang.Exception, X> t;

        public MappingCheckedFuture(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, com.google.common.base.Function<? super java.lang.Exception, X> function) {
            super(listenableFuture);
            this.t = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.util.concurrent.AbstractCheckedFuture
        public X mapException(java.lang.Exception exc) {
            return this.t.apply(exc);
        }
    }

    public static final class NonCancellationPropagatingFuture<V> extends com.google.common.util.concurrent.AbstractFuture.TrustedFuture<V> implements java.lang.Runnable {
        public com.google.common.util.concurrent.ListenableFuture<V> z;

        public NonCancellationPropagatingFuture(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
            this.z = listenableFuture;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.z = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public java.lang.String pendingToString() {
            com.google.common.util.concurrent.ListenableFuture<V> listenableFuture = this.z;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.common.util.concurrent.ListenableFuture<V> listenableFuture = this.z;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    public static void a(java.lang.Throwable th) {
        if (!(th instanceof java.lang.Error)) {
            throw new com.google.common.util.concurrent.UncheckedExecutionException(th);
        }
        throw new com.google.common.util.concurrent.ExecutionError((java.lang.Error) th);
    }

    public static <V> void addCallback(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, com.google.common.util.concurrent.FutureCallback<? super V> futureCallback, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new com.google.common.util.concurrent.Futures.CallbackListener(listenableFuture, futureCallback), executor);
    }

    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.ListenableFuture<java.util.List<V>> allAsList(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> iterable) {
        return new com.google.common.util.concurrent.CollectionFuture.ListFuture(com.google.common.collect.ImmutableList.copyOf(iterable), true);
    }

    @java.lang.SafeVarargs
    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.ListenableFuture<java.util.List<V>> allAsList(com.google.common.util.concurrent.ListenableFuture<? extends V>... listenableFutureArr) {
        return new com.google.common.util.concurrent.CollectionFuture.ListFuture(com.google.common.collect.ImmutableList.copyOf(listenableFutureArr), true);
    }

    @com.google.common.util.concurrent.Partially.GwtIncompatible
    @com.google.common.annotations.Beta
    public static <V, X extends java.lang.Throwable> com.google.common.util.concurrent.ListenableFuture<V> catching(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, com.google.common.base.Function<? super X, ? extends V> function, java.util.concurrent.Executor executor) {
        return com.google.common.util.concurrent.AbstractCatchingFuture.w(listenableFuture, cls, function, executor);
    }

    @com.google.common.util.concurrent.Partially.GwtIncompatible
    @com.google.common.annotations.Beta
    public static <V, X extends java.lang.Throwable> com.google.common.util.concurrent.ListenableFuture<V> catchingAsync(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, com.google.common.util.concurrent.AsyncFunction<? super X, ? extends V> asyncFunction, java.util.concurrent.Executor executor) {
        return com.google.common.util.concurrent.AbstractCatchingFuture.x(listenableFuture, cls, asyncFunction, executor);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V, X extends java.lang.Exception> V getChecked(java.util.concurrent.Future<V> future, java.lang.Class<X> cls) throws java.lang.Exception {
        return (V) com.google.common.util.concurrent.FuturesGetChecked.d(future, cls);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V, X extends java.lang.Exception> V getChecked(java.util.concurrent.Future<V> future, java.lang.Class<X> cls, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.Exception {
        return (V) com.google.common.util.concurrent.FuturesGetChecked.e(future, cls, j, timeUnit);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V> V getDone(java.util.concurrent.Future<V> future) throws java.util.concurrent.ExecutionException {
        com.google.common.base.Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(future);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V> V getUnchecked(java.util.concurrent.Future<V> future) {
        com.google.common.base.Preconditions.checkNotNull(future);
        try {
            return (V) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(future);
        } catch (java.util.concurrent.ExecutionException e) {
            a(e.getCause());
            throw new java.lang.AssertionError();
        }
    }

    public static <V> com.google.common.util.concurrent.ListenableFuture<V> immediateCancelledFuture() {
        return new com.google.common.util.concurrent.ImmediateFuture.ImmediateCancelledFuture();
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static <V, X extends java.lang.Exception> com.google.common.util.concurrent.CheckedFuture<V, X> immediateCheckedFuture(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new com.google.common.util.concurrent.ImmediateFuture.ImmediateSuccessfulCheckedFuture(v);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static <V, X extends java.lang.Exception> com.google.common.util.concurrent.CheckedFuture<V, X> immediateFailedCheckedFuture(X x) {
        com.google.common.base.Preconditions.checkNotNull(x);
        return new com.google.common.util.concurrent.ImmediateFuture.ImmediateFailedCheckedFuture(x);
    }

    public static <V> com.google.common.util.concurrent.ListenableFuture<V> immediateFailedFuture(java.lang.Throwable th) {
        com.google.common.base.Preconditions.checkNotNull(th);
        return new com.google.common.util.concurrent.ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static <V> com.google.common.util.concurrent.ListenableFuture<V> immediateFuture(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return v == null ? com.google.common.util.concurrent.ImmediateFuture.ImmediateSuccessfulFuture.u : new com.google.common.util.concurrent.ImmediateFuture.ImmediateSuccessfulFuture(v);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<T>> inCompletionOrder(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>> iterable) {
        java.util.Collection copyOf = iterable instanceof java.util.Collection ? (java.util.Collection) iterable : com.google.common.collect.ImmutableList.copyOf(iterable);
        com.google.common.util.concurrent.ListenableFuture[] listenableFutureArr = (com.google.common.util.concurrent.ListenableFuture[]) copyOf.toArray(new com.google.common.util.concurrent.ListenableFuture[copyOf.size()]);
        com.google.common.util.concurrent.Futures.InCompletionOrderState inCompletionOrderState = new com.google.common.util.concurrent.Futures.InCompletionOrderState(listenableFutureArr, null);
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        for (int i = 0; i < listenableFutureArr.length; i++) {
            builder.add((com.google.common.collect.ImmutableList.Builder) new com.google.common.util.concurrent.Futures.InCompletionOrderFuture(inCompletionOrderState, null));
        }
        com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<T>> build = builder.build();
        for (int i2 = 0; i2 < listenableFutureArr.length; i2++) {
            listenableFutureArr[i2].addListener(new com.google.common.util.concurrent.Futures.AnonymousClass3(inCompletionOrderState, build, i2), com.google.common.util.concurrent.MoreExecutors.directExecutor());
        }
        return build;
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <I, O> java.util.concurrent.Future<O> lazyTransform(java.util.concurrent.Future<I> future, com.google.common.base.Function<? super I, ? extends O> function) {
        com.google.common.base.Preconditions.checkNotNull(future);
        com.google.common.base.Preconditions.checkNotNull(function);
        return new com.google.common.util.concurrent.Futures.AnonymousClass2(future, function);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static <V, X extends java.lang.Exception> com.google.common.util.concurrent.CheckedFuture<V, X> makeChecked(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, com.google.common.base.Function<? super java.lang.Exception, X> function) {
        return new com.google.common.util.concurrent.Futures.MappingCheckedFuture((com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(listenableFuture), function);
    }

    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.ListenableFuture<V> nonCancellationPropagating(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        com.google.common.util.concurrent.Futures.NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new com.google.common.util.concurrent.Futures.NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.addListener(nonCancellationPropagatingFuture, com.google.common.util.concurrent.MoreExecutors.directExecutor());
        return nonCancellationPropagatingFuture;
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <O> com.google.common.util.concurrent.ListenableFuture<O> scheduleAsync(com.google.common.util.concurrent.AsyncCallable<O> asyncCallable, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        com.google.common.util.concurrent.TrustedListenableFutureTask w = com.google.common.util.concurrent.TrustedListenableFutureTask.w(asyncCallable);
        w.addListener(new com.google.common.util.concurrent.Futures.AnonymousClass1(scheduledExecutorService.schedule(w, j, timeUnit)), com.google.common.util.concurrent.MoreExecutors.directExecutor());
        return w;
    }

    @com.google.common.annotations.Beta
    public static <O> com.google.common.util.concurrent.ListenableFuture<O> submitAsync(com.google.common.util.concurrent.AsyncCallable<O> asyncCallable, java.util.concurrent.Executor executor) {
        com.google.common.util.concurrent.TrustedListenableFutureTask w = com.google.common.util.concurrent.TrustedListenableFutureTask.w(asyncCallable);
        executor.execute(w);
        return w;
    }

    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.ListenableFuture<java.util.List<V>> successfulAsList(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> iterable) {
        return new com.google.common.util.concurrent.CollectionFuture.ListFuture(com.google.common.collect.ImmutableList.copyOf(iterable), false);
    }

    @java.lang.SafeVarargs
    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.ListenableFuture<java.util.List<V>> successfulAsList(com.google.common.util.concurrent.ListenableFuture<? extends V>... listenableFutureArr) {
        return new com.google.common.util.concurrent.CollectionFuture.ListFuture(com.google.common.collect.ImmutableList.copyOf(listenableFutureArr), false);
    }

    @com.google.common.annotations.Beta
    public static <I, O> com.google.common.util.concurrent.ListenableFuture<O> transform(com.google.common.util.concurrent.ListenableFuture<I> listenableFuture, com.google.common.base.Function<? super I, ? extends O> function, java.util.concurrent.Executor executor) {
        return com.google.common.util.concurrent.AbstractTransformFuture.w(listenableFuture, function, executor);
    }

    @com.google.common.annotations.Beta
    public static <I, O> com.google.common.util.concurrent.ListenableFuture<O> transformAsync(com.google.common.util.concurrent.ListenableFuture<I> listenableFuture, com.google.common.util.concurrent.AsyncFunction<? super I, ? extends O> asyncFunction, java.util.concurrent.Executor executor) {
        return com.google.common.util.concurrent.AbstractTransformFuture.x(listenableFuture, asyncFunction, executor);
    }

    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.Futures.FutureCombiner<V> whenAllComplete(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> iterable) {
        return new com.google.common.util.concurrent.Futures.FutureCombiner<>(false, com.google.common.collect.ImmutableList.copyOf(iterable), null);
    }

    @java.lang.SafeVarargs
    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.Futures.FutureCombiner<V> whenAllComplete(com.google.common.util.concurrent.ListenableFuture<? extends V>... listenableFutureArr) {
        return new com.google.common.util.concurrent.Futures.FutureCombiner<>(false, com.google.common.collect.ImmutableList.copyOf(listenableFutureArr), null);
    }

    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.Futures.FutureCombiner<V> whenAllSucceed(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> iterable) {
        return new com.google.common.util.concurrent.Futures.FutureCombiner<>(true, com.google.common.collect.ImmutableList.copyOf(iterable), null);
    }

    @java.lang.SafeVarargs
    @com.google.common.annotations.Beta
    public static <V> com.google.common.util.concurrent.Futures.FutureCombiner<V> whenAllSucceed(com.google.common.util.concurrent.ListenableFuture<? extends V>... listenableFutureArr) {
        return new com.google.common.util.concurrent.Futures.FutureCombiner<>(true, com.google.common.collect.ImmutableList.copyOf(listenableFutureArr), null);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <V> com.google.common.util.concurrent.ListenableFuture<V> withTimeout(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : com.google.common.util.concurrent.TimeoutFuture.z(listenableFuture, j, timeUnit, scheduledExecutorService);
    }
}
