package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class z implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    public z(android.content.Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.mipush.sdk.MessageHandleService.c(this.a);
    }
}
