package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class c {
    private static final java.lang.String a = "CATT";
    private static int b;
    private static long c = com.getui.gtc.extension.distribution.gbd.d.d.bI * 1000;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.k.a.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.k.a.c.a();
            try {
                com.getui.gtc.extension.distribution.gbd.k.a.c.a(com.getui.gtc.extension.distribution.gbd.k.a.c.c);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    public static void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "initCAT  start  ");
        if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron ido closed, CATTask can't be executed");
            return;
        }
        try {
            if (com.getui.gtc.extension.distribution.gbd.d.h.ai.split(",").length >= 200) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, " CAD length > 200, clean. ");
                com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
            }
            long C = com.getui.gtc.extension.distribution.gbd.n.l.C() - com.getui.gtc.extension.distribution.gbd.d.h.aj;
            com.getui.gtc.extension.distribution.gbd.d.h.ak = C;
            if (C < 0) {
                com.getui.gtc.extension.distribution.gbd.d.h.aj = com.getui.gtc.extension.distribution.gbd.n.l.C();
                com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
            int i = b;
            b = i + 1;
            if (i < 3) {
                c = 30000L;
            } else {
                c = org.apache.tools.ant.taskdefs.WaitFor.DEFAULT_MAX_WAIT_MILLIS;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(long j) {
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.k.a.c.AnonymousClass1(), j);
    }
}
