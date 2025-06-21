package com.getui.gtc.base.util;

/* loaded from: classes22.dex */
public class ScheduleQueue {
    private static final java.lang.String TAG = "ScheduleQueue";
    private static final java.util.concurrent.atomic.AtomicInteger poolNumber = new java.util.concurrent.atomic.AtomicInteger(1);
    private java.util.concurrent.ScheduledThreadPoolExecutor exec;

    /* renamed from: com.getui.gtc.base.util.ScheduleQueue$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.getui.gtc.base.util.ScheduleQueue$1$1, reason: invalid class name and collision with other inner class name */
        public class C02961 implements java.lang.Thread.UncaughtExceptionHandler {
            public C02961() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                new java.lang.StringBuilder("caught an exception from ").append(thread.getName());
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("Gtc-ScheduleQueue-" + com.getui.gtc.base.util.ScheduleQueue.poolNumber.getAndIncrement());
            thread.setUncaughtExceptionHandler(new com.getui.gtc.base.util.ScheduleQueue.AnonymousClass1.C02961());
            return thread;
        }
    }

    public static class SingletonHolder {
        private static final com.getui.gtc.base.util.ScheduleQueue instance = new com.getui.gtc.base.util.ScheduleQueue(null);

        private SingletonHolder() {
        }
    }

    private ScheduleQueue() {
        this.exec = null;
        this.exec = new java.util.concurrent.ScheduledThreadPoolExecutor(1, new com.getui.gtc.base.util.ScheduleQueue.AnonymousClass1());
    }

    public /* synthetic */ ScheduleQueue(com.getui.gtc.base.util.ScheduleQueue.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.base.util.ScheduleQueue getInstance() {
        return com.getui.gtc.base.util.ScheduleQueue.SingletonHolder.instance;
    }

    public boolean addSchedule(java.lang.Runnable runnable) {
        try {
            this.exec.execute(runnable);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean addSchedule(java.lang.Runnable runnable, long j) {
        try {
            this.exec.schedule(runnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean addSchedule(java.lang.Runnable runnable, long j, long j2) {
        try {
            this.exec.scheduleAtFixedRate(runnable, j, j2, java.util.concurrent.TimeUnit.MILLISECONDS);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public java.util.concurrent.ScheduledFuture<?> addScheduler(java.lang.Runnable runnable, long j, long j2) {
        try {
            return this.exec.scheduleAtFixedRate(runnable, j, j2, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public void shutDown() {
        this.exec.shutdown();
    }
}
