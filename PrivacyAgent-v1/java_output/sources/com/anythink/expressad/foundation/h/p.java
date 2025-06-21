package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class p implements com.anythink.expressad.e.b {
    public static final java.lang.String a = "MD5";

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (byte b : digest) {
                sb.append(java.lang.Integer.toHexString((b & 240) >>> 4));
                sb.append(java.lang.Integer.toHexString(b & 15));
            }
            return sb.toString().toLowerCase(java.util.Locale.US);
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int length = bArr.length * 2;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = org.apache.tools.tar.TarConstants.LF_NORMAL;
        }
        byte[] bArr3 = new byte[bArr.length + 1];
        bArr3[0] = 0;
        java.lang.System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        byte[] bytes = new java.math.BigInteger(bArr3).toString(16).getBytes();
        java.lang.System.arraycopy(bytes, 0, bArr2, length - bytes.length, bytes.length);
        return new java.lang.String(bArr2);
    }

    private static java.lang.String b(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (byte b : digest) {
                sb.append(java.lang.Integer.toHexString((b & 240) >>> 4));
                sb.append(java.lang.Integer.toHexString(b & 15));
            }
            return sb.toString().toUpperCase(java.util.Locale.US);
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String b(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(java.lang.Integer.toHexString((b & 240) >>> 4));
            sb.append(java.lang.Integer.toHexString(b & 15));
        }
        return sb.toString().toLowerCase(java.util.Locale.US);
    }

    private static java.lang.String c(java.lang.String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-16LE");
            a(bytes);
            byte[] bArr = new byte[length];
            int i = 0;
            for (int i2 = 0; i2 < bytes.length; i2 += 2) {
                byte b = bytes[i2];
                if (b != -1 && b != -2) {
                    bArr[i] = b;
                    i++;
                    if (i == length) {
                        break;
                    }
                }
            }
            a(bArr);
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i3 = 0;
            for (byte b2 : digest) {
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                i3 = i4 + 1;
                cArr2[i4] = cArr[b2 & 15];
            }
            return new java.lang.String(cArr2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String c(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(java.lang.Integer.toHexString((b & 240) >>> 4));
            sb.append(java.lang.Integer.toHexString(b & 15));
        }
        return sb.toString().toUpperCase(java.util.Locale.US);
    }

    private static byte[] d(java.lang.String str) {
        int length = str.length();
        byte[] bytes = str.getBytes("UTF-16LE");
        a(bytes);
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < bytes.length; i2 += 2) {
            byte b = bytes[i2];
            if (b != -1 && b != -2) {
                bArr[i] = b;
                i++;
                if (i == length) {
                    break;
                }
            }
        }
        a(bArr);
        return bArr;
    }
}
