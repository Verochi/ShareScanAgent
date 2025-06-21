package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class i extends com.getui.gtc.extension.distribution.gbd.k.b {
    public static com.getui.gtc.extension.distribution.gbd.k.a.i c = null;
    private static final java.lang.String d = "GBD_RNALT";

    public i() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.bm * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.d.M ? com.getui.gtc.extension.distribution.gbd.d.h.r : java.lang.System.currentTimeMillis();
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static com.getui.gtc.extension.distribution.gbd.k.a.i e() {
        if (c == null) {
            c = new com.getui.gtc.extension.distribution.gbd.k.a.i();
        }
        return c;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "dotask ...");
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 4;
                obtain.arg1 = 41;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain);
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return true;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 124;
    }
}
