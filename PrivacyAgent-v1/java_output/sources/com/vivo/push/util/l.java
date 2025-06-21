package com.vivo.push.util;

/* loaded from: classes19.dex */
final class l implements java.lang.Runnable {
    final /* synthetic */ java.util.List a;
    final /* synthetic */ com.vivo.push.util.k b;

    public l(com.vivo.push.util.k kVar, java.util.List list) {
        this.b = kVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.vivo.push.model.InsideNotificationItem insideNotificationItem;
        long j;
        android.content.Context context;
        com.vivo.push.model.InsideNotificationItem insideNotificationItem2;
        long j2;
        int i;
        com.vivo.push.d.r.a aVar;
        insideNotificationItem = this.b.b;
        if (insideNotificationItem != null) {
            com.vivo.push.util.w b = com.vivo.push.util.w.b();
            j = this.b.c;
            b.a("com.vivo.push.notify_key", j);
            context = this.b.a;
            java.util.List list = this.a;
            insideNotificationItem2 = this.b.b;
            j2 = this.b.c;
            i = this.b.e;
            aVar = this.b.f;
            com.vivo.push.util.NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, aVar);
        }
    }
}
