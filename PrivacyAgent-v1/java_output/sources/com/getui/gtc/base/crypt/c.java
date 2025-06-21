package com.getui.gtc.base.crypt;

/* loaded from: classes22.dex */
public final class c {
    java.security.KeyPair a;
    private com.getui.gtc.base.crypt.b b;
    private java.io.File c;

    public c(android.content.Context context, java.security.KeyPair keyPair) throws java.security.NoSuchAlgorithmException {
        this.c = context.getFilesDir();
        this.a = keyPair;
        if (keyPair == null) {
            this.b = new com.getui.gtc.base.crypt.b(context.getPackageName());
        }
    }

    public final javax.crypto.SecretKey a(java.lang.String str) throws java.security.InvalidKeyException, javax.crypto.BadPaddingException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.io.IOException, java.security.InvalidAlgorithmParameterException {
        return a(str, true, this.a);
    }

    public final javax.crypto.SecretKey a(java.lang.String str, boolean z, java.security.KeyPair keyPair) throws java.security.InvalidKeyException, javax.crypto.BadPaddingException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.io.IOException, java.security.InvalidAlgorithmParameterException {
        byte[] b;
        java.io.File file = new java.io.File(this.c, str);
        if (!file.exists() && z) {
            javax.crypto.SecretKey generateKey = com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128);
            byte[] encoded = generateKey.getEncoded();
            java.security.KeyPair keyPair2 = this.a;
            com.getui.gtc.base.util.io.IOUtils.saveToFile(keyPair2 != null ? com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), encoded) : this.b.a(encoded), new java.io.File(this.c, str));
            return generateKey;
        }
        try {
            byte[] readFile = com.getui.gtc.base.util.io.IOUtils.readFile(file);
            if (keyPair == null && (keyPair = this.a) == null) {
                b = this.b.b(readFile);
                return com.getui.gtc.base.crypt.CryptTools.wrapperKey("AES", b);
            }
            b = com.getui.gtc.base.crypt.CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), readFile);
            return com.getui.gtc.base.crypt.CryptTools.wrapperKey("AES", b);
        } catch (java.io.IOException | java.security.InvalidAlgorithmParameterException unused) {
            return null;
        }
    }

    public final javax.crypto.spec.IvParameterSpec b(java.lang.String str, boolean z, java.security.KeyPair keyPair) throws javax.crypto.IllegalBlockSizeException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.io.IOException, java.security.InvalidAlgorithmParameterException {
        byte[] b;
        java.io.File file = new java.io.File(this.c, str);
        if (!file.exists() && z) {
            byte[] bArr = new byte[16];
            new java.security.SecureRandom().nextBytes(bArr);
            java.security.KeyPair keyPair2 = this.a;
            com.getui.gtc.base.util.io.IOUtils.saveToFile(keyPair2 != null ? com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), bArr) : this.b.a(bArr), new java.io.File(this.c, str));
            return new javax.crypto.spec.IvParameterSpec(bArr);
        }
        try {
            byte[] readFile = com.getui.gtc.base.util.io.IOUtils.readFile(file);
            if (keyPair == null && (keyPair = this.a) == null) {
                b = this.b.b(readFile);
                return new javax.crypto.spec.IvParameterSpec(b);
            }
            b = com.getui.gtc.base.crypt.CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), readFile);
            return new javax.crypto.spec.IvParameterSpec(b);
        } catch (java.io.IOException | java.security.InvalidAlgorithmParameterException unused) {
            return null;
        }
    }
}
