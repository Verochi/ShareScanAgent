package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
final class s {
    private static final int a = 100;
    private final com.anythink.expressad.exoplayer.ae.a b = new com.anythink.expressad.exoplayer.ae.a();
    private final com.anythink.expressad.exoplayer.ae.b c = new com.anythink.expressad.exoplayer.ae.b();
    private long d;
    private com.anythink.expressad.exoplayer.ae e;
    private int f;
    private boolean g;
    private com.anythink.expressad.exoplayer.q h;
    private com.anythink.expressad.exoplayer.q i;
    private com.anythink.expressad.exoplayer.q j;
    private int k;
    private java.lang.Object l;
    private long m;

    private com.anythink.expressad.exoplayer.h.s.a a(int i, long j, long j2) {
        this.e.a(i, this.b, false);
        int a2 = this.b.a(j);
        return a2 == -1 ? new com.anythink.expressad.exoplayer.h.s.a(i, j2) : new com.anythink.expressad.exoplayer.h.s.a(i, a2, this.b.b(a2), j2);
    }

    private com.anythink.expressad.exoplayer.r a(int i, int i2, int i3, long j, long j2) {
        com.anythink.expressad.exoplayer.h.s.a aVar = new com.anythink.expressad.exoplayer.h.s.a(i, i2, i3, j2);
        boolean b = b(aVar, Long.MIN_VALUE);
        boolean a2 = a(aVar, b);
        return new com.anythink.expressad.exoplayer.r(aVar, i3 == this.b.b(i2) ? this.b.d() : 0L, Long.MIN_VALUE, j, this.e.a(aVar.a, this.b, false).c(aVar.b, aVar.c), b, a2);
    }

