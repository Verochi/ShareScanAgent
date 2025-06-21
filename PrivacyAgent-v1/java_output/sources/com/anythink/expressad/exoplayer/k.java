package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
final class k implements android.os.Handler.Callback, com.anythink.expressad.exoplayer.e.a, com.anythink.expressad.exoplayer.h.r.a, com.anythink.expressad.exoplayer.h.s.b, com.anythink.expressad.exoplayer.i.h.a, com.anythink.expressad.exoplayer.x.a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final java.lang.String d = "ExoPlayerImplInternal";
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;
    private static final int j = 5;
    private static final int k = 6;
    private static final int l = 7;
    private static final int m = 8;
    private static final int n = 9;
    private static final int o = 10;
    private static final int p = 11;
    private static final int q = 12;
    private static final int r = 13;

    /* renamed from: s, reason: collision with root package name */
    private static final int f228s = 14;
    private static final int t = 15;
    private static final int u = 10;
    private static final int v = 10;
    private static final int w = 1000;
    private static final long x = 500;
    private final com.anythink.expressad.exoplayer.i.h A;
    private final com.anythink.expressad.exoplayer.i.i B;
    private final com.anythink.expressad.exoplayer.p C;
    private final com.anythink.expressad.exoplayer.k.k D;
    private final android.os.HandlerThread E;
    private final android.os.Handler F;
    private final com.anythink.expressad.exoplayer.h G;
    private final com.anythink.expressad.exoplayer.ae.b H;
    private final com.anythink.expressad.exoplayer.ae.a I;
    private final com.anythink.expressad.exoplayer.e L;
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.k.b> N;
    private final com.anythink.expressad.exoplayer.k.c O;
    private com.anythink.expressad.exoplayer.u R;
    private com.anythink.expressad.exoplayer.h.s S;
    private com.anythink.expressad.exoplayer.y[] T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private int Z;
    private com.anythink.expressad.exoplayer.k.d aa;
    private long ab;
    private int ac;
    private final com.anythink.expressad.exoplayer.y[] y;
    private final com.anythink.expressad.exoplayer.z[] z;
    private final com.anythink.expressad.exoplayer.s P = new com.anythink.expressad.exoplayer.s();
    private final long J = 0;
    private final boolean K = false;
    private com.anythink.expressad.exoplayer.ac Q = com.anythink.expressad.exoplayer.ac.e;
    private final com.anythink.expressad.exoplayer.k.c M = new com.anythink.expressad.exoplayer.k.c((byte) 0);

    /* renamed from: com.anythink.expressad.exoplayer.k$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.exoplayer.x a;

        public AnonymousClass1(com.anythink.expressad.exoplayer.x xVar) {
            this.a = xVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.expressad.exoplayer.k.f(this.a);
            } catch (com.anythink.expressad.exoplayer.g e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public static final class a {
        public final com.anythink.expressad.exoplayer.h.s a;
        public final com.anythink.expressad.exoplayer.ae b;
        public final java.lang.Object c;

        public a(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, java.lang.Object obj) {
            this.a = sVar;
            this.b = aeVar;
            this.c = obj;
        }
    }

    public static final class b implements java.lang.Comparable<com.anythink.expressad.exoplayer.k.b> {
        public final com.anythink.expressad.exoplayer.x a;
        public int b;
        public long c;

        @androidx.annotation.Nullable
        public java.lang.Object d;

        public b(com.anythink.expressad.exoplayer.x xVar) {
            this.a = xVar;
        }

        private int a(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.k.b bVar) {
            java.lang.Object obj = this.d;
            if ((obj == null) != (bVar.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - bVar.b;
            return i != 0 ? i : com.anythink.expressad.exoplayer.k.af.b(this.c, bVar.c);
        }

        public final void a(int i, long j, java.lang.Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.k.b bVar) {
            com.anythink.expressad.exoplayer.k.b bVar2 = bVar;
            java.lang.Object obj = this.d;
            if ((obj == null) != (bVar2.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - bVar2.b;
            return i != 0 ? i : com.anythink.expressad.exoplayer.k.af.b(this.c, bVar2.c);
        }
    }

    public static final class c {
        private com.anythink.expressad.exoplayer.u a;
        private int b;
        private boolean c;
        private int d;

        private c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        public final void a(int i) {
            this.b += i;
        }

        public final boolean a(com.anythink.expressad.exoplayer.u uVar) {
            return uVar != this.a || this.b > 0 || this.c;
        }

        public final void b(int i) {
            if (this.c && this.d != 4) {
                com.anythink.expressad.exoplayer.k.a.a(i == 4);
            } else {
                this.c = true;
                this.d = i;
            }
        }

        public final void b(com.anythink.expressad.exoplayer.u uVar) {
            this.a = uVar;
            this.b = 0;
            this.c = false;
        }
    }

    public static final class d {
        public final com.anythink.expressad.exoplayer.ae a;
        public final int b;
        public final long c;

        public d(com.anythink.expressad.exoplayer.ae aeVar, int i, long j) {
            this.a = aeVar;
            this.b = i;
            this.c = j;
        }
    }

    public k(com.anythink.expressad.exoplayer.y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.i.i iVar, com.anythink.expressad.exoplayer.p pVar, boolean z, int i2, boolean z2, android.os.Handler handler, com.anythink.expressad.exoplayer.h hVar2, com.anythink.expressad.exoplayer.k.c cVar) {
        this.y = yVarArr;
        this.A = hVar;
        this.B = iVar;
        this.C = pVar;
        this.V = z;
        this.X = i2;
        this.Y = z2;
        this.F = handler;
        this.G = hVar2;
        this.O = cVar;
        this.R = new com.anythink.expressad.exoplayer.u(com.anythink.expressad.exoplayer.ae.a, -9223372036854775807L, com.anythink.expressad.exoplayer.h.af.a, iVar);
        this.z = new com.anythink.expressad.exoplayer.z[yVarArr.length];
        for (int i3 = 0; i3 < yVarArr.length; i3++) {
            yVarArr[i3].a(i3);
            this.z[i3] = yVarArr[i3].b();
        }
        this.L = new com.anythink.expressad.exoplayer.e(this, cVar);
        this.N = new java.util.ArrayList<>();
        this.T = new com.anythink.expressad.exoplayer.y[0];
        this.H = new com.anythink.expressad.exoplayer.ae.b();
        this.I = new com.anythink.expressad.exoplayer.ae.a();
        hVar.a((com.anythink.expressad.exoplayer.i.h.a) this);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.E = handlerThread;
        handlerThread.start();
        this.D = cVar.a(handlerThread.getLooper(), this);
    }

    private int a(int i2, com.anythink.expressad.exoplayer.ae aeVar, com.anythink.expressad.exoplayer.ae aeVar2) {
        int c2 = aeVar.c();
        int i3 = i2;
        int i4 = -1;
        for (int i5 = 0; i5 < c2 && i4 == -1; i5++) {
            i3 = aeVar.a(i3, this.I, this.H, this.X, this.Y);
            if (i3 == -1) {
                break;
            }
            i4 = aeVar2.a(aeVar.a(i3, this.I, true).b);
        }
        return i4;
    }

    private long a(com.anythink.expressad.exoplayer.h.s.a aVar, long j2) {
        return a(aVar, j2, this.P.c() != this.P.d());
    }

    private long a(com.anythink.expressad.exoplayer.h.s.a aVar, long j2, boolean z) {
        f();
        this.W = false;
        b(2);
        com.anythink.expressad.exoplayer.q c2 = this.P.c();
        com.anythink.expressad.exoplayer.q qVar = c2;
        while (true) {
            if (qVar == null) {
                break;
            }
            if (a(aVar, j2, qVar)) {
                this.P.a(qVar);
                break;
            }
            qVar = this.P.h();
        }
        if (c2 != qVar || z) {
            for (com.anythink.expressad.exoplayer.y yVar : this.T) {
                b(yVar);
            }
            this.T = new com.anythink.expressad.exoplayer.y[0];
            c2 = null;
        }
        if (qVar != null) {
            a(c2);
            if (qVar.g) {
                long b2 = qVar.a.b(j2);
                qVar.a.a(b2 - this.J, this.K);
                j2 = b2;
            }
            a(j2);
            r();
        } else {
            this.P.b(true);
            a(j2);
        }
        this.D.b(2);
        return j2;
    }

    private android.util.Pair<java.lang.Integer, java.lang.Long> a(com.anythink.expressad.exoplayer.ae aeVar, int i2) {
        return aeVar.a(this.H, this.I, i2, -9223372036854775807L);
    }

    private android.util.Pair<java.lang.Integer, java.lang.Long> a(com.anythink.expressad.exoplayer.k.d dVar, boolean z) {
        int a2;
        com.anythink.expressad.exoplayer.ae aeVar = this.R.a;
        com.anythink.expressad.exoplayer.ae aeVar2 = dVar.a;
        if (aeVar.a()) {
            return null;
        }
        if (aeVar2.a()) {
            aeVar2 = aeVar;
        }
        try {
            android.util.Pair<java.lang.Integer, java.lang.Long> a3 = aeVar2.a(this.H, this.I, dVar.b, dVar.c);
            if (aeVar == aeVar2) {
                return a3;
            }
            int a4 = aeVar.a(aeVar2.a(((java.lang.Integer) a3.first).intValue(), this.I, true).b);
            if (a4 != -1) {
                return android.util.Pair.create(java.lang.Integer.valueOf(a4), (java.lang.Long) a3.second);
            }
            if (!z || (a2 = a(((java.lang.Integer) a3.first).intValue(), aeVar2, aeVar)) == -1) {
                return null;
            }
            return a(aeVar, aeVar.a(a2, this.I, false).c);
        } catch (java.lang.IndexOutOfBoundsException unused) {
            throw new com.anythink.expressad.exoplayer.o(aeVar, dVar.b, dVar.c);
        }
    }

    private void a(float f2) {
        for (com.anythink.expressad.exoplayer.q e2 = this.P.e(); e2 != null; e2 = e2.i) {
            com.anythink.expressad.exoplayer.i.i iVar = e2.k;
            if (iVar != null) {
                for (com.anythink.expressad.exoplayer.i.f fVar : iVar.c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private void a(int i2, boolean z, int i3) {
        com.anythink.expressad.exoplayer.q c2 = this.P.c();
        com.anythink.expressad.exoplayer.y yVar = this.y[i2];
        this.T[i3] = yVar;
        if (yVar.a_() == 0) {
            com.anythink.expressad.exoplayer.i.i iVar = c2.k;
            com.anythink.expressad.exoplayer.aa aaVar = iVar.b[i2];
            com.anythink.expressad.exoplayer.m[] a2 = a(iVar.c.a(i2));
            boolean z2 = this.V && this.R.f == 3;
            yVar.a(aaVar, a2, c2.c[i2], this.ab, !z && z2, c2.e);
            this.L.a(yVar);
            if (z2) {
                yVar.b_();
            }
        }
    }

    private void a(long j2) {
        if (this.P.f()) {
            j2 += this.P.c().e;
        }
        this.ab = j2;
        this.L.a(j2);
        for (com.anythink.expressad.exoplayer.y yVar : this.T) {
            yVar.a(this.ab);
        }
    }

    private void a(long j2, long j3) {
        this.D.b();
        this.D.a(j2 + j3);
    }

    private void a(com.anythink.expressad.exoplayer.i.i iVar) {
        this.C.a(this.y, iVar.c);
    }

    private void a(com.anythink.expressad.exoplayer.k.a aVar) {
        if (aVar.a != this.S) {
            return;
        }
        com.anythink.expressad.exoplayer.ae aeVar = this.R.a;
        com.anythink.expressad.exoplayer.ae aeVar2 = aVar.b;
        java.lang.Object obj = aVar.c;
        this.P.a(aeVar2);
        this.R = this.R.a(aeVar2, obj);
        for (int size = this.N.size() - 1; size >= 0; size--) {
            if (!a(this.N.get(size))) {
                this.N.get(size).a.a(false);
                this.N.remove(size);
            }
        }
        java.util.Collections.sort(this.N);
        int i2 = this.Z;
        if (i2 > 0) {
            this.M.a(i2);
            this.Z = 0;
            com.anythink.expressad.exoplayer.k.d dVar = this.aa;
            if (dVar != null) {
                android.util.Pair<java.lang.Integer, java.lang.Long> a2 = a(dVar, true);
                this.aa = null;
                if (a2 == null) {
                    o();
                    return;
                }
                int intValue = ((java.lang.Integer) a2.first).intValue();
                long longValue = ((java.lang.Long) a2.second).longValue();
                com.anythink.expressad.exoplayer.h.s.a a3 = this.P.a(intValue, longValue);
                this.R = this.R.a(a3, a3.a() ? 0L : longValue, longValue);
                return;
            }
            if (this.R.d == -9223372036854775807L) {
                if (aeVar2.a()) {
                    o();
                    return;
                }
                android.util.Pair<java.lang.Integer, java.lang.Long> a4 = a(aeVar2, aeVar2.b(this.Y));
                int intValue2 = ((java.lang.Integer) a4.first).intValue();
                long longValue2 = ((java.lang.Long) a4.second).longValue();
                com.anythink.expressad.exoplayer.h.s.a a5 = this.P.a(intValue2, longValue2);
                this.R = this.R.a(a5, a5.a() ? 0L : longValue2, longValue2);
                return;
            }
            return;
        }
        com.anythink.expressad.exoplayer.u uVar = this.R;
        int i3 = uVar.c.a;
        long j2 = uVar.e;
        if (aeVar.a()) {
            if (aeVar2.a()) {
                return;
            }
            com.anythink.expressad.exoplayer.h.s.a a6 = this.P.a(i3, j2);
            this.R = this.R.a(a6, a6.a() ? 0L : j2, j2);
            return;
        }
        com.anythink.expressad.exoplayer.q e2 = this.P.e();
        int a7 = aeVar2.a(e2 == null ? aeVar.a(i3, this.I, true).b : e2.b);
        if (a7 != -1) {
            if (a7 != i3) {
                this.R = this.R.a(a7);
            }
            com.anythink.expressad.exoplayer.h.s.a aVar2 = this.R.c;
            if (aVar2.a()) {
                com.anythink.expressad.exoplayer.h.s.a a8 = this.P.a(a7, j2);
                if (!a8.equals(aVar2)) {
                    this.R = this.R.a(a8, a(a8, a8.a() ? 0L : j2), j2);
                    return;
                }
            }
            if (this.P.a(aVar2, this.ab)) {
                return;
            }
            g(false);
            return;
        }
        int a9 = a(i3, aeVar, aeVar2);
        if (a9 == -1) {
            o();
            return;
        }
        android.util.Pair<java.lang.Integer, java.lang.Long> a10 = a(aeVar2, aeVar2.a(a9, this.I, false).c);
        int intValue3 = ((java.lang.Integer) a10.first).intValue();
        long longValue3 = ((java.lang.Long) a10.second).longValue();
        com.anythink.expressad.exoplayer.h.s.a a11 = this.P.a(intValue3, longValue3);
        aeVar2.a(intValue3, this.I, true);
        if (e2 != null) {
            java.lang.Object obj2 = this.I.b;
            e2.h = e2.h.a();
            while (true) {
                e2 = e2.i;
                if (e2 == null) {
                    break;
                } else if (e2.b.equals(obj2)) {
                    e2.h = this.P.a(e2.h, intValue3);
                } else {
                    e2.h = e2.h.a();
                }
            }
        }
        this.R = this.R.a(a11, a(a11, a11.a() ? 0L : longValue3), longValue3);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:7:0x005d, B:9:0x0061, B:14:0x006a, B:22:0x0072, B:24:0x007c, B:28:0x0088, B:29:0x0092, B:31:0x00a2, B:37:0x00b9, B:40:0x00c3, B:44:0x00c7), top: B:6:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:7:0x005d, B:9:0x0061, B:14:0x006a, B:22:0x0072, B:24:0x007c, B:28:0x0088, B:29:0x0092, B:31:0x00a2, B:37:0x00b9, B:40:0x00c3, B:44:0x00c7), top: B:6:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.anythink.expressad.exoplayer.k.d dVar) {
        long longValue;
        boolean z;
        com.anythink.expressad.exoplayer.h.s.a aVar;
        long j2;
        long j3;
        long j4;
        boolean z2 = true;
        this.M.a(1);
        android.util.Pair<java.lang.Integer, java.lang.Long> a2 = a(dVar, true);
        try {
            if (a2 == null) {
                aVar = new com.anythink.expressad.exoplayer.h.s.a(j());
                longValue = -9223372036854775807L;
                j2 = -9223372036854775807L;
            } else {
                int intValue = ((java.lang.Integer) a2.first).intValue();
                long longValue2 = ((java.lang.Long) a2.second).longValue();
                com.anythink.expressad.exoplayer.h.s.a a3 = this.P.a(intValue, longValue2);
                if (a3.a()) {
                    longValue = 0;
                    aVar = a3;
                    j2 = longValue2;
                } else {
                    longValue = ((java.lang.Long) a2.second).longValue();
                    z = dVar.c == -9223372036854775807L;
                    aVar = a3;
                    j2 = longValue2;
                    if (this.S != null && this.Z <= 0) {
                        if (longValue != -9223372036854775807L) {
                            b(4);
                            a(false, true, false);
                            j3 = longValue;
                            this.R = this.R.a(aVar, j3, j2);
                            if (z) {
                                return;
                            }
                            this.M.b(2);
                            return;
                        }
                        if (aVar.equals(this.R.c)) {
                            com.anythink.expressad.exoplayer.q c2 = this.P.c();
                            j4 = (c2 == null || longValue == 0) ? longValue : c2.a.a(longValue, this.Q);
                            if (com.anythink.expressad.exoplayer.b.a(j4) == com.anythink.expressad.exoplayer.b.a(this.R.j)) {
                                this.R = this.R.a(aVar, this.R.j, j2);
                                if (z) {
                                    this.M.b(2);
                                    return;
                                }
                                return;
                            }
                        } else {
                            j4 = longValue;
                        }
                        long a4 = a(aVar, j4);
                        if (longValue == a4) {
                            z2 = false;
                        }
                        z |= z2;
                        j3 = a4;
                        this.R = this.R.a(aVar, j3, j2);
                        if (z) {
                        }
                    }
                    this.aa = dVar;
                    j3 = longValue;
                    this.R = this.R.a(aVar, j3, j2);
                    if (z) {
                    }
                }
            }
            if (this.S != null) {
                if (longValue != -9223372036854775807L) {
                }
            }
            this.aa = dVar;
            j3 = longValue;
            this.R = this.R.a(aVar, j3, j2);
            if (z) {
            }
        } catch (java.lang.Throwable th) {
            this.R = this.R.a(aVar, longValue, j2);
            if (z) {
                this.M.b(2);
            }
            throw th;
        }
        z = true;
    }

    private void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.q qVar) {
        com.anythink.expressad.exoplayer.q c2 = this.P.c();
        if (c2 == null || qVar == c2) {
            return;
        }
        boolean[] zArr = new boolean[this.y.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.y[] yVarArr = this.y;
            if (i2 >= yVarArr.length) {
                this.R = this.R.a(c2.j, c2.k);
                a(zArr, i3);
                return;
            }
            com.anythink.expressad.exoplayer.y yVar = yVarArr[i2];
            zArr[i2] = yVar.a_() != 0;
            if (c2.k.a(i2)) {
                i3++;
            }
            if (zArr[i2] && (!c2.k.a(i2) || (yVar.i() && yVar.f() == qVar.c[i2]))) {
                b(yVar);
            }
            i2++;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.y yVar) {
        if (yVar.a_() == 2) {
            yVar.k();
        }
    }

    private void a(boolean z, boolean z2) {
        a(true, z, z);
        this.M.a(this.Z + (z2 ? 1 : 0));
        this.Z = 0;
        this.C.b();
        b(1);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.anythink.expressad.exoplayer.h.s sVar;
        this.D.b();
        this.W = false;
        this.L.b();
        this.ab = 0L;
        for (com.anythink.expressad.exoplayer.y yVar : this.T) {
            try {
                b(yVar);
            } catch (com.anythink.expressad.exoplayer.g | java.lang.RuntimeException unused) {
            }
        }
        this.T = new com.anythink.expressad.exoplayer.y[0];
        this.P.b(!z2);
        d(false);
        if (z2) {
            this.aa = null;
        }
        if (z3) {
            this.P.a(com.anythink.expressad.exoplayer.ae.a);
            java.util.Iterator<com.anythink.expressad.exoplayer.k.b> it = this.N.iterator();
            while (it.hasNext()) {
                it.next().a.a(false);
            }
            this.N.clear();
            this.ac = 0;
        }
        com.anythink.expressad.exoplayer.ae aeVar = z3 ? com.anythink.expressad.exoplayer.ae.a : this.R.a;
        java.lang.Object obj = z3 ? null : this.R.b;
        com.anythink.expressad.exoplayer.h.s.a aVar = z2 ? new com.anythink.expressad.exoplayer.h.s.a(j()) : this.R.c;
        long j2 = z2 ? -9223372036854775807L : this.R.j;
        long j3 = z2 ? -9223372036854775807L : this.R.e;
        com.anythink.expressad.exoplayer.u uVar = this.R;
        this.R = new com.anythink.expressad.exoplayer.u(aeVar, obj, aVar, j2, j3, uVar.f, false, z3 ? com.anythink.expressad.exoplayer.h.af.a : uVar.h, z3 ? this.B : uVar.i);
        if (!z || (sVar = this.S) == null) {
            return;
        }
        sVar.a(this);
        this.S = null;
    }

    private void a(boolean[] zArr, int i2) {
        this.T = new com.anythink.expressad.exoplayer.y[i2];
        com.anythink.expressad.exoplayer.q c2 = this.P.c();
        int i3 = 0;
        for (int i4 = 0; i4 < this.y.length; i4++) {
            if (c2.k.a(i4)) {
                a(i4, zArr[i4], i3);
                i3++;
            }
        }
    }

    private boolean a(com.anythink.expressad.exoplayer.h.s.a aVar, long j2, com.anythink.expressad.exoplayer.q qVar) {
        if (aVar.equals(qVar.h.a) && qVar.f) {
            this.R.a.a(qVar.h.a.a, this.I, false);
            int b2 = this.I.b(j2);
            if (b2 == -1 || this.I.a(b2) == qVar.h.c) {
                return true;
            }
        }
        return false;
    }

    private boolean a(com.anythink.expressad.exoplayer.k.b bVar) {
        java.lang.Object obj = bVar.d;
        if (obj == null) {
            android.util.Pair<java.lang.Integer, java.lang.Long> a2 = a(new com.anythink.expressad.exoplayer.k.d(bVar.a.a(), bVar.a.g(), com.anythink.expressad.exoplayer.b.b(bVar.a.f())), false);
            if (a2 == null) {
                return false;
            }
            bVar.a(((java.lang.Integer) a2.first).intValue(), ((java.lang.Long) a2.second).longValue(), this.R.a.a(((java.lang.Integer) a2.first).intValue(), this.I, true).b);
        } else {
            int a3 = this.R.a.a(obj);
            if (a3 == -1) {
                return false;
            }
            bVar.b = a3;
        }
        return true;
    }

    @androidx.annotation.NonNull
    private static com.anythink.expressad.exoplayer.m[] a(com.anythink.expressad.exoplayer.i.f fVar) {
        int g2 = fVar != null ? fVar.g() : 0;
        com.anythink.expressad.exoplayer.m[] mVarArr = new com.anythink.expressad.exoplayer.m[g2];
        for (int i2 = 0; i2 < g2; i2++) {
            mVarArr[i2] = fVar.a(i2);
        }
        return mVarArr;
    }

    private void b(int i2) {
        com.anythink.expressad.exoplayer.u uVar = this.R;
        if (uVar.f != i2) {
            this.R = uVar.b(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x006b, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0034, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(long j2, long j3) {
        com.anythink.expressad.exoplayer.k.b bVar;
        com.anythink.expressad.exoplayer.k.b bVar2;
        if (this.N.isEmpty() || this.R.c.a()) {
            return;
        }
        com.anythink.expressad.exoplayer.u uVar = this.R;
        if (uVar.d == j2) {
            j2--;
        }
        int i2 = uVar.c.a;
        int i3 = this.ac;
        if (i3 > 0) {
            bVar = this.N.get(i3 - 1);
            while (bVar != null) {
                int i4 = bVar.b;
                if (i4 <= i2 && (i4 != i2 || bVar.c <= j2)) {
                    break;
                }
                int i5 = this.ac - 1;
                this.ac = i5;
                if (i5 > 0) {
                    bVar = this.N.get(i5 - 1);
                }
            }
            if (this.ac < this.N.size()) {
                bVar2 = this.N.get(this.ac);
                while (bVar2 != null && bVar2.d != null) {
                    int i6 = bVar2.b;
                    if (i6 >= i2 && (i6 != i2 || bVar2.c > j2)) {
                        break;
                    }
                    int i7 = this.ac + 1;
                    this.ac = i7;
                    if (i7 < this.N.size()) {
                        bVar2 = this.N.get(this.ac);
                    }
                }
                while (bVar2 != null && bVar2.d != null && bVar2.b == i2) {
                    long j4 = bVar2.c;
                    if (j4 <= j2 || j4 > j3) {
                        return;
                    }
                    d(bVar2.a);
                    if (bVar2.a.h() || bVar2.a.j()) {
                        this.N.remove(this.ac);
                    } else {
                        this.ac++;
                    }
                    bVar2 = this.ac < this.N.size() ? this.N.get(this.ac) : null;
                }
                return;
            }
            bVar2 = null;
        }
        bVar = null;
    }

    private void b(com.anythink.expressad.exoplayer.ac acVar) {
        this.Q = acVar;
    }

    private void b(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(10, rVar).sendToTarget();
    }

    private void b(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.Z++;
        a(true, z, z2);
        this.C.a();
        this.S = sVar;
        b(2);
        sVar.a(this.G, true, this);
        this.D.b(2);
    }

    private void b(com.anythink.expressad.exoplayer.y yVar) {
        this.L.b(yVar);
        a(yVar);
        yVar.l();
    }

    private void c(int i2) {
        this.X = i2;
        if (this.P.a(i2)) {
            return;
        }
        g(true);
    }

    private void c(com.anythink.expressad.exoplayer.h.r rVar) {
        if (this.P.a(rVar)) {
            com.anythink.expressad.exoplayer.q b2 = this.P.b();
            float f2 = this.L.e().b;
            b2.f = true;
            b2.j = b2.a.b();
            b2.a(f2);
            long b3 = b2.b(b2.h.b);
            long j2 = b2.e;
            com.anythink.expressad.exoplayer.r rVar2 = b2.h;
            b2.e = j2 + (rVar2.b - b3);
            b2.h = new com.anythink.expressad.exoplayer.r(rVar2.a, b3, rVar2.c, rVar2.d, rVar2.e, rVar2.f, rVar2.g);
            a(b2.k);
            if (!this.P.f()) {
                a(this.P.h().h.b);
                a((com.anythink.expressad.exoplayer.q) null);
            }
            r();
        }
    }

    private void c(com.anythink.expressad.exoplayer.v vVar) {
        this.L.a(vVar);
    }

    private void c(com.anythink.expressad.exoplayer.x xVar) {
        if (xVar.f() == -9223372036854775807L) {
            d(xVar);
            return;
        }
        if (this.S == null || this.Z > 0) {
            this.N.add(new com.anythink.expressad.exoplayer.k.b(xVar));
            return;
        }
        com.anythink.expressad.exoplayer.k.b bVar = new com.anythink.expressad.exoplayer.k.b(xVar);
        if (!a(bVar)) {
            xVar.a(false);
        } else {
            this.N.add(bVar);
            java.util.Collections.sort(this.N);
        }
    }

    private boolean c(com.anythink.expressad.exoplayer.y yVar) {
        com.anythink.expressad.exoplayer.q qVar = this.P.d().i;
        return qVar != null && qVar.f && yVar.g();
    }

    private void d() {
        if (this.M.a(this.R)) {
            this.F.obtainMessage(0, this.M.b, this.M.c ? this.M.d : -1, this.R).sendToTarget();
            this.M.b(this.R);
        }
    }

    private void d(com.anythink.expressad.exoplayer.h.r rVar) {
        if (this.P.a(rVar)) {
            this.P.a(this.ab);
            r();
        }
    }

    private void d(com.anythink.expressad.exoplayer.x xVar) {
        if (xVar.e().getLooper() != this.D.a()) {
            this.D.a(15, xVar).sendToTarget();
            return;
        }
        f(xVar);
        int i2 = this.R.f;
        if (i2 == 3 || i2 == 2) {
            this.D.b(2);
        }
    }

    private void d(boolean z) {
        com.anythink.expressad.exoplayer.u uVar = this.R;
        if (uVar.g != z) {
            this.R = uVar.a(z);
        }
    }

    private void e() {
        this.W = false;
        this.L.a();
        for (com.anythink.expressad.exoplayer.y yVar : this.T) {
            yVar.b_();
        }
    }

    private void e(com.anythink.expressad.exoplayer.x xVar) {
        xVar.e().post(new com.anythink.expressad.exoplayer.k.AnonymousClass1(xVar));
    }

    private void e(boolean z) {
        this.W = false;
        this.V = z;
        if (!z) {
            f();
            g();
            return;
        }
        int i2 = this.R.f;
        if (i2 == 3) {
            e();
            this.D.b(2);
        } else if (i2 == 2) {
            this.D.b(2);
        }
    }

    private void f() {
        this.L.b();
        for (com.anythink.expressad.exoplayer.y yVar : this.T) {
            a(yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(com.anythink.expressad.exoplayer.x xVar) {
        if (xVar.j()) {
            return;
        }
        try {
            xVar.b().a(xVar.c(), xVar.d());
        } finally {
            xVar.a(true);
        }
    }

    private void f(boolean z) {
        this.Y = z;
        if (this.P.a(z)) {
            return;
        }
        g(true);
    }

    private void g() {
        if (this.P.f()) {
            com.anythink.expressad.exoplayer.q c2 = this.P.c();
            long c3 = c2.a.c();
            if (c3 != -9223372036854775807L) {
                a(c3);
                if (c3 != this.R.j) {
                    com.anythink.expressad.exoplayer.u uVar = this.R;
                    this.R = uVar.a(uVar.c, c3, uVar.e);
                    this.M.b(4);
                }
            } else {
                long c4 = this.L.c();
                this.ab = c4;
                long j2 = c4 - c2.e;
                b(this.R.j, j2);
                this.R.j = j2;
            }
            this.R.k = this.T.length == 0 ? c2.h.e : c2.a(true);
        }
    }

    private void g(boolean z) {
        com.anythink.expressad.exoplayer.h.s.a aVar = this.P.c().h.a;
        long a2 = a(aVar, this.R.j, true);
        if (a2 != this.R.j) {
            com.anythink.expressad.exoplayer.u uVar = this.R;
            this.R = uVar.a(aVar, a2, uVar.e);
            if (z) {
                this.M.b(4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x0295, code lost:
    
        if (r19.C.a(r6 - (r19.ab - r3.e), r19.L.e().b, r19.W) == false) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0218  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        boolean z;
        int i2;
        boolean z2;
        long b2 = this.O.b();
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            if (this.Z > 0) {
                sVar.b();
            } else {
                this.P.a(this.ab);
                if (this.P.a()) {
                    com.anythink.expressad.exoplayer.r a2 = this.P.a(this.ab, this.R);
                    if (a2 == null) {
                        this.S.b();
                    } else {
                        this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(a2.a.a, this.I, true).b, a2).a(this, a2.b);
                        d(true);
                    }
                }
                com.anythink.expressad.exoplayer.q b3 = this.P.b();
                if (b3 == null || b3.a()) {
                    d(false);
                } else if (!this.R.g) {
                    r();
                }
                if (this.P.f()) {
                    com.anythink.expressad.exoplayer.q c2 = this.P.c();
                    com.anythink.expressad.exoplayer.q d2 = this.P.d();
                    boolean z3 = false;
                    while (this.V && c2 != d2 && this.ab >= c2.i.e) {
                        if (z3) {
                            d();
                        }
                        int i3 = c2.h.f ? 0 : 3;
                        com.anythink.expressad.exoplayer.q h2 = this.P.h();
                        a(c2);
                        com.anythink.expressad.exoplayer.u uVar = this.R;
                        com.anythink.expressad.exoplayer.r rVar = h2.h;
                        this.R = uVar.a(rVar.a, rVar.b, rVar.d);
                        this.M.b(i3);
                        g();
                        c2 = h2;
                        z3 = true;
                    }
                    if (d2.h.g) {
                        int i4 = 0;
                        while (true) {
                            com.anythink.expressad.exoplayer.y[] yVarArr = this.y;
                            if (i4 >= yVarArr.length) {
                                break;
                            }
                            com.anythink.expressad.exoplayer.y yVar = yVarArr[i4];
                            com.anythink.expressad.exoplayer.h.y yVar2 = d2.c[i4];
                            if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                                yVar.h();
                            }
                            i4++;
                        }
                    } else {
                        com.anythink.expressad.exoplayer.q qVar = d2.i;
                        if (qVar != null && qVar.f) {
                            int i5 = 0;
                            while (true) {
                                com.anythink.expressad.exoplayer.y[] yVarArr2 = this.y;
                                if (i5 >= yVarArr2.length) {
                                    com.anythink.expressad.exoplayer.i.i iVar = d2.k;
                                    com.anythink.expressad.exoplayer.q g2 = this.P.g();
                                    com.anythink.expressad.exoplayer.i.i iVar2 = g2.k;
                                    boolean z4 = g2.a.c() != -9223372036854775807L;
                                    int i6 = 0;
                                    while (true) {
                                        com.anythink.expressad.exoplayer.y[] yVarArr3 = this.y;
                                        if (i6 >= yVarArr3.length) {
                                            break;
                                        }
                                        com.anythink.expressad.exoplayer.y yVar3 = yVarArr3[i6];
                                        if (iVar.a(i6)) {
                                            if (!z4) {
                                                if (!yVar3.i()) {
                                                    com.anythink.expressad.exoplayer.i.f a3 = iVar2.c.a(i6);
                                                    boolean a4 = iVar2.a(i6);
                                                    boolean z5 = this.z[i6].a() == 5;
                                                    com.anythink.expressad.exoplayer.aa aaVar = iVar.b[i6];
                                                    com.anythink.expressad.exoplayer.aa aaVar2 = iVar2.b[i6];
                                                    if (a4 && aaVar2.equals(aaVar) && !z5) {
                                                        yVar3.a(a(a3), g2.c[i6], g2.e);
                                                    }
                                                }
                                            }
                                            yVar3.h();
                                        }
                                        i6++;
                                    }
                                } else {
                                    com.anythink.expressad.exoplayer.y yVar4 = yVarArr2[i5];
                                    com.anythink.expressad.exoplayer.h.y yVar5 = d2.c[i5];
                                    if (yVar4.f() != yVar5 || (yVar5 != null && !yVar4.g())) {
                                        break;
                                    } else {
                                        i5++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!this.P.f()) {
            n();
            a(b2, 10L);
            return;
        }
        com.anythink.expressad.exoplayer.q c3 = this.P.c();
        com.anythink.expressad.exoplayer.k.ad.a("doSomeWork");
        g();
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        c3.a.a(this.R.j - this.J, this.K);
        boolean z6 = true;
        boolean z7 = true;
        for (com.anythink.expressad.exoplayer.y yVar6 : this.T) {
            yVar6.a(this.ab, elapsedRealtime);
            z7 = z7 && yVar6.v();
            if (!yVar6.u() && !yVar6.v()) {
                com.anythink.expressad.exoplayer.q qVar2 = this.P.d().i;
                if (!(qVar2 != null && qVar2.f && yVar6.g())) {
                    z2 = false;
                    if (!z2) {
                        yVar6.j();
                    }
                    z6 = !z6 && z2;
                }
            }
            z2 = true;
            if (!z2) {
            }
            if (z6) {
            }
        }
        if (!z6) {
            n();
        }
        long j2 = c3.h.e;
        if (!z7 || ((j2 != -9223372036854775807L && j2 > this.R.j) || !c3.h.g)) {
            com.anythink.expressad.exoplayer.u uVar2 = this.R;
            if (uVar2.f == 2) {
                if (this.T.length == 0) {
                    z = m();
                } else {
                    if (z6) {
                        if (uVar2.g) {
                            com.anythink.expressad.exoplayer.q b4 = this.P.b();
                            long a5 = b4.a(!b4.h.g);
                            if (a5 != Long.MIN_VALUE) {
                            }
                        }
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    b(3);
                    if (this.V) {
                        e();
                    }
                }
            }
            if (this.R.f == 3 && (this.T.length != 0 ? !z6 : !m())) {
                this.W = this.V;
                b(2);
                f();
            }
        } else {
            b(4);
            f();
        }
        if (this.R.f == 2) {
            for (com.anythink.expressad.exoplayer.y yVar7 : this.T) {
                yVar7.j();
            }
        }
        if ((this.V && this.R.f == 3) || (i2 = this.R.f) == 2) {
            a(b2, 10L);
        } else if (this.T.length == 0 || i2 == 4) {
            this.D.b();
        } else {
            a(b2, 1000L);
        }
        com.anythink.expressad.exoplayer.k.ad.a();
    }

    private boolean h(boolean z) {
        if (this.T.length == 0) {
            return m();
        }
        if (!z) {
            return false;
        }
        if (!this.R.g) {
            return true;
        }
        com.anythink.expressad.exoplayer.q b2 = this.P.b();
        long a2 = b2.a(!b2.h.g);
        return a2 == Long.MIN_VALUE || this.C.a(a2 - (this.ab - b2.e), this.L.e().b, this.W);
    }

    private void i() {
        a(true, true, true);
        this.C.c();
        b(1);
        this.E.quitSafely();
        synchronized (this) {
            this.U = true;
            notifyAll();
        }
    }

    private int j() {
        com.anythink.expressad.exoplayer.ae aeVar = this.R.a;
        if (aeVar.a()) {
            return 0;
        }
        return aeVar.a(aeVar.b(this.Y), this.H, false).f;
    }

    private void k() {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            if (!a(this.N.get(size))) {
                this.N.get(size).a.a(false);
                this.N.remove(size);
            }
        }
        java.util.Collections.sort(this.N);
    }

    private void l() {
        if (this.P.f()) {
            float f2 = this.L.e().b;
            com.anythink.expressad.exoplayer.q d2 = this.P.d();
            boolean z = true;
            for (com.anythink.expressad.exoplayer.q c2 = this.P.c(); c2 != null && c2.f; c2 = c2.i) {
                if (c2.a(f2)) {
                    if (z) {
                        com.anythink.expressad.exoplayer.q c3 = this.P.c();
                        boolean a2 = this.P.a(c3);
                        boolean[] zArr = new boolean[this.y.length];
                        long a3 = c3.a(this.R.j, a2, zArr);
                        a(c3.k);
                        com.anythink.expressad.exoplayer.u uVar = this.R;
                        if (uVar.f != 4 && a3 != uVar.j) {
                            com.anythink.expressad.exoplayer.u uVar2 = this.R;
                            this.R = uVar2.a(uVar2.c, a3, uVar2.e);
                            this.M.b(4);
                            a(a3);
                        }
                        boolean[] zArr2 = new boolean[this.y.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            com.anythink.expressad.exoplayer.y[] yVarArr = this.y;
                            if (i2 >= yVarArr.length) {
                                break;
                            }
                            com.anythink.expressad.exoplayer.y yVar = yVarArr[i2];
                            boolean z2 = yVar.a_() != 0;
                            zArr2[i2] = z2;
                            com.anythink.expressad.exoplayer.h.y yVar2 = c3.c[i2];
                            if (yVar2 != null) {
                                i3++;
                            }
                            if (z2) {
                                if (yVar2 != yVar.f()) {
                                    b(yVar);
                                } else if (zArr[i2]) {
                                    yVar.a(this.ab);
                                }
                            }
                            i2++;
                        }
                        this.R = this.R.a(c3.j, c3.k);
                        a(zArr2, i3);
                    } else {
                        this.P.a(c2);
                        if (c2.f) {
                            c2.b(java.lang.Math.max(c2.h.b, this.ab - c2.e));
                            a(c2.k);
                        }
                    }
                    if (this.R.f != 4) {
                        r();
                        g();
                        this.D.b(2);
                        return;
                    }
                    return;
                }
                if (c2 == d2) {
                    z = false;
                }
            }
        }
    }

    private boolean m() {
        com.anythink.expressad.exoplayer.q c2 = this.P.c();
        long j2 = c2.h.e;
        if (j2 == -9223372036854775807L || this.R.j < j2) {
            return true;
        }
        com.anythink.expressad.exoplayer.q qVar = c2.i;
        if (qVar != null) {
            return qVar.f || qVar.h.a.a();
        }
        return false;
    }

    private void n() {
        com.anythink.expressad.exoplayer.q b2 = this.P.b();
        com.anythink.expressad.exoplayer.q d2 = this.P.d();
        if (b2 == null || b2.f) {
            return;
        }
        if (d2 == null || d2.i == b2) {
            for (com.anythink.expressad.exoplayer.y yVar : this.T) {
                if (!yVar.g()) {
                    return;
                }
            }
            b2.a.a();
        }
    }

    private void o() {
        b(4);
        a(false, true, false);
    }

    private void p() {
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar == null) {
            return;
        }
        if (this.Z > 0) {
            sVar.b();
            return;
        }
        this.P.a(this.ab);
        if (this.P.a()) {
            com.anythink.expressad.exoplayer.r a2 = this.P.a(this.ab, this.R);
            if (a2 == null) {
                this.S.b();
            } else {
                this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(a2.a.a, this.I, true).b, a2).a(this, a2.b);
                d(true);
            }
        }
        com.anythink.expressad.exoplayer.q b2 = this.P.b();
        int i2 = 0;
        if (b2 == null || b2.a()) {
            d(false);
        } else if (!this.R.g) {
            r();
        }
        if (!this.P.f()) {
            return;
        }
        com.anythink.expressad.exoplayer.q c2 = this.P.c();
        com.anythink.expressad.exoplayer.q d2 = this.P.d();
        boolean z = false;
        while (this.V && c2 != d2 && this.ab >= c2.i.e) {
            if (z) {
                d();
            }
            int i3 = c2.h.f ? 0 : 3;
            com.anythink.expressad.exoplayer.q h2 = this.P.h();
            a(c2);
            com.anythink.expressad.exoplayer.u uVar = this.R;
            com.anythink.expressad.exoplayer.r rVar = h2.h;
            this.R = uVar.a(rVar.a, rVar.b, rVar.d);
            this.M.b(i3);
            g();
            c2 = h2;
            z = true;
        }
        if (d2.h.g) {
            while (true) {
                com.anythink.expressad.exoplayer.y[] yVarArr = this.y;
                if (i2 >= yVarArr.length) {
                    return;
                }
                com.anythink.expressad.exoplayer.y yVar = yVarArr[i2];
                com.anythink.expressad.exoplayer.h.y yVar2 = d2.c[i2];
                if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                    yVar.h();
                }
                i2++;
            }
        } else {
            com.anythink.expressad.exoplayer.q qVar = d2.i;
            if (qVar == null || !qVar.f) {
                return;
            }
            int i4 = 0;
            while (true) {
                com.anythink.expressad.exoplayer.y[] yVarArr2 = this.y;
                if (i4 < yVarArr2.length) {
                    com.anythink.expressad.exoplayer.y yVar3 = yVarArr2[i4];
                    com.anythink.expressad.exoplayer.h.y yVar4 = d2.c[i4];
                    if (yVar3.f() != yVar4) {
                        return;
                    }
                    if (yVar4 != null && !yVar3.g()) {
                        return;
                    } else {
                        i4++;
                    }
                } else {
                    com.anythink.expressad.exoplayer.i.i iVar = d2.k;
                    com.anythink.expressad.exoplayer.q g2 = this.P.g();
                    com.anythink.expressad.exoplayer.i.i iVar2 = g2.k;
                    boolean z2 = g2.a.c() != -9223372036854775807L;
                    int i5 = 0;
                    while (true) {
                        com.anythink.expressad.exoplayer.y[] yVarArr3 = this.y;
                        if (i5 >= yVarArr3.length) {
                            return;
                        }
                        com.anythink.expressad.exoplayer.y yVar5 = yVarArr3[i5];
                        if (iVar.a(i5)) {
                            if (!z2) {
                                if (!yVar5.i()) {
                                    com.anythink.expressad.exoplayer.i.f a3 = iVar2.c.a(i5);
                                    boolean a4 = iVar2.a(i5);
                                    boolean z3 = this.z[i5].a() == 5;
                                    com.anythink.expressad.exoplayer.aa aaVar = iVar.b[i5];
                                    com.anythink.expressad.exoplayer.aa aaVar2 = iVar2.b[i5];
                                    if (a4 && aaVar2.equals(aaVar) && !z3) {
                                        yVar5.a(a(a3), g2.c[i5], g2.e);
                                    }
                                }
                            }
                            yVar5.h();
                        }
                        i5++;
                    }
                }
            }
        }
    }

    private void q() {
        this.P.a(this.ab);
        if (this.P.a()) {
            com.anythink.expressad.exoplayer.r a2 = this.P.a(this.ab, this.R);
            if (a2 == null) {
                this.S.b();
                return;
            }
            this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(a2.a.a, this.I, true).b, a2).a(this, a2.b);
            d(true);
        }
    }

    private void r() {
        com.anythink.expressad.exoplayer.q b2 = this.P.b();
        long b3 = b2.b();
        if (b3 == Long.MIN_VALUE) {
            d(false);
            return;
        }
        boolean a2 = this.C.a(b3 - (this.ab - b2.e), this.L.e().b);
        d(a2);
        if (a2) {
            b2.a(this.ab);
        }
    }

    public final synchronized void a() {
        if (!this.U && this.E.isAlive()) {
            this.D.b(7);
            long j2 = 500;
            long a2 = this.O.a() + 500;
            boolean z = false;
            while (!this.U && j2 > 0) {
                try {
                    wait(j2);
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                }
                j2 = a2 - this.O.a();
            }
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    public final void a(int i2) {
        this.D.a(12, i2).sendToTarget();
    }

    public final void a(com.anythink.expressad.exoplayer.ac acVar) {
        this.D.a(5, acVar).sendToTarget();
    }

    public final void a(com.anythink.expressad.exoplayer.ae aeVar, int i2, long j2) {
        this.D.a(3, new com.anythink.expressad.exoplayer.k.d(aeVar, i2, j2)).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(9, rVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.h.s.b
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, java.lang.Object obj) {
        this.D.a(8, new com.anythink.expressad.exoplayer.k.a(sVar, aeVar, obj)).sendToTarget();
    }

    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.D.a(z ? 1 : 0, z2 ? 1 : 0, sVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.D.a(10, rVar).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.e.a
    public final void a(com.anythink.expressad.exoplayer.v vVar) {
        this.F.obtainMessage(1, vVar).sendToTarget();
        float f2 = vVar.b;
        for (com.anythink.expressad.exoplayer.q e2 = this.P.e(); e2 != null; e2 = e2.i) {
            com.anythink.expressad.exoplayer.i.i iVar = e2.k;
            if (iVar != null) {
                for (com.anythink.expressad.exoplayer.i.f fVar : iVar.c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.x.a
    public final synchronized void a(com.anythink.expressad.exoplayer.x xVar) {
        if (this.U) {
            xVar.a(false);
        } else {
            this.D.a(14, xVar).sendToTarget();
        }
    }

    public final void a(boolean z) {
        this.D.a(1, z ? 1 : 0).sendToTarget();
    }

    public final android.os.Looper b() {
        return this.E.getLooper();
    }

    public final void b(com.anythink.expressad.exoplayer.v vVar) {
        this.D.a(4, vVar).sendToTarget();
    }

    public final void b(boolean z) {
        this.D.a(13, z ? 1 : 0).sendToTarget();
    }

    @Override // com.anythink.expressad.exoplayer.i.h.a
    public final void c() {
        this.D.b(11);
    }

    public final void c(boolean z) {
        this.D.a(6, z ? 1 : 0).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:478:0x07e2, code lost:
    
        if (r14 == false) goto L403;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x048b A[Catch: all -> 0x04fe, TryCatch #10 {all -> 0x04fe, blocks: (B:218:0x047e, B:220:0x0482, B:225:0x048b, B:231:0x0494, B:233:0x049e, B:237:0x04aa, B:238:0x04b4, B:240:0x04c4, B:244:0x04dd, B:247:0x04e8, B:251:0x04ec), top: B:217:0x047e }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04fa A[Catch: RuntimeException -> 0x0897, IOException -> 0x089b, g -> 0x08a0, TryCatch #3 {RuntimeException -> 0x0897, blocks: (B:9:0x0017, B:10:0x0893, B:12:0x0029, B:14:0x0035, B:15:0x003a, B:17:0x003e, B:20:0x0043, B:22:0x004e, B:23:0x005a, B:24:0x005f, B:25:0x006b, B:28:0x0072, B:30:0x007c, B:32:0x0081, B:34:0x008d, B:35:0x0092, B:37:0x009a, B:39:0x00b1, B:41:0x00b7, B:46:0x00c0, B:50:0x00c5, B:52:0x00e9, B:54:0x00ef, B:55:0x0106, B:56:0x010d, B:58:0x0112, B:61:0x011d, B:63:0x0125, B:65:0x0129, B:67:0x012f, B:70:0x0133, B:72:0x0137, B:69:0x013c, B:78:0x013f, B:79:0x016d, B:81:0x0173, B:82:0x014f, B:84:0x0158, B:88:0x0180, B:90:0x018c, B:91:0x0198, B:93:0x01a4, B:95:0x01fa, B:96:0x020a, B:97:0x020f, B:99:0x0219, B:101:0x0238, B:103:0x0246, B:105:0x0259, B:108:0x025c, B:111:0x0265, B:114:0x026d, B:116:0x0271, B:118:0x027a, B:121:0x027f, B:124:0x02a0, B:126:0x02a8, B:128:0x02b0, B:130:0x02b6, B:131:0x02bb, B:134:0x02e6, B:136:0x02f9, B:138:0x0307, B:140:0x030d, B:143:0x031e, B:145:0x0328, B:147:0x0330, B:148:0x033c, B:150:0x0343, B:152:0x0349, B:153:0x034e, B:155:0x0379, B:156:0x0385, B:158:0x0389, B:165:0x0391, B:161:0x039c, B:168:0x03a5, B:171:0x03ad, B:174:0x03bf, B:175:0x03c7, B:177:0x03d1, B:179:0x03dd, B:182:0x03e5, B:184:0x03f5, B:188:0x033a, B:204:0x0405, B:206:0x040a, B:209:0x0411, B:211:0x0417, B:212:0x041f, B:213:0x042a, B:215:0x043a, B:227:0x04f0, B:229:0x04fa, B:230:0x04d7, B:241:0x04c8, B:243:0x04d4, B:253:0x04ff, B:255:0x050c, B:257:0x050f, B:259:0x051d, B:260:0x0449, B:263:0x046a, B:269:0x051e, B:271:0x0528, B:273:0x052c, B:274:0x0531, B:276:0x0540, B:278:0x054c, B:279:0x0552, B:280:0x0586, B:282:0x058e, B:285:0x0595, B:287:0x059b, B:288:0x05a3, B:290:0x05ab, B:291:0x05b8, B:294:0x05be, B:297:0x05ca, B:298:0x05cd, B:302:0x05d6, B:306:0x05ff, B:309:0x0606, B:311:0x060b, B:313:0x0613, B:315:0x0619, B:317:0x061f, B:319:0x0622, B:324:0x0625, B:326:0x0629, B:330:0x0630, B:332:0x0635, B:335:0x0643, B:340:0x064b, B:344:0x064e, B:348:0x0666, B:350:0x066b, B:353:0x0675, B:355:0x067b, B:358:0x0693, B:360:0x069d, B:363:0x06a5, B:368:0x06b3, B:365:0x06b6, B:375:0x059f, B:376:0x06be, B:378:0x06c8, B:379:0x06d0, B:381:0x06fc, B:383:0x0705, B:386:0x070e, B:388:0x0714, B:390:0x071a, B:392:0x0724, B:394:0x0728, B:401:0x0739, B:406:0x0743, B:414:0x074c, B:415:0x074f, B:419:0x075e, B:421:0x0766, B:423:0x076c, B:424:0x07ef, B:426:0x07f6, B:428:0x07fc, B:430:0x0804, B:432:0x0808, B:434:0x0816, B:435:0x082f, B:436:0x080f, B:438:0x081c, B:442:0x0824, B:443:0x082a, B:444:0x0775, B:446:0x077c, B:448:0x0781, B:450:0x07c3, B:452:0x07cb, B:454:0x0788, B:457:0x078e, B:460:0x079d, B:462:0x07a7, B:467:0x07cf, B:469:0x07d6, B:471:0x07db, B:474:0x07e4, B:476:0x07e9, B:477:0x07ec, B:479:0x0833, B:482:0x083a, B:484:0x0841, B:485:0x0848, B:487:0x084f, B:490:0x085c, B:492:0x0862, B:495:0x086d, B:498:0x0874), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0494 A[Catch: all -> 0x04fe, TryCatch #10 {all -> 0x04fe, blocks: (B:218:0x047e, B:220:0x0482, B:225:0x048b, B:231:0x0494, B:233:0x049e, B:237:0x04aa, B:238:0x04b4, B:240:0x04c4, B:244:0x04dd, B:247:0x04e8, B:251:0x04ec), top: B:217:0x047e }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x05ab A[Catch: RuntimeException -> 0x0897, IOException -> 0x089b, g -> 0x08a0, TryCatch #3 {RuntimeException -> 0x0897, blocks: (B:9:0x0017, B:10:0x0893, B:12:0x0029, B:14:0x0035, B:15:0x003a, B:17:0x003e, B:20:0x0043, B:22:0x004e, B:23:0x005a, B:24:0x005f, B:25:0x006b, B:28:0x0072, B:30:0x007c, B:32:0x0081, B:34:0x008d, B:35:0x0092, B:37:0x009a, B:39:0x00b1, B:41:0x00b7, B:46:0x00c0, B:50:0x00c5, B:52:0x00e9, B:54:0x00ef, B:55:0x0106, B:56:0x010d, B:58:0x0112, B:61:0x011d, B:63:0x0125, B:65:0x0129, B:67:0x012f, B:70:0x0133, B:72:0x0137, B:69:0x013c, B:78:0x013f, B:79:0x016d, B:81:0x0173, B:82:0x014f, B:84:0x0158, B:88:0x0180, B:90:0x018c, B:91:0x0198, B:93:0x01a4, B:95:0x01fa, B:96:0x020a, B:97:0x020f, B:99:0x0219, B:101:0x0238, B:103:0x0246, B:105:0x0259, B:108:0x025c, B:111:0x0265, B:114:0x026d, B:116:0x0271, B:118:0x027a, B:121:0x027f, B:124:0x02a0, B:126:0x02a8, B:128:0x02b0, B:130:0x02b6, B:131:0x02bb, B:134:0x02e6, B:136:0x02f9, B:138:0x0307, B:140:0x030d, B:143:0x031e, B:145:0x0328, B:147:0x0330, B:148:0x033c, B:150:0x0343, B:152:0x0349, B:153:0x034e, B:155:0x0379, B:156:0x0385, B:158:0x0389, B:165:0x0391, B:161:0x039c, B:168:0x03a5, B:171:0x03ad, B:174:0x03bf, B:175:0x03c7, B:177:0x03d1, B:179:0x03dd, B:182:0x03e5, B:184:0x03f5, B:188:0x033a, B:204:0x0405, B:206:0x040a, B:209:0x0411, B:211:0x0417, B:212:0x041f, B:213:0x042a, B:215:0x043a, B:227:0x04f0, B:229:0x04fa, B:230:0x04d7, B:241:0x04c8, B:243:0x04d4, B:253:0x04ff, B:255:0x050c, B:257:0x050f, B:259:0x051d, B:260:0x0449, B:263:0x046a, B:269:0x051e, B:271:0x0528, B:273:0x052c, B:274:0x0531, B:276:0x0540, B:278:0x054c, B:279:0x0552, B:280:0x0586, B:282:0x058e, B:285:0x0595, B:287:0x059b, B:288:0x05a3, B:290:0x05ab, B:291:0x05b8, B:294:0x05be, B:297:0x05ca, B:298:0x05cd, B:302:0x05d6, B:306:0x05ff, B:309:0x0606, B:311:0x060b, B:313:0x0613, B:315:0x0619, B:317:0x061f, B:319:0x0622, B:324:0x0625, B:326:0x0629, B:330:0x0630, B:332:0x0635, B:335:0x0643, B:340:0x064b, B:344:0x064e, B:348:0x0666, B:350:0x066b, B:353:0x0675, B:355:0x067b, B:358:0x0693, B:360:0x069d, B:363:0x06a5, B:368:0x06b3, B:365:0x06b6, B:375:0x059f, B:376:0x06be, B:378:0x06c8, B:379:0x06d0, B:381:0x06fc, B:383:0x0705, B:386:0x070e, B:388:0x0714, B:390:0x071a, B:392:0x0724, B:394:0x0728, B:401:0x0739, B:406:0x0743, B:414:0x074c, B:415:0x074f, B:419:0x075e, B:421:0x0766, B:423:0x076c, B:424:0x07ef, B:426:0x07f6, B:428:0x07fc, B:430:0x0804, B:432:0x0808, B:434:0x0816, B:435:0x082f, B:436:0x080f, B:438:0x081c, B:442:0x0824, B:443:0x082a, B:444:0x0775, B:446:0x077c, B:448:0x0781, B:450:0x07c3, B:452:0x07cb, B:454:0x0788, B:457:0x078e, B:460:0x079d, B:462:0x07a7, B:467:0x07cf, B:469:0x07d6, B:471:0x07db, B:474:0x07e4, B:476:0x07e9, B:477:0x07ec, B:479:0x0833, B:482:0x083a, B:484:0x0841, B:485:0x0848, B:487:0x084f, B:490:0x085c, B:492:0x0862, B:495:0x086d, B:498:0x0874), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0739 A[Catch: RuntimeException -> 0x0897, IOException -> 0x089b, g -> 0x08a0, TryCatch #3 {RuntimeException -> 0x0897, blocks: (B:9:0x0017, B:10:0x0893, B:12:0x0029, B:14:0x0035, B:15:0x003a, B:17:0x003e, B:20:0x0043, B:22:0x004e, B:23:0x005a, B:24:0x005f, B:25:0x006b, B:28:0x0072, B:30:0x007c, B:32:0x0081, B:34:0x008d, B:35:0x0092, B:37:0x009a, B:39:0x00b1, B:41:0x00b7, B:46:0x00c0, B:50:0x00c5, B:52:0x00e9, B:54:0x00ef, B:55:0x0106, B:56:0x010d, B:58:0x0112, B:61:0x011d, B:63:0x0125, B:65:0x0129, B:67:0x012f, B:70:0x0133, B:72:0x0137, B:69:0x013c, B:78:0x013f, B:79:0x016d, B:81:0x0173, B:82:0x014f, B:84:0x0158, B:88:0x0180, B:90:0x018c, B:91:0x0198, B:93:0x01a4, B:95:0x01fa, B:96:0x020a, B:97:0x020f, B:99:0x0219, B:101:0x0238, B:103:0x0246, B:105:0x0259, B:108:0x025c, B:111:0x0265, B:114:0x026d, B:116:0x0271, B:118:0x027a, B:121:0x027f, B:124:0x02a0, B:126:0x02a8, B:128:0x02b0, B:130:0x02b6, B:131:0x02bb, B:134:0x02e6, B:136:0x02f9, B:138:0x0307, B:140:0x030d, B:143:0x031e, B:145:0x0328, B:147:0x0330, B:148:0x033c, B:150:0x0343, B:152:0x0349, B:153:0x034e, B:155:0x0379, B:156:0x0385, B:158:0x0389, B:165:0x0391, B:161:0x039c, B:168:0x03a5, B:171:0x03ad, B:174:0x03bf, B:175:0x03c7, B:177:0x03d1, B:179:0x03dd, B:182:0x03e5, B:184:0x03f5, B:188:0x033a, B:204:0x0405, B:206:0x040a, B:209:0x0411, B:211:0x0417, B:212:0x041f, B:213:0x042a, B:215:0x043a, B:227:0x04f0, B:229:0x04fa, B:230:0x04d7, B:241:0x04c8, B:243:0x04d4, B:253:0x04ff, B:255:0x050c, B:257:0x050f, B:259:0x051d, B:260:0x0449, B:263:0x046a, B:269:0x051e, B:271:0x0528, B:273:0x052c, B:274:0x0531, B:276:0x0540, B:278:0x054c, B:279:0x0552, B:280:0x0586, B:282:0x058e, B:285:0x0595, B:287:0x059b, B:288:0x05a3, B:290:0x05ab, B:291:0x05b8, B:294:0x05be, B:297:0x05ca, B:298:0x05cd, B:302:0x05d6, B:306:0x05ff, B:309:0x0606, B:311:0x060b, B:313:0x0613, B:315:0x0619, B:317:0x061f, B:319:0x0622, B:324:0x0625, B:326:0x0629, B:330:0x0630, B:332:0x0635, B:335:0x0643, B:340:0x064b, B:344:0x064e, B:348:0x0666, B:350:0x066b, B:353:0x0675, B:355:0x067b, B:358:0x0693, B:360:0x069d, B:363:0x06a5, B:368:0x06b3, B:365:0x06b6, B:375:0x059f, B:376:0x06be, B:378:0x06c8, B:379:0x06d0, B:381:0x06fc, B:383:0x0705, B:386:0x070e, B:388:0x0714, B:390:0x071a, B:392:0x0724, B:394:0x0728, B:401:0x0739, B:406:0x0743, B:414:0x074c, B:415:0x074f, B:419:0x075e, B:421:0x0766, B:423:0x076c, B:424:0x07ef, B:426:0x07f6, B:428:0x07fc, B:430:0x0804, B:432:0x0808, B:434:0x0816, B:435:0x082f, B:436:0x080f, B:438:0x081c, B:442:0x0824, B:443:0x082a, B:444:0x0775, B:446:0x077c, B:448:0x0781, B:450:0x07c3, B:452:0x07cb, B:454:0x0788, B:457:0x078e, B:460:0x079d, B:462:0x07a7, B:467:0x07cf, B:469:0x07d6, B:471:0x07db, B:474:0x07e4, B:476:0x07e9, B:477:0x07ec, B:479:0x0833, B:482:0x083a, B:484:0x0841, B:485:0x0848, B:487:0x084f, B:490:0x085c, B:492:0x0862, B:495:0x086d, B:498:0x0874), top: B:5:0x0012 }] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(android.os.Message message) {
        boolean z;
        boolean z2;
        java.io.IOException iOException;
        boolean z3;
        com.anythink.expressad.exoplayer.g gVar;
        java.lang.RuntimeException runtimeException;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        long longValue;
        boolean z9;
        com.anythink.expressad.exoplayer.h.s.a aVar;
        long j2;
        int i4;
        com.anythink.expressad.exoplayer.k.c cVar;
        long j3;
        long j4;
        int i5 = 0;
        try {
            long j5 = 0;
            try {
                try {
                    try {
                        switch (message.what) {
                            case 0:
                                com.anythink.expressad.exoplayer.h.s sVar = (com.anythink.expressad.exoplayer.h.s) message.obj;
                                boolean z10 = message.arg1 != 0;
                                boolean z11 = message.arg2 != 0;
                                this.Z++;
                                a(true, z10, z11);
                                this.C.a();
                                this.S = sVar;
                                b(2);
                                sVar.a(this.G, true, this);
                                this.D.b(2);
                                d();
                                return true;
                            case 1:
                                boolean z12 = message.arg1 != 0;
                                this.W = false;
                                this.V = z12;
                                if (z12) {
                                    int i6 = this.R.f;
                                    if (i6 == 3) {
                                        e();
                                        this.D.b(2);
                                    } else if (i6 == 2) {
                                        this.D.b(2);
                                    }
                                } else {
                                    f();
                                    g();
                                }
                                d();
                                return true;
                            case 2:
                                long b2 = this.O.b();
                                com.anythink.expressad.exoplayer.h.s sVar2 = this.S;
                                if (sVar2 != null) {
                                    if (this.Z > 0) {
                                        sVar2.b();
                                    } else {
                                        this.P.a(this.ab);
                                        if (this.P.a()) {
                                            com.anythink.expressad.exoplayer.r a2 = this.P.a(this.ab, this.R);
                                            if (a2 == null) {
                                                this.S.b();
                                            } else {
                                                this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(a2.a.a, this.I, true).b, a2).a(this, a2.b);
                                                d(true);
                                            }
                                        }
                                        com.anythink.expressad.exoplayer.q b3 = this.P.b();
                                        if (b3 != null && !b3.a()) {
                                            if (!this.R.g) {
                                                r();
                                            }
                                            if (this.P.f()) {
                                                com.anythink.expressad.exoplayer.q c2 = this.P.c();
                                                com.anythink.expressad.exoplayer.q d2 = this.P.d();
                                                boolean z13 = false;
                                                while (this.V && c2 != d2 && this.ab >= c2.i.e) {
                                                    if (z13) {
                                                        d();
                                                    }
                                                    int i7 = c2.h.f ? 0 : 3;
                                                    com.anythink.expressad.exoplayer.q h2 = this.P.h();
                                                    a(c2);
                                                    com.anythink.expressad.exoplayer.u uVar = this.R;
                                                    com.anythink.expressad.exoplayer.r rVar = h2.h;
                                                    this.R = uVar.a(rVar.a, rVar.b, rVar.d);
                                                    this.M.b(i7);
                                                    g();
                                                    c2 = h2;
                                                    z13 = true;
                                                }
                                                if (d2.h.g) {
                                                    int i8 = 0;
                                                    while (true) {
                                                        com.anythink.expressad.exoplayer.y[] yVarArr = this.y;
                                                        if (i8 < yVarArr.length) {
                                                            com.anythink.expressad.exoplayer.y yVar = yVarArr[i8];
                                                            com.anythink.expressad.exoplayer.h.y yVar2 = d2.c[i8];
                                                            if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                                                                yVar.h();
                                                            }
                                                            i8++;
                                                        }
                                                    }
                                                } else {
                                                    com.anythink.expressad.exoplayer.q qVar = d2.i;
                                                    if (qVar != null && qVar.f) {
                                                        while (true) {
                                                            com.anythink.expressad.exoplayer.y[] yVarArr2 = this.y;
                                                            if (i3 < yVarArr2.length) {
                                                                com.anythink.expressad.exoplayer.y yVar3 = yVarArr2[i3];
                                                                com.anythink.expressad.exoplayer.h.y yVar4 = d2.c[i3];
                                                                i3 = (yVar3.f() == yVar4 && (yVar4 == null || yVar3.g())) ? i3 + 1 : 0;
                                                            } else {
                                                                com.anythink.expressad.exoplayer.i.i iVar = d2.k;
                                                                com.anythink.expressad.exoplayer.q g2 = this.P.g();
                                                                com.anythink.expressad.exoplayer.i.i iVar2 = g2.k;
                                                                boolean z14 = g2.a.c() != -9223372036854775807L;
                                                                int i9 = 0;
                                                                while (true) {
                                                                    com.anythink.expressad.exoplayer.y[] yVarArr3 = this.y;
                                                                    if (i9 < yVarArr3.length) {
                                                                        com.anythink.expressad.exoplayer.y yVar5 = yVarArr3[i9];
                                                                        if (iVar.a(i9)) {
                                                                            if (!z14) {
                                                                                if (!yVar5.i()) {
                                                                                    com.anythink.expressad.exoplayer.i.f a3 = iVar2.c.a(i9);
                                                                                    boolean a4 = iVar2.a(i9);
                                                                                    boolean z15 = this.z[i9].a() == 5;
                                                                                    com.anythink.expressad.exoplayer.aa aaVar = iVar.b[i9];
                                                                                    com.anythink.expressad.exoplayer.aa aaVar2 = iVar2.b[i9];
                                                                                    if (a4 && aaVar2.equals(aaVar) && !z15) {
                                                                                        yVar5.a(a(a3), g2.c[i9], g2.e);
                                                                                    }
                                                                                }
                                                                            }
                                                                            yVar5.h();
                                                                        }
                                                                        i9++;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        d(false);
                                        if (this.P.f()) {
                                        }
                                    }
                                }
                                if (this.P.f()) {
                                    com.anythink.expressad.exoplayer.q c3 = this.P.c();
                                    com.anythink.expressad.exoplayer.k.ad.a("doSomeWork");
                                    g();
                                    long elapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
                                    c3.a.a(this.R.j - this.J, this.K);
                                    boolean z16 = true;
                                    boolean z17 = true;
                                    for (com.anythink.expressad.exoplayer.y yVar6 : this.T) {
                                        yVar6.a(this.ab, elapsedRealtime);
                                        z17 = z17 && yVar6.v();
                                        if (!yVar6.u() && !yVar6.v()) {
                                            com.anythink.expressad.exoplayer.q qVar2 = this.P.d().i;
                                            if (!(qVar2 != null && qVar2.f && yVar6.g())) {
                                                z8 = false;
                                                if (!z8) {
                                                    yVar6.j();
                                                }
                                                z16 = !z16 && z8;
                                            }
                                        }
                                        z8 = true;
                                        if (!z8) {
                                        }
                                        if (z16) {
                                        }
                                    }
                                    if (!z16) {
                                        n();
                                    }
                                    long j6 = c3.h.e;
                                    if (!z17 || ((j6 != -9223372036854775807L && j6 > this.R.j) || !c3.h.g)) {
                                        com.anythink.expressad.exoplayer.u uVar2 = this.R;
                                        if (uVar2.f == 2) {
                                            if (this.T.length == 0) {
                                                z7 = m();
                                            } else {
                                                if (z16) {
                                                    if (uVar2.g) {
                                                        com.anythink.expressad.exoplayer.q b4 = this.P.b();
                                                        long a5 = b4.a(!b4.h.g);
                                                        if (a5 != Long.MIN_VALUE) {
                                                            if (this.C.a(a5 - (this.ab - b4.e), this.L.e().b, this.W)) {
                                                            }
                                                        }
                                                    }
                                                    z7 = true;
                                                }
                                                z7 = false;
                                            }
                                            if (z7) {
                                                b(3);
                                                if (this.V) {
                                                    e();
                                                }
                                            }
                                        }
                                        if (this.R.f == 3) {
                                            if (this.T.length == 0) {
                                                if (m()) {
                                                }
                                                this.W = this.V;
                                                b(2);
                                                f();
                                            }
                                        }
                                    } else {
                                        b(4);
                                        f();
                                    }
                                    if (this.R.f == 2) {
                                        for (com.anythink.expressad.exoplayer.y yVar7 : this.T) {
                                            yVar7.j();
                                        }
                                    }
                                    if ((this.V && this.R.f == 3) || (i2 = this.R.f) == 2) {
                                        a(b2, 10L);
                                    } else if (this.T.length == 0 || i2 == 4) {
                                        this.D.b();
                                    } else {
                                        a(b2, 1000L);
                                    }
                                    com.anythink.expressad.exoplayer.k.ad.a();
                                } else {
                                    n();
                                    a(b2, 10L);
                                }
                                d();
                                return true;
                            case 3:
                                com.anythink.expressad.exoplayer.k.d dVar = (com.anythink.expressad.exoplayer.k.d) message.obj;
                                this.M.a(1);
                                android.util.Pair<java.lang.Integer, java.lang.Long> a6 = a(dVar, true);
                                try {
                                    if (a6 == null) {
                                        aVar = new com.anythink.expressad.exoplayer.h.s.a(j());
                                        longValue = -9223372036854775807L;
                                        j2 = -9223372036854775807L;
                                    } else {
                                        int intValue = ((java.lang.Integer) a6.first).intValue();
                                        long longValue2 = ((java.lang.Long) a6.second).longValue();
                                        com.anythink.expressad.exoplayer.h.s.a a7 = this.P.a(intValue, longValue2);
                                        if (!a7.a()) {
                                            longValue = ((java.lang.Long) a6.second).longValue();
                                            z9 = dVar.c == -9223372036854775807L;
                                            aVar = a7;
                                            j2 = longValue2;
                                            if (this.S != null && this.Z <= 0) {
                                                if (longValue != -9223372036854775807L) {
                                                    b(4);
                                                    a(false, true, false);
                                                    j3 = longValue;
                                                    this.R = this.R.a(aVar, j3, j2);
                                                    if (z9) {
                                                        cVar = this.M;
                                                        i4 = 2;
                                                        cVar.b(i4);
                                                    }
                                                    d();
                                                    return true;
                                                }
                                                if (aVar.equals(this.R.c)) {
                                                    com.anythink.expressad.exoplayer.q c4 = this.P.c();
                                                    j4 = (c4 == null || longValue == 0) ? longValue : c4.a.a(longValue, this.Q);
                                                    if (com.anythink.expressad.exoplayer.b.a(j4) == com.anythink.expressad.exoplayer.b.a(this.R.j)) {
                                                        this.R = this.R.a(aVar, this.R.j, j2);
                                                        if (z9) {
                                                            cVar = this.M;
                                                            i4 = 2;
                                                            cVar.b(i4);
                                                        }
                                                        d();
                                                        return true;
                                                    }
                                                } else {
                                                    j4 = longValue;
                                                }
                                                long a8 = a(aVar, j4);
                                                z9 |= longValue != a8;
                                                j3 = a8;
                                                this.R = this.R.a(aVar, j3, j2);
                                                if (z9) {
                                                }
                                                d();
                                                return true;
                                            }
                                            this.aa = dVar;
                                            j3 = longValue;
                                            this.R = this.R.a(aVar, j3, j2);
                                            if (z9) {
                                            }
                                            d();
                                            return true;
                                        }
                                        aVar = a7;
                                        j2 = longValue2;
                                        longValue = 0;
                                    }
                                    if (this.S != null) {
                                        if (longValue != -9223372036854775807L) {
                                        }
                                    }
                                    this.aa = dVar;
                                    j3 = longValue;
                                    this.R = this.R.a(aVar, j3, j2);
                                    if (z9) {
                                    }
                                    d();
                                    return true;
                                } catch (java.lang.Throwable th) {
                                    this.R = this.R.a(aVar, longValue, j2);
                                    if (!z9) {
                                        throw th;
                                    }
                                    this.M.b(2);
                                    throw th;
                                }
                                z9 = true;
                                break;
                            case 4:
                                this.L.a((com.anythink.expressad.exoplayer.v) message.obj);
                                d();
                                return true;
                            case 5:
                                this.Q = (com.anythink.expressad.exoplayer.ac) message.obj;
                                d();
                                return true;
                            case 6:
                                a(message.arg1 != 0, true);
                                d();
                                return true;
                            case 7:
                                i();
                                return true;
                            case 8:
                                com.anythink.expressad.exoplayer.k.a aVar2 = (com.anythink.expressad.exoplayer.k.a) message.obj;
                                if (aVar2.a == this.S) {
                                    com.anythink.expressad.exoplayer.ae aeVar = this.R.a;
                                    com.anythink.expressad.exoplayer.ae aeVar2 = aVar2.b;
                                    java.lang.Object obj = aVar2.c;
                                    this.P.a(aeVar2);
                                    this.R = this.R.a(aeVar2, obj);
                                    for (int size = this.N.size() - 1; size >= 0; size--) {
                                        if (!a(this.N.get(size))) {
                                            this.N.get(size).a.a(false);
                                            this.N.remove(size);
                                        }
                                    }
                                    java.util.Collections.sort(this.N);
                                    int i10 = this.Z;
                                    try {
                                        if (i10 > 0) {
                                            this.M.a(i10);
                                            this.Z = 0;
                                            com.anythink.expressad.exoplayer.k.d dVar2 = this.aa;
                                            if (dVar2 != null) {
                                                android.util.Pair<java.lang.Integer, java.lang.Long> a9 = a(dVar2, true);
                                                this.aa = null;
                                                if (a9 == null) {
                                                    o();
                                                    i10 = a9;
                                                } else {
                                                    int intValue2 = ((java.lang.Integer) a9.first).intValue();
                                                    long longValue3 = ((java.lang.Long) a9.second).longValue();
                                                    com.anythink.expressad.exoplayer.h.s.a a10 = this.P.a(intValue2, longValue3);
                                                    com.anythink.expressad.exoplayer.u a11 = this.R.a(a10, a10.a() ? 0L : longValue3, longValue3);
                                                    this.R = a11;
                                                    i10 = a11;
                                                }
                                            } else {
                                                long j7 = this.R.d;
                                                i10 = j7;
                                                if (j7 == -9223372036854775807L) {
                                                    boolean a12 = aeVar2.a();
                                                    if (a12) {
                                                        o();
                                                        i10 = a12;
                                                    } else {
                                                        android.util.Pair<java.lang.Integer, java.lang.Long> a13 = a(aeVar2, aeVar2.b(this.Y));
                                                        int intValue3 = ((java.lang.Integer) a13.first).intValue();
                                                        long longValue4 = ((java.lang.Long) a13.second).longValue();
                                                        com.anythink.expressad.exoplayer.h.s.a a14 = this.P.a(intValue3, longValue4);
                                                        com.anythink.expressad.exoplayer.u a15 = this.R.a(a14, a14.a() ? 0L : longValue4, longValue4);
                                                        this.R = a15;
                                                        i10 = a15;
                                                    }
                                                }
                                            }
                                        } else {
                                            com.anythink.expressad.exoplayer.u uVar3 = this.R;
                                            int i11 = uVar3.c.a;
                                            long j8 = uVar3.e;
                                            if (!aeVar.a()) {
                                                com.anythink.expressad.exoplayer.q e2 = this.P.e();
                                                int a16 = aeVar2.a(e2 == null ? aeVar.a(i11, this.I, true).b : e2.b);
                                                if (a16 == -1) {
                                                    int a17 = a(i11, aeVar, aeVar2);
                                                    if (a17 == -1) {
                                                        o();
                                                    } else {
                                                        android.util.Pair<java.lang.Integer, java.lang.Long> a18 = a(aeVar2, aeVar2.a(a17, this.I, false).c);
                                                        int intValue4 = ((java.lang.Integer) a18.first).intValue();
                                                        long longValue5 = ((java.lang.Long) a18.second).longValue();
                                                        com.anythink.expressad.exoplayer.h.s.a a19 = this.P.a(intValue4, longValue5);
                                                        aeVar2.a(intValue4, this.I, true);
                                                        if (e2 != null) {
                                                            java.lang.Object obj2 = this.I.b;
                                                            e2.h = e2.h.a();
                                                            while (true) {
                                                                e2 = e2.i;
                                                                if (e2 != null) {
                                                                    if (e2.b.equals(obj2)) {
                                                                        e2.h = this.P.a(e2.h, intValue4);
                                                                    } else {
                                                                        e2.h = e2.h.a();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (!a19.a()) {
                                                            j5 = longValue5;
                                                        }
                                                        this.R = this.R.a(a19, a(a19, j5), longValue5);
                                                    }
                                                } else {
                                                    if (a16 != i11) {
                                                        this.R = this.R.a(a16);
                                                    }
                                                    com.anythink.expressad.exoplayer.h.s.a aVar3 = this.R.c;
                                                    if (aVar3.a()) {
                                                        com.anythink.expressad.exoplayer.h.s.a a20 = this.P.a(a16, j8);
                                                        if (!a20.equals(aVar3)) {
                                                            if (!a20.a()) {
                                                                j5 = j8;
                                                            }
                                                            this.R = this.R.a(a20, a(a20, j5), j8);
                                                        }
                                                    }
                                                    if (!this.P.a(aVar3, this.ab)) {
                                                        i10 = 0;
                                                        g(false);
                                                    }
                                                }
                                            } else if (!aeVar2.a()) {
                                                com.anythink.expressad.exoplayer.h.s.a a21 = this.P.a(i11, j8);
                                                this.R = this.R.a(a21, a21.a() ? 0L : j8, j8);
                                            }
                                        }
                                    } catch (com.anythink.expressad.exoplayer.g e3) {
                                        gVar = e3;
                                        z6 = i10;
                                        i5 = 2;
                                        z3 = z6;
                                        a(z3, z3);
                                        this.F.obtainMessage(i5, gVar).sendToTarget();
                                        d();
                                        return true;
                                    } catch (java.io.IOException e4) {
                                        iOException = e4;
                                        z5 = i10;
                                        i5 = 2;
                                        z2 = z5;
                                        a(z2, z2);
                                        this.F.obtainMessage(i5, com.anythink.expressad.exoplayer.g.a(iOException)).sendToTarget();
                                        d();
                                        return true;
                                    } catch (java.lang.RuntimeException e5) {
                                        e = e5;
                                        z = i10;
                                        runtimeException = e;
                                        z4 = z;
                                        a(z4, z4);
                                        this.F.obtainMessage(2, com.anythink.expressad.exoplayer.g.a(runtimeException)).sendToTarget();
                                        d();
                                        return true;
                                    }
                                }
                                d();
                                return true;
                            case 9:
                                if (this.P.a((com.anythink.expressad.exoplayer.h.r) message.obj)) {
                                    com.anythink.expressad.exoplayer.q b5 = this.P.b();
                                    float f2 = this.L.e().b;
                                    b5.f = true;
                                    b5.j = b5.a.b();
                                    b5.a(f2);
                                    long b6 = b5.b(b5.h.b);
                                    long j9 = b5.e;
                                    com.anythink.expressad.exoplayer.r rVar2 = b5.h;
                                    b5.e = j9 + (rVar2.b - b6);
                                    b5.h = new com.anythink.expressad.exoplayer.r(rVar2.a, b6, rVar2.c, rVar2.d, rVar2.e, rVar2.f, rVar2.g);
                                    a(b5.k);
                                    if (!this.P.f()) {
                                        a(this.P.h().h.b);
                                        a((com.anythink.expressad.exoplayer.q) null);
                                    }
                                    r();
                                }
                                d();
                                return true;
                            case 10:
                                if (this.P.a((com.anythink.expressad.exoplayer.h.r) message.obj)) {
                                    this.P.a(this.ab);
                                    r();
                                }
                                d();
                                return true;
                            case 11:
                                if (this.P.f()) {
                                    float f3 = this.L.e().b;
                                    com.anythink.expressad.exoplayer.q c5 = this.P.c();
                                    com.anythink.expressad.exoplayer.q d3 = this.P.d();
                                    boolean z18 = true;
                                    while (true) {
                                        if (c5 != null && c5.f) {
                                            if (c5.a(f3)) {
                                                if (z18) {
                                                    com.anythink.expressad.exoplayer.q c6 = this.P.c();
                                                    boolean a22 = this.P.a(c6);
                                                    boolean[] zArr = new boolean[this.y.length];
                                                    long a23 = c6.a(this.R.j, a22, zArr);
                                                    a(c6.k);
                                                    com.anythink.expressad.exoplayer.u uVar4 = this.R;
                                                    if (uVar4.f != 4 && a23 != uVar4.j) {
                                                        com.anythink.expressad.exoplayer.u uVar5 = this.R;
                                                        this.R = uVar5.a(uVar5.c, a23, uVar5.e);
                                                        this.M.b(4);
                                                        a(a23);
                                                    }
                                                    boolean[] zArr2 = new boolean[this.y.length];
                                                    int i12 = 0;
                                                    int i13 = 0;
                                                    while (true) {
                                                        com.anythink.expressad.exoplayer.y[] yVarArr4 = this.y;
                                                        if (i12 < yVarArr4.length) {
                                                            com.anythink.expressad.exoplayer.y yVar8 = yVarArr4[i12];
                                                            boolean z19 = yVar8.a_() != 0;
                                                            zArr2[i12] = z19;
                                                            com.anythink.expressad.exoplayer.h.y yVar9 = c6.c[i12];
                                                            if (yVar9 != null) {
                                                                i13++;
                                                            }
                                                            if (z19) {
                                                                if (yVar9 != yVar8.f()) {
                                                                    b(yVar8);
                                                                } else if (zArr[i12]) {
                                                                    yVar8.a(this.ab);
                                                                }
                                                            }
                                                            i12++;
                                                        } else {
                                                            this.R = this.R.a(c6.j, c6.k);
                                                            a(zArr2, i13);
                                                        }
                                                    }
                                                } else {
                                                    this.P.a(c5);
                                                    if (c5.f) {
                                                        c5.b(java.lang.Math.max(c5.h.b, this.ab - c5.e));
                                                        a(c5.k);
                                                    }
                                                }
                                                if (this.R.f != 4) {
                                                    r();
                                                    g();
                                                    this.D.b(2);
                                                }
                                            } else {
                                                if (c5 == d3) {
                                                    z18 = false;
                                                }
                                                c5 = c5.i;
                                            }
                                        }
                                    }
                                }
                                d();
                                return true;
                            case 12:
                                int i14 = message.arg1;
                                this.X = i14;
                                if (!this.P.a(i14)) {
                                    g(true);
                                }
                                d();
                                return true;
                            case 13:
                                boolean z20 = message.arg1 != 0;
                                this.Y = z20;
                                if (!this.P.a(z20)) {
                                    g(true);
                                }
                                d();
                                return true;
                            case 14:
                                com.anythink.expressad.exoplayer.x xVar = (com.anythink.expressad.exoplayer.x) message.obj;
                                if (xVar.f() == -9223372036854775807L) {
                                    d(xVar);
                                } else {
                                    if (this.S != null && this.Z <= 0) {
                                        com.anythink.expressad.exoplayer.k.b bVar = new com.anythink.expressad.exoplayer.k.b(xVar);
                                        if (a(bVar)) {
                                            this.N.add(bVar);
                                            java.util.Collections.sort(this.N);
                                        } else {
                                            xVar.a(false);
                                        }
                                    }
                                    this.N.add(new com.anythink.expressad.exoplayer.k.b(xVar));
                                }
                                d();
                                return true;
                            case 15:
                                com.anythink.expressad.exoplayer.x xVar2 = (com.anythink.expressad.exoplayer.x) message.obj;
                                xVar2.e().post(new com.anythink.expressad.exoplayer.k.AnonymousClass1(xVar2));
                                d();
                                return true;
                            default:
                                return false;
                        }
                    } catch (java.lang.RuntimeException e6) {
                        runtimeException = e6;
                        z4 = false;
                        a(z4, z4);
                        this.F.obtainMessage(2, com.anythink.expressad.exoplayer.g.a(runtimeException)).sendToTarget();
                        d();
                        return true;
                    }
                } catch (com.anythink.expressad.exoplayer.g e7) {
                    gVar = e7;
                    z6 = false;
                } catch (java.io.IOException e8) {
                    iOException = e8;
                    z5 = false;
                }
            } catch (com.anythink.expressad.exoplayer.g e9) {
                gVar = e9;
                z3 = false;
                a(z3, z3);
                this.F.obtainMessage(i5, gVar).sendToTarget();
                d();
                return true;
            } catch (java.io.IOException e10) {
                iOException = e10;
                z2 = false;
                a(z2, z2);
                this.F.obtainMessage(i5, com.anythink.expressad.exoplayer.g.a(iOException)).sendToTarget();
                d();
                return true;
            }
        } catch (com.anythink.expressad.exoplayer.g e11) {
            z3 = false;
            i5 = 2;
            gVar = e11;
        } catch (java.io.IOException e12) {
            z2 = false;
            i5 = 2;
            iOException = e12;
        } catch (java.lang.RuntimeException e13) {
            e = e13;
            z = false;
        }
    }
}
