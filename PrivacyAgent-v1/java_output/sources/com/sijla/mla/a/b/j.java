package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public abstract class j extends com.sijla.mla.a.j {
    protected int d;
    protected java.lang.String e;

    public static void a(com.sijla.mla.a.r rVar, java.lang.Class cls, java.lang.String[] strArr) {
        a(rVar, cls, strArr, 0);
    }

    public static void a(com.sijla.mla.a.r rVar, java.lang.Class cls, java.lang.String[] strArr, int i) {
        try {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                com.sijla.mla.a.b.j jVar = (com.sijla.mla.a.b.j) cls.newInstance();
                jVar.d = i + i2;
                java.lang.String str = strArr[i2];
                jVar.e = str;
                rVar.a(str, jVar);
            }
        } catch (java.lang.Exception e) {
            throw new com.sijla.mla.a.i("bind failed: ".concat(java.lang.String.valueOf(e)));
        }
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.r a(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2, com.sijla.mla.a.r rVar3) {
        return b(rVar, rVar2);
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
        int e = yVar.e();
        return e != 0 ? e != 1 ? e != 2 ? e != 3 ? b(yVar.h(), yVar.c(2), yVar.c(3), yVar.c(4)) : a(yVar.h(), yVar.c(2), yVar.c(3)) : b(yVar.h(), yVar.c(2)) : b(yVar.h()) : m();
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
        return m();
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        return b(rVar);
    }

    public com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2, com.sijla.mla.a.r rVar3, com.sijla.mla.a.r rVar4) {
        return a(rVar, rVar2, rVar3);
    }

    @Override // com.sijla.mla.a.j, com.sijla.mla.a.r, com.sijla.mla.a.y
    public java.lang.String g() {
        java.lang.String str = this.e;
        return str != null ? str : super.g();
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.r m() {
        return com.sijla.mla.a.r.a(1, com.sijla.mla.L2.s713458829());
    }
}
