package com.xiaomi.push.service.receivers;

/* loaded from: classes19.dex */
class a implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ com.xiaomi.push.service.receivers.NetworkStatusReceiver f62a;

    public a(com.xiaomi.push.service.receivers.NetworkStatusReceiver networkStatusReceiver, android.content.Context context) {
        this.f62a = networkStatusReceiver;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f62a.a(this.a);
    }
}
