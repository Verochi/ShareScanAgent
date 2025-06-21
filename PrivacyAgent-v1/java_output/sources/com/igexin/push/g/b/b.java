package com.igexin.push.g.b;

/* loaded from: classes23.dex */
public final class b extends com.igexin.push.g.b.f {
    public static final int a = -2147483642;
    private static final java.lang.String b = "HeartBeatTimerTask";
    private static com.igexin.push.g.b.b c;

    public b() {
        super(com.igexin.push.core.j.a().b(), (byte) 0);
        this.p = true;
    }

    public static com.igexin.push.g.b.b g() {
        if (c == null) {
            c = new com.igexin.push.g.b.b();
        }
        return c;
    }

    private static void q() {
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return a;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        if (this.m) {
            return;
        }
        i();
    }

    @Override // com.igexin.push.g.b.f
    public final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        com.igexin.push.core.e.P = java.lang.System.currentTimeMillis();
        if (!com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.a("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!", new java.lang.Object[0]);
            i();
        } else {
            java.lang.System.currentTimeMillis();
            com.igexin.c.a.c.a.a("heartbeatReq", new java.lang.Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.f();
        }
    }

    public final void i() {
        a(com.igexin.push.core.j.a().b(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
