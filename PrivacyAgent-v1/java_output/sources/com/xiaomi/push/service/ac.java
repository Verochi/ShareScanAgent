package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ac extends com.xiaomi.push.m.a {
    private com.xiaomi.push.hk a;
    private java.lang.ref.WeakReference<com.xiaomi.push.service.c> b;
    private boolean c;

    public ac(com.xiaomi.push.hk hkVar, java.lang.ref.WeakReference<com.xiaomi.push.service.c> weakReference, boolean z) {
        this.a = hkVar;
        this.b = weakReference;
        this.c = z;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.push.service.c cVar;
        java.lang.ref.WeakReference<com.xiaomi.push.service.c> weakReference = this.b;
        if (weakReference == null || this.a == null || (cVar = weakReference.get()) == null) {
            return;
        }
        this.a.c = com.xiaomi.push.service.ag.a();
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.c);
        try {
            com.xiaomi.push.hk hkVar = this.a;
            java.lang.String str = hkVar.i;
            cVar.a(str, com.xiaomi.push.hv.a(com.xiaomi.push.service.l.a(str, hkVar.d, hkVar, com.xiaomi.push.gk.Notification)), this.c);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
