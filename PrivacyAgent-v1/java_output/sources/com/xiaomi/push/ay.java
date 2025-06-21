package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ay extends com.xiaomi.push.m.a {
    final /* synthetic */ com.xiaomi.push.aw a;

    public ay(com.xiaomi.push.aw awVar) {
        this.a = awVar;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String b;
        android.content.Context context;
        android.content.Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        b = this.a.b();
        context = this.a.a;
        com.xiaomi.push.bc bcVar = new com.xiaomi.push.bc(b, new java.lang.ref.WeakReference(context));
        context2 = this.a.a;
        com.xiaomi.push.bj.a(context2).a(bcVar);
        com.xiaomi.push.aw.a(this.a, "check_time");
    }
}
