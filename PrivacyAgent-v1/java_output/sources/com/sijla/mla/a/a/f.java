package com.sijla.mla.a.a;

/* loaded from: classes19.dex */
public final class f extends com.sijla.mla.a.a.a {
    private static java.lang.String[] e = {"(for control)", "(for generator)", "(for index)", "(for limit)", "(for state)", "(for step)"};
    private static final java.util.Hashtable f = new java.util.Hashtable();
    private static java.lang.String[] r;

    /* renamed from: s, reason: collision with root package name */
    private static java.util.Hashtable f426s;
    private static com.sijla.mla.a.a.f.e[] t;
    int b;
    com.sijla.mla.a.a.c c;
    private int g;
    private int h;
    private com.sijla.mla.a.a.g.a k;
    private java.io.InputStream l;
    private int n;
    private com.sijla.mla.a.n o;
    private com.sijla.mla.a.n p;
    private byte q;
    private com.sijla.mla.a.a.f.g i = new com.sijla.mla.a.a.f.g((byte) 0);
    private com.sijla.mla.a.a.f.g j = new com.sijla.mla.a.a.f.g((byte) 0);
    com.sijla.mla.a.a.f.b d = new com.sijla.mla.a.a.f.b();
    private char[] m = new char[32];

    public static class a {
        com.sijla.mla.a.a.f.i a = new com.sijla.mla.a.a.f.i();
        com.sijla.mla.a.a.f.i b;
        int c;
        int d;
        int e;
    }

    public static class b {
        com.sijla.mla.a.a.f.h[] a;
        com.sijla.mla.a.a.f.d[] c;
        com.sijla.mla.a.a.f.d[] e;
        int b = 0;
        int d = 0;
        int f = 0;
    }

    public static class c {
        com.sijla.mla.a.a.f.c a;
        com.sijla.mla.a.a.f.i b = new com.sijla.mla.a.a.f.i();
    }

    public static class d {
        com.sijla.mla.a.n a;
        int b;
        int c;
        short d;

        public d(com.sijla.mla.a.n nVar, int i, int i2, short s2) {
            this.a = nVar;
            this.b = i;
            this.c = i2;
            this.d = s2;
        }
    }

    public static class e {
        final byte a;
        final byte b;

        public e(int i, int i2) {
            this.a = (byte) i;
            this.b = (byte) i2;
        }
    }

    /* renamed from: com.sijla.mla.a.a.f$f, reason: collision with other inner class name */
    public static class C0456f {
        com.sijla.mla.a.r a;
        com.sijla.mla.a.n b;

        private C0456f() {
        }

        public /* synthetic */ C0456f(byte b) {
            this();
        }
    }

    public static class g {
        int a;
        final com.sijla.mla.a.a.f.C0456f b;

        private g() {
            this.b = new com.sijla.mla.a.a.f.C0456f((byte) 0);
        }

        public /* synthetic */ g(byte b) {
            this();
        }
    }

    public static class h {
        final short a;

        public h(int i) {
            this.a = (short) i;
        }
    }

    public static class i {
        int a;
        final com.sijla.mla.a.a.f.i.a b = new com.sijla.mla.a.a.f.i.a();
        final com.sijla.mla.a.a.e c = new com.sijla.mla.a.a.e();
        final com.sijla.mla.a.a.e d = new com.sijla.mla.a.a.e();

        public static class a {
            short a;
            short b;
            short c;
            int d;
            private com.sijla.mla.a.r e;

            public final com.sijla.mla.a.r a() {
                com.sijla.mla.a.r rVar = this.e;
                return rVar == null ? com.sijla.mla.a.k.c_(this.d) : rVar;
            }

            public final void a(com.sijla.mla.a.r rVar) {
                this.e = rVar;
            }
        }

        public final void a(int i, int i2) {
            this.d.a = -1;
            this.c.a = -1;
            this.a = i;
            this.b.d = i2;
        }

        public final void a(com.sijla.mla.a.a.f.i iVar) {
            this.d.a = iVar.d.a;
            this.a = iVar.a;
            this.c.a = iVar.c.a;
            this.b.e = iVar.b.e;
            com.sijla.mla.a.a.f.i.a aVar = this.b;
            com.sijla.mla.a.a.f.i.a aVar2 = iVar.b;
            aVar.a = aVar2.a;
            aVar.b = aVar2.b;
            aVar.c = aVar2.c;
            aVar.d = aVar2.d;
        }

        public final boolean a() {
            return this.c.a != this.d.a;
        }

        public final boolean b() {
            return this.a == 5 && this.c.a == -1 && this.d.a == -1;
        }
    }

    static {
        for (int i2 = 0; i2 < 6; i2++) {
            f.put(e[i2], java.lang.Boolean.TRUE);
        }
        r = new java.lang.String[]{com.sijla.mla.L2.s34398285(), com.sijla.mla.L2.s1270569563(), com.sijla.mla.L2.s1112469(), com.sijla.mla.L2.s1069997863(), com.sijla.mla.L2.s1770834026(), com.sijla.mla.L2.s34517449(), com.sijla.mla.L2.s1171527167(), com.sijla.mla.L2.s34548635(), com.sijla.mla.L2.s1767902568(), com.sijla.mla.L2.s1071935549(), com.sijla.mla.L2.s1116995(), com.sijla.mla.L2.s1117243(), com.sijla.mla.L2.s987108167(), com.sijla.mla.L2.s34781011(), com.sijla.mla.L2.s34787025(), com.sijla.mla.L2.s1123133(), com.sijla.mla.L2.s220298117(), com.sijla.mla.L2.s224485008(), com.sijla.mla.L2.s1083718339(), com.sijla.mla.L2.s1084031346(), com.sijla.mla.L2.s729855194(), com.sijla.mla.L2.s678463053(), com.sijla.mla.L2.s1058560(), com.sijla.mla.L2.s32815766(), "==", ">=", "<=", "~=", "::", "<eos>", "<number>", "<name>", "<string>", "<eof>"};
        f426s = new java.util.Hashtable();
        int i3 = 0;
        for (int i4 = 22; i3 < i4; i4 = 22) {
            f426s.put(com.sijla.mla.a.r.h(r[i3]), new java.lang.Integer(i3 + 257));
            i3++;
        }
        t = new com.sijla.mla.a.a.f.e[]{new com.sijla.mla.a.a.f.e(6, 6), new com.sijla.mla.a.a.f.e(6, 6), new com.sijla.mla.a.a.f.e(7, 7), new com.sijla.mla.a.a.f.e(7, 7), new com.sijla.mla.a.a.f.e(7, 7), new com.sijla.mla.a.a.f.e(10, 9), new com.sijla.mla.a.a.f.e(5, 4), new com.sijla.mla.a.a.f.e(3, 3), new com.sijla.mla.a.a.f.e(3, 3), new com.sijla.mla.a.a.f.e(3, 3), new com.sijla.mla.a.a.f.e(3, 3), new com.sijla.mla.a.a.f.e(3, 3), new com.sijla.mla.a.a.f.e(3, 3), new com.sijla.mla.a.a.f.e(2, 2), new com.sijla.mla.a.a.f.e(1, 1)};
    }

