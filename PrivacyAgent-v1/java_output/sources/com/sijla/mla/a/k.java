package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class k extends com.sijla.mla.a.m {
    private static final com.sijla.mla.a.k[] a = new com.sijla.mla.a.k[512];
    private int c;

    static {
        for (int i = 0; i < 512; i++) {
            a[i] = new com.sijla.mla.a.k(i + androidx.core.view.InputDeviceCompat.SOURCE_ANY);
        }
    }

    private k(int i) {
        this.c = i;
    }

    private static com.sijla.mla.a.m a(long j) {
        int i = (int) j;
        return j == ((long) i) ? (i > 255 || i < -256) ? new com.sijla.mla.a.k(i) : a[i + 256] : com.sijla.mla.a.h.a(j);
    }

    public static com.sijla.mla.a.k c_(int i) {
        return (i > 255 || i < -256) ? new com.sijla.mla.a.k(i) : a[i + 256];
    }

    public static int d_(int i) {
        return i;
    }

    @Override // com.sijla.mla.a.r
    public final double A() {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String B() {
        return java.lang.String.valueOf(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n C() {
        return com.sijla.mla.a.n.c(java.lang.String.valueOf(this.c));
    }

    @Override // com.sijla.mla.a.r
    public final boolean I() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final int a(int i) {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final int a(com.sijla.mla.a.n nVar) {
        f("attempt to compare number with string");
        return 0;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r a_(int i) {
        return a(i * this.c);
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String a_(java.lang.String str) {
        return java.lang.Integer.toString(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n b(com.sijla.mla.a.n nVar) {
        return com.sijla.mla.a.n.c(java.lang.Integer.toString(this.c));
    }

    @Override // com.sijla.mla.a.r
    public final boolean b(double d) {
        return ((double) this.c) == d;
    }

    @Override // com.sijla.mla.a.r
    public final boolean b(int i) {
        return this.c == i;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r c(double d) {
        return com.sijla.mla.a.h.a(d + this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean c(com.sijla.mla.a.r rVar) {
        return rVar.b(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean c_() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r d(double d) {
        return com.sijla.mla.a.h.a(d - this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r d(int i) {
        return com.sijla.mla.a.b.k.a(i, this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean d(com.sijla.mla.a.r rVar) {
        return rVar.b(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r e(double d) {
        return com.sijla.mla.a.h.a(d * this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r e(com.sijla.mla.a.r rVar) {
        return rVar.j(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean e(int i) {
        return this.c <= i;
    }

    @Override // com.sijla.mla.a.r
    public final boolean equals(java.lang.Object obj) {
        return (obj instanceof com.sijla.mla.a.k) && ((com.sijla.mla.a.k) obj).c == this.c;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r f(double d) {
        return com.sijla.mla.a.b.k.a(d, this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r f(com.sijla.mla.a.r rVar) {
        return rVar.k(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean f(int i) {
        return this.c > i;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r g(double d) {
        return com.sijla.mla.a.h.a(d, this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r g(com.sijla.mla.a.r rVar) {
        return rVar.a_(this.c);
    }

    @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
    public final java.lang.String g() {
        return java.lang.Integer.toString(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean g(int i) {
        return this.c >= i;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r h(double d) {
        return com.sijla.mla.a.h.b(d, this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r h(com.sijla.mla.a.r rVar) {
        return rVar.d(this.c);
    }

    public final int hashCode() {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r i(com.sijla.mla.a.r rVar) {
        return rVar.g(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean i(double d) {
        return ((double) this.c) <= d;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j(int i) {
        return a(i + this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j(com.sijla.mla.a.r rVar) {
        return rVar.h(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean j(double d) {
        return ((double) this.c) > d;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r k(int i) {
        return a(i - this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean k(double d) {
        return ((double) this.c) >= d;
    }

    @Override // com.sijla.mla.a.r
    public final boolean k(com.sijla.mla.a.r rVar) {
        return rVar.f(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean l(com.sijla.mla.a.r rVar) {
        return rVar.g(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean m(com.sijla.mla.a.r rVar) {
        return rVar.e(this.c);
    }

    @Override // com.sijla.mla.a.r
    public final boolean n() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final double o() {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final int p() {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final long q() {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r r() {
        return a(-this.c);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n s() {
        return com.sijla.mla.a.n.c(java.lang.Integer.toString(this.c));
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r t() {
        return com.sijla.mla.a.n.c(java.lang.Integer.toString(this.c));
    }

    @Override // com.sijla.mla.a.m, com.sijla.mla.a.r
    public final boolean v() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final int x() {
        return this.c;
    }

    @Override // com.sijla.mla.a.r
    public final long y() {
        return this.c;
    }
}
