package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class ae extends com.xiaomi.push.m.a {
    private android.content.Context a;

    public ae(android.content.Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.m.a
    public java.lang.String a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.ad a = com.xiaomi.push.service.ad.a(this.a);
        com.xiaomi.push.hd hdVar = new com.xiaomi.push.hd();
        hdVar.a = com.xiaomi.push.service.ae.a(a, com.xiaomi.push.gq.MISC_CONFIG);
        hdVar.a();
        hdVar.b = com.xiaomi.push.service.ae.a(a, com.xiaomi.push.gq.PLUGIN_CONFIG);
        hdVar.b();
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk("-1", false);
        hkVar.e = com.xiaomi.push.gu.DailyCheckClientConfig.ah;
        hkVar.a(com.xiaomi.push.hv.a(hdVar));
        com.xiaomi.mipush.sdk.ao.a(this.a).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, (com.xiaomi.push.gx) null);
    }
}
