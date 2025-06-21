package com.alimm.tanx.core.common;

/* loaded from: classes.dex */
public class tanxc_do {
    private static long tanxc_do;
    private static final java.util.concurrent.ThreadPoolExecutor tanxc_if;

    /* renamed from: com.alimm.tanx.core.common.tanxc_do$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "AdThread-" + com.alimm.tanx.core.common.tanxc_do.tanxc_do());
        }
    }

    /* renamed from: com.alimm.tanx.core.common.tanxc_do$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    static {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 4, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(100), new com.alimm.tanx.core.common.tanxc_do.AnonymousClass1());
        tanxc_if = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new com.alimm.tanx.core.common.tanxc_do.AnonymousClass2());
    }

    public static /* synthetic */ long tanxc_do() {
        long j = tanxc_do;
        tanxc_do = 1 + j;
        return j;
    }

    public static void tanxc_do(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        try {
            tanxc_if.execute(runnable);
        } catch (java.lang.Throwable th) {
            com.alimm.tanx.core.utils.LogUtils.d("AdThreadPoolExecutor", "post exception", th);
        }
    }
}
