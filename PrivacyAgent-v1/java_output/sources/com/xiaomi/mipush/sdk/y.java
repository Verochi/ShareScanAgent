package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class y implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ android.content.Intent f61a;

    public y(android.content.Context context, android.content.Intent intent) {
        this.a = context;
        this.f61a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.startService(this.f61a);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e.getMessage());
        }
    }
}
