package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_cp {
    public static android.app.Application jad_an;

    @androidx.annotation.Nullable
    public static android.app.Application jad_an() {
        android.app.Application application = jad_an;
        if (application != null) {
            return application;
        }
        try {
            return (android.app.Application) java.lang.Class.forName("android.app.ActivityThread").getMethod("currentApplication", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("get application error: ", e.getMessage());
            try {
                return (android.app.Application) java.lang.Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            } catch (java.lang.Exception e2) {
                com.jd.ad.sdk.logger.Logger.w("get application error: ", e2.getMessage());
                return null;
            }
        }
    }
}
