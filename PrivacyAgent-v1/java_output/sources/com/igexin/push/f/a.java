package com.igexin.push.f;

/* loaded from: classes23.dex */
public class a {
    private static final java.lang.String a = "QtsActivity";
    private static volatile com.igexin.push.f.a d;
    private java.lang.Class b;
    private java.lang.Object c;

    private a(android.content.Context context) {
        try {
            if (this.c == null) {
                android.os.Looper.getMainLooper();
                android.os.Looper.prepare();
                java.lang.Class<?> cls = java.lang.Class.forName("com.adplus.sdk.QtsBaseActivity");
                this.b = cls;
                this.c = cls.newInstance();
                com.igexin.push.h.m.a((java.lang.Class<?>) this.b, "attachBaseContext", (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}).invoke(this.c, context);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static com.igexin.push.f.a a(android.content.Context context) {
        if (d == null) {
            synchronized (com.igexin.push.f.a.class) {
                if (d == null) {
                    d = new com.igexin.push.f.a(context);
                }
            }
        }
        return d;
    }

    private void a(android.app.Activity activity) {
        if (this.c == null) {
            com.igexin.c.a.c.a.a("QtsActivity|mInstance = null", new java.lang.Object[0]);
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = this.b.getDeclaredMethod("onCreate", android.app.Activity.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.c, activity);
            com.igexin.c.a.c.a.a("QtsActivity|callMethod onCreate() success", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a("QtsActivity|callMethod onCreate() failed：%s", th.toString());
        }
    }
}
