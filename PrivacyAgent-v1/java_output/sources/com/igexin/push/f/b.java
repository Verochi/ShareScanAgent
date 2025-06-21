package com.igexin.push.f;

/* loaded from: classes23.dex */
public final class b {
    private static final java.lang.String c = "QtsService";
    public java.lang.Class a;
    public java.lang.Object b;

    public b(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.adplus.sdk.QtsBaseService");
            this.a = cls;
            this.b = cls.newInstance();
            com.igexin.push.h.m.a((java.lang.Class<?>) this.a, "attachBaseContext", (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}).invoke(this.b, context);
        } catch (java.lang.Exception unused) {
        }
    }

    private void a() {
        if (this.b == null) {
            com.igexin.c.a.c.a.a("QtsService|mInstance = null", new java.lang.Object[0]);
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = this.a.getDeclaredMethod("onCreate", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.b, new java.lang.Object[0]);
            com.igexin.c.a.c.a.a("QtsService|callMethod onCreate() success", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a("QtsService|callMethod onCreate() failed：%s", e.toString());
        }
    }

    private void b() {
        if (this.b == null) {
            com.igexin.c.a.c.a.a("QtsService|mInstance = null", new java.lang.Object[0]);
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = this.a.getDeclaredMethod("onDestroy", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.b, new java.lang.Object[0]);
            com.igexin.c.a.c.a.a("QtsService|callMethod onDestroy() success", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a("QtsService|callMethod onDestroy() failed：%s", e.toString());
        }
    }

    public final int a(android.content.Intent intent, int i, int i2) {
        if (this.b != null) {
            try {
                java.lang.Class cls = this.a;
                java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("onStartCommand", android.content.Intent.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.b, intent, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
                com.igexin.c.a.c.a.a("QtsService|callMethod onStartCommand() success", new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a("QtsService|callMethod onStartCommand() failed：%s", e.toString());
            }
        }
        return 0;
    }

    public final android.os.IBinder a(android.content.Intent intent) {
        if (this.b == null) {
            return null;
        }
        try {
            java.lang.reflect.Method declaredMethod = this.a.getDeclaredMethod("onBind", android.content.Intent.class);
            declaredMethod.setAccessible(true);
            return (android.os.IBinder) declaredMethod.invoke(this.b, intent);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a("QtsService|callMethod onBind() failed：%s", e.toString());
            return null;
        }
    }
}
