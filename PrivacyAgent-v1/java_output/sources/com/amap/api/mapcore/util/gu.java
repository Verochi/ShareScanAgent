package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class gu {
    com.amap.api.mapcore.util.gu a;

    public gu() {
    }

    public gu(com.amap.api.mapcore.util.gu guVar) {
        this.a = guVar;
    }

    public abstract byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        com.amap.api.mapcore.util.gu guVar = this.a;
        if (guVar != null) {
            bArr = guVar.b(bArr);
        }
        return a(bArr);
    }
}
