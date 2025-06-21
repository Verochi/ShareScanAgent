package com.igexin.push.e;

/* loaded from: classes23.dex */
public class a {
    public static java.lang.String a = "com.igexin.push.e.a";
    public boolean b;

    private int a(java.lang.String str, com.igexin.push.d.c.c cVar) {
        return a(str, cVar, false);
    }

    public static void a(int i) {
        if (i == com.igexin.c.a.b.a.a.j.a) {
            com.igexin.c.a.b.e.a().a(new com.igexin.push.d.b.b());
            com.igexin.c.a.b.e.a().b();
        } else if (i == com.igexin.c.a.b.a.a.j.b) {
            com.igexin.c.a.b.e.a().a(new com.igexin.push.d.b.a());
            com.igexin.c.a.b.e.a().b();
        }
    }

    public static void a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return;
        }
        com.igexin.push.core.a.b.d().a(cVar);
    }

    public static void a(boolean z) {
        com.igexin.c.a.c.a.a(a + "|call -> disconnect, reset delay = " + z, new java.lang.Object[0]);
        if (z) {
            com.igexin.push.core.e.b(0L);
        }
        com.igexin.c.a.b.a.a.d.a().d();
    }

    private void b(boolean z) {
        com.igexin.c.a.c.a.a(a, "call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O);
        com.igexin.c.a.c.a.a(a + "|call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O, new java.lang.Object[0]);
        boolean z2 = this.b;
        if (z2 == z) {
            if (!z2 || com.igexin.push.core.e.u || com.igexin.push.core.e.O <= 1500) {
                return;
            }
            com.igexin.c.a.c.a.a(a + "|start active again, online = false, reset delay", new java.lang.Object[0]);
            com.igexin.push.core.e.b(0L);
            c();
            return;
        }
        this.b = z;
        if (z) {
            com.igexin.c.a.c.a.a(a + "|active = true, start connect~~~~", new java.lang.Object[0]);
            g();
            return;
        }
        com.igexin.c.a.c.a.a(a + "|active = false, disconnect...", new java.lang.Object[0]);
        a(true);
    }

    public static void c() {
        com.igexin.push.core.e.b(com.igexin.push.d.c.b.a.e.a());
        com.igexin.push.g.b.e.g().a(com.igexin.push.core.e.O);
    }

    public static void d() {
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.d);
        boolean e = com.igexin.push.h.c.e();
        com.igexin.c.a.c.a.a(a, "network changed, available = " + e + ", last = " + com.igexin.push.core.e.n);
        com.igexin.c.a.c.a.a(a + "|network changed, available = " + e + ", last = " + com.igexin.push.core.e.n, new java.lang.Object[0]);
        com.igexin.push.d.c.b.a.a();
        if (!e) {
            com.igexin.c.a.c.a.a(a + "|network changed, available = false, do nothing", new java.lang.Object[0]);
            a(false);
        } else if (!com.igexin.push.core.e.n) {
            com.igexin.c.a.c.a.a(a + "|network changed, try connect reset delay", new java.lang.Object[0]);
            g();
        }
        if (e) {
            com.igexin.push.c.c.a().c();
        }
        com.igexin.push.core.e.n = e;
    }

    public static boolean e() {
        return (com.igexin.push.core.e.p && com.igexin.push.core.e.f388s) ? false : true;
    }

    private boolean f() {
        return this.b;
    }

    private static void g() {
        com.igexin.c.a.c.a.a(a + "|call -> tryConnect and reset delay = 0", new java.lang.Object[0]);
        a(true);
    }

    private static void h() {
        com.igexin.push.d.a.c.b = -1;
        if (com.igexin.push.core.e.q) {
            com.igexin.c.a.c.a.a(a, "isAppidWrong = true");
            com.igexin.c.a.c.a.a(a + "|isAppidWrong = true", new java.lang.Object[0]);
            com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
            return;
        }
        if (!com.igexin.push.h.g.a()) {
            com.igexin.c.a.c.a.a(a, "so error ++++++++");
            com.igexin.c.a.c.a.a(a + "|so error ++++++++", new java.lang.Object[0]);
            return;
        }
        if (com.igexin.push.core.e.az) {
            c();
            return;
        }
        com.igexin.c.a.c.a.a(a, "initSuccess = false");
        com.igexin.c.a.c.a.a(a + "|initSuccess = false", new java.lang.Object[0]);
    }

    private static void i() {
        com.igexin.push.c.c.a().d().c();
        com.igexin.push.c.a d = com.igexin.push.c.c.a().d();
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.c);
        d.f();
        if (e()) {
            com.igexin.c.a.c.a.a(a, "sdkOn = false or pushOn = false, disconnect|user");
            com.igexin.c.a.c.a.a(a + "|sdkOn = false or pushOn = false, disconnect|user", new java.lang.Object[0]);
        } else {
            com.igexin.c.a.c.a.a(a + "|disconnect by network", new java.lang.Object[0]);
        }
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.b.e.a().f381s;
        if (eVar != null) {
            eVar.a(com.igexin.c.a.b.a.a.f.class);
        }
        a(false);
    }

    public final int a(java.lang.String str, com.igexin.push.d.c.c cVar, boolean z) {
        if (str == null || cVar == null) {
            return -1;
        }
        if (!com.igexin.push.core.e.u && !(cVar instanceof com.igexin.push.d.c.g) && !(cVar instanceof com.igexin.push.d.c.i) && !(cVar instanceof com.igexin.push.d.c.d)) {
            com.igexin.c.a.c.a.a("networkLayer|sendData|not online|" + cVar.getClass().getName(), new java.lang.Object[0]);
            return -3;
        }
        if (this.b) {
            if (z) {
                int i = com.igexin.push.config.d.f;
                if (com.igexin.c.a.b.e.a().a(com.igexin.push.config.SDKUrlConfig.getConnectAddress(), com.igexin.push.core.d.a.a.g, cVar, i > 0 ? i : 10, new com.igexin.push.d.f()) == null) {
                    return -2;
                }
            } else if (com.igexin.c.a.b.e.a().a(com.igexin.push.config.SDKUrlConfig.getConnectAddress(), com.igexin.push.core.d.a.a.g, cVar) == null) {
                return -2;
            }
        }
        return 0;
    }

    public final void a() {
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.f388s;
        boolean a2 = com.igexin.push.h.c.a();
        if (z && z2 && a2) {
            b(true);
        }
    }

    public final void b() {
        b(false);
        if (com.igexin.push.core.e.u) {
            com.igexin.push.core.e.u = false;
            com.igexin.push.core.l.a().b();
        }
        com.igexin.c.a.c.a.a(a + "|stop by user", new java.lang.Object[0]);
        com.igexin.push.c.c.a().d().f();
    }
}
