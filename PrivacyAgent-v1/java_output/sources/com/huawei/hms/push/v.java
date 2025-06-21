package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class v {
    public static final java.lang.Object a = new java.lang.Object();
    public static java.util.concurrent.ThreadPoolExecutor b = new java.util.concurrent.ThreadPoolExecutor(1, 50, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());

    public static java.util.concurrent.ThreadPoolExecutor a() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        synchronized (a) {
            threadPoolExecutor = b;
        }
        return threadPoolExecutor;
    }
}
