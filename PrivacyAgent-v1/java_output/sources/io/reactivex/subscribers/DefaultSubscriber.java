package io.reactivex.subscribers;

/* loaded from: classes14.dex */
public abstract class DefaultSubscriber<T> implements io.reactivex.FlowableSubscriber<T> {
    public org.reactivestreams.Subscription n;

    public final void cancel() {
        org.reactivestreams.Subscription subscription = this.n;
        this.n = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.util.EndConsumerHelper.validate(this.n, subscription, getClass())) {
            this.n = subscription;
            onStart();
        }
    }

    public final void request(long j) {
        org.reactivestreams.Subscription subscription = this.n;
        if (subscription != null) {
            subscription.request(j);
        }
    }
}
