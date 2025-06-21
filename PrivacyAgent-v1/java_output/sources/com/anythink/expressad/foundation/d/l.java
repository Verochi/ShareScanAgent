package com.anythink.expressad.foundation.d;

/* loaded from: classes12.dex */
public final class l {
    public static final java.lang.String a = "key";
    public static final java.lang.String b = "time";
    public static final java.lang.String c = "ad_source_id";
    public static final java.lang.String d = "num";
    public static final java.lang.String e = "unit_id";
    public static final java.lang.String f = "fb";
    public static final java.lang.String g = "timeout";
    public static final java.lang.String h = "network_type";
    public static final java.lang.String i = "network_str";
    public static final java.lang.String j = "2000006";
    public static final java.lang.String k = "hb";
    private int l;
    private java.lang.String m;
    private int n;
    private java.lang.String o;
    private int p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f241s;
    private int t;
    private java.lang.String u;

    public l() {
    }

    private l(int i2, java.lang.String str, int i3, java.lang.String str2, int i4, int i5, int i6) {
        this.l = i2;
        this.m = str;
        this.n = i3;
        this.o = str2;
        this.p = i4;
        this.q = i5;
        this.r = i6;
    }

    private int a() {
        return this.t;
    }

    private static java.lang.String a(java.util.List<com.anythink.expressad.foundation.d.l> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (com.anythink.expressad.foundation.d.l lVar : list) {
            stringBuffer.append("ad_source_id=" + lVar.l);
            stringBuffer.append("&time=" + lVar.m);
            stringBuffer.append("&num=" + lVar.n);
            stringBuffer.append("&unit_id=" + lVar.o);
            stringBuffer.append("&key=2000006");
            stringBuffer.append("&fb=" + lVar.p);
            if (lVar.t == 1) {
                stringBuffer.append("&hb=1");
            }
            stringBuffer.append("&timeout=" + lVar.q + "\n");
        }
        return stringBuffer.toString();
    }

    private void a(int i2) {
        this.t = i2;
    }

    private void a(java.lang.String str) {
        this.m = str;
    }

    private int b() {
        return this.l;
    }

    private void b(int i2) {
        this.l = i2;
    }

    private void b(java.lang.String str) {
        this.u = str;
    }

    private java.lang.String c() {
        return this.m;
    }

    private void c(int i2) {
        this.n = i2;
    }

    private void c(java.lang.String str) {
        this.o = str;
    }

    private java.lang.String d() {
        return this.u;
    }

    private void d(int i2) {
        this.p = i2;
    }

    private void d(java.lang.String str) {
        this.f241s = str;
    }

    private int e() {
        return this.n;
    }

    private void e(int i2) {
        this.q = i2;
    }

    private java.lang.String f() {
        return this.o;
    }

    private void f(int i2) {
        this.r = i2;
    }

    private int g() {
        return this.p;
    }

    private int h() {
        return this.q;
    }

    private int i() {
        return this.r;
    }

    private java.lang.String j() {
        return this.f241s;
    }
}
