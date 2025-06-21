package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableTimeout<T, U, V> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final org.reactivestreams.Publisher<U> t;
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> u;
    public final org.reactivestreams.Publisher<? extends T> v;

    public static final class TimeoutConsumer extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport parent;

        public TimeoutConsumer(long j, io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport timeoutSelectorSupport) {
            this.idx = j;
            this.parent = timeoutSelectorSupport;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            java.lang.Object obj = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            java.lang.Object obj = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (obj == subscriptionHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                lazySet(subscriptionHelper);
                this.parent.onTimeoutError(this.idx, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            org.reactivestreams.Subscription subscription = (org.reactivestreams.Subscription) get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends io.reactivex.internal.subscriptions.SubscriptionArbiter implements io.reactivex.FlowableSubscriber<T>, io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final org.reactivestreams.Subscriber<? super T> downstream;
        org.reactivestreams.Publisher<? extends T> fallback;
        final java.util.concurrent.atomic.AtomicLong index;
        final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<?>> itemTimeoutIndicator;
        final io.reactivex.internal.disposables.SequentialDisposable task;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream;

        public TimeoutFallbackSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<?>> function, org.reactivestreams.Publisher<? extends T> publisher) {
            super(true);
            this.downstream = subscriber;
            this.itemTimeoutIndicator = function;
            this.task = new io.reactivex.internal.disposables.SequentialDisposable();
            this.upstream = new java.util.concurrent.atomic.AtomicReference<>();
            this.fallback = publisher;
            this.index = new java.util.concurrent.atomic.AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.index.compareAndSet(j, j2)) {
                    io.reactivex.disposables.Disposable disposable = this.task.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.consumed++;
                    this.downstream.onNext(t);
                    try {
                        org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer timeoutConsumer = new io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.upstream, subscription)) {
                setSubscription(subscription);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                org.reactivestreams.Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                long j2 = this.consumed;
                if (j2 != 0) {
                    produced(j2);
                }
                publisher.subscribe(new io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.FallbackSubscriber(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long j, java.lang.Throwable th) {
            if (!this.index.compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th);
            }
        }

        public void startFirstTimeout(org.reactivestreams.Publisher<?> publisher) {
            if (publisher != null) {
                io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer timeoutConsumer = new io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }
    }

    public interface TimeoutSelectorSupport extends io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long j, java.lang.Throwable th);
    }

    public static final class TimeoutSubscriber<T> extends java.util.concurrent.atomic.AtomicLong implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription, io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<?>> itemTimeoutIndicator;
        final io.reactivex.internal.disposables.SequentialDisposable task = new io.reactivex.internal.disposables.SequentialDisposable();
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

        public TimeoutSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<?>> function) {
            this.downstream = subscriber;
            this.itemTimeoutIndicator = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.task.dispose();
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    io.reactivex.disposables.Disposable disposable = this.task.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer timeoutConsumer = new io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.upstream.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(new java.util.concurrent.TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long j, java.lang.Throwable th) {
            if (!compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public void startFirstTimeout(org.reactivestreams.Publisher<?> publisher) {
            if (publisher != null) {
                io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer timeoutConsumer = new io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }
    }

    public FlowableTimeout(io.reactivex.Flowable<T> flowable, org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function, org.reactivestreams.Publisher<? extends T> publisher2) {
        super(flowable);
        this.t = publisher;
        this.u = function;
        this.v = publisher2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        if (this.v == null) {
            io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSubscriber timeoutSubscriber = new io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSubscriber(subscriber, this.u);
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startFirstTimeout(this.t);
            this.source.subscribe((io.reactivex.FlowableSubscriber) timeoutSubscriber);
            return;
        }
        io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutFallbackSubscriber timeoutFallbackSubscriber = new io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutFallbackSubscriber(subscriber, this.u, this.v);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startFirstTimeout(this.t);
        this.source.subscribe((io.reactivex.FlowableSubscriber) timeoutFallbackSubscriber);
    }
}
