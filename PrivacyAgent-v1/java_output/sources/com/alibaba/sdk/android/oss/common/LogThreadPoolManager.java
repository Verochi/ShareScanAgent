package com.alibaba.sdk.android.oss.common;

/* loaded from: classes.dex */
public class LogThreadPoolManager {
    private static final int PERIOD_TASK_QOS = 1000;
    private static final int SIZE_CACHE_QUEUE = 200;
    private static final int SIZE_CORE_POOL = 1;
    private static final int SIZE_MAX_POOL = 1;
    private static final int SIZE_WORK_QUEUE = 500;
    private static final int TIME_KEEP_ALIVE = 5000;
    private static com.alibaba.sdk.android.oss.common.LogThreadPoolManager sThreadPoolManager = new com.alibaba.sdk.android.oss.common.LogThreadPoolManager();
    private final java.lang.Runnable mAccessBufferThread;
    private final java.util.concurrent.RejectedExecutionHandler mHandler;
    protected final java.util.concurrent.ScheduledFuture<?> mTaskHandler;
    private final java.util.Queue<java.lang.Runnable> mTaskQueue = new java.util.LinkedList();
    private final java.util.concurrent.ThreadPoolExecutor mThreadPool;
    private final java.util.concurrent.ScheduledExecutorService scheduler;

    /* renamed from: com.alibaba.sdk.android.oss.common.LogThreadPoolManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.RejectedExecutionHandler {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            if (com.alibaba.sdk.android.oss.common.LogThreadPoolManager.this.mTaskQueue.size() >= 200) {
                com.alibaba.sdk.android.oss.common.LogThreadPoolManager.this.mTaskQueue.poll();
            }
            com.alibaba.sdk.android.oss.common.LogThreadPoolManager.this.mTaskQueue.offer(runnable);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.common.LogThreadPoolManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.ThreadFactory {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "oss-android-log-thread");
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.common.LogThreadPoolManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alibaba.sdk.android.oss.common.LogThreadPoolManager.this.hasMoreAcquire()) {
                com.alibaba.sdk.android.oss.common.LogThreadPoolManager.this.mThreadPool.execute((java.lang.Runnable) com.alibaba.sdk.android.oss.common.LogThreadPoolManager.this.mTaskQueue.poll());
            }
        }
    }

    private LogThreadPoolManager() {
        com.alibaba.sdk.android.oss.common.LogThreadPoolManager.AnonymousClass1 anonymousClass1 = new com.alibaba.sdk.android.oss.common.LogThreadPoolManager.AnonymousClass1();
        this.mHandler = anonymousClass1;
        java.util.concurrent.ScheduledExecutorService newScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(1);
        this.scheduler = newScheduledThreadPool;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        this.mThreadPool = new java.util.concurrent.ThreadPoolExecutor(1, 1, 5000L, timeUnit, new java.util.concurrent.ArrayBlockingQueue(500), new com.alibaba.sdk.android.oss.common.LogThreadPoolManager.AnonymousClass2(), anonymousClass1);
        com.alibaba.sdk.android.oss.common.LogThreadPoolManager.AnonymousClass3 anonymousClass3 = new com.alibaba.sdk.android.oss.common.LogThreadPoolManager.AnonymousClass3();
        this.mAccessBufferThread = anonymousClass3;
        this.mTaskHandler = newScheduledThreadPool.scheduleAtFixedRate(anonymousClass3, 0L, 1000L, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMoreAcquire() {
        return !this.mTaskQueue.isEmpty();
    }

    public static com.alibaba.sdk.android.oss.common.LogThreadPoolManager newInstance() {
        if (sThreadPoolManager == null) {
            sThreadPoolManager = new com.alibaba.sdk.android.oss.common.LogThreadPoolManager();
        }
        return sThreadPoolManager;
    }

    public void addExecuteTask(java.lang.Runnable runnable) {
        if (runnable != null) {
            this.mThreadPool.execute(runnable);
        }
    }
}
