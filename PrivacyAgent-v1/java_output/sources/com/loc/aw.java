package com.loc;

/* loaded from: classes23.dex */
public final class aw extends com.loc.at implements java.lang.Thread.UncaughtExceptionHandler {
    private static java.util.concurrent.ExecutorService e;
    private static java.lang.ref.WeakReference<android.content.Context> g;
    private android.content.Context d;
    private static java.util.Set<java.lang.Integer> f = java.util.Collections.synchronizedSet(new java.util.HashSet());
    private static final java.util.concurrent.ThreadFactory h = new com.loc.aw.AnonymousClass2();

    /* renamed from: com.loc.aw$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ com.loc.x a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(com.loc.x xVar, boolean z) {
            this.a = xVar;
            this.b = z;
        }

        @Override // com.loc.cu
        public final void a() {
            try {
                synchronized (android.os.Looper.getMainLooper()) {
                    com.loc.au.a(this.a);
                }
                if (this.b) {
                    com.loc.ax.a(com.loc.aw.this.d);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.loc.aw$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);

        /* renamed from: com.loc.aw$2$1, reason: invalid class name */
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
            return new com.loc.aw.AnonymousClass2.AnonymousClass1(runnable, "pama#" + this.a.getAndIncrement());
        }
    }

    private aw(android.content.Context context) {
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

    public static synchronized com.loc.aw a(android.content.Context context, com.loc.x xVar) throws com.loc.l {
        synchronized (com.loc.aw.class) {
            try {
                if (xVar == null) {
                    throw new com.loc.l("sdk info is null");
                }
                if (xVar.a() == null || "".equals(xVar.a())) {
                    throw new com.loc.l("sdk name is invalid");
                }
                try {
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (!f.add(java.lang.Integer.valueOf(xVar.hashCode()))) {
                    return (com.loc.aw) com.loc.at.a;
                }
                com.loc.at atVar = com.loc.at.a;
                if (atVar == null) {
                    com.loc.at.a = new com.loc.aw(context);
                } else {
                    atVar.c = false;
                }
                com.loc.at atVar2 = com.loc.at.a;
                atVar2.a(xVar, atVar2.c);
                return (com.loc.aw) com.loc.at.a;
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(com.loc.x xVar, java.lang.String str, com.loc.l lVar) {
        if (lVar != null) {
            a(xVar, str, lVar.c(), lVar.d(), lVar.e(), lVar.b());
        }
    }

    public static void a(com.loc.x xVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(xVar, str, str2, str3, "", str4);
    }

    public static void a(com.loc.x xVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        try {
            if (com.loc.at.a != null) {
                com.loc.at.a.a(xVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
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
        synchronized (com.loc.aw.class) {
            try {
                try {
                    java.util.concurrent.ExecutorService executorService = e;
                    if (executorService != null) {
                        executorService.shutdown();
                    }
                    com.loc.bm.a();
                } finally {
                    if (com.loc.at.a != null) {
                    }
                    com.loc.at.a = null;
                }
                if (com.loc.at.a != null) {
                    java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
                    com.loc.at atVar = com.loc.at.a;
                    if (defaultUncaughtExceptionHandler == atVar && (uncaughtExceptionHandler = atVar.b) != null) {
                        java.lang.Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                    }
                }
                com.loc.at.a = null;
            } catch (java.lang.Throwable th) {
            }
        }
    }

    public static void b(com.loc.x xVar, java.lang.String str, java.lang.String str2) {
        try {
            com.loc.at atVar = com.loc.at.a;
            if (atVar != null) {
                atVar.a(xVar, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void b(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        try {
            com.loc.at atVar = com.loc.at.a;
            if (atVar != null) {
                atVar.a(th, 1, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            com.loc.au.a(g.get());
            return;
        }
        com.loc.at atVar = com.loc.at.a;
        if (atVar != null) {
            atVar.a();
        }
    }

    @Override // com.loc.at
    public final void a() {
        com.loc.au.a(this.d);
    }

    @Override // com.loc.at
    public final void a(com.loc.x xVar, java.lang.String str, java.lang.String str2) {
        com.loc.ax.a(xVar, this.d, str2, str);
    }

    @Override // com.loc.at
    public final void a(com.loc.x xVar, boolean z) {
        try {
            com.loc.ct.a().b(new com.loc.aw.AnonymousClass1(xVar, z));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.loc.at
    public final void a(java.lang.Throwable th, int i, java.lang.String str, java.lang.String str2) {
        com.loc.ax.a(this.d, th, i, str, str2);
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
