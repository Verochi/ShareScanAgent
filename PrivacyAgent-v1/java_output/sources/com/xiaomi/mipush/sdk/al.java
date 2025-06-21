package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class al implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ android.content.Intent f23a;

    public al(android.content.Context context, android.content.Intent intent) {
        this.a = context;
        this.f23a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.mipush.sdk.PushMessageHandler.b(this.a, this.f23a);
    }
}
