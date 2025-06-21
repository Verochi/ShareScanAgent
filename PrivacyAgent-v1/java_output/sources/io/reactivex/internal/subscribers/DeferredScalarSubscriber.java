package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public abstract class DeferredScalarSubscriber<T, R> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<R> implements io.reactivex.FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected org.reactivestreams.Subscription upstream;

    public DeferredScalarSubscriber(org.reactivestreams.Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(java.lang.Throwable th) {
        this.value = null;
        this.downstream.onError(th);
    }

    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
