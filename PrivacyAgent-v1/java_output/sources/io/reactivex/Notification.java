package io.reactivex;

/* loaded from: classes9.dex */
public final class Notification<T> {
    public static final io.reactivex.Notification<java.lang.Object> b = new io.reactivex.Notification<>(null);
    public final java.lang.Object a;

    public Notification(java.lang.Object obj) {
        this.a = obj;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Notification<T> createOnComplete() {
        return (io.reactivex.Notification<T>) b;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Notification<T> createOnError(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "error is null");
        return new io.reactivex.Notification<>(io.reactivex.internal.util.NotificationLite.error(th));
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Notification<T> createOnNext(@io.reactivex.annotations.NonNull T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "value is null");
        return new io.reactivex.Notification<>(t);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof io.reactivex.Notification) {
            return io.reactivex.internal.functions.ObjectHelper.equals(this.a, ((io.reactivex.Notification) obj).a);
        }
        return false;
    }

    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getError() {
        java.lang.Object obj = this.a;
        if (io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return io.reactivex.internal.util.NotificationLite.getError(obj);
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        java.lang.Object obj = this.a;
        if (obj == null || io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.a;
    }

    public int hashCode() {
        java.lang.Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isOnComplete() {
        return this.a == null;
    }

    public boolean isOnError() {
        return io.reactivex.internal.util.NotificationLite.isError(this.a);
    }

    public boolean isOnNext() {
        java.lang.Object obj = this.a;
        return (obj == null || io.reactivex.internal.util.NotificationLite.isError(obj)) ? false : true;
    }

    public java.lang.String toString() {
        java.lang.Object obj = this.a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + io.reactivex.internal.util.NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.a + "]";
    }
}
