package com.google.android.gms.common.util;

@com.google.android.gms.common.util.VisibleForTesting
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class NumberUtils {
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static long parseHexLong(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (str.length() <= 16) {
            if (str.length() != 16) {
                return java.lang.Long.parseLong(str, 16);
            }
            return (java.lang.Long.parseLong(str.substring(0, 8), 16) << 32) | java.lang.Long.parseLong(str.substring(8), 16);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 37);
        sb.append("Invalid input: ");
        sb.append(str);
        sb.append(" exceeds 16 characters");
        throw new java.lang.NumberFormatException(sb.toString());
    }
}
