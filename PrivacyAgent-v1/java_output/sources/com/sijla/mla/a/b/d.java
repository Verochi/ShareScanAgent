package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class d extends com.sijla.mla.a.b.s {
    private static final com.sijla.mla.a.n L;
    private static final com.sijla.mla.a.n M;
    private static final com.sijla.mla.a.n N;
    private static final com.sijla.mla.a.n O;
    private static final com.sijla.mla.a.n P;
    private static final com.sijla.mla.a.n Q;
    private static final com.sijla.mla.a.n R;
    private static final com.sijla.mla.a.n S;
    private static final com.sijla.mla.a.n T;
    private static final com.sijla.mla.a.n U;
    private static final com.sijla.mla.a.n V;
    private static final com.sijla.mla.a.n W;
    private static final com.sijla.mla.a.n X;
    private static final com.sijla.mla.a.n Y;
    private static final com.sijla.mla.a.n Z;
    public static boolean a;
    private static final com.sijla.mla.a.n f;
    private static final com.sijla.mla.a.n g;
    private static final com.sijla.mla.a.n h;
    private static final com.sijla.mla.a.n i;
    private static final com.sijla.mla.a.n j;
    com.sijla.mla.a.b b;

    public static class a {
        com.sijla.mla.a.j a;
        int b;
        int c;
        com.sijla.mla.a.y d;
        com.sijla.mla.a.r[] e;
        com.sijla.mla.a.b.d.a f;

        public static /* synthetic */ int a(com.sijla.mla.a.b.d.a aVar) {
            if (aVar.a.k()) {
                return aVar.a.l().a.h;
            }
            return -1;
        }

        public final com.sijla.mla.a.n a(int i) {
            if (this.a.k()) {
                return this.a.l().a.a(i, this.b);
            }
            return null;
        }

        public final java.lang.String a() {
            return this.a.k() ? this.a.l().a.a() : "[Java]";
        }

        public final int b() {
            int[] iArr;
            int i;
            if (this.a.k() && (iArr = this.a.l().a.d) != null && (i = this.b) >= 0 && i < iArr.length) {
                return iArr[i];
            }
            return -1;
        }
    }

    public static class b {
        private static com.sijla.mla.a.b.d.a[] a = new com.sijla.mla.a.b.d.a[0];
        private com.sijla.mla.a.b.d.a[] b = a;
        private int c = 0;

        private synchronized com.sijla.mla.a.b.d.a c() {
            com.sijla.mla.a.b.d.a[] aVarArr;
            int i;
            int i2 = this.c;
            com.sijla.mla.a.b.d.a[] aVarArr2 = this.b;
            if (i2 >= aVarArr2.length) {
                int max = java.lang.Math.max(4, (aVarArr2.length * 3) / 2);
                com.sijla.mla.a.b.d.a[] aVarArr3 = new com.sijla.mla.a.b.d.a[max];
                com.sijla.mla.a.b.d.a[] aVarArr4 = this.b;
                java.lang.System.arraycopy(aVarArr4, 0, aVarArr3, 0, aVarArr4.length);
                for (int length = this.b.length; length < max; length++) {
                    aVarArr3[length] = new com.sijla.mla.a.b.d.a();
                }
                this.b = aVarArr3;
                for (int i3 = 1; i3 < max; i3++) {
                    aVarArr3[i3].f = aVarArr3[i3 - 1];
                }
            }
            aVarArr = this.b;
            i = this.c;
            this.c = i + 1;
            return aVarArr[i];
        }

        public final synchronized int a() {
            int i = this.c;
            if (i <= 0) {
                return -1;
            }
            return this.b[i - 1].b();
        }

        public final synchronized com.sijla.mla.a.b.d.a a(com.sijla.mla.a.r rVar) {
            int i = 1;
            while (true) {
                int i2 = this.c;
                if (i > i2) {
                    return null;
                }
                com.sijla.mla.a.b.d.a[] aVarArr = this.b;
                if (aVarArr[i2 - i].a == rVar) {
                    return aVarArr[i];
                }
                i++;
            }
        }

        public final synchronized com.sijla.mla.a.b.d.c a(java.lang.String str, com.sijla.mla.a.j jVar, com.sijla.mla.a.b.d.a aVar) {
            com.sijla.mla.a.b.d.c cVar;
            java.lang.String b_;
            com.sijla.mla.a.b.d.a aVar2;
            com.sijla.mla.a.b.d.C0461d a2;
            cVar = new com.sijla.mla.a.b.d.c();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                int i2 = -1;
                if (charAt == 'S') {
                    if (jVar.k()) {
                        com.sijla.mla.a.w wVar = jVar.l().a;
                        com.sijla.mla.a.n nVar = wVar.g;
                        cVar.d = nVar != null ? nVar.g() : "=?";
                        int i3 = wVar.h;
                        cVar.f = i3;
                        cVar.g = wVar.i;
                        cVar.c = i3 == 0 ? com.sijla.mla.L2.s1077048999() : com.sijla.mla.L2.s33779308();
                        b_ = wVar.a();
                    } else {
                        cVar.d = "=[Java]";
                        cVar.f = -1;
                        cVar.g = -1;
                        cVar.c = com.sijla.mla.L2.s1044737854();
                        b_ = jVar.b_();
                    }
                    cVar.l = b_;
                } else if (charAt == 'l') {
                    if (aVar != null && aVar.a.k()) {
                        i2 = aVar.b();
                    }
                    cVar.e = i2;
                } else if (charAt == 'n') {
                    if (aVar != null && (aVar2 = aVar.f) != null && aVar2.a.k() && (a2 = com.sijla.mla.a.b.d.a(aVar.f)) != null) {
                        cVar.a = a2.a;
                        cVar.b = a2.b;
                    }
                    if (cVar.b == null) {
                        cVar.b = "";
                        cVar.a = null;
                    }
                } else if (charAt == 't') {
                    cVar.k = false;
                } else if (charAt == 'u') {
                    boolean z = true;
                    if (jVar == null || !jVar.k()) {
                        cVar.h = (short) 0;
                        cVar.j = true;
                        cVar.i = (short) 0;
                    } else {
                        com.sijla.mla.a.w wVar2 = jVar.l().a;
                        cVar.h = (short) wVar2.f.length;
                        cVar.i = (short) wVar2.j;
                        if (wVar2.k == 0) {
                            z = false;
                        }
                        cVar.j = z;
                    }
                }
            }
            return cVar;
        }

        public final synchronized java.lang.String a(int i) {
            java.lang.StringBuffer stringBuffer;
            java.lang.String str;
            stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("stack traceback:");
            while (true) {
                int i2 = i + 1;
                com.sijla.mla.a.b.d.a b = b(i);
                if (b != null) {
                    stringBuffer.append("\n\t");
                    stringBuffer.append(b.a());
                    stringBuffer.append(':');
                    if (b.b() > 0) {
                        stringBuffer.append(b.b() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    }
                    stringBuffer.append(" in ");
                    com.sijla.mla.a.b.d.c a2 = a(com.sijla.mla.L2.s36118(), b.a, b);
                    if (com.sijla.mla.a.b.d.a.a(b) == 0) {
                        str = "main chunk";
                    } else if (a2.a != null) {
                        stringBuffer.append("function '");
                        stringBuffer.append(a2.a);
                        stringBuffer.append('\'');
                        i = i2;
                    } else {
                        str = "function <" + b.a() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + com.sijla.mla.a.b.d.a.a(b) + ">";
                    }
                    stringBuffer.append(str);
                    i = i2;
                } else {
                    stringBuffer.append("\n\t[Java]: in ?");
                }
            }
            return stringBuffer.toString();
        }

        public final synchronized void a(int i, com.sijla.mla.a.y yVar, int i2) {
            int i3 = this.c;
            if (i3 > 0) {
                com.sijla.mla.a.b.d.a aVar = this.b[i3 - 1];
                aVar.b = i;
                aVar.d = yVar;
                aVar.c = i2;
                if (com.sijla.mla.a.b.d.a) {
                    com.sijla.mla.a.v.a(aVar.a.l(), i, aVar.e, i2, yVar);
                }
            }
        }

        public final synchronized void a(com.sijla.mla.a.g gVar, com.sijla.mla.a.y yVar, com.sijla.mla.a.r[] rVarArr) {
            com.sijla.mla.a.b.d.a c = c();
            c.a = gVar;
            c.d = yVar;
            c.e = rVarArr;
        }

        public final synchronized void a(com.sijla.mla.a.j jVar) {
            c().a = jVar;
        }

        public final synchronized com.sijla.mla.a.b.d.a b(int i) {
            if (i > 0) {
                int i2 = this.c;
                if (i <= i2) {
                    return this.b[i2 - i];
                }
            }
            return null;
        }

        public final synchronized void b() {
            int i = this.c;
            if (i > 0) {
                com.sijla.mla.a.b.d.a[] aVarArr = this.b;
                int i2 = i - 1;
                this.c = i2;
                com.sijla.mla.a.b.d.a aVar = aVarArr[i2];
                aVar.a = null;
                aVar.d = null;
                aVar.e = null;
            }
        }
    }

    public static class c {
        java.lang.String a;
        java.lang.String b;
        java.lang.String c;
        java.lang.String d;
        int e;
        int f;
        int g;
        short h;
        short i;
        boolean j;
        boolean k;
        java.lang.String l;
    }

    /* renamed from: com.sijla.mla.a.b.d$d, reason: collision with other inner class name */
    public static class C0461d {
        final java.lang.String a;
        final java.lang.String b;

        public C0461d(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public static final class e extends com.sijla.mla.a.b.u {
        @Override // com.sijla.mla.a.b.u, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r m() {
            return com.sijla.mla.a.r.n;
        }
    }

    public final class f extends com.sijla.mla.a.b.t {
        public f() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p.a aVar = (yVar.e() > 0 ? yVar.ad() : com.sijla.mla.a.b.d.this.b.d).e;
            com.sijla.mla.a.r rVar = aVar.b;
            if (rVar == null) {
                rVar = com.sijla.mla.a.r.k;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(aVar.d ? com.sijla.mla.L2.s35777() : "");
            sb.append(aVar.c ? com.sijla.mla.L2.s36056() : "");
            sb.append(aVar.e ? com.sijla.mla.L2.s36242() : "");
            return com.sijla.mla.a.r.a(rVar, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(sb.toString()), (com.sijla.mla.a.y) com.sijla.mla.a.k.c_(aVar.f));
        }
    }

    public final class g extends com.sijla.mla.a.b.t {
        public g() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p pVar;
            int i;
            com.sijla.mla.a.b.d.a a;
            int i2 = 1;
            if (yVar.ab()) {
                pVar = yVar.ad();
                i = 2;
            } else {
                pVar = com.sijla.mla.a.b.d.this.b.d;
                i = 1;
            }
            int i3 = i + 1;
            com.sijla.mla.a.r c = yVar.c(i);
            int i4 = i3 + 1;
            java.lang.String b = yVar.b(i3, com.sijla.mla.L2.s1641772396());
            com.sijla.mla.a.b.d.b a2 = com.sijla.mla.a.b.d.a(pVar);
            if (c.u()) {
                a = a2.b(c.p());
                if (a == null) {
                    return com.sijla.mla.a.r.n;
                }
                c = a.a;
            } else {
                if (!c.E()) {
                    return com.sijla.mla.a.r.a(i4 - 2, "function or level");
                }
                a = a2.a(c);
            }
            com.sijla.mla.a.b.d.c a3 = a2.a(b, (com.sijla.mla.a.j) c, a);
            com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
            if (b.indexOf(83) >= 0) {
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.T, (com.sijla.mla.a.r) com.sijla.mla.a.b.d.f);
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.U, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(a3.d));
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.V, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(a3.l));
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.W, (com.sijla.mla.a.r) com.sijla.mla.a.k.c_(a3.f));
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.X, (com.sijla.mla.a.r) com.sijla.mla.a.k.c_(a3.g));
            }
            if (b.indexOf(108) >= 0) {
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.Y, (com.sijla.mla.a.r) com.sijla.mla.a.k.c_(a3.e));
            }
            if (b.indexOf(117) >= 0) {
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.P, (com.sijla.mla.a.r) com.sijla.mla.a.k.c_(a3.h));
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.Q, (com.sijla.mla.a.r) com.sijla.mla.a.k.c_(a3.i));
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.O, (com.sijla.mla.a.r) (a3.j ? com.sijla.mla.a.r.p : com.sijla.mla.a.r.o));
            }
            if (b.indexOf(110) >= 0) {
                com.sijla.mla.a.n nVar = com.sijla.mla.a.b.d.R;
                java.lang.String str = a3.a;
                if (str == null) {
                    str = "?";
                }
                oVar.a((com.sijla.mla.a.r) nVar, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(str));
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.S, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(a3.b));
            }
            if (b.indexOf(116) >= 0) {
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.N, (com.sijla.mla.a.r) com.sijla.mla.a.r.o);
            }
            if (b.indexOf(76) >= 0) {
                com.sijla.mla.a.o oVar2 = new com.sijla.mla.a.o();
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.Z, (com.sijla.mla.a.r) oVar2);
                while (true) {
                    com.sijla.mla.a.b.d.a b2 = a2.b(i2);
                    if (b2 == null) {
                        break;
                    }
                    if (b2.a == c) {
                        oVar2.c(-1, com.sijla.mla.a.k.c_(b2.b()));
                    }
                    i2++;
                }
            }
            if (b.indexOf(102) >= 0 && c != null) {
                oVar.a((com.sijla.mla.a.r) com.sijla.mla.a.b.d.M, c);
            }
            return oVar;
        }
    }

    public final class h extends com.sijla.mla.a.b.t {
        public h() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p pVar;
            int i;
            if (yVar.ab()) {
                pVar = yVar.ad();
                i = 2;
            } else {
                pVar = com.sijla.mla.a.b.d.this.b.d;
                i = 1;
            }
            int i2 = i + 1;
            int u = yVar.u(i);
            int u2 = yVar.u(i2);
            com.sijla.mla.a.b.d.a b = com.sijla.mla.a.b.d.a(pVar).b(u);
            if (b == null) {
                return com.sijla.mla.a.r.n;
            }
            com.sijla.mla.a.n a = b.a(u2);
            return a != null ? com.sijla.mla.a.r.a((com.sijla.mla.a.r) a, (com.sijla.mla.a.y) b.e[u2 - 1]) : com.sijla.mla.a.r.k;
        }
    }

    public final class i extends com.sijla.mla.a.b.j {
        public i() {
        }

        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.r j = rVar.j();
            return j != null ? j : com.sijla.mla.a.r.k;
        }
    }

    public final class j extends com.sijla.mla.a.b.u {
        public j() {
        }

        @Override // com.sijla.mla.a.b.u, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r m() {
            return com.sijla.mla.a.b.d.this.b;
        }
    }

    public static final class k extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.g gVar;
            com.sijla.mla.a.n a;
            com.sijla.mla.a.j t = yVar.t(1);
            int u = yVar.u(2);
            return (!(t instanceof com.sijla.mla.a.g) || (a = com.sijla.mla.a.b.d.a((gVar = (com.sijla.mla.a.g) t), u)) == null) ? com.sijla.mla.a.r.k : com.sijla.mla.a.r.a((com.sijla.mla.a.r) a, (com.sijla.mla.a.y) gVar.b[u - 1].a());
        }
    }

    public static final class l extends com.sijla.mla.a.b.j {
        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return rVar.m_() ? rVar : com.sijla.mla.a.r.k;
        }
    }

    public final class m extends com.sijla.mla.a.b.t {
        public m() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p pVar;
            int i;
            if (yVar.ab()) {
                pVar = yVar.ad();
                i = 2;
            } else {
                pVar = com.sijla.mla.a.b.d.this.b.d;
                i = 1;
            }
            int i2 = i + 1;
            com.sijla.mla.a.j G = yVar.c(i).G();
            int i3 = i2 + 1;
            java.lang.String b = yVar.b(i2, "");
            int c = yVar.c(i3, 0);
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i4 = 0; i4 < b.length(); i4++) {
                char charAt = b.charAt(i4);
                if (charAt == 'c') {
                    z = true;
                } else if (charAt == 'l') {
                    z2 = true;
                } else if (charAt == 'r') {
                    z3 = true;
                }
            }
            com.sijla.mla.a.p.a aVar = pVar.e;
            aVar.b = G;
            aVar.d = z;
            aVar.c = z2;
            aVar.f = c;
            aVar.e = z3;
            return com.sijla.mla.a.r.n;
        }
    }

    public final class n extends com.sijla.mla.a.b.t {
        public n() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p pVar;
            int i;
            if (yVar.ab()) {
                pVar = yVar.ad();
                i = 2;
            } else {
                pVar = com.sijla.mla.a.b.d.this.b.d;
                i = 1;
            }
            int i2 = i + 1;
            int u = yVar.u(i);
            int i3 = i2 + 1;
            int u2 = yVar.u(i2);
            com.sijla.mla.a.r c = yVar.c(i3);
            com.sijla.mla.a.b.d.a b = com.sijla.mla.a.b.d.a(pVar).b(u);
            if (b == null) {
                return com.sijla.mla.a.r.n;
            }
            com.sijla.mla.a.n a = b.a(u2);
            if (a == null) {
                return com.sijla.mla.a.r.k;
            }
            b.e[u2 - 1] = c;
            return a;
        }
    }

    public final class o extends com.sijla.mla.a.b.s {
        public o() {
        }

        @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            com.sijla.mla.a.o L = rVar2.L();
            int a_ = rVar.a_();
            if (a_ == 0) {
                com.sijla.mla.a.l.b = L;
            } else if (a_ == 1) {
                com.sijla.mla.a.f.c = L;
            } else if (a_ == 3) {
                com.sijla.mla.a.m.b = L;
            } else if (a_ == 4) {
                com.sijla.mla.a.n.a = L;
            } else if (a_ == 6) {
                com.sijla.mla.a.j.c = L;
            } else if (a_ != 8) {
                rVar.p(L);
            } else {
                com.sijla.mla.a.p.a = L;
            }
            return rVar;
        }
    }

    public final class p extends com.sijla.mla.a.b.t {
        public p() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.g gVar;
            com.sijla.mla.a.n a;
            com.sijla.mla.a.j t = yVar.t(1);
            int u = yVar.u(2);
            com.sijla.mla.a.r c = yVar.c(3);
            if (!(t instanceof com.sijla.mla.a.g) || (a = com.sijla.mla.a.b.d.a((gVar = (com.sijla.mla.a.g) t), u)) == null) {
                return com.sijla.mla.a.r.k;
            }
            gVar.b[u - 1].a(c);
            return a;
        }
    }

    public final class q extends com.sijla.mla.a.b.t {
        public q() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            yVar.c(1).V();
            com.sijla.mla.a.r x = yVar.x(2);
            com.sijla.mla.a.q qVar = (com.sijla.mla.a.q) yVar.h();
            qVar.a = x.V();
            qVar.b = x.j();
            return com.sijla.mla.a.r.n;
        }
    }

    public final class r extends com.sijla.mla.a.b.t {
        public r() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p pVar;
            int i;
            if (yVar.ab()) {
                pVar = yVar.ad();
                i = 2;
            } else {
                pVar = com.sijla.mla.a.b.d.this.b.d;
                i = 1;
            }
            int i2 = i + 1;
            java.lang.String b = yVar.b(i, null);
            java.lang.String a = com.sijla.mla.a.b.d.a(pVar).a(yVar.c(i2, 1));
            if (b != null) {
                a = b + "\n" + a;
            }
            return com.sijla.mla.a.n.c(a);
        }
    }

    public final class s extends com.sijla.mla.a.b.t {
        public s() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.d[] dVarArr;
            com.sijla.mla.a.j t = yVar.t(1);
            int u = yVar.u(2);
            return (!(t instanceof com.sijla.mla.a.g) || (dVarArr = ((com.sijla.mla.a.g) t).b) == null || u <= 0 || u > dVarArr.length) ? com.sijla.mla.a.r.k : com.sijla.mla.a.k.c_(dVarArr[u - 1].hashCode());
        }
    }

    public final class t extends com.sijla.mla.a.b.t {
        public t() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.g r = yVar.r(1);
            int u = yVar.u(2);
            com.sijla.mla.a.g r2 = yVar.r(3);
            int u2 = yVar.u(4);
            if (u <= 0 || u > r.b.length) {
                e("index out of range");
            }
            if (u2 <= 0 || u2 > r2.b.length) {
                e("index out of range");
            }
            r.b[u - 1] = r2.b[u2 - 1];
            return com.sijla.mla.a.r.n;
        }
    }

    static {
        try {
            java.lang.System.getProperty(com.sijla.mla.L2.s2090875823());
        } catch (java.lang.Exception unused) {
        }
        try {
            a = java.lang.System.getProperty(com.sijla.mla.L2.s1702032833()) != null;
        } catch (java.lang.Exception unused2) {
        }
        f = com.sijla.mla.a.n.c(com.sijla.mla.L2.s33779308());
        g = com.sijla.mla.a.n.c("?");
        h = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1067816610());
        i = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1076368332());
        j = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1244221547());
        L = com.sijla.mla.a.n.c(com.sijla.mla.L2.s224485008());
        M = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1071184636());
        N = com.sijla.mla.a.n.c(com.sijla.mla.L2.s804132888());
        O = com.sijla.mla.a.n.c(com.sijla.mla.L2.s99393049());
        P = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1078575222());
        Q = com.sijla.mla.a.n.c(com.sijla.mla.L2.s613170512());
        R = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1077976085());
        S = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1130817455());
        T = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1086485244());
        U = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1399099653());
        V = com.sijla.mla.a.n.c(com.sijla.mla.L2.s599154243());
        W = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1685537713());
        X = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1683930341());
        Y = com.sijla.mla.a.n.c(com.sijla.mla.L2.s94826999());
        Z = com.sijla.mla.a.n.c(com.sijla.mla.L2.s744951979());
    }

    public static com.sijla.mla.a.b.d.b a(com.sijla.mla.a.p pVar) {
        if (pVar.f == null) {
            pVar.f = new com.sijla.mla.a.b.d.b();
        }
        return (com.sijla.mla.a.b.d.b) pVar.f;
    }

    public static com.sijla.mla.a.b.d.C0461d a(com.sijla.mla.a.b.d.a aVar) {
        com.sijla.mla.a.n nVar;
        com.sijla.mla.a.n nVar2;
        if (!aVar.a.k()) {
            return new com.sijla.mla.a.b.d.C0461d(aVar.a.H(), com.sijla.mla.L2.s1044737854());
        }
        com.sijla.mla.a.w wVar = aVar.a.l().a;
        int i2 = aVar.b;
        int i3 = wVar.b[i2];
        switch (com.sijla.mla.a.e.a(i3)) {
            case 6:
            case 7:
            case 12:
                nVar = com.sijla.mla.a.r.f428s;
                break;
            case 8:
            case 10:
                nVar = com.sijla.mla.a.r.t;
                break;
            case 9:
            case 11:
            case 20:
            case 23:
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
            default:
                return null;
            case 13:
                nVar = com.sijla.mla.a.r.w;
                break;
            case 14:
                nVar = com.sijla.mla.a.r.x;
                break;
            case 15:
                nVar = com.sijla.mla.a.r.z;
                break;
            case 16:
                nVar = com.sijla.mla.a.r.y;
                break;
            case 17:
                nVar = com.sijla.mla.a.r.B;
                break;
            case 18:
                nVar = com.sijla.mla.a.r.A;
                break;
            case 19:
                nVar = com.sijla.mla.a.r.C;
                break;
            case 21:
                nVar = com.sijla.mla.a.r.D;
                break;
            case 22:
                nVar = com.sijla.mla.a.r.I;
                break;
            case 24:
                nVar = com.sijla.mla.a.r.E;
                break;
            case 25:
                nVar = com.sijla.mla.a.r.F;
                break;
            case 26:
                nVar = com.sijla.mla.a.r.G;
                break;
            case 29:
            case 30:
                int b2 = com.sijla.mla.a.e.b(i3);
                while (true) {
                    com.sijla.mla.a.n a2 = wVar.a(b2 + 1, i2);
                    if (a2 != null) {
                        return new com.sijla.mla.a.b.d.C0461d(a2.g(), com.sijla.mla.L2.s987108167());
                    }
                    int i4 = -1;
                    int i5 = 0;
                    while (i5 < i2) {
                        int i6 = wVar.b[i5];
                        int a3 = com.sijla.mla.a.e.a(i6);
                        int b3 = com.sijla.mla.a.e.b(i6);
                        if (a3 != 4) {
                            if (a3 == 23) {
                                int g2 = com.sijla.mla.a.e.g(i6);
                                int i7 = i5 + 1 + g2;
                                if (i5 < i7 && i7 <= i2) {
                                    i5 += g2;
                                }
                            } else if (a3 == 27) {
                                if (b2 != b3) {
                                }
                                i4 = i5;
                            } else if (a3 == 34) {
                                if (b2 < b3 + 2) {
                                }
                                i4 = i5;
                            } else if (a3 == 29 || a3 == 30) {
                                if (b2 < b3) {
                                }
                                i4 = i5;
                            } else if (com.sijla.mla.a.e.l(a3)) {
                                if (b2 != b3) {
                                }
                                i4 = i5;
                            }
                            i5++;
                        } else {
                            int d = com.sijla.mla.a.e.d(i6);
                            if (b3 <= b2) {
                                if (b2 > b3 + d) {
                                }
                                i4 = i5;
                            }
                            i5++;
                        }
                    }
                    if (i4 != -1) {
                        int i8 = wVar.b[i4];
                        int a4 = com.sijla.mla.a.e.a(i8);
                        if (a4 == 0) {
                            int b4 = com.sijla.mla.a.e.b(i8);
                            int d2 = com.sijla.mla.a.e.d(i8);
                            if (d2 < b4) {
                                b2 = d2;
                                i2 = i4;
                            }
                        } else if (a4 == 1 || a4 == 2) {
                            int f2 = com.sijla.mla.a.e.a(i8) == 1 ? com.sijla.mla.a.e.f(i8) : com.sijla.mla.a.e.c(wVar.b[i4 + 1]);
                            if (wVar.a[f2].v()) {
                                return new com.sijla.mla.a.b.d.C0461d(wVar.a[f2].s().g(), com.sijla.mla.L2.s1486198556());
                            }
                        } else {
                            if (a4 == 5) {
                                int d3 = com.sijla.mla.a.e.d(i8);
                                com.sijla.h.f[] fVarArr = wVar.f;
                                return new com.sijla.mla.a.b.d.C0461d((d3 < fVarArr.length ? fVarArr[d3].a : g).g(), com.sijla.mla.L2.s513788238());
                            }
                            if (a4 == 6 || a4 == 7) {
                                int e2 = com.sijla.mla.a.e.e(i8);
                                int d4 = com.sijla.mla.a.e.d(i8);
                                if (com.sijla.mla.a.e.a(i8) == 7) {
                                    nVar2 = wVar.a(d4 + 1, i4);
                                } else {
                                    com.sijla.h.f[] fVarArr2 = wVar.f;
                                    nVar2 = d4 < fVarArr2.length ? fVarArr2[d4].a : g;
                                }
                                return new com.sijla.mla.a.b.d.C0461d(a(wVar, e2).g(), (nVar2 == null || !nVar2.c((com.sijla.mla.a.r) com.sijla.mla.a.r.r)) ? com.sijla.mla.L2.s1164354294() : com.sijla.mla.L2.s752916867());
                            }
                            if (a4 == 12) {
                                return new com.sijla.mla.a.b.d.C0461d(a(wVar, com.sijla.mla.a.e.e(i8)).g(), com.sijla.mla.L2.s81543423());
                            }
                        }
                    }
                }
                return null;
            case 34:
                return new com.sijla.mla.a.b.d.C0461d("(for iterator)", "(for iterator");
        }
        return new com.sijla.mla.a.b.d.C0461d(nVar.g(), com.sijla.mla.L2.s1875227558());
    }

    public static com.sijla.mla.a.n a(com.sijla.mla.a.g gVar, int i2) {
        com.sijla.mla.a.d[] dVarArr = gVar.b;
        if (dVarArr == null || i2 <= 0 || i2 > dVarArr.length) {
            return null;
        }
        com.sijla.h.f[] fVarArr = gVar.a.f;
        if (fVarArr != null && i2 <= fVarArr.length) {
            return fVarArr[i2 - 1].a;
        }
        return com.sijla.mla.a.n.c(com.sijla.mla.L2.s34134() + i2);
    }

    private static com.sijla.mla.a.n a(com.sijla.mla.a.w wVar, int i2) {
        return (com.sijla.mla.a.e.h(i2) && wVar.a[com.sijla.mla.a.e.i(i2)].v()) ? wVar.a[com.sijla.mla.a.e.i(i2)].s() : g;
    }

    private static void a(com.sijla.mla.a.p.a aVar, com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.r rVar3;
        if (aVar.g || (rVar3 = aVar.b) == null) {
            return;
        }
        aVar.g = true;
        try {
            try {
                rVar3.b(rVar, rVar2);
            } catch (com.sijla.mla.a.i e2) {
                throw e2;
            } catch (java.lang.RuntimeException e3) {
                throw new com.sijla.mla.a.i(e3);
            }
        } finally {
            aVar.g = false;
        }
    }

    private com.sijla.mla.a.b.d.b au() {
        return a(this.b.d);
    }

    public final void a(int i2, com.sijla.mla.a.y yVar, int i3) {
        int a2;
        com.sijla.mla.a.p.a aVar = this.b.d.e;
        if (aVar.g) {
            return;
        }
        au().a(i2, yVar, i3);
        if (aVar.b == null) {
            return;
        }
        int i4 = aVar.f;
        if (i4 > 0) {
            int i5 = aVar.i + 1;
            aVar.i = i5;
            if (i5 % i4 == 0) {
                a(aVar, j, com.sijla.mla.a.r.k);
            }
        }
        if (!aVar.c || (a2 = au().a()) == aVar.h) {
            return;
        }
        aVar.h = a2;
        a(aVar, i, com.sijla.mla.a.k.c_(a2));
    }

    public final void a(com.sijla.mla.a.g gVar, com.sijla.mla.a.y yVar, com.sijla.mla.a.r[] rVarArr) {
        com.sijla.mla.a.p.a aVar = this.b.d.e;
        if (aVar.g) {
            return;
        }
        au().a(gVar, yVar, rVarArr);
        if (aVar.d) {
            a(aVar, h, com.sijla.mla.a.r.k);
        }
    }

    public final void a(com.sijla.mla.a.j jVar) {
        com.sijla.mla.a.p.a aVar = this.b.d.e;
        if (aVar.g) {
            return;
        }
        au().a(jVar);
        if (aVar.d) {
            a(aVar, h, com.sijla.mla.a.r.k);
        }
    }

    public final void ae() {
        com.sijla.mla.a.p.a aVar = this.b.d.e;
        if (aVar.g) {
            return;
        }
        au().b();
        if (aVar.e) {
            a(aVar, L, com.sijla.mla.a.r.k);
        }
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.b a2 = rVar2.a();
        this.b = a2;
        a2.g = this;
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        oVar.a(com.sijla.mla.L2.s1225387311(), new com.sijla.mla.a.b.d.e());
        oVar.a(com.sijla.mla.L2.s660931563(), new com.sijla.mla.a.b.d.f());
        oVar.a(com.sijla.mla.L2.s661816768(), new com.sijla.mla.a.b.d.g());
        oVar.a(com.sijla.mla.L2.s871806197(), new com.sijla.mla.a.b.d.h());
        oVar.a(com.sijla.mla.L2.s505110707(), new com.sijla.mla.a.b.d.i());
        oVar.a(com.sijla.mla.L2.s973866513(), new com.sijla.mla.a.b.d.j());
        oVar.a(com.sijla.mla.L2.s350168288(), new com.sijla.mla.a.b.d.k());
        oVar.a(com.sijla.mla.L2.s276096848(), new com.sijla.mla.a.b.d.l());
        oVar.a(com.sijla.mla.L2.s99819103(), new com.sijla.mla.a.b.d.m());
        oVar.a(com.sijla.mla.L2.s1086423273(), new com.sijla.mla.a.b.d.n());
        oVar.a(com.sijla.mla.L2.s269020505(), new com.sijla.mla.a.b.d.o());
        oVar.a(com.sijla.mla.L2.s438748116(), new com.sijla.mla.a.b.d.p());
        oVar.a(com.sijla.mla.L2.s1050228060(), new com.sijla.mla.a.b.d.q());
        oVar.a(com.sijla.mla.L2.s23553944(), new com.sijla.mla.a.b.d.r());
        oVar.a(com.sijla.mla.L2.s170670957(), new com.sijla.mla.a.b.d.s());
        oVar.a(com.sijla.mla.L2.s804709532(), new com.sijla.mla.a.b.d.t());
        rVar2.a(com.sijla.mla.L2.s1225387311(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s1225387311(), oVar);
        return oVar;
    }

    public final java.lang.String m(int i2) {
        return au().a(i2);
    }
}
