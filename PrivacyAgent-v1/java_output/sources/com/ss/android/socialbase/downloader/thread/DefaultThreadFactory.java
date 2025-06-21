package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
    private final boolean ignoreStatusCheck;
    private final java.lang.String threadName;
    private final java.util.concurrent.atomic.AtomicInteger threadSeq;

    public DefaultThreadFactory(java.lang.String str) {
        this(str, false);
    }

    public DefaultThreadFactory(java.lang.String str, boolean z) {
        this.threadSeq = new java.util.concurrent.atomic.AtomicInteger();
        this.threadName = str;
        this.ignoreStatusCheck = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, this.threadName + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.threadSeq.incrementAndGet());
        if (!this.ignoreStatusCheck) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }
}
