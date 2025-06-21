package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class h extends com.sijla.mla.a.m {
    private double h;
    private static com.sijla.mla.a.h c = new com.sijla.mla.a.h(Double.NaN);
    public static final com.sijla.mla.a.h a = new com.sijla.mla.a.h(Double.POSITIVE_INFINITY);
    private static com.sijla.mla.a.h d = new com.sijla.mla.a.h(Double.NEGATIVE_INFINITY);
    private static java.lang.String e = com.sijla.mla.L2.s34773385();
    private static java.lang.String f = com.sijla.mla.L2.s34636675();
    private static java.lang.String g = com.sijla.mla.L2.s1018186540();

    private h(double d2) {
        this.h = d2;
    }

    public static com.sijla.mla.a.m a(double d2) {
        int i = (int) d2;
        return d2 == ((double) i) ? com.sijla.mla.a.k.c_(i) : new com.sijla.mla.a.h(d2);
    }

    public static com.sijla.mla.a.r a(double d2, double d3) {
        return d3 != 0.0d ? a(d2 / d3) : d2 > 0.0d ? a : d2 == 0.0d ? c : d;
    }

    public static com.sijla.mla.a.r b(double d2, double d3) {
        return d3 != 0.0d ? a(d2 - (d3 * java.lang.Math.floor(d2 / d3))) : c;
    }

    @Override // com.sijla.mla.a.r
    public final double A() {
        return this.h;
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String B() {
        return g();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n C() {
        return com.sijla.mla.a.n.c(g());
    }

    @Override // com.sijla.mla.a.r
    public final boolean D() {
        return !java.lang.Double.isNaN(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final int a(int i) {
        return (int) this.h;
    }

    @Override // com.sijla.mla.a.r
    public final int a(com.sijla.mla.a.n nVar) {
        f("attempt to compare number with string");
        return 0;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r a_(int i) {
        return a(i * this.h);
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String a_(java.lang.String str) {
        return g();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n b(com.sijla.mla.a.n nVar) {
        return com.sijla.mla.a.n.c(g());
    }

    @Override // com.sijla.mla.a.r
    public final boolean b(double d2) {
        return this.h == d2;
    }

    @Override // com.sijla.mla.a.r
    public final boolean b(int i) {
        return this.h == ((double) i);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r c(double d2) {
        return a(d2 + this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean c(com.sijla.mla.a.r rVar) {
        return rVar.b(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r d(double d2) {
        return a(d2 - this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r d(int i) {
        return com.sijla.mla.a.b.k.a(i, this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean d(com.sijla.mla.a.r rVar) {
        return rVar.b(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r e(double d2) {
        return a(d2 * this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r e(com.sijla.mla.a.r rVar) {
        return rVar.c(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean e(int i) {
        return this.h <= ((double) i);
    }

    @Override // com.sijla.mla.a.r
    public final boolean equals(java.lang.Object obj) {
        return (obj instanceof com.sijla.mla.a.h) && ((com.sijla.mla.a.h) obj).h == this.h;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r f(double d2) {
        return com.sijla.mla.a.b.k.a(d2, this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r f(com.sijla.mla.a.r rVar) {
        return rVar.d(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean f(int i) {
        return this.h > ((double) i);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r g(double d2) {
        return a(d2, this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r g(com.sijla.mla.a.r rVar) {
        return rVar.e(this.h);
    }

    @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
    public final java.lang.String g() {
        double d2 = this.h;
        long j = (long) d2;
        return ((double) j) == d2 ? java.lang.Long.toString(j) : java.lang.Double.isNaN(d2) ? e : java.lang.Double.isInfinite(this.h) ? this.h < 0.0d ? g : f : java.lang.Float.toString((float) this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean g(int i) {
        return this.h >= ((double) i);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r h(double d2) {
        return b(d2, this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r h(com.sijla.mla.a.r rVar) {
        return rVar.f(this.h);
    }

    public final int hashCode() {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(this.h + 1.0d);
        return ((int) (doubleToLongBits >> 32)) + ((int) doubleToLongBits);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r i(com.sijla.mla.a.r rVar) {
        return rVar.g(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean i(double d2) {
        return this.h <= d2;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j(com.sijla.mla.a.r rVar) {
        return rVar.h(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean j(double d2) {
        return this.h > d2;
    }

    @Override // com.sijla.mla.a.r
    public final boolean k(double d2) {
        return this.h >= d2;
    }

    @Override // com.sijla.mla.a.r
    public final boolean k(com.sijla.mla.a.r rVar) {
        return rVar.j(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean l(com.sijla.mla.a.r rVar) {
        return rVar.k(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean m(com.sijla.mla.a.r rVar) {
        return rVar.i(this.h);
    }

    @Override // com.sijla.mla.a.r
    public final boolean n() {
        double d2 = this.h;
        return d2 == ((double) ((long) d2));
    }

    @Override // com.sijla.mla.a.r
    public final double o() {
        return this.h;
    }

    @Override // com.sijla.mla.a.r
    public final int p() {
        return (int) this.h;
    }

    @Override // com.sijla.mla.a.r
    public final long q() {
        return (long) this.h;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r r() {
        return a(-this.h);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n s() {
        return com.sijla.mla.a.n.c(g());
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r t() {
        return com.sijla.mla.a.n.c(g());
    }

    @Override // com.sijla.mla.a.m, com.sijla.mla.a.r
    public final boolean u() {
        return true;
    }

    @Override // com.sijla.mla.a.m, com.sijla.mla.a.r
    public final boolean v() {
        return true;
    }

    @Override // com.sijla.mla.a.m, com.sijla.mla.a.r
    public final com.sijla.mla.a.r w() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final int x() {
        return (int) this.h;
    }

    @Override // com.sijla.mla.a.r
    public final long y() {
        return (long) this.h;
    }

    @Override // com.sijla.mla.a.m, com.sijla.mla.a.r
    public final com.sijla.mla.a.m z() {
        return this;
    }
}
