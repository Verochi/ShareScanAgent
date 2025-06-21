package com.huawei.hms.framework.common.check;

/* loaded from: classes22.dex */
public class ProviderCheckUtil {
    private static java.lang.String TAG = "ProviderCheckUtil";

    public static boolean isValid(android.net.Uri uri) {
        if (uri == null) {
            return false;
        }
        android.content.pm.PackageManager packageManager = com.huawei.hms.framework.common.ContextHolder.getAppContext().getPackageManager();
        android.content.pm.ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (resolveContentProvider == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, "Invalid param");
            return false;
        }
        android.content.pm.ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        java.lang.String str = applicationInfo.packageName;
        com.huawei.hms.framework.common.Logger.v(TAG, "Target provider service's package name is : " + str);
        return str != null && packageManager.checkSignatures("com.huawei.hwid", str) == 0;
    }
}
