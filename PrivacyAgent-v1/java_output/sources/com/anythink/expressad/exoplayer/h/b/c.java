package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public abstract class c implements com.anythink.expressad.exoplayer.j.t.c {
    public final com.anythink.expressad.exoplayer.j.k b;
    public final int c = 1;
    public final com.anythink.expressad.exoplayer.m d;
    public final int e;

    @androidx.annotation.Nullable
    public final java.lang.Object f;
    public final long g;
    public final long h;
    protected final com.anythink.expressad.exoplayer.j.h i;

    public c(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.m mVar, int i, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2) {
        this.i = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (com.anythink.expressad.exoplayer.j.k) com.anythink.expressad.exoplayer.k.a.a(kVar);
        this.d = mVar;
        this.e = i;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    private long c() {
        return this.h - this.g;
    }

    public abstract long d();
}
