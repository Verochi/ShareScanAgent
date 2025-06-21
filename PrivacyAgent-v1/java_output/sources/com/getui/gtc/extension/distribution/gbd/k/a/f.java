package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class f extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_Config";
    private static com.getui.gtc.extension.distribution.gbd.k.a.f d;

    private f() {
        this.b = 86400000L;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.D;
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    public static com.getui.gtc.extension.distribution.gbd.k.a.f e() {
        if (d == null) {
            d = new com.getui.gtc.extension.distribution.gbd.k.a.f();
        }
        return d;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        if (!com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "GBD_CONFIG not network, return.");
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "doTask GBD_CONFIG");
            com.getui.gtc.extension.distribution.gbd.d.e.a().b();
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return true;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 0;
    }
}
