package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class ds {
    public com.amap.api.col.s.ds c;
    public byte[] d = null;

    public ds() {
    }

    public ds(com.amap.api.col.s.ds dsVar) {
        this.c = dsVar;
    }

    public final byte[] a() throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        byte[] a = a(this.d);
        com.amap.api.col.s.ds dsVar = this.c;
        if (dsVar == null) {
            return a;
        }
        dsVar.d = a;
        return dsVar.a();
    }

    public abstract byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException;

    public void b(byte[] bArr) {
    }
}
