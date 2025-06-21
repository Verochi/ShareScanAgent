package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public abstract class g extends com.sijla.mla.a.b.s {
    com.sijla.mla.a.o a;
    protected com.sijla.mla.a.b b;
    private com.sijla.mla.a.b.g.a f = null;
    private com.sijla.mla.a.b.g.a g = null;
    private com.sijla.mla.a.b.g.a h = null;
    private static final com.sijla.mla.a.r i = com.sijla.mla.a.n.c(com.sijla.mla.L2.s782048964());
    private static final com.sijla.mla.a.r j = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1526473941());
    private static final com.sijla.mla.a.r L = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1526173086());
    private static final com.sijla.mla.a.r M = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1070825284());
    private static final com.sijla.mla.a.r N = com.sijla.mla.a.n.c("closed file");
    private static java.lang.String[] O = {com.sijla.mla.L2.s1247166516(), com.sijla.mla.L2.s1161100224(), com.sijla.mla.L2.s1073512390(), com.sijla.mla.L2.s992317531(), com.sijla.mla.L2.s1079339062(), com.sijla.mla.L2.s1980105505(), com.sijla.mla.L2.s872200374(), com.sijla.mla.L2.s1081777770(), com.sijla.mla.L2.s236178833(), com.sijla.mla.L2.s1084235078(), com.sijla.mla.L2.s669220155()};
    private static java.lang.String[] P = {com.sijla.mla.L2.s1247166516(), com.sijla.mla.L2.s1161100224(), com.sijla.mla.L2.s992317531(), com.sijla.mla.L2.s1081777770(), com.sijla.mla.L2.s1082705352(), com.sijla.mla.L2.s112366725(), com.sijla.mla.L2.s669220155()};

    public abstract class a extends com.sijla.mla.a.r {
        public a() {
        }

        public abstract int a(byte[] bArr, int i);

        @Override // com.sijla.mla.a.r
        public final com.sijla.mla.a.r a(com.sijla.mla.a.r rVar) {
            return com.sijla.mla.a.b.g.this.a.a(rVar);
        }

        @Override // com.sijla.mla.a.r
        public final int a_() {
            return 7;
        }

        public abstract void ae();

        public abstract boolean af();

        public abstract void ag();

        public abstract boolean ah();

        public abstract int ai();

        public abstract int aj();

        public abstract int ak();

        public abstract int b(java.lang.String str, int i);

        @Override // com.sijla.mla.a.r
        public final java.lang.String c() {
            return com.sijla.mla.L2.s2042902805();
        }

        public abstract void c(java.lang.String str);

        public abstract void e(com.sijla.mla.a.n nVar);

        @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
        public java.lang.String g() {
            return "file: " + java.lang.Integer.toHexString(hashCode());
        }
    }

    public static final class b extends com.sijla.mla.a.b.t {
        public com.sijla.mla.a.b.g a;
        private com.sijla.mla.a.b.g.a b;

        public b() {
        }

        public b(com.sijla.mla.a.b.g.a aVar, java.lang.String str, com.sijla.mla.a.b.g gVar) {
            this.b = aVar;
            this.e = str;
            this.d = 19;
            this.a = gVar;
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            try {
                switch (this.d) {
                    case 0:
                        return this.a.t(yVar.h());
                    case 1:
                        return this.a.ai();
                    case 2:
                        return this.a.u(yVar.h());
                    case 3:
                        return this.a.c(1 <= yVar.e() ? yVar.v(1) : null);
                    case 4:
                        return this.a.f(yVar.v(1), yVar.b(2, com.sijla.mla.L2.s36242()));
                    case 5:
                        return this.a.v(yVar.h());
                    case 6:
                        return this.a.e(yVar.v(1), yVar.b(2, com.sijla.mla.L2.s36242()));
                    case 7:
                        return this.a.c(yVar);
                    case 8:
                        return this.a.aj();
                    case 9:
                        return com.sijla.mla.a.b.g.z(yVar.h());
                    case 10:
                        return this.a.d(yVar);
                    case 11:
                        return com.sijla.mla.a.b.g.A(yVar.h());
                    case 12:
                        return com.sijla.mla.a.b.g.B(yVar.h());
                    case 13:
                        return this.a.C(yVar.h());
                    case 14:
                        return com.sijla.mla.a.b.g.b(yVar.h(), yVar.b_(2));
                    case 15:
                        return com.sijla.mla.a.b.g.a(yVar.h(), yVar.b(2, com.sijla.mla.L2.s34465028()), yVar.c(3, 0));
                    case 16:
                        com.sijla.mla.a.r h = yVar.h();
                        java.lang.String v = yVar.v(2);
                        yVar.c(3, 1024);
                        return com.sijla.mla.a.b.g.a(h, v);
                    case 17:
                        return com.sijla.mla.a.b.g.c(yVar.h(), yVar.b_(2));
                    case 18:
                        return this.a.D(yVar.c(2));
                    case 19:
                        return com.sijla.mla.a.b.g.E(this.b);
                    default:
                        return com.sijla.mla.a.r.n;
                }
            } catch (java.io.IOException e) {
                return com.sijla.mla.a.b.g.a(e);
            }
        }
    }

    public static com.sijla.mla.a.y A(com.sijla.mla.a.r rVar) {
        return a(F(rVar));
    }

    public static com.sijla.mla.a.y B(com.sijla.mla.a.r rVar) {
        F(rVar).ae();
        return com.sijla.mla.a.r.l;
    }

    public static com.sijla.mla.a.y E(com.sijla.mla.a.r rVar) {
        return a(F(rVar), true);
    }

    private static com.sijla.mla.a.b.g.a F(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.b.g.a G = G(rVar);
        if (G == null) {
            com.sijla.mla.a.r.a(1, com.sijla.mla.L2.s1070825284());
        }
        c(G);
        return G;
    }

    private static com.sijla.mla.a.b.g.a G(com.sijla.mla.a.r rVar) {
        if (rVar instanceof com.sijla.mla.a.b.g.a) {
            return (com.sijla.mla.a.b.g.a) rVar;
        }
        return null;
    }

    private com.sijla.mla.a.b.g.a a(int i2, java.lang.String str, java.lang.String str2) {
        try {
            return b(i2, str, str2);
        } catch (java.lang.Exception e) {
            com.sijla.mla.a.r.d("io error: " + e.getMessage());
            return null;
        }
    }

    private static com.sijla.mla.a.r a(com.sijla.mla.a.b.g.a aVar, int i2) {
        byte[] bArr = new byte[i2];
        int a2 = aVar.a(bArr, i2);
        return a2 < 0 ? com.sijla.mla.a.r.k : com.sijla.mla.a.n.b(bArr, 0, a2);
    }

    private static com.sijla.mla.a.r a(com.sijla.mla.a.b.g.a aVar, boolean z) {
        int i2;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            if (!z) {
                while (true) {
                    i2 = aVar.ak();
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(i2);
                }
            } else {
                while (true) {
                    i2 = aVar.ak();
                    if (i2 <= 0 || i2 == 10) {
                        break;
                    }
                    if (i2 != 13) {
                        byteArrayOutputStream.write(i2);
                    }
                }
            }
        } catch (java.io.EOFException unused) {
            i2 = -1;
        }
        return (i2 >= 0 || byteArrayOutputStream.size() != 0) ? com.sijla.mla.a.n.b(byteArrayOutputStream.toByteArray()) : com.sijla.mla.a.r.k;
    }

    private static com.sijla.mla.a.y a(com.sijla.mla.a.b.g.a aVar) {
        if (aVar.af()) {
            return i("cannot close standard file");
        }
        aVar.ag();
        return com.sijla.mla.a.r.l;
    }

    private static com.sijla.mla.a.y a(com.sijla.mla.a.b.g.a aVar, com.sijla.mla.a.y yVar) {
        int e = yVar.e();
        for (int i2 = 1; i2 <= e; i2++) {
            aVar.e(yVar.w(i2));
        }
        return aVar;
    }

    public static com.sijla.mla.a.y a(com.sijla.mla.a.r rVar, java.lang.String str) {
        F(rVar).c(str);
        return com.sijla.mla.a.r.l;
    }

    public static com.sijla.mla.a.y a(com.sijla.mla.a.r rVar, java.lang.String str, int i2) {
        return com.sijla.mla.a.k.c_(F(rVar).b(str, i2));
    }

    public static /* synthetic */ com.sijla.mla.a.y a(java.lang.Exception exc) {
        java.lang.String message = exc.getMessage();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("io error: ");
        if (message == null) {
            message = exc.toString();
        }
        sb.append(message);
        return i(sb.toString());
    }

    private static void a(com.sijla.mla.a.b.g.a aVar, java.lang.String str, java.io.ByteArrayOutputStream byteArrayOutputStream) {
        while (true) {
            int aj = aVar.aj();
            if (str.indexOf(aj) < 0) {
                return;
            }
            aVar.ak();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.write(aj);
            }
        }
    }

    private void a(com.sijla.mla.a.o oVar) {
        for (com.sijla.mla.a.r rVar : oVar.g_()) {
            ((com.sijla.mla.a.b.g.b) oVar.a(rVar)).a = this;
        }
    }

    private com.sijla.mla.a.b.g.a ak() {
        com.sijla.mla.a.b.g.a aVar = this.f;
        if (aVar != null) {
            return aVar;
        }
        com.sijla.mla.a.b.g.a a2 = a(0, com.sijla.mla.L2.s34103(), com.sijla.mla.L2.s36242());
        this.f = a2;
        return a2;
    }

    private com.sijla.mla.a.b.g.a al() {
        com.sijla.mla.a.b.g.a aVar = this.g;
        if (aVar != null) {
            return aVar;
        }
        com.sijla.mla.a.b.g.a a2 = a(1, com.sijla.mla.L2.s34103(), com.sijla.mla.L2.s36397());
        this.g = a2;
        return a2;
    }

    private com.sijla.mla.a.b.g.a b(int i2, java.lang.String str, java.lang.String str2) {
        if (i2 == 0) {
            return ae();
        }
        if (i2 == 1) {
            return af();
        }
        if (i2 == 2) {
            return ag();
        }
        boolean startsWith = str2.startsWith(com.sijla.mla.L2.s36242());
        boolean startsWith2 = str2.startsWith(com.sijla.mla.L2.s35715());
        str2.indexOf("+");
        str2.endsWith(com.sijla.mla.L2.s35746());
        return a(str, startsWith, startsWith2);
    }

    private com.sijla.mla.a.y b(com.sijla.mla.a.b.g.a aVar) {
        try {
            return new com.sijla.mla.a.b.g.b(aVar, com.sijla.mla.L2.s987949755(), this);
        } catch (java.lang.Exception e) {
            return com.sijla.mla.a.r.d("lines: ".concat(java.lang.String.valueOf(e)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        if (r3 != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        return com.sijla.mla.a.r.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        return com.sijla.mla.a.r.a(r1, 0, r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.sijla.mla.a.y b(com.sijla.mla.a.b.g.a aVar, com.sijla.mla.a.y yVar) {
        int i2;
        com.sijla.mla.a.r a2;
        int e = yVar.e();
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[e];
        int i3 = 0;
        while (true) {
            if (i3 >= e) {
                break;
            }
            i2 = i3 + 1;
            com.sijla.mla.a.r c = yVar.c(i2);
            int a_ = c.a_();
            if (a_ == 3) {
                a2 = a(aVar, c.p());
            } else if (a_ == 4) {
                com.sijla.mla.a.n C = c.C();
                if (C.d != 2) {
                    break;
                }
                byte[] bArr = C.b;
                int i4 = C.c;
                if (bArr[i4] != 42) {
                    break;
                }
                byte b2 = bArr[i4 + 1];
                if (b2 == 97) {
                    a2 = d(aVar);
                } else if (b2 == 108) {
                    a2 = a(aVar, true);
                } else {
                    if (b2 != 110) {
                        break;
                    }
                    a2 = e(aVar);
                }
            } else {
                break;
            }
            rVarArr[i3] = a2;
            if (a2.J()) {
                i3 = i2;
                break;
            }
            i3 = i2;
        }
        return com.sijla.mla.a.r.a(i2, "(invalid format)");
    }

    public static com.sijla.mla.a.y b(com.sijla.mla.a.r rVar, com.sijla.mla.a.y yVar) {
        return b(F(rVar), yVar);
    }

    private static com.sijla.mla.a.b.g.a c(com.sijla.mla.a.b.g.a aVar) {
        if (aVar.ah()) {
            com.sijla.mla.a.r.d("attempt to use a closed file");
        }
        return aVar;
    }

    public static com.sijla.mla.a.y c(com.sijla.mla.a.r rVar, com.sijla.mla.a.y yVar) {
        return a(F(rVar), yVar);
    }

    private static com.sijla.mla.a.r d(com.sijla.mla.a.b.g.a aVar) {
        int ai = aVar.ai();
        return ai >= 0 ? a(aVar, ai) : a(aVar, false);
    }

    private static com.sijla.mla.a.r e(com.sijla.mla.a.b.g.a aVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        a(aVar, " \t\r\n", (java.io.ByteArrayOutputStream) null);
        a(aVar, "-+", byteArrayOutputStream);
        a(aVar, com.sijla.mla.L2.s1980330331(), byteArrayOutputStream);
        a(aVar, com.sijla.mla.L2.s34134(), byteArrayOutputStream);
        a(aVar, com.sijla.mla.L2.s1980330331(), byteArrayOutputStream);
        java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        return byteArrayOutputStream2.length() > 0 ? com.sijla.mla.a.h.a(java.lang.Double.parseDouble(byteArrayOutputStream2)) : com.sijla.mla.a.r.k;
    }

    private static com.sijla.mla.a.y i(java.lang.String str) {
        return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(str));
    }

    public static com.sijla.mla.a.y z(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.b.g.a G = G(rVar);
        return G != null ? G.ah() ? N : M : com.sijla.mla.a.r.k;
    }

    public final com.sijla.mla.a.y C(com.sijla.mla.a.r rVar) {
        return b(F(rVar));
    }

    public final com.sijla.mla.a.y D(com.sijla.mla.a.r rVar) {
        if (rVar.equals(j)) {
            return al();
        }
        if (rVar.equals(i)) {
            return ak();
        }
        if (!rVar.equals(L)) {
            return com.sijla.mla.a.r.k;
        }
        com.sijla.mla.a.b.g.a aVar = this.h;
        if (aVar != null) {
            return aVar;
        }
        com.sijla.mla.a.b.g.a a2 = a(2, com.sijla.mla.L2.s34103(), com.sijla.mla.L2.s36397());
        this.h = a2;
        return a2;
    }

    public abstract com.sijla.mla.a.b.g.a a(java.lang.String str, boolean z, boolean z2);

    public abstract com.sijla.mla.a.b.g.a ae();

    public abstract com.sijla.mla.a.b.g.a af();

    public abstract com.sijla.mla.a.b.g.a ag();

    public abstract com.sijla.mla.a.b.g.a ah();

    public final com.sijla.mla.a.y ai() {
        c(al());
        this.g.ae();
        return com.sijla.mla.a.r.l;
    }

    public final com.sijla.mla.a.y aj() {
        return ah();
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        this.b = rVar2.a();
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        com.sijla.mla.a.b.j.a(oVar, com.sijla.mla.a.b.g.b.class, O);
        com.sijla.mla.a.o oVar2 = new com.sijla.mla.a.o();
        this.a = oVar2;
        com.sijla.mla.a.b.j.a(oVar2, com.sijla.mla.a.b.g.b.class, P, 11);
        com.sijla.mla.a.o oVar3 = new com.sijla.mla.a.o();
        com.sijla.mla.a.b.j.a(oVar3, com.sijla.mla.a.b.g.b.class, new java.lang.String[]{com.sijla.mla.L2.s1736420462()}, 18);
        oVar.p(oVar3);
        a(oVar);
        a(this.a);
        a(oVar3);
        rVar2.a(com.sijla.mla.L2.s1117274(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s1117274(), oVar);
        return oVar;
    }

    public final com.sijla.mla.a.y c(com.sijla.mla.a.y yVar) {
        c(ak());
        return b(this.f, yVar);
    }

    public final com.sijla.mla.a.y c(java.lang.String str) {
        com.sijla.mla.a.b.g.a ak = str == null ? ak() : a(3, str, com.sijla.mla.L2.s36242());
        this.f = ak;
        c(ak);
        return b(this.f);
    }

    public abstract com.sijla.mla.a.b.g.a d(java.lang.String str, java.lang.String str2);

    public final com.sijla.mla.a.y d(com.sijla.mla.a.y yVar) {
        c(al());
        return a(this.g, yVar);
    }

    public final com.sijla.mla.a.y e(java.lang.String str, java.lang.String str2) {
        return d(str, str2);
    }

    public final com.sijla.mla.a.y f(java.lang.String str, java.lang.String str2) {
        return b(3, str, str2);
    }

    public final com.sijla.mla.a.y t(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.b.g.a al = rVar.J() ? al() : F(rVar);
        c(al);
        return a(al);
    }

    public final com.sijla.mla.a.y u(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.b.g.a ak = rVar.J() ? ak() : rVar.v() ? a(3, rVar.B(), com.sijla.mla.L2.s36242()) : F(rVar);
        this.f = ak;
        return ak;
    }

    public final com.sijla.mla.a.y v(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.b.g.a al = rVar.J() ? al() : rVar.v() ? a(3, rVar.B(), com.sijla.mla.L2.s36397()) : F(rVar);
        this.g = al;
        return al;
    }
}
