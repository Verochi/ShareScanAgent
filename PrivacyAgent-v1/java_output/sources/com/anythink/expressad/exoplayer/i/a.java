package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.exoplayer.i.b {
    public static final int a = 10000;
    public static final int b = 25000;
    public static final int c = 25000;
    public static final float d = 0.75f;
    public static final float e = 0.75f;
    public static final long f = 2000;
    private final com.anythink.expressad.exoplayer.j.d j;
    private final long k;
    private final long l;
    private final long m;
    private final float n;
    private final float o;
    private final long p;
    private final com.anythink.expressad.exoplayer.k.c q;
    private float r;

    /* renamed from: s, reason: collision with root package name */
    private int f224s;
    private int t;
    private long u;

    /* renamed from: com.anythink.expressad.exoplayer.i.a$a, reason: collision with other inner class name */
    public static final class C0200a implements com.anythink.expressad.exoplayer.i.f.a {
        private final com.anythink.expressad.exoplayer.j.d a;
        private final int b;
        private final int c;
        private final int d;
        private final float e;
        private final float f;
        private final long g;
        private final com.anythink.expressad.exoplayer.k.c h;

        public C0200a(com.anythink.expressad.exoplayer.j.d dVar) {
            this(dVar, 10000, 25000, 25000, 0.75f, com.anythink.expressad.exoplayer.k.c.a);
        }

        private C0200a(com.anythink.expressad.exoplayer.j.d dVar, int i, int i2, int i3, float f) {
            this(dVar, i, i2, i3, f, com.anythink.expressad.exoplayer.k.c.a);
        }

        private C0200a(com.anythink.expressad.exoplayer.j.d dVar, int i, int i2, int i3, float f, com.anythink.expressad.exoplayer.k.c cVar) {
            this.a = dVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = f;
            this.f = 0.75f;
            this.g = 2000L;
            this.h = cVar;
        }

        private com.anythink.expressad.exoplayer.i.a b(com.anythink.expressad.exoplayer.h.ae aeVar, int... iArr) {
            return new com.anythink.expressad.exoplayer.i.a(aeVar, iArr, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        @Override // com.anythink.expressad.exoplayer.i.f.a
        public final /* synthetic */ com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr) {
            return new com.anythink.expressad.exoplayer.i.a(aeVar, iArr, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    private a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.j.d dVar) {
        this(aeVar, iArr, dVar, 10000L, 25000L, 25000L, 0.75f, 0.75f, 2000L, com.anythink.expressad.exoplayer.k.c.a);
    }

    public a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.j.d dVar, long j, long j2, long j3, float f2, float f3, long j4, com.anythink.expressad.exoplayer.k.c cVar) {
        super(aeVar, iArr);
        this.j = dVar;
        this.k = j * 1000;
        this.l = j2 * 1000;
        this.m = j3 * 1000;
        this.n = f2;
        this.o = f3;
        this.p = j4;
        this.q = cVar;
        this.r = 1.0f;
        this.t = 1;
        this.u = -9223372036854775807L;
        this.f224s = a(Long.MIN_VALUE);
    }

    private int a(long j) {
        long a2 = (long) (this.j.a() * this.n);
        int i = 0;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (j == Long.MIN_VALUE || !b(i2, j)) {
                if (java.lang.Math.round(a(i2).d * this.r) <= a2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long b(long j) {
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.k ? 1 : (j == this.k ? 0 : -1)) <= 0 ? (long) (j * this.o) : this.k;
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final int a(long j, java.util.List<? extends com.anythink.expressad.exoplayer.h.b.i> list) {
        int i;
        int i2;
        long a2 = this.q.a();
        long j2 = this.u;
        if (j2 != -9223372036854775807L && a2 - j2 < this.p) {
            return list.size();
        }
        this.u = a2;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (com.anythink.expressad.exoplayer.k.af.b(list.get(size - 1).g - j, this.r) < this.m) {
            return size;
        }
        com.anythink.expressad.exoplayer.m a3 = a(a(a2));
        for (int i3 = 0; i3 < size; i3++) {
            com.anythink.expressad.exoplayer.h.b.i iVar = list.get(i3);
            com.anythink.expressad.exoplayer.m mVar = iVar.d;
            if (com.anythink.expressad.exoplayer.k.af.b(iVar.g - j, this.r) >= this.m && mVar.d < a3.d && (i = mVar.n) != -1 && i < 720 && (i2 = mVar.m) != -1 && i2 < 1280 && i < a3.n) {
                return i3;
            }
        }
        return size;
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final void a() {
        this.u = -9223372036854775807L;
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final void a(float f2) {
        this.r = f2;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void a(long j, long j2) {
        long a2 = this.q.a();
        int i = this.f224s;
        int a3 = a(a2);
        this.f224s = a3;
        if (a3 == i) {
            return;
        }
        if (!b(i, a2)) {
            com.anythink.expressad.exoplayer.m a4 = a(i);
            int i2 = a(this.f224s).d;
            int i3 = a4.d;
            if (i2 > i3) {
                if (j < ((j2 > (-9223372036854775807L) ? 1 : (j2 == (-9223372036854775807L) ? 0 : -1)) != 0 && (j2 > this.k ? 1 : (j2 == this.k ? 0 : -1)) <= 0 ? (long) (j2 * this.o) : this.k)) {
                    this.f224s = i;
                }
            }
            if (i2 < i3 && j >= this.l) {
                this.f224s = i;
            }
        }
        if (this.f224s != i) {
            this.t = 3;
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b() {
        return this.f224s;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c() {
        return this.t;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    @androidx.annotation.Nullable
    public final java.lang.Object d() {
        return null;
    }
}
