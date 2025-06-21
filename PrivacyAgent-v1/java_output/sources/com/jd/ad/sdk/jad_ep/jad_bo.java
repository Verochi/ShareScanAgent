package com.jd.ad.sdk.jad_ep;

/* loaded from: classes23.dex */
public class jad_bo {
    public static final java.util.concurrent.ThreadPoolExecutor jad_an;
    public static final java.util.concurrent.ThreadPoolExecutor jad_bo;
    public static final java.util.concurrent.ThreadPoolExecutor jad_cp;
    public static final java.util.concurrent.ThreadPoolExecutor jad_dq;

    public static class jad_an implements java.util.concurrent.ThreadFactory {
        public final java.lang.String jad_an;
        public final java.util.concurrent.atomic.AtomicInteger jad_bo = new java.util.concurrent.atomic.AtomicInteger(1);

        public jad_an(java.lang.String str) {
            this.jad_an = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("$");
            jad_an.append(this.jad_an);
            jad_an.append(" Request #");
            jad_an.append(this.jad_bo.getAndIncrement());
            return new java.lang.Thread(runnable, jad_an.toString());
        }
    }

    static {
        java.lang.Runtime.getRuntime().availableProcessors();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(2, 2, 30L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.jd.ad.sdk.jad_ep.jad_bo.jad_an("gw"));
        jad_an = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        threadPoolExecutor.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("gw"));
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor2 = new java.util.concurrent.ThreadPoolExecutor(2, 2, 30L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.jd.ad.sdk.jad_ep.jad_bo.jad_an("xlog"));
        jad_bo = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(false);
        threadPoolExecutor2.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("xlog"));
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor3 = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.jd.ad.sdk.jad_ep.jad_bo.jad_an(com.alipay.sdk.m.s.a.u));
        jad_cp = threadPoolExecutor3;
        threadPoolExecutor3.allowCoreThreadTimeOut(false);
        threadPoolExecutor3.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an(com.alipay.sdk.m.s.a.u));
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor4 = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.jd.ad.sdk.jad_ep.jad_bo.jad_an("video"));
        jad_dq = threadPoolExecutor4;
        threadPoolExecutor4.allowCoreThreadTimeOut(false);
        threadPoolExecutor4.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("video"));
    }
}
