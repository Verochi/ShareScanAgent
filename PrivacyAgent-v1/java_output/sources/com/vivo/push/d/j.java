package com.vivo.push.d;

/* loaded from: classes19.dex */
final class j implements java.lang.Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ java.util.List b;
    final /* synthetic */ java.util.List c;
    final /* synthetic */ java.lang.String d;
    final /* synthetic */ com.vivo.push.d.h e;

    public j(com.vivo.push.d.h hVar, int i, java.util.List list, java.util.List list2, java.lang.String str) {
        this.e = hVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.vivo.push.d.h hVar = this.e;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) hVar).b;
        context = ((com.vivo.push.l) hVar).a;
        pushMessageCallback.onDelAlias(context, this.a, this.b, this.c, this.d);
    }
}
