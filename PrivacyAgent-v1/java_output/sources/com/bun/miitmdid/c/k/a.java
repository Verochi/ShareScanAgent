package com.bun.miitmdid.c.k;

/* loaded from: classes.dex */
public class a {
    private static java.lang.Object a;
    private static java.lang.Class<?> b;
    private static java.lang.reflect.Method c;
    private static java.lang.reflect.Method d;
    private static java.lang.reflect.Method e;

    static {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
        } catch (java.lang.Exception e2) {
            com.bun.lib.a.a(com.alipay.sdk.m.j0.b.a, "reflect exception!", e2);
        }
        try {
            java.lang.Class<?> cls2 = b;
            if (cls2 != null) {
                c = cls2.getMethod("getOAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e3) {
            com.bun.lib.a.a(com.alipay.sdk.m.j0.b.a, "reflect exception!", e3);
        }
        try {
            java.lang.Class<?> cls3 = b;
            if (cls3 != null) {
                d = cls3.getMethod("getVAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e4) {
            com.bun.lib.a.a(com.alipay.sdk.m.j0.b.a, "reflect exception!", e4);
        }
        try {
            java.lang.Class<?> cls4 = b;
            if (cls4 != null) {
                e = cls4.getMethod("getAAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e5) {
            com.bun.lib.a.a(com.alipay.sdk.m.j0.b.a, "reflect exception!", e5);
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return a(context, e);
    }

    private static java.lang.String a(android.content.Context context, java.lang.reflect.Method method) {
        java.lang.Object obj = a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (java.lang.String) invoke;
            }
            return null;
        } catch (java.lang.Exception e2) {
            com.bun.lib.a.a(com.alipay.sdk.m.j0.b.a, "invoke exception!", e2);
            return null;
        }
    }

    public static boolean a() {
        return (b == null || a == null) ? false : true;
    }

    public static java.lang.String b(android.content.Context context) {
        return a(context, c);
    }

    public static java.lang.String c(android.content.Context context) {
        return a(context, d);
    }
}
