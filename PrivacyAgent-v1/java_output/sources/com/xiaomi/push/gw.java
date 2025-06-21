package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gw implements com.xiaomi.push.hw<com.xiaomi.push.gw, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    public com.xiaomi.push.gz a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public long e;
    public long f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public com.xiaomi.push.gx l;
    public java.lang.String m;
    public java.lang.String o;
    public long p;
    public java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.im f473s = new com.xiaomi.push.im("PushMessage");
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 12, 1);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 11, 2);
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 10, 5);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 10, 6);
    private static final com.xiaomi.push.ie z = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie A = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie B = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie C = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie D = new com.xiaomi.push.ie("", (byte) 11, 11);
    private static final com.xiaomi.push.ie E = new com.xiaomi.push.ie("", (byte) 12, 12);
    private static final com.xiaomi.push.ie F = new com.xiaomi.push.ie("", (byte) 11, 13);
    private static final com.xiaomi.push.ie G = new com.xiaomi.push.ie("", (byte) 2, 14);
    private static final com.xiaomi.push.ie H = new com.xiaomi.push.ie("", (byte) 11, 15);
    private static final com.xiaomi.push.ie I = new com.xiaomi.push.ie("", (byte) 10, 16);
    private static final com.xiaomi.push.ie J = new com.xiaomi.push.ie("", (byte) 11, 20);
    private static final com.xiaomi.push.ie K = new com.xiaomi.push.ie("", (byte) 11, 21);
    private java.util.BitSet L = new java.util.BitSet(4);
    public boolean n = false;

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
        return this.L.get(0);
    }

    private boolean f() {
        return this.L.get(1);
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
        return this.j != null;
    }

    private boolean k() {
        return this.k != null;
    }

    private boolean l() {
        return this.l != null;
    }

    private boolean m() {
        return this.m != null;
    }

    private boolean n() {
        return this.L.get(2);
    }

    private boolean o() {
        return this.o != null;
    }

    private boolean p() {
        return this.L.get(3);
    }

    private boolean q() {
        return this.q != null;
    }

    private boolean r() {
        return this.r != null;
    }

    private void s() {
        if (this.b == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'payload' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        java.util.BitSet bitSet;
        int i;
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                s();
                return;
            }
            short s2 = b.c;
            if (s2 != 20) {
                if (s2 != 21) {
                    switch (s2) {
                        case 1:
                            if (b2 != 12) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
                                this.a = gzVar;
                                gzVar.a(ihVar);
                                break;
                            }
                        case 2:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.b = ihVar.l();
                                break;
                            }
                        case 3:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.c = ihVar.l();
                                break;
                            }
                        case 4:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.d = ihVar.l();
                                break;
                            }
                        case 5:
                            if (b2 != 10) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.e = ihVar.j();
                                bitSet = this.L;
                                i = 0;
                                bitSet.set(i, true);
                                break;
                            }
                        case 6:
                            if (b2 != 10) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.f = ihVar.j();
                                this.L.set(1, true);
                                break;
                            }
                        case 7:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.g = ihVar.l();
                                break;
                            }
                        case 8:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.h = ihVar.l();
                                break;
                            }
                        case 9:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.i = ihVar.l();
                                break;
                            }
                        case 10:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.j = ihVar.l();
                                break;
                            }
                        case 11:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.k = ihVar.l();
                                break;
                            }
                        case 12:
                            if (b2 != 12) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                com.xiaomi.push.gx gxVar = new com.xiaomi.push.gx();
                                this.l = gxVar;
                                gxVar.a(ihVar);
                                break;
                            }
                        case 13:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.m = ihVar.l();
                                break;
                            }
                        case 14:
                            if (b2 != 2) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.n = ihVar.f();
                                this.L.set(2, true);
                                break;
                            }
                        case 15:
                            if (b2 != 11) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.o = ihVar.l();
                                break;
                            }
                        case 16:
                            if (b2 != 10) {
                                com.xiaomi.push.ik.a(ihVar, b2);
                                break;
                            } else {
                                this.p = ihVar.j();
                                bitSet = this.L;
                                i = 3;
                                bitSet.set(i, true);
                                break;
                            }
                        default:
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                    }
                } else if (b2 == 11) {
                    this.r = ihVar.l();
                } else {
                    com.xiaomi.push.ik.a(ihVar, b2);
                }
            } else if (b2 == 11) {
                this.q = ihVar.l();
            } else {
                com.xiaomi.push.ik.a(ihVar, b2);
            }
        }
    }

    public final boolean a(com.xiaomi.push.gw gwVar) {
        if (gwVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = gwVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(gwVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = gwVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(gwVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = gwVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(gwVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = gwVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(gwVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = gwVar.e();
        if ((e || e2) && !(e && e2 && this.e == gwVar.e)) {
            return false;
        }
        boolean f = f();
        boolean f2 = gwVar.f();
        if ((f || f2) && !(f && f2 && this.f == gwVar.f)) {
            return false;
        }
        boolean g = g();
        boolean g2 = gwVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(gwVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = gwVar.h();
        if ((h || h2) && !(h && h2 && this.h.equals(gwVar.h))) {
            return false;
        }
        boolean i = i();
        boolean i2 = gwVar.i();
        if ((i || i2) && !(i && i2 && this.i.equals(gwVar.i))) {
            return false;
        }
        boolean j = j();
        boolean j2 = gwVar.j();
        if ((j || j2) && !(j && j2 && this.j.equals(gwVar.j))) {
            return false;
        }
        boolean k = k();
        boolean k2 = gwVar.k();
        if ((k || k2) && !(k && k2 && this.k.equals(gwVar.k))) {
            return false;
        }
        boolean l = l();
        boolean l2 = gwVar.l();
        if ((l || l2) && !(l && l2 && this.l.a(gwVar.l))) {
            return false;
        }
        boolean m = m();
        boolean m2 = gwVar.m();
        if ((m || m2) && !(m && m2 && this.m.equals(gwVar.m))) {
            return false;
        }
        boolean n = n();
        boolean n2 = gwVar.n();
        if ((n || n2) && !(n && n2 && this.n == gwVar.n)) {
            return false;
        }
        boolean o = o();
        boolean o2 = gwVar.o();
        if ((o || o2) && !(o && o2 && this.o.equals(gwVar.o))) {
            return false;
        }
        boolean p = p();
        boolean p2 = gwVar.p();
        if ((p || p2) && !(p && p2 && this.p == gwVar.p)) {
            return false;
        }
        boolean q = q();
        boolean q2 = gwVar.q();
        if ((q || q2) && !(q && q2 && this.q.equals(gwVar.q))) {
            return false;
        }
        boolean r = r();
        boolean r2 = gwVar.r();
        if (r || r2) {
            return r && r2 && this.r.equals(gwVar.r);
        }
        return true;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        s();
        if (this.a != null && a()) {
            ihVar.a(t);
            this.a.b(ihVar);
        }
        if (this.b != null) {
            ihVar.a(u);
            ihVar.a(this.b);
        }
        if (this.c != null) {
            ihVar.a(v);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(w);
            ihVar.a(this.d);
        }
        if (e()) {
            ihVar.a(x);
            ihVar.a(this.e);
        }
        if (f()) {
            ihVar.a(y);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(z);
            ihVar.a(this.g);
        }
        if (this.h != null && h()) {
            ihVar.a(A);
            ihVar.a(this.h);
        }
        if (this.i != null && i()) {
            ihVar.a(B);
            ihVar.a(this.i);
        }
        if (this.j != null && j()) {
            ihVar.a(C);
            ihVar.a(this.j);
        }
        if (this.k != null && k()) {
            ihVar.a(D);
            ihVar.a(this.k);
        }
        if (this.l != null && l()) {
            ihVar.a(E);
            this.l.b(ihVar);
        }
        if (this.m != null && m()) {
            ihVar.a(F);
            ihVar.a(this.m);
        }
        if (n()) {
            ihVar.a(G);
            ihVar.a(this.n);
        }
        if (this.o != null && o()) {
            ihVar.a(H);
            ihVar.a(this.o);
        }
        if (p()) {
            ihVar.a(I);
            ihVar.a(this.p);
        }
        if (this.q != null && q()) {
            ihVar.a(J);
            ihVar.a(this.q);
        }
        if (this.r != null && r()) {
            ihVar.a(K);
            ihVar.a(this.r);
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
        com.xiaomi.push.gw gwVar = (com.xiaomi.push.gw) obj;
        if (!com.xiaomi.push.gw.class.equals(gwVar.getClass())) {
            return com.xiaomi.push.gw.class.getName().compareTo(com.xiaomi.push.gw.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(gwVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a18 = com.xiaomi.push.hx.a(this.a, gwVar.a)) != 0) {
            return a18;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(gwVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a17 = com.xiaomi.push.hx.a(this.b, gwVar.b)) != 0) {
            return a17;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(gwVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a16 = com.xiaomi.push.hx.a(this.c, gwVar.c)) != 0) {
            return a16;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(gwVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a15 = com.xiaomi.push.hx.a(this.d, gwVar.d)) != 0) {
            return a15;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(gwVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a14 = com.xiaomi.push.hx.a(this.e, gwVar.e)) != 0) {
            return a14;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(gwVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a13 = com.xiaomi.push.hx.a(this.f, gwVar.f)) != 0) {
            return a13;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(gwVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a12 = com.xiaomi.push.hx.a(this.g, gwVar.g)) != 0) {
            return a12;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(gwVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a11 = com.xiaomi.push.hx.a(this.h, gwVar.h)) != 0) {
            return a11;
        }
        int compareTo9 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(gwVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a10 = com.xiaomi.push.hx.a(this.i, gwVar.i)) != 0) {
            return a10;
        }
        int compareTo10 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(gwVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a9 = com.xiaomi.push.hx.a(this.j, gwVar.j)) != 0) {
            return a9;
        }
        int compareTo11 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(gwVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a8 = com.xiaomi.push.hx.a(this.k, gwVar.k)) != 0) {
            return a8;
        }
        int compareTo12 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(gwVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a7 = com.xiaomi.push.hx.a(this.l, gwVar.l)) != 0) {
            return a7;
        }
        int compareTo13 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(gwVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a6 = com.xiaomi.push.hx.a(this.m, gwVar.m)) != 0) {
            return a6;
        }
        int compareTo14 = java.lang.Boolean.valueOf(n()).compareTo(java.lang.Boolean.valueOf(gwVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a5 = com.xiaomi.push.hx.a(this.n, gwVar.n)) != 0) {
            return a5;
        }
        int compareTo15 = java.lang.Boolean.valueOf(o()).compareTo(java.lang.Boolean.valueOf(gwVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a4 = com.xiaomi.push.hx.a(this.o, gwVar.o)) != 0) {
            return a4;
        }
        int compareTo16 = java.lang.Boolean.valueOf(p()).compareTo(java.lang.Boolean.valueOf(gwVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a3 = com.xiaomi.push.hx.a(this.p, gwVar.p)) != 0) {
            return a3;
        }
        int compareTo17 = java.lang.Boolean.valueOf(q()).compareTo(java.lang.Boolean.valueOf(gwVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a2 = com.xiaomi.push.hx.a(this.q, gwVar.q)) != 0) {
            return a2;
        }
        int compareTo18 = java.lang.Boolean.valueOf(r()).compareTo(java.lang.Boolean.valueOf(gwVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (a = com.xiaomi.push.hx.a(this.r, gwVar.r)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.gw)) {
            return a((com.xiaomi.push.gw) obj);
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        boolean z2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("PushMessage(");
        if (a()) {
            sb.append("to:");
            com.xiaomi.push.gz gzVar = this.a;
            if (gzVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gzVar);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        java.lang.String str = this.b;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        java.lang.String str3 = this.d;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            java.lang.String str4 = this.g;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str5 = this.h;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            java.lang.String str6 = this.i;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            java.lang.String str7 = this.j;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            java.lang.String str8 = this.k;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            com.xiaomi.push.gx gxVar = this.l;
            if (gxVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gxVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str9 = this.m;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.n);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            java.lang.String str10 = this.o;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.p);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            java.lang.String str11 = this.q;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            java.lang.String str12 = this.r;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
