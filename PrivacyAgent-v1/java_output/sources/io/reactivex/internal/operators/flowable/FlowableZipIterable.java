package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableZipIterable<T, U, V> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, V> {
    public final java.lang.Iterable<U> t;
    public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> u;

    public static final class ZipIterableSubscriber<T, U, V> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super V> n;
        public final java.util.Iterator<U> t;
        public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> u;
        public org.reactivestreams.Subscription v;
        public boolean w;

        public ZipIterableSubscriber(org.reactivestreams.Subscriber<? super V> subscriber, java.util.Iterator<U> it, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.n = subscriber;
            this.t = it;
            this.u = biFunction;
        }

        public void a(java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            this.w = true;
            this.v.cancel();
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.v.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.w) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.w = true;
                this.n.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            try {
                try {
                    this.n.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.apply(t, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.t.hasNext()) {
                            return;
                        }
                        this.w = true;
                        this.v.cancel();
                        this.n.onComplete();
                    } catch (java.lang.Throwable th) {
                        a(th);
                    }
                } catch (java.lang.Throwable th2) {
                    a(th2);
                }
            } catch (java.lang.Throwable th3) {
                a(th3);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.v, subscription)) {
                this.v = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.v.request(j);
        }
    }

    public FlowableZipIterable(io.reactivex.Flowable<T> flowable, java.lang.Iterable<U> iterable, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.t = iterable;
        this.u = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super V> subscriber) {
        try {
            java.util.Iterator it = (java.util.Iterator) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableZipIterable.ZipIterableSubscriber(subscriber, it, this.u));
                } else {
                    io.reactivex.internal.subscriptions.EmptySubscription.complete(subscriber);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
            }
        } catch (java.lang.Throwable th2) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th2, subscriber);
        }
    }
}
