package com.anythink.core.common;

/* loaded from: classes12.dex */
public class h {
    private static volatile com.anythink.core.common.h a;

    private h() {
    }

    public static com.anythink.core.common.h a() {
        if (a == null) {
            synchronized (com.anythink.core.common.h.class) {
                if (a == null) {
                    a = new com.anythink.core.common.h();
                }
            }
        }
        return a;
    }

    public static java.lang.String a(com.anythink.core.d.e eVar) {
        java.lang.String D = eVar.D();
        return android.text.TextUtils.isEmpty(D) ? "" : D;
    }

    public static java.lang.String a(com.anythink.core.d.e eVar, boolean z) {
        if (!com.anythink.core.common.e.c.a().b() && z) {
            java.lang.String H = eVar.H();
            eVar.aw();
            if (!android.text.TextUtils.isEmpty(H)) {
                return H;
            }
        }
        com.anythink.core.common.f.t z2 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()).z();
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.y : com.anythink.core.common.b.h.d.k;
        return z2 != null ? a(z2.c(), str) : str;
    }

    private static java.lang.String a(java.lang.String str) {
        return str;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return android.text.TextUtils.isEmpty(str) ? str2 : str;
    }

    public static java.lang.String b() {
        return com.anythink.core.common.e.c.a().a(m() ? com.anythink.core.common.b.h.d.t : com.anythink.core.common.b.h.d.f);
    }

    public static java.lang.String b(com.anythink.core.d.e eVar) {
        return eVar.C();
    }

    public static java.lang.String c() {
        return com.anythink.core.common.e.c.a().a(m() ? com.anythink.core.common.b.h.d.u : com.anythink.core.common.b.h.d.g);
    }

    public static java.lang.String d() {
        return m() ? com.anythink.core.common.b.h.d.x : com.anythink.core.common.b.h.d.j;
    }

    public static java.lang.String e() {
        return m() ? com.anythink.core.common.b.h.d.D : com.anythink.core.common.b.h.d.q;
    }

    public static java.lang.String f() {
        com.anythink.core.common.f.t z = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()).z();
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.z : com.anythink.core.common.b.h.d.l;
        return z != null ? a(z.b(), str) : str;
    }

    public static java.lang.String g() {
        com.anythink.core.common.f.t z = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()).z();
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.A : com.anythink.core.common.b.h.d.m;
        return z != null ? a(z.d(), str) : str;
    }

    public static java.lang.String h() {
        com.anythink.core.common.f.t z = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()).z();
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.B : com.anythink.core.common.b.h.d.n;
        return z != null ? a(z.a(), str) : str;
    }

    public static java.lang.String i() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.C : com.anythink.core.common.b.h.d.p;
        return b != null ? a(b.w(), str) : str;
    }

    public static java.lang.String j() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.w : com.anythink.core.common.b.h.d.i;
        return b != null ? a(b.ah(), str) : str;
    }

    public static java.lang.String k() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        java.lang.String str = m() ? com.anythink.core.common.b.h.d.v : com.anythink.core.common.b.h.d.h;
        return b != null ? a(b.am(), str) : str;
    }

    public static java.lang.String l() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        return b != null ? a(b.ad(), "") : "";
    }

    private static boolean m() {
        return com.anythink.core.common.b.o.a().D() && com.anythink.core.common.b.o.a().C();
    }
}
