package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class ClientLibraryUtils {
    @androidx.annotation.Nullable
    public static android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str) {
        try {
            return com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getPackageInfo(str, 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int getClientVersion(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        android.os.Bundle bundle;
        android.content.pm.PackageInfo a = a(context, str);
        if (a == null || (applicationInfo = a.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isPackageSide() {
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    public static boolean zza(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        "com.google.android.gms".equals(str);
        return (com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
    }
}
