package com.efs.sdk.base.core.util.concurrent;

/* loaded from: classes22.dex */
public class WorkThreadUtil {
    public static final int DEFAULT_THREAD_POOL_MAX_CNT = 2;
    private static java.util.concurrent.ThreadPoolExecutor a = new java.util.concurrent.ThreadPoolExecutor(2, 2, 10, java.util.concurrent.TimeUnit.MINUTES, new java.util.concurrent.LinkedBlockingQueue(Integer.MAX_VALUE), new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());

    public static java.util.concurrent.Future<?> submit(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        try {
            return a.submit(runnable);
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.util.concurrent", "submit task error!", th);
            return null;
        }
    }
}
