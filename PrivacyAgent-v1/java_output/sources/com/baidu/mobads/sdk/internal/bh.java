package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
final class bh implements java.util.concurrent.RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor2;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor3;
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue;
        java.util.concurrent.ThreadFactory threadFactory;
        com.baidu.mobads.sdk.internal.ay.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            threadPoolExecutor2 = com.baidu.mobads.sdk.internal.be.d;
            if (threadPoolExecutor2 == null) {
                java.util.concurrent.LinkedBlockingQueue unused = com.baidu.mobads.sdk.internal.be.e = new java.util.concurrent.LinkedBlockingQueue();
                java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
                linkedBlockingQueue = com.baidu.mobads.sdk.internal.be.e;
                threadFactory = com.baidu.mobads.sdk.internal.be.f;
                java.util.concurrent.ThreadPoolExecutor unused2 = com.baidu.mobads.sdk.internal.be.d = new java.util.concurrent.ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
            }
        }
        threadPoolExecutor3 = com.baidu.mobads.sdk.internal.be.d;
        threadPoolExecutor3.execute(runnable);
    }
}
