package com.getui.gtc.extension.distribution.gbd.m;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String a = "Up_M";

    private static void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start ott discover.");
        if (com.getui.gtc.extension.distribution.gbd.d.h.z == null) {
            com.getui.gtc.extension.distribution.gbd.d.h.z = new java.util.concurrent.ConcurrentHashMap<>();
        }
        com.getui.gtc.extension.distribution.gbd.d.h.z.clear();
        com.getui.gtc.extension.distribution.gbd.m.b.b bVar = new com.getui.gtc.extension.distribution.gbd.m.b.b();
        bVar.a();
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wait 5s before shutting down ott.");
        java.lang.Thread.sleep(5000L);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "up Map size = " + com.getui.gtc.extension.distribution.gbd.d.h.z.size());
        if (com.getui.gtc.extension.distribution.gbd.d.d.aJ) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "ott enable http request.");
            com.getui.gtc.extension.distribution.gbd.m.h.a.a(com.getui.gtc.extension.distribution.gbd.d.h.z);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "ott disable http request.");
        }
        java.lang.Thread.sleep(2000L);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "Attempt to stop ott discover.");
        bVar.b();
    }
}
