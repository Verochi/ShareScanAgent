package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class p extends com.getui.gtc.extension.distribution.gbd.k.b {
    public static com.getui.gtc.extension.distribution.gbd.k.a.p c = null;
    private static final java.lang.String d = "GBD_UST";

    public p() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.bP * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.ac;
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static com.getui.gtc.extension.distribution.gbd.k.a.p e() {
        if (c == null) {
            c = new com.getui.gtc.extension.distribution.gbd.k.a.p();
        }
        return c;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "dotask ...");
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(new com.getui.gtc.extension.distribution.gbd.g.a.f()));
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a(long j) {
        this.a = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.ac = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(145, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "save  last time = " + this.a);
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
