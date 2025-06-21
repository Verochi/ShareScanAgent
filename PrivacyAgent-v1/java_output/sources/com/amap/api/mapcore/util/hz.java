package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class hz {
    com.amap.api.mapcore.util.hz c;
    byte[] d = null;

    public hz() {
    }

    public hz(com.amap.api.mapcore.util.hz hzVar) {
        this.c = hzVar;
    }

    public final byte[] a() throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        byte[] a = a(this.d);
        com.amap.api.mapcore.util.hz hzVar = this.c;
        if (hzVar == null) {
            return a;
        }
        hzVar.d = a;
        return hzVar.a();
    }

    public abstract byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException;

    public void b(byte[] bArr) {
    }
}
