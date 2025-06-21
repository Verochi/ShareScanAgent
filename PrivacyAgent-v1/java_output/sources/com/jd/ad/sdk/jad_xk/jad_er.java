package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_er {
    public static final java.util.concurrent.ScheduledThreadPoolExecutor jad_an;

    public class jad_an implements java.util.concurrent.RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            com.jd.ad.sdk.logger.Logger.d("execute rejected");
        }
    }

    static {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(2);
        jad_an = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, java.util.concurrent.TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_xk.jad_er.jad_an());
    }
}
