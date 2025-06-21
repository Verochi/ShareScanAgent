package com.alipay.sdk.m.b;

/* loaded from: classes.dex */
public class c {
    public static com.alipay.sdk.m.b.b a;
    public static boolean b;

    public static synchronized java.lang.String a(android.content.Context context) {
        synchronized (com.alipay.sdk.m.b.c.class) {
            if (context == null) {
                throw new java.lang.RuntimeException("Context is null");
            }
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                throw new java.lang.IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            com.alipay.sdk.m.b.b bVar = a;
            if (bVar != null) {
                try {
                    return bVar.a(context);
                } catch (java.lang.Exception unused) {
                }
            }
            return null;
        }
    }

    public static void b(android.content.Context context) {
        if (a != null || b) {
            return;
        }
        synchronized (com.alipay.sdk.m.b.c.class) {
            if (a == null && !b) {
                a = com.alipay.sdk.m.c.a.a(context);
                b = true;
            }
        }
    }
}
