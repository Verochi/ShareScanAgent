package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class a {
    private static final java.lang.String a = "ebmclXzZOhtU2sRlZxGL8A";
    private static byte[] b = new byte[32];
    private static byte[] c = new byte[16];

    /* renamed from: com.anythink.expressad.foundation.h.a$a, reason: collision with other inner class name */
    public static class C0214a extends java.security.Provider {
        public C0214a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", androidx.exifinterface.media.ExifInterface.TAG_SOFTWARE);
        }
    }

    static {
        if (android.text.TextUtils.isEmpty(a)) {
            return;
        }
        try {
            byte[] digest = java.security.MessageDigest.getInstance("sha-384").digest(a.getBytes());
            java.lang.System.arraycopy(digest, 0, b, 0, 32);
            java.lang.System.arraycopy(digest, 32, c, 0, 16);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static java.lang.String a(java.lang.String str) {
        return a(str, b, c);
    }

    private static java.lang.String a(java.lang.String str, byte[] bArr, byte[] bArr2) {
        try {
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr2);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            java.security.Security.addProvider(new com.anythink.expressad.foundation.h.a.C0214a());
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new java.lang.String(android.util.Base64.encode(cipher.doFinal(str.getBytes()), 0));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.String str = "";
        for (byte b2 : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str;
    }

    private static java.lang.String b(java.lang.String str, byte[] bArr, byte[] bArr2) {
        try {
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr2);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new java.lang.String(cipher.doFinal(android.util.Base64.decode(str, 0)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] digest = java.security.MessageDigest.getInstance("sha-384").digest(str.getBytes());
            java.lang.System.arraycopy(digest, 0, b, 0, 32);
            java.lang.System.arraycopy(digest, 32, c, 0, 16);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static java.lang.String c(java.lang.String str) {
        return b(str, b, c);
    }

    private static byte[] d(java.lang.String str) {
        java.lang.String upperCase = str.trim().replace(" ", "").toUpperCase(java.util.Locale.US);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) (java.lang.Integer.decode("0x" + upperCase.substring(i2, i3) + upperCase.substring(i3, i3 + 1)).intValue() & 255);
        }
        return bArr;
    }
}
