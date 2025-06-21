package com.vivo.push.d;

/* loaded from: classes19.dex */
final class y implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.b.r a;
    final /* synthetic */ com.vivo.push.d.x b;

    public y(com.vivo.push.d.x xVar, com.vivo.push.b.r rVar) {
        this.b = xVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.x xVar = this.b;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) xVar).b;
        context = ((com.vivo.push.l) xVar).a;
        pushMessageCallback.onPublish(context, this.a.h(), this.a.g());
    }
}
