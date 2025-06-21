package com.google.android.gms.common.api.internal;

@com.google.android.gms.common.annotation.KeepForSdk
@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class GoogleServices {
    public static final java.lang.Object e = new java.lang.Object();

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("sLock")
    public static com.google.android.gms.common.api.internal.GoogleServices f;

    @androidx.annotation.Nullable
    public final java.lang.String a;
    public final com.google.android.gms.common.api.Status b;
    public final boolean c;
    public final boolean d;

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public GoogleServices(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.d = !z2;
            z = z2;
        } else {
            this.d = false;
        }
        this.c = z;
        java.lang.String zza = com.google.android.gms.common.internal.zzt.zza(context);
        zza = zza == null ? new com.google.android.gms.common.internal.StringResourceValueReader(context).getString("google_app_id") : zza;
        if (android.text.TextUtils.isEmpty(zza)) {
            this.b = new com.google.android.gms.common.api.Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.a = null;
        } else {
            this.a = zza;
            this.b = com.google.android.gms.common.api.Status.RESULT_SUCCESS;
        }
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public GoogleServices(java.lang.String str, boolean z) {
        this.a = str;
        this.b = com.google.android.gms.common.api.Status.RESULT_SUCCESS;
        this.c = z;
        this.d = !z;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.internal.GoogleServices b(java.lang.String str) {
        com.google.android.gms.common.api.internal.GoogleServices googleServices;
        synchronized (e) {
            googleServices = f;
            if (googleServices == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new java.lang.IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String getGoogleAppId() {
        return b("getGoogleAppId").a;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.Status initialize(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        com.google.android.gms.common.api.Status status;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (e) {
            if (f == null) {
                f = new com.google.android.gms.common.api.internal.GoogleServices(context);
            }
            status = f.b;
        }
        return status;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.Status initialize(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull boolean z) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(context, "Context must not be null.");
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (e) {
            com.google.android.gms.common.api.internal.GoogleServices googleServices = f;
            if (googleServices != null) {
                return googleServices.a(str);
            }
            com.google.android.gms.common.api.internal.GoogleServices googleServices2 = new com.google.android.gms.common.api.internal.GoogleServices(str, z);
            f = googleServices2;
            return googleServices2.b;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isMeasurementEnabled() {
        com.google.android.gms.common.api.internal.GoogleServices b = b("isMeasurementEnabled");
        return b.b.isSuccess() && b.c;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return b("isMeasurementExplicitlyDisabled").d;
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public final com.google.android.gms.common.api.Status a(java.lang.String str) {
        java.lang.String str2 = this.a;
        if (str2 == null || str2.equals(str)) {
            return com.google.android.gms.common.api.Status.RESULT_SUCCESS;
        }
        java.lang.String str3 = this.a;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str3).length() + 97);
        sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        sb.append(str3);
        sb.append("'.");
        return new com.google.android.gms.common.api.Status(10, sb.toString());
    }
}
