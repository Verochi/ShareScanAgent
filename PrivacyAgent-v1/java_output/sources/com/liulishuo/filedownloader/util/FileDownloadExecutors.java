package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class FileDownloadExecutors {

    public static class FileDownloadThreadFactory implements java.util.concurrent.ThreadFactory {
        public static final java.util.concurrent.atomic.AtomicInteger v = new java.util.concurrent.atomic.AtomicInteger(1);
        public final java.lang.String n;
        public final java.util.concurrent.atomic.AtomicInteger u = new java.util.concurrent.atomic.AtomicInteger(1);
        public final java.lang.ThreadGroup t = java.lang.Thread.currentThread().getThreadGroup();

        public FileDownloadThreadFactory(java.lang.String str) {
            this.n = com.liulishuo.filedownloader.util.FileDownloadUtils.getThreadPoolName(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.t, runnable, this.n + this.u.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static java.util.concurrent.ThreadPoolExecutor newDefaultThreadPool(int i, java.lang.String str) {
        return newDefaultThreadPool(i, new java.util.concurrent.LinkedBlockingQueue(), str);
    }

    public static java.util.concurrent.ThreadPoolExecutor newDefaultThreadPool(int i, java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> linkedBlockingQueue, java.lang.String str) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i, 15L, java.util.concurrent.TimeUnit.SECONDS, linkedBlockingQueue, new com.liulishuo.filedownloader.util.FileDownloadExecutors.FileDownloadThreadFactory(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static java.util.concurrent.ThreadPoolExecutor newFixedThreadPool(java.lang.String str) {
        return new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.liulishuo.filedownloader.util.FileDownloadExecutors.FileDownloadThreadFactory(str));
    }
}
