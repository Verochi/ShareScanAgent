package com.meizu.cloud.pushsdk.d.b.a;

/* loaded from: classes23.dex */
public class b {
    private static java.util.concurrent.ExecutorService a = null;
    private static int b = 2;

    public static java.util.concurrent.ExecutorService a() {
        synchronized (com.meizu.cloud.pushsdk.d.b.a.b.class) {
            if (a == null) {
                a = java.util.concurrent.Executors.newScheduledThreadPool(b);
            }
        }
        return a;
    }

    public static java.util.concurrent.Future a(java.util.concurrent.Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        b = i;
    }

    public static void a(java.lang.Runnable runnable) {
        a().execute(runnable);
    }
}
