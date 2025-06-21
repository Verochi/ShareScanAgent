package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public abstract class SHA256 {
    public static byte[] digest(java.io.File file) {
        java.security.MessageDigest messageDigest;
        java.io.BufferedInputStream bufferedInputStream;
        int i;
        java.io.InputStream inputStream = null;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                messageDigest = java.security.MessageDigest.getInstance("SHA-256");
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException | java.security.NoSuchAlgorithmException unused) {
        }
        try {
            byte[] bArr = new byte[4096];
            i = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
                i += read;
            }
        } catch (java.io.IOException | java.security.NoSuchAlgorithmException unused2) {
            bufferedInputStream2 = bufferedInputStream;
            com.huawei.hms.support.log.HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) bufferedInputStream2);
            inputStream = bufferedInputStream2;
            return new byte[0];
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = bufferedInputStream;
            com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
            throw th;
        }
        if (i > 0) {
            byte[] digest = messageDigest.digest();
            com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) bufferedInputStream);
            return digest;
        }
        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) bufferedInputStream);
        inputStream = i;
        return new byte[0];
    }

    public static byte[] digest(byte[] bArr) {
        try {
            return java.security.MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (java.security.NoSuchAlgorithmException e) {
            com.huawei.hms.support.log.HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }
}
