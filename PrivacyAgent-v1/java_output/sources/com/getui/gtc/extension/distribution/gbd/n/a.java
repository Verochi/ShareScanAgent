package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String a = "0123456789ABCDEF";
    private static final java.lang.String b = "AES/CFB/NoPadding";
    private static final java.lang.String c = "AES";
    private static final java.lang.String d = "SHA1PRNG";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.a$a, reason: collision with other inner class name */
    public static class C0317a extends java.security.Provider {
        public C0317a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", androidx.exifinterface.media.ExifInterface.TAG_SOFTWARE);
        }
    }

    public static java.lang.String a() {
        try {
            byte[] bArr = new byte[20];
            java.security.SecureRandom.getInstance(d).nextBytes(bArr);
            return b(bArr);
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return null;
        }
    }

    public static java.lang.String a(byte[] bArr, java.lang.String str, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a2 = a(str);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, c);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr2);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new java.lang.String(cipher.doFinal(a2));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static void a(java.lang.StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(a.charAt((b2 >> 4) & 15));
        stringBuffer.append(a.charAt(b2 & 15));
    }

    public static byte[] a(java.lang.String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = java.lang.Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        java.security.SecureRandom secureRandom;
        try {
            javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(c);
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 28) {
                byte[] bArr2 = com.getui.gtc.extension.distribution.gbd.d.h.aB;
                if (bArr2 != null) {
                    return bArr2;
                }
                secureRandom = java.security.SecureRandom.getInstance(d);
            } else {
                secureRandom = i >= 24 ? java.security.SecureRandom.getInstance(d, new com.getui.gtc.extension.distribution.gbd.n.a.C0317a()) : java.security.SecureRandom.getInstance(d, "Crypto");
            }
            secureRandom.setSeed(bArr);
            keyGenerator.init(128, secureRandom);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            if (i >= 28 && com.getui.gtc.extension.distribution.gbd.d.h.aB == null) {
                com.getui.gtc.extension.distribution.gbd.d.h.aB = encoded;
            }
            return encoded;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr2 != null && bArr3 != null) {
            try {
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, c);
                javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr2);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return null;
    }

    private static java.lang.String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            a(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    public static java.lang.String b(byte[] bArr, java.lang.String str, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new java.lang.String(g(bArr, a(str), bArr2));
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2 == null) {
            return null;
        }
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, c);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String c(byte[] bArr, java.lang.String str, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new java.lang.String(f(bArr, a(str), bArr2));
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return null;
        }
    }

    public static java.lang.String c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return b(d(bArr, bArr2, bArr3));
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(a(bArr), c);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr2 != null && bArr3 != null) {
            try {
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, c);
                javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return b(cipher.doFinal(bArr2));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return null;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(a(bArr), c);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static byte[] g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, c);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(b);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }
}
