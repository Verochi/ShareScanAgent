package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public class j extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_RIP";
    private static volatile com.getui.gtc.extension.distribution.gbd.k.a.j d;

    private j() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.dq * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.bm;
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    public static com.getui.gtc.extension.distribution.gbd.k.a.j e() {
        if (d == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.k.a.j.class) {
                if (d == null) {
                    d = new com.getui.gtc.extension.distribution.gbd.k.a.j();
                }
            }
        }
        return d;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(c, "dotask ... ");
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message message = new android.os.Message();
                message.what = 255;
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
        com.getui.gtc.extension.distribution.gbd.d.h.bm = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(401, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "save last time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean b() {
        return super.b();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return com.getui.gtc.extension.distribution.gbd.d.d.dp;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 255;
    }
}
