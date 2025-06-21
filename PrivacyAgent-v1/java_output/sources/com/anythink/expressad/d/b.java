package com.anythink.expressad.d;

/* loaded from: classes12.dex */
public class b {
    public static final java.lang.String a = "b";
    public static final int b = 500;
    public static final java.lang.String c = "anythink";
    private static volatile com.anythink.expressad.d.b d;
    private static java.util.HashMap<java.lang.String, com.anythink.expressad.d.c> e = new java.util.HashMap<>();
    private static com.anythink.expressad.d.a f = null;

    private b() {
    }

    public static com.anythink.expressad.d.b a() {
        if (d == null) {
            synchronized (com.anythink.expressad.d.b.class) {
                if (d == null) {
                    d = new com.anythink.expressad.d.b();
                }
            }
        }
        return d;
    }

    public static com.anythink.expressad.d.c a(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.d.c c2 = c(str, str2);
        return c2 == null ? new com.anythink.expressad.d.c() : c2;
    }

    public static java.lang.String a(java.lang.String str) {
        return str == null ? "" : b().R();
    }

    private static void a(android.content.Context context, java.lang.String str) {
        try {
            java.util.Map<java.lang.String, ?> all = context.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0).getAll();
            for (java.lang.String str2 : all.keySet()) {
                if (str2.startsWith(str + "_")) {
                    e.put(str2, com.anythink.expressad.d.c.b((java.lang.String) all.get(str2)));
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str + "_" + str2;
        com.anythink.expressad.foundation.a.a.a.a().a(str4, str3);
        e.put(str4, com.anythink.expressad.d.c.b(str3));
    }

    public static com.anythink.expressad.d.a b() {
        if (f == null) {
            f = c();
        }
        return f;
    }

    public static com.anythink.expressad.d.c b(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.d.c g = g(str, str2);
        return g == null ? new com.anythink.expressad.d.c() : g;
    }

    public static java.lang.String b(java.lang.String str) {
        return com.anythink.expressad.foundation.a.a.a.a().a("ivreward_".concat(java.lang.String.valueOf(str)));
    }

    public static com.anythink.expressad.d.a c() {
        com.anythink.expressad.d.a aVar = new com.anythink.expressad.d.a();
        aVar.A();
        aVar.B();
        aVar.y();
        aVar.z();
        aVar.w();
        aVar.u();
        aVar.m();
        aVar.a("anythink");
        aVar.j();
        aVar.p();
        aVar.o();
        aVar.s();
        aVar.e();
        aVar.d();
        aVar.f();
        aVar.g();
        aVar.h();
        aVar.i();
        aVar.c();
        aVar.c(com.anythink.expressad.d.a.b.df);
        aVar.a(120);
        aVar.O();
        aVar.N();
        aVar.a(100);
        aVar.Q();
        aVar.e(com.anythink.expressad.foundation.g.a.cH);
        aVar.d(com.anythink.expressad.foundation.g.a.cJ);
        aVar.c(com.anythink.expressad.foundation.g.a.cI);
        aVar.a();
        aVar.f(com.anythink.expressad.foundation.g.a.cO);
        aVar.b(10);
        return aVar;
    }

    public static com.anythink.expressad.d.c c(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.d.c g = g(str, str2);
        if (g != null && g.k() == 0) {
            g.l();
        }
        return g;
    }

    public static void c(java.lang.String str) {
        com.anythink.expressad.foundation.a.a.a.a().b("ivreward_".concat(java.lang.String.valueOf(str)));
    }

    private static com.anythink.expressad.d.c d(java.lang.String str) {
        com.anythink.expressad.d.c cVar = new com.anythink.expressad.d.c();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        cVar.v();
        cVar.u();
        cVar.a(str);
        cVar.a(arrayList);
        cVar.b(arrayList2);
        cVar.p();
        cVar.r();
        cVar.q();
        cVar.o();
        cVar.n();
        cVar.j();
        cVar.l();
        cVar.c(100);
        cVar.d(0);
        cVar.h();
        cVar.e();
        cVar.c();
        cVar.w();
        cVar.x();
        return cVar;
    }

    public static com.anythink.expressad.d.c d(java.lang.String str, java.lang.String str2) {
        return g(str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.foundation.a.a.a.a().a("ivreward_".concat(java.lang.String.valueOf(str)), str2);
    }

    private static void f(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.foundation.a.a.a.a().a(str, str2);
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.a.b(str2);
        f = b2;
        if (b2 != null) {
            b2.G();
        }
    }

    private static com.anythink.expressad.d.c g(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.anythink.expressad.foundation.b.a.b().e();
        }
        java.lang.String str3 = str + "_" + str2;
        if (e.containsKey(str3)) {
            return e.get(str3);
        }
        return null;
    }
}
