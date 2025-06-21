package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class DownloadDigestUtils {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static byte[] hexStringToBytes(java.lang.String str) throws java.lang.IllegalArgumentException {
        if (str == null || str.length() % 2 == 1) {
            throw new java.lang.IllegalArgumentException("hexBinary needs to be even-length: ".concat(java.lang.String.valueOf(str)));
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((java.lang.Character.digit(charArray[i], 16) << 4) + java.lang.Character.digit(charArray[i + 1], 16));
        }
        return bArr;
    }

    public static java.lang.String md5Hex(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(null);
                return null;
            }
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        java.lang.String hexString = toHexString(messageDigest.digest());
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(fileInputStream);
                        return hexString;
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (java.lang.Exception unused) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(fileInputStream);
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(fileInputStream2);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.lang.String md5Hex(java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.lang.String md5Hex(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    return toHexString(messageDigest.digest());
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.lang.String md5Hex(byte[] bArr, int i, int i2) {
        if (bArr != null && i >= 0 && i2 > 0) {
            try {
                if (i + i2 <= bArr.length) {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr, i, i2);
                    return toHexString(messageDigest.digest());
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.lang.String toHexString(byte[] bArr) {
        if (bArr != null) {
            return toHexString(bArr, 0, bArr.length);
        }
        throw new java.lang.NullPointerException("bytes is null");
    }

    public static java.lang.String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new java.lang.String(cArr, 0, i3);
    }
}
