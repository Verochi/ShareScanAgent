package com.loc;

/* loaded from: classes23.dex */
public abstract class bi {
    com.loc.bi a;

    public bi() {
    }

    public bi(com.loc.bi biVar) {
        this.a = biVar;
    }

    public abstract byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        com.loc.bi biVar = this.a;
        if (biVar != null) {
            bArr = biVar.b(bArr);
        }
        return a(bArr);
    }
}
