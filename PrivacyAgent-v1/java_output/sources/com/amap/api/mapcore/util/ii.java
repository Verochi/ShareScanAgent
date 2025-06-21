package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ii extends com.amap.api.mapcore.util.ik {
    private static com.amap.api.mapcore.util.ii c = new com.amap.api.mapcore.util.ii(new com.amap.api.mapcore.util.ih.a().a("amap-global-threadPool").b());

    private ii(com.amap.api.mapcore.util.ih ihVar) {
        try {
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(ihVar.a(), ihVar.b(), ihVar.d(), java.util.concurrent.TimeUnit.SECONDS, ihVar.c(), ihVar);
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static com.amap.api.mapcore.util.ii a() {
        return c;
    }

    public static com.amap.api.mapcore.util.ii a(com.amap.api.mapcore.util.ih ihVar) {
        return new com.amap.api.mapcore.util.ii(ihVar);
    }

    @java.lang.Deprecated
    public static synchronized com.amap.api.mapcore.util.ii b() {
        com.amap.api.mapcore.util.ii iiVar;
        synchronized (com.amap.api.mapcore.util.ii.class) {
            if (c == null) {
                c = new com.amap.api.mapcore.util.ii(new com.amap.api.mapcore.util.ih.a().b());
            }
            iiVar = c;
        }
        return iiVar;
    }

    @java.lang.Deprecated
    public static com.amap.api.mapcore.util.ii c() {
        return new com.amap.api.mapcore.util.ii(new com.amap.api.mapcore.util.ih.a().b());
    }
}
