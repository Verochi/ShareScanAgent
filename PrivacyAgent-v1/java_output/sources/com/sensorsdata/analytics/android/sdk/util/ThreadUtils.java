package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class ThreadUtils {
    private static final java.lang.String TAG = "SA.ThreadUtils";
    private static final java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.util.concurrent.ExecutorService>> TYPE_PRIORITY_POOLS = new java.util.HashMap();
    private static final byte TYPE_SINGLE = -1;

    public static final class LinkedBlockingQueueUtil extends java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> {
        private int mCapacity;
        private volatile com.sensorsdata.analytics.android.sdk.util.ThreadUtils.ThreadPoolExecutorUtil mPool;

        public LinkedBlockingQueueUtil() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        public LinkedBlockingQueueUtil(int i) {
            this.mCapacity = i;
        }

        public LinkedBlockingQueueUtil(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(java.lang.Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((com.sensorsdata.analytics.android.sdk.util.ThreadUtils.LinkedBlockingQueueUtil) runnable);
            }
            return false;
        }
    }

    public static final class ThreadPoolExecutorUtil extends java.util.concurrent.ThreadPoolExecutor {
        private final java.util.concurrent.atomic.AtomicInteger mSubmittedCount;
        private com.sensorsdata.analytics.android.sdk.util.ThreadUtils.LinkedBlockingQueueUtil mWorkQueue;

        public ThreadPoolExecutorUtil(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, com.sensorsdata.analytics.android.sdk.util.ThreadUtils.LinkedBlockingQueueUtil linkedBlockingQueueUtil, java.util.concurrent.ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueueUtil, threadFactory);
            this.mSubmittedCount = new java.util.concurrent.atomic.AtomicInteger();
            linkedBlockingQueueUtil.mPool = this;
            this.mWorkQueue = linkedBlockingQueueUtil;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static java.util.concurrent.ExecutorService createPool(int i, int i2) {
            if (i == -1) {
                return new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.ThreadPoolExecutorUtil(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.LinkedBlockingQueueUtil(), new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.UtilsThreadFactory("single", i2));
            }
            return new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.ThreadPoolExecutorUtil(i, i, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.LinkedBlockingQueueUtil(), new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.UtilsThreadFactory("fixed(" + i + ")", i2));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.mSubmittedCount.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (java.util.concurrent.RejectedExecutionException unused) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.util.ThreadUtils.TAG, "This will not happen!");
                this.mWorkQueue.offer(runnable);
            } catch (java.lang.Throwable unused2) {
                this.mSubmittedCount.decrementAndGet();
            }
        }
    }

    public static final class UtilsThreadFactory extends java.util.concurrent.atomic.AtomicLong implements java.util.concurrent.ThreadFactory {
        private static final java.util.concurrent.atomic.AtomicInteger POOL_NUMBER = new java.util.concurrent.atomic.AtomicInteger(1);
        private final boolean isDaemon;
        private final java.lang.String namePrefix;
        private final int priority;

        /* renamed from: com.sensorsdata.analytics.android.sdk.util.ThreadUtils$UtilsThreadFactory$1, reason: invalid class name */
        public class AnonymousClass1 extends java.lang.Thread {
            public AnonymousClass1(java.lang.Runnable runnable, java.lang.String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (java.lang.Throwable unused) {
                    com.sensorsdata.analytics.android.sdk.SALog.i("ThreadUtils", "Request threw uncaught throwable");
                }
            }
        }

        public UtilsThreadFactory(java.lang.String str, int i) {
            this(str, i, false);
        }

        public UtilsThreadFactory(java.lang.String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            com.sensorsdata.analytics.android.sdk.util.ThreadUtils.UtilsThreadFactory.AnonymousClass1 anonymousClass1 = new com.sensorsdata.analytics.android.sdk.util.ThreadUtils.UtilsThreadFactory.AnonymousClass1(runnable, this.namePrefix + getAndIncrement());
            anonymousClass1.setDaemon(this.isDaemon);
            anonymousClass1.setPriority(this.priority);
            return anonymousClass1;
        }
    }

    private static java.util.concurrent.ExecutorService getPoolByTypeAndPriority(int i) {
        return getPoolByTypeAndPriority(i, 5);
    }

    private static java.util.concurrent.ExecutorService getPoolByTypeAndPriority(int i, int i2) {
        java.util.concurrent.ExecutorService executorService;
        java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.util.concurrent.ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            java.util.Map<java.lang.Integer, java.util.concurrent.ExecutorService> map2 = map.get(java.lang.Integer.valueOf(i));
            if (map2 == null) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
                executorService = com.sensorsdata.analytics.android.sdk.util.ThreadUtils.ThreadPoolExecutorUtil.createPool(i, i2);
                concurrentHashMap.put(java.lang.Integer.valueOf(i2), executorService);
                map.put(java.lang.Integer.valueOf(i), concurrentHashMap);
            } else {
                executorService = map2.get(java.lang.Integer.valueOf(i2));
                if (executorService == null) {
                    executorService = com.sensorsdata.analytics.android.sdk.util.ThreadUtils.ThreadPoolExecutorUtil.createPool(i, i2);
                    map2.put(java.lang.Integer.valueOf(i2), executorService);
                }
            }
        }
        return executorService;
    }

    public static java.util.concurrent.ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static java.util.concurrent.ExecutorService getSinglePool(int i) {
        return getPoolByTypeAndPriority(-1, i);
    }
}
