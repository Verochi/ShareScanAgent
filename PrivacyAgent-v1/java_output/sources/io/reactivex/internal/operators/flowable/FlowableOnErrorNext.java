package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableOnErrorNext<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends T>> t;
    public final boolean u;

    public static final class OnErrorNextSubscriber<T> extends io.reactivex.internal.subscriptions.SubscriptionArbiter implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        final boolean allowFatal;
        boolean done;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends T>> nextSupplier;
        boolean once;
        long produced;

        public OnErrorNextSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends T>> function, boolean z) {
            super(false);
            this.downstream = subscriber;
            this.nextSupplier = function;
            this.allowFatal = z;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.once) {
                if (this.done) {
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.downstream.onError(th);
                    return;
                }
            }
            this.once = true;
            if (this.allowFatal && !(th instanceof java.lang.Exception)) {
                this.downstream.onError(th);
                return;
            }
            try {
                org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.nextSupplier.apply(th), "The nextSupplier returned a null Publisher");
                long j = this.produced;
                if (j != 0) {
                    produced(j);
                }
                publisher.subscribe(this);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (!this.once) {
                this.produced++;
            }
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableOnErrorNext(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends T>> function, boolean z) {
        super(flowable);
        this.t = function;
        this.u = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableOnErrorNext.OnErrorNextSubscriber onErrorNextSubscriber = new io.reactivex.internal.operators.flowable.FlowableOnErrorNext.OnErrorNextSubscriber(subscriber, this.t, this.u);
        subscriber.onSubscribe(onErrorNextSubscriber);
        this.source.subscribe((io.reactivex.FlowableSubscriber) onErrorNextSubscriber);
    }
}
