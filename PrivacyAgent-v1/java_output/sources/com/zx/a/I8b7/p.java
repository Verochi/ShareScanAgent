package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class p {
    public static final java.security.SecureRandom a = new java.security.SecureRandom();

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(str2, str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        } catch (java.security.NoSuchAlgorithmException e) {
            com.zx.a.I8b7.r2.a(e);
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str, boolean z) throws java.lang.Throwable {
        if (!z) {
            str = a("MD5", str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        }
        java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a(str);
        a2.append(com.zx.a.I8b7.m3.h);
        byte[] bytes = a2.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA256");
        messageDigest.update(bytes);
        java.lang.String a3 = a(messageDigest.digest());
        return a3.substring(0, 16) + a3.substring(a3.length() - 16);
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr) throws java.security.NoSuchAlgorithmException {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return a(messageDigest.digest());
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                sb.append("0");
            }
            sb.append(java.lang.Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static java.lang.String a(byte[] bArr, javax.crypto.SecretKey secretKey, java.lang.String str) throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKey, new javax.crypto.spec.GCMParameterSpec(128, bArr, 0, 12));
        cipher.updateAAD(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return new java.lang.String(cipher.doFinal(bArr, 12, bArr.length - 12), java.nio.charset.StandardCharsets.UTF_8);
    }

    public static javax.crypto.SecretKey a(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
            mac.init(new javax.crypto.spec.SecretKeySpec(str.getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] bArr2 = new byte[16];
            java.lang.System.arraycopy(mac.doFinal(bArr), 0, bArr2, 0, 16);
            return new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
            return null;
        }
    }

    public static byte[] a(java.lang.String str, javax.crypto.SecretKey secretKey, java.lang.String str2) throws java.lang.Exception {
        byte[] bArr = new byte[12];
        a.nextBytes(bArr);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKey, new javax.crypto.spec.GCMParameterSpec(128, bArr));
        cipher.updateAAD(str2.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        byte[] doFinal = cipher.doFinal(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(doFinal.length + 12);
        allocate.put(bArr);
        allocate.put(doFinal);
        return allocate.array();
    }

    public static byte[] a(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static javax.crypto.SecretKey b(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
            mac.init(new javax.crypto.spec.SecretKeySpec(str.getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
            return new javax.crypto.spec.SecretKeySpec(mac.doFinal(bArr), "AES");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
            return null;
        }
    }

    public static byte[] b(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }
}
