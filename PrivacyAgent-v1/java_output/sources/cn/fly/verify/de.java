package cn.fly.verify;

/* loaded from: classes.dex */
public class de {
    public static boolean a() {
        return cn.fly.verify.az.a().c();
    }

    private static boolean a(java.lang.String str) {
        return true;
    }

    public static boolean b() {
        return a(cn.fly.verify.dn.a("003beb"));
    }

    public static boolean c() {
        return a(cn.fly.verify.dn.a("003_ddbg@b"));
    }

    public static boolean d() {
        return a(cn.fly.verify.dn.a("003,dd9eb"));
    }

    public static boolean e() {
        return a("na");
    }

    public static boolean f() {
        return android.os.SystemClock.elapsedRealtime() - cn.fly.verify.ba.a().b() <= ((long) ((java.lang.Integer) cn.fly.verify.bo.a(cn.fly.verify.dn.a("003TdfbgCg"), 600)).intValue()) * 1000;
    }
}
