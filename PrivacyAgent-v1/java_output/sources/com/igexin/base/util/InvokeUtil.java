package com.igexin.base.util;

/* loaded from: classes22.dex */
public class InvokeUtil {
    private static android.content.Context appContext;

    public static android.content.Context findAppContext() {
        android.content.Context context = appContext;
        if (context != null) {
            return context;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            android.content.Context context2 = (android.content.Context) cls.getMethod("getApplication", new java.lang.Class[0]).invoke(cls.getDeclaredMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]), new java.lang.Object[0]);
            appContext = context2;
            return context2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
