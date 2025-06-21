package io.reactivex.android.schedulers;

/* loaded from: classes9.dex */
public final class AndroidSchedulers {
    public static final io.reactivex.Scheduler a = io.reactivex.android.plugins.RxAndroidPlugins.initMainThreadScheduler(new io.reactivex.android.schedulers.AndroidSchedulers.AnonymousClass1());

    /* renamed from: io.reactivex.android.schedulers.AndroidSchedulers$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.Callable<io.reactivex.Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public io.reactivex.Scheduler call() throws java.lang.Exception {
            return io.reactivex.android.schedulers.AndroidSchedulers.MainHolder.a;
        }
    }

    public static final class MainHolder {
        public static final io.reactivex.Scheduler a = new io.reactivex.android.schedulers.HandlerScheduler(new android.os.Handler(android.os.Looper.getMainLooper()), false);
    }

    public AndroidSchedulers() {
        throw new java.lang.AssertionError("No instances.");
    }

    public static io.reactivex.Scheduler from(android.os.Looper looper) {
        return from(looper, false);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static io.reactivex.Scheduler from(android.os.Looper looper, boolean z) {
        if (looper == null) {
            throw new java.lang.NullPointerException("looper == null");
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (z && i < 22) {
            android.os.Message obtain = android.os.Message.obtain();
            try {
                obtain.setAsynchronous(true);
            } catch (java.lang.NoSuchMethodError unused) {
                z = false;
            }
            obtain.recycle();
        }
        return new io.reactivex.android.schedulers.HandlerScheduler(new android.os.Handler(looper), z);
    }

    public static io.reactivex.Scheduler mainThread() {
        return io.reactivex.android.plugins.RxAndroidPlugins.onMainThreadScheduler(a);
    }
}
