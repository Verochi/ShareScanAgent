package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jv {
    public int l;
    public boolean o;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public long e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = -113;
    public short m = 0;
    public long n = 0;
    public int p = 32767;
    public int q = Integer.MAX_VALUE;
    public int r = Integer.MAX_VALUE;

    public jv(int i, boolean z) {
        this.l = i;
        this.o = z;
    }

    private long c() {
        return this.l == 5 ? this.e : this.d;
    }

    private java.lang.String d() {
        int i = this.l;
        return this.l + "#" + this.a + "#" + this.b + "#0#" + c();
    }

    private java.lang.String e() {
        return this.l + "#" + this.h + "#" + this.i + "#" + this.j;
    }

    public final int a() {
        return this.k;
    }

    public final java.lang.String b() {
        int i = this.l;
        if (i != 1) {
            if (i == 2) {
                return e();
            }
            if (i != 3 && i != 4 && i != 5) {
                return null;
            }
        }
        return d();
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.amap.api.mapcore.util.jv)) {
            com.amap.api.mapcore.util.jv jvVar = (com.amap.api.mapcore.util.jv) obj;
            int i = jvVar.l;
            if (i != 1) {
                return i != 2 ? i != 3 ? i != 4 ? i == 5 && this.l == 5 && jvVar.c == this.c && jvVar.e == this.e && jvVar.r == this.r : this.l == 4 && jvVar.c == this.c && jvVar.d == this.d && jvVar.b == this.b : this.l == 3 && jvVar.c == this.c && jvVar.d == this.d && jvVar.b == this.b : this.l == 2 && jvVar.j == this.j && jvVar.i == this.i && jvVar.h == this.h;
            }
            if (this.l == 1 && jvVar.c == this.c && jvVar.d == this.d && jvVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i;
        int hashCode2 = java.lang.String.valueOf(this.l).hashCode();
        if (this.l == 2) {
            hashCode = java.lang.String.valueOf(this.j).hashCode() + java.lang.String.valueOf(this.i).hashCode();
            i = this.h;
        } else {
            hashCode = java.lang.String.valueOf(this.c).hashCode() + java.lang.String.valueOf(this.d).hashCode();
            i = this.b;
        }
        return hashCode2 + hashCode + java.lang.String.valueOf(i).hashCode();
    }

    public final java.lang.String toString() {
        int i = this.l;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : java.lang.String.format(java.util.Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s,  sig=%d, age=%d, reg=%b, pci=%d", java.lang.Integer.valueOf(this.c), java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(this.b), java.lang.Integer.valueOf(this.k), java.lang.Short.valueOf(this.m), java.lang.Boolean.valueOf(this.o), java.lang.Integer.valueOf(this.p)) : java.lang.String.format(java.util.Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, sig=%d, age=%d, reg=%b, pci=%d", java.lang.Integer.valueOf(this.c), java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(this.b), java.lang.Integer.valueOf(this.k), java.lang.Short.valueOf(this.m), java.lang.Boolean.valueOf(this.o), java.lang.Integer.valueOf(this.p)) : java.lang.String.format(java.util.Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d,  sig=%d, age=%d, reg=%b", java.lang.Integer.valueOf(this.j), java.lang.Integer.valueOf(this.i), java.lang.Integer.valueOf(this.h), java.lang.Integer.valueOf(this.k), java.lang.Short.valueOf(this.m), java.lang.Boolean.valueOf(this.o)) : java.lang.String.format(java.util.Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s,  sig=%d, age=%d, reg=%b", java.lang.Integer.valueOf(this.c), java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(this.b), java.lang.Integer.valueOf(this.k), java.lang.Short.valueOf(this.m), java.lang.Boolean.valueOf(this.o));
    }
}
