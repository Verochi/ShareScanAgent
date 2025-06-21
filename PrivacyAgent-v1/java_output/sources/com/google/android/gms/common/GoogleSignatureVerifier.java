package com.google.android.gms.common;

@com.google.android.gms.common.internal.ShowFirstParty
@com.google.android.gms.common.annotation.KeepForSdk
@javax.annotation.CheckReturnValue
/* loaded from: classes22.dex */
public class GoogleSignatureVerifier {

    @javax.annotation.Nullable
    public static com.google.android.gms.common.GoogleSignatureVerifier c;
    public final android.content.Context a;
    public volatile java.lang.String b;

    public GoogleSignatureVerifier(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    @javax.annotation.Nullable
    public static com.google.android.gms.common.zzd a(android.content.pm.PackageInfo packageInfo, com.google.android.gms.common.zzd... zzdVarArr) {
        android.content.pm.Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        com.google.android.gms.common.zzg zzgVar = new com.google.android.gms.common.zzg(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzdVarArr.length; i++) {
            if (zzdVarArr[i].equals(zzgVar)) {
                return zzdVarArr[i];
            }
        }
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.GoogleSignatureVerifier getInstance(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(context);
        synchronized (com.google.android.gms.common.GoogleSignatureVerifier.class) {
            if (c == null) {
                com.google.android.gms.common.zzc.c(context);
                c = new com.google.android.gms.common.GoogleSignatureVerifier(context);
            }
        }
        return c;
    }

    @androidx.annotation.RecentlyNonNull
    public static boolean zza(@androidx.annotation.RecentlyNonNull android.content.pm.PackageInfo packageInfo, @androidx.annotation.RecentlyNonNull boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? a(packageInfo, com.google.android.gms.common.zzi.a) : a(packageInfo, com.google.android.gms.common.zzi.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    public final com.google.android.gms.common.zzl b(java.lang.String str, boolean z, boolean z2) {
        com.google.android.gms.common.zzl b;
        android.content.pm.ApplicationInfo applicationInfo;
        if (str == null) {
            return com.google.android.gms.common.zzl.b("null pkg");
        }
        if (str.equals(this.b)) {
            return com.google.android.gms.common.zzl.a();
        }
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(str, 64);
            boolean honorsDebugCertificates = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(this.a);
            if (packageInfo == null) {
                b = com.google.android.gms.common.zzl.b("null pkg");
            } else {
                android.content.pm.Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length != 1) {
                    b = com.google.android.gms.common.zzl.b("single cert required");
                } else {
                    com.google.android.gms.common.zzg zzgVar = new com.google.android.gms.common.zzg(packageInfo.signatures[0].toByteArray());
                    java.lang.String str2 = packageInfo.packageName;
                    com.google.android.gms.common.zzl a = com.google.android.gms.common.zzc.a(str2, zzgVar, honorsDebugCertificates, false);
                    b = (!a.a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !com.google.android.gms.common.zzc.a(str2, zzgVar, false, true).a) ? a : com.google.android.gms.common.zzl.b("debuggable release cert app rejected");
                }
            }
            if (b.a) {
                this.b = str;
            }
            return b;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            return com.google.android.gms.common.zzl.c(str.length() != 0 ? "no pkg ".concat(str) : new java.lang.String("no pkg "), e);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isGooglePublicSignedPackage(@androidx.annotation.RecentlyNonNull android.content.pm.PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        return zza(packageInfo, true) && com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(this.a);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isPackageGoogleSigned(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        com.google.android.gms.common.zzl b = b(str, false, false);
        b.g();
        return b.a;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isUidGoogleSigned(@androidx.annotation.RecentlyNonNull int i) {
        com.google.android.gms.common.zzl b;
        java.lang.String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            int length = packagesForUid.length;
            b = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    b = (com.google.android.gms.common.zzl) com.google.android.gms.common.internal.Preconditions.checkNotNull(b);
                    break;
                }
                b = b(packagesForUid[i2], false, false);
                if (b.a) {
                    break;
                }
                i2++;
            }
        } else {
            b = com.google.android.gms.common.zzl.b("no pkgs");
        }
        b.g();
        return b.a;
    }
}
