package com.xiaomi.push;

/* loaded from: classes19.dex */
public class m {
    private static volatile com.xiaomi.push.m a;
    private java.util.concurrent.ScheduledThreadPoolExecutor b = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
    private java.util.Map<java.lang.String, java.util.concurrent.ScheduledFuture> c = new java.util.HashMap();
    private java.lang.Object d = new java.lang.Object();
    private android.content.SharedPreferences e;

    public static abstract class a implements java.lang.Runnable {
        public abstract java.lang.String a();
    }

    public static class b implements java.lang.Runnable {
        com.xiaomi.push.m.a a;

        public b(com.xiaomi.push.m.a aVar) {
            this.a = aVar;
        }

        public void a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
            a();
        }
    }

    private m(android.content.Context context) {
        this.e = context.getSharedPreferences("mipush_extra", 0);
    }

    public static com.xiaomi.push.m a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.push.m.class) {
                if (a == null) {
                    a = new com.xiaomi.push.m(context);
                }
            }
        }
        return a;
    }

    private java.util.concurrent.ScheduledFuture a(com.xiaomi.push.m.a aVar) {
        java.util.concurrent.ScheduledFuture scheduledFuture;
        synchronized (this.d) {
            scheduledFuture = this.c.get(aVar.a());
        }
        return scheduledFuture;
    }

    public final void a(java.lang.Runnable runnable, int i) {
        this.b.schedule(runnable, i, java.util.concurrent.TimeUnit.SECONDS);
    }

    public final boolean a(com.xiaomi.push.m.a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        java.util.concurrent.ScheduledFuture<?> schedule = this.b.schedule(new com.xiaomi.push.o(this, aVar), i, java.util.concurrent.TimeUnit.SECONDS);
        synchronized (this.d) {
            this.c.put(aVar.a(), schedule);
        }
        return true;
    }

    public final boolean a(com.xiaomi.push.m.a aVar, int i, int i2) {
        if (a(aVar) != null) {
            return false;
        }
        java.lang.String concat = "last_job_time".concat(java.lang.String.valueOf(aVar.a()));
        com.xiaomi.push.n nVar = new com.xiaomi.push.n(this, aVar, concat);
        long abs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.e.getLong(concat, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        try {
            java.util.concurrent.ScheduledFuture<?> scheduleAtFixedRate = this.b.scheduleAtFixedRate(nVar, i2, i, java.util.concurrent.TimeUnit.SECONDS);
            synchronized (this.d) {
                this.c.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public final boolean a(java.lang.String str) {
        synchronized (this.d) {
            java.util.concurrent.ScheduledFuture scheduledFuture = this.c.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.c.remove(str);
            return scheduledFuture.cancel(false);
        }
    }
}
