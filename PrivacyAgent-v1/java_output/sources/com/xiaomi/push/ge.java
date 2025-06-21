package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ge implements com.xiaomi.push.service.c.n {
    private static boolean a;
    private android.content.Context b;
    private boolean c;
    private int d;

    public ge(android.content.Context context) {
        this.b = context;
    }

    public static void b() {
        a = false;
    }

    @Override // com.xiaomi.push.service.c.n
    public final void a() {
        com.xiaomi.push.gh a2 = com.xiaomi.push.gh.a(this.b);
        com.xiaomi.push.gi giVar = a2.b.get("UPLOADER_PUSH_CHANNEL");
        if (giVar == null && (giVar = a2.b.get("UPLOADER_HTTP")) == null) {
            giVar = null;
        }
        android.content.Context context = this.b;
        boolean z = false;
        if ((!com.xiaomi.push.service.be.b.isEmpty() && com.xiaomi.push.ai.d(context) && com.xiaomi.push.ib.k(context)) && giVar != null) {
            com.xiaomi.push.gg.a(this.b, giVar, com.xiaomi.push.service.be.b);
            com.xiaomi.push.service.be.a();
            com.xiaomi.channel.commonutils.logger.b.c("coord data upload");
        }
        android.content.Context context2 = this.b;
        this.c = com.xiaomi.push.service.ad.a(context2).a(com.xiaomi.push.gp.TinyDataUploadSwitch.bw, true);
        int a3 = com.xiaomi.push.service.ad.a(context2).a(com.xiaomi.push.gp.TinyDataUploadFrequency.bw, 7200);
        this.d = a3;
        this.d = java.lang.Math.max(60, a3);
        if (this.c) {
            if (java.lang.Math.abs((java.lang.System.currentTimeMillis() / 1000) - this.b.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.d)) {
                com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + java.lang.System.currentTimeMillis());
                if (com.xiaomi.push.ai.a(this.b) && giVar != null) {
                    java.lang.String packageName = this.b.getPackageName();
                    if (!android.text.TextUtils.isEmpty("com.xiaomi.xmsf".equals(packageName) ? "1000271" : this.b.getSharedPreferences("pref_registered_pkg_names", 0).getString(packageName, null)) && new java.io.File(this.b.getFilesDir(), "tiny_data.data").exists() && !a && (!com.xiaomi.push.service.ad.a(this.b).a(com.xiaomi.push.gp.ScreenOnOrChargingTinyDataUploadSwitch.bw, false) || com.xiaomi.push.ib.j(this.b) || com.xiaomi.push.ib.k(this.b))) {
                        z = true;
                    }
                }
                if (z) {
                    a = true;
                    com.xiaomi.push.gf.a(this.b, giVar);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + java.lang.System.currentTimeMillis());
                }
            }
        }
    }
}
