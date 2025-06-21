package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public final class UIThreadUtils implements com.alimm.tanx.core.utils.NotConfused {

    public static final class tanxc_do {
        private static final android.os.Handler tanxc_do = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    private UIThreadUtils() {
    }

    public static void post(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        com.alimm.tanx.core.utils.UIThreadUtils.tanxc_do.tanxc_do.post(runnable);
    }

    public static void postDelayed(@androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
        com.alimm.tanx.core.utils.UIThreadUtils.tanxc_do.tanxc_do.postDelayed(runnable, j);
    }

    public static void removeCallbacks(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        com.alimm.tanx.core.utils.UIThreadUtils.tanxc_do.tanxc_do.removeCallbacks(runnable);
    }

    public static void run(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread()) {
            runnable.run();
        } else {
            com.alimm.tanx.core.utils.UIThreadUtils.tanxc_do.tanxc_do.post(runnable);
        }
    }
}
