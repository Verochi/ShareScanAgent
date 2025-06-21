package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ha implements com.xiaomi.push.hw<com.xiaomi.push.ha, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public long e;
    public java.lang.String f;
    public java.lang.String g;
    public com.xiaomi.push.ho h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String l;
    public java.lang.String m;
    public java.lang.String n;
    public short o;
    public short p;
    public java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public int f475s;
    public java.util.Map<java.lang.String, java.lang.String> t;
    private static final com.xiaomi.push.im u = new com.xiaomi.push.im("XmPushActionAckMessage");
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie z = new com.xiaomi.push.ie("", (byte) 10, 5);
    private static final com.xiaomi.push.ie A = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie B = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie C = new com.xiaomi.push.ie("", (byte) 12, 8);
    private static final com.xiaomi.push.ie D = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie E = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie F = new com.xiaomi.push.ie("", (byte) 2, 11);
    private static final com.xiaomi.push.ie G = new com.xiaomi.push.ie("", (byte) 11, 12);
    private static final com.xiaomi.push.ie H = new com.xiaomi.push.ie("", (byte) 11, 13);
    private static final com.xiaomi.push.ie I = new com.xiaomi.push.ie("", (byte) 11, 14);
    private static final com.xiaomi.push.ie J = new com.xiaomi.push.ie("", (byte) 6, 15);
    private static final com.xiaomi.push.ie K = new com.xiaomi.push.ie("", (byte) 6, 16);
    private static final com.xiaomi.push.ie L = new com.xiaomi.push.ie("", (byte) 11, 20);
    private static final com.xiaomi.push.ie M = new com.xiaomi.push.ie("", (byte) 11, 21);
    private static final com.xiaomi.push.ie N = new com.xiaomi.push.ie("", (byte) 8, 22);
    private static final com.xiaomi.push.ie O = new com.xiaomi.push.ie("", (byte) 13, 23);
    private java.util.BitSet P = new java.util.BitSet(5);
    public boolean k = false;

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

    private void f() {
        this.P.set(0, true);
    }

    private boolean g() {
        return this.f != null;
    }

    private boolean h() {
        return this.g != null;
    }

    private boolean i() {
        return this.h != null;
    }

    private boolean j() {
        return this.i != null;
    }

    private boolean k() {
        return this.j != null;
    }

    private boolean l() {
        return this.P.get(1);
    }

    private boolean m() {
        return this.l != null;
    }

    private boolean n() {
        return this.m != null;
    }

    private boolean o() {
        return this.n != null;
    }

    private boolean p() {
        return this.P.get(2);
    }

    private void q() {
        this.P.set(2, true);
    }

    private boolean r() {
        return this.P.get(3);
    }

    private boolean s() {
        return this.q != null;
    }

    private boolean t() {
        return this.r != null;
    }

    private boolean u() {
        return this.P.get(4);
    }

    private boolean v() {
        return this.t != null;
    }

    private void w() {
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.ha a(long j) {
        this.e = j;
        f();
        return this;
    }

    public final com.xiaomi.push.ha a(short s2) {
        this.o = s2;
        q();
        return this;
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
                    throw new com.xiaomi.push.ii("Required field 'messageTs' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
                w();
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
                    if (b2 == 10) {
                        this.e = ihVar.j();
                        f();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.g = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        com.xiaomi.push.ho hoVar = new com.xiaomi.push.ho();
                        this.h = hoVar;
                        hoVar.a(ihVar);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.i = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.j = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.k = ihVar.f();
                        this.P.set(1, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.l = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.m = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.n = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 6) {
                        this.o = ihVar.h();
                        q();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 6) {
                        this.p = ihVar.h();
                        bitSet = this.P;
                        i = 3;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
                case 20:
                    if (b2 == 11) {
                        this.q = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 11) {
                        this.r = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 8) {
                        this.f475s = ihVar.i();
                        bitSet = this.P;
                        i = 4;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 13) {
                        com.xiaomi.push.ig c = ihVar.c();
                        this.t = new java.util.HashMap(c.c * 2);
                        for (int i2 = 0; i2 < c.c; i2++) {
                            this.t.put(ihVar.l(), ihVar.l());
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
        w();
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
        if (this.f != null && g()) {
            ihVar.a(A);
            ihVar.a(this.f);
        }
        if (this.g != null && h()) {
            ihVar.a(B);
            ihVar.a(this.g);
        }
        if (this.h != null && i()) {
            ihVar.a(C);
            this.h.b(ihVar);
        }
        if (this.i != null && j()) {
            ihVar.a(D);
            ihVar.a(this.i);
        }
        if (this.j != null && k()) {
            ihVar.a(E);
            ihVar.a(this.j);
        }
        if (l()) {
            ihVar.a(F);
            ihVar.a(this.k);
        }
        if (this.l != null && m()) {
            ihVar.a(G);
            ihVar.a(this.l);
        }
        if (this.m != null && n()) {
            ihVar.a(H);
            ihVar.a(this.m);
        }
        if (this.n != null && o()) {
            ihVar.a(I);
            ihVar.a(this.n);
        }
        if (p()) {
            ihVar.a(J);
            ihVar.a(this.o);
        }
        if (r()) {
            ihVar.a(K);
            ihVar.a(this.p);
        }
        if (this.q != null && s()) {
            ihVar.a(L);
            ihVar.a(this.q);
        }
        if (this.r != null && t()) {
            ihVar.a(M);
            ihVar.a(this.r);
        }
        if (u()) {
            ihVar.a(N);
            ihVar.a(this.f475s);
        }
        if (this.t != null && v()) {
            ihVar.a(O);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.t.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.t.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
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
        com.xiaomi.push.ha haVar = (com.xiaomi.push.ha) obj;
        if (!com.xiaomi.push.ha.class.equals(haVar.getClass())) {
            return com.xiaomi.push.ha.class.getName().compareTo(com.xiaomi.push.ha.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(haVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a20 = com.xiaomi.push.hx.a(this.a, haVar.a)) != 0) {
            return a20;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(haVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a19 = com.xiaomi.push.hx.a(this.b, haVar.b)) != 0) {
            return a19;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(haVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a18 = com.xiaomi.push.hx.a(this.c, haVar.c)) != 0) {
            return a18;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(haVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a17 = com.xiaomi.push.hx.a(this.d, haVar.d)) != 0) {
            return a17;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(haVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a16 = com.xiaomi.push.hx.a(this.e, haVar.e)) != 0) {
            return a16;
        }
        int compareTo6 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(haVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a15 = com.xiaomi.push.hx.a(this.f, haVar.f)) != 0) {
            return a15;
        }
        int compareTo7 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(haVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a14 = com.xiaomi.push.hx.a(this.g, haVar.g)) != 0) {
            return a14;
        }
        int compareTo8 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(haVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a13 = com.xiaomi.push.hx.a(this.h, haVar.h)) != 0) {
            return a13;
        }
        int compareTo9 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(haVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (j() && (a12 = com.xiaomi.push.hx.a(this.i, haVar.i)) != 0) {
            return a12;
        }
        int compareTo10 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(haVar.k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (k() && (a11 = com.xiaomi.push.hx.a(this.j, haVar.j)) != 0) {
            return a11;
        }
        int compareTo11 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(haVar.l()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (l() && (a10 = com.xiaomi.push.hx.a(this.k, haVar.k)) != 0) {
            return a10;
        }
        int compareTo12 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(haVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a9 = com.xiaomi.push.hx.a(this.l, haVar.l)) != 0) {
            return a9;
        }
        int compareTo13 = java.lang.Boolean.valueOf(n()).compareTo(java.lang.Boolean.valueOf(haVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (n() && (a8 = com.xiaomi.push.hx.a(this.m, haVar.m)) != 0) {
            return a8;
        }
        int compareTo14 = java.lang.Boolean.valueOf(o()).compareTo(java.lang.Boolean.valueOf(haVar.o()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (o() && (a7 = com.xiaomi.push.hx.a(this.n, haVar.n)) != 0) {
            return a7;
        }
        int compareTo15 = java.lang.Boolean.valueOf(p()).compareTo(java.lang.Boolean.valueOf(haVar.p()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (p() && (a6 = com.xiaomi.push.hx.a(this.o, haVar.o)) != 0) {
            return a6;
        }
        int compareTo16 = java.lang.Boolean.valueOf(r()).compareTo(java.lang.Boolean.valueOf(haVar.r()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (r() && (a5 = com.xiaomi.push.hx.a(this.p, haVar.p)) != 0) {
            return a5;
        }
        int compareTo17 = java.lang.Boolean.valueOf(s()).compareTo(java.lang.Boolean.valueOf(haVar.s()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (s() && (a4 = com.xiaomi.push.hx.a(this.q, haVar.q)) != 0) {
            return a4;
        }
        int compareTo18 = java.lang.Boolean.valueOf(t()).compareTo(java.lang.Boolean.valueOf(haVar.t()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (t() && (a3 = com.xiaomi.push.hx.a(this.r, haVar.r)) != 0) {
            return a3;
        }
        int compareTo19 = java.lang.Boolean.valueOf(u()).compareTo(java.lang.Boolean.valueOf(haVar.u()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (u() && (a2 = com.xiaomi.push.hx.a(this.f475s, haVar.f475s)) != 0) {
            return a2;
        }
        int compareTo20 = java.lang.Boolean.valueOf(v()).compareTo(java.lang.Boolean.valueOf(haVar.v()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!v() || (a = com.xiaomi.push.hx.a(this.t, haVar.t)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.ha)) {
            com.xiaomi.push.ha haVar = (com.xiaomi.push.ha) obj;
            boolean a = a();
            boolean a2 = haVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(haVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = haVar.b();
            if ((b || b2) && !(b && b2 && this.b.a(haVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = haVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(haVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = haVar.d();
            if (((d || d2) && !(d && d2 && this.d.equals(haVar.d))) || this.e != haVar.e) {
                return false;
            }
            boolean g = g();
            boolean g2 = haVar.g();
            if ((g || g2) && !(g && g2 && this.f.equals(haVar.f))) {
                return false;
            }
            boolean h = h();
            boolean h2 = haVar.h();
            if ((h || h2) && !(h && h2 && this.g.equals(haVar.g))) {
                return false;
            }
            boolean i = i();
            boolean i2 = haVar.i();
            if ((i || i2) && !(i && i2 && this.h.a(haVar.h))) {
                return false;
            }
            boolean j = j();
            boolean j2 = haVar.j();
            if ((j || j2) && !(j && j2 && this.i.equals(haVar.i))) {
                return false;
            }
            boolean k = k();
            boolean k2 = haVar.k();
            if ((k || k2) && !(k && k2 && this.j.equals(haVar.j))) {
                return false;
            }
            boolean l = l();
            boolean l2 = haVar.l();
            if ((l || l2) && !(l && l2 && this.k == haVar.k)) {
                return false;
            }
            boolean m = m();
            boolean m2 = haVar.m();
            if ((m || m2) && !(m && m2 && this.l.equals(haVar.l))) {
                return false;
            }
            boolean n = n();
            boolean n2 = haVar.n();
            if ((n || n2) && !(n && n2 && this.m.equals(haVar.m))) {
                return false;
            }
            boolean o = o();
            boolean o2 = haVar.o();
            if ((o || o2) && !(o && o2 && this.n.equals(haVar.n))) {
                return false;
            }
            boolean p = p();
            boolean p2 = haVar.p();
            if ((p || p2) && !(p && p2 && this.o == haVar.o)) {
                return false;
            }
            boolean r = r();
            boolean r2 = haVar.r();
            if ((r || r2) && !(r && r2 && this.p == haVar.p)) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = haVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.q.equals(haVar.q))) {
                return false;
            }
            boolean t = t();
            boolean t2 = haVar.t();
            if ((t || t2) && !(t && t2 && this.r.equals(haVar.r))) {
                return false;
            }
            boolean u2 = u();
            boolean u3 = haVar.u();
            if ((u2 || u3) && !(u2 && u3 && this.f475s == haVar.f475s)) {
                return false;
            }
            boolean v2 = v();
            boolean v3 = haVar.v();
            if (v2 || v3) {
                return v2 && v3 && this.t.equals(haVar.t);
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionAckMessage(");
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
        sb.append("messageTs:");
        sb.append(this.e);
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            java.lang.String str4 = this.f;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str5 = this.g;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("request:");
            com.xiaomi.push.ho hoVar = this.h;
            if (hoVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(hoVar);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str6 = this.i;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            java.lang.String str7 = this.j;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.k);
        }
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            java.lang.String str8 = this.l;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            java.lang.String str9 = this.m;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            java.lang.String str10 = this.n;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.o);
        }
        if (r()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.p);
        }
        if (s()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            java.lang.String str11 = this.q;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("deviceId:");
            java.lang.String str12 = this.r;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f475s);
        }
        if (v()) {
            sb.append(", ");
            sb.append("extra:");
            java.util.Map<java.lang.String, java.lang.String> map = this.t;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
