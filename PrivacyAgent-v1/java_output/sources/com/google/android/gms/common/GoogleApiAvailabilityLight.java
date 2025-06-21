package com.google.android.gms.common;

@com.google.android.gms.common.internal.ShowFirstParty
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class GoogleApiAvailabilityLight {

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = com.google.android.gms.common.GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final com.google.android.gms.common.GoogleApiAvailabilityLight a = new com.google.android.gms.common.GoogleApiAvailabilityLight();

    @com.google.android.gms.common.annotation.KeepForSdk
    public GoogleApiAvailabilityLight() {
    }

    @com.google.android.gms.common.util.VisibleForTesting
    public static java.lang.String a(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            try {
                sb.append(com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.GoogleApiAvailabilityLight getInstance() {
        return a;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void cancelAvailabilityErrorNotifications(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        com.google.android.gms.common.GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public int getApkVersion(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public int getClientVersion(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.getClientVersion(context);
    }

    @androidx.annotation.RecentlyNullable
    @java.lang.Deprecated
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.content.Intent getErrorResolutionIntent(@androidx.annotation.RecentlyNonNull int i) {
        return getErrorResolutionIntent(null, i, null);
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.content.Intent getErrorResolutionIntent(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable java.lang.String str) {
        if (i == 1 || i == 2) {
            return (context == null || !com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(context)) ? com.google.android.gms.common.internal.zzj.zza("com.google.android.gms", a(context, str)) : com.google.android.gms.common.internal.zzj.zza();
        }
        if (i != 3) {
            return null;
        }
        return com.google.android.gms.common.internal.zzj.zza("com.google.android.gms");
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.app.PendingIntent getErrorResolutionPendingIntent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull int i2) {
        return getErrorResolutionPendingIntent(context, i, i2, null);
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.app.PendingIntent getErrorResolutionPendingIntent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull int i2, @androidx.annotation.Nullable java.lang.String str) {
        android.content.Intent errorResolutionIntent = getErrorResolutionIntent(context, i, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return android.app.PendingIntent.getActivity(context, i2, errorResolutionIntent, 134217728);
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getErrorString(@androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.getErrorString(i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.HideFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public int isGooglePlayServicesAvailable(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public int isGooglePlayServicesAvailable(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        int isGooglePlayServicesAvailable = com.google.android.gms.common.GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (com.google.android.gms.common.GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isPlayServicesPossiblyUpdating(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isPlayStorePossiblyUpdating(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isUninstalledAppPossiblyUpdating(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.b(context, str);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isUserResolvableError(@androidx.annotation.RecentlyNonNull int i) {
        return com.google.android.gms.common.GooglePlayServicesUtilLight.isUserRecoverableError(i);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void verifyGooglePlayServicesIsAvailable(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull int i) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        com.google.android.gms.common.GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i);
    }
}
