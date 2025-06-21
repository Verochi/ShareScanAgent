package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class EndConsumerHelper {
    public EndConsumerHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static java.lang.String composeMessage(java.lang.String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void reportDoubleSubscription(java.lang.Class<?> cls) {
        io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.ProtocolViolationException(composeMessage(cls.getName())));
    }

    public static boolean setOnce(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.disposables.Disposable disposable, java.lang.Class<?> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "next is null");
        if (defpackage.xv0.a(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }

    public static boolean setOnce(java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference, org.reactivestreams.Subscription subscription, java.lang.Class<?> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscription, "next is null");
        if (defpackage.xv0.a(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }

    public static boolean validate(io.reactivex.disposables.Disposable disposable, io.reactivex.disposables.Disposable disposable2, java.lang.Class<?> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable2, "next is null");
        if (disposable == null) {
            return true;
        }
        disposable2.dispose();
        if (disposable == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }

    public static boolean validate(org.reactivestreams.Subscription subscription, org.reactivestreams.Subscription subscription2, java.lang.Class<?> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscription2, "next is null");
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        if (subscription == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }
}
