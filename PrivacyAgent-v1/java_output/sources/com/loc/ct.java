package com.loc;

/* loaded from: classes23.dex */
public final class ct extends com.loc.cv {
    private static java.lang.Thread.UncaughtExceptionHandler c = new com.loc.ct.AnonymousClass1();
    private static com.loc.ct d = new com.loc.ct(new com.loc.cs.a().a(c).a("amap-global-threadPool").a());

    /* renamed from: com.loc.ct$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
            com.loc.aw.b(th, "TPool", "ThreadPool");
        }
    }

    private ct(com.loc.cs csVar) {
        try {
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(csVar.a(), csVar.b(), csVar.d(), java.util.concurrent.TimeUnit.SECONDS, csVar.c(), csVar);
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static com.loc.ct a() {
        return d;
    }
}
