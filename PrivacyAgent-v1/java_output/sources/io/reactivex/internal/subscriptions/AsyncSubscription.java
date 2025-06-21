package io.reactivex.internal.subscriptions;

/* loaded from: classes13.dex */
public final class AsyncSubscription extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription, io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = 7028635084060361255L;
    final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> actual;
    final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> resource;

    public AsyncSubscription() {
        this.resource = new java.util.concurrent.atomic.AtomicReference<>();
        this.actual = new java.util.concurrent.atomic.AtomicReference<>();
    }

    public AsyncSubscription(io.reactivex.disposables.Disposable disposable) {
        this();
        this.resource.lazySet(disposable);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.actual);
        io.reactivex.internal.disposables.DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.actual.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(io.reactivex.disposables.Disposable disposable) {
        return io.reactivex.internal.disposables.DisposableHelper.replace(this.resource, disposable);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.actual, this, j);
    }

    public boolean setResource(io.reactivex.disposables.Disposable disposable) {
        return io.reactivex.internal.disposables.DisposableHelper.set(this.resource, disposable);
    }

    public void setSubscription(org.reactivestreams.Subscription subscription) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.actual, this, subscription);
    }
}
