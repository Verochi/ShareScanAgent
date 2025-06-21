package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class g {
    public static final java.lang.String a = "MD5";
    private static char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                sb.append(java.lang.Integer.toHexString((b2 & 240) >>> 4));
                sb.append(java.lang.Integer.toHexString(b2 & 15));
            }
            return sb.toString().toLowerCase(java.util.Locale.US);
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(java.lang.Integer.toHexString((b2 & 240) >>> 4));
            sb.append(java.lang.Integer.toHexString(b2 & 15));
        }
        return sb.toString().toLowerCase(java.util.Locale.US);
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                sb.append(java.lang.Integer.toHexString((b2 & 240) >>> 4));
                sb.append(java.lang.Integer.toHexString(b2 & 15));
            }
            return sb.toString().toUpperCase(java.util.Locale.US);
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String b(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(java.lang.Integer.toHexString((b2 & 240) >>> 4));
            sb.append(java.lang.Integer.toHexString(b2 & 15));
        }
        return sb.toString().toUpperCase(java.util.Locale.US);
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                sb.append(b[(digest[i] & 240) >>> 4]);
                sb.append(b[digest[i] & 15]);
            }
            return sb.toString().toLowerCase();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String c(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(b[(bArr[i] & 240) >>> 4]);
            sb.append(b[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