    public f(com.sijla.mla.a.a.g.a aVar, java.io.InputStream inputStream) {
        this.l = inputStream;
        this.k = aVar;
    }

    private static int A(int i2) {
        int i3 = 0;
        while (i2 >= 16) {
            i2 = (i2 + 1) >> 1;
            i3++;
        }
        if (i2 < 8) {
            return i2;
        }
        return (i2 - 8) | ((i3 + 1) << 3);
    }

    private void B(int i2) {
        com.sijla.mla.a.n c2;
        int i3 = this.h;
        if (w(266)) {
            c2 = h();
        } else {
            g();
            c2 = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1270569563());
        }
        com.sijla.mla.a.n nVar = c2;
        com.sijla.mla.a.a.f.b bVar = this.d;
        com.sijla.mla.a.a.f.d[] a2 = com.sijla.mla.a.a.a.a(bVar.c, bVar.d + 1);
        bVar.c = a2;
        com.sijla.mla.a.a.f.b bVar2 = this.d;
        int i4 = bVar2.d;
        bVar2.d = i4 + 1;
        n(a(a2, i4, nVar, i3, i2));
    }

    private void C(int i2) {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.c.a aVar = new com.sijla.mla.a.a.c.a();
        g();
        int c2 = cVar.c();
        int m = m();
        cVar.a(aVar, true);
        y(259);
        l();
        cVar.d(cVar.b(), c2);
        b(262, com.anythink.expressad.foundation.g.a.aS, i2);
        cVar.a();
        cVar.o(m);
    }

    private void D(int i2) {
        com.sijla.mla.a.a.c cVar = this.c;
        int c2 = cVar.c();
        com.sijla.mla.a.a.c.a aVar = new com.sijla.mla.a.a.c.a();
        com.sijla.mla.a.a.c.a aVar2 = new com.sijla.mla.a.a.c.a();
        cVar.a(aVar, true);
        cVar.a(aVar2, false);
        g();
        u();
        b(277, 273, i2);
        int m = m();
        if (aVar2.e) {
            cVar.e(m, aVar2.d);
        }
        cVar.a();
        cVar.d(m, c2);
        cVar.a();
    }

    private void E(int i2) {
        com.sijla.mla.a.a.c cVar = this.c;
        cVar.a(new com.sijla.mla.a.a.c.a(), true);
        g();
        com.sijla.mla.a.n h2 = h();
        int i3 = this.i.a;
        if (i3 != 44) {
            if (i3 == 61) {
                com.sijla.mla.a.a.c cVar2 = this.c;
                short s2 = cVar2.o;
                f("(for index)");
                f("(for limit)");
                f("(for step)");
                a(h2);
                y(61);
                o();
                y(44);
                o();
                if (w(44)) {
                    o();
                } else {
                    cVar2.b(1, cVar2.o, cVar2.b(com.sijla.mla.a.k.c_(1)));
                    cVar2.q(1);
                }
                a((int) s2, i2, 1, true);
            } else if (i3 != 268) {
                b(d(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) + " or " + d(java.lang.String.valueOf(com.sijla.mla.L2.s1117243())) + " expected");
            }
            b(262, 264, i2);
            cVar.a();
        }
        com.sijla.mla.a.a.c cVar3 = this.c;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        short s3 = cVar3.o;
        f("(for generator)");
        f("(for state)");
        f("(for control)");
        a(h2);
        int i4 = 4;
        while (w(44)) {
            a(h());
            i4++;
        }
        y(268);
        int i5 = this.h;
        a(3, f(iVar), iVar);
        cVar3.p(3);
        a((int) s3, i5, i4 - 3, false);
        b(262, 264, i2);
        cVar.a();
    }

    private void F(int i2) {
        com.sijla.mla.a.a.e eVar = new com.sijla.mla.a.a.e(-1);
        do {
            a(eVar);
        } while (this.i.a == 261);
        if (w(260)) {
            l();
        }
        b(262, 267, i2);
        this.c.o(eVar.a);
    }

    private void G(int i2) {
        int i3;
        boolean z;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
        g();
        b(iVar);
        while (true) {
            i3 = this.i.a;
            if (i3 != 46) {
                break;
            } else {
                c(iVar);
            }
        }
        if (i3 == 58) {
            c(iVar);
            z = true;
        } else {
            z = false;
        }
        a(iVar2, z, i2);
        this.c.a(iVar, iVar2);
        this.c.r(i2);
    }

    private void a() {
        try {
            this.g = this.l.read();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            this.g = -1;
        }
    }

    private void a(int i2, int i3, int i4, boolean z) {
        int i5;
        com.sijla.mla.a.a.c.a aVar = new com.sijla.mla.a.a.c.a();
        com.sijla.mla.a.a.c cVar = this.c;
        z(3);
        y(259);
        int a2 = z ? cVar.a(33, i2) : cVar.b();
        cVar.a(aVar, false);
        z(i4);
        cVar.q(i4);
        l();
        cVar.a();
        cVar.o(a2);
        if (z) {
            i5 = 32;
        } else {
            cVar.b(34, i2, 0, i4);
            cVar.r(i3);
            i2 += 2;
            i5 = 35;
        }
        cVar.d(cVar.a(i5, i2), a2 + 1);
        cVar.r(i3);
    }

    private void a(int i2, int i3, com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.a.c cVar = this.c;
        int i4 = i2 - i3;
        if (u(iVar.a)) {
            int i5 = i4 + 1;
            if (i5 < 0) {
                i5 = 0;
            }
            cVar.a(iVar, i5);
            if (i5 > 1) {
                cVar.q(i5 - 1);
                return;
            }
            return;
        }
        if (iVar.a != 0) {
            cVar.e(iVar);
        }
        if (i4 > 0) {
            short s2 = cVar.o;
            cVar.q(i4);
            cVar.b(s2, i4);
        }
    }

    private void a(int i2, com.sijla.mla.a.a.f.d dVar) {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.f.d[] dVarArr = this.d.c;
        com.sijla.mla.a.a.f.d dVar2 = dVarArr[i2];
        com.sijla.mla.a.a.a.a(dVar2.a.c((com.sijla.mla.a.r) dVar.a));
        short s2 = dVar2.d;
        if (s2 < dVar.d) {
            c("<goto " + dVar2.a + "> at line " + dVar2.c + " jumps into the scope of local '" + cVar.n(s2).a.g() + "'");
        }
        cVar.d(dVar2.b, dVar.b);
        java.lang.System.arraycopy(dVarArr, i2 + 1, dVarArr, i2, (this.d.d - i2) - 1);
        com.sijla.mla.a.a.f.b bVar = this.d;
        int i3 = bVar.d - 1;
        bVar.d = i3;
        dVarArr[i3] = null;
    }

    private void a(com.sijla.mla.a.a.c cVar, com.sijla.mla.a.a.c.a aVar) {
        cVar.c = this.c;
        cVar.d = this;
        this.c = cVar;
        cVar.f = 0;
        cVar.g = -1;
        cVar.h = new com.sijla.mla.a.a.e(-1);
        cVar.o = (short) 0;
        cVar.i = 0;
        cVar.j = 0;
        cVar.n = (short) 0;
        cVar.l = (short) 0;
        cVar.m = (short) 0;
        cVar.k = this.d.b;
        cVar.e = null;
        com.sijla.mla.a.w wVar = cVar.b;
        wVar.g = this.o;
        wVar.l = 2;
        cVar.a(aVar, false);
    }

    private void a(com.sijla.mla.a.a.e eVar) {
        int b2;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        com.sijla.mla.a.a.c.a aVar = new com.sijla.mla.a.a.c.a();
        g();
        b(iVar, 0);
        y(275);
        int i2 = this.i.a;
        if (i2 == 266 || i2 == 258) {
            this.c.k(iVar);
            this.c.a(aVar, false);
            B(iVar.c.a);
            n();
            if (b(false)) {
                this.c.a();
                return;
            }
            b2 = this.c.b();
        } else {
            this.c.j(iVar);
            this.c.a(aVar, false);
            b2 = iVar.d.a;
        }
        u();
        this.c.a();
        int i3 = this.i.a;
        if (i3 == 260 || i3 == 261) {
            com.sijla.mla.a.a.c cVar = this.c;
            cVar.a(eVar, cVar.b());
        }
        this.c.o(b2);
    }

    private void a(com.sijla.mla.a.a.f.a aVar) {
        com.sijla.mla.a.a.c cVar = this.c;
        short s2 = cVar.o;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
        if (this.i.a == 288) {
            cVar.a(aVar.c, 2147483645, "items in a constructor");
            a(iVar);
        } else {
            d(iVar);
        }
        aVar.c++;
        y(61);
        int i2 = cVar.i(iVar);
        b(iVar2, 0);
        cVar.b(10, aVar.b.b.d, i2, cVar.i(iVar2));
        cVar.o = s2;
    }

    private void a(com.sijla.mla.a.a.f.c cVar, int i2) {
        int i3;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        int i4 = cVar.b.a;
        int i5 = 9;
        a(7 <= i4 && i4 <= 9, "syntax error");
        if (w(44)) {
            com.sijla.mla.a.a.f.c cVar2 = new com.sijla.mla.a.a.f.c();
            cVar2.a = cVar;
            g(cVar2.b);
            com.sijla.mla.a.a.f.i iVar2 = cVar2.b;
            if (iVar2.a != 9) {
                com.sijla.mla.a.a.c cVar3 = this.c;
                short s2 = cVar3.o;
                com.sijla.mla.a.a.f.c cVar4 = cVar;
                boolean z = false;
                while (cVar4 != null) {
                    com.sijla.mla.a.a.f.i iVar3 = cVar4.b;
                    if (iVar3.a == i5) {
                        com.sijla.mla.a.a.f.i.a aVar = iVar3.b;
                        short s3 = aVar.c;
                        int i6 = iVar2.a;
                        if (s3 == i6 && aVar.b == iVar2.b.d) {
                            aVar.c = (short) 7;
                            aVar.b = s2;
                            z = true;
                        }
                        if (i6 == 7 && aVar.a == iVar2.b.d) {
                            aVar.a = s2;
                            z = true;
                        }
                    }
                    cVar4 = cVar4.a;
                    i5 = 9;
                }
                if (z) {
                    cVar3.b(iVar2.a == 7 ? 0 : 5, s2, iVar2.b.d, 0);
                    i3 = 1;
                    cVar3.q(1);
                    a(cVar2, i2 + i3);
                }
            }
            i3 = 1;
            a(cVar2, i2 + i3);
        } else {
            y(61);
            int f2 = f(iVar);
            if (f2 == i2) {
                this.c.c(iVar);
                this.c.a(cVar.b, iVar);
            } else {
                a(i2, f2, iVar);
                if (f2 > i2) {
                    com.sijla.mla.a.a.c cVar5 = this.c;
                    cVar5.o = (short) (cVar5.o - (f2 - i2));
                }
            }
        }
        iVar.a(6, this.c.o - 1);
        this.c.a(cVar.b, iVar);
    }

    private void a(com.sijla.mla.a.a.f.C0456f c0456f) {
        java.lang.String s1082368 = com.sijla.mla.L2.s1082368();
        int i2 = this.g;
        com.sijla.mla.a.a.a.a(o(i2));
        c();
        if (i2 == 48 && e(com.sijla.mla.L2.s1101216())) {
            s1082368 = com.sijla.mla.L2.s1093280();
        }
        while (true) {
            if (e(s1082368)) {
                e("+-");
            }
            if (!p(this.g) && this.g != 46) {
                r(0);
                a(new java.lang.String(this.m, 0, this.n), c0456f);
                return;
            }
            c();
        }
    }

    private void a(com.sijla.mla.a.a.f.C0456f c0456f, int i2) {
        java.lang.String str;
        int i3;
        c();
        if (b()) {
            d();
        }
        boolean z = false;
        while (!z) {
            int i4 = this.g;
            if (i4 == -1) {
                str = c0456f != null ? "unfinished long string" : "unfinished long comment";
                i3 = 286;
            } else if (i4 == 10 || i4 == 13) {
                r(10);
                d();
                if (c0456f == null) {
                    this.n = 0;
                }
            } else {
                i3 = 91;
                if (i4 != 91) {
                    if (i4 != 93) {
                        if (c0456f != null) {
                            c();
                        } else {
                            a();
                        }
                    } else if (e() == i2) {
                        c();
                        z = true;
                    }
                } else if (e() == i2) {
                    c();
                    if (i2 == 0) {
                        str = "nesting of [[...]] is deprecated";
                    }
                }
            }
            a(str, i3);
        }
        if (c0456f != null) {
            int i5 = i2 + 2;
            c0456f.b = this.k.a(com.sijla.mla.a.n.a(this.m, i5, this.n - (i5 * 2)));
        }
    }

    private void a(com.sijla.mla.a.a.f.i iVar) {
        a(iVar, h());
    }

    private void a(com.sijla.mla.a.a.f.i iVar, int i2) {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
        com.sijla.mla.a.a.f.g gVar = this.i;
        int i3 = gVar.a;
        int i4 = -1;
        if (i3 == 40) {
            g();
            if (this.i.a == 41) {
                iVar2.a = 0;
            } else {
                f(iVar2);
                cVar.a(iVar2, -1);
            }
            b(41, 40, i2);
        } else if (i3 == 123) {
            e(iVar2);
        } else if (i3 != 289) {
            b("function arguments expected");
            return;
        } else {
            a(iVar2, gVar.b.b);
            g();
        }
        com.sijla.mla.a.a.a.a(iVar.a == 6);
        int i5 = iVar.b.d;
        if (!u(iVar2.a)) {
            if (iVar2.a != 0) {
                cVar.e(iVar2);
            }
            i4 = cVar.o - (i5 + 1);
        }
        iVar.a(12, cVar.b(29, i5, i4 + 1, 2));
        cVar.r(i2);
        cVar.o = (short) (i5 + 1);
    }

    private void a(com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.n nVar) {
        iVar.a(4, this.c.a(nVar));
    }

    private void a(com.sijla.mla.a.a.f.i iVar, boolean z, int i2) {
        int i3;
        com.sijla.mla.a.a.c cVar = new com.sijla.mla.a.a.c();
        com.sijla.mla.a.a.c.a aVar = new com.sijla.mla.a.a.c.a();
        com.sijla.mla.a.a.c cVar2 = this.c;
        com.sijla.mla.a.w wVar = cVar2.b;
        com.sijla.mla.a.w[] wVarArr = wVar.c;
        if (wVarArr == null || cVar2.j >= wVarArr.length) {
            wVar.c = com.sijla.mla.a.a.a.a(wVarArr, java.lang.Math.max(1, cVar2.j << 1));
        }
        com.sijla.mla.a.w[] wVarArr2 = wVar.c;
        com.sijla.mla.a.a.c cVar3 = this.c;
        int i4 = cVar3.j;
        cVar3.j = i4 + 1;
        com.sijla.mla.a.w wVar2 = new com.sijla.mla.a.w();
        wVarArr2[i4] = wVar2;
        cVar.b = wVar2;
        wVar2.h = i2;
        a(cVar, aVar);
        y(40);
        if (z) {
            f(com.sijla.mla.L2.s1082711924());
            z(1);
        }
        com.sijla.mla.a.a.c cVar4 = this.c;
        com.sijla.mla.a.w wVar3 = cVar4.b;
        wVar3.k = 0;
        if (this.i.a != 41) {
            i3 = 0;
            do {
                int i5 = this.i.a;
                if (i5 == 280) {
                    g();
                    wVar3.k = 1;
                } else if (i5 != 288) {
                    b("<name> or " + d(java.lang.String.valueOf(com.sijla.mla.L2.s32815766())) + " expected");
                } else {
                    a(h());
                    i3++;
                }
                if (wVar3.k != 0) {
                    break;
                }
            } while (w(44));
        } else {
            i3 = 0;
        }
        z(i3);
        short s2 = cVar4.m;
        wVar3.j = s2;
        cVar4.q(s2);
        y(41);
        u();
        cVar.b.i = this.h;
        b(262, 265, i2);
        com.sijla.mla.a.a.c cVar5 = this.c.c;
        iVar.a(11, cVar5.b(37, 0, cVar5.j - 1));
        cVar5.e(iVar);
        k();
    }

    private void a(com.sijla.mla.a.n nVar) {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.w wVar = cVar.b;
        com.sijla.mla.b[] bVarArr = wVar.e;
        if (bVarArr == null || cVar.l + 1 > bVarArr.length) {
            wVar.e = com.sijla.mla.a.a.a.a(bVarArr, (cVar.l << 1) + 1);
        }
        wVar.e[cVar.l] = new com.sijla.mla.b(nVar, 0, 0);
        short s2 = cVar.l;
        cVar.l = (short) (s2 + 1);
        this.c.a(this.d.b + 1, 200, "local variables");
        com.sijla.mla.a.a.f.b bVar = this.d;
        com.sijla.mla.a.a.f.h[] hVarArr = bVar.a;
        if (hVarArr == null || bVar.b + 1 > hVarArr.length) {
            int max = java.lang.Math.max(1, bVar.b << 1);
            com.sijla.mla.a.a.f.h[] hVarArr2 = new com.sijla.mla.a.a.f.h[max];
            if (hVarArr != null) {
                java.lang.System.arraycopy(hVarArr, 0, hVarArr2, 0, java.lang.Math.min(hVarArr.length, max));
            }
            bVar.a = hVarArr2;
        }
        com.sijla.mla.a.a.f.b bVar2 = this.d;
        com.sijla.mla.a.a.f.h[] hVarArr3 = bVar2.a;
        int i2 = bVar2.b;
        bVar2.b = i2 + 1;
        hVarArr3[i2] = new com.sijla.mla.a.a.f.h(s2);
    }

    private void a(com.sijla.mla.a.n nVar, int i2) {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.f.b bVar = this.d;
        com.sijla.mla.a.a.f.d[] dVarArr = bVar.e;
        int i3 = bVar.f;
        for (int i4 = cVar.e.b; i4 < i3; i4++) {
            if (nVar.c((com.sijla.mla.a.r) dVarArr[i4].a)) {
                cVar.d.c("label '" + nVar + " already defined on line " + dVarArr[i4].c);
            }
        }
        y(285);
        com.sijla.mla.a.a.f.b bVar2 = this.d;
        com.sijla.mla.a.a.f.d[] a2 = com.sijla.mla.a.a.a.a(bVar2.e, bVar2.f + 1);
        bVar2.e = a2;
        com.sijla.mla.a.a.f.b bVar3 = this.d;
        int i5 = bVar3.f;
        bVar3.f = i5 + 1;
        int a3 = a(a2, i5, nVar, i2, this.c.f);
        n();
        if (b(false)) {
            this.d.e[a3].d = this.c.e.d;
        }
        a(this.d.e[a3]);
    }

    private void a(boolean z, java.lang.String str) {
        if (z) {
            return;
        }
        b(str);
    }

    public static boolean a(java.lang.String str) {
        return f.containsKey(str);
    }

    private static boolean a(java.lang.String str, com.sijla.mla.a.a.f.C0456f c0456f) {
        com.sijla.mla.a.m mVar;
        double d2;
        char c2;
        double d3;
        int i2;
        char c3;
        int i3;
        boolean z;
        if (str.indexOf(110) < 0 && str.indexOf(78) < 0) {
            if (str.indexOf(120) >= 0 || str.indexOf(88) >= 0) {
                char[] charArray = str.toCharArray();
                int i4 = 0;
                int i5 = 0;
                while (i5 < charArray.length && q(charArray[i5])) {
                    i5++;
                }
                if (i5 >= charArray.length || charArray[i5] != '-') {
                    d2 = 1.0d;
                } else {
                    i5++;
                    d2 = -1.0d;
                }
                if (i5 + 2 < charArray.length) {
                    int i6 = i5 + 1;
                    if (charArray[i5] == '0' && ((c2 = charArray[i6]) == 'x' || c2 == 'X')) {
                        int i7 = i6 + 1;
                        double d4 = 0.0d;
                        while (true) {
                            d3 = 16.0d;
                            if (i7 >= charArray.length || !p(charArray[i7])) {
                                break;
                            }
                            d4 = (d4 * 16.0d) + t(charArray[i7]);
                            i7++;
                        }
                        if (i7 >= charArray.length || charArray[i7] != '.') {
                            i2 = 0;
                        } else {
                            i7++;
                            i2 = 0;
                            while (i7 < charArray.length && p(charArray[i7])) {
                                d4 = (d4 * d3) + t(charArray[i7]);
                                i2 -= 4;
                                i7++;
                                d3 = 16.0d;
                            }
                        }
                        if (i7 < charArray.length && ((c3 = charArray[i7]) == 'p' || c3 == 'P')) {
                            int i8 = i7 + 1;
                            if (i8 >= charArray.length || charArray[i8] != '-') {
                                i3 = i8;
                                z = false;
                            } else {
                                i3 = i8 + 1;
                                z = true;
                            }
                            while (i3 < charArray.length && o(charArray[i3])) {
                                i4 = ((i4 * 10) + charArray[i3]) - 48;
                                i3++;
                            }
                            if (z) {
                                i4 = -i4;
                            }
                            i2 += i4;
                        }
                        mVar = com.sijla.mla.a.r.l(d2 * d4 * com.sijla.mla.a.b.k.a(i2));
                    }
                }
            } else {
                mVar = com.sijla.mla.a.r.l(java.lang.Double.parseDouble(str.trim()));
            }
            c0456f.a = mVar;
            return true;
        }
        mVar = com.sijla.mla.a.r.o;
        c0456f.a = mVar;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0165, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x016a, code lost:
    
        if (r14.g == 61) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x016c, code lost:
    
        return 61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x016d, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0172, code lost:
    
        return 281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0173, code lost:
    
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0176, code lost:
    
        r6 = r14.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0178, code lost:
    
        if (r6 == r1) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x017c, code lost:
    
        if (r6 == (-1)) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x021f, code lost:
    
        a("unfinished string", 286);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x017e, code lost:
    
        if (r6 == 10) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0180, code lost:
    
        if (r6 == 13) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x021a, code lost:
    
        a("unfinished string", 289);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0184, code lost:
    
        if (r6 == 92) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0187, code lost:
    
        a();
        r6 = r14.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x018c, code lost:
    
        if (r6 == (-1)) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x018e, code lost:
    
        if (r6 == 10) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0190, code lost:
    
        if (r6 == 13) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0212, code lost:
    
        r(10);
        d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0194, code lost:
    
        if (r6 == 102) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0198, code lost:
    
        if (r6 == 110) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x019c, code lost:
    
        if (r6 == 114) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x01a0, code lost:
    
        if (r6 == 116) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x01a4, code lost:
    
        if (r6 == 118) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x01a8, code lost:
    
        if (r6 == 120) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x01aa, code lost:
    
        if (r6 == 122) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x01e2, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x01eb, code lost:
    
        if (q(r14.g) == false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x01f1, code lost:
    
        if (b() == false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x01f3, code lost:
    
        d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x01ac, code lost:
    
        if (r6 == 97) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x01b0, code lost:
    
        if (r6 == 98) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x01dd, code lost:
    
        r6 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x020a, code lost:
    
        r(r6);
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x01b6, code lost:
    
        if (o(r6) != false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x01b9, code lost:
    
        r6 = 0;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x01bb, code lost:
    
        r6 = (r6 * 10) + (r14.g - 48);
        a();
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x01c6, code lost:
    
        if (r12 >= 3) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x01ce, code lost:
    
        if (o(r14.g) != false) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x01d2, code lost:
    
        if (r6 <= 255) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x01d4, code lost:
    
        a("escape sequence too large", 289);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x01d9, code lost:
    
        r(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x01e0, code lost:
    
        r6 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x01f7, code lost:
    
        r6 = f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x01fc, code lost:
    
        r6 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x01ff, code lost:
    
        r6 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0202, code lost:
    
        r6 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0205, code lost:
    
        r6 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0208, code lost:
    
        r6 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0224, code lost:
    
        c();
        r15.b = r14.k.a(com.sijla.mla.a.n.a(r14.m, 1, r14.n - 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0239, code lost:
    
        return 289;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b(com.sijla.mla.a.a.f.C0456f c0456f) {
        int e2;
        while (true) {
            this.n = 0;
            while (true) {
                int i2 = this.g;
                if (i2 == -1) {
                    return 286;
                }
                if (i2 == 10 || i2 == 13) {
                    d();
                } else if (i2 != 34 && i2 != 39) {
                    if (i2 == 91) {
                        int e3 = e();
                        if (e3 >= 0) {
                            a(c0456f, e3);
                            return 289;
                        }
                        if (e3 == -1) {
                            return 91;
                        }
                        a("invalid long string delimiter", 289);
                    } else {
                        if (i2 == 126) {
                            a();
                            if (this.g != 61) {
                                return 126;
                            }
                            a();
                            return 284;
                        }
                        if (i2 == 45) {
                            a();
                            if (this.g != 45) {
                                return 45;
                            }
                            a();
                            if (this.g == 91) {
                                e2 = e();
                                this.n = 0;
                                if (e2 >= 0) {
                                    break;
                                }
                            }
                            while (!b() && this.g != -1) {
                                a();
                            }
                        } else {
                            if (i2 == 46) {
                                c();
                                if (e(com.sijla.mla.L2.s34134())) {
                                    if (e(com.sijla.mla.L2.s34134())) {
                                        return 280;
                                    }
                                    return com.anythink.expressad.foundation.g.a.aT;
                                }
                                if (!o(this.g)) {
                                    return 46;
                                }
                                a(c0456f);
                                return com.anythink.expressad.foundation.g.a.aU;
                            }
                            switch (i2) {
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                    a(c0456f);
                                    return com.anythink.expressad.foundation.g.a.aU;
                                case 58:
                                    a();
                                    if (this.g != 58) {
                                        return 58;
                                    }
                                    a();
                                    return 285;
                                default:
                                    switch (i2) {
                                        case 60:
                                            a();
                                            if (this.g != 61) {
                                                return 60;
                                            }
                                            a();
                                            return 283;
                                        case 61:
                                            break;
                                        case 62:
                                            a();
                                            if (this.g != 61) {
                                                return 62;
                                            }
                                            a();
                                            return 282;
                                        default:
                                            if (q(i2)) {
                                                com.sijla.mla.a.a.a.a(!b());
                                                a();
                                                break;
                                            } else {
                                                if (o(this.g)) {
                                                    a(c0456f);
                                                    return com.anythink.expressad.foundation.g.a.aU;
                                                }
                                                int i3 = this.g;
                                                if (!((i3 >= 97 && i3 <= 122) || (i3 >= 65 && i3 <= 90)) && i3 != 95) {
                                                    a();
                                                    return i3;
                                                }
                                                while (true) {
                                                    c();
                                                    int i4 = this.g;
                                                    if (!((i4 >= 48 && i4 <= 57) || (i4 >= 97 && i4 <= 122) || ((i4 >= 65 && i4 <= 90) || i4 == 95)) && i4 != 95) {
                                                        com.sijla.mla.a.n a2 = this.k.a(new java.lang.String(this.m, 0, this.n));
                                                        if (f426s.containsKey(a2)) {
                                                            return ((java.lang.Integer) f426s.get(a2)).intValue();
                                                        }
                                                        c0456f.b = a2;
                                                        return com.anythink.expressad.foundation.g.a.aW;
                                                    }
                                                }
                                            }
                                            break;
                                    }
                            }
                        }
                    }
                }
            }
            a((com.sijla.mla.a.a.f.C0456f) null, e2);
        }
    }

    private int b(com.sijla.mla.a.a.f.i iVar, int i2) {
        i();
        com.sijla.mla.a.a.f.g gVar = this.i;
        int i3 = gVar.a;
        int i4 = 2;
        int i5 = i3 != 35 ? i3 != 45 ? i3 != 271 ? 3 : 1 : 0 : 2;
        if (i5 != 3) {
            int i6 = this.h;
            g();
            b(iVar, 8);
            this.c.a(i5, iVar, i6);
        } else if (i3 != 123) {
            if (i3 == 263) {
                iVar.a(3, 0);
            } else if (i3 == 265) {
                g();
                a(iVar, false, this.h);
            } else if (i3 == 270) {
                iVar.a(1, 0);
            } else if (i3 == 276) {
                iVar.a(2, 0);
            } else if (i3 == 280) {
                com.sijla.mla.a.a.c cVar = this.c;
                a(cVar.b.k != 0, "cannot use " + d(java.lang.String.valueOf(com.sijla.mla.L2.s32815766())) + " outside a vararg function");
                iVar.a(13, cVar.b(38, 0, 1, 0));
            } else if (i3 == 287) {
                iVar.a(5, 0);
                iVar.b.a(this.i.b.a);
            } else if (i3 != 289) {
                g(iVar);
            } else {
                a(iVar, gVar.b.b);
            }
            g();
        } else {
            e(iVar);
        }
        int i7 = this.i.a;
        if (i7 == 37) {
            i4 = 4;
        } else if (i7 == 45) {
            i4 = 1;
        } else if (i7 == 47) {
            i4 = 3;
        } else if (i7 == 60) {
            i4 = 9;
        } else if (i7 == 62) {
            i4 = 11;
        } else if (i7 == 94) {
            i4 = 5;
        } else if (i7 == 257) {
            i4 = 13;
        } else if (i7 == 272) {
            i4 = 14;
        } else if (i7 == 279) {
            i4 = 6;
        } else if (i7 != 42) {
            if (i7 != 43) {
                switch (i7) {
                    case 281:
                        i4 = 8;
                        break;
                    case 282:
                        i4 = 12;
                        break;
                    case 283:
                        i4 = 10;
                        break;
                    case 284:
                        i4 = 7;
                        break;
                    default:
                        i4 = 15;
                        break;
                }
            } else {
                i4 = 0;
            }
        }
        while (i4 != 15 && t[i4].a > i2) {
            com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
            int i8 = this.h;
            g();
            this.c.a(i4, iVar);
            int b2 = b(iVar2, t[i4].b);
            this.c.a(i4, iVar, iVar2, i8);
            i4 = b2;
        }
        j();
        return i4;
    }

    private void b(int i2, int i3, int i4) {
        if (w(i2)) {
            return;
        }
        if (i4 == this.h) {
            v(i2);
            return;
        }
        b(d(s(i2)) + " expected (to close " + d(s(i3)) + " at line " + i4 + ")");
    }

    private void b(com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.n h2 = h();
        com.sijla.mla.a.a.c cVar = this.c;
        boolean z = true;
        if (com.sijla.mla.a.a.c.a(cVar, h2, iVar, 1) == 0) {
            com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
            com.sijla.mla.a.a.c.a(cVar, this.p, iVar, 1);
            int i2 = iVar.a;
            if (i2 != 7 && i2 != 8) {
                z = false;
            }
            com.sijla.mla.a.a.a.a(z);
            a(iVar2, h2);
            cVar.c(iVar, iVar2);
        }
    }

    private boolean b() {
        int i2 = this.g;
        return i2 == 10 || i2 == 13;
    }

    private boolean b(boolean z) {
        int i2 = this.i.a;
        if (i2 == 277) {
            return z;
        }
        if (i2 != 286) {
            switch (i2) {
                case 260:
                case 261:
                case 262:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void c() {
        r(this.g);
        a();
    }

    private void c(com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
        cVar.g(iVar);
        g();
        a(iVar2);
        cVar.c(iVar, iVar2);
    }

    private static final java.lang.String d(java.lang.String str) {
        return "'" + str + "'";
    }

    private void d() {
        int i2 = this.g;
        com.sijla.mla.a.a.a.a(b());
        a();
        if (b() && this.g != i2) {
            a();
        }
        int i3 = this.h + 1;
        this.h = i3;
        if (i3 >= 2147483645) {
            b("chunk has too many lines");
        }
    }

    private void d(com.sijla.mla.a.a.f.i iVar) {
        g();
        b(iVar, 0);
        this.c.h(iVar);
        y(93);
    }

    private int e() {
        int i2;
        int i3 = this.g;
        int i4 = 0;
        com.sijla.mla.a.a.a.a(i3 == 91 || i3 == 93);
        c();
        while (true) {
            i2 = this.g;
            if (i2 != 61) {
                break;
            }
            c();
            i4++;
        }
        return i2 == i3 ? i4 : (-i4) - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (r11.j.a == 61) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.a.c cVar = this.c;
        int i2 = this.h;
        int b2 = cVar.b(11, 0, 0, 0);
        com.sijla.mla.a.a.f.a aVar = new com.sijla.mla.a.a.f.a();
        aVar.e = 0;
        aVar.c = 0;
        aVar.d = 0;
        aVar.b = iVar;
        iVar.a(11, b2);
        aVar.a.a(0, 0);
        cVar.e(iVar);
        y(123);
        while (true) {
            com.sijla.mla.a.a.a.a(aVar.a.a == 0 || aVar.e > 0);
            if (this.i.a == 125) {
                break;
            }
            cVar.a(aVar);
            int i3 = this.i.a;
            if (i3 != 91) {
                if (i3 == 288) {
                    com.sijla.mla.a.a.a.a(this.j.a == 286);
                    com.sijla.mla.a.a.f.g gVar = this.j;
                    gVar.a = b(gVar.b);
                }
                b(aVar.a, 0);
                this.c.a(aVar.d, 2147483645, "items in a constructor");
                aVar.d++;
                aVar.e++;
                if (w(44) && !w(59)) {
                    break;
                }
            }
            a(aVar);
            if (w(44)) {
            }
        }
        b(125, 123, i2);
        cVar.b(aVar);
        com.sijla.mla.a.a.d dVar = new com.sijla.mla.a.a.d(cVar.b.b, b2);
        com.sijla.mla.a.a.a.b(dVar, A(aVar.d));
        com.sijla.mla.a.a.a.c(dVar, A(aVar.c));
    }

    private boolean e(java.lang.String str) {
        if (str.indexOf(this.g) < 0) {
            return false;
        }
        c();
        return true;
    }

    private int f() {
        a();
        int i2 = this.g;
        a();
        int i3 = this.g;
        if (!p(i2) || !p(i3)) {
            a("hexadecimal digit expected 'x" + ((char) i2) + ((char) i3), 289);
        }
        return (t(i2) << 4) + t(i3);
    }

    private int f(com.sijla.mla.a.a.f.i iVar) {
        b(iVar, 0);
        int i2 = 1;
        while (w(44)) {
            this.c.e(iVar);
            b(iVar, 0);
            i2++;
        }
        return i2;
    }

    private void f(java.lang.String str) {
        a(this.k.a(str));
    }

    private void g() {
        this.b = this.h;
        com.sijla.mla.a.a.f.g gVar = this.j;
        int i2 = gVar.a;
        if (i2 == 286) {
            com.sijla.mla.a.a.f.g gVar2 = this.i;
            gVar2.a = b(gVar2.b);
            return;
        }
        com.sijla.mla.a.a.f.g gVar3 = this.i;
        gVar3.a = i2;
        com.sijla.mla.a.a.f.C0456f c0456f = gVar3.b;
        com.sijla.mla.a.a.f.C0456f c0456f2 = gVar.b;
        c0456f.a = c0456f2.a;
        c0456f.b = c0456f2.b;
        gVar.a = 286;
    }

    private void g(com.sijla.mla.a.a.f.i iVar) {
        int i2 = this.h;
        int i3 = this.i.a;
        if (i3 == 40) {
            g();
            b(iVar, 0);
            b(41, 40, i2);
            this.c.d(iVar);
        } else if (i3 != 288) {
            b("unexpected symbol " + this.i.a + " (" + ((char) this.i.a) + ")");
        } else {
            b(iVar);
        }
        while (true) {
            int i4 = this.i.a;
            if (i4 != 40) {
                if (i4 == 46) {
                    c(iVar);
                } else if (i4 == 58) {
                    com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
                    g();
                    a(iVar2);
                    this.c.b(iVar, iVar2);
                    a(iVar, i2);
                } else if (i4 == 91) {
                    com.sijla.mla.a.a.f.i iVar3 = new com.sijla.mla.a.a.f.i();
                    this.c.g(iVar);
                    d(iVar3);
                    this.c.c(iVar, iVar3);
                } else if (i4 != 123 && i4 != 289) {
                    return;
                }
            }
            this.c.e(iVar);
            a(iVar, i2);
        }
    }

    private com.sijla.mla.a.n h() {
        x(com.anythink.expressad.foundation.g.a.aW);
        com.sijla.mla.a.n nVar = this.i.b.b;
        g();
        return nVar;
    }

    private void i() {
        com.sijla.mla.a.a.g.a aVar = this.k;
        int i2 = aVar.a + 1;
        aVar.a = i2;
        if (i2 > 200) {
            a("chunk has too many syntax levels", 0);
        }
    }

    private void j() {
        com.sijla.mla.a.a.g.a aVar = this.k;
        aVar.a--;
    }

    private void k() {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.w wVar = cVar.b;
        cVar.c(0, 0);
        cVar.a();
        wVar.b = com.sijla.mla.a.a.a.a(wVar.b, cVar.f);
        wVar.d = com.sijla.mla.a.a.a.a(wVar.d, cVar.f);
        wVar.a = com.sijla.mla.a.a.a.a(wVar.a, cVar.i);
        wVar.c = com.sijla.mla.a.a.a.a(wVar.c, cVar.j);
        wVar.e = com.sijla.mla.a.a.a.a(wVar.e, cVar.l);
        wVar.f = com.sijla.mla.a.a.a.a(wVar.f, cVar.n);
        com.sijla.mla.a.a.a.a(cVar.e == null);
        this.c = cVar.c;
    }

    private void l() {
        com.sijla.mla.a.a.c cVar = this.c;
        cVar.a(new com.sijla.mla.a.a.c.a(), false);
        u();
        cVar.a();
    }

    private int m() {
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        b(iVar, 0);
        if (iVar.a == 1) {
            iVar.a = 3;
        }
        this.c.j(iVar);
        return iVar.d.a;
    }

    private void n() {
        while (true) {
            int i2 = this.i.a;
            if (i2 != 59 && i2 != 285) {
                return;
            } else {
                t();
            }
        }
    }

    private int o() {
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        b(iVar, 0);
        int i2 = iVar.a;
        this.c.e(iVar);
        return i2;
    }

    private static boolean o(int i2) {
        return i2 >= 48 && i2 <= 57;
    }

    private void p() {
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        com.sijla.mla.a.a.c cVar = this.c;
        a(h());
        z(1);
        a(iVar, false, this.h);
        cVar.n(cVar.m - 1).b = cVar.f;
    }

    private static boolean p(int i2) {
        if (i2 >= 48 && i2 <= 57) {
            return true;
        }
        if (i2 < 97 || i2 > 102) {
            return i2 >= 65 && i2 <= 70;
        }
        return true;
    }

    private void q() {
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        int i2 = 0;
        int i3 = 0;
        do {
            a(h());
            i3++;
        } while (w(44));
        if (w(61)) {
            i2 = f(iVar);
        } else {
            iVar.a = 0;
        }
        a(i3, i2, iVar);
        z(i3);
    }

    private static boolean q(int i2) {
        return i2 <= 32;
    }

    private void r() {
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.f.c cVar2 = new com.sijla.mla.a.a.f.c();
        g(cVar2.b);
        int i2 = this.i.a;
        if (i2 == 61 || i2 == 44) {
            cVar2.a = null;
            a(cVar2, 1);
        } else {
            a(cVar2.b.a == 12, "syntax error");
            com.sijla.mla.a.a.a.c(cVar.a(cVar2.b), 1);
        }
    }

    private void r(int i2) {
        char[] cArr = this.m;
        if (cArr == null || this.n + 1 > cArr.length) {
            this.m = com.sijla.mla.a.a.a.a(cArr, (this.n << 1) + 1);
        }
        char[] cArr2 = this.m;
        int i3 = this.n;
        this.n = i3 + 1;
        cArr2[i3] = (char) i2;
    }

    private static java.lang.String s(int i2) {
        if (i2 >= 257) {
            return r[i2 - 257];
        }
        if (!(i2 < 32)) {
            return java.lang.String.valueOf((char) i2);
        }
        return "char(" + i2 + ")";
    }

    private void s() {
        int i2;
        com.sijla.mla.a.a.c cVar = this.c;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        int i3 = 0;
        if (b(true) || this.i.a == 59) {
            i2 = 0;
        } else {
            i2 = f(iVar);
            if (u(iVar.a)) {
                cVar.a(iVar, -1);
                if (iVar.a == 12 && i2 == 1) {
                    com.sijla.mla.a.a.d a2 = cVar.a(iVar);
                    a2.a((a2.a() & (-64)) | 30);
                    com.sijla.mla.a.a.a.a(com.sijla.mla.a.e.b(cVar.b(iVar)) == cVar.m);
                }
                i3 = cVar.m;
                i2 = -1;
            } else if (i2 == 1) {
                i3 = cVar.f(iVar);
            } else {
                cVar.e(iVar);
                short s2 = cVar.m;
                com.sijla.mla.a.a.a.a(i2 == cVar.o - s2);
                i3 = s2;
            }
        }
        cVar.c(i3, i2);
        w(59);
    }

    private static int t(int i2) {
        return i2 <= 57 ? i2 - 48 : i2 <= 70 ? (i2 + 10) - 65 : (i2 + 10) - 97;
    }

    private void t() {
        int i2 = this.h;
        i();
        int i3 = this.i.a;
        if (i3 == 59) {
            g();
        } else if (i3 == 269) {
            g();
            if (w(265)) {
                p();
            } else {
                q();
            }
        } else if (i3 == 278) {
            C(i2);
        } else if (i3 != 285) {
            if (i3 != 258) {
                if (i3 == 259) {
                    g();
                    l();
                    b(262, 259, i2);
                } else if (i3 == 273) {
                    D(i2);
                } else if (i3 != 274) {
                    switch (i3) {
                        case 264:
                            E(i2);
                            break;
                        case 265:
                            G(i2);
                            break;
                        case 266:
                            break;
                        case 267:
                            F(i2);
                            break;
                        default:
                            r();
                            break;
                    }
                } else {
                    g();
                    s();
                }
            }
            B(this.c.b());
        } else {
            g();
            a(h(), i2);
        }
        com.sijla.mla.a.a.c cVar = this.c;
        int i4 = cVar.b.l;
        short s2 = cVar.o;
        com.sijla.mla.a.a.a.a(i4 >= s2 && s2 >= cVar.m);
        com.sijla.mla.a.a.c cVar2 = this.c;
        cVar2.o = cVar2.m;
        j();
    }

    private void u() {
        while (!b(true)) {
            int i2 = this.i.a;
            t();
            if (i2 == 274) {
                return;
            }
        }
    }

    private static boolean u(int i2) {
        return i2 == 12 || i2 == 13;
    }

    private void v(int i2) {
        b(d(s(i2)) + " expected");
    }

    private boolean w(int i2) {
        if (this.i.a != i2) {
            return false;
        }
        g();
        return true;
    }

    private void x(int i2) {
        if (this.i.a != i2) {
            v(i2);
        }
    }

    private void y(int i2) {
        x(i2);
        g();
    }

    private void z(int i2) {
        com.sijla.mla.a.a.c cVar = this.c;
        cVar.m = (short) (cVar.m + i2);
        while (i2 > 0) {
            cVar.n(cVar.m - i2).b = cVar.f;
            i2--;
        }
    }

    public final int a(com.sijla.mla.a.a.f.d[] dVarArr, int i2, com.sijla.mla.a.n nVar, int i3, int i4) {
        dVarArr[i2] = new com.sijla.mla.a.a.f.d(nVar, i4, i3, this.c.m);
        return i2;
    }

    public final void a(com.sijla.mla.a.a.c cVar) {
        a(cVar, new com.sijla.mla.a.a.c.a());
        this.c.b.k = 1;
        com.sijla.mla.a.a.f.i iVar = new com.sijla.mla.a.a.f.i();
        iVar.a(7, 0);
        this.c.a(this.p, iVar);
        g();
        u();
        x(286);
        k();
    }

    public final void a(com.sijla.mla.a.a.f.d dVar) {
        com.sijla.mla.a.a.f.d[] dVarArr = this.d.c;
        int i2 = this.c.e.c;
        while (i2 < this.d.d) {
            if (dVarArr[i2].a.c((com.sijla.mla.a.r) dVar.a)) {
                a(i2, dVar);
            } else {
                i2++;
            }
        }
    }

    public final void a(com.sijla.mla.a.a.g.a aVar, int i2, java.io.InputStream inputStream, com.sijla.mla.a.n nVar) {
        this.q = (byte) 46;
        this.k = aVar;
        this.j.a = 286;
        this.l = inputStream;
        this.c = null;
        this.h = 1;
        this.b = 1;
        this.o = nVar;
        this.p = com.sijla.mla.a.r.r;
        this.n = 0;
        this.g = i2;
        if (i2 == 35) {
            while (!b() && this.g != -1) {
                a();
            }
        }
    }

    public final void a(java.lang.String str, int i2) {
        java.lang.String concat;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String g2 = this.o.g();
        if (g2.startsWith(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)) {
            str3 = g2.substring(1);
        } else {
            if (g2.startsWith("@")) {
                concat = g2.substring(1);
                str2 = "";
            } else {
                concat = "[string \"".concat(g2);
                str2 = "\"]";
            }
            if (concat.length() + str2.length() > 80) {
                concat = concat.substring(0, (80 - str2.length()) - 3) + com.sijla.mla.L2.s32815766();
            }
            str3 = concat + str2;
        }
        if (i2 != 0) {
            switch (i2) {
                case com.anythink.expressad.foundation.g.a.aU /* 287 */:
                case com.anythink.expressad.foundation.g.a.aW /* 288 */:
                case 289:
                    new java.lang.String(this.m, 0, this.n);
                    break;
                default:
                    s(i2);
                    break;
            }
        }
        throw new com.sijla.mla.a.i(str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.h + ": " + str);
    }

    public final void b(java.lang.String str) {
        a(str, this.i.a);
    }

    public final void c(java.lang.String str) {
        this.i.a = 0;
        b(str);
    }

    public final boolean n(int i2) {
        com.sijla.mla.a.a.c.a aVar = this.c.e;
        com.sijla.mla.a.a.f.b bVar = this.d;
        com.sijla.mla.a.a.f.d dVar = bVar.c[i2];
        for (int i3 = aVar.b; i3 < bVar.f; i3++) {
            com.sijla.mla.a.a.f.d dVar2 = bVar.e[i3];
            if (dVar2.a.c((com.sijla.mla.a.r) dVar.a)) {
                short s2 = dVar.d;
                short s3 = dVar2.d;
                if (s2 > s3 && (aVar.e || bVar.f > aVar.b)) {
                    this.c.e(dVar.b, s3);
                }
                a(i2, dVar2);
                return true;
            }
        }
        return false;
    }
}
