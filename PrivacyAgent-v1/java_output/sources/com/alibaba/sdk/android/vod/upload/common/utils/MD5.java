package com.alibaba.sdk.android.vod.upload.common.utils;

/* loaded from: classes.dex */
public class MD5 {
    private static final java.lang.String TAG = "MD5";

    public static java.lang.String calculateMD5(android.content.Context context, android.net.Uri uri) {
        try {
            return calculateMD5ByStream(java.security.MessageDigest.getInstance("MD5"), context.getContentResolver().openInputStream(uri));
        } catch (java.io.FileNotFoundException | java.security.NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static java.lang.String calculateMD5(android.content.Context context, java.lang.String str) {
        return com.aliyun.vod.common.utils.StringUtils.isUriPath(str) ? calculateMD5(context, android.net.Uri.parse(str)) : calculateMD5(new java.io.File(str));
    }

    public static java.lang.String calculateMD5(java.io.File file) {
        try {
            return calculateMD5ByStream(java.security.MessageDigest.getInstance("MD5"), new java.io.FileInputStream(file));
        } catch (java.io.FileNotFoundException | java.security.NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @org.jetbrains.annotations.NotNull
    private static java.lang.String calculateMD5ByStream(java.security.MessageDigest messageDigest, java.io.InputStream inputStream) {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                    if (i >= 1048576) {
                        break;
                    }
                    i += read;
                } catch (java.io.IOException e) {
                    throw new java.lang.RuntimeException("Unable to process file for MD5", e);
                }
            } finally {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused) {
                }
            }
        }
        return java.lang.String.format("%32s", new java.math.BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
    }

    public static boolean checkMD5(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || context == null) {
            return false;
        }
        java.lang.String calculateMD5 = com.aliyun.vod.common.utils.StringUtils.isUriPath(str2) ? calculateMD5(context, android.net.Uri.parse(str2)) : calculateMD5(new java.io.File(str2));
        if (calculateMD5 == null) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Calculated digest: ");
        sb.append(calculateMD5);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Provided digest: ");
        sb2.append(str);
        return calculateMD5.equalsIgnoreCase(str);
    }

    public static boolean checkMD5(java.lang.String str, java.io.File file) {
        java.lang.String calculateMD5;
        if (android.text.TextUtils.isEmpty(str) || file == null || (calculateMD5 = calculateMD5(file)) == null) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Calculated digest: ");
        sb.append(calculateMD5);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Provided digest: ");
        sb2.append(str);
        return calculateMD5.equalsIgnoreCase(str);
    }
}
