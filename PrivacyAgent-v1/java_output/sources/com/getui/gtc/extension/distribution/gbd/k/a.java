package com.getui.gtc.extension.distribution.gbd.k;

/* loaded from: classes22.dex */
public final class a implements com.getui.gtc.extension.distribution.gbd.k.d {
    private static final java.lang.String a = "GBD_CronTask";
    private java.util.List<com.getui.gtc.extension.distribution.gbd.k.b> b = new java.util.concurrent.CopyOnWriteArrayList();

    @Override // com.getui.gtc.extension.distribution.gbd.k.d
    public final boolean a() {
        com.getui.gtc.extension.distribution.gbd.f.h.b();
        if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron ido closed, task can't be executed");
            return false;
        }
        boolean a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, true);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron s c = ".concat(java.lang.String.valueOf(a2)));
        java.util.Set<java.lang.String> a3 = com.getui.gtc.extension.distribution.gbd.n.l.a(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        java.lang.StringBuilder sb = new java.lang.StringBuilder("gbd tz white set = ");
        sb.append(a3 == null ? com.igexin.push.core.b.m : a3.toString());
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, sb.toString());
        for (com.getui.gtc.extension.distribution.gbd.k.b bVar : this.b) {
            boolean z = (bVar instanceof com.getui.gtc.extension.distribution.gbd.k.a.f) || (bVar instanceof com.getui.gtc.extension.distribution.gbd.k.a.b) || (bVar instanceof com.getui.gtc.extension.distribution.gbd.k.a.l);
            boolean z2 = !com.getui.gtc.extension.distribution.gbd.d.d.bZ || a3 == null || a3.contains(java.lang.String.valueOf(bVar.d()));
            boolean z3 = a2 && z2;
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, bVar.getClass().getSimpleName() + "|step=" + bVar.b + "|enable=" + bVar.c() + "|match=" + bVar.b() + "|isIgnore=" + z + "|matchWhiteList=" + z2 + "|" + bVar.d());
            if (z || z3) {
                if (bVar.c() && bVar.b() && !com.getui.gtc.extension.distribution.gbd.n.l.c(bVar.d()) && com.getui.gtc.extension.distribution.gbd.n.l.a(bVar.d())) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, bVar.getClass().getSimpleName() + "|fresh and doTask");
                    bVar.a(java.lang.System.currentTimeMillis());
                    bVar.a();
                }
            }
        }
        return false;
    }

    public final boolean a(com.getui.gtc.extension.distribution.gbd.k.b bVar) {
        return !this.b.contains(bVar) && this.b.add(bVar);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.d
    public final boolean b() {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "GBDCronTask ioIdle...");
        return false;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.d
    public final boolean c() {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "GBDCronTask exceptionCaught...");
        return false;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.d
    public final boolean d() {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "GBDCronTask isEnable...");
        return true;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.d
    public final void e() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.d
    public final long f() {
        return -423462L;
    }
}
