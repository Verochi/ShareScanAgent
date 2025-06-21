package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSkip<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final long t;

    public static final class SkipSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public long t;
        public org.reactivestreams.Subscription u;

        public SkipSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, long j) {
            this.n = subscriber;
            this.t = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.u.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.t;
            if (j != 0) {
                this.t = j - 1;
            } else {
                this.n.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                long j = this.t;
                this.u = subscription;
                this.n.onSubscribe(this);
                subscription.request(j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.u.request(j);
        }
    }

    public FlowableSkip(io.reactivex.Flowable<T> flowable, long j) {
        super(flowable);
        this.t = j;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableSkip.SkipSubscriber(subscriber, this.t));
    }
}
