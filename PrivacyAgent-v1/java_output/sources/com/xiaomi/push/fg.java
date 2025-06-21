package com.xiaomi.push;

/* loaded from: classes19.dex */
final class fg implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ com.xiaomi.push.fd b;

    public fg(com.xiaomi.push.fd fdVar, java.lang.String str) {
        this.b = fdVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.push.bv.a().a(this.a, true);
    }
}
