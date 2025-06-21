package com.getui.gtc.extension.distribution.gbd.m.a;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String b = "Up_SC";
    public final java.util.concurrent.ExecutorService a = new com.getui.gtc.extension.distribution.gbd.m.a.a.C0312a();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.m.a.a$a, reason: collision with other inner class name */
    public static class C0312a extends java.util.concurrent.ThreadPoolExecutor {

        /* renamed from: com.getui.gtc.extension.distribution.gbd.m.a.a$a$1, reason: invalid class name */
        public class AnonymousClass1 extends java.util.concurrent.ThreadPoolExecutor.DiscardPolicy {
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
                com.getui.gtc.extension.distribution.gbd.n.j.b("ClingExecutor", "rejectedExecution: " + runnable.getClass());
                super.rejectedExecution(runnable, threadPoolExecutor);
            }
        }

        public C0312a() {
            this(new com.getui.gtc.extension.distribution.gbd.m.a.a.b(), new com.getui.gtc.extension.distribution.gbd.m.a.a.C0312a.AnonymousClass1());
        }

        private C0312a(java.util.concurrent.ThreadFactory threadFactory, java.util.concurrent.RejectedExecutionHandler rejectedExecutionHandler) {
            super(0, 10, 30L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), threadFactory, rejectedExecutionHandler);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
            super.afterExecute(runnable, th);
        }
    }

    public static class b implements java.util.concurrent.ThreadFactory {
        protected final java.lang.ThreadGroup a;
        protected final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(1);
        protected final java.lang.String c = "cl-";

        public b() {
            java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.a, runnable, "cl-" + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.m.e.a a() {
        return new com.getui.gtc.extension.distribution.gbd.m.e.a(java.net.InetAddress.getByName("239.255.255.250"));
    }

    private java.util.concurrent.Executor b() {
        return this.a;
    }

    private static com.getui.gtc.extension.distribution.gbd.m.e.b c() {
        return new com.getui.gtc.extension.distribution.gbd.m.e.b();
    }

    private void d() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(b, "Shutting down default executor service");
        this.a.shutdownNow();
    }
}
