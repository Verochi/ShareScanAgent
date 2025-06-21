package com.igexin.push.g;

/* loaded from: classes23.dex */
public class c implements com.igexin.push.g.b.c {
    public static final java.lang.String a = "com.igexin.push.g.c";
    private static final long c = 3600000;
    public long b = 0;

    @Override // com.igexin.push.g.b.c
    public final void a(long j) {
        this.b = j;
    }

    @Override // com.igexin.push.g.b.c
    public final void b() {
        com.igexin.c.a.c.a.a("start cron-keep task", new java.lang.Object[0]);
        com.igexin.sdk.main.FeedbackImpl.getInstance().clearFeedbackMessage();
        com.igexin.push.core.e.c.a().d();
        com.igexin.push.core.e.c.a().c();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.j();
        com.igexin.push.h.j.h();
        com.igexin.push.h.j.i();
    }

    @Override // com.igexin.push.g.b.c
    public final boolean c() {
        return java.lang.System.currentTimeMillis() - this.b > 3600000;
    }
}
