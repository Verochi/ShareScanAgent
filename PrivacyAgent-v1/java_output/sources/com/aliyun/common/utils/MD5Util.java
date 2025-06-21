package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class MD5Util {
    private static java.lang.String getHashString(java.security.MessageDigest messageDigest) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : messageDigest.digest()) {
            sb.append(java.lang.Integer.toHexString((b >> 4) & 15));
            sb.append(java.lang.Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    public static java.lang.String getMD5(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return getHashString(messageDigest);
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
