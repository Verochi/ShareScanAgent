package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class l extends com.getui.gtc.extension.distribution.gbd.k.b {
    public static com.getui.gtc.extension.distribution.gbd.k.a.l c = null;
    private static final java.lang.String d = "GBD_RUT";

    public l() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.dm * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.X;
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static com.getui.gtc.extension.distribution.gbd.k.a.l e() {
        if (c == null) {
            c = new com.getui.gtc.extension.distribution.gbd.k.a.l();
        }
        return c;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "dotask ...");
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message message = new android.os.Message();
                message.what = 118;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(message);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a(long j) {
        this.a = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.X = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(350, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "save last time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return com.getui.gtc.extension.distribution.gbd.d.d.dl;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 0;
    }
}
