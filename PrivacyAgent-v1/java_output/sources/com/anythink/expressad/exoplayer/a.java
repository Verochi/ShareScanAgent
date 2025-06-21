package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public abstract class a implements com.anythink.expressad.exoplayer.y, com.anythink.expressad.exoplayer.z {
    private final int n;
    private com.anythink.expressad.exoplayer.aa o;
    private int p;
    private int q;
    private com.anythink.expressad.exoplayer.h.y r;

    /* renamed from: s, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m[] f202s;
    private long t;
    private boolean u = true;
    private boolean v;

    public a(int i) {
        this.n = i;
    }

    public static boolean a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<?> gVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (gVar == null) {
            return false;
        }
        return gVar.a(eVar);
    }

    @Override // com.anythink.expressad.exoplayer.y, com.anythink.expressad.exoplayer.z
    public final int a() {
        return this.n;
    }

    public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
        int a = this.r.a(nVar, eVar, z);
        if (a == -4) {
            if (eVar.c()) {
                this.u = true;
                return this.v ? -4 : -3;
            }
            eVar.f += this.t;
        } else if (a == -5) {
            com.anythink.expressad.exoplayer.m mVar = nVar.a;
            long j = mVar.l;
            if (j != Long.MAX_VALUE) {
                nVar.a = mVar.a(j + this.t);
            }
        }
        return a;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(int i) {
        this.p = i;
    }

    @Override // com.anythink.expressad.exoplayer.x.b
    public void a(int i, java.lang.Object obj) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j) {
        this.v = false;
        this.u = false;
        a(j, false);
    }

    public void a(long j, boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(com.anythink.expressad.exoplayer.aa aaVar, com.anythink.expressad.exoplayer.m[] mVarArr, com.anythink.expressad.exoplayer.h.y yVar, long j, boolean z, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(this.q == 0);
        this.o = aaVar;
        this.q = 1;
        a(z);
        a(mVarArr, yVar, j2);
        a(j, z);
    }

    public void a(boolean z) {
    }

    public void a(com.anythink.expressad.exoplayer.m[] mVarArr, long j) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(com.anythink.expressad.exoplayer.m[] mVarArr, com.anythink.expressad.exoplayer.h.y yVar, long j) {
        com.anythink.expressad.exoplayer.k.a.b(!this.v);
        this.r = yVar;
        this.u = false;
        this.f202s = mVarArr;
        this.t = j;
        a(mVarArr, j);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final int a_() {
        return this.q;
    }

    public final int b(long j) {
        return this.r.a(j - this.t);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.z b() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void b_() {
        com.anythink.expressad.exoplayer.k.a.b(this.q == 1);
        this.q = 2;
        n();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public com.anythink.expressad.exoplayer.k.n c() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.h.y f() {
        return this.r;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean g() {
        return this.u;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void h() {
        this.v = true;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean i() {
        return this.v;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void j() {
        this.r.c();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void k() {
        com.anythink.expressad.exoplayer.k.a.b(this.q == 2);
        this.q = 1;
        o();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void l() {
        com.anythink.expressad.exoplayer.k.a.b(this.q == 1);
        this.q = 0;
        this.r = null;
        this.f202s = null;
        this.v = false;
        p();
    }

    @Override // com.anythink.expressad.exoplayer.z
    public int m() {
        return 0;
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public final com.anythink.expressad.exoplayer.m[] q() {
        return this.f202s;
    }

    public final com.anythink.expressad.exoplayer.aa r() {
        return this.o;
    }

    public final int s() {
        return this.p;
    }

    public final boolean t() {
        return this.u ? this.v : this.r.b();
    }
}
