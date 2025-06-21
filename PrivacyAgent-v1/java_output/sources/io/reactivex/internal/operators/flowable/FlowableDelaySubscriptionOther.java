package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends io.reactivex.Flowable<T> {
    public final org.reactivestreams.Publisher<? extends T> t;
    public final org.reactivestreams.Publisher<U> u;

    public static final class MainSubscriber<T> extends java.util.concurrent.atomic.AtomicLong implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 2259811067697317255L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final org.reactivestreams.Publisher<? extends T> main;
        final io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber<T>.OtherSubscriber other = new io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber.OtherSubscriber();
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();

        public final class OtherSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            public OtherSubscriber() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                    io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber.this.next();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(java.lang.Throwable th) {
                if (get() != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                    io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber.this.downstream.onError(th);
                } else {
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(java.lang.Object obj) {
                org.reactivestreams.Subscription subscription = get();
                io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    subscription.cancel();
                    io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber.this.next();
                }
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(org.reactivestreams.Subscription subscription) {
                if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public MainSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, org.reactivestreams.Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.main = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
        }

        public void next() {
            this.main.subscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this, j);
            }
        }
    }

    public FlowableDelaySubscriptionOther(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<U> publisher2) {
        this.t = publisher;
        this.u = publisher2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber mainSubscriber = new io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther.MainSubscriber(subscriber, this.t);
        subscriber.onSubscribe(mainSubscriber);
        this.u.subscribe(mainSubscriber.other);
    }
}
