package com.vivo.push.d;

/* loaded from: classes19.dex */
final class w implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.model.UPSNotificationMessage a;
    final /* synthetic */ com.vivo.push.d.u b;

    public w(com.vivo.push.d.u uVar, com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage) {
        this.b = uVar;
        this.a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.u uVar = this.b;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) uVar).b;
        context = ((com.vivo.push.l) uVar).a;
        pushMessageCallback.onNotificationMessageClicked(context, this.a);
    }
}
