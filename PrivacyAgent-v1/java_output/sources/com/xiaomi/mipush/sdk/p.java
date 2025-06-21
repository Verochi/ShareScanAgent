package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class p extends com.xiaomi.push.m.a {
    final /* synthetic */ android.content.Context a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ com.xiaomi.push.hk f56a;

    public p(com.xiaomi.push.hk hkVar, android.content.Context context) {
        this.f56a = hkVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.push.hk hkVar = this.f56a;
        if (hkVar != null) {
            hkVar.c = com.xiaomi.push.service.ag.a();
            com.xiaomi.mipush.sdk.ao.a(this.a.getApplicationContext()).a((com.xiaomi.mipush.sdk.ao) this.f56a, com.xiaomi.push.gk.Notification, true, (com.xiaomi.push.gx) null, true);
        }
    }
}
