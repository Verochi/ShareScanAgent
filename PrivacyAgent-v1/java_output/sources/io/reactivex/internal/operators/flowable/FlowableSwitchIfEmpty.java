package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSwitchIfEmpty<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final org.reactivestreams.Publisher<? extends T> t;

    public static final class SwitchIfEmptySubscriber<T> implements io.reactivex.FlowableSubscriber<T> {
        public final org.reactivestreams.Subscriber<? super T> n;
        public final org.reactivestreams.Publisher<? extends T> t;
        public boolean v = true;
        public final io.reactivex.internal.subscriptions.SubscriptionArbiter u = new io.reactivex.internal.subscriptions.SubscriptionArbiter(false);

        public SwitchIfEmptySubscriber(org.reactivestreams.Subscriber<? super T> subscriber, org.reactivestreams.Publisher<? extends T> publisher) {
            this.n = subscriber;
            this.t = publisher;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.v) {
                this.n.onComplete();
            } else {
                this.v = false;
                this.t.subscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.v) {
                this.v = false;
            }
            this.n.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            this.u.setSubscription(subscription);
        }
    }

    public FlowableSwitchIfEmpty(io.reactivex.Flowable<T> flowable, org.reactivestreams.Publisher<? extends T> publisher) {
        super(flowable);
        this.t = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty.SwitchIfEmptySubscriber switchIfEmptySubscriber = new io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty.SwitchIfEmptySubscriber(subscriber, this.t);
        subscriber.onSubscribe(switchIfEmptySubscriber.u);
        this.source.subscribe((io.reactivex.FlowableSubscriber) switchIfEmptySubscriber);
    }
}
