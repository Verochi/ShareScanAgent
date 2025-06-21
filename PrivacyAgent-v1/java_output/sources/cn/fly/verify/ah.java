package cn.fly.verify;

/* loaded from: classes.dex */
public class ah {
    protected static cn.fly.verify.fs a;

    static {
        try {
            cn.fly.verify.fs fsVar = new cn.fly.verify.fs(cn.fly.verify.ax.g());
            a = fsVar;
            fsVar.a("Fly_Pure_Cache", 1);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.lang.String a(java.lang.String str) {
        return a.a(str);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return a.b(str, str2);
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            a.e(str);
        } else {
            a.a(str, str2);
        }
    }
}
