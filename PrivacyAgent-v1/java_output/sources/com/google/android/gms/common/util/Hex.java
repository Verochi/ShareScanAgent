package com.google.android.gms.common.util;

@com.google.android.gms.common.internal.ShowFirstParty
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class Hex {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String bytesToStringLowercase(@androidx.annotation.RecentlyNonNull byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            int i3 = i + 1;
            char[] cArr2 = b;
            cArr[i] = cArr2[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        return new java.lang.String(cArr);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String bytesToStringUppercase(@androidx.annotation.RecentlyNonNull byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String bytesToStringUppercase(@androidx.annotation.RecentlyNonNull byte[] bArr, @androidx.annotation.RecentlyNonNull boolean z) {
        int length = bArr.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length << 1);
        for (int i = 0; i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0); i++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static byte[] stringToBytes(@androidx.annotation.RecentlyNonNull java.lang.String str) throws java.lang.IllegalArgumentException {
        int length = str.length();
        if (length % 2 != 0) {
            throw new java.lang.IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArr[i / 2] = (byte) java.lang.Integer.parseInt(str.substring(i, i2), 16);
            i = i2;
        }
        return bArr;
    }
}
