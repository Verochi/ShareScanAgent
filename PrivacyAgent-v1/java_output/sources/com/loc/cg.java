package com.loc;

/* loaded from: classes23.dex */
public final class cg extends com.loc.ck {
    private android.content.Context a;
    private java.lang.String b;
    private com.loc.bi e;
    private java.lang.Object[] f;

    public cg(android.content.Context context, com.loc.ck ckVar, com.loc.bi biVar, java.lang.String str, java.lang.Object... objArr) {
        super(ckVar);
        this.a = context;
        this.b = str;
        this.e = biVar;
        this.f = objArr;
    }

    private java.lang.String b() {
        try {
            return java.lang.String.format(com.loc.y.c(this.b), this.f);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.loc.aw.b(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.loc.ck
    public final byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        java.lang.String a = com.loc.y.a(bArr);
        if (android.text.TextUtils.isEmpty(a)) {
            return null;
        }
        return com.loc.y.a("{\"pinfo\":\"" + com.loc.y.a(this.e.b(com.loc.y.a(b()))) + "\",\"els\":[" + a + "]}");
    }
}
