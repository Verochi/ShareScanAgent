package io.reactivex.internal.subscriptions;

/* loaded from: classes13.dex */
public enum SubscriptionHelper implements org.reactivestreams.Subscription {
    CANCELLED;

    public static boolean cancel(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference) {
        org.reactivestreams.Subscription andSet;
        org.reactivestreams.Subscription subscription = atomicReference.get();
        io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, java.util.concurrent.atomic.AtomicLong atomicLong, long j) {
        org.reactivestreams.Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
            return;
        }
        if (validate(j)) {
            io.reactivex.internal.util.BackpressureHelper.add(atomicLong, j);
            org.reactivestreams.Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, java.util.concurrent.atomic.AtomicLong atomicLong, org.reactivestreams.Subscription subscription) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        subscription.request(andSet);
        return true;
    }

    public static boolean replace(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, org.reactivestreams.Subscription subscription) {
        org.reactivestreams.Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!defpackage.xv0.a(atomicReference, subscription2, subscription));
        return true;
    }

    public static void reportMoreProduced(long j) {
        io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.ProtocolViolationException("More produced than requested: " + j));
    }

    public static void reportSubscriptionSet() {
        io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, org.reactivestreams.Subscription subscription) {
        org.reactivestreams.Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!defpackage.xv0.a(atomicReference, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }

    public static boolean setOnce(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, org.reactivestreams.Subscription subscription) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscription, "s is null");
        if (defpackage.xv0.a(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean setOnce(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, org.reactivestreams.Subscription subscription, long j) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        subscription.request(j);
        return true;
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        io.reactivex.plugins.RxJavaPlugins.onError(new java.lang.IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    public static boolean validate(org.reactivestreams.Subscription subscription, org.reactivestreams.Subscription subscription2) {
        if (subscription2 == null) {
            io.reactivex.plugins.RxJavaPlugins.onError(new java.lang.NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
