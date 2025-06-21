package com.igexin.c.a.d;

/* loaded from: classes22.dex */
public abstract class b implements com.igexin.c.a.d.a.e {
    private volatile boolean a;
    private long b;
    protected java.lang.String y = getClass().getName();

    @Override // com.igexin.c.a.d.a.e
    public final void a(boolean z) {
        this.a = !z;
    }

    @Override // com.igexin.c.a.d.a.e
    public final void b(long j) {
        this.b = j;
    }

    @Override // com.igexin.c.a.d.a.e
    public final boolean j() {
        return this.a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final long k() {
        return this.b;
    }
}
