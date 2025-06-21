package com.getui.gtc.extension.distribution.gbd.n.a;

/* loaded from: classes22.dex */
public final class a {
    public static final java.lang.String a = "AESUtil2";
    private static final int b = 1000;
    private static final int c = 128;
    private static final java.lang.String d = "0123456789ABCDEF";
    private static final java.lang.String e = "AES";
    private static final java.lang.String f = "AES/ECB/PKCS5Padding";

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        javax.crypto.SecretKey generateKey;
        byte[] bArr = new byte[0];
        try {
            if (android.os.Build.VERSION.SDK_INT > 23) {
                generateKey = javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new javax.crypto.spec.PBEKeySpec(str.toCharArray(), new byte[16], 1000, 128));
            } else {
                byte[] bytes = str.getBytes();
                javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(e);
                java.security.SecureRandom secureRandom = java.security.SecureRandom.getInstance("SHA1PRNG", "Crypto");
                secureRandom.setSeed(bytes);
                keyGenerator.init(128, secureRandom);
                generateKey = keyGenerator.generateKey();
            }
            byte[] encoded = generateKey.getEncoded();
            byte[] a2 = a(str2);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(encoded, e);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(f);
            cipher.init(2, secretKeySpec);
            bArr = com.getui.gtc.extension.distribution.gbd.n.e.a(cipher.doFinal(a2));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return new java.lang.String(bArr);
    }

    private static byte[] a(java.lang.String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = java.lang.Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr) {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(e);
        java.security.SecureRandom secureRandom = java.security.SecureRandom.getInstance("SHA1PRNG", "Crypto");
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, e);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(f);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] a(char[] cArr) {
        return javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new javax.crypto.spec.PBEKeySpec(cArr, new byte[16], 1000, 128)).getEncoded();
    }
}
