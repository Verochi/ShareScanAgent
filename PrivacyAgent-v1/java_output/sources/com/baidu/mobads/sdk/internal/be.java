package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class be {
    private static final java.lang.String a = "ThreadPoolFactory";
    private static final int b = 2;
    private static final int c = 60;
    private static java.util.concurrent.ThreadPoolExecutor d;
    private static java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> e;
    private static final java.util.concurrent.ThreadFactory f = new com.baidu.mobads.sdk.internal.bf();
    private static final java.util.concurrent.RejectedExecutionHandler g = new com.baidu.mobads.sdk.internal.bh();

    public static java.util.concurrent.ScheduledThreadPoolExecutor a(int i) {
        return new java.util.concurrent.ScheduledThreadPoolExecutor(i, f);
    }

    public static java.util.concurrent.ThreadPoolExecutor a(int i, int i2) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i2, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), f);
        threadPoolExecutor.setRejectedExecutionHandler(g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
