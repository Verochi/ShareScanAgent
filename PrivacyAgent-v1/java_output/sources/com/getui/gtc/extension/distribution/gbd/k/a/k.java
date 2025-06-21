package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class k extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_RT";
    private static com.getui.gtc.extension.distribution.gbd.k.a.k d;

    private k() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.aP * 1000;
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b);
    }

    public static com.getui.gtc.extension.distribution.gbd.k.a.k e() {
        if (d == null) {
            d = new com.getui.gtc.extension.distribution.gbd.k.a.k();
        }
        return d;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "doTask");
        if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 2;
            obtain.arg1 = 21;
            com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain);
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

    public final void f() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.aP * 1000;
    }
}
