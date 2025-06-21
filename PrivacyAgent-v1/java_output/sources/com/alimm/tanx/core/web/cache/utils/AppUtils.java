package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class AppUtils {
    public static int getVersionCode(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
