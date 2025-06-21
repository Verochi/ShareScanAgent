package com.jd.ad.sdk.jad_ep;

/* loaded from: classes23.dex */
public final class jad_cp {
    public static final java.util.concurrent.ScheduledThreadPoolExecutor jad_an;

    static {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
        jad_an = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, java.util.concurrent.TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("video"));
    }
}
