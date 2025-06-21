package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class SystemUtils {
    public static boolean checkServiceExists(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            for (android.content.pm.ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
