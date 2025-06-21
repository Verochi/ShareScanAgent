package com.efs.sdk.base.core.util.secure;

/* loaded from: classes22.dex */
public final class a {
    private static final javax.crypto.spec.IvParameterSpec a = new javax.crypto.spec.IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    private static javax.crypto.spec.SecretKeySpec a(java.lang.String str) {
        return new javax.crypto.spec.SecretKeySpec(str.getBytes(), "AES");
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) {
        try {
            return b(str.getBytes("UTF-8"), str2);
        } catch (java.io.UnsupportedEncodingException e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "getBytes error", e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec a2 = a(str);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, a2, a);
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.BadPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.NoSuchPaddingException e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "aes decrypt error", e);
            return null;
        }
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

    public static byte[] b(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec a2 = a(str);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, a2, a);
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.BadPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.NoSuchPaddingException e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "aes encrypt error", e);
            return null;
        }
    }
}
