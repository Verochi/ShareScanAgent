package com.tanx.onlyid.api;

/* loaded from: classes19.dex */
public class ThreadPool {
    public static long a;
    public static java.util.concurrent.ThreadPoolExecutor b;
    public static android.os.Handler c;

    /* renamed from: com.tanx.onlyid.api.ThreadPool$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "UserReportAddThreadPool-" + com.tanx.onlyid.api.ThreadPool.a());
        }
    }

    /* renamed from: com.tanx.onlyid.api.ThreadPool$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* renamed from: com.tanx.onlyid.api.ThreadPool$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Runnable n;

        public AnonymousClass3(java.lang.Runnable runnable) {
            this.n = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tanx.onlyid.api.ThreadPool.post(this.n);
        }
    }

    static {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(2, 4, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(100), new com.tanx.onlyid.api.ThreadPool.AnonymousClass1());
        b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b.setRejectedExecutionHandler(new com.tanx.onlyid.api.ThreadPool.AnonymousClass2());
    }

    public static /* synthetic */ long a() {
        long j = a;
        a = 1 + j;
        return j;
    }

    public static void post(java.lang.Runnable runnable) {
        try {
            b.execute(runnable);
        } catch (java.lang.Throwable unused) {
            com.tanx.onlyid.api.OAIDLog.print("UserReportAddThreadPool", "post error");
        }
    }

    public static void postDelayed(java.lang.Runnable runnable, int i) {
        if (i == 0) {
            post(runnable);
        } else if (i > 0) {
            if (c == null) {
                c = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            c.postDelayed(new com.tanx.onlyid.api.ThreadPool.AnonymousClass3(runnable), i);
        }
    }

    public static void removeTask(java.lang.Runnable runnable) {
        android.os.Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
