package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.exoplayer.p {
    public static final int a = 15000;
    public static final int b = 50000;
    public static final int c = 2500;
    public static final int d = 5000;
    public static final int e = -1;
    public static final boolean f = true;
    private final com.anythink.expressad.exoplayer.j.l g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final int l;
    private final boolean m;
    private final com.anythink.expressad.exoplayer.k.v n;
    private int o;
    private boolean p;

    public static final class a {
        private com.anythink.expressad.exoplayer.j.l a = null;
        private int b = 15000;
        private int c = 50000;
        private int d = 2500;
        private int e = 5000;
        private int f = -1;
        private boolean g = true;
        private com.anythink.expressad.exoplayer.k.v h = null;

        private com.anythink.expressad.exoplayer.d.a a(int i) {
            this.f = i;
            return this;
        }

        private com.anythink.expressad.exoplayer.d.a a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            return this;
        }

        private com.anythink.expressad.exoplayer.d.a a(com.anythink.expressad.exoplayer.j.l lVar) {
            this.a = lVar;
            return this;
        }

        private com.anythink.expressad.exoplayer.d.a a(com.anythink.expressad.exoplayer.k.v vVar) {
            this.h = vVar;
            return this;
        }

        private com.anythink.expressad.exoplayer.d.a a(boolean z) {
            this.g = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.d a() {
            if (this.a == null) {
                this.a = new com.anythink.expressad.exoplayer.j.l((byte) 0);
            }
            return new com.anythink.expressad.exoplayer.d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public d() {
        this(new com.anythink.expressad.exoplayer.j.l((byte) 0));
    }

    @java.lang.Deprecated
    private d(com.anythink.expressad.exoplayer.j.l lVar) {
        this(lVar, (byte) 0);
    }

    @java.lang.Deprecated
    private d(com.anythink.expressad.exoplayer.j.l lVar, byte b2) {
        this(lVar, 15000, 50000, 2500, 5000, -1, true, null);
    }

    @java.lang.Deprecated
    public d(com.anythink.expressad.exoplayer.j.l lVar, int i, int i2, int i3, int i4, int i5, boolean z, com.anythink.expressad.exoplayer.k.v vVar) {
        a(i3, 0, "bufferForPlaybackMs", "0");
        a(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i, i3, "minBufferMs", "bufferForPlaybackMs");
        a(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i2, i, "maxBufferMs", "minBufferMs");
        this.g = lVar;
        this.h = i * 1000;
        this.i = i2 * 1000;
        this.j = i3 * 1000;
        this.k = i4 * 1000;
        this.l = i5;
        this.m = z;
        this.n = vVar;
    }

    private static void a(int i, int i2, java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.exoplayer.k.a.a(i >= i2, str + " cannot be less than " + str2);
    }

    private void a(boolean z) {
        this.o = 0;
        com.anythink.expressad.exoplayer.k.v vVar = this.n;
        if (vVar != null && this.p) {
            vVar.c();
        }
        this.p = false;
        if (z) {
            this.g.e();
        }
    }

    private static int b(com.anythink.expressad.exoplayer.y[] yVarArr, com.anythink.expressad.exoplayer.i.g gVar) {
        int i = 0;
        for (int i2 = 0; i2 < yVarArr.length; i2++) {
            if (gVar.a(i2) != null) {
                i += com.anythink.expressad.exoplayer.k.af.g(yVarArr[i2].a());
            }
        }
        return i;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void a() {
        a(false);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void a(com.anythink.expressad.exoplayer.y[] yVarArr, com.anythink.expressad.exoplayer.i.g gVar) {
        int i = this.l;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < yVarArr.length; i3++) {
                if (gVar.a(i3) != null) {
                    i2 += com.anythink.expressad.exoplayer.k.af.g(yVarArr[i3].a());
                }
            }
            i = i2;
        }
        this.o = i;
        this.g.a(i);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean a(long j, float f2) {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.g.c() >= this.o;
        boolean z4 = this.p;
        long j2 = this.h;
        if (f2 > 1.0f) {
            j2 = java.lang.Math.min(com.anythink.expressad.exoplayer.k.af.a(j2, f2), this.i);
        }
        if (j < j2) {
            if (!this.m && z3) {
                z2 = false;
            }
            this.p = z2;
        } else if (j > this.i || z3) {
            this.p = false;
        }
        com.anythink.expressad.exoplayer.k.v vVar = this.n;
        if (vVar != null && (z = this.p) != z4) {
            if (z) {
                vVar.a();
            } else {
                vVar.c();
            }
        }
        return this.p;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean a(long j, float f2, boolean z) {
        long b2 = com.anythink.expressad.exoplayer.k.af.b(j, f2);
        long j2 = z ? this.k : this.j;
        if (j2 <= 0 || b2 >= j2) {
            return true;
        }
        return !this.m && this.g.c() >= this.o;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void b() {
        a(true);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void c() {
        a(true);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final com.anythink.expressad.exoplayer.j.b d() {
        return this.g;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final long e() {
        return 0L;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean f() {
        return false;
    }
}
