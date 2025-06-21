package com.jd.ad.sdk.jad_an;

/* loaded from: classes23.dex */
public final class jad_cp {
    public static java.lang.String jad_an = "";
    public static java.lang.String jad_bo = "";
    public static java.lang.String jad_cp = "";
    public static int jad_dq;
    public static long jad_er;
    public static long jad_fs;
    public static long jad_jt;

    public static android.content.pm.PackageInfo jad_an(android.content.Context context, int i) {
        try {
            return context.getPackageManager().getPackageInfo(jad_an(context), i);
        } catch (java.lang.Exception e) {
            com.jd.android.sdk.coreinfo.util.Logger.e("AppInfo", "An exception happends when call getPackageInfo().", e);
            return null;
        }
    }

    public static java.lang.String jad_an(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(jad_bo)) {
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", com.anythink.expressad.foundation.g.b.b.a);
                return "";
            }
            jad_bo = context.getPackageName();
        }
        return jad_bo;
    }

    public static long jad_bo(android.content.Context context) {
        java.lang.String str;
        if (jad_jt <= 0) {
            if (context == null) {
                str = com.anythink.expressad.foundation.g.b.b.a;
            } else {
                if (jad_an(context, 64) == null) {
                    str = "packageInfo is null";
                } else {
                    jad_jt = r5.signatures[0].hashCode();
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", str);
            return 0L;
        }
        return jad_jt;
    }
}
