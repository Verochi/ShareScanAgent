package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public class TTAppContextHolder {

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static volatile android.content.Context vw;

    public static class vw {

        @android.annotation.SuppressLint({"StaticFieldLeak"})
        private static volatile android.app.Application vw;

        static {
            try {
                java.lang.Object wg = wg();
                vw = (android.app.Application) wg.getClass().getMethod("getApplication", new java.lang.Class[0]).invoke(wg, new java.lang.Object[0]);
                com.bytedance.sdk.openadsdk.api.t.v("MyApplication", "application get success");
            } catch (java.lang.Throwable th) {
                com.bytedance.sdk.openadsdk.api.t.t("MyApplication", "application get failed", th);
            }
        }

        public static android.app.Application vw() {
            return vw;
        }

        private static java.lang.Object wg() {
            try {
                java.lang.reflect.Method method = java.lang.Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new java.lang.Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                com.bytedance.sdk.openadsdk.api.t.t("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static android.content.Context getContext() {
        if (vw == null) {
            setContext(null);
        }
        return vw;
    }

    public static synchronized void setContext(android.content.Context context) {
        synchronized (com.bytedance.sdk.openadsdk.TTAppContextHolder.class) {
            if (vw == null) {
                if (context != null) {
                    vw = context.getApplicationContext();
                } else if (com.bytedance.sdk.openadsdk.TTAppContextHolder.vw.vw() != null) {
                    try {
                        android.app.Application vw2 = com.bytedance.sdk.openadsdk.TTAppContextHolder.vw.vw();
                        vw = vw2;
                        if (vw2 != null) {
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
    }
}
