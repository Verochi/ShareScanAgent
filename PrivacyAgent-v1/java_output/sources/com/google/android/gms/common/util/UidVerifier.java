package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class UidVerifier {
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isGooglePlayServicesUid(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        if (!uidHasPackageName(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return com.google.android.gms.common.GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(19)
    public static boolean uidHasPackageName(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        return com.google.android.gms.common.wrappers.Wrappers.packageManager(context).zza(i, str);
    }
}
