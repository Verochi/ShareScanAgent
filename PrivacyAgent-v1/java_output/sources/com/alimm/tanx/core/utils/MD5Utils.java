package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class MD5Utils implements com.alimm.tanx.core.utils.NotConfused {
    public static final java.lang.String ALGORIGTHM_MD5 = "MD5";
    public static final java.lang.String EMPTY_CONTENT_MD5 = "d41d8cd98f00b204e9800998ecf8427e";
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    private static void appendHexPair(byte b, java.lang.StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static java.lang.String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static java.lang.String bytesToHex(byte[] bArr, int i, int i2) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static java.lang.String getFileMD5String(java.io.File file) throws java.io.IOException {
        java.security.MessageDigest mD5Digest = getMD5Digest();
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                fileInputStream.close();
                return bytesToHex(mD5Digest.digest());
            }
            mD5Digest.update(bArr, 0, read);
        }
    }

    public static java.lang.String getFilePathMD5String(java.lang.String str) {
        try {
            byte[] bArr = new byte[8192];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return new java.math.BigInteger(1, messageDigest.digest()).toString(16);
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.security.MessageDigest getMD5Digest() {
        try {
            return java.security.MessageDigest.getInstance("MD5");
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String getMD5String(java.lang.String str) {
        return str == null ? "" : getMD5String(str.getBytes());
    }

    public static java.lang.String getMD5String(byte[] bArr) {
        java.security.MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr);
        return bytesToHex(mD5Digest.digest());
    }

    public static java.lang.String getMD5String(byte[] bArr, int i, int i2) {
        java.security.MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr, i, i2);
        return bytesToHex(mD5Digest.digest());
    }
}
