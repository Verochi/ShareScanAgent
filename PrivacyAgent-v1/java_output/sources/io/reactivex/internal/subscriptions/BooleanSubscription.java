package io.reactivex.internal.subscriptions;

/* loaded from: classes13.dex */
public final class BooleanSubscription extends java.util.concurrent.atomic.AtomicBoolean implements org.reactivestreams.Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public java.lang.String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
