package com.vivo.push;

/* loaded from: classes19.dex */
final class f implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ com.vivo.push.e b;

    public f(com.vivo.push.e eVar, java.lang.String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        android.content.Context context2;
        android.content.Context context3;
        context = this.b.h;
        if (context == null || android.text.TextUtils.isEmpty(this.a)) {
            return;
        }
        context2 = this.b.h;
        context3 = this.b.h;
        if (com.vivo.push.util.z.b(context2, context3.getPackageName(), this.a)) {
            this.b.i();
        }
    }
}
