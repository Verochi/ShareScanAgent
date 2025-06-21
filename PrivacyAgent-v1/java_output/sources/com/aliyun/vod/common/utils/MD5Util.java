package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class MD5Util {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int STREAM_BUFFER_LENGTH = 1024;

    private static java.lang.String bytesToHexStr(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            char[] cArr2 = DIGITS_UPPER;
            byte b = bArr[i];
            cArr[i2] = cArr2[(b >>> 4) & 15];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    public static byte[] encrypt(java.io.InputStream inputStream) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        return updateDigest(getDigest("MD5"), inputStream).digest();
    }

    public static byte[] encrypt(java.lang.String str) {
        return encrypt(str.getBytes());
    }

    public static byte[] encrypt(byte[] bArr) {
        try {
            java.security.MessageDigest digest = getDigest("MD5");
            digest.update(bArr);
            return digest.digest();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String encryptToHexStr(java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] bytes = str.getBytes();
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return bytesToHexStr(messageDigest.digest());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.security.MessageDigest getDigest(java.lang.String str) throws java.security.NoSuchAlgorithmException {
        return java.security.MessageDigest.getInstance(str);
    }

    private static java.security.MessageDigest updateDigest(java.security.MessageDigest messageDigest, java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= -1) {
                return messageDigest;
            }
            messageDigest.update(bArr, 0, read);
        }
    }
}
