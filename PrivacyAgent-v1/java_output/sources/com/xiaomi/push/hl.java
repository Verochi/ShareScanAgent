package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hl implements com.xiaomi.push.hw<com.xiaomi.push.hl, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im D = new com.xiaomi.push.im("XmPushActionRegistration");
    private static final com.xiaomi.push.ie E = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie F = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie G = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie H = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie I = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie J = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie K = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie L = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie M = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie N = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie O = new com.xiaomi.push.ie("", (byte) 11, 11);
    private static final com.xiaomi.push.ie P = new com.xiaomi.push.ie("", (byte) 11, 12);
    private static final com.xiaomi.push.ie Q = new com.xiaomi.push.ie("", (byte) 8, 13);
    private static final com.xiaomi.push.ie R = new com.xiaomi.push.ie("", (byte) 8, 14);
    private static final com.xiaomi.push.ie S = new com.xiaomi.push.ie("", (byte) 11, 15);
    private static final com.xiaomi.push.ie T = new com.xiaomi.push.ie("", (byte) 11, 16);
    private static final com.xiaomi.push.ie U = new com.xiaomi.push.ie("", (byte) 11, 17);
    private static final com.xiaomi.push.ie V = new com.xiaomi.push.ie("", (byte) 11, 18);
    private static final com.xiaomi.push.ie W = new com.xiaomi.push.ie("", (byte) 8, 19);
    private static final com.xiaomi.push.ie X = new com.xiaomi.push.ie("", (byte) 8, 20);
    private static final com.xiaomi.push.ie Y = new com.xiaomi.push.ie("", (byte) 2, 21);
    private static final com.xiaomi.push.ie Z = new com.xiaomi.push.ie("", (byte) 10, 22);
    private static final com.xiaomi.push.ie aa = new com.xiaomi.push.ie("", (byte) 10, 23);
    private static final com.xiaomi.push.ie ab = new com.xiaomi.push.ie("", (byte) 11, 24);
    private static final com.xiaomi.push.ie ac = new com.xiaomi.push.ie("", (byte) 11, 25);
    private static final com.xiaomi.push.ie ad = new com.xiaomi.push.ie("", (byte) 2, 26);
    private static final com.xiaomi.push.ie ae = new com.xiaomi.push.ie("", (byte) 13, 100);
    private static final com.xiaomi.push.ie af = new com.xiaomi.push.ie("", (byte) 2, 101);
    private static final com.xiaomi.push.ie ag = new com.xiaomi.push.ie("", (byte) 11, 102);
    public java.util.Map<java.lang.String, java.lang.String> A;
    public java.lang.String C;
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public int m;
    public int n;
    public java.lang.String o;
    public java.lang.String p;
    public java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public int f480s;
    public com.xiaomi.push.gy t;
    public long v;
    public long w;
    public java.lang.String x;
    public java.lang.String y;
    private java.util.BitSet ah = new java.util.BitSet(8);
    public boolean u = true;
    public boolean B = false;
    public boolean z = false;

    private boolean A() {
        return this.ah.get(5);
    }

    private boolean B() {
        return this.x != null;
    }

    private boolean C() {
        return this.y != null;
    }

    private boolean D() {
        return this.ah.get(6);
    }

    private boolean E() {
        return this.A != null;
    }

    private boolean F() {
        return this.ah.get(7);
    }

    private boolean G() {
        return this.C != null;
    }

    private void H() {
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d == null) {
            throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.g != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'token' was not present! Struct: " + toString(), (byte) 0);
    }

    private boolean b() {
        return this.a != null;
    }

    private boolean c() {
        return this.b != null;
    }

    private boolean d() {
        return this.c != null;
    }

    private boolean e() {
        return this.d != null;
    }

    private boolean f() {
        return this.e != null;
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
        return this.k != null;
    }

    private boolean m() {
        return this.l != null;
    }

    private boolean n() {
        return this.ah.get(0);
    }

    private void o() {
        this.ah.set(0, true);
    }

    private boolean p() {
        return this.ah.get(1);
    }

    private void q() {
        this.ah.set(1, true);
    }

    private boolean r() {
        return this.o != null;
    }

    private boolean s() {
        return this.p != null;
    }

    private boolean t() {
        return this.q != null;
    }

    private boolean u() {
        return this.r != null;
    }

    private boolean v() {
        return this.ah.get(2);
    }

    private void w() {
        this.ah.set(2, true);
    }

    private boolean x() {
        return this.t != null;
    }

    private boolean y() {
        return this.ah.get(3);
    }

    private boolean z() {
        return this.ah.get(4);
    }

    public final com.xiaomi.push.hl a() {
        this.m = 40090;
        o();
        return this;
    }

    public final com.xiaomi.push.hl a(int i) {
        this.n = i;
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
                H();
                return;
            }
            short s2 = b.c;
            switch (s2) {
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
                    if (b2 == 11) {
                        this.e = ihVar.l();
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
                    if (b2 == 11) {
                        this.h = ihVar.l();
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
                    if (b2 == 11) {
                        this.k = ihVar.l();
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
                    if (b2 == 8) {
                        this.m = ihVar.i();
                        o();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 8) {
                        this.n = ihVar.i();
                        q();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.o = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 11) {
                        this.p = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.q = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 11) {
                        this.r = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 8) {
                        this.f480s = ihVar.i();
                        w();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 8) {
                        this.t = com.xiaomi.push.gy.a(ihVar.i());
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 2) {
                        this.u = ihVar.f();
                        bitSet = this.ah;
                        i = 3;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 10) {
                        this.v = ihVar.j();
                        bitSet = this.ah;
                        i = 4;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 10) {
                        this.w = ihVar.j();
                        bitSet = this.ah;
                        i = 5;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 24:
                    if (b2 == 11) {
                        this.x = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 25:
                    if (b2 == 11) {
                        this.y = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 26:
                    if (b2 == 2) {
                        this.z = ihVar.f();
                        bitSet = this.ah;
                        i = 6;
                        bitSet.set(i, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                com.xiaomi.push.ig c = ihVar.c();
                                this.A = new java.util.HashMap(c.c * 2);
                                for (int i2 = 0; i2 < c.c; i2++) {
                                    this.A.put(ihVar.l(), ihVar.l());
                                }
                                break;
                            } else {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            }
                        case 101:
                            if (b2 == 2) {
                                this.B = ihVar.f();
                                bitSet = this.ah;
                                i = 7;
                                bitSet.set(i, true);
                                break;
                            } else {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            }
                        case 102:
                            if (b2 == 11) {
                                this.C = ihVar.l();
                                break;
                            } else {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            }
                        default:
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                    }
            }
        }
    }

    public final com.xiaomi.push.hl b(int i) {
        this.f480s = i;
        w();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        H();
        if (this.a != null && b()) {
            ihVar.a(E);
            ihVar.a(this.a);
        }
        if (this.b != null && c()) {
            ihVar.a(F);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(G);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(H);
            ihVar.a(this.d);
        }
        if (this.e != null && f()) {
            ihVar.a(I);
            ihVar.a(this.e);
        }
        if (this.f != null && g()) {
            ihVar.a(J);
            ihVar.a(this.f);
        }
        if (this.g != null) {
            ihVar.a(K);
            ihVar.a(this.g);
        }
        if (this.h != null && i()) {
            ihVar.a(L);
            ihVar.a(this.h);
        }
        if (this.i != null && j()) {
            ihVar.a(M);
            ihVar.a(this.i);
        }
        if (this.j != null && k()) {
            ihVar.a(N);
            ihVar.a(this.j);
        }
        if (this.k != null && l()) {
            ihVar.a(O);
            ihVar.a(this.k);
        }
        if (this.l != null && m()) {
            ihVar.a(P);
            ihVar.a(this.l);
        }
        if (n()) {
            ihVar.a(Q);
            ihVar.a(this.m);
        }
        if (p()) {
            ihVar.a(R);
            ihVar.a(this.n);
        }
        if (this.o != null && r()) {
            ihVar.a(S);
            ihVar.a(this.o);
        }
        if (this.p != null && s()) {
            ihVar.a(T);
            ihVar.a(this.p);
        }
        if (this.q != null && t()) {
            ihVar.a(U);
            ihVar.a(this.q);
        }
        if (this.r != null && u()) {
            ihVar.a(V);
            ihVar.a(this.r);
        }
        if (v()) {
            ihVar.a(W);
            ihVar.a(this.f480s);
        }
        if (this.t != null && x()) {
            ihVar.a(X);
            ihVar.a(this.t.d);
        }
        if (y()) {
            ihVar.a(Y);
            ihVar.a(this.u);
        }
        if (z()) {
            ihVar.a(Z);
            ihVar.a(this.v);
        }
        if (A()) {
            ihVar.a(aa);
            ihVar.a(this.w);
        }
        if (this.x != null && B()) {
            ihVar.a(ab);
            ihVar.a(this.x);
        }
        if (this.y != null && C()) {
            ihVar.a(ac);
            ihVar.a(this.y);
        }
        if (D()) {
            ihVar.a(ad);
            ihVar.a(this.z);
        }
        if (this.A != null && E()) {
            ihVar.a(ae);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.A.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.A.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
            }
        }
        if (F()) {
            ihVar.a(af);
            ihVar.a(this.B);
        }
        if (this.C != null && G()) {
            ihVar.a(ag);
            ihVar.a(this.C);
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
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        com.xiaomi.push.hl hlVar = (com.xiaomi.push.hl) obj;
        if (!com.xiaomi.push.hl.class.equals(hlVar.getClass())) {
            return com.xiaomi.push.hl.class.getName().compareTo(com.xiaomi.push.hl.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hlVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a29 = com.xiaomi.push.hx.a(this.a, hlVar.a)) != 0) {
            return a29;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hlVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a28 = com.xiaomi.push.hx.a(this.b, hlVar.b)) != 0) {
            return a28;
        }
        int compareTo3 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hlVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a27 = com.xiaomi.push.hx.a(this.c, hlVar.c)) != 0) {
            return a27;
        }
        int compareTo4 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hlVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a26 = com.xiaomi.push.hx.a(this.d, hlVar.d)) != 0) {
            return a26;
        }
        int compareTo5 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hlVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a25 = com.xiaomi.push.hx.a(this.e, hlVar.e)) != 0) {
            return a25;
        }
        int compareTo6 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hlVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a24 = com.xiaomi.push.hx.a(this.f, hlVar.f)) != 0) {
            return a24;
        }
        int compareTo7 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hlVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a23 = com.xiaomi.push.hx.a(this.g, hlVar.g)) != 0) {
            return a23;
        }
        int compareTo8 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hlVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a22 = com.xiaomi.push.hx.a(this.h, hlVar.h)) != 0) {
            return a22;
        }
        int compareTo9 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hlVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (j() && (a21 = com.xiaomi.push.hx.a(this.i, hlVar.i)) != 0) {
            return a21;
        }
        int compareTo10 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hlVar.k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (k() && (a20 = com.xiaomi.push.hx.a(this.j, hlVar.j)) != 0) {
            return a20;
        }
        int compareTo11 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(hlVar.l()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (l() && (a19 = com.xiaomi.push.hx.a(this.k, hlVar.k)) != 0) {
            return a19;
        }
        int compareTo12 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(hlVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a18 = com.xiaomi.push.hx.a(this.l, hlVar.l)) != 0) {
            return a18;
        }
        int compareTo13 = java.lang.Boolean.valueOf(n()).compareTo(java.lang.Boolean.valueOf(hlVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (n() && (a17 = com.xiaomi.push.hx.a(this.m, hlVar.m)) != 0) {
            return a17;
        }
        int compareTo14 = java.lang.Boolean.valueOf(p()).compareTo(java.lang.Boolean.valueOf(hlVar.p()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (p() && (a16 = com.xiaomi.push.hx.a(this.n, hlVar.n)) != 0) {
            return a16;
        }
        int compareTo15 = java.lang.Boolean.valueOf(r()).compareTo(java.lang.Boolean.valueOf(hlVar.r()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (r() && (a15 = com.xiaomi.push.hx.a(this.o, hlVar.o)) != 0) {
            return a15;
        }
        int compareTo16 = java.lang.Boolean.valueOf(s()).compareTo(java.lang.Boolean.valueOf(hlVar.s()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (s() && (a14 = com.xiaomi.push.hx.a(this.p, hlVar.p)) != 0) {
            return a14;
        }
        int compareTo17 = java.lang.Boolean.valueOf(t()).compareTo(java.lang.Boolean.valueOf(hlVar.t()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (t() && (a13 = com.xiaomi.push.hx.a(this.q, hlVar.q)) != 0) {
            return a13;
        }
        int compareTo18 = java.lang.Boolean.valueOf(u()).compareTo(java.lang.Boolean.valueOf(hlVar.u()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (u() && (a12 = com.xiaomi.push.hx.a(this.r, hlVar.r)) != 0) {
            return a12;
        }
        int compareTo19 = java.lang.Boolean.valueOf(v()).compareTo(java.lang.Boolean.valueOf(hlVar.v()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (v() && (a11 = com.xiaomi.push.hx.a(this.f480s, hlVar.f480s)) != 0) {
            return a11;
        }
        int compareTo20 = java.lang.Boolean.valueOf(x()).compareTo(java.lang.Boolean.valueOf(hlVar.x()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (x() && (a10 = com.xiaomi.push.hx.a(this.t, hlVar.t)) != 0) {
            return a10;
        }
        int compareTo21 = java.lang.Boolean.valueOf(y()).compareTo(java.lang.Boolean.valueOf(hlVar.y()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (y() && (a9 = com.xiaomi.push.hx.a(this.u, hlVar.u)) != 0) {
            return a9;
        }
        int compareTo22 = java.lang.Boolean.valueOf(z()).compareTo(java.lang.Boolean.valueOf(hlVar.z()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (z() && (a8 = com.xiaomi.push.hx.a(this.v, hlVar.v)) != 0) {
            return a8;
        }
        int compareTo23 = java.lang.Boolean.valueOf(A()).compareTo(java.lang.Boolean.valueOf(hlVar.A()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (A() && (a7 = com.xiaomi.push.hx.a(this.w, hlVar.w)) != 0) {
            return a7;
        }
        int compareTo24 = java.lang.Boolean.valueOf(B()).compareTo(java.lang.Boolean.valueOf(hlVar.B()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (B() && (a6 = com.xiaomi.push.hx.a(this.x, hlVar.x)) != 0) {
            return a6;
        }
        int compareTo25 = java.lang.Boolean.valueOf(C()).compareTo(java.lang.Boolean.valueOf(hlVar.C()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (C() && (a5 = com.xiaomi.push.hx.a(this.y, hlVar.y)) != 0) {
            return a5;
        }
        int compareTo26 = java.lang.Boolean.valueOf(D()).compareTo(java.lang.Boolean.valueOf(hlVar.D()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (D() && (a4 = com.xiaomi.push.hx.a(this.z, hlVar.z)) != 0) {
            return a4;
        }
        int compareTo27 = java.lang.Boolean.valueOf(E()).compareTo(java.lang.Boolean.valueOf(hlVar.E()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (E() && (a3 = com.xiaomi.push.hx.a(this.A, hlVar.A)) != 0) {
            return a3;
        }
        int compareTo28 = java.lang.Boolean.valueOf(F()).compareTo(java.lang.Boolean.valueOf(hlVar.F()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (F() && (a2 = com.xiaomi.push.hx.a(this.B, hlVar.B)) != 0) {
            return a2;
        }
        int compareTo29 = java.lang.Boolean.valueOf(G()).compareTo(java.lang.Boolean.valueOf(hlVar.G()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!G() || (a = com.xiaomi.push.hx.a(this.C, hlVar.C)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hl)) {
            com.xiaomi.push.hl hlVar = (com.xiaomi.push.hl) obj;
            boolean b = b();
            boolean b2 = hlVar.b();
            if ((b || b2) && !(b && b2 && this.a.equals(hlVar.a))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hlVar.c();
            if ((c || c2) && !(c && c2 && this.b.a(hlVar.b))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hlVar.d();
            if ((d || d2) && !(d && d2 && this.c.equals(hlVar.c))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hlVar.e();
            if ((e || e2) && !(e && e2 && this.d.equals(hlVar.d))) {
                return false;
            }
            boolean f = f();
            boolean f2 = hlVar.f();
            if ((f || f2) && !(f && f2 && this.e.equals(hlVar.e))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hlVar.g();
            if ((g || g2) && !(g && g2 && this.f.equals(hlVar.f))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hlVar.h();
            if ((h || h2) && !(h && h2 && this.g.equals(hlVar.g))) {
                return false;
            }
            boolean i = i();
            boolean i2 = hlVar.i();
            if ((i || i2) && !(i && i2 && this.h.equals(hlVar.h))) {
                return false;
            }
            boolean j = j();
            boolean j2 = hlVar.j();
            if ((j || j2) && !(j && j2 && this.i.equals(hlVar.i))) {
                return false;
            }
            boolean k = k();
            boolean k2 = hlVar.k();
            if ((k || k2) && !(k && k2 && this.j.equals(hlVar.j))) {
                return false;
            }
            boolean l = l();
            boolean l2 = hlVar.l();
            if ((l || l2) && !(l && l2 && this.k.equals(hlVar.k))) {
                return false;
            }
            boolean m = m();
            boolean m2 = hlVar.m();
            if ((m || m2) && !(m && m2 && this.l.equals(hlVar.l))) {
                return false;
            }
            boolean n = n();
            boolean n2 = hlVar.n();
            if ((n || n2) && !(n && n2 && this.m == hlVar.m)) {
                return false;
            }
            boolean p = p();
            boolean p2 = hlVar.p();
            if ((p || p2) && !(p && p2 && this.n == hlVar.n)) {
                return false;
            }
            boolean r = r();
            boolean r2 = hlVar.r();
            if ((r || r2) && !(r && r2 && this.o.equals(hlVar.o))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = hlVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.p.equals(hlVar.p))) {
                return false;
            }
            boolean t = t();
            boolean t2 = hlVar.t();
            if ((t || t2) && !(t && t2 && this.q.equals(hlVar.q))) {
                return false;
            }
            boolean u = u();
            boolean u2 = hlVar.u();
            if ((u || u2) && !(u && u2 && this.r.equals(hlVar.r))) {
                return false;
            }
            boolean v = v();
            boolean v2 = hlVar.v();
            if ((v || v2) && !(v && v2 && this.f480s == hlVar.f480s)) {
                return false;
            }
            boolean x = x();
            boolean x2 = hlVar.x();
            if ((x || x2) && !(x && x2 && this.t.equals(hlVar.t))) {
                return false;
            }
            boolean y = y();
            boolean y2 = hlVar.y();
            if ((y || y2) && !(y && y2 && this.u == hlVar.u)) {
                return false;
            }
            boolean z = z();
            boolean z2 = hlVar.z();
            if ((z || z2) && !(z && z2 && this.v == hlVar.v)) {
                return false;
            }
            boolean A = A();
            boolean A2 = hlVar.A();
            if ((A || A2) && !(A && A2 && this.w == hlVar.w)) {
                return false;
            }
            boolean B = B();
            boolean B2 = hlVar.B();
            if ((B || B2) && !(B && B2 && this.x.equals(hlVar.x))) {
                return false;
            }
            boolean C = C();
            boolean C2 = hlVar.C();
            if ((C || C2) && !(C && C2 && this.y.equals(hlVar.y))) {
                return false;
            }
            boolean D2 = D();
            boolean D3 = hlVar.D();
            if ((D2 || D3) && !(D2 && D3 && this.z == hlVar.z)) {
                return false;
            }
            boolean E2 = E();
            boolean E3 = hlVar.E();
            if ((E2 || E3) && !(E2 && E3 && this.A.equals(hlVar.A))) {
                return false;
            }
            boolean F2 = F();
            boolean F3 = hlVar.F();
            if ((F2 || F3) && !(F2 && F3 && this.B == hlVar.B)) {
                return false;
            }
            boolean G2 = G();
            boolean G3 = hlVar.G();
            if (G2 || G3) {
                return G2 && G3 && this.C.equals(hlVar.C);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        boolean z;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionRegistration(");
        boolean z2 = false;
        if (b()) {
            sb.append("debug:");
            java.lang.String str = this.a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (c()) {
            if (!z) {
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
            z2 = z;
        }
        if (!z2) {
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
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            java.lang.String str4 = this.e;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str5 = this.f;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        java.lang.String str6 = this.g;
        if (str6 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str6);
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            java.lang.String str7 = this.h;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str8 = this.i;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            java.lang.String str9 = this.j;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            java.lang.String str10 = this.k;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            java.lang.String str11 = this.l;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.m);
        }
        if (p()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.n);
        }
        if (r()) {
            sb.append(", ");
            sb.append("androidId:");
            java.lang.String str12 = this.o;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("imei:");
            java.lang.String str13 = this.p;
            if (str13 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str13);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("serial:");
            java.lang.String str14 = this.q;
            if (str14 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str14);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            java.lang.String str15 = this.r;
            if (str15 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str15);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f480s);
        }
        if (x()) {
            sb.append(", ");
            sb.append("reason:");
            com.xiaomi.push.gy gyVar = this.t;
            if (gyVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gyVar);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.u);
        }
        if (z()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.v);
        }
        if (A()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.w);
        }
        if (B()) {
            sb.append(", ");
            sb.append("subImei:");
            java.lang.String str16 = this.x;
            if (str16 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str16);
            }
        }
        if (C()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            java.lang.String str17 = this.y;
            if (str17 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str17);
            }
        }
        if (D()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.z);
        }
        if (E()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            java.util.Map<java.lang.String, java.lang.String> map = this.A;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (F()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.B);
        }
        if (G()) {
            sb.append(", ");
            sb.append("oldRegId:");
            java.lang.String str18 = this.C;
            if (str18 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
