package cn.fly.verify;

/* loaded from: classes.dex */
public class ea {
    public static final java.lang.String a = "M-" + cn.fly.verify.bj.a("002@gkil");
    public static final java.lang.String b = "M-" + cn.fly.verify.bj.a("003 hmgdil");
    public static final java.util.concurrent.ThreadPoolExecutor c;
    public static final java.util.concurrent.ThreadPoolExecutor d;
    public static final java.util.concurrent.ExecutorService e;
    public static final java.util.concurrent.ExecutorService f;
    public static final java.util.concurrent.ExecutorService g;

    public static class a implements java.util.concurrent.RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            try {
                cn.fly.verify.bj.a().d(500L, runnable);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class b implements java.util.concurrent.ThreadFactory {
        private static final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);
        private final java.lang.ThreadGroup b;
        private final java.util.concurrent.atomic.AtomicInteger c = new java.util.concurrent.atomic.AtomicInteger(1);
        private final java.lang.String d;

        public b(int i) {
            java.lang.String str;
            java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
            if (android.text.TextUtils.isEmpty("M-")) {
                str = cn.fly.verify.bj.a("005kYfefe_hQil") + a.getAndIncrement() + cn.fly.verify.bj.a("008UilIji,ekOgeYedil");
            } else {
                str = cn.fly.verify.ea.b + i + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + a.getAndIncrement() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            this.d = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int max = java.lang.Math.max(2, 5);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        c = new java.util.concurrent.ThreadPoolExecutor(2, max, 60L, timeUnit, new java.util.concurrent.SynchronousQueue(), new cn.fly.verify.ea.b(0), new cn.fly.verify.ea.a());
        d = new java.util.concurrent.ThreadPoolExecutor(1, 1, 120L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new cn.fly.verify.ea.b(1));
        e = java.util.concurrent.Executors.newCachedThreadPool(new cn.fly.verify.ea.b(2));
        f = java.util.concurrent.Executors.newCachedThreadPool(new cn.fly.verify.ea.b(3));
        g = java.util.concurrent.Executors.newCachedThreadPool(new cn.fly.verify.ea.b(4));
    }
}
