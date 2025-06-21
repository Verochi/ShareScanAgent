package com.google.android.gms.common.stats;

@com.google.android.gms.common.annotation.KeepForSdk
@java.lang.Deprecated
/* loaded from: classes22.dex */
public class StatsUtils {
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String getEventKey(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.Intent intent) {
        return java.lang.String.valueOf(java.lang.System.identityHashCode(intent) | (java.lang.System.identityHashCode(context) << 32));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String getEventKey(@androidx.annotation.RecentlyNonNull android.os.PowerManager.WakeLock wakeLock, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.String.valueOf((android.os.Process.myPid() << 32) | java.lang.System.identityHashCode(wakeLock)));
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new java.lang.String(valueOf);
    }
}
