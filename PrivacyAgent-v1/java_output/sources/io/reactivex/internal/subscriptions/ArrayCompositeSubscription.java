package io.reactivex.internal.subscriptions;

/* loaded from: classes13.dex */
public final class ArrayCompositeSubscription extends java.util.concurrent.atomic.AtomicReferenceArray<org.reactivestreams.Subscription> implements io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        org.reactivestreams.Subscription andSet;
        if (get(0) != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                org.reactivestreams.Subscription subscription = get(i);
                io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != subscriptionHelper && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
    }

    public org.reactivestreams.Subscription replaceResource(int i, org.reactivestreams.Subscription subscription) {
        org.reactivestreams.Subscription subscription2;
        do {
            subscription2 = get(i);
            if (subscription2 == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return null;
                }
                subscription.cancel();
                return null;
            }
        } while (!compareAndSet(i, subscription2, subscription));
        return subscription2;
    }

    public boolean setResource(int i, org.reactivestreams.Subscription subscription) {
        org.reactivestreams.Subscription subscription2;
        do {
            subscription2 = get(i);
            if (subscription2 == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!compareAndSet(i, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }
}
