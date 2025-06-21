package com.jd.ad.sdk.jad_lo;

/* loaded from: classes23.dex */
public final class jad_fs {
    public static boolean jad_an(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.checkPermission(str, context.getPackageName()) == 0;
    }
}
