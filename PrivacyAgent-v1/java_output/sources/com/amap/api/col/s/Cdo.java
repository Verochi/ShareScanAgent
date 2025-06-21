package com.amap.api.col.s;

/* renamed from: com.amap.api.col.s.do, reason: invalid class name */
/* loaded from: classes12.dex */
public final class Cdo extends com.amap.api.col.s.ds {
    public android.content.Context e;
    public java.lang.String f;
    public com.amap.api.col.s.cq g;
    public java.lang.Object[] h;

    public Cdo(android.content.Context context, com.amap.api.col.s.ds dsVar, com.amap.api.col.s.cq cqVar, java.lang.String str, java.lang.Object... objArr) {
        super(dsVar);
        this.e = context;
        this.f = str;
        this.g = cqVar;
        this.h = objArr;
    }

    @Override // com.amap.api.col.s.ds
    public final byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        java.lang.String a = com.amap.api.col.s.bu.a(bArr);
        if (android.text.TextUtils.isEmpty(a)) {
            return null;
        }
        return com.amap.api.col.s.bu.a("{\"pinfo\":\"" + com.amap.api.col.s.bu.a(this.g.b(com.amap.api.col.s.bu.a(c()))) + "\",\"els\":[" + a + "]}");
    }

    public final java.lang.String c() {
        try {
            return java.lang.String.format(com.amap.api.col.s.bu.c(this.f), this.h);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.col.s.cj.c(th, "ofm", "gpj");
            return "";
        }
    }
}
