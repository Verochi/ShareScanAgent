package com.efs.sdk.net.b;

/* loaded from: classes22.dex */
public final class a {
    public static long a(java.util.Map<java.lang.String, java.lang.Long> map, java.lang.String str, java.lang.String str2) {
        if (!map.containsKey(str) || !map.containsKey(str2)) {
            return 0L;
        }
        return map.get(str2).longValue() - map.get(str).longValue();
    }

    public static java.lang.String a(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        try {
            return java.lang.String.format(java.util.Locale.CHINA, "%032x", new java.math.BigInteger(1, java.security.MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (java.security.NoSuchAlgorithmException e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "md5 error", e);
            return "";
        }
    }

    public static java.lang.String a(byte[] bArr) {
        return new java.lang.String(android.util.Base64.encode(bArr, 11));
    }

    public static boolean a(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new java.util.Random().nextInt(100) <= i;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            return null;
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
        }
        return bArr3;
    }
}
