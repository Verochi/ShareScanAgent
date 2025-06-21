package com.loc;

/* loaded from: classes23.dex */
public abstract class ck {
    com.loc.ck c;
    byte[] d = null;

    public ck() {
    }

    public ck(com.loc.ck ckVar) {
        this.c = ckVar;
    }

    public final byte[] a() throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        byte[] a = a(this.d);
        com.loc.ck ckVar = this.c;
        if (ckVar == null) {
            return a;
        }
        ckVar.d = a;
        return ckVar.a();
    }

    public abstract byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException;

    public void b(byte[] bArr) {
    }
}
