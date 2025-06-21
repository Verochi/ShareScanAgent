package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public final class jad_fs {
    public static final char[] jad_an = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String jad_an(java.lang.String str) {
        byte[] decode;
        return (android.text.TextUtils.isEmpty(str) || (decode = android.util.Base64.decode(str.getBytes(), 10)) == null) ? "" : new java.lang.String(decode);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[LOOP:0: B:15:0x0031->B:16:0x0033, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_bo(java.lang.String str) {
        byte[] bArr;
        int length;
        if (str == null || str.length() == 0) {
            return "";
        }
        byte[] bytes = str.getBytes();
        if (bytes != null && bytes.length > 0) {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                bArr = messageDigest.digest();
            } catch (java.security.NoSuchAlgorithmException unused) {
            }
            if (bArr != null || (length = bArr.length) <= 0) {
                return "";
            }
            char[] cArr = new char[length << 1];
            int i = 0;
            for (byte b : bArr) {
                int i2 = i + 1;
                char[] cArr2 = jad_an;
                cArr[i] = cArr2[(b >> 4) & 15];
                i = i2 + 1;
                cArr[i2] = cArr2[b & 15];
            }
            return new java.lang.String(cArr);
        }
        bArr = null;
        if (bArr != null) {
            return "";
        }
        char[] cArr3 = new char[length << 1];
        int i3 = 0;
        while (r2 < length) {
        }
        return new java.lang.String(cArr3);
    }
}
