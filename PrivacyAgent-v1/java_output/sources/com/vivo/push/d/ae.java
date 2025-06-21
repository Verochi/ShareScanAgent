package com.vivo.push.d;

/* loaded from: classes19.dex */
final class ae implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.b.i a;
    final /* synthetic */ com.vivo.push.d.ad b;

    public ae(com.vivo.push.d.ad adVar, com.vivo.push.b.i iVar) {
        this.b = adVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.ad adVar = this.b;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) adVar).b;
        context = ((com.vivo.push.l) adVar).a;
        pushMessageCallback.onUnBind(context, this.a.h(), this.a.d());
    }
}
