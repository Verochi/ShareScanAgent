package com.alipay.sdk.m.j0;

/* loaded from: classes.dex */
public class b {
    public static final java.lang.String a = "IdentifierManager";
    public static java.lang.Object b;
    public static java.lang.Class<?> c;
    public static java.lang.reflect.Method d;
    public static java.lang.reflect.Method e;
    public static java.lang.reflect.Method f;
    public static java.lang.reflect.Method g;

    static {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            b = cls.newInstance();
            d = c.getMethod("getUDID", android.content.Context.class);
            e = c.getMethod("getOAID", android.content.Context.class);
            f = c.getMethod("getVAID", android.content.Context.class);
            g = c.getMethod("getAAID", android.content.Context.class);
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return a(context, g);
    }

    public static java.lang.String a(android.content.Context context, java.lang.reflect.Method method) {
        java.lang.Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (java.lang.String) invoke;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static java.lang.String b(android.content.Context context) {
        return a(context, e);
    }

    public static java.lang.String c(android.content.Context context) {
        return a(context, d);
    }

    public static java.lang.String d(android.content.Context context) {
        return a(context, f);
    }
}
