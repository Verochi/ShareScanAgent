package com.alimm.tanx.core.ut.core.thread;

/* loaded from: classes.dex */
public class FileThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int DEFAULT_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = 4;
    private static final java.lang.String TAG = "UserReportAddThreadPool";
    private static final java.util.concurrent.ThreadPoolExecutor sExecutor;
    private static android.os.Handler sHandler;
    private static long sIndex;

    /* renamed from: com.alimm.tanx.core.ut.core.thread.FileThreadPool$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "UserReportAddThreadPool-" + com.alimm.tanx.core.ut.core.thread.FileThreadPool.access$008());
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.thread.FileThreadPool$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* renamed from: com.alimm.tanx.core.ut.core.thread.FileThreadPool$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Runnable val$runnable;

        public AnonymousClass3(java.lang.Runnable runnable) {
            this.val$runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.ut.core.thread.FileThreadPool.post(this.val$runnable);
        }
    }

    static {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(1, 4, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(100), new com.alimm.tanx.core.ut.core.thread.FileThreadPool.AnonymousClass1());
        sExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new com.alimm.tanx.core.ut.core.thread.FileThreadPool.AnonymousClass2());
    }

    public static /* synthetic */ long access$008() {
        long j = sIndex;
        sIndex = 1 + j;
        return j;
    }

    public static void post(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        try {
            sExecutor.execute(runnable);
        } catch (java.lang.Throwable th) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :post exception", th);
        }
    }

    public static void postDelayed(@androidx.annotation.NonNull java.lang.Runnable runnable, int i) {
        if (i == 0) {
            post(runnable);
        } else if (i > 0) {
            if (sHandler == null) {
                sHandler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            sHandler.postDelayed(new com.alimm.tanx.core.ut.core.thread.FileThreadPool.AnonymousClass3(runnable), i);
        }
    }

    public static void removeTask(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        android.os.Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
