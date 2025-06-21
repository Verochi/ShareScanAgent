package cn.fly.verify;

/* loaded from: classes.dex */
public class et {
    public static int a(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        if (applicationInfo == null || !a(com.anythink.core.api.ErrorCode.networkError, str)) {
            return -1;
        }
        return applicationInfo.uid;
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = (java.lang.String) cn.fly.verify.bo.a("aps", (java.lang.Object) null);
        if (str3 == null) {
            return true;
        }
        java.lang.String[] split = str3.split(com.alipay.sdk.m.u.i.b);
        if (android.text.TextUtils.equals(str2, cn.fly.verify.fh.d.c())) {
            if (split.length > 1) {
                return !split[1].contains(str);
            }
            return true;
        }
        if (split.length > 0) {
            return !split[0].contains(str);
        }
        return true;
    }

    public static android.content.pm.Signature[] a(java.lang.Object obj, java.lang.String str) {
        if (a(com.anythink.core.api.ErrorCode.adapterNotExistError, str)) {
            return (android.content.pm.Signature[]) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("010*giejffUfejNehekBgWgi"), (java.lang.Object) null);
        }
        return null;
    }

    public static java.lang.String b(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        if (applicationInfo == null || !a("1004", str)) {
            return null;
        }
        return applicationInfo.name;
    }

    public static java.lang.String b(java.lang.Object obj, java.lang.String str) {
        return a(com.anythink.core.api.ErrorCode.inPacingError, str) ? (java.lang.String) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("011Oee<g>ekgiejfe9fWfi*e egLg"), "1.0") : "1.0";
    }

    public static int c(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        if (applicationInfo == null || !a("1005", str)) {
            return -1;
        }
        return applicationInfo.labelRes;
    }

    public static long c(java.lang.Object obj, java.lang.String str) {
        if (a(com.anythink.core.api.ErrorCode.adapterInnerError, str)) {
            return ((java.lang.Long) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("014heOgi-j2fh:k^edQejg-flejeg@g"), 0L)).longValue();
        }
        return 0L;
    }

    public static int d(java.lang.Object obj, java.lang.String str) {
        if (a(com.anythink.core.api.ErrorCode.inRequestFailPacing, str)) {
            return ((java.lang.Integer) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("011!eeOg=ekgiejfe8f9hlfeedCg"), 0)).intValue();
        }
        return 0;
    }

    public static java.lang.CharSequence d(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        if (applicationInfo == null || !a("1006", str)) {
            return null;
        }
        return applicationInfo.nonLocalizedLabel;
    }

    public static long e(java.lang.Object obj, java.lang.String str) {
        if (a("2101", str)) {
            return ((java.lang.Long) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("018$ffBgj3gdfe4f_ffhkOgHekgiejfeDf[hlfeedTg"), 0L, new java.lang.Object[0])).longValue();
        }
        return 0L;
    }

    public static java.lang.String e(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        if (applicationInfo == null || !a("1008", str)) {
            return null;
        }
        return applicationInfo.processName;
    }

    public static java.lang.CharSequence f(android.content.pm.ApplicationInfo applicationInfo, java.lang.String str) {
        if (applicationInfo == null || !a("1101", str)) {
            return null;
        }
        return applicationInfo.loadLabel(cn.fly.verify.ax.g().getPackageManager());
    }
}
