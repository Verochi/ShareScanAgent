package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public class au implements java.lang.Comparable<com.anythink.core.common.f.au> {
    private java.lang.String A;
    private java.lang.String B;
    private long C;
    private java.lang.String D;
    private int E;
    private int F;
    private double G;
    private int H;
    private java.lang.String I;
    private java.lang.String J;
    private int K;
    private long L;
    private long M;
    private long N;
    private long O;
    private int P;
    private java.lang.String Q;
    private long R;
    private long S;
    private long T;
    private long U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private java.lang.String Z;
    int a;
    private int aA;
    private long aa;
    private long ab;
    private double ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private com.anythink.core.common.f.q aj;
    private int ak;
    private int al;
    private java.lang.String am;
    private int an;
    private int ao;
    private int ap;
    private double as;
    private double at;
    private double au;
    private double av;
    private int[] aw;
    private org.json.JSONArray az;
    int c;
    int d;
    java.lang.String e;
    int f;
    int g;
    double h;
    int i;
    double j;
    java.lang.String k;
    boolean l;
    protected int m;
    int n;
    int o;
    int p;
    java.lang.String t;
    long u;
    private int v;
    private java.lang.String w;
    private int x;
    private int y;
    private java.lang.String z;
    int b = 0;
    private int aq = -1;
    private com.anythink.core.api.ATAdConst.CURRENCY ar = com.anythink.core.api.ATAdConst.CURRENCY.USD;
    int q = 2;
    boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    double f169s = -1.0d;
    private int ax = 1;
    private int ay = 1;

    public au(int i) {
        this.ao = i;
    }

    private void I(int i) {
        this.X = i;
    }

    private void J(int i) {
        this.ak = i;
    }

    private int a(com.anythink.core.common.f.au auVar) {
        if (com.anythink.core.common.o.h.a(this) > com.anythink.core.common.o.h.a(auVar)) {
            return -1;
        }
        return com.anythink.core.common.o.h.a(this) == com.anythink.core.common.o.h.a(auVar) ? 0 : 1;
    }

    private void a(com.anythink.core.common.f.q qVar) {
        this.aj = qVar;
    }

    private long aD() {
        return this.R;
    }

    private int aE() {
        return this.X;
    }

    private int aF() {
        return this.ad;
    }

    private int aG() {
        return this.ap;
    }

    private boolean aH() {
        return this.ay == 1;
    }

    private void m(java.lang.String str) {
        this.am = str;
    }

    public final java.lang.String A() {
        return this.J;
    }

    public final void A(int i) {
        this.m = i;
    }

    public final long B() {
        return this.S;
    }

    public final void B(int i) {
        this.n = i;
    }

    public final long C() {
        return this.T;
    }

    public final void C(int i) {
        this.o = i;
    }

    public final int D() {
        return this.V;
    }

    public final void D(int i) {
        this.p = i;
    }

    public final int E() {
        return this.W;
    }

    public final void E(int i) {
        this.q = i;
    }

    public final int F() {
        return this.Y;
    }

    public final void F(int i) {
        this.ax = i;
    }

    public final java.lang.String G() {
        return this.Z;
    }

    public final void G(int i) {
        this.ay = i;
    }

    public final long H() {
        return this.aa;
    }

    public final void H(int i) {
        this.aA = i;
    }

    public final long I() {
        return this.ab;
    }

    public final double J() {
        return this.ac;
    }

    public final int K() {
        return this.ae;
    }

    public final boolean L() {
        return this.af == 2;
    }

    public final com.anythink.core.common.f.q M() {
        return this.aj;
    }

    public final int N() {
        return this.ak;
    }

    public final int O() {
        return this.al;
    }

    public final void P() {
        this.al = 1;
    }

    public final java.lang.String Q() {
        return this.am;
    }

    public final int R() {
        int i = this.b;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final int S() {
        return this.c;
    }

    public final int T() {
        return this.d;
    }

    public final java.lang.String U() {
        return this.e;
    }

    public final int V() {
        return this.a;
    }

    public final int W() {
        return this.aq;
    }

    public final int X() {
        int i;
        com.anythink.core.common.f.q qVar = this.aj;
        return (qVar == null || (i = qVar.n) == 0) ? this.f : i;
    }

    public final boolean Y() {
        int i = this.v;
        return i == 66 || i == 67;
    }

    public final boolean Z() {
        return this.v == 1 && this.ai == 1;
    }

    public final int a() {
        return this.ao;
    }

    public final void a(double d) {
        this.G = d;
    }

    public final void a(int i) {
        this.v = i;
    }

    public final void a(long j) {
        this.M = j;
    }

    public final void a(com.anythink.core.api.ATAdConst.CURRENCY currency) {
        this.ar = currency;
    }

    public final synchronized void a(com.anythink.core.common.f.au auVar, int i, int i2, int i3) {
        if (auVar.Q.equals(this.Q)) {
            this.G = auVar.G;
            this.j = auVar.j;
            this.K = i2;
            this.I = auVar.I;
            this.am = auVar.am;
            this.ah = 0;
            if (i == 0) {
                this.ak = auVar.ak;
            } else {
                this.ak = i;
            }
            this.J = auVar.J;
            this.aj = auVar.aj;
            this.al = i3;
        }
    }

    public final void a(com.anythink.core.common.f.q qVar, int i, int i2, int i3) {
        this.K = i2;
        this.G = qVar.getPrice();
        this.j = qVar.getSortPrice();
        this.I = qVar.token;
        this.am = qVar.m;
        this.ah = 0;
        this.ak = i;
        this.aj = qVar;
        this.al = i3;
        if (i3 == 1) {
            this.J = "";
        }
    }

    public final void a(java.lang.String str) {
        this.w = str;
    }

    public final void a(org.json.JSONArray jSONArray) {
        this.az = jSONArray;
    }

    public final void a(int[] iArr) {
        this.aw = iArr;
    }

    public final boolean aA() {
        int i = this.v;
        return i == 28 || i == 8 || i == 29 || i == 15 || i == 3;
    }

    public final org.json.JSONArray aB() {
        return this.az;
    }

    public final int aC() {
        return this.aA;
    }

    public final int aa() {
        return this.an;
    }

    public final com.anythink.core.api.ATAdConst.CURRENCY ab() {
        return this.ar;
    }

    public final int ac() {
        return this.g;
    }

    public final double ad() {
        return this.h;
    }

    public final int ae() {
        return this.i;
    }

    public final double af() {
        return this.j;
    }

    public final java.lang.String ag() {
        return this.k;
    }

    public final boolean ah() {
        return this.l;
    }

    public final void ai() {
        this.l = true;
    }

    public final int aj() {
        return this.m;
    }

    public final int ak() {
        return this.n;
    }

    public final int al() {
        return this.o;
    }

    public final int am() {
        int i = this.p;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public final int an() {
        return this.q;
    }

    public final boolean ao() {
        return this.r;
    }

    public final void ap() {
        this.r = true;
    }

    public final double aq() {
        return this.f169s;
    }

    public final java.lang.String ar() {
        return this.t;
    }

    public final long as() {
        return this.u;
    }

    public final double at() {
        return this.as;
    }

    public final double au() {
        return this.at;
    }

    public final double av() {
        return this.au;
    }

    public final double aw() {
        return this.av;
    }

    public final int[] ax() {
        return this.aw;
    }

    public final int ay() {
        return this.ax;
    }

    public final int az() {
        return this.ay;
    }

    public final int b() {
        return this.ah;
    }

    public final void b(double d) {
        this.ac = d;
    }

    public final void b(int i) {
        this.x = i;
    }

    public final void b(long j) {
        this.U = j;
    }

    public final void b(java.lang.String str) {
        this.z = str;
    }

    public final void c() {
        this.ah = -1;
    }

    public final void c(double d) {
        this.h = d;
    }

    public final void c(int i) {
        this.y = i;
    }

    public final void c(long j) {
        this.N = j;
    }

    public final void c(java.lang.String str) {
        this.A = str;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.au auVar2 = auVar;
        if (com.anythink.core.common.o.h.a(this) > com.anythink.core.common.o.h.a(auVar2)) {
            return -1;
        }
        return com.anythink.core.common.o.h.a(this) == com.anythink.core.common.o.h.a(auVar2) ? 0 : 1;
    }

    public final int d() {
        return this.v;
    }

    public final void d(double d) {
        this.j = d;
    }

    public final void d(int i) {
        this.H = i;
    }

    public final void d(long j) {
        this.O = j;
    }

    public final void d(java.lang.String str) {
        this.B = str;
    }

    public final java.lang.String e() {
        return this.w;
    }

    public final void e(double d) {
        this.f169s = d;
    }

    public final void e(int i) {
        this.ai = i;
    }

    public final void e(long j) {
        this.C = j;
    }

    public final void e(java.lang.String str) {
        this.Q = str;
    }

    public final int f() {
        return this.x;
    }

    public final void f(double d) {
        this.as = d;
    }

    public final void f(int i) {
        this.ag = i;
    }

    public final void f(long j) {
        this.R = j;
    }

    public final void f(java.lang.String str) {
        this.D = str;
    }

    public final int g() {
        return this.y;
    }

    public final void g(double d) {
        this.at = d;
    }

    public final void g(int i) {
        this.K = i;
    }

    public final void g(long j) {
        this.S = j;
    }

    public final void g(java.lang.String str) {
        this.I = str;
    }

    public final java.lang.String h() {
        return this.z;
    }

    public final void h(double d) {
        this.au = d;
    }

    public final void h(int i) {
        this.P = i;
    }

    public final void h(long j) {
        this.T = j;
    }

    public final void h(java.lang.String str) {
        this.J = str;
    }

    public final java.lang.String i() {
        return this.A;
    }

    public final void i(double d) {
        this.av = d;
    }

    public final void i(int i) {
        this.E = i;
    }

    public final void i(long j) {
        this.aa = j;
    }

    public final void i(java.lang.String str) {
        this.Z = str;
    }

    public final int j() {
        return this.H;
    }

    public final void j(int i) {
        this.F = i;
    }

    public final void j(long j) {
        this.ab = j;
    }

    public final void j(java.lang.String str) {
        this.e = str;
    }

    public final void k(int i) {
        this.V = i;
    }

    public final void k(long j) {
        this.u = j;
    }

    public final void k(java.lang.String str) {
        this.k = str;
    }

    public final boolean k() {
        return this.H == 1;
    }

    public final long l() {
        return this.M;
    }

    public final void l(int i) {
        this.W = i;
    }

    public final void l(java.lang.String str) {
        this.t = str;
    }

    public final int m() {
        return this.ai;
    }

    public final void m(int i) {
        this.Y = i;
    }

    public final int n() {
        return this.ag;
    }

    public final void n(int i) {
        this.ad = i;
    }

    public final long o() {
        return this.U;
    }

    public final void o(int i) {
        this.ae = i;
    }

    public final int p() {
        return this.K;
    }

    public final void p(int i) {
        this.af = i;
    }

    public final long q() {
        return this.N;
    }

    public final void q(int i) {
        this.ap = i;
    }

    public final long r() {
        return this.O;
    }

    public final void r(int i) {
        this.b = i;
    }

    public final int s() {
        return this.P;
    }

    public final void s(int i) {
        this.c = i;
    }

    public final long t() {
        return this.C;
    }

    public final void t(int i) {
        this.d = i;
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("UnitGroupInfo{networkFirmId=");
        sb.append(this.v);
        sb.append(", networkName='");
        sb.append(this.w);
        sb.append('\'');
        sb.append(", adSourceId='");
        sb.append(this.Q);
        sb.append('\'');
        sb.append(", bidType=");
        int i = this.H;
        sb.append(i == 1 ? com.anythink.core.common.o.h.a(this.ao) : java.lang.Integer.valueOf(i));
        if (this.aj != null) {
            str = ", bidId=" + this.aj.token;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", sortPrice=");
        sb.append(com.anythink.core.common.o.h.a(this));
        sb.append(", maxOfferCacheSize=");
        sb.append(am());
        sb.append(", samePriceSortIndex=");
        sb.append(this.n);
        sb.append(", content=");
        sb.append(this.z);
        sb.append(", lossSendSwitch=");
        sb.append(this.ay);
        sb.append(", winSendSwitch=");
        sb.append(this.ax);
        sb.append('}');
        return sb.toString();
    }

    public final java.lang.String u() {
        return this.Q;
    }

    public final void u(int i) {
        this.a = i;
    }

    public final java.lang.String v() {
        return this.D;
    }

    public final void v(int i) {
        this.aq = i;
    }

    public final int w() {
        return this.E;
    }

    public final void w(int i) {
        this.f = i;
    }

    public final int x() {
        return this.F;
    }

    public final void x(int i) {
        this.an = i;
    }

    public final double y() {
        return this.G;
    }

    public final void y(int i) {
        this.g = i;
    }

    public final java.lang.String z() {
        return this.I;
    }

    public final void z(int i) {
        this.i = i;
    }
}
