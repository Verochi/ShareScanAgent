package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class q extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_WST";
    private static com.getui.gtc.extension.distribution.gbd.k.a.q d;

    private q() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.aR * 1000;
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.ab;
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    public static com.getui.gtc.extension.distribution.gbd.k.a.q e() {
        if (d == null) {
            d = new com.getui.gtc.extension.distribution.gbd.k.a.q();
        }
        return d;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "doTask");
        if (com.getui.gtc.extension.distribution.gbd.n.l.c(111)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "type 11 in type black list, return.");
        } else if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 11;
            com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a(long j) {
        this.a = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.ab = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "save last time = " + this.a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return true;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 111;
    }

    public final void f() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "refreshWaitTime:" + (com.getui.gtc.extension.distribution.gbd.d.d.aR * 1000));
        this.b = com.getui.gtc.extension.distribution.gbd.d.d.aR * 1000;
    }
}
