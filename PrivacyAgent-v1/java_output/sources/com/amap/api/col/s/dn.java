package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dn extends com.amap.api.col.s.ds {
    public com.amap.api.col.s.cq e;

    public dn() {
        this.e = new com.amap.api.col.s.cs();
    }

    public dn(com.amap.api.col.s.ds dsVar) {
        super(dsVar);
        this.e = new com.amap.api.col.s.cs();
    }

    @Override // com.amap.api.col.s.ds
    public final byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        return this.e.b(bArr);
    }
}
