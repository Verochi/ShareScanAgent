package com.alipay.sdk.m.i0;

/* loaded from: classes.dex */
public class b {
    public static final java.lang.String a = "OpenIdHelper";
    public static java.lang.reflect.Method b;

    public static java.lang.String a(android.content.Context context) {
        com.alipay.sdk.m.i0.f a2 = com.alipay.sdk.m.i0.f.a();
        return a2.a(context.getApplicationContext(), a2.c);
    }

    public static void a(boolean z) {
        com.alipay.sdk.m.i0.f.a();
        com.alipay.sdk.m.i0.f.a(z);
    }

    public static final boolean a() {
        android.content.Context context = null;
        try {
            if (b == null) {
                java.lang.reflect.Method method = java.lang.Class.forName("android.app.ActivityThread").getMethod("currentApplication", new java.lang.Class[0]);
                b = method;
                method.setAccessible(true);
            }
            context = (android.content.Context) b.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            new java.lang.StringBuilder("ActivityThread:currentApplication --> ").append(e.toString());
        }
        if (context == null) {
            return false;
        }
        return com.alipay.sdk.m.i0.f.a().a(context, false);
    }

    public static java.lang.String b(android.content.Context context) {
        com.alipay.sdk.m.i0.f a2 = com.alipay.sdk.m.i0.f.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }

    public static java.lang.String c(android.content.Context context) {
        com.alipay.sdk.m.i0.f a2 = com.alipay.sdk.m.i0.f.a();
        return a2.a(context.getApplicationContext(), a2.a);
    }

    public static java.lang.String d(android.content.Context context) {
        com.alipay.sdk.m.i0.f a2 = com.alipay.sdk.m.i0.f.a();
        return a2.a(context.getApplicationContext(), a2.d);
    }
}
