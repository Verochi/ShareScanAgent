package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class n extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_TALT";
    private static com.getui.gtc.extension.distribution.gbd.k.a.n d;

    private n() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.bM * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.af;
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static com.getui.gtc.extension.distribution.gbd.k.a.n e() {
        if (d == null) {
            d = new com.getui.gtc.extension.distribution.gbd.k.a.n();
        }
        return d;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "dotask ...");
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 16;
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
        com.getui.gtc.extension.distribution.gbd.d.h.af = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.aliyun.svideosdk.facearengine.FaceARFaceResult.YUNOS_FL51PT_FACE_3D_KEY_POINT_NUM, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "save last time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return com.getui.gtc.extension.distribution.gbd.d.d.bN;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 134;
    }
}
