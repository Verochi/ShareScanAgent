package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class HandlerUtils {

    public static class jad_an extends android.os.Handler {
        public java.lang.ref.WeakReference<com.jd.ad.sdk.fdt.utils.HandlerUtils.jad_bo> jad_an;

        public jad_an(com.jd.ad.sdk.fdt.utils.HandlerUtils.jad_bo jad_boVar, android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            com.jd.ad.sdk.fdt.utils.HandlerUtils.jad_bo jad_boVar;
            java.lang.ref.WeakReference<com.jd.ad.sdk.fdt.utils.HandlerUtils.jad_bo> weakReference = this.jad_an;
            if (weakReference == null || (jad_boVar = weakReference.get()) == null) {
                return;
            }
            jad_boVar.jad_an(message);
        }
    }

    public interface jad_bo {
        void jad_an(android.os.Message message);
    }

    private HandlerUtils() {
        throw new java.lang.UnsupportedOperationException("u can't instantiate me...");
    }

    public static void runOnUiThread(java.lang.Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            runnable.run();
        } else {
            new com.jd.ad.sdk.fdt.utils.HandlerUtils.jad_an(null, android.os.Looper.getMainLooper()).postDelayed(runnable, 0L);
        }
    }

    public static void runOnUiThread(java.lang.Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        new com.jd.ad.sdk.fdt.utils.HandlerUtils.jad_an(null, android.os.Looper.getMainLooper()).postDelayed(runnable, j);
    }
}
