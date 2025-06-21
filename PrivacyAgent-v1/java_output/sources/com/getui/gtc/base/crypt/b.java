package com.getui.gtc.base.crypt;

/* loaded from: classes22.dex */
final class b {
    private javax.crypto.SecretKey a;

    public b(java.lang.String str) throws java.security.NoSuchAlgorithmException {
        this.a = com.getui.gtc.base.crypt.CryptTools.wrapperKey("RC4", com.getui.gtc.base.crypt.CryptTools.digest("MD5", str.getBytes()));
    }

    public final byte[] a(byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.InvalidAlgorithmParameterException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.security.InvalidKeyException {
        return com.getui.gtc.base.crypt.CryptTools.encrypt("RC4", this.a, (javax.crypto.spec.IvParameterSpec) null, bArr);
    }

    public final byte[] b(byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.security.InvalidAlgorithmParameterException {
        return com.getui.gtc.base.crypt.CryptTools.decrypt("RC4", this.a, (javax.crypto.spec.IvParameterSpec) null, bArr);
    }
}
