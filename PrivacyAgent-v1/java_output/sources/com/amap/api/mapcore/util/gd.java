package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gd extends com.amap.api.mapcore.util.ga implements java.lang.Thread.UncaughtExceptionHandler {
    private static java.util.concurrent.ExecutorService e;
    private static java.lang.ref.WeakReference<android.content.Context> g;
    private android.content.Context d;
    private static java.util.Set<java.lang.Integer> f = java.util.Collections.synchronizedSet(new java.util.HashSet());
    private static final java.util.concurrent.ThreadFactory h = new com.amap.api.mapcore.util.gd.AnonymousClass2();

    /* renamed from: com.amap.api.mapcore.util.gd$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ com.amap.api.mapcore.util.fh a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(com.amap.api.mapcore.util.fh fhVar, boolean z) {
            this.a = fhVar;
            this.b = z;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                synchronized (android.os.Looper.getMainLooper()) {
                    com.amap.api.mapcore.util.gb.a(this.a);
                }
                if (this.b) {
                    com.amap.api.mapcore.util.ge.a(com.amap.api.mapcore.util.gd.this.d);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.gd$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);

        /* renamed from: com.amap.api.mapcore.util.gd$2$1, reason: invalid class name */
        public class AnonymousClass1 extends java.lang.Thread {
            public AnonymousClass1(java.lang.Runnable runnable, java.lang.String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (java.lang.Throwable unused) {
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new com.amap.api.mapcore.util.gd.AnonymousClass2.AnonymousClass1(runnable, "pama#" + this.a.getAndIncrement());
        }
    }

    private gd(android.content.Context context) {
        this.d = context;
        try {
            java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
            this.b = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            java.lang.String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.c = false;
            } else {
                java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized com.amap.api.mapcore.util.gd a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar) throws com.amap.api.mapcore.util.eu {
        synchronized (com.amap.api.mapcore.util.gd.class) {
            try {
                if (fhVar == null) {
                    throw new com.amap.api.mapcore.util.eu("sdk info is null");
                }
                if (fhVar.a() == null || "".equals(fhVar.a())) {
                    throw new com.amap.api.mapcore.util.eu("sdk name is invalid");
                }
                try {
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (!f.add(java.lang.Integer.valueOf(fhVar.hashCode()))) {
                    return (com.amap.api.mapcore.util.gd) com.amap.api.mapcore.util.ga.a;
                }
                com.amap.api.mapcore.util.ga gaVar = com.amap.api.mapcore.util.ga.a;
                if (gaVar == null) {
                    com.amap.api.mapcore.util.ga.a = new com.amap.api.mapcore.util.gd(context);
                } else {
                    gaVar.c = false;
                }
                com.amap.api.mapcore.util.ga gaVar2 = com.amap.api.mapcore.util.ga.a;
                gaVar2.a(fhVar, gaVar2.c);
                return (com.amap.api.mapcore.util.gd) com.amap.api.mapcore.util.ga.a;
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            g = new java.lang.ref.WeakReference<>(context.getApplicationContext());
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.amap.api.mapcore.util.ge.a(context, fhVar, str, 0, str2, str3);
    }

    public static void a(com.amap.api.mapcore.util.fh fhVar, java.lang.String str, com.amap.api.mapcore.util.eu euVar) {
        a(fhVar, str, euVar.c(), euVar.d(), euVar.e(), euVar.b());
    }

    public static void a(com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        try {
            if (com.amap.api.mapcore.util.ga.a != null) {
                com.amap.api.mapcore.util.ga.a.a(fhVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016 A[Catch: all -> 0x002a, TryCatch #1 {all -> 0x002a, blocks: (B:9:0x0012, B:11:0x0016, B:13:0x001e, B:15:0x0022, B:16:0x0025), top: B:8:0x0012, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b() {
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (com.amap.api.mapcore.util.gd.class) {
            try {
                try {
                    java.util.concurrent.ExecutorService executorService = e;
                    if (executorService != null) {
                        executorService.shutdown();
                    }
                    com.amap.api.mapcore.util.gy.a();
                } finally {
                    if (com.amap.api.mapcore.util.ga.a != null) {
                    }
                    com.amap.api.mapcore.util.ga.a = null;
                }
                if (com.amap.api.mapcore.util.ga.a != null) {
                    java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
                    com.amap.api.mapcore.util.ga gaVar = com.amap.api.mapcore.util.ga.a;
                    if (defaultUncaughtExceptionHandler == gaVar && (uncaughtExceptionHandler = gaVar.b) != null) {
                        java.lang.Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                    }
                }
                com.amap.api.mapcore.util.ga.a = null;
            } catch (java.lang.Throwable th) {
            }
        }
    }

    public static void b(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.amap.api.mapcore.util.ge.a(context, fhVar, str, 1, str2, str3);
    }

    public static void b(com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2) {
        try {
            com.amap.api.mapcore.util.ga gaVar = com.amap.api.mapcore.util.ga.a;
            if (gaVar != null) {
                gaVar.a(fhVar, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            com.amap.api.mapcore.util.gb.a(g.get());
            return;
        }
        com.amap.api.mapcore.util.ga gaVar = com.amap.api.mapcore.util.ga.a;
        if (gaVar != null) {
            gaVar.a();
        }
    }

    public static void c(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        try {
            com.amap.api.mapcore.util.ga gaVar = com.amap.api.mapcore.util.ga.a;
            if (gaVar != null) {
                gaVar.a(th, 1, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @java.lang.Deprecated
    public static synchronized java.util.concurrent.ExecutorService d() {
        java.util.concurrent.ExecutorService executorService;
        synchronized (com.amap.api.mapcore.util.gd.class) {
            try {
                java.util.concurrent.ExecutorService executorService2 = e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    e = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(256), h);
                }
            } catch (java.lang.Throwable unused) {
            }
            executorService = e;
        }
        return executorService;
    }

    public static synchronized com.amap.api.mapcore.util.gd e() {
        com.amap.api.mapcore.util.gd gdVar;
        synchronized (com.amap.api.mapcore.util.gd.class) {
            gdVar = (com.amap.api.mapcore.util.gd) com.amap.api.mapcore.util.ga.a;
        }
        return gdVar;
    }

    @Override // com.amap.api.mapcore.util.ga
    public final void a() {
        com.amap.api.mapcore.util.gb.a(this.d);
    }

    @Override // com.amap.api.mapcore.util.ga
    public final void a(com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2) {
        com.amap.api.mapcore.util.ge.a(fhVar, this.d, str2, str);
    }

    @Override // com.amap.api.mapcore.util.ga
    public final void a(com.amap.api.mapcore.util.fh fhVar, boolean z) {
        try {
            com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.gd.AnonymousClass1(fhVar, z));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.ga
    public final void a(java.lang.Throwable th, int i, java.lang.String str, java.lang.String str2) {
        com.amap.api.mapcore.util.ge.a(this.d, th, i, str, str2);
    }

    public final void b(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        try {
            a(th, 1, str, str2);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            try {
                java.lang.Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (java.lang.Throwable unused) {
            }
            this.b.uncaughtException(thread, th);
        }
    }
}
