package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class ThreadUtils {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    private static final java.util.concurrent.BlockingQueue<java.lang.Runnable> POOL_WORK_QUEUE;
    private static final java.util.concurrent.ThreadFactory THREAD_FACTORY;
    private static final java.util.concurrent.ThreadPoolExecutor THREAD_POOL_EXECUTOR;
    private static android.os.Handler sMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final java.lang.String TAG = com.aliyun.svideo.common.utils.ThreadUtils.class.getName();

    /* renamed from: com.aliyun.svideo.common.utils.ThreadUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger mCount = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "ThreadUtils #" + this.mCount.getAndIncrement());
        }
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = java.lang.Math.max(2, java.lang.Math.min(availableProcessors - 1, 4));
        CORE_POOL_SIZE = max;
        int i = (availableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i;
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue(128);
        POOL_WORK_QUEUE = linkedBlockingQueue;
        com.aliyun.svideo.common.utils.ThreadUtils.AnonymousClass1 anonymousClass1 = new com.aliyun.svideo.common.utils.ThreadUtils.AnonymousClass1();
        THREAD_FACTORY = anonymousClass1;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(max, i, 30L, java.util.concurrent.TimeUnit.SECONDS, linkedBlockingQueue, anonymousClass1);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public static void removeCallbacks(java.lang.Runnable runnable) {
        sMainHandler.removeCallbacks(runnable);
    }

    public static void runOnSubThread(java.lang.Runnable runnable) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = THREAD_POOL_EXECUTOR;
        if (threadPoolExecutor.getQueue().size() == 128 || threadPoolExecutor.isShutdown()) {
            return;
        }
        threadPoolExecutor.execute(runnable);
    }

    public static void runOnUiThread(java.lang.Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(java.lang.Runnable runnable, long j) {
        sMainHandler.postDelayed(runnable, j);
    }
}
