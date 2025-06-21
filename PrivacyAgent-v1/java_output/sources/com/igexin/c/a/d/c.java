package com.igexin.c.a.d;

/* loaded from: classes22.dex */
public abstract class c implements com.igexin.c.a.d.a.g {
    protected boolean a = true;

    @Override // com.igexin.c.a.d.a.g
    public final boolean a(long j, com.igexin.c.a.d.f fVar) {
        return java.util.concurrent.TimeUnit.SECONDS.toMillis((long) fVar.B) < j - fVar.z;
    }

    @Override // com.igexin.c.a.d.a.g
    public final long b(long j, com.igexin.c.a.d.f fVar) {
        return (java.util.concurrent.TimeUnit.SECONDS.toMillis(fVar.B) + fVar.z) - j;
    }

    @Override // com.igexin.c.a.d.a.g
    public void b() {
        this.a = false;
    }

    @Override // com.igexin.c.a.d.a.g
    public final boolean d() {
        return this.a;
    }
}
