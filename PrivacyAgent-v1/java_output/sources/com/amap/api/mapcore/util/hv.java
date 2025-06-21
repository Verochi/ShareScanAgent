package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hv extends com.amap.api.mapcore.util.hz {
    private android.content.Context a;
    private java.lang.String b;
    private com.amap.api.mapcore.util.gu e;
    private java.lang.Object[] f;

    public hv(android.content.Context context, com.amap.api.mapcore.util.hz hzVar, com.amap.api.mapcore.util.gu guVar, java.lang.String str, java.lang.Object... objArr) {
        super(hzVar);
        this.a = context;
        this.b = str;
        this.e = guVar;
        this.f = objArr;
    }

    private java.lang.String b() {
        try {
            return java.lang.String.format(com.amap.api.mapcore.util.fi.c(this.b), this.f);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.gd.c(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.mapcore.util.hz
    public final byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        java.lang.String a = com.amap.api.mapcore.util.fi.a(bArr);
        if (android.text.TextUtils.isEmpty(a)) {
            return null;
        }
        return com.amap.api.mapcore.util.fi.a("{\"pinfo\":\"" + com.amap.api.mapcore.util.fi.a(this.e.b(com.amap.api.mapcore.util.fi.a(b()))) + "\",\"els\":[" + a + "]}");
    }
}
