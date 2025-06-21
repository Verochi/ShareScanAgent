package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class f {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(java.lang.String str) {
        return a(str.getBytes());
    }

    public static java.lang.String a(byte[] bArr) {
        int length;
        if (bArr != null && bArr.length > 0) {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                if (digest == null || (length = digest.length) <= 0) {
                    return null;
                }
                char[] cArr = new char[length << 1];
                int i = 0;
                for (byte b : digest) {
                    int i2 = i + 1;
                    char[] cArr2 = a;
                    cArr[i] = cArr2[(b >>> 4) & 15];
                    i = i2 + 1;
                    cArr[i2] = cArr2[b & 15];
                }
                return new java.lang.String(cArr);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }
}
