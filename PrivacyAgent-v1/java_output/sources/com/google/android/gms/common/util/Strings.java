package com.google.android.gms.common.util;

@com.google.android.gms.common.util.VisibleForTesting
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class Strings {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("\\$\\{(.*?)\\}");

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String emptyToNull(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isEmptyOrWhitespace(@androidx.annotation.Nullable java.lang.String str) {
        return str == null || str.trim().isEmpty();
    }
}
