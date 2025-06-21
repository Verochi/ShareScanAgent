package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_bo {
    public static boolean jad_an(java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        android.app.Application jad_an;
        try {
            jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        } catch (java.lang.Throwable unused) {
            packageInfo = null;
        }
        if (jad_an == null) {
            return false;
        }
        packageInfo = jad_an.getPackageManager().getPackageInfo(str, 0);
        return packageInfo != null;
    }
}
