package com.vivo.push.d;

/* loaded from: classes19.dex */
final class o implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.b.n a;
    final /* synthetic */ com.vivo.push.d.n b;

    public o(com.vivo.push.d.n nVar, com.vivo.push.b.n nVar2) {
        this.b = nVar;
        this.a = nVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.n nVar = this.b;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) nVar).b;
        context = ((com.vivo.push.l) nVar).a;
        pushMessageCallback.onLog(context, this.a.d(), this.a.e(), this.a.f());
    }
}
