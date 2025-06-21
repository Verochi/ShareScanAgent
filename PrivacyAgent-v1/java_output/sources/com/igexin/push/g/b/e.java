package com.igexin.push.g.b;

import com.igexin.push.core.e.f.AnonymousClass13;

/* loaded from: classes23.dex */
public final class e extends com.igexin.push.g.b.f {
    public static final int b = -2147483641;
    private static final java.lang.String c = "RNTT";
    private static com.igexin.push.g.b.e e;
    public long a;
    private long f;

    private e() {
        super(com.igexin.push.config.c.g, (byte) 0);
        this.p = true;
        this.f = java.lang.System.currentTimeMillis();
        this.a = android.os.SystemClock.elapsedRealtime();
    }

    private void c(long j) {
        this.a = j;
    }

    public static synchronized com.igexin.push.g.b.e g() {
        com.igexin.push.g.b.e eVar;
        synchronized (com.igexin.push.g.b.e.class) {
            if (e == null) {
                e = new com.igexin.push.g.b.e();
            }
            eVar = e;
        }
        return eVar;
    }

    private void i() {
        a(com.igexin.push.core.e.O);
    }

    public final void a(long j) {
        com.igexin.c.a.c.a.a("RNTT|refreshDelayTime, delay = ".concat(java.lang.String.valueOf(j)), new java.lang.Object[0]);
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return b;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
    }

    @Override // com.igexin.push.g.b.f
    public final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        boolean a = com.igexin.push.h.c.a();
        com.igexin.push.core.e.n = com.igexin.push.h.c.e();
        com.igexin.c.a.c.a.a("RNTT|networkAvailable = " + com.igexin.push.core.e.n + "|,sdkOnline = " + com.igexin.push.core.e.u + ", sdkOn= " + com.igexin.push.core.e.p + ", pushOn =" + com.igexin.push.core.e.f388s + ", blockEndTime= " + a, new java.lang.Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.f388s || com.igexin.push.core.e.u || !a) {
            com.igexin.c.a.c.a.a("RNTT reconnect timer task stop, connect interval = 20min #######", new java.lang.Object[0]);
            a(com.igexin.push.config.c.g, java.util.concurrent.TimeUnit.MILLISECONDS);
            return;
        }
        if (!com.igexin.push.h.c.f() && android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            a(com.heytap.mcssdk.constant.a.h, java.util.concurrent.TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(c, "date is error, set connect interval = 15min");
            com.igexin.c.a.c.a.a("RNTT|date is error, set connect interval = 15min", new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("RNTT reconnect timer task isOnline = false, try login...", new java.lang.Object[0]);
        if (java.lang.System.currentTimeMillis() - this.f < 2500) {
            com.igexin.push.core.e.r++;
        }
        if (com.igexin.push.core.e.r > 30 && java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - this.a) < 72000.0d) {
            com.igexin.push.core.e.f.a();
            com.igexin.c.a.c.a.a(com.igexin.push.core.e.f.a + "| found a duplicate cid " + com.igexin.push.core.e.A, new java.lang.Object[0]);
            com.igexin.push.core.e.L = null;
            com.igexin.push.core.e.f.d();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass13(com.igexin.push.core.e.L), false, true);
            com.igexin.push.core.e.f.a().b();
            com.igexin.push.core.e.r = 0;
            g().a = android.os.SystemClock.elapsedRealtime();
        }
        this.f = java.lang.System.currentTimeMillis();
        com.igexin.push.core.k.a();
        com.igexin.push.core.k.b();
        a(1800000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
