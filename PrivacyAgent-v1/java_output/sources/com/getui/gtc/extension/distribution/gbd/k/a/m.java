package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class m extends com.getui.gtc.extension.distribution.gbd.k.b {
    public static com.getui.gtc.extension.distribution.gbd.k.a.m c = null;
    private static final java.lang.String d = "GBD_SLMT";

    public m() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.bA * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.R;
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static com.getui.gtc.extension.distribution.gbd.k.a.m e() {
        if (c == null) {
            c = new com.getui.gtc.extension.distribution.gbd.k.a.m();
        }
        return c;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "do Task");
        try {
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 7;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain);
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a(long j) {
        this.a = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.R = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(138, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "save last time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return com.getui.gtc.extension.distribution.gbd.d.d.bz;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 127;
    }
}
