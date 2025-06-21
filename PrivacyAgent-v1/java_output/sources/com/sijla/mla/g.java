package com.sijla.mla;

/* loaded from: classes19.dex */
public final class g extends com.sijla.mla.a.q {
    private boolean c;
    private boolean d;

    public g(java.lang.Object obj) {
        super(obj);
        this.c = obj instanceof java.lang.Class;
        this.d = obj.getClass().isArray();
    }

    private com.sijla.mla.a.r t(com.sijla.mla.a.r rVar) {
        java.lang.String str;
        try {
            try {
                str = com.sijla.mla.j.a((java.lang.Class<?>) this.a);
                try {
                    return com.sijla.mla.e.a(com.sijla.mla.j.b(str, rVar.B()));
                } catch (java.lang.NoSuchFieldException unused) {
                    return new com.sijla.mla.h(this, str, rVar.B());
                }
            } catch (java.lang.Throwable th) {
                throw new com.sijla.mla.a.i(th);
            }
        } catch (java.lang.NoSuchFieldException unused2) {
            str = null;
        }
    }

    private com.sijla.mla.a.r u(com.sijla.mla.a.r rVar) {
        try {
            java.lang.Object a_ = com.sijla.mla.e.a_(rVar);
            if (com.sijla.mla.L2.s811526246().equals(a_)) {
                return com.sijla.mla.a.k.c_(((java.lang.Integer) com.sijla.mla.j.a(this.a, com.sijla.mla.L2.s811526246())).intValue());
            }
            return com.sijla.mla.e.a(com.sijla.mla.j.a(this.a, "[" + a_ + "]"));
        } catch (java.lang.Throwable th) {
            throw new com.sijla.mla.a.i(th);
        }
    }

    private com.sijla.mla.a.r v(com.sijla.mla.a.r rVar) {
        try {
            return com.sijla.mla.e.a(com.sijla.mla.j.a(this.a, rVar.B()));
        } catch (java.lang.NoSuchFieldException unused) {
            return new com.sijla.mla.i(this, rVar.B());
        } catch (java.lang.Throwable th) {
            throw new com.sijla.mla.a.i(th);
        }
    }

    @Override // com.sijla.mla.a.q, com.sijla.mla.a.r
    public final com.sijla.mla.a.r a(com.sijla.mla.a.r rVar) {
        return this.c ? t(rVar) : this.d ? u(rVar) : v(rVar);
    }

    @Override // com.sijla.mla.a.q, com.sijla.mla.a.r
    public final void a(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.i iVar;
        if (this.c) {
            try {
                com.sijla.mla.j.a(com.sijla.mla.j.a((java.lang.Class<?>) this.a), rVar.B(), com.sijla.mla.e.a_(rVar2));
                return;
            } finally {
            }
        }
        if (!this.d) {
            try {
                com.sijla.mla.j.a(this.a, rVar.B(), com.sijla.mla.e.a_(rVar2));
                return;
            } finally {
            }
        }
        try {
            java.lang.Object a_ = com.sijla.mla.e.a_(rVar);
            com.sijla.mla.j.a(this.a, "[" + a_ + "]", com.sijla.mla.e.a_(rVar2));
        } finally {
        }
    }
}
