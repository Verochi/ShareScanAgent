package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableReduce<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.BiFunction<T, T, T> t;

    public static final class ReduceSubscriber<T> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<T> implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final io.reactivex.functions.BiFunction<T, T, T> reducer;
        org.reactivestreams.Subscription upstream;

        public ReduceSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.reducer = biFunction;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
            this.upstream = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            org.reactivestreams.Subscription subscription = this.upstream;
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                return;
            }
            this.upstream = subscriptionHelper;
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            org.reactivestreams.Subscription subscription = this.upstream;
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.upstream = subscriptionHelper;
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.upstream == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
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
    }

    public FlowableReduce(io.reactivex.Flowable<T> flowable, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.t = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableReduce.ReduceSubscriber(subscriber, this.t));
    }
}
