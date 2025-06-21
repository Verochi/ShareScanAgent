package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bh extends com.xiaomi.push.m.a {
    final /* synthetic */ int a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ android.content.Context c;
    final /* synthetic */ java.lang.String d;
    final /* synthetic */ android.app.Notification e = null;

    public bh(int i, java.lang.String str, android.content.Context context, java.lang.String str2) {
        this.a = i;
        this.b = str;
        this.c = context;
        this.d = str2;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return com.xiaomi.push.service.bg.a(this.a, this.b);
    }

    @Override // java.lang.Runnable
    @android.annotation.TargetApi(19)
    public final void run() {
        com.xiaomi.push.service.bg.a(this.c, this.d, this.a, this.b, this.e);
    }
}
