package com.sijla.mla;

/* loaded from: classes19.dex */
final class d implements com.sijla.mla.a.b.p {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ com.sijla.mla.c b;

    public d(com.sijla.mla.c cVar, android.content.Context context) {
        this.b = cVar;
        this.a = context;
    }

    @Override // com.sijla.mla.a.b.p
    public final java.io.InputStream a(java.lang.String str) {
        byte[] bArr;
        if (str.endsWith(com.sijla.mla.L2.s1019206006())) {
            str = str.replace(com.sijla.mla.L2.s1019206006(), "");
        }
        try {
            bArr = com.sijla.mla.c.a(this.a, str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            return new java.io.ByteArrayInputStream(bArr);
        }
        return null;
    }
}
