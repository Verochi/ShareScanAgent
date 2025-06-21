package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class Base64Utils {
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static byte[] decode(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (str == null) {
            return null;
        }
        return android.util.Base64.decode(str, 0);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static byte[] decodeUrlSafe(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (str == null) {
            return null;
        }
        return android.util.Base64.decode(str, 10);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static byte[] decodeUrlSafeNoPadding(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (str == null) {
            return null;
        }
        return android.util.Base64.decode(str, 11);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String encode(@androidx.annotation.RecentlyNonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return android.util.Base64.encodeToString(bArr, 0);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String encodeUrlSafe(@androidx.annotation.RecentlyNonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return android.util.Base64.encodeToString(bArr, 10);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String encodeUrlSafeNoPadding(@androidx.annotation.RecentlyNonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return android.util.Base64.encodeToString(bArr, 11);
    }
}
