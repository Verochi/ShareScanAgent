package com.google.android.gms.common.stats;

@com.google.android.gms.common.annotation.KeepForSdk
@java.lang.Deprecated
/* loaded from: classes22.dex */
public class WakeLockTracker {
    public static com.google.android.gms.common.stats.WakeLockTracker a = new com.google.android.gms.common.stats.WakeLockTracker();

    @com.google.android.gms.common.util.VisibleForTesting
    public static boolean b = false;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.stats.WakeLockTracker getInstance() {
        return a;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void registerAcquireEvent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.String str3, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str4) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void registerDeadlineEvent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.String str3, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.String> list, @androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull long j) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void registerEvent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.String str3, @androidx.annotation.RecentlyNonNull java.lang.String str4, @androidx.annotation.RecentlyNonNull int i2, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.String> list) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void registerEvent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.String str3, @androidx.annotation.RecentlyNonNull java.lang.String str4, @androidx.annotation.RecentlyNonNull int i2, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.String> list, @androidx.annotation.RecentlyNonNull long j) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void registerReleaseEvent(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.Intent intent) {
    }
}
