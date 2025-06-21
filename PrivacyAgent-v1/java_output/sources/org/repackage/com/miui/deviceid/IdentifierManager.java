package org.repackage.com.miui.deviceid;

/* loaded from: classes26.dex */
public class IdentifierManager {
    public static java.lang.Object a;
    public static java.lang.Class<?> b;
    public static java.lang.reflect.Method c;
    public static java.lang.reflect.Method d;
    public static java.lang.reflect.Method e;
    public static java.lang.reflect.Method f;

    static {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getUDID", android.content.Context.class);
            d = b.getMethod("getOAID", android.content.Context.class);
            e = b.getMethod("getVAID", android.content.Context.class);
            f = b.getMethod("getAAID", android.content.Context.class);
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return b(context, c);
    }

    public static boolean a() {
        return (b == null || a == null) ? false : true;
    }

    public static java.lang.String b(android.content.Context context) {
        return b(context, d);
    }

    public static java.lang.String b(android.content.Context context, java.lang.reflect.Method method) {
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
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        return b(context, e);
    }

    public static java.lang.String d(android.content.Context context) {
        return b(context, f);
    }
}
