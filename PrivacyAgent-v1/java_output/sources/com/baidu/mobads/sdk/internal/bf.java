package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
final class bf implements java.util.concurrent.ThreadFactory {
    private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, "TaskScheduler #" + this.a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new com.baidu.mobads.sdk.internal.bg(this));
        return thread;
    }
}
