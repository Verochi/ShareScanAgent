package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class f {
    private static final java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newSingleThreadExecutor();
    private static android.os.Handler b = new android.os.Handler(android.os.Looper.getMainLooper());

    public static void a(java.lang.Runnable runnable) {
        a.execute(runnable);
    }

    public static void b(java.lang.Runnable runnable) {
        b.post(runnable);
    }
}
