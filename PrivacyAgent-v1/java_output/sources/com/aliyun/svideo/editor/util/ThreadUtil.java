package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class ThreadUtil {
    private static int corePoolSize = 1;
    private static int keepAliveTime = 60;
    private static int maximumPoolSize = 1;

    public static java.util.concurrent.ExecutorService newDynamicSingleThreadedExecutor(java.util.concurrent.ThreadFactory threadFactory) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), threadFactory, new java.util.concurrent.ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
