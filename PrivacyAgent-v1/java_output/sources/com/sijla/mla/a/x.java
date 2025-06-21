package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class x extends com.sijla.mla.a.y {
    private com.sijla.mla.a.r a;
    private com.sijla.mla.a.y b;
    private com.sijla.mla.a.y c;

    public x(com.sijla.mla.a.r rVar, com.sijla.mla.a.y yVar) {
        this.a = rVar;
        this.b = yVar;
    }

    @Override // com.sijla.mla.a.y
    public final com.sijla.mla.a.y b() {
        com.sijla.mla.a.y yVar;
        while (true) {
            com.sijla.mla.a.y yVar2 = this.c;
            if (yVar2 != null) {
                return yVar2;
            }
            com.sijla.mla.a.y b = this.a.b(this.b);
            if (b.f_()) {
                com.sijla.mla.a.x xVar = (com.sijla.mla.a.x) b;
                this.a = xVar.a;
                yVar = xVar.b;
            } else {
                this.c = b;
                yVar = null;
                this.a = null;
            }
            this.b = yVar;
        }
    }

    @Override // com.sijla.mla.a.y
    public final com.sijla.mla.a.y b_(int i) {
        if (this.c == null) {
            b();
        }
        return this.c.b_(i);
    }

    @Override // com.sijla.mla.a.y
    public final com.sijla.mla.a.r c(int i) {
        if (this.c == null) {
            b();
        }
        return this.c.c(i);
    }

    @Override // com.sijla.mla.a.y
    public final int e() {
        if (this.c == null) {
            b();
        }
        return this.c.e();
    }

    @Override // com.sijla.mla.a.y
    public final boolean f_() {
        return true;
    }

    @Override // com.sijla.mla.a.y
    public final com.sijla.mla.a.r h() {
        if (this.c == null) {
            b();
        }
        return this.c.h();
    }
}
