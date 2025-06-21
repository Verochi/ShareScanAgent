package com.loc;

/* loaded from: classes23.dex */
public final class ap {
    private static byte[] a;
    private static java.lang.String[] b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
    private static int[] c = null;

    private static int a(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    public static java.lang.String a() {
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        try {
            javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(com.loc.y.c("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return com.loc.ak.a(keyGenerator.generateKey().getEncoded());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String a(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            char c2 = (char) ((i >>> (i2 * 8)) & 255);
            cArr[(4 - i2) - 1] = c2;
            java.lang.String str = " ";
            for (int i3 = 0; i3 < 32; i3++) {
                str = str + (((Integer.MIN_VALUE >>> i3) & c2) >>> (31 - i3));
            }
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String a(java.lang.String str) {
        return com.loc.t.a(str);
    }

    private static java.lang.String a(int[] iArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                sb.append(a(a(b(iArr[i]), i)));
            }
        }
        return sb.toString();
    }

    private static byte[] a(byte[] bArr) {
        try {
            if (a == null) {
                a = com.loc.y.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(a);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(a(b()).getBytes("UTF-8"), com.loc.y.c("EQUVT"));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.loc.y.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int b(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            return com.loc.ak.a(a(str.getBytes("UTF-8")));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static int[] b() {
        int[] iArr = c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i = 0;
        while (true) {
            java.lang.String[] strArr = b;
            if (i >= strArr.length) {
                return iArr2;
            }
            byte[] b2 = com.loc.q.b(strArr[i]);
            iArr2[i] = ((b2[0] & 255) << 24) | (b2[3] & 255) | ((b2[2] & 255) << 8) | ((b2[1] & 255) << 16);
            i++;
        }
    }
}
