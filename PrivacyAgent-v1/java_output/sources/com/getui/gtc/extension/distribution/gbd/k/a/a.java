package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class a extends com.getui.gtc.extension.distribution.gbd.k.b {
    public static com.getui.gtc.extension.distribution.gbd.k.a.a c = null;
    private static final java.lang.String d = "GBD_ALT";

    public a() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.bE * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.V;
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static com.getui.gtc.extension.distribution.gbd.k.a.a e() {
        if (c == null) {
            c = new com.getui.gtc.extension.distribution.gbd.k.a.a();
        }
        return c;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "dotask ...");
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message message = new android.os.Message();
                message.what = 10;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(message);
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a(long j) {
        this.a = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.V = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "save last time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean b() {
        return super.b();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return true;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 128;
    }
}
