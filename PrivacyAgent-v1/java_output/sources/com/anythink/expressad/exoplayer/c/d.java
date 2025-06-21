package com.anythink.expressad.exoplayer.c;

/* loaded from: classes12.dex */
public final class d {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    private synchronized void a() {
    }

    private void a(com.anythink.expressad.exoplayer.c.d dVar) {
        this.a += dVar.a;
        this.b += dVar.b;
        this.c += dVar.c;
        this.d += dVar.d;
        this.e += dVar.e;
        this.f += dVar.f;
        this.g += dVar.g;
        this.h = java.lang.Math.max(this.h, dVar.h);
        this.i += dVar.i;
    }
}
