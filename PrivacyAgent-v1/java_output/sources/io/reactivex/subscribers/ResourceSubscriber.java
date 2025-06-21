package io.reactivex.subscribers;

/* loaded from: classes14.dex */
public abstract class ResourceSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
    public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> n = new java.util.concurrent.atomic.AtomicReference<>();
    public final io.reactivex.internal.disposables.ListCompositeDisposable t = new io.reactivex.internal.disposables.ListCompositeDisposable();
    public final java.util.concurrent.atomic.AtomicLong u = new java.util.concurrent.atomic.AtomicLong();

    public final void add(io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "resource is null");
        this.t.add(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.n)) {
            this.t.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.n.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.util.EndConsumerHelper.setOnce(this.n, subscription, getClass())) {
            long andSet = this.u.getAndSet(0L);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            onStart();
        }
    }

    public final void request(long j) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.n, this.u, j);
    }
}
