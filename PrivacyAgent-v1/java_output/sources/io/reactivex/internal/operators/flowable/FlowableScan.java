package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableScan<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.BiFunction<T, T, T> t;

    public static final class ScanSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public final io.reactivex.functions.BiFunction<T, T, T> t;
        public org.reactivestreams.Subscription u;
        public T v;
        public boolean w;

        public ScanSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            this.n = subscriber;
            this.t = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.u.cancel();
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

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            org.reactivestreams.Subscriber<? super T> subscriber = this.n;
            T t2 = this.v;
            if (t2 == null) {
                this.v = t;
                subscriber.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t2, t), "The value returned by the accumulator is null");
                this.v = r4;
                subscriber.onNext(r4);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.u.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.u.request(j);
        }
    }

    public FlowableScan(io.reactivex.Flowable<T> flowable, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.t = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableScan.ScanSubscriber(subscriber, this.t));
    }
}
