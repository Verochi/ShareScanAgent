package com.igexin.push.g.b;

/* loaded from: classes23.dex */
public abstract class f extends com.igexin.c.a.d.f {
    long d;

    private f(long j) {
        super(5);
        this.d = j;
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public f(long j, byte b) {
        this(j);
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        h();
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }

    public abstract void h();
}
