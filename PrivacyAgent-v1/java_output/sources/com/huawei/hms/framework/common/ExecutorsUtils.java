package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ExecutorsUtils {
    private static final java.lang.String THREADNAME_HEADER = "NetworkKit_";

    /* renamed from: com.huawei.hms.framework.common.ExecutorsUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger threadNumbers = new java.util.concurrent.atomic.AtomicInteger(0);
        final /* synthetic */ java.lang.String val$threadName;

        public AnonymousClass1(java.lang.String str) {
            this.val$threadName = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, com.huawei.hms.framework.common.ExecutorsUtils.THREADNAME_HEADER + this.val$threadName + "_" + this.threadNumbers.getAndIncrement());
        }
    }

    public static java.util.concurrent.ThreadFactory createThreadFactory(java.lang.String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new java.lang.NullPointerException("ThreadName is empty");
        }
        return new com.huawei.hms.framework.common.ExecutorsUtils.AnonymousClass1(str);
    }

    public static java.util.concurrent.ExecutorService newCachedThreadPool(java.lang.String str) {
        return new com.huawei.hms.framework.common.ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), createThreadFactory(str));
    }

    public static java.util.concurrent.ExecutorService newFixedThreadPool(int i, java.lang.String str) {
        return new com.huawei.hms.framework.common.ThreadPoolExcutorEnhance(i, i, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), createThreadFactory(str));
    }

    public static java.util.concurrent.ScheduledExecutorService newScheduledThreadPool(int i, java.lang.String str) {
        return new com.huawei.hms.framework.common.ScheduledThreadPoolExecutorEnhance(i, createThreadFactory(str));
    }

    public static java.util.concurrent.ExecutorService newSingleThreadExecutor(java.lang.String str) {
        return com.huawei.hms.framework.common.ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(str));
    }
}
