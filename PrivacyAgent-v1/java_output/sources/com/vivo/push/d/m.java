package com.vivo.push.d;

/* loaded from: classes19.dex */
final class m implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.b.m a;
    final /* synthetic */ com.vivo.push.d.l b;

    public m(com.vivo.push.d.l lVar, com.vivo.push.b.m mVar) {
        this.b = lVar;
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.l lVar = this.b;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) lVar).b;
        context = ((com.vivo.push.l) lVar).a;
        pushMessageCallback.onListTags(context, this.a.h(), this.a.d(), this.a.g());
    }
}