    private com.anythink.expressad.exoplayer.r a(com.anythink.expressad.exoplayer.h.s.a aVar, long j, long j2) {
        this.e.a(aVar.a, this.b, false);
        if (!aVar.a()) {
            return b(aVar.a, j2, aVar.d);
        }
        if (this.b.b(aVar.b, aVar.c)) {
            return a(aVar.a, aVar.b, aVar.c, j, aVar.d);
        }
        return null;
    }

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.r a(com.anythink.expressad.exoplayer.q qVar, long j) {
        int i;
        long j2;
        long j3;
        com.anythink.expressad.exoplayer.r rVar = qVar.h;
        if (rVar.f) {
            int a2 = this.e.a(rVar.a.a, this.b, this.c, this.f, this.g);
            if (a2 == -1) {
                return null;
            }
            int i2 = this.e.a(a2, this.b, true).c;
            java.lang.Object obj = this.b.b;
            long j4 = rVar.a.d;
            long j5 = 0;
            if (this.e.a(i2, this.c, false).f == a2) {
                android.util.Pair<java.lang.Integer, java.lang.Long> a3 = this.e.a(this.c, this.b, i2, -9223372036854775807L, java.lang.Math.max(0L, (qVar.e + rVar.e) - j));
                if (a3 == null) {
                    return null;
                }
                int intValue = ((java.lang.Integer) a3.first).intValue();
                long longValue = ((java.lang.Long) a3.second).longValue();
                com.anythink.expressad.exoplayer.q qVar2 = qVar.i;
                if (qVar2 == null || !qVar2.b.equals(obj)) {
                    j3 = this.d;
                    this.d = 1 + j3;
                } else {
                    j3 = qVar.i.h.a.d;
                }
                j5 = longValue;
                j2 = j3;
                i = intValue;
            } else {
                i = a2;
                j2 = j4;
            }
            long j6 = j5;
            return a(a(i, j6, j2), j6, j5);
        }
        com.anythink.expressad.exoplayer.h.s.a aVar = rVar.a;
        this.e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            int i3 = aVar.b;
            int d = this.b.d(i3);
            if (d == -1) {
                return null;
            }
            int a4 = this.b.a(i3, aVar.c);
            if (a4 >= d) {
                return b(aVar.a, rVar.d, aVar.d);
            }
            if (this.b.b(i3, a4)) {
                return a(aVar.a, i3, a4, rVar.d, aVar.d);
            }
            return null;
        }
        long j7 = rVar.c;
        if (j7 != Long.MIN_VALUE) {
            int a5 = this.b.a(j7);
            if (a5 == -1) {
                return b(aVar.a, rVar.c, aVar.d);
            }
            int b = this.b.b(a5);
            if (this.b.b(a5, b)) {
                return a(aVar.a, a5, b, rVar.c, aVar.d);
            }
            return null;
        }
        int c = this.b.c();
        if (c == 0) {
            return null;
        }
        int i4 = c - 1;
        if (this.b.a(i4) != Long.MIN_VALUE || this.b.c(i4)) {
            return null;
        }
        int b2 = this.b.b(i4);
        if (!this.b.b(i4, b2)) {
            return null;
        }
        return a(aVar.a, i4, b2, this.b.d, aVar.d);
    }

    private com.anythink.expressad.exoplayer.r a(com.anythink.expressad.exoplayer.r rVar, com.anythink.expressad.exoplayer.h.s.a aVar) {
        long j;
        long j2;
        long j3 = rVar.b;
        long j4 = rVar.c;
        boolean b = b(aVar, j4);
        boolean a2 = a(aVar, b);
        this.e.a(aVar.a, this.b, false);
        if (aVar.a()) {
            j2 = this.b.c(aVar.b, aVar.c);
        } else {
            if (j4 != Long.MIN_VALUE) {
                j = j4;
                return new com.anythink.expressad.exoplayer.r(aVar, j3, j4, rVar.d, j, b, a2);
            }
            j2 = this.b.d;
        }
        j = j2;
        return new com.anythink.expressad.exoplayer.r(aVar, j3, j4, rVar.d, j, b, a2);
    }

    private com.anythink.expressad.exoplayer.r a(com.anythink.expressad.exoplayer.u uVar) {
        return a(uVar.c, uVar.e, uVar.d);
    }

    private boolean a(com.anythink.expressad.exoplayer.h.s.a aVar, boolean z) {
        return !this.e.a(this.e.a(aVar.a, this.b, false).c, this.c, false).e && this.e.b(aVar.a, this.b, this.c, this.f, this.g) && z;
    }

    private static boolean a(com.anythink.expressad.exoplayer.q qVar, com.anythink.expressad.exoplayer.r rVar) {
        com.anythink.expressad.exoplayer.r rVar2 = qVar.h;
        return rVar2.b == rVar.b && rVar2.c == rVar.c && rVar2.a.equals(rVar.a);
    }

    private long b(int i) {
        int a2;
        java.lang.Object obj = this.e.a(i, this.b, true).b;
        int i2 = this.b.c;
        java.lang.Object obj2 = this.l;
        if (obj2 != null && (a2 = this.e.a(obj2)) != -1 && this.e.a(a2, this.b, false).c == i2) {
            return this.m;
        }
        for (com.anythink.expressad.exoplayer.q e = e(); e != null; e = e.i) {
            if (e.b.equals(obj)) {
                return e.h.a.d;
            }
        }
        for (com.anythink.expressad.exoplayer.q e2 = e(); e2 != null; e2 = e2.i) {
            int a3 = this.e.a(e2.b);
            if (a3 != -1 && this.e.a(a3, this.b, false).c == i2) {
                return e2.h.a.d;
            }
        }
        long j = this.d;
        this.d = 1 + j;
        return j;
    }

    private com.anythink.expressad.exoplayer.r b(int i, long j, long j2) {
        com.anythink.expressad.exoplayer.h.s.a aVar = new com.anythink.expressad.exoplayer.h.s.a(i, j2);
        this.e.a(aVar.a, this.b, false);
        int b = this.b.b(j);
        long a2 = b == -1 ? Long.MIN_VALUE : this.b.a(b);
        boolean b2 = b(aVar, a2);
        return new com.anythink.expressad.exoplayer.r(aVar, j, a2, -9223372036854775807L, a2 == Long.MIN_VALUE ? this.b.d : a2, b2, a(aVar, b2));
    }

    private boolean b(com.anythink.expressad.exoplayer.h.s.a aVar, long j) {
        int c = this.e.a(aVar.a, this.b, false).c();
        if (c == 0) {
            return true;
        }
        int i = c - 1;
        boolean a2 = aVar.a();
        if (this.b.a(i) != Long.MIN_VALUE) {
            return !a2 && j == Long.MIN_VALUE;
        }
        int d = this.b.d(i);
        if (d == -1) {
            return false;
        }
        return (a2 && aVar.b == i && aVar.c == d + (-1)) || (!a2 && this.b.b(i) == d);
    }

    private boolean i() {
        com.anythink.expressad.exoplayer.q qVar;
        com.anythink.expressad.exoplayer.q e = e();
        if (e == null) {
            return true;
        }
        while (true) {
            int a2 = this.e.a(e.h.a.a, this.b, this.c, this.f, this.g);
            while (true) {
                qVar = e.i;
                if (qVar == null || e.h.f) {
                    break;
                }
                e = qVar;
            }
            if (a2 == -1 || qVar == null || qVar.h.a.a != a2) {
                break;
            }
            e = qVar;
        }
        boolean a3 = a(e);
        com.anythink.expressad.exoplayer.r rVar = e.h;
        e.h = a(rVar, rVar.a);
        return (a3 && f()) ? false : true;
    }

    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.z[] zVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.j.b bVar, com.anythink.expressad.exoplayer.h.s sVar, java.lang.Object obj, com.anythink.expressad.exoplayer.r rVar) {
        com.anythink.expressad.exoplayer.q qVar = this.j;
        com.anythink.expressad.exoplayer.q qVar2 = new com.anythink.expressad.exoplayer.q(zVarArr, qVar == null ? rVar.b : qVar.e + qVar.h.e, hVar, bVar, sVar, obj, rVar);
        if (this.j != null) {
            com.anythink.expressad.exoplayer.k.a.b(f());
            this.j.i = qVar2;
        }
        this.l = null;
        this.j = qVar2;
        this.k++;
        return qVar2.a;
    }

    public final com.anythink.expressad.exoplayer.h.s.a a(int i, long j) {
        long j2;
        int a2;
        java.lang.Object obj = this.e.a(i, this.b, true).b;
        int i2 = this.b.c;
        java.lang.Object obj2 = this.l;
        if (obj2 == null || (a2 = this.e.a(obj2)) == -1 || this.e.a(a2, this.b, false).c != i2) {
            com.anythink.expressad.exoplayer.q e = e();
            while (true) {
                if (e == null) {
                    com.anythink.expressad.exoplayer.q e2 = e();
                    while (true) {
                        if (e2 != null) {
                            int a3 = this.e.a(e2.b);
                            if (a3 != -1 && this.e.a(a3, this.b, false).c == i2) {
                                j2 = e2.h.a.d;
                                break;
                            }
                            e2 = e2.i;
                        } else {
                            j2 = this.d;
                            this.d = 1 + j2;
                            break;
                        }
                    }
                } else {
                    if (e.b.equals(obj)) {
                        j2 = e.h.a.d;
                        break;
                    }
                    e = e.i;
                }
            }
        } else {
            j2 = this.m;
        }
        return a(i, j, j2);
    }

    @androidx.annotation.Nullable
    public final com.anythink.expressad.exoplayer.r a(long j, com.anythink.expressad.exoplayer.u uVar) {
        com.anythink.expressad.exoplayer.q qVar = this.j;
        return qVar == null ? a(uVar.c, uVar.e, uVar.d) : a(qVar, j);
    }

    public final com.anythink.expressad.exoplayer.r a(com.anythink.expressad.exoplayer.r rVar, int i) {
        return a(rVar, rVar.a.a(i));
    }

    public final void a(long j) {
        com.anythink.expressad.exoplayer.q qVar = this.j;
        if (qVar == null || !qVar.f) {
            return;
        }
        qVar.a.a_(j - qVar.e);
    }

    public final void a(com.anythink.expressad.exoplayer.ae aeVar) {
        this.e = aeVar;
    }

    public final boolean a() {
        com.anythink.expressad.exoplayer.q qVar = this.j;
        if (qVar != null) {
            return !qVar.h.g && qVar.a() && this.j.h.e != -9223372036854775807L && this.k < 100;
        }
        return true;
    }

    public final boolean a(int i) {
        this.f = i;
        return i();
    }

    public final boolean a(com.anythink.expressad.exoplayer.h.r rVar) {
        com.anythink.expressad.exoplayer.q qVar = this.j;
        return qVar != null && qVar.a == rVar;
    }

    public final boolean a(com.anythink.expressad.exoplayer.h.s.a aVar, long j) {
        int i = aVar.a;
        com.anythink.expressad.exoplayer.q qVar = null;
        int i2 = i;
        for (com.anythink.expressad.exoplayer.q e = e(); e != null; e = e.i) {
            if (qVar == null) {
                e.h = a(e.h, i2);
            } else {
                if (i2 == -1 || !e.b.equals(this.e.a(i2, this.b, true).b)) {
                    return !a(qVar);
                }
                com.anythink.expressad.exoplayer.r a2 = a(qVar, j);
                if (a2 == null) {
                    return !a(qVar);
                }
                com.anythink.expressad.exoplayer.r a3 = a(e.h, i2);
                e.h = a3;
                if (!(a3.b == a2.b && a3.c == a2.c && a3.a.equals(a2.a))) {
                    return !a(qVar);
                }
            }
            if (e.h.f) {
                i2 = this.e.a(i2, this.b, this.c, this.f, this.g);
            }
            qVar = e;
        }
        return true;
    }

    public final boolean a(com.anythink.expressad.exoplayer.q qVar) {
        boolean z = false;
        com.anythink.expressad.exoplayer.k.a.b(qVar != null);
        this.j = qVar;
        while (true) {
            qVar = qVar.i;
            if (qVar == null) {
                this.j.i = null;
                return z;
            }
            if (qVar == this.i) {
                this.i = this.h;
                z = true;
            }
            qVar.c();
            this.k--;
        }
    }

    public final boolean a(boolean z) {
        this.g = z;
        return i();
    }

    public final com.anythink.expressad.exoplayer.q b() {
        return this.j;
    }

    public final void b(boolean z) {
        com.anythink.expressad.exoplayer.q e = e();
        if (e != null) {
            this.l = z ? e.b : null;
            this.m = e.h.a.d;
            e.c();
            a(e);
        } else if (!z) {
            this.l = null;
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
    }

    public final com.anythink.expressad.exoplayer.q c() {
        return this.h;
    }

    public final com.anythink.expressad.exoplayer.q d() {
        return this.i;
    }

    public final com.anythink.expressad.exoplayer.q e() {
        return f() ? this.h : this.j;
    }

    public final boolean f() {
        return this.h != null;
    }

    public final com.anythink.expressad.exoplayer.q g() {
        com.anythink.expressad.exoplayer.q qVar = this.i;
        com.anythink.expressad.exoplayer.k.a.b((qVar == null || qVar.i == null) ? false : true);
        com.anythink.expressad.exoplayer.q qVar2 = this.i.i;
        this.i = qVar2;
        return qVar2;
    }

    public final com.anythink.expressad.exoplayer.q h() {
        com.anythink.expressad.exoplayer.q qVar = this.h;
        if (qVar != null) {
            if (qVar == this.i) {
                this.i = qVar.i;
            }
            qVar.c();
            int i = this.k - 1;
            this.k = i;
            if (i == 0) {
                this.j = null;
                com.anythink.expressad.exoplayer.q qVar2 = this.h;
                this.l = qVar2.b;
                this.m = qVar2.h.a.d;
            }
            this.h = this.h.i;
        } else {
            com.anythink.expressad.exoplayer.q qVar3 = this.j;
            this.h = qVar3;
            this.i = qVar3;
        }
        return this.h;
    }
}
