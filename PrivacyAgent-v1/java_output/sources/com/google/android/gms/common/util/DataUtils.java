package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class DataUtils {
    @com.google.android.gms.common.annotation.KeepForSdk
    public static void copyStringToBuffer(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.database.CharArrayBuffer charArrayBuffer) {
        if (android.text.TextUtils.isEmpty(str)) {
            charArrayBuffer.sizeCopied = 0;
        } else {
            char[] cArr = charArrayBuffer.data;
            if (cArr == null || cArr.length < str.length()) {
                charArrayBuffer.data = str.toCharArray();
            } else {
                str.getChars(0, str.length(), charArrayBuffer.data, 0);
            }
        }
        charArrayBuffer.sizeCopied = str.length();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static byte[] loadImageBytes(@androidx.annotation.RecentlyNonNull android.graphics.Bitmap bitmap) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
