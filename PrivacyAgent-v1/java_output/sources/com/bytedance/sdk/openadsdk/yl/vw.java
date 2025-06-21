package com.bytedance.sdk.openadsdk.yl;

/* loaded from: classes22.dex */
public final class vw {
    private static volatile com.bytedance.sdk.openadsdk.yl.vw vw;
    private volatile java.util.concurrent.ThreadPoolExecutor t;
    private volatile java.util.concurrent.ThreadPoolExecutor v;
    private volatile java.util.concurrent.ExecutorService wg;

    /* renamed from: com.bytedance.sdk.openadsdk.yl.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.openadsdk.yl.vw.this.t != null) {
                try {
                    com.bytedance.sdk.openadsdk.yl.vw vwVar = com.bytedance.sdk.openadsdk.yl.vw.this;
                    vwVar.vw(vwVar.t);
                    com.bytedance.sdk.openadsdk.api.t.wg("ApiThread", "release init pool!");
                } catch (java.lang.Throwable th) {
                    com.bytedance.sdk.openadsdk.api.t.vw("ApiThread", "release mInitExecutor failed", th);
                }
                com.bytedance.sdk.openadsdk.yl.vw.this.t = null;
            }
            if (com.bytedance.sdk.openadsdk.yl.vw.this.v != null) {
                try {
                    com.bytedance.sdk.openadsdk.yl.vw vwVar2 = com.bytedance.sdk.openadsdk.yl.vw.this;
                    vwVar2.vw(vwVar2.v);
                    com.bytedance.sdk.openadsdk.api.t.wg("ApiThread", "release api pool!");
                } catch (java.lang.Throwable th2) {
                    com.bytedance.sdk.openadsdk.api.t.vw("ApiThread", "release mApiExecutor failed", th2);
                }
                com.bytedance.sdk.openadsdk.yl.vw.this.v = null;
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.yl.vw$vw, reason: collision with other inner class name */
    public static class ThreadFactoryC0281vw implements java.util.concurrent.ThreadFactory {
        private final java.lang.String t;
        private final java.lang.ThreadGroup vw;
        private final java.util.concurrent.atomic.AtomicInteger wg;

        public ThreadFactoryC0281vw() {
            this.wg = new java.util.concurrent.atomic.AtomicInteger(1);
            this.vw = new java.lang.ThreadGroup("csj_api");
            this.t = "csj_api";
        }

        public ThreadFactoryC0281vw(java.lang.String str) {
            this.wg = new java.util.concurrent.atomic.AtomicInteger(1);
            this.vw = new java.lang.ThreadGroup("csj_api");
            this.t = "csj_api_".concat(java.lang.String.valueOf(str));
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.vw, runnable, this.t + "_" + this.wg.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }
    }

    private vw() {
    }

    private java.util.concurrent.ExecutorService t() {
        if (this.v == null) {
            this.v = new java.util.concurrent.ThreadPoolExecutor(2, 5, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.bytedance.sdk.openadsdk.yl.vw.ThreadFactoryC0281vw());
        }
        return this.v;
    }

    public static com.bytedance.sdk.openadsdk.yl.vw vw() {
        if (vw == null) {
            synchronized (com.bytedance.sdk.openadsdk.yl.vw.class) {
                vw = new com.bytedance.sdk.openadsdk.yl.vw();
            }
        }
        return vw;
    }

    private java.util.concurrent.ExecutorService vw(boolean z) {
        return this.wg == null ? z ? wg() : t() : this.wg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setKeepAliveTime(1L, java.util.concurrent.TimeUnit.MILLISECONDS);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        while (true) {
            try {
                java.lang.Thread.sleep(100L);
            } catch (java.lang.InterruptedException unused) {
            }
            if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }

    private java.util.concurrent.ExecutorService wg() {
        if (this.t == null) {
            this.t = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.bytedance.sdk.openadsdk.yl.vw.ThreadFactoryC0281vw("init"));
        }
        return this.t;
    }

    private void wg(java.util.concurrent.ExecutorService executorService) {
        executorService.execute(new com.bytedance.sdk.openadsdk.yl.vw.AnonymousClass1());
    }

    public void vw(java.lang.Runnable runnable) {
        if (runnable != null) {
            try {
                vw(true).execute(runnable);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void vw(java.util.concurrent.ExecutorService executorService) {
        if (executorService != null) {
            this.wg = executorService;
            if (this.v == null && this.t == null) {
                return;
            }
            wg(executorService);
        }
    }

    public void wg(java.lang.Runnable runnable) {
        if (runnable != null) {
            try {
                vw(false).execute(runnable);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
