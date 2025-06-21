package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSkipUntil<T, U> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final org.reactivestreams.Publisher<U> t;

    public static final class SkipUntilMainSubscriber<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.internal.fuseable.ConditionalSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -6270983465606289181L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        volatile boolean gate;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber<T>.OtherSubscriber other = new io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber.OtherSubscriber();
        final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();

        public final class OtherSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            public OtherSubscriber() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber.this.gate = true;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(java.lang.Throwable th) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber.this.upstream);
                io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber skipUntilMainSubscriber = io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber.this;
                io.reactivex.internal.util.HalfSerializer.onError(skipUntilMainSubscriber.downstream, th, skipUntilMainSubscriber, skipUntilMainSubscriber.error);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(java.lang.Object obj) {
                io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber.this.gate = true;
                get().cancel();
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(org.reactivestreams.Subscription subscription) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public SkipUntilMainSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.upstream.get().request(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (!this.gate) {
                return false;
            }
            io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, t, this, this.error);
            return true;
        }
    }

    public FlowableSkipUntil(io.reactivex.Flowable<T> flowable, org.reactivestreams.Publisher<U> publisher) {
        super(flowable);
        this.t = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber skipUntilMainSubscriber = new io.reactivex.internal.operators.flowable.FlowableSkipUntil.SkipUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(skipUntilMainSubscriber);
        this.t.subscribe(skipUntilMainSubscriber.other);
        this.source.subscribe((io.reactivex.FlowableSubscriber) skipUntilMainSubscriber);
    }
}
