package com.sijla.mla.a;

/* loaded from: classes19.dex */
public class q extends com.sijla.mla.a.r {
    public java.lang.Object a;
    public com.sijla.mla.a.r b;

    public q(java.lang.Object obj) {
        this.a = obj;
    }

    public q(java.lang.Object obj, com.sijla.mla.a.r rVar) {
        this.a = obj;
        this.b = rVar;
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.Object U() {
        return this.a;
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.Object V() {
        return this.a;
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.r a(com.sijla.mla.a.r rVar) {
        return this.b != null ? com.sijla.mla.a.r.g(this, rVar) : com.sijla.mla.a.r.k;
    }

    @Override // com.sijla.mla.a.r
    public void a(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        if (this.b == null || !com.sijla.mla.a.r.b(this, rVar, rVar2)) {
            com.sijla.mla.a.r.d("cannot set " + rVar + " for userdata");
        }
    }

    @Override // com.sijla.mla.a.r
    public final boolean a(com.sijla.mla.a.q qVar) {
        if (this != qVar) {
            return this.b == qVar.b && this.a.equals(qVar.a);
        }
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final int a_() {
        return 7;
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String c() {
        return com.sijla.mla.L2.s2042902805();
    }

    @Override // com.sijla.mla.a.r
    public final boolean c(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.r j;
        if (rVar.a(this)) {
            return true;
        }
        return this.b != null && rVar.m_() && (j = rVar.j()) != null && com.sijla.mla.a.r.a(this, this.b, rVar, j);
    }

    @Override // com.sijla.mla.a.r
    public final boolean d(com.sijla.mla.a.r rVar) {
        return rVar.a(this);
    }

    @Override // com.sijla.mla.a.r
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.sijla.mla.a.q) {
            return this.a.equals(((com.sijla.mla.a.q) obj).a);
        }
        return false;
    }

    @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
    public final java.lang.String g() {
        return java.lang.String.valueOf(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j() {
        return this.b;
    }

    @Override // com.sijla.mla.a.r
    public final boolean m_() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r p(com.sijla.mla.a.r rVar) {
        this.b = rVar;
        return this;
    }
}
