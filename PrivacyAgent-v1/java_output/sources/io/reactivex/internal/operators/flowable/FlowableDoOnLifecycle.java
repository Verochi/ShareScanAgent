package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDoOnLifecycle<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> t;
    public final io.reactivex.functions.LongConsumer u;
    public final io.reactivex.functions.Action v;

    public static final class SubscriptionLambdaSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public final io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> t;
        public final io.reactivex.functions.LongConsumer u;
        public final io.reactivex.functions.Action v;
        public org.reactivestreams.Subscription w;

        public SubscriptionLambdaSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> consumer, io.reactivex.functions.LongConsumer longConsumer, io.reactivex.functions.Action action) {
            this.n = subscriber;
            this.t = consumer;
            this.v = action;
            this.u = longConsumer;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            org.reactivestreams.Subscription subscription = this.w;
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.w = subscriptionHelper;
                try {
                    this.v.run();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
                subscription.cancel();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.w != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                this.n.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.w != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                this.n.onError(th);
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.n.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            try {
                this.t.accept(subscription);
                if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.w, subscription)) {
                    this.w = subscription;
                    this.n.onSubscribe(this);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                subscription.cancel();
                this.w = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                io.reactivex.internal.subscriptions.EmptySubscription.error(th, this.n);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            try {
                this.u.accept(j);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
            this.w.request(j);
        }
    }

    public FlowableDoOnLifecycle(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> consumer, io.reactivex.functions.LongConsumer longConsumer, io.reactivex.functions.Action action) {
        super(flowable);
        this.t = consumer;
        this.u = longConsumer;
        this.v = action;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle.SubscriptionLambdaSubscriber(subscriber, this.t, this.u, this.v));
    }
}
