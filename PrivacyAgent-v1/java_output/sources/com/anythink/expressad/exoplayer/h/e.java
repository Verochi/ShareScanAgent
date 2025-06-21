package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class e extends com.anythink.expressad.exoplayer.h.f<java.lang.Void> {
    private final com.anythink.expressad.exoplayer.h.s a;
    private final long b;
    private final long c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.h.d> g;
    private final com.anythink.expressad.exoplayer.ae.b h;

    @androidx.annotation.Nullable
    private java.lang.Object i;
    private com.anythink.expressad.exoplayer.h.e.a j;
    private com.anythink.expressad.exoplayer.h.e.b k;
    private long l;
    private long m;

    public static final class a extends com.anythink.expressad.exoplayer.h.p {
        private final long c;
        private final long d;
        private final long e;
        private final boolean f;

        public a(com.anythink.expressad.exoplayer.ae aeVar, long j, long j2) {
            super(aeVar);
            boolean z = false;
            if (aeVar.c() != 1) {
                throw new com.anythink.expressad.exoplayer.h.e.b(0);
            }
            com.anythink.expressad.exoplayer.ae.b a = aeVar.a(0, new com.anythink.expressad.exoplayer.ae.b(), false);
            long max = java.lang.Math.max(0L, j);
            long max2 = j2 == Long.MIN_VALUE ? a.i : java.lang.Math.max(0L, j2);
            long j3 = a.i;
            if (j3 != -9223372036854775807L) {
                max2 = max2 > j3 ? j3 : max2;
                if (max != 0 && !a.d) {
                    throw new com.anythink.expressad.exoplayer.h.e.b(1);
                }
                if (max > max2) {
                    throw new com.anythink.expressad.exoplayer.h.e.b(2);
                }
            }
            this.c = max;
            this.d = max2;
            this.e = max2 == -9223372036854775807L ? -9223372036854775807L : max2 - max;
            if (a.e && (max2 == -9223372036854775807L || (j3 != -9223372036854775807L && max2 == j3))) {
                z = true;
            }
            this.f = z;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
            this.b.a(0, aVar, z);
            long b = aVar.b() - this.c;
            long j = this.e;
            return aVar.a(aVar.a, aVar.b, j == -9223372036854775807L ? -9223372036854775807L : j - b, b);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j) {
            this.b.a(0, bVar, z, 0L);
            long j2 = bVar.j;
            long j3 = this.c;
            bVar.j = j2 + j3;
            bVar.i = this.e;
            bVar.e = this.f;
            long j4 = bVar.h;
            if (j4 != -9223372036854775807L) {
                long max = java.lang.Math.max(j4, j3);
                bVar.h = max;
                long j5 = this.d;
                if (j5 != -9223372036854775807L) {
                    max = java.lang.Math.min(max, j5);
                }
                bVar.h = max - this.c;
            }
            long a = com.anythink.expressad.exoplayer.b.a(this.c);
            long j6 = bVar.b;
            if (j6 != -9223372036854775807L) {
                bVar.b = j6 + a;
            }
            long j7 = bVar.c;
            if (j7 != -9223372036854775807L) {
                bVar.c = j7 + a;
            }
            return bVar;
        }
    }

    public static final class b extends java.io.IOException {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public final int d;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface a {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(int i) {
            super(r0.toString());
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Illegal clipping: ");
            sb.append(i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count");
            this.d = i;
        }

        private static java.lang.String a(int i) {
            return i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    private e(com.anythink.expressad.exoplayer.h.s sVar, long j) {
        this(sVar, 0L, j, true, true);
    }

    private e(com.anythink.expressad.exoplayer.h.s sVar, long j, long j2) {
        this(sVar, j, j2, true, false);
    }

    @java.lang.Deprecated
    private e(com.anythink.expressad.exoplayer.h.s sVar, long j, long j2, boolean z) {
        this(sVar, j, j2, z, false);
    }

    private e(com.anythink.expressad.exoplayer.h.s sVar, long j, long j2, boolean z, boolean z2) {
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        this.a = (com.anythink.expressad.exoplayer.h.s) com.anythink.expressad.exoplayer.k.a.a(sVar);
        this.b = j;
        this.c = j2;
        this.d = z;
        this.e = false;
        this.f = z2;
        this.g = new java.util.ArrayList<>();
        this.h = new com.anythink.expressad.exoplayer.ae.b();
    }

    private void a(com.anythink.expressad.exoplayer.ae aeVar) {
        long j;
        long j2;
        long j3;
        aeVar.a(0, this.h, false);
        long j4 = this.h.j;
        if (this.j == null || this.g.isEmpty() || this.e) {
            long j5 = this.b;
            long j6 = this.c;
            if (this.f) {
                long j7 = this.h.h;
                j5 += j7;
                j = j7 + j6;
            } else {
                j = j6;
            }
            this.l = j4 + j5;
            this.m = j6 != Long.MIN_VALUE ? j4 + j : Long.MIN_VALUE;
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                this.g.get(i).a(this.l, this.m);
            }
            j2 = j5;
            j3 = j;
        } else {
            long j8 = this.l - j4;
            j3 = this.c != Long.MIN_VALUE ? this.m - j4 : Long.MIN_VALUE;
            j2 = j8;
        }
        try {
            com.anythink.expressad.exoplayer.h.e.a aVar = new com.anythink.expressad.exoplayer.h.e.a(aeVar, j2, j3);
            this.j = aVar;
            a(aVar, this.i);
        } catch (com.anythink.expressad.exoplayer.h.e.b e) {
            this.k = e;
        }
    }

    private long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long a2 = com.anythink.expressad.exoplayer.b.a(this.b);
        long max = java.lang.Math.max(0L, j - a2);
        long j2 = this.c;
        return j2 != Long.MIN_VALUE ? java.lang.Math.min(com.anythink.expressad.exoplayer.b.a(j2) - a2, max) : max;
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        if (this.k != null) {
            return;
        }
        this.i = obj;
        a(aeVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* synthetic */ long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long a2 = com.anythink.expressad.exoplayer.b.a(this.b);
        long max = java.lang.Math.max(0L, j - a2);
        long j2 = this.c;
        return j2 != Long.MIN_VALUE ? java.lang.Math.min(com.anythink.expressad.exoplayer.b.a(j2) - a2, max) : max;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        com.anythink.expressad.exoplayer.h.d dVar = new com.anythink.expressad.exoplayer.h.d(this.a.a(aVar, bVar), this.d, this.l, this.m);
        this.g.add(dVar);
        return dVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.k = null;
        this.j = null;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.g.remove(rVar));
        this.a.a(((com.anythink.expressad.exoplayer.h.d) rVar).a);
        if (!this.g.isEmpty() || this.e) {
            return;
        }
        a(this.j.b);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        a((com.anythink.expressad.exoplayer.h.e) null, this.a);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* bridge */ /* synthetic */ void a(java.lang.Void r1, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        if (this.k == null) {
            this.i = obj;
            a(aeVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.s
    public final void b() {
        com.anythink.expressad.exoplayer.h.e.b bVar = this.k;
        if (bVar != null) {
            throw bVar;
        }
        super.b();
    }
}
