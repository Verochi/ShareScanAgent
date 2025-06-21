package cn.fly.verify;

/* loaded from: classes.dex */
public class dq {
    public static final java.lang.String a;
    public static final java.lang.String b;
    public static final java.lang.String c;
    public static final java.lang.String d;
    public static final java.lang.String e;
    public static final java.lang.String f;
    public static final java.lang.String g;
    public static final java.lang.String h;
    public static final java.lang.Object i;
    public static final java.lang.Object j;
    private static final java.lang.String k;

    static {
        java.lang.String a2 = cn.fly.verify.bj.a("011dFfeegeg mhHfe+d(emgi)m");
        k = a2;
        a = a2 + ".mrlock";
        b = a2 + cn.fly.verify.bj.a("007DgeedFihXfeAdRem");
        c = a2 + cn.fly.verify.bj.a("011^geff*h:fegf[ehBgdfe3d[em");
        d = a2 + cn.fly.verify.bj.a("008)geedeleiYh!feUdVem");
        e = a2 + cn.fly.verify.bj.a("0082geedgiei[h'fe$d=em");
        f = a2 + ".cl_lock";
        g = a2 + ".gcf_lock";
        h = a2 + ".mp_lock";
        i = new java.lang.Object();
        j = new java.lang.Object();
    }

    public static synchronized java.io.File a(java.lang.String str) {
        java.io.File a2;
        synchronized (cn.fly.verify.dq.class) {
            a2 = cn.fly.verify.fq.a(cn.fly.verify.ax.g(), str, true);
        }
        return a2;
    }

    public static boolean a(java.io.File file, cn.fly.verify.dp dpVar) {
        return a(file, true, dpVar);
    }

    public static boolean a(java.io.File file, boolean z, cn.fly.verify.dp dpVar) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            java.lang.String absolutePath = file.getAbsolutePath();
            synchronized (b(absolutePath)) {
                cn.fly.verify.fj fjVar = new cn.fly.verify.fj();
                fjVar.a(absolutePath);
                if (!fjVar.a(z)) {
                    return false;
                }
                try {
                    if (!dpVar.a(fjVar)) {
                        fjVar.b();
                    }
                } catch (java.lang.Throwable unused) {
                    fjVar.b();
                }
                return true;
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return true;
        }
    }

    private static java.lang.String b(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String str2 = c;
            if (str.endsWith(str2)) {
                return str2;
            }
            java.lang.String str3 = b;
            if (str.endsWith(str3)) {
                return str3;
            }
            java.lang.String str4 = d;
            if (str.endsWith(str4)) {
                return str4;
            }
            java.lang.String str5 = e;
            if (str.endsWith(str5)) {
                return str5;
            }
            java.lang.String str6 = f;
            if (str.endsWith(str6)) {
                return str6;
            }
            java.lang.String str7 = g;
            if (str.endsWith(str7)) {
                return str7;
            }
        }
        return str;
    }
}
