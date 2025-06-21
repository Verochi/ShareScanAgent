package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class cq {
    public com.amap.api.col.s.cq a;

    public cq() {
    }

    public cq(com.amap.api.col.s.cq cqVar) {
        this.a = cqVar;
    }

    public abstract byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        com.amap.api.col.s.cq cqVar = this.a;
        if (cqVar != null) {
            bArr = cqVar.b(bArr);
        }
        return a(bArr);
    }
}
