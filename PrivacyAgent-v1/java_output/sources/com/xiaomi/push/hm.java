package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hm implements com.xiaomi.push.hw<com.xiaomi.push.hm, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public long e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public long j;
    public java.lang.String k;
    public java.lang.String l;
    public long m;
    public java.lang.String n;
    public int o;
    public java.lang.String p;
    public int q;
    public java.lang.String r;
    public java.util.List<java.lang.String> t;
    private static final com.xiaomi.push.im u = new com.xiaomi.push.im("XmPushActionRegistrationResult");
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie z = new com.xiaomi.push.ie("", (byte) 10, 6);
    private static final com.xiaomi.push.ie A = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie B = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie C = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie D = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie E = new com.xiaomi.push.ie("", (byte) 10, 11);
    private static final com.xiaomi.push.ie F = new com.xiaomi.push.ie("", (byte) 11, 12);
    private static final com.xiaomi.push.ie G = new com.xiaomi.push.ie("", (byte) 11, 13);
    private static final com.xiaomi.push.ie H = new com.xiaomi.push.ie("", (byte) 10, 14);
    private static final com.xiaomi.push.ie I = new com.xiaomi.push.ie("", (byte) 11, 15);
    private static final com.xiaomi.push.ie J = new com.xiaomi.push.ie("", (byte) 8, 16);
    private static final com.xiaomi.push.ie K = new com.xiaomi.push.ie("", (byte) 11, 17);
    private static final com.xiaomi.push.ie L = new com.xiaomi.push.ie("", (byte) 8, 18);
    private static final com.xiaomi.push.ie M = new com.xiaomi.push.ie("", (byte) 11, 19);
    private static final com.xiaomi.push.ie N = new com.xiaomi.push.ie("", (byte) 2, 20);
    private static final com.xiaomi.push.ie O = new com.xiaomi.push.ie("", (byte) 15, 21);
    private java.util.BitSet P = new java.util.BitSet(6);

    /* renamed from: s, reason: collision with root package name */
    public boolean f481s = false;

    private boolean a() {
        return this.a != null;
    }

    private boolean b() {
        return this.b != null;
    }

    private boolean c() {
        return this.c != null;
    }

    private boolean d() {
        return this.d != null;
    }

    private boolean e() {
        return this.P.get(0);
    }

    private boolean f() {
        return this.f != null;
    }

    private boolean g() {
        return this.g != null;
    }

    private boolean h() {
        return this.h != null;
    }

    private boolean i() {
        return this.i != null;
    }

    private boolean j() {
        return this.P.get(1);
    }

    private boolean k() {
        return this.k != null;
    }

    private boolean l() {
        return this.l != null;
    }

    private boolean m() {
        return this.P.get(2);
    }

    private boolean n() {
        return this.n != null;
    }

    private boolean o() {
        return this.P.get(3);
    }

    private boolean p() {
        return this.p != null;
    }

    private boolean q() {
        return this.P.get(4);
    }

    private boolean r() {
        return this.r != null;
    }

    private boolean s() {
        return this.P.get(5);
    }

    private boolean t() {
        return this.t != null;
    }

    private void u() {
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        java.util.BitSet bitSet;
        int i;
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                if (!e()) {
                    throw new com.xiaomi.push.ii("Required field 'errorCode' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
                u();
                return;
            }
            switch (b.c) {
                case 1:
                    if (b2 == 11) {
                        this.a = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
                        this.b = gzVar;
                        gzVar.a(ihVar);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.c = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.d = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 5:
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.e = ihVar.j();
                        this.P.set(0, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.g = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.h = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.i = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 10) {
                        this.j = ihVar.j();
                        this.P.set(1, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.k = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.l = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 10) {
                        this.m = ihVar.j();
                        this.P.set(2, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.n = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 8) {
                        this.o = ihVar.i();
                        bitSet = this.P;
                        i = 3;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.p = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 8) {
                        this.q = ihVar.i();
                        bitSet = this.P;
                        i = 4;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 11) {
                        this.r = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f481s = ihVar.f();
                        bitSet = this.P;
                        i = 5;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 15) {
                        com.xiaomi.push.Cif d = ihVar.d();
                        this.t = new java.util.ArrayList(d.b);
                        for (int i2 = 0; i2 < d.b; i2++) {
                            this.t.add(ihVar.l());
                        }
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        u();
        if (this.a != null && a()) {
            ihVar.a(v);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(w);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(x);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(y);
            ihVar.a(this.d);
        }
        ihVar.a(z);
        ihVar.a(this.e);
        if (this.f != null && f()) {
            ihVar.a(A);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(B);
            ihVar.a(this.g);
        }
        if (this.h != null && h()) {
            ihVar.a(C);
            ihVar.a(this.h);
        }
        if (this.i != null && i()) {
            ihVar.a(D);
            ihVar.a(this.i);
        }
        if (j()) {
            ihVar.a(E);
            ihVar.a(this.j);
        }
        if (this.k != null && k()) {
            ihVar.a(F);
            ihVar.a(this.k);
        }
        if (this.l != null && l()) {
            ihVar.a(G);
            ihVar.a(this.l);
        }
        if (m()) {
            ihVar.a(H);
            ihVar.a(this.m);
        }
        if (this.n != null && n()) {
            ihVar.a(I);
            ihVar.a(this.n);
        }
        if (o()) {
            ihVar.a(J);
            ihVar.a(this.o);
        }
        if (this.p != null && p()) {
            ihVar.a(K);
            ihVar.a(this.p);
        }
        if (q()) {
            ihVar.a(L);
            ihVar.a(this.q);
        }
        if (this.r != null && r()) {
            ihVar.a(M);
            ihVar.a(this.r);
        }
        if (s()) {
            ihVar.a(N);
            ihVar.a(this.f481s);
        }
        if (this.t != null && t()) {
            ihVar.a(O);
            ihVar.a(new com.xiaomi.push.Cif((byte) 11, this.t.size()));
            java.util.Iterator<java.lang.String> it = this.t.iterator();
            while (it.hasNext()) {
                ihVar.a(it.next());
            }
        }
        ihVar.a();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        com.xiaomi.push.hm hmVar = (com.xiaomi.push.hm) obj;
        if (!com.xiaomi.push.hm.class.equals(hmVar.getClass())) {
            return com.xiaomi.push.hm.class.getName().compareTo(com.xiaomi.push.hm.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hmVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a20 = com.xiaomi.push.hx.a(this.a, hmVar.a)) != 0) {
            return a20;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a19 = com.xiaomi.push.hx.a(this.b, hmVar.b)) != 0) {
            return a19;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a18 = com.xiaomi.push.hx.a(this.c, hmVar.c)) != 0) {
            return a18;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a17 = com.xiaomi.push.hx.a(this.d, hmVar.d)) != 0) {
            return a17;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a16 = com.xiaomi.push.hx.a(this.e, hmVar.e)) != 0) {
            return a16;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a15 = com.xiaomi.push.hx.a(this.f, hmVar.f)) != 0) {
            return a15;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a14 = com.xiaomi.push.hx.a(this.g, hmVar.g)) != 0) {
            return a14;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a13 = com.xiaomi.push.hx.a(this.h, hmVar.h)) != 0) {
            return a13;
        }
        int compareTo9 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hmVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a12 = com.xiaomi.push.hx.a(this.i, hmVar.i)) != 0) {
            return a12;
        }
        int compareTo10 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hmVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a11 = com.xiaomi.push.hx.a(this.j, hmVar.j)) != 0) {
            return a11;
        }
        int compareTo11 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hmVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a10 = com.xiaomi.push.hx.a(this.k, hmVar.k)) != 0) {
            return a10;
        }
        int compareTo12 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(hmVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a9 = com.xiaomi.push.hx.a(this.l, hmVar.l)) != 0) {
            return a9;
        }
        int compareTo13 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(hmVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a8 = com.xiaomi.push.hx.a(this.m, hmVar.m)) != 0) {
            return a8;
        }
        int compareTo14 = java.lang.Boolean.valueOf(n()).compareTo(java.lang.Boolean.valueOf(hmVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a7 = com.xiaomi.push.hx.a(this.n, hmVar.n)) != 0) {
            return a7;
        }
        int compareTo15 = java.lang.Boolean.valueOf(o()).compareTo(java.lang.Boolean.valueOf(hmVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a6 = com.xiaomi.push.hx.a(this.o, hmVar.o)) != 0) {
            return a6;
        }
        int compareTo16 = java.lang.Boolean.valueOf(p()).compareTo(java.lang.Boolean.valueOf(hmVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a5 = com.xiaomi.push.hx.a(this.p, hmVar.p)) != 0) {
            return a5;
        }
        int compareTo17 = java.lang.Boolean.valueOf(q()).compareTo(java.lang.Boolean.valueOf(hmVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a4 = com.xiaomi.push.hx.a(this.q, hmVar.q)) != 0) {
            return a4;
        }
        int compareTo18 = java.lang.Boolean.valueOf(r()).compareTo(java.lang.Boolean.valueOf(hmVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a3 = com.xiaomi.push.hx.a(this.r, hmVar.r)) != 0) {
            return a3;
        }
        int compareTo19 = java.lang.Boolean.valueOf(s()).compareTo(java.lang.Boolean.valueOf(hmVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a2 = com.xiaomi.push.hx.a(this.f481s, hmVar.f481s)) != 0) {
            return a2;
        }
        int compareTo20 = java.lang.Boolean.valueOf(t()).compareTo(java.lang.Boolean.valueOf(hmVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a = com.xiaomi.push.hx.a(this.t, hmVar.t)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hm)) {
            com.xiaomi.push.hm hmVar = (com.xiaomi.push.hm) obj;
            boolean a = a();
            boolean a2 = hmVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(hmVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = hmVar.b();
            if ((b || b2) && !(b && b2 && this.b.a(hmVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hmVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(hmVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hmVar.d();
            if (((d || d2) && !(d && d2 && this.d.equals(hmVar.d))) || this.e != hmVar.e) {
                return false;
            }
            boolean f = f();
            boolean f2 = hmVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(hmVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hmVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(hmVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hmVar.h();
            if ((h || h2) && !(h && h2 && this.h.equals(hmVar.h))) {
                return false;
            }
            boolean i = i();
            boolean i2 = hmVar.i();
            if ((i || i2) && !(i && i2 && this.i.equals(hmVar.i))) {
                return false;
            }
            boolean j = j();
            boolean j2 = hmVar.j();
            if ((j || j2) && !(j && j2 && this.j == hmVar.j)) {
                return false;
            }
            boolean k = k();
            boolean k2 = hmVar.k();
            if ((k || k2) && !(k && k2 && this.k.equals(hmVar.k))) {
                return false;
            }
            boolean l = l();
            boolean l2 = hmVar.l();
            if ((l || l2) && !(l && l2 && this.l.equals(hmVar.l))) {
                return false;
            }
            boolean m = m();
            boolean m2 = hmVar.m();
            if ((m || m2) && !(m && m2 && this.m == hmVar.m)) {
                return false;
            }
            boolean n = n();
            boolean n2 = hmVar.n();
            if ((n || n2) && !(n && n2 && this.n.equals(hmVar.n))) {
                return false;
            }
            boolean o = o();
            boolean o2 = hmVar.o();
            if ((o || o2) && !(o && o2 && this.o == hmVar.o)) {
                return false;
            }
            boolean p = p();
            boolean p2 = hmVar.p();
            if ((p || p2) && !(p && p2 && this.p.equals(hmVar.p))) {
                return false;
            }
            boolean q = q();
            boolean q2 = hmVar.q();
            if ((q || q2) && !(q && q2 && this.q == hmVar.q)) {
                return false;
            }
            boolean r = r();
            boolean r2 = hmVar.r();
            if ((r || r2) && !(r && r2 && this.r.equals(hmVar.r))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = hmVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f481s == hmVar.f481s)) {
                return false;
            }
            boolean t = t();
            boolean t2 = hmVar.t();
            if (t || t2) {
                return t && t2 && this.t.equals(hmVar.t);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        boolean z2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionRegistrationResult(");
        boolean z3 = false;
        if (a()) {
            sb.append("debug:");
            java.lang.String str = this.a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            com.xiaomi.push.gz gzVar = this.b;
            if (gzVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gzVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        java.lang.String str3 = this.d;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.e);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            java.lang.String str4 = this.f;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            java.lang.String str5 = this.g;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            java.lang.String str6 = this.h;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str7 = this.i;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.j);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str8 = this.k;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            java.lang.String str9 = this.l;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.m);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            java.lang.String str10 = this.n;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.o);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            java.lang.String str11 = this.p;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.q);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            java.lang.String str12 = this.r;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f481s);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            java.util.List<java.lang.String> list = this.t;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
