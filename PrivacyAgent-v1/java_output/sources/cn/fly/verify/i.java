package cn.fly.verify;

/* loaded from: classes.dex */
public class i {
    private static java.lang.String a;
    private static java.lang.String b;
    private static java.lang.String c;
    private static java.lang.String d;

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(a)) {
            a = "api-auth.zztfly.com";
        }
        return a;
    }

    public static java.lang.String a(int i) {
        java.lang.StringBuilder sb;
        java.lang.String a2;
        java.lang.String str;
        if (i != 1) {
            if (i == 2) {
                a2 = a("https://" + b());
                str = "conf";
            } else if (i == 3) {
                a2 = a("https://" + c());
                str = "cdn";
            } else if (i == 4) {
                a2 = a("https://" + d());
                str = "log";
            } else {
                sb = new java.lang.StringBuilder();
            }
            return a(a2, str, false);
        }
        sb = new java.lang.StringBuilder();
        sb.append("https://");
        sb.append(a());
        return a(a(sb.toString()), "api", false);
    }

    private static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return str;
        }
        return str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String str3;
        try {
            str3 = cn.fly.verify.ax.a(cn.fly.verify.FlyVerify.sdkTag, str2, str, z);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            str3 = null;
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            str3 = str;
        }
        if (!str3.startsWith("https://")) {
            str3 = a("https://" + str3);
        }
        try {
            return cn.fly.verify.ax.a(str3);
        } catch (java.lang.Throwable th2) {
            cn.fly.verify.f.a().a(th2);
            return "https://" + str;
        }
    }

    public static java.lang.String b() {
        if (android.text.TextUtils.isEmpty(b)) {
            b = "conf-auth.zztfly.com";
        }
        return b;
    }

    public static java.lang.String c() {
        if (android.text.TextUtils.isEmpty(c)) {
            c = "cdn-api-auth.zztfly.com";
        }
        return c;
    }

    public static java.lang.String d() {
        if (android.text.TextUtils.isEmpty(d)) {
            d = "log-auth.zztfly.com";
        }
        return d;
    }
}
