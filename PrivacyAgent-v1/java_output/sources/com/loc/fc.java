package com.loc;

/* loaded from: classes23.dex */
public final class fc {
    public int l;
    public boolean n;
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
    public int o = 32767;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;
    public boolean r = true;

    /* renamed from: s, reason: collision with root package name */
    public int f406s = 99;
    public long t = 0;

    public fc(int i, boolean z) {
        this.l = i;
        this.n = z;
    }

    private java.lang.String e() {
        int i = this.l;
        return this.l + "#" + this.a + "#" + this.b + "#0#" + a();
    }

    private java.lang.String f() {
        return this.l + "#" + this.h + "#" + this.i + "#" + this.j;
    }

    public final long a() {
        return this.l == 5 ? this.e : this.d;
    }

    public final java.lang.String b() {
        int i = this.l;
        if (i != 1) {
            if (i == 2) {
                return f();
            }
            if (i != 3 && i != 4 && i != 5) {
                return null;
            }
        }
        return e();
    }

    public final java.lang.String c() {
        java.lang.String b = b();
        if (b == null || b.length() <= 0) {
            return "";
        }
        return (this.r ? 1 : 0) + "#" + b;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final com.loc.fc clone() {
        com.loc.fc fcVar = new com.loc.fc(this.l, this.n);
        fcVar.a = this.a;
        fcVar.b = this.b;
        fcVar.c = this.c;
        fcVar.d = this.d;
        fcVar.e = this.e;
        fcVar.f = this.f;
        fcVar.g = this.g;
        fcVar.h = this.h;
        fcVar.i = this.i;
        fcVar.j = this.j;
        fcVar.k = this.k;
        fcVar.m = this.m;
        fcVar.o = this.o;
        fcVar.p = this.p;
        fcVar.q = this.q;
        fcVar.r = this.r;
        fcVar.f406s = this.f406s;
        fcVar.t = this.t;
        return fcVar;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.loc.fc)) {
            com.loc.fc fcVar = (com.loc.fc) obj;
            int i = fcVar.l;
            if (i != 1) {
                return i != 2 ? i != 3 ? i != 4 ? i == 5 && this.l == 5 && fcVar.c == this.c && fcVar.e == this.e && fcVar.q == this.q : this.l == 4 && fcVar.c == this.c && fcVar.d == this.d && fcVar.b == this.b : this.l == 3 && fcVar.c == this.c && fcVar.d == this.d && fcVar.b == this.b : this.l == 2 && fcVar.j == this.j && fcVar.i == this.i && fcVar.h == this.h;
            }
            if (this.l == 1 && fcVar.c == this.c && fcVar.d == this.d && fcVar.b == this.b) {
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
}
