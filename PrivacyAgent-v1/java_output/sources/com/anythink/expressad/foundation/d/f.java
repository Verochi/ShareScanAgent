package com.anythink.expressad.foundation.d;

/* loaded from: classes12.dex */
public final class f {
    public static final java.lang.String a = "cid";
    public static final java.lang.String b = "click_type";
    public static final java.lang.String c = "network_type";
    public static final java.lang.String d = "network_str";
    public static final java.lang.String e = "click_duration";
    public static final java.lang.String f = "last_url";
    public static final java.lang.String g = "type";
    public static final java.lang.String h = "code";
    public static final java.lang.String i = "exception";
    public static final java.lang.String j = "header";
    public static final java.lang.String k = "content";
    public static final java.lang.String l = "network_type";
    public static final java.lang.String m = "rid";
    public static final java.lang.String n = "key";
    public static final java.lang.String o = "rid_n";
    public static final java.lang.String p = "unit_id";
    public static final java.lang.String q = "landing_type";
    public static final java.lang.String r = "link_type";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f239s = "click_time";
    public static final java.lang.String t = "market_result";
    public static final java.lang.String u = "2000013";
    public static final java.lang.String v = "2000012";
    private java.lang.String A;
    private int B;
    private java.lang.String C;
    private java.lang.String D;
    private java.lang.String E;
    private int F;
    private int G;
    private java.lang.String H;
    private int I;
    private int J;
    private java.lang.String K;
    private int L;
    private java.lang.String M;
    private int N;
    private int w;
    private java.lang.String x;
    private java.lang.String y;
    private java.lang.String z;

    public f() {
    }

    private f(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, java.lang.String str5, java.lang.String str6, java.lang.String str7, int i3, int i4, java.lang.String str8, int i5, int i6, java.lang.String str9, int i7, int i8, java.lang.String str10) {
        this.x = str;
        this.y = str2;
        this.z = str3;
        this.A = str4;
        this.B = i2;
        this.C = str5;
        this.D = str6;
        this.E = str7;
        this.F = i3;
        this.G = i4;
        this.H = str8;
        this.I = i5;
        this.J = i6;
        this.K = str9;
        this.L = i7;
        this.M = str10;
        this.N = i8;
    }

    private static java.lang.String a(com.anythink.expressad.foundation.d.f fVar) {
        if (fVar == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = fVar.A;
        sb.append("rid_n=" + fVar.x);
        sb.append("&click_type=" + fVar.G);
        sb.append("&type=" + fVar.F);
        sb.append("&cid=" + fVar.y);
        sb.append("&click_duration=" + fVar.z);
        sb.append("&key=2000012");
        sb.append("&unit_id=" + fVar.H);
        sb.append("&last_url=".concat(java.lang.String.valueOf(str)));
        sb.append("&code=" + fVar.B);
        sb.append("&exception=" + fVar.C);
        sb.append("&landing_type=" + fVar.I);
        sb.append("&link_type=" + fVar.J);
        sb.append("&click_time=" + fVar.K + "\n");
        return sb.toString();
    }

    public static java.lang.String a(java.util.List<com.anythink.expressad.foundation.d.f> list) {
        if (list.size() <= 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.anythink.expressad.foundation.d.f fVar : list) {
            sb.append("rid_n=" + fVar.x);
            sb.append("&cid=" + fVar.y);
            sb.append("&click_type=" + fVar.G);
            sb.append("&type=" + fVar.F);
            sb.append("&click_duration=" + fVar.z);
            sb.append("&key=2000013");
            sb.append("&unit_id=" + fVar.H);
            sb.append("&last_url=" + fVar.A);
            sb.append("&content=" + fVar.E);
            sb.append("&code=" + fVar.B);
            sb.append("&exception=" + fVar.C);
            sb.append("&header=" + fVar.D);
            sb.append("&landing_type=" + fVar.I);
            sb.append("&link_type=" + fVar.J);
            sb.append("&click_time=" + fVar.K + "\n");
        }
        return sb.toString();
    }

    private int b() {
        return this.N;
    }

    private int c() {
        return this.L;
    }

    private java.lang.String d() {
        return this.M;
    }

    private java.lang.String e() {
        return this.H;
    }

    private void e(int i2) {
        this.N = i2;
    }

    private int f() {
        return this.I;
    }

    private void f(int i2) {
        this.L = i2;
    }

    private int g() {
        return this.J;
    }

    private void g(int i2) {
        this.w = i2;
    }

    private java.lang.String h() {
        return this.K;
    }

    private int i() {
        return this.G;
    }

    private java.lang.String j() {
        return this.C;
    }

    private void j(java.lang.String str) {
        this.M = str;
    }

    private int k() {
        return this.B;
    }

    private java.lang.String l() {
        return this.D;
    }

    private java.lang.String m() {
        return this.E;
    }

    private int n() {
        return this.F;
    }

    private java.lang.String o() {
        return this.A;
    }

    private java.lang.String p() {
        return this.y;
    }

    private java.lang.String q() {
        return this.z;
    }

    private int r() {
        return this.w;
    }

    private java.lang.String s() {
        return this.x;
    }

    public final void a() {
        this.G = 1;
    }

    public final void a(int i2) {
        this.I = i2;
    }

    public final void a(java.lang.String str) {
        this.H = str;
    }

    public final void b(int i2) {
        this.J = i2;
    }

    public final void b(java.lang.String str) {
        this.K = str;
    }

    public final void c(int i2) {
        this.B = i2;
    }

    public final void c(java.lang.String str) {
        this.C = str;
    }

    public final void d(int i2) {
        this.F = i2;
    }

    public final void d(java.lang.String str) {
        this.D = str;
    }

    public final void e(java.lang.String str) {
        this.E = str;
    }

    public final void f(java.lang.String str) {
        this.A = str;
    }

    public final void g(java.lang.String str) {
        this.y = str;
    }

    public final void h(java.lang.String str) {
        this.z = str;
    }

    public final void i(java.lang.String str) {
        this.x = str;
    }

    public final java.lang.String toString() {
        return "ClickTime [campaignId=" + this.y + ", click_duration=" + this.z + ", lastUrl=" + this.A + ", code=" + this.B + ", excepiton=" + this.C + ", header=" + this.D + ", content=" + this.E + ", type=" + this.F + ", click_type=" + this.G + "]";
    }
}
