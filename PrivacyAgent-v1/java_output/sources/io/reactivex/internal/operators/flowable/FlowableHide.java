package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableHide<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {

    public static final class HideSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public org.reactivestreams.Subscription t;

        public HideSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.n = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.t.cancel();
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
            this.n.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.t, subscription)) {
                this.t = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.t.request(j);
        }
    }

    public FlowableHide(io.reactivex.Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableHide.HideSubscriber(subscriber));
    }
}
