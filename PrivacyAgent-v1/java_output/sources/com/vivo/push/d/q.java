package com.vivo.push.d;

/* loaded from: classes19.dex */
final class q implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.model.UnvarnishedMessage a;
    final /* synthetic */ com.vivo.push.d.p b;

    public q(com.vivo.push.d.p pVar, com.vivo.push.model.UnvarnishedMessage unvarnishedMessage) {
        this.b = pVar;
        this.a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.p pVar = this.b;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) pVar).b;
        context = ((com.vivo.push.l) pVar).a;
        pushMessageCallback.onTransmissionMessage(context, this.a);
    }
}
