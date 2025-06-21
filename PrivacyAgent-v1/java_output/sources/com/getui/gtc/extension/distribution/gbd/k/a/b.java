package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class b extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_CAReportTask";
    private static com.getui.gtc.extension.distribution.gbd.k.a.b d;

    private b() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.bJ * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.ah;
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.k.a.b e() {
        com.getui.gtc.extension.distribution.gbd.k.a.b bVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.k.a.b.class) {
            if (d == null) {
                d = new com.getui.gtc.extension.distribution.gbd.k.a.b();
            }
            bVar = d;
        }
        return bVar;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "dotask ...");
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 17;
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
        com.getui.gtc.extension.distribution.gbd.d.h.ah = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(164, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "last report time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return com.getui.gtc.extension.distribution.gbd.n.l.B();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE;
    }
}
