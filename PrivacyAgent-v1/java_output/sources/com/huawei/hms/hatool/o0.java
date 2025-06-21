package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class o0 {
    public static com.huawei.hms.hatool.o0 b;
    public static com.huawei.hms.hatool.o0 c;
    public static com.huawei.hms.hatool.o0 d;
    public java.util.concurrent.ThreadPoolExecutor a = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60000, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(5000), new com.huawei.hms.hatool.o0.b());

    public static class a implements java.lang.Runnable {
        public java.lang.Runnable a;

        public a(java.lang.Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (java.lang.Exception unused) {
                    com.huawei.hms.hatool.y.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    public static class b implements java.util.concurrent.ThreadFactory {
        public static final java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(1);
        public final java.lang.ThreadGroup a;
        public final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(1);
        public final java.lang.String c;

        public b() {
            java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
            this.c = "FormalHASDK-base-" + d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
        }
    }

    static {
        new com.huawei.hms.hatool.o0();
        new com.huawei.hms.hatool.o0();
        b = new com.huawei.hms.hatool.o0();
        c = new com.huawei.hms.hatool.o0();
        d = new com.huawei.hms.hatool.o0();
    }

    public static com.huawei.hms.hatool.o0 a() {
        return d;
    }

    public static com.huawei.hms.hatool.o0 b() {
        return c;
    }

    public static com.huawei.hms.hatool.o0 c() {
        return b;
    }

    public void a(com.huawei.hms.hatool.n0 n0Var) {
        try {
            this.a.execute(new com.huawei.hms.hatool.o0.a(n0Var));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            com.huawei.hms.hatool.y.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
