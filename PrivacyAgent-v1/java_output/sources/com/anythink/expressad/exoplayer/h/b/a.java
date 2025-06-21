package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public abstract class a extends com.anythink.expressad.exoplayer.h.b.i {
    public final long a;
    private com.anythink.expressad.exoplayer.h.b.b k;
    private int[] l;

    public a(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.m mVar, int i, java.lang.Object obj, long j, long j2, long j3, long j4) {
        super(hVar, kVar, mVar, i, obj, j, j2, j4);
        this.a = j3;
    }

    public final int a(int i) {
        return this.l[i];
    }

    public final void a(com.anythink.expressad.exoplayer.h.b.b bVar) {
        this.k = bVar;
        this.l = bVar.a();
    }

    public final com.anythink.expressad.exoplayer.h.b.b c() {
        return this.k;
    }
}
