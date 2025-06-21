package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class bb {
    int a;
    com.anythink.core.common.f.q.a b;
    private com.anythink.core.common.f.h c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private double i;
    private double j;
    private double k;
    private double l;
    private int m;

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        if (map == null) {
            return "";
        }
        java.lang.Object obj = map.get(str);
        return (!(obj instanceof java.lang.String) && obj == null) ? "" : obj.toString();
    }

    public final com.anythink.core.common.f.q.a a() {
        return this.b;
    }

    public final void a(double d) {
        this.i = d;
    }

    public final void a(com.anythink.core.common.f.au auVar) {
        this.h = "0";
        if (auVar == null) {
            return;
        }
        int m = auVar.m();
        if (m == 2) {
            this.h = "2";
        } else if (m == 5 || m == 6) {
            this.h = "3";
        } else {
            this.h = "1";
        }
        this.m = auVar.ay();
    }

    public final void a(com.anythink.core.common.f.h hVar) {
        this.c = hVar;
    }

    public final void a(java.lang.String str) {
        this.f = str;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.d = a(map, "offer_id");
        this.e = a(map, "dsp_id");
        if (map != null) {
            java.lang.Object obj = map.get(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.WS_IMP_SWITCH);
            if (obj instanceof java.lang.Integer) {
                java.lang.Integer num = (java.lang.Integer) obj;
                if (num.intValue() != 0) {
                    this.a = num.intValue();
                }
            }
            java.lang.Object obj2 = map.get(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.WS_ACTION);
            if (obj2 instanceof com.anythink.core.common.f.q.a) {
                this.b = (com.anythink.core.common.f.q.a) obj2;
            }
        }
    }

    public final int b() {
        return this.a;
    }

    public final void b(double d) {
        this.j = d;
    }

    public final void b(java.lang.String str) {
        this.g = str;
    }

    public final java.lang.String c() {
        return this.d;
    }

    public final void c(double d) {
        this.k = d;
    }

    public final java.lang.String d() {
        return this.e;
    }

    public final void d(double d) {
        this.l = d;
    }

    public final java.lang.String e() {
        return this.f;
    }

    public final java.lang.String f() {
        return this.g;
    }

    public final java.lang.String g() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.j() : "";
    }

    public final java.lang.String h() {
        return this.h;
    }

    public final java.lang.String i() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.ad() : "";
    }

    public final java.lang.String j() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? java.lang.String.valueOf(hVar.N()) : "";
    }

    public final java.lang.String k() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? java.lang.String.valueOf(hVar.aa()) : "";
    }

    public final java.lang.String l() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.ac() : "";
    }

    public final int m() {
        com.anythink.core.common.f.h hVar = this.c;
        if (hVar != null) {
            return hVar.M();
        }
        return 0;
    }

    public final java.lang.String n() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.C() : "";
    }

    public final java.lang.String o() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.ab() : "";
    }

    public final java.lang.String p() {
        com.anythink.core.common.f.h hVar = this.c;
        if (hVar != null) {
            return hVar.ae();
        }
        return null;
    }

    public final double q() {
        return this.i;
    }

    public final double r() {
        return this.j;
    }

    public final double s() {
        return this.k;
    }

    public final double t() {
        return this.l;
    }

    public final int u() {
        return this.m;
    }

    public final boolean v() {
        return this.m == 1;
    }
}
