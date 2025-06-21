package com.getui.gs.g;

/* loaded from: classes22.dex */
public final class d {
    private static java.util.Timer a;
    private static final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: com.getui.gs.g.d$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            com.getui.gs.g.d.c();
            com.getui.gs.g.d.d();
            com.getui.gs.g.d.e();
        }
    }

    public static void a() {
        if (b.getAndSet(true)) {
            return;
        }
        java.util.Timer timer = new java.util.Timer();
        a = timer;
        timer.scheduleAtFixedRate(new com.getui.gs.g.d.AnonymousClass1(), 3000L, 5000L);
        com.getui.gs.h.a.a("session timer start");
    }

    public static void b() {
        com.getui.gs.h.a.a("session timer cancel");
        if (b.getAndSet(false)) {
            a.cancel();
            com.getui.gs.h.a.a("session timer cancel success");
        }
        a = null;
    }

    public static /* synthetic */ void c() {
        com.getui.gs.g.f fVar;
        try {
            fVar = com.getui.gs.g.f.a.a;
            fVar.a();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    public static /* synthetic */ void d() {
        com.getui.gs.d.b bVar;
        try {
            bVar = com.getui.gs.d.b.a.a;
            bVar.a();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    public static /* synthetic */ void e() {
        try {
            com.getui.gs.a.c.b();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }
}
