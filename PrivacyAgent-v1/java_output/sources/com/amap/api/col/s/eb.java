package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class eb extends com.amap.api.col.s.ed {
    public static com.amap.api.col.s.eb d = new com.amap.api.col.s.eb(new com.amap.api.col.s.ea.a().a("amap-global-threadPool").a());

    public eb(com.amap.api.col.s.ea eaVar) {
        try {
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(eaVar.a(), eaVar.b(), eaVar.d(), java.util.concurrent.TimeUnit.SECONDS, eaVar.c(), eaVar);
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static com.amap.api.col.s.eb a() {
        return d;
    }
}
