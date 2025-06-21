package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public abstract class l<T extends com.anythink.core.common.f.n> implements java.io.Serializable {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 10;
    public static final int w = 1;
    public static final int x = 2;
    protected java.lang.String A;
    protected int B;
    protected java.lang.String C;
    protected java.lang.String D;
    protected java.lang.String E;
    protected java.lang.String F;
    protected java.lang.String G;
    protected java.lang.String H;
    protected java.lang.String I;
    protected android.graphics.Bitmap J;
    protected com.anythink.core.common.f.n K;
    protected java.lang.String L;
    protected java.lang.String M;
    protected int N;
    protected java.lang.String O;
    protected java.lang.String P;
    protected java.lang.String Q;
    protected java.lang.String R;
    protected int S;
    protected int T;
    protected int U;
    protected int V;
    private boolean a;
    protected java.lang.String h;
    protected java.lang.String i;
    protected java.lang.String j;
    protected java.lang.String k;
    protected java.lang.String l;
    protected java.lang.String m;
    protected java.lang.String n;
    protected java.lang.String o;
    protected java.lang.String p;
    protected java.lang.String q;
    protected java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    protected java.lang.String f172s;
    protected java.lang.String t;
    protected java.lang.String u;
    protected int v;
    protected int y;
    protected int z;

    private java.lang.String U() {
        return this.A;
    }

    private int a() {
        return this.N;
    }

    private java.lang.String b() {
        return this.m;
    }

    private int c() {
        return this.z;
    }

    public final java.lang.String A() {
        return this.q;
    }

    public final void A(java.lang.String str) {
        this.E = str;
    }

    public final java.lang.String B() {
        return this.r;
    }

    public final void B(java.lang.String str) {
        this.F = str;
    }

    public final java.lang.String C() {
        return this.f172s;
    }

    public final void C(java.lang.String str) {
        this.G = str;
    }

    public final java.lang.String D() {
        return this.t;
    }

    public final void D(java.lang.String str) {
        this.M = str;
    }

    public final java.lang.String E() {
        return this.u;
    }

    public final boolean E(java.lang.String str) {
        return android.text.TextUtils.equals(this.q, str) && !android.text.TextUtils.isEmpty(str);
    }

    public final int F() {
        return this.v;
    }

    public final int G() {
        return this.y;
    }

    public final boolean H() {
        return !android.text.TextUtils.isEmpty(this.q);
    }

    public final java.lang.String I() {
        return this.D;
    }

    public final java.lang.String J() {
        return this.E;
    }

    public final java.lang.String K() {
        return this.F;
    }

    public final java.lang.String L() {
        return this.G;
    }

    public final android.graphics.Bitmap M() {
        return this.J;
    }

    public final boolean N() {
        return (android.text.TextUtils.isEmpty(this.E) || android.text.TextUtils.isEmpty(this.D) || android.text.TextUtils.isEmpty(this.F) || android.text.TextUtils.isEmpty(this.G)) ? false : true;
    }

    public boolean O() {
        return false;
    }

    public final java.lang.String P() {
        return this.M;
    }

    public final int Q() {
        return this.U;
    }

    public final int R() {
        return this.V;
    }

    public final boolean S() {
        return this.a;
    }

    public final void T() {
        this.a = true;
    }

    public final void a(android.graphics.Bitmap bitmap) {
        this.J = bitmap;
    }

    public final void a(com.anythink.core.common.f.n nVar) {
        this.K = nVar;
    }

    public abstract java.util.List<java.lang.String> b(T t);

    public final void b(int i) {
        this.S = i;
    }

    public final void c(int i) {
        this.T = i;
    }

    public final void c(java.lang.String str) {
        this.H = str;
    }

    public abstract int d();

    public final void d(int i) {
        this.N = i;
    }

    public final void d(java.lang.String str) {
        this.Q = str;
    }

    public final java.lang.String e() {
        return this.H;
    }

    public final void e(int i) {
        this.B = i;
    }

    public final void e(java.lang.String str) {
        this.R = str;
    }

    public final int f() {
        return this.S;
    }

    public final void f(int i) {
        this.v = i;
    }

    public final void f(java.lang.String str) {
        this.O = str;
    }

    public final int g() {
        return this.T;
    }

    public final void g(int i) {
        this.y = i;
    }

    public final void g(java.lang.String str) {
        this.P = str;
    }

    public final java.lang.String h() {
        return this.Q;
    }

    public final void h(int i) {
        this.z = i;
    }

    public final void h(java.lang.String str) {
        this.L = str;
    }

    public final java.lang.String i() {
        return this.R;
    }

    public final void i(int i) {
        this.U = i;
    }

    public final void i(java.lang.String str) {
        this.I = str;
    }

    public final void j(int i) {
        this.V = i;
    }

    public final void j(java.lang.String str) {
        this.C = str;
    }

    public final boolean j() {
        return this.N == 1;
    }

    public final java.lang.String k() {
        return this.O;
    }

    public final void k(java.lang.String str) {
        this.h = str;
    }

    public final java.lang.String l() {
        return this.P;
    }

    public final void l(java.lang.String str) {
        this.i = str;
    }

    public final java.lang.String m() {
        return this.L;
    }

    public final void m(java.lang.String str) {
        this.j = str;
    }

    public final com.anythink.core.common.f.n n() {
        return this.K;
    }

    public final void n(java.lang.String str) {
        this.k = str;
    }

    public final java.lang.String o() {
        return this.I;
    }

    public final void o(java.lang.String str) {
        this.l = str;
    }

    public abstract java.lang.String p();

    public final void p(java.lang.String str) {
        this.m = str;
    }

    public final int q() {
        return this.B;
    }

    public final void q(java.lang.String str) {
        this.n = str;
    }

    public final java.lang.String r() {
        return this.C;
    }

    public final void r(java.lang.String str) {
        this.o = str;
    }

    public final java.lang.String s() {
        return this.h;
    }

    public final void s(java.lang.String str) {
        this.p = str;
    }

    public final java.lang.String t() {
        return this.i;
    }

    public final void t(java.lang.String str) {
        this.q = str;
    }

    public final java.lang.String u() {
        return this.j;
    }

    public final void u(java.lang.String str) {
        this.r = str;
    }

    public final java.lang.String v() {
        return this.k;
    }

    public final void v(java.lang.String str) {
        this.f172s = str;
    }

    public final java.lang.String w() {
        return this.l;
    }

    public final void w(java.lang.String str) {
        this.t = str;
    }

    public final java.lang.String x() {
        return this.n;
    }

    public final void x(java.lang.String str) {
        this.u = str;
    }

    public final java.lang.String y() {
        return this.o;
    }

    public final void y(java.lang.String str) {
        this.A = str;
    }

    public final java.lang.String z() {
        return this.p;
    }

    public final void z(java.lang.String str) {
        this.D = str;
    }
}
