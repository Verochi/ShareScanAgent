package com.sijla.mla;

/* loaded from: classes19.dex */
final class i extends com.sijla.mla.a.b.t {
    private /* synthetic */ java.lang.String a;
    private /* synthetic */ com.sijla.mla.g b;

    public i(com.sijla.mla.g gVar, java.lang.String str) {
        this.b = gVar;
        this.a = str;
    }

    @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.r
    public final com.sijla.mla.a.y b(com.sijla.mla.a.y yVar) {
        try {
            if (yVar.e() <= 1) {
                return com.sijla.mla.e.a(com.sijla.mla.j.a(this.b.a, this.a, new java.lang.Object[0]));
            }
            int e = yVar.e() - 1;
            java.lang.Object[] objArr = new java.lang.Object[e];
            for (int i = 0; i < e; i++) {
                objArr[i] = com.sijla.mla.e.a_(yVar.c(i + 2));
            }
            return com.sijla.mla.e.a(com.sijla.mla.j.a(this.b.a, this.a, objArr));
        } catch (java.lang.Throwable th) {
            throw new com.sijla.mla.a.i(th);
        }
    }
}
