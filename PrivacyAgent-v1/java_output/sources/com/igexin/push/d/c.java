package com.igexin.push.d;

/* loaded from: classes23.dex */
public final class c {
    public static final java.lang.String a = "ConnectModelCoordinator";
    private static final long i = 20000;
    private static final long j = 200000;
    public boolean b;
    public long c;
    public int d;
    public com.igexin.push.d.b e;
    private int f;
    private int g;
    private int h;
    private long k;
    private com.igexin.push.d.c.a l;

    public enum a {
        WIFI,
        MOBILE
    }

    public static class b {
        private static final com.igexin.push.d.c a = new com.igexin.push.d.c((byte) 0);

        private b() {
        }
    }

    private c() {
        this.f = com.igexin.push.config.d.x;
        this.g = com.igexin.push.config.d.z;
        this.e = new com.igexin.push.d.d();
        this.l = com.igexin.push.h.c.b() ? com.igexin.push.d.c.a.WIFI : com.igexin.push.d.c.a.MOBILE;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    private static void a(int i2) {
        if (com.igexin.push.core.e.l == null) {
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("com.igexin.sdk.action.polling");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("code", i2);
            intent.putExtras(bundle);
            intent.setPackage(com.igexin.push.core.e.l.getPackageName());
            com.igexin.push.core.e.l.sendBroadcast(intent);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(a, th.toString());
        }
    }

    private void a(boolean z) {
        this.b = z;
        com.igexin.c.a.c.a.a("ConnectModelCoordinator|init, current is polling mdl = ".concat(java.lang.String.valueOf(z)), new java.lang.Object[0]);
        if (z) {
            com.igexin.push.g.b.d.a.a.g();
        }
    }

    private com.igexin.push.d.b e() {
        return this.e;
    }

    private static com.igexin.push.d.c f() {
        return com.igexin.push.d.c.b.a;
    }

    private void g() {
        this.c = java.lang.System.currentTimeMillis();
        if (!this.b) {
            b();
            return;
        }
        com.igexin.c.a.c.a.a(a, "loginRsp| enter polling");
        this.e = new com.igexin.push.d.e();
        com.igexin.push.g.b.d.a.a.g();
        this.d = 0;
    }

    private void h() {
        com.igexin.push.d.b bVar;
        if (!this.b || (bVar = this.e) == null || (bVar instanceof com.igexin.push.d.d)) {
            return;
        }
        this.e = new com.igexin.push.d.d();
    }

    private static void i() {
        a(0);
    }

    private static void j() {
        a(1);
    }

    public final synchronized void a() {
        com.igexin.push.d.c.a aVar = com.igexin.push.h.c.b() ? com.igexin.push.d.c.a.WIFI : com.igexin.push.d.c.a.MOBILE;
        if (aVar != this.l) {
            com.igexin.c.a.c.a.a(a, "net type changed " + this.l + "->" + aVar);
            com.igexin.c.a.c.a.a("ConnectModelCoordinator|net type changed " + this.l + "->" + aVar, new java.lang.Object[0]);
            b();
            this.l = aVar;
        }
    }

    public final void b() {
        com.igexin.c.a.c.a.a("ConnectModelCoordinator|reset current mdl = normal", new java.lang.Object[0]);
        com.igexin.push.d.b bVar = this.e;
        if (bVar != null && !(bVar instanceof com.igexin.push.d.d)) {
            this.e = new com.igexin.push.d.d();
        }
        com.igexin.push.g.b.d.a.a.i();
        this.d = 0;
        this.h = 0;
        this.b = false;
        com.igexin.push.core.e.f.a().b(this.b);
    }

    public final synchronized void c() {
        if (this.b) {
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis() - this.c;
        if (currentTimeMillis > 20000 && currentTimeMillis < j) {
            this.h++;
            com.igexin.c.a.c.a.a(a, "read len = -1, interval = " + currentTimeMillis + ", tcpDisconnectSuccess =" + this.h);
            com.igexin.c.a.c.a.a("ConnectModelCoordinator|read len = -1, interval = " + currentTimeMillis + ", tcpDisconnectSuccess =" + this.h, new java.lang.Object[0]);
            if (this.h >= this.f) {
                com.igexin.c.a.c.a.a(a, "enter polling mode #####");
                com.igexin.c.a.c.a.a("ConnectModelCoordinator|enter polling mode ####", new java.lang.Object[0]);
                a(0);
                this.b = true;
                this.e = new com.igexin.push.d.e();
                com.igexin.push.g.b.d.a.a.g();
                com.igexin.push.core.e.f.a().b(this.b);
            }
        }
    }

    public final synchronized void d() {
        if (this.b) {
            this.d++;
            com.igexin.c.a.c.a.a(a, "polling mode, cur heartbeat = " + this.d);
            com.igexin.c.a.c.a.a("ConnectModelCoordinator|polling mode, cur heartbeat =" + this.d, new java.lang.Object[0]);
            if (this.d >= this.g) {
                com.igexin.c.a.c.a.a(a, "enter normal mode #####");
                com.igexin.c.a.c.a.a("ConnectModelCoordinator|enter normal mode ####", new java.lang.Object[0]);
                a(1);
                com.igexin.push.core.e.b(0L);
                b();
            }
        }
    }
}
