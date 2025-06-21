package com.getui.gtc.extension.distribution.gbd.l;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String b = "ScheduleQueueManager";
    public java.util.concurrent.ScheduledThreadPoolExecutor a;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.l.a$a, reason: collision with other inner class name */
    public static class C0311a {
        private static final com.getui.gtc.extension.distribution.gbd.l.a a = new com.getui.gtc.extension.distribution.gbd.l.a((byte) 0);

        private C0311a() {
        }
    }

    private a() {
        if (this.a == null) {
            this.a = new java.util.concurrent.ScheduledThreadPoolExecutor(4);
        }
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    private static com.getui.gtc.extension.distribution.gbd.l.a a() {
        return com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a;
    }

    private java.util.concurrent.ScheduledFuture b(java.lang.Runnable runnable, long j, long j2) {
        try {
            return this.a.scheduleWithFixedDelay(runnable, j, j2, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
            return null;
        }
    }

    private void b() {
        try {
            java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
            if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown()) {
                return;
            }
            this.a.shutdownNow();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
        }
    }

    public final boolean a(java.lang.Runnable runnable) {
        try {
            this.a.execute(runnable);
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
            return false;
        }
    }

    public final boolean a(java.lang.Runnable runnable, long j) {
        try {
            this.a.schedule(runnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
            return false;
        }
    }

    public final boolean a(java.lang.Runnable runnable, long j, long j2) {
        try {
            this.a.scheduleAtFixedRate(runnable, j, j2, java.util.concurrent.TimeUnit.MILLISECONDS);
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(b, th.toString());
            return false;
        }
    }
}
