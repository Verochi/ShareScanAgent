package com.igexin.push.c;

/* loaded from: classes23.dex */
public class c {
    private static final java.lang.String a = com.igexin.push.c.b.a + com.igexin.push.c.c.class.getName();
    private static com.igexin.push.c.c b;
    private static int c;

    private c() {
        c = com.igexin.push.h.c.b() ? com.igexin.push.c.b.EnumC0371b.a : com.igexin.push.c.b.EnumC0371b.b;
    }

    public static synchronized com.igexin.push.c.c a() {
        com.igexin.push.c.c cVar;
        synchronized (com.igexin.push.c.c.class) {
            if (b == null) {
                b = new com.igexin.push.c.c();
            }
            cVar = b;
        }
        return cVar;
    }

    public static void b() {
        if (com.igexin.push.config.SDKUrlConfig.hasMultipleXfr()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.c.f.g(), false, true);
            return;
        }
        com.igexin.c.a.c.a.a(a + "|xfr len = 1, detect = false", new java.lang.Object[0]);
    }

    public final void c() {
        if (com.igexin.push.config.SDKUrlConfig.hasMultipleXfr()) {
            try {
                f().e();
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public final com.igexin.push.c.a d() {
        return f().d;
    }

    public final void e() {
        if (com.igexin.push.config.SDKUrlConfig.hasMultipleXfr()) {
            try {
                com.igexin.push.c.j.a();
                com.igexin.push.c.h.k();
                com.igexin.push.c.j.a().g();
                com.igexin.push.c.g.a().g();
                com.igexin.push.c.h f = f();
                if (f != null) {
                    f.i();
                    return;
                }
                return;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return;
            }
        }
        com.igexin.push.c.j.a().f();
        com.igexin.push.c.g.a().f();
        com.igexin.push.c.f.g().i();
        try {
            com.igexin.push.c.g.a().d.a((java.util.List<com.igexin.push.c.a.b>) null);
            com.igexin.push.c.j.a().d.a((java.util.List<com.igexin.push.c.a.b>) null);
            com.igexin.push.c.j.a().h();
            com.igexin.push.c.g.a().h();
            com.igexin.push.c.j.a();
            com.igexin.push.c.h.k();
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
    }

    public final synchronized com.igexin.push.c.h f() {
        com.igexin.push.c.h a2;
        com.igexin.push.c.h a3;
        a2 = com.igexin.push.h.c.b() ? com.igexin.push.c.j.a() : com.igexin.push.c.g.a();
        int c2 = a2.c();
        if (c2 != c) {
            if (c2 == com.igexin.push.c.b.EnumC0371b.a) {
                a3 = com.igexin.push.c.g.a();
            } else if (c2 == com.igexin.push.c.b.EnumC0371b.b) {
                a3 = com.igexin.push.c.j.a();
            }
            a3.f();
        }
        c = c2;
        return a2;
    }
}
