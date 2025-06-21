package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class y {
    double a;
    private int b;
    private com.anythink.core.common.f.h c;
    private boolean d;
    private double e;
    private java.lang.String f;
    private int g;

    public y(int i, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar) {
        this.b = i;
        this.d = auVar.Y();
        this.e = com.anythink.core.b.d.a.b(auVar);
        if (hVar != null) {
            com.anythink.core.common.f.h S = hVar.S();
            this.c = S;
            com.anythink.core.common.o.u.a(S, auVar, 0, false);
        }
        this.f = "0";
        int m = auVar.m();
        if (m == 2) {
            this.f = "2";
        } else if (m == 5 || m == 6) {
            this.f = "3";
        } else {
            this.f = "1";
        }
        this.g = auVar.az();
    }

    public y(int i, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar, double d) {
        this(i, auVar, hVar);
        this.a = d;
    }

    private void a(com.anythink.core.common.f.au auVar) {
        this.f = "0";
        if (auVar == null) {
            return;
        }
        int m = auVar.m();
        if (m == 2) {
            this.f = "2";
        } else if (m == 5 || m == 6) {
            this.f = "3";
        } else {
            this.f = "1";
        }
        this.g = auVar.az();
    }

    private int r() {
        com.anythink.core.common.f.h hVar = this.c;
        if (hVar != null) {
            return hVar.f();
        }
        return 0;
    }

    public final boolean a() {
        return this.d;
    }

    public final double b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final java.lang.String d() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.ad() : "";
    }

    public final java.lang.String e() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? java.lang.String.valueOf(hVar.N()) : "";
    }

    public final java.lang.String f() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? java.lang.String.valueOf(hVar.aa()) : "";
    }

    public final java.lang.String g() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.ac() : "";
    }

    public final int h() {
        com.anythink.core.common.f.h hVar = this.c;
        if (hVar != null) {
            return hVar.M();
        }
        return 0;
    }

    public final java.lang.String i() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.C() : "";
    }

    public final java.lang.String j() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.ab() : "";
    }

    public final java.lang.String k() {
        com.anythink.core.common.f.h hVar = this.c;
        if (hVar != null) {
            return hVar.ae();
        }
        return null;
    }

    public final java.lang.String l() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.V() : "";
    }

    public final java.lang.String m() {
        com.anythink.core.common.f.h hVar = this.c;
        return hVar != null ? hVar.W() : "";
    }

    public final double n() {
        return this.e;
    }

    public final java.lang.String o() {
        return this.f;
    }

    public final int p() {
        return this.g;
    }

    public final boolean q() {
        return this.g == 1;
    }
}
