package io.reactivex.internal.operators.mixed;

/* loaded from: classes11.dex */
public final class FlowableConcatMapCompletable<T> extends io.reactivex.Completable {
    public final io.reactivex.Flowable<T> n;
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> t;
    public final io.reactivex.internal.util.ErrorMode u;
    public final int v;

    public static final class ConcatMapCompletableObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        int consumed;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.CompletableObserver downstream;
        final io.reactivex.internal.util.ErrorMode errorMode;
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();
        final io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable.ConcatMapCompletableObserver.ConcatMapInnerObserver inner = new io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable.ConcatMapCompletableObserver.ConcatMapInnerObserver(this);
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> mapper;
        final int prefetch;
        final io.reactivex.internal.fuseable.SimplePlainQueue<T> queue;
        org.reactivestreams.Subscription upstream;

        public static final class ConcatMapInnerObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable.ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable.ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            public void dispose() {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(java.lang.Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, io.reactivex.internal.util.ErrorMode errorMode, int i) {
            this.downstream = completableObserver;
            this.mapper = function;
            this.errorMode = errorMode;
            this.prefetch = i;
            this.queue = new io.reactivex.internal.queue.SpscArrayQueue(i);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    if (this.errorMode == io.reactivex.internal.util.ErrorMode.BOUNDARY && this.errors.get() != null) {
                        this.queue.clear();
                        this.downstream.onError(this.errors.terminate());
                        return;
                    }
                    boolean z = this.done;
                    T poll = this.queue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        java.lang.Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (!z2) {
                        int i = this.prefetch;
                        int i2 = i - (i >> 1);
                        int i3 = this.consumed + 1;
                        if (i3 == i2) {
                            this.consumed = 0;
                            this.upstream.request(i2);
                        } else {
                            this.consumed = i3;
                        }
                        try {
                            io.reactivex.CompletableSource completableSource = (io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                            this.active = true;
                            completableSource.subscribe(this.inner);
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            this.queue.clear();
                            this.upstream.cancel();
                            this.errors.addThrowable(th);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (this.errorMode != io.reactivex.internal.util.ErrorMode.IMMEDIATE) {
                this.active = false;
                drain();
                return;
            }
            this.upstream.cancel();
            java.lang.Throwable terminate = this.errors.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (this.errorMode != io.reactivex.internal.util.ErrorMode.IMMEDIATE) {
                this.done = true;
                drain();
                return;
            }
            this.inner.dispose();
            java.lang.Throwable terminate = this.errors.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                drain();
            } else {
                this.upstream.cancel();
                onError(new io.reactivex.exceptions.MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }
    }

    public FlowableConcatMapCompletable(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, io.reactivex.internal.util.ErrorMode errorMode, int i) {
        this.n = flowable;
        this.t = function;
        this.u = errorMode;
        this.v = i;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable.ConcatMapCompletableObserver(completableObserver, this.t, this.u, this.v));
    }
}
