package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public enum NotificationLite {
    COMPLETE;

    public static final class DisposableNotification implements java.io.Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.disposables.Disposable upstream;

        public DisposableNotification(io.reactivex.disposables.Disposable disposable) {
            this.upstream = disposable;
        }

        public java.lang.String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static final class ErrorNotification implements java.io.Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final java.lang.Throwable e;

        public ErrorNotification(java.lang.Throwable th) {
            this.e = th;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof io.reactivex.internal.util.NotificationLite.ErrorNotification) {
                return io.reactivex.internal.functions.ObjectHelper.equals(this.e, ((io.reactivex.internal.util.NotificationLite.ErrorNotification) obj).e);
            }
            return false;
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public java.lang.String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }
    }

    public static final class SubscriptionNotification implements java.io.Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final org.reactivestreams.Subscription upstream;

        public SubscriptionNotification(org.reactivestreams.Subscription subscription) {
            this.upstream = subscription;
        }

        public java.lang.String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(java.lang.Object obj, io.reactivex.Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (obj instanceof io.reactivex.internal.util.NotificationLite.ErrorNotification) {
            observer.onError(((io.reactivex.internal.util.NotificationLite.ErrorNotification) obj).e);
            return true;
        }
        observer.onNext(obj);
        return false;
    }

    public static <T> boolean accept(java.lang.Object obj, org.reactivestreams.Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof io.reactivex.internal.util.NotificationLite.ErrorNotification) {
            subscriber.onError(((io.reactivex.internal.util.NotificationLite.ErrorNotification) obj).e);
            return true;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(java.lang.Object obj, io.reactivex.Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (obj instanceof io.reactivex.internal.util.NotificationLite.ErrorNotification) {
            observer.onError(((io.reactivex.internal.util.NotificationLite.ErrorNotification) obj).e);
            return true;
        }
        if (obj instanceof io.reactivex.internal.util.NotificationLite.DisposableNotification) {
            observer.onSubscribe(((io.reactivex.internal.util.NotificationLite.DisposableNotification) obj).upstream);
            return false;
        }
        observer.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(java.lang.Object obj, org.reactivestreams.Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof io.reactivex.internal.util.NotificationLite.ErrorNotification) {
            subscriber.onError(((io.reactivex.internal.util.NotificationLite.ErrorNotification) obj).e);
            return true;
        }
        if (obj instanceof io.reactivex.internal.util.NotificationLite.SubscriptionNotification) {
            subscriber.onSubscribe(((io.reactivex.internal.util.NotificationLite.SubscriptionNotification) obj).upstream);
            return false;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static java.lang.Object complete() {
        return COMPLETE;
    }

    public static java.lang.Object disposable(io.reactivex.disposables.Disposable disposable) {
        return new io.reactivex.internal.util.NotificationLite.DisposableNotification(disposable);
    }

    public static java.lang.Object error(java.lang.Throwable th) {
        return new io.reactivex.internal.util.NotificationLite.ErrorNotification(th);
    }

    public static io.reactivex.disposables.Disposable getDisposable(java.lang.Object obj) {
        return ((io.reactivex.internal.util.NotificationLite.DisposableNotification) obj).upstream;
    }

    public static java.lang.Throwable getError(java.lang.Object obj) {
        return ((io.reactivex.internal.util.NotificationLite.ErrorNotification) obj).e;
    }

    public static org.reactivestreams.Subscription getSubscription(java.lang.Object obj) {
        return ((io.reactivex.internal.util.NotificationLite.SubscriptionNotification) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(java.lang.Object obj) {
        return obj;
    }

    public static boolean isComplete(java.lang.Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(java.lang.Object obj) {
        return obj instanceof io.reactivex.internal.util.NotificationLite.DisposableNotification;
    }

    public static boolean isError(java.lang.Object obj) {
        return obj instanceof io.reactivex.internal.util.NotificationLite.ErrorNotification;
    }

    public static boolean isSubscription(java.lang.Object obj) {
        return obj instanceof io.reactivex.internal.util.NotificationLite.SubscriptionNotification;
    }

    public static <T> java.lang.Object next(T t) {
        return t;
    }

    public static java.lang.Object subscription(org.reactivestreams.Subscription subscription) {
        return new io.reactivex.internal.util.NotificationLite.SubscriptionNotification(subscription);
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return "NotificationLite.Complete";
    }
}
