package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
class HttpTaskManager {
    private static final int POOL_SIZE = 2;
    private static volatile java.util.concurrent.ExecutorService executor;

    public static class ThreadFactoryWithName implements java.util.concurrent.ThreadFactory {
        private final java.lang.String name;

        public ThreadFactoryWithName(java.lang.String str) {
            this.name = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, this.name);
        }
    }

    private HttpTaskManager() {
    }

    public static void execute(java.lang.Runnable runnable) {
        getInstance().execute(runnable);
    }

    private static java.util.concurrent.ExecutorService getInstance() {
        if (executor == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.network.HttpTaskManager.class) {
                if (executor == null) {
                    executor = new java.util.concurrent.ThreadPoolExecutor(2, 2, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.sensorsdata.analytics.android.sdk.network.HttpTaskManager.ThreadFactoryWithName(com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_DEEP_LINK_REQUEST));
                }
            }
        }
        return executor;
    }
}
