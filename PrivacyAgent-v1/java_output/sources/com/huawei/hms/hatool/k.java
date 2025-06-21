package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class k {
    public boolean a;
    public boolean b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public com.huawei.hms.hatool.j g;
    public java.lang.String h;
    public java.util.Map<java.lang.String, java.lang.String> i;
    public java.lang.String j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public java.lang.String p;
    public long q;

    public k() {
        this.e = "";
        this.f = "";
        this.g = new com.huawei.hms.hatool.j();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
    }

    public k(com.huawei.hms.hatool.k kVar) {
        this.e = "";
        this.f = "";
        this.g = new com.huawei.hms.hatool.j();
        this.h = "";
        this.j = "";
        this.k = 10;
        this.l = 7;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
        this.g = kVar.g;
        b(kVar.a);
        a(kVar.c);
        b(kVar.d);
        e(kVar.e);
        g(kVar.f);
        d(kVar.h);
        f(kVar.j);
        c(kVar.b);
        a(kVar.k);
        b(kVar.l);
        d(kVar.m);
        a(kVar.n);
        e(kVar.o);
        a(kVar.i);
        c(kVar.p);
        a(kVar.q);
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(java.lang.String str) {
        this.c = str;
    }

    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.i = map;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.k;
    }

    public void b(int i) {
        this.l = i;
    }

    public void b(java.lang.String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public void c(java.lang.String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.l;
    }

    public void d(java.lang.String str) {
        this.h = str;
    }

    public void d(boolean z) {
        this.m = z;
    }

    public void e(java.lang.String str) {
        this.e = str;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public boolean e() {
        return this.b;
    }

    public java.lang.String f() {
        return this.c;
    }

    public void f(java.lang.String str) {
        this.j = str;
    }

    public void g(java.lang.String str) {
        this.f = str;
    }

    public boolean g() {
        return this.m;
    }

    public java.lang.String h() {
        return this.d;
    }

    public boolean i() {
        return this.o;
    }

    public com.huawei.hms.hatool.j j() {
        return this.g;
    }

    public java.util.Map<java.lang.String, java.lang.String> k() {
        return this.i;
    }

    public long l() {
        return this.q;
    }

    public java.lang.String m() {
        return this.p;
    }

    public java.lang.String n() {
        return this.h;
    }

    public java.lang.String o() {
        return this.e;
    }

    public java.lang.String p() {
        return this.j;
    }

    public java.lang.String q() {
        return this.f;
    }
}
