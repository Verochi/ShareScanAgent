package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class SharedPreferencesUtils {
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static void publishWorldReadableSharedPreferences(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.SharedPreferences.Editor editor, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        throw new java.lang.IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}
