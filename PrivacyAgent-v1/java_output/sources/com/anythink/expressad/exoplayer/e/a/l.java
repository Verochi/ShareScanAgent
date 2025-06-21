package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
final class l {
    public com.anythink.expressad.exoplayer.e.a.c a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public com.anythink.expressad.exoplayer.e.a.k o;
    public int p;
    public com.anythink.expressad.exoplayer.k.s q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public long f217s;

    private void a(com.anythink.expressad.exoplayer.e.f fVar) {
        fVar.b(this.q.a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public final void a() {
        this.e = 0;
        this.f217s = 0L;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public final void a(int i) {
        com.anythink.expressad.exoplayer.k.s sVar = this.q;
        if (sVar == null || sVar.b() < i) {
            this.q = new com.anythink.expressad.exoplayer.k.s(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public final void a(int i, int i2) {
        this.e = i;
        this.f = i2;
        int[] iArr = this.h;
        if (iArr == null || iArr.length < i) {
            this.g = new long[i];
            this.h = new int[i];
        }
        int[] iArr2 = this.i;
        if (iArr2 == null || iArr2.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.i = new int[i3];
            this.j = new int[i3];
            this.k = new long[i3];
            this.l = new boolean[i3];
            this.n = new boolean[i3];
        }
    }

    public final void a(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.a(this.q.a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public final long b(int i) {
        return this.k[i] + this.j[i];
    }
}
