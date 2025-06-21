package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ax extends com.xiaomi.push.m.a {
    final /* synthetic */ com.xiaomi.push.aw a;

    public ax(com.xiaomi.push.aw awVar) {
        this.a = awVar;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.push.bn bnVar;
        com.xiaomi.push.bn unused;
        android.content.Context unused2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        bnVar = this.a.j;
        if (bnVar != null) {
            unused = this.a.j;
            unused2 = this.a.a;
            com.xiaomi.push.aw.a(this.a, "upload_time");
        }
    }
}
