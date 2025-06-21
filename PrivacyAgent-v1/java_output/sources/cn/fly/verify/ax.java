package cn.fly.verify;

/* loaded from: classes.dex */
public class ax {
    public static final int a;
    public static final java.lang.String b;
    private static volatile android.content.Context c;

    static {
        int i;
        java.lang.String str = "1.0.0";
        try {
            str = "2024-11-08".replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, ".");
            i = java.lang.Integer.parseInt("2024-11-08".replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        } catch (java.lang.Throwable unused) {
            i = 1;
        }
        a = i;
        b = str;
    }

    public static cn.fly.verify.bb a() {
        return cn.fly.verify.ds.e == null ? cn.fly.verify.bb.DEFAULT : cn.fly.verify.ds.e;
    }

    @java.lang.Deprecated
    public static java.lang.String a(java.lang.String str) {
        return cn.fly.verify.dw.a(str);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        return cn.fly.verify.dv.a(str, str2, str3, z);
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (cn.fly.verify.ax.class) {
            a(context, null, null);
        }
    }

    public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        synchronized (cn.fly.verify.ax.class) {
            if (context == null) {
                return;
            }
            if (c == null) {
                c = context.getApplicationContext();
                cn.fly.verify.ds.a = str;
                cn.fly.verify.ds.b = str2;
                cn.fly.verify.dv.a(false);
            } else if (!android.text.TextUtils.isEmpty(str) && !str.equals(cn.fly.verify.ds.a)) {
                cn.fly.verify.ds.a = str;
                cn.fly.verify.ds.b = str2;
                cn.fly.verify.dv.a(true);
            }
        }
    }

    public static void a(cn.fly.verify.aw awVar) {
        cn.fly.verify.az.a().a(awVar);
    }

    public static void a(cn.fly.verify.aw awVar, boolean z) {
        cn.fly.verify.dy.b(z);
        a(awVar);
    }

    public static void a(boolean z) {
        a(null, z);
    }

    public static boolean b() {
        return cn.fly.verify.ds.f;
    }

    public static boolean c() {
        return cn.fly.verify.ds.g;
    }

    public static java.lang.String d() {
        if (cn.fly.verify.dy.h()) {
            return cn.fly.verify.dv.a();
        }
        return null;
    }

    public static java.lang.String e() {
        return android.text.TextUtils.isEmpty(cn.fly.verify.ds.b) ? cn.fly.verify.ds.d : cn.fly.verify.ds.b;
    }

    public static android.content.Context f() {
        return c;
    }

    public static android.content.Context g() {
        if (c == null) {
            try {
                android.content.Context a2 = cn.fly.verify.dw.a();
                if (a2 != null) {
                    a(a2);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return c;
    }

    public static final boolean h() {
        return cn.fly.verify.dv.c();
    }

    public static int i() {
        return cn.fly.verify.dy.c();
    }
}
