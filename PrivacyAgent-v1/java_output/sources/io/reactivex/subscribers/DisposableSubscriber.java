package io.reactivex.subscribers;

/* loaded from: classes14.dex */
public abstract class DisposableSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
    public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> n = new java.util.concurrent.atomic.AtomicReference<>();

    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.n);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.n.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
    }

    public void onStart() {
        this.n.get().request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.util.EndConsumerHelper.setOnce(this.n, subscription, getClass())) {
            onStart();
        }
    }

    public final void request(long j) {
        this.n.get().request(j);
    }
}
