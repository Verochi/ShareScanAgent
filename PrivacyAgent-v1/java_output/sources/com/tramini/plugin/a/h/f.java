package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class f {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                sb.append(a[(digest[i] & 240) >>> 4]);
                sb.append(a[digest[i] & 15]);
            }
            return sb.toString().toLowerCase();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(a[(bArr[i] & 240) >>> 4]);
            sb.append(a[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
