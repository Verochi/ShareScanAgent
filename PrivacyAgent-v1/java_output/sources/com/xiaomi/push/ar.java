package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ar implements java.lang.Runnable {
    public com.xiaomi.a.c.e a;
    public android.content.Context b;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.xiaomi.a.c.e eVar = this.a;
            if (eVar != null) {
                eVar.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            com.xiaomi.a.c.e eVar2 = this.a;
            if (eVar2 instanceof com.xiaomi.a.c.a) {
                com.xiaomi.push.av.a(this.b).a("sp_client_report_status", "event_last_upload_time", java.lang.System.currentTimeMillis());
            } else if (eVar2 instanceof com.xiaomi.a.c.b) {
                com.xiaomi.push.av.a(this.b).a("sp_client_report_status", "perf_last_upload_time", java.lang.System.currentTimeMillis());
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
