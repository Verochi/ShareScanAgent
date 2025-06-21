package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hu extends com.amap.api.mapcore.util.hz {
    private com.amap.api.mapcore.util.gu a;

    public hu() {
        this.a = new com.amap.api.mapcore.util.gw();
    }

    public hu(com.amap.api.mapcore.util.hz hzVar) {
        super(hzVar);
        this.a = new com.amap.api.mapcore.util.gw();
    }

    @Override // com.amap.api.mapcore.util.hz
    public final byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        return this.a.b(bArr);
    }
}
