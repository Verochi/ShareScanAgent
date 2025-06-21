package com.google.android.gms.common;

@com.google.android.gms.common.internal.ShowFirstParty
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class GooglePlayServicesUtilLight {

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static final java.lang.String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean a;

    @com.google.android.gms.common.util.VisibleForTesting
    public static boolean b;

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean();
    public static final java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean();

    @com.google.android.gms.common.annotation.KeepForSdk
    public GooglePlayServicesUtilLight() {
    }

    @com.google.android.gms.common.util.VisibleForTesting
    public static int a(android.content.Context context, boolean z, int i) {
        android.content.pm.PackageInfo packageInfo;
        com.google.android.gms.common.internal.Preconditions.checkArgument(i >= 0);
        java.lang.String packageName = context.getPackageName();
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                java.lang.String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing.");
                return 9;
            }
        } else {
            packageInfo = null;
        }
        try {
            android.content.pm.PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            com.google.android.gms.common.GoogleSignatureVerifier.getInstance(context);
            if (!com.google.android.gms.common.GoogleSignatureVerifier.zza(packageInfo2, true)) {
                java.lang.String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid.");
                return 9;
            }
            if (z && (!com.google.android.gms.common.GoogleSignatureVerifier.zza((android.content.pm.PackageInfo) com.google.android.gms.common.internal.Preconditions.checkNotNull(packageInfo), true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                java.lang.String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid.");
                return 9;
            }
            if (com.google.android.gms.common.util.zza.zza(packageInfo2.versionCode) >= com.google.android.gms.common.util.zza.zza(i)) {
                android.content.pm.ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                        android.util.Log.wtf("GooglePlayServicesUtil", java.lang.String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
            int i2 = packageInfo2.versionCode;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(packageName).length() + 82);
            sb.append("Google Play services out of date for ");
            sb.append(packageName);
            sb.append(".  Requires ");
            sb.append(i);
            sb.append(" but found ");
            sb.append(i2);
            return 2;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            java.lang.String.valueOf(packageName).concat(" requires Google Play services, but they are missing.");
            return 1;
        }
    }

    @android.annotation.TargetApi(21)
    public static boolean b(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop()) {
            try {
                java.util.Iterator<android.content.pm.PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
        }
        return equals ? applicationInfo.enabled : applicationInfo.enabled && !isRestrictedUserProfile(context);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static void cancelAvailabilityErrorNotifications(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        if (c.getAndSet(true)) {
            return;
        }
        try {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (java.lang.SecurityException unused) {
        }
    }

    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static void enableUsingApkIndependentContext() {
        d.set(true);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static void ensurePlayServicesAvailable(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            android.content.Intent errorResolutionIntent = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            java.lang.StringBuilder sb = new java.lang.StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(isGooglePlayServicesAvailable);
            if (errorResolutionIntent != null) {
                throw new com.google.android.gms.common.GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
            }
            throw new com.google.android.gms.common.GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int getApkVersion(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int getClientVersion(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        com.google.android.gms.common.internal.Preconditions.checkState(true);
        return com.google.android.gms.common.util.ClientLibraryUtils.getClientVersion(context, context.getPackageName());
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static android.app.PendingIntent getErrorPendingIntent(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i2) {
        return com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2);
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.util.VisibleForTesting
    @java.lang.Deprecated
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String getErrorString(@androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.ConnectionResult.zza(i);
    }

    @androidx.annotation.RecentlyNullable
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static android.content.Intent getGooglePlayServicesAvailabilityRecoveryIntent(@androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, i, null);
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static android.content.Context getRemoteContext(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static android.content.res.Resources getRemoteResource(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean honorsDebugCertificates(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        if (!b) {
            try {
                android.content.pm.PackageInfo packageInfo = com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                com.google.android.gms.common.GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || com.google.android.gms.common.GoogleSignatureVerifier.zza(packageInfo, false) || !com.google.android.gms.common.GoogleSignatureVerifier.zza(packageInfo, true)) {
                    a = false;
                } else {
                    a = true;
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            } finally {
                b = true;
            }
        }
        return a || !com.google.android.gms.common.util.DeviceProperties.isUserBuild();
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.HideFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int isGooglePlayServicesAvailable(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static int isGooglePlayServicesAvailable(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        try {
            context.getResources().getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        } catch (java.lang.Throwable unused) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !d.get()) {
            int zzb = com.google.android.gms.common.internal.zzt.zzb(context);
            if (zzb == 0) {
                throw new java.lang.IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
            if (zzb != i2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(zzb);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new java.lang.IllegalStateException(sb.toString());
            }
        }
        return a(context, (com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(context) || com.google.android.gms.common.util.DeviceProperties.zza(context)) ? false : true, i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static boolean isGooglePlayServicesUid(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.util.UidVerifier.isGooglePlayServicesUid(context, i);
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isPlayServicesPossiblyUpdating(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return b(context, "com.google.android.gms");
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isPlayStorePossiblyUpdating(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        if (i == 9) {
            return b(context, "com.android.vending");
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(18)
    public static boolean isRestrictedUserProfile(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        android.os.Bundle applicationRestrictions;
        return com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2() && (applicationRestrictions = ((android.os.UserManager) com.google.android.gms.common.internal.Preconditions.checkNotNull(context.getSystemService(com.umeng.analytics.pro.ay.m))).getApplicationRestrictions(context.getPackageName())) != null && com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(applicationRestrictions.getString("restricted_profile"));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.util.VisibleForTesting
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isSidewinderDevice(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return com.google.android.gms.common.util.DeviceProperties.isSidewinder(context);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static boolean isUserRecoverableError(@androidx.annotation.RecentlyNonNull int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(19)
    public static boolean uidHasPackageName(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        return com.google.android.gms.common.util.UidVerifier.uidHasPackageName(context, i, str);
    }
}
