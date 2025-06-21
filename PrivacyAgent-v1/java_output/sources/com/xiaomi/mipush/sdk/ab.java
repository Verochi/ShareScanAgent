package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class ab implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.mipush.sdk.MiTinyDataClient.a.C0532a a;

    public ab(com.xiaomi.mipush.sdk.MiTinyDataClient.a.C0532a c0532a) {
        this.a = c0532a;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.concurrent.ScheduledFuture scheduledFuture;
        java.util.concurrent.ScheduledFuture scheduledFuture2;
        if (this.a.f14a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f15a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f15a;
            scheduledFuture2.cancel(false);
            this.a.f15a = null;
        }
    }
}
