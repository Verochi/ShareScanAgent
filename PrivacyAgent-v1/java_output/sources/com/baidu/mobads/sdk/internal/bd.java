package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bd {
    private static final java.lang.String a = "TaskScheduler";
    private static volatile com.baidu.mobads.sdk.internal.bd d;
    private java.util.concurrent.ThreadPoolExecutor b;
    private java.util.concurrent.ScheduledThreadPoolExecutor c;

    private bd() {
        b();
    }

    public static com.baidu.mobads.sdk.internal.bd a() {
        if (d == null) {
            synchronized (com.baidu.mobads.sdk.internal.bd.class) {
                if (d == null) {
                    d = new com.baidu.mobads.sdk.internal.bd();
                }
            }
        }
        return d;
    }

    private void b() {
        this.b = com.baidu.mobads.sdk.internal.be.a(1, 1);
        this.c = com.baidu.mobads.sdk.internal.be.a(1);
    }

    public void a(com.baidu.mobads.sdk.internal.j jVar) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        if (jVar == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(java.lang.System.currentTimeMillis());
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor2 = this.b;
            jVar.a((java.util.concurrent.Future) ((threadPoolExecutor2 == null || threadPoolExecutor2.isShutdown()) ? null : (java.util.concurrent.FutureTask) this.b.submit(jVar)));
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(com.baidu.mobads.sdk.internal.j jVar, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(java.lang.System.currentTimeMillis());
            jVar.a((java.util.concurrent.Future) this.c.scheduleAtFixedRate(jVar, j, j2, timeUnit));
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(com.baidu.mobads.sdk.internal.j jVar, long j, java.util.concurrent.TimeUnit timeUnit) {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(java.lang.System.currentTimeMillis());
            jVar.a((java.util.concurrent.Future) this.c.schedule(jVar, j, timeUnit));
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(java.lang.Runnable runnable) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.b.submit(runnable);
        } catch (java.lang.Throwable unused) {
        }
    }
}
