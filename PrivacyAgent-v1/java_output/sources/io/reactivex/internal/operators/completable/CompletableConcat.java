package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableConcat extends io.reactivex.Completable {
    public final org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> n;
    public final int t;

    public static final class CompletableConcatSubscriber extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<io.reactivex.CompletableSource>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        int consumed;
        volatile boolean done;
        final io.reactivex.CompletableObserver downstream;
        final int limit;
        final int prefetch;
        io.reactivex.internal.fuseable.SimpleQueue<io.reactivex.CompletableSource> queue;
        int sourceFused;
        org.reactivestreams.Subscription upstream;
        final io.reactivex.internal.operators.completable.CompletableConcat.CompletableConcatSubscriber.ConcatInnerObserver inner = new io.reactivex.internal.operators.completable.CompletableConcat.CompletableConcatSubscriber.ConcatInnerObserver(this);
        final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean();

        public static final class ConcatInnerObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;
            final io.reactivex.internal.operators.completable.CompletableConcat.CompletableConcatSubscriber parent;

            public ConcatInnerObserver(io.reactivex.internal.operators.completable.CompletableConcat.CompletableConcatSubscriber completableConcatSubscriber) {
                this.parent = completableConcatSubscriber;
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

        public CompletableConcatSubscriber(io.reactivex.CompletableObserver completableObserver, int i) {
            this.downstream = completableObserver;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.inner);
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        io.reactivex.CompletableSource poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            if (this.once.compareAndSet(false, true)) {
                                this.downstream.onComplete();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.active = true;
                            poll.subscribe(this.inner);
                            request();
                        }
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        innerError(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerError(java.lang.Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.upstream.cancel();
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.inner.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.inner);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(io.reactivex.CompletableSource completableSource) {
            if (this.sourceFused != 0 || this.queue.offer(completableSource)) {
                drain();
            } else {
                onError(new io.reactivex.exceptions.MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                int i = this.prefetch;
                long j = i == Integer.MAX_VALUE ? Long.MAX_VALUE : i;
                if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                    io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceFused = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceFused = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        subscription.request(j);
                        return;
                    }
                }
                if (this.prefetch == Integer.MAX_VALUE) {
                    this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue(io.reactivex.Flowable.bufferSize());
                } else {
                    this.queue = new io.reactivex.internal.queue.SpscArrayQueue(this.prefetch);
                }
                this.downstream.onSubscribe(this);
                subscription.request(j);
            }
        }

        public void request() {
            if (this.sourceFused != 1) {
                int i = this.consumed + 1;
                if (i != this.limit) {
                    this.consumed = i;
                } else {
                    this.consumed = 0;
                    this.upstream.request(i);
                }
            }
        }
    }

    public CompletableConcat(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher, int i) {
        this.n = publisher;
        this.t = i;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableConcat.CompletableConcatSubscriber(completableObserver, this.t));
    }
}
