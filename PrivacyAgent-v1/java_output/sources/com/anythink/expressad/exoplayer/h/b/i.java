package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public abstract class i extends com.anythink.expressad.exoplayer.h.b.c {
    public final long j;

    public i(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.m mVar, int i, java.lang.Object obj, long j, long j2, long j3) {
        super(hVar, kVar, mVar, i, obj, j, j2);
        com.anythink.expressad.exoplayer.k.a.a(mVar);
        this.j = j3;
    }

    public long e() {
        long j = this.j;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }

    public abstract boolean f();
}
