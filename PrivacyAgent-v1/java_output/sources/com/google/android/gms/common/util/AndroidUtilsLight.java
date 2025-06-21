package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class AndroidUtilsLight {
    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(24)
    public static android.content.Context getDeviceProtectedStorageContext(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return com.google.android.gms.internal.common.zzl.zza() ? com.google.android.gms.internal.common.zzl.zza(context) : context;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static byte[] getPackageCertificateHashBytes(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        java.security.MessageDigest zza;
        android.content.pm.PackageInfo packageInfo = com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getPackageInfo(str, 64);
        android.content.pm.Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (zza = zza("SHA1")) == null) {
            return null;
        }
        return zza.digest(packageInfo.signatures[0].toByteArray());
    }

    @androidx.annotation.RecentlyNullable
    public static java.security.MessageDigest zza(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        java.security.MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = java.security.MessageDigest.getInstance(str);
            } catch (java.security.NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
