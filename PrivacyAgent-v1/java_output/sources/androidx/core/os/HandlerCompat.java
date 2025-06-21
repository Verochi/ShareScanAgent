package androidx.core.os;

/* loaded from: classes.dex */
public final class HandlerCompat {
    private static final java.lang.String TAG = "HandlerCompat";

    private HandlerCompat() {
    }

    @androidx.annotation.NonNull
    public static android.os.Handler createAsync(@androidx.annotation.NonNull android.os.Looper looper) {
        android.os.Handler createAsync;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            createAsync = android.os.Handler.createAsync(looper);
            return createAsync;
        }
        try {
            return (android.os.Handler) android.os.Handler.class.getDeclaredConstructor(android.os.Looper.class, android.os.Handler.Callback.class, java.lang.Boolean.TYPE).newInstance(looper, null, java.lang.Boolean.TRUE);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException unused) {
            return new android.os.Handler(looper);
        } catch (java.lang.reflect.InvocationTargetException e) {
            java.lang.Throwable cause = e.getCause();
            if (cause instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) cause);
            }
            if (cause instanceof java.lang.Error) {
                throw ((java.lang.Error) cause);
            }
            throw new java.lang.RuntimeException(cause);
        }
    }

    @androidx.annotation.NonNull
    public static android.os.Handler createAsync(@androidx.annotation.NonNull android.os.Looper looper, @androidx.annotation.NonNull android.os.Handler.Callback callback) {
        android.os.Handler createAsync;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            createAsync = android.os.Handler.createAsync(looper, callback);
            return createAsync;
        }
        try {
            return (android.os.Handler) android.os.Handler.class.getDeclaredConstructor(android.os.Looper.class, android.os.Handler.Callback.class, java.lang.Boolean.TYPE).newInstance(looper, callback, java.lang.Boolean.TRUE);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException unused) {
            return new android.os.Handler(looper, callback);
        } catch (java.lang.reflect.InvocationTargetException e) {
            java.lang.Throwable cause = e.getCause();
            if (cause instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) cause);
            }
            if (cause instanceof java.lang.Error) {
                throw ((java.lang.Error) cause);
            }
            throw new java.lang.RuntimeException(cause);
        }
    }

    public static boolean postDelayed(@androidx.annotation.NonNull android.os.Handler handler, @androidx.annotation.NonNull java.lang.Runnable runnable, @androidx.annotation.Nullable java.lang.Object obj, long j) {
        boolean postDelayed;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            postDelayed = handler.postDelayed(runnable, obj, j);
            return postDelayed;
        }
        android.os.Message obtain = android.os.Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j);
    }
}
