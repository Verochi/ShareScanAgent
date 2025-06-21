package com.getui.gtc.extension.distribution.gbd.m.b;

/* loaded from: classes22.dex */
public final class b {
    private static final java.lang.String c = "Up_S";
    protected final com.getui.gtc.extension.distribution.gbd.m.a.a a;
    protected final com.getui.gtc.extension.distribution.gbd.m.b.a b;

    public b() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "Starting UPnP service.");
        com.getui.gtc.extension.distribution.gbd.m.a.a aVar = new com.getui.gtc.extension.distribution.gbd.m.a.a();
        this.a = aVar;
        com.getui.gtc.extension.distribution.gbd.m.b.a aVar2 = new com.getui.gtc.extension.distribution.gbd.m.b.a(aVar);
        this.b = aVar2;
        try {
            aVar2.a();
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "UPnP service started successfully.");
        } catch (com.getui.gtc.extension.distribution.gbd.m.c.a.e e) {
            throw new java.lang.RuntimeException("Enabling network router failed: ".concat(java.lang.String.valueOf(e)), e);
        }
    }

    private com.getui.gtc.extension.distribution.gbd.m.f.b d() {
        return new com.getui.gtc.extension.distribution.gbd.m.f.b(this);
    }

    private void e() {
        try {
            this.b.b();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void f() {
        com.getui.gtc.extension.distribution.gbd.m.a.a aVar = this.a;
        com.getui.gtc.extension.distribution.gbd.n.j.b("Up_SC", "Shutting down default executor service");
        aVar.a.shutdownNow();
    }

    public final void a() {
        this.a.a.execute(new com.getui.gtc.extension.distribution.gbd.m.f.b(this));
    }

    public final synchronized void b() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "Start shut down UPnP service.");
        try {
            this.b.b();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        com.getui.gtc.extension.distribution.gbd.m.a.a aVar = this.a;
        com.getui.gtc.extension.distribution.gbd.n.j.b("Up_SC", "Shutting down default executor service");
        aVar.a.shutdownNow();
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "UPnP service shutdown completed.");
    }

    public final com.getui.gtc.extension.distribution.gbd.m.b.a c() {
        return this.b;
    }
}
