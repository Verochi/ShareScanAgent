package com.anythink.expressad.mbbanner.a.b;

/* loaded from: classes12.dex */
public final class c {
    public static final java.lang.String a = "2000067";
    public static final java.lang.String b = "2000068";
    public static final java.lang.String c = "2000069";
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private int l;
    private boolean m;

    private c() {
    }

    private static com.anythink.expressad.mbbanner.a.b.c a() {
        return new com.anythink.expressad.mbbanner.a.b.c();
    }

    private com.anythink.expressad.mbbanner.a.b.c a(int i) {
        this.l = i;
        return this;
    }

    private com.anythink.expressad.mbbanner.a.b.c a(java.lang.String str) {
        this.d = str;
        return this;
    }

    private com.anythink.expressad.mbbanner.a.b.c a(boolean z) {
        this.m = z;
        return this;
    }

    private com.anythink.expressad.mbbanner.a.b.c b(java.lang.String str) {
        this.e = str;
        return this;
    }

    private java.lang.String b() {
        return this.d;
    }

    private com.anythink.expressad.mbbanner.a.b.c c(java.lang.String str) {
        this.f = str;
        return this;
    }

    private java.lang.String c() {
        return this.e;
    }

    private com.anythink.expressad.mbbanner.a.b.c d(java.lang.String str) {
        this.g = str;
        return this;
    }

    private java.lang.String d() {
        return this.f;
    }

    private com.anythink.expressad.mbbanner.a.b.c e(java.lang.String str) {
        this.h = str;
        return this;
    }

    private java.lang.String e() {
        return this.g;
    }

    private com.anythink.expressad.mbbanner.a.b.c f(java.lang.String str) {
        this.i = str;
        return this;
    }

    private java.lang.String f() {
        return this.h;
    }

    private com.anythink.expressad.mbbanner.a.b.c g(java.lang.String str) {
        this.j = str;
        return this;
    }

    private java.lang.String g() {
        return this.i;
    }

    private com.anythink.expressad.mbbanner.a.b.c h(java.lang.String str) {
        this.k = str;
        return this;
    }

    private java.lang.String h() {
        return this.j;
    }

    private java.lang.String i() {
        return this.k;
    }

    private int j() {
        return this.l;
    }

    private java.lang.String k() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(this.e)) {
            sb.append("unit_id=");
            sb.append(this.e);
            sb.append("&");
        }
        if (!android.text.TextUtils.isEmpty(this.g)) {
            sb.append("cid=");
            sb.append(this.g);
            sb.append("&");
        }
        if (!android.text.TextUtils.isEmpty(this.h)) {
            sb.append("rid=");
            sb.append(this.h);
            sb.append("&");
        }
        if (!android.text.TextUtils.isEmpty(this.i)) {
            sb.append("rid_n=");
            sb.append(this.i);
            sb.append("&");
        }
        if (!android.text.TextUtils.isEmpty(this.j)) {
            sb.append("creative_id=");
            sb.append(this.j);
            sb.append("&");
        }
        if (!android.text.TextUtils.isEmpty(this.k)) {
            sb.append("reason=");
            sb.append(this.k);
            sb.append("&");
        }
        if (this.l != 0) {
            sb.append("result=");
            sb.append(this.l);
            sb.append("&");
        }
        if (this.m) {
            sb.append("hb=1&");
        }
        sb.append("network_type=");
        com.anythink.core.common.b.o.a().f();
        sb.append(com.anythink.expressad.foundation.h.k.a());
        sb.append("&");
        if (!android.text.TextUtils.isEmpty(this.d)) {
            sb.append("key=");
            sb.append(this.d);
        }
        return sb.toString();
    }
}
