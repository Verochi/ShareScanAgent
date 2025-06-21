package com.getui.gtc.extension.distribution.gbd.m.f;

/* loaded from: classes22.dex */
public final class a {
    public final java.net.InetAddress a = java.net.InetAddress.getByName("239.255.255.250");
    public final int b = 1900;
    public final com.getui.gtc.extension.distribution.gbd.m.d.c c;

    public a() {
        com.getui.gtc.extension.distribution.gbd.m.d.c cVar = new com.getui.gtc.extension.distribution.gbd.m.d.c();
        this.c = cVar;
        cVar.a(com.getui.gtc.extension.distribution.gbd.m.d.b.a.MAN, new com.getui.gtc.extension.distribution.gbd.m.d.a.b());
        cVar.a(com.getui.gtc.extension.distribution.gbd.m.d.b.a.MX, new com.getui.gtc.extension.distribution.gbd.m.d.a.c());
        cVar.a(com.getui.gtc.extension.distribution.gbd.m.d.b.a.ST, new com.getui.gtc.extension.distribution.gbd.m.d.a.d());
        cVar.a(com.getui.gtc.extension.distribution.gbd.m.d.b.a.HOST, new com.getui.gtc.extension.distribution.gbd.m.d.a.C0314a());
    }

    private java.net.InetAddress a() {
        return this.a;
    }

    private int b() {
        return this.b;
    }

    private com.getui.gtc.extension.distribution.gbd.m.d.c c() {
        return this.c;
    }

    public final java.lang.String toString() {
        return "(" + com.getui.gtc.extension.distribution.gbd.m.f.a.class.getSimpleName() + ")";
    }
}
