package com.google.android.gms.common.wrappers;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class PackageManagerWrapper {
    public final android.content.Context a;

    public PackageManagerWrapper(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        this.a = context;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public int checkCallingOrSelfPermission(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        return this.a.checkCallingOrSelfPermission(str);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public int checkPermission(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.content.pm.ApplicationInfo getApplicationInfo(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull int i) throws android.content.pm.PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.CharSequence getApplicationLabel(@androidx.annotation.RecentlyNonNull java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.content.pm.PackageInfo getPackageInfo(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull int i) throws android.content.pm.PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isCallerInstantApp() {
        java.lang.String nameForUid;
        boolean isInstantApp;
        if (android.os.Binder.getCallingUid() == android.os.Process.myUid()) {
            return com.google.android.gms.common.wrappers.InstantApps.isInstantApp(this.a);
        }
        if (!com.google.android.gms.common.util.PlatformVersion.isAtLeastO() || (nameForUid = this.a.getPackageManager().getNameForUid(android.os.Binder.getCallingUid())) == null) {
            return false;
        }
        isInstantApp = this.a.getPackageManager().isInstantApp(nameForUid);
        return isInstantApp;
    }

    @androidx.annotation.RecentlyNonNull
    @android.annotation.TargetApi(19)
    public final boolean zza(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastKitKat()) {
            try {
                android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) this.a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new java.lang.NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i, str);
                return true;
            } catch (java.lang.SecurityException unused) {
                return false;
            }
        }
        java.lang.String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (java.lang.String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
