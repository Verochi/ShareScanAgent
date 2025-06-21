package com.vivo.push.d;

/* loaded from: classes19.dex */
final class e implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ com.vivo.push.b.i b;
    final /* synthetic */ com.vivo.push.d.d c;

    public e(com.vivo.push.d.d dVar, java.lang.String str, com.vivo.push.b.i iVar) {
        this.c = dVar;
        this.a = str;
        this.b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        android.content.Context context2;
        if (!android.text.TextUtils.isEmpty(this.a)) {
            com.vivo.push.d.d dVar = this.c;
            com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) dVar).b;
            context2 = ((com.vivo.push.l) dVar).a;
            pushMessageCallback.onReceiveRegId(context2, this.a);
        }
        com.vivo.push.d.d dVar2 = this.c;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback2 = ((com.vivo.push.d.z) dVar2).b;
        context = ((com.vivo.push.l) dVar2).a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
