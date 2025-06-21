package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDebounce<T, U> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> t;

    public static final class DebounceSubscriber<T, U> extends java.util.concurrent.atomic.AtomicLong implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> debounceSelector;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> debouncer = new java.util.concurrent.atomic.AtomicReference<>();
        boolean done;
        final org.reactivestreams.Subscriber<? super T> downstream;
        volatile long index;
        org.reactivestreams.Subscription upstream;

        public static final class DebounceInnerSubscriber<T, U> extends io.reactivex.subscribers.DisposableSubscriber<U> {
            public final io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber<T, U> t;
            public final long u;
            public final T v;
            public boolean w;
            public final java.util.concurrent.atomic.AtomicBoolean x = new java.util.concurrent.atomic.AtomicBoolean();

            public DebounceInnerSubscriber(io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.t = debounceSubscriber;
                this.u = j;
                this.v = t;
            }

            public void a() {
                if (this.x.compareAndSet(false, true)) {
                    this.t.emit(this.u, this.v);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (this.w) {
                    return;
                }
                this.w = true;
                a();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(java.lang.Throwable th) {
                if (this.w) {
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                } else {
                    this.w = true;
                    this.t.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U u) {
                if (this.w) {
                    return;
                }
                this.w = true;
                cancel();
                a();
            }
        }

        public DebounceSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> function) {
            this.downstream = subscriber;
            this.debounceSelector = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.debouncer);
        }

        public void emit(long j, T t) {
            if (j == this.index) {
                if (get() != 0) {
                    this.downstream.onNext(t);
                    io.reactivex.internal.util.BackpressureHelper.produced(this, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            io.reactivex.disposables.Disposable disposable = this.debouncer.get();
            if (io.reactivex.internal.disposables.DisposableHelper.isDisposed(disposable)) {
                return;
            }
            io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber.DebounceInnerSubscriber debounceInnerSubscriber = (io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber.DebounceInnerSubscriber) disposable;
            if (debounceInnerSubscriber != null) {
                debounceInnerSubscriber.a();
            }
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            io.reactivex.disposables.Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.debounceSelector.apply(t), "The publisher supplied is null");
                io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber.DebounceInnerSubscriber debounceInnerSubscriber = new io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber.DebounceInnerSubscriber(this, j, t);
                if (defpackage.xv0.a(this.debouncer, disposable, debounceInnerSubscriber)) {
                    publisher.subscribe(debounceInnerSubscriber);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this, j);
            }
        }
    }

    public FlowableDebounce(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> function) {
        super(flowable);
        this.t = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDebounce.DebounceSubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.t));
    }
}
