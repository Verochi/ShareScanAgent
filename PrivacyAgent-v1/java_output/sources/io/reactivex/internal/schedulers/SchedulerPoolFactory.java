package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final int PURGE_PERIOD_SECONDS;
    public static final java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> a = new java.util.concurrent.atomic.AtomicReference<>();
    public static final java.util.Map<java.util.concurrent.ScheduledThreadPoolExecutor, java.lang.Object> b = new java.util.concurrent.ConcurrentHashMap();

    public static final class ScheduledTask implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator it = new java.util.ArrayList(io.reactivex.internal.schedulers.SchedulerPoolFactory.b.keySet()).iterator();
            while (it.hasNext()) {
                java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (java.util.concurrent.ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    io.reactivex.internal.schedulers.SchedulerPoolFactory.b.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    public static final class SystemPropertyAccessor implements io.reactivex.functions.Function<java.lang.String, java.lang.String> {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String apply(java.lang.String str) throws java.lang.Exception {
            return java.lang.System.getProperty(str);
        }
    }

    static {
        io.reactivex.internal.schedulers.SchedulerPoolFactory.SystemPropertyAccessor systemPropertyAccessor = new io.reactivex.internal.schedulers.SchedulerPoolFactory.SystemPropertyAccessor();
        boolean a2 = a(true, "rx2.purge-enabled", true, true, systemPropertyAccessor);
        PURGE_ENABLED = a2;
        PURGE_PERIOD_SECONDS = b(a2, "rx2.purge-period-seconds", 1, 1, systemPropertyAccessor);
        start();
    }

    public SchedulerPoolFactory() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static boolean a(boolean z, java.lang.String str, boolean z2, boolean z3, io.reactivex.functions.Function<java.lang.String, java.lang.String> function) {
        if (!z) {
            return z3;
        }
        try {
            java.lang.String apply = function.apply(str);
            return apply == null ? z2 : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(apply);
        } catch (java.lang.Throwable unused) {
            return z2;
        }
    }

    public static int b(boolean z, java.lang.String str, int i, int i2, io.reactivex.functions.Function<java.lang.String, java.lang.String> function) {
        if (!z) {
            return i2;
        }
        try {
            java.lang.String apply = function.apply(str);
            return apply == null ? i : java.lang.Integer.parseInt(apply);
        } catch (java.lang.Throwable unused) {
            return i;
        }
    }

    public static void c(boolean z, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof java.util.concurrent.ScheduledThreadPoolExecutor)) {
            b.put((java.util.concurrent.ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static java.util.concurrent.ScheduledExecutorService create(java.util.concurrent.ThreadFactory threadFactory) {
        java.util.concurrent.ScheduledExecutorService newScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(1, threadFactory);
        c(PURGE_ENABLED, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static void d(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> atomicReference = a;
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            java.util.concurrent.ScheduledExecutorService newScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(1, new io.reactivex.internal.schedulers.RxThreadFactory("RxSchedulerPurge"));
            if (defpackage.xv0.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                io.reactivex.internal.schedulers.SchedulerPoolFactory.ScheduledTask scheduledTask = new io.reactivex.internal.schedulers.SchedulerPoolFactory.ScheduledTask();
                int i = PURGE_PERIOD_SECONDS;
                newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i, i, java.util.concurrent.TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    public static void shutdown() {
        java.util.concurrent.ScheduledExecutorService andSet = a.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        b.clear();
    }

    public static void start() {
        d(PURGE_ENABLED);
    }
}
