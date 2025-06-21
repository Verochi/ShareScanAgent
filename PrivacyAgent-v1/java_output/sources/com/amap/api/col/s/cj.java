package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class cj extends com.amap.api.col.s.cg implements java.lang.Thread.UncaughtExceptionHandler {
    public static java.lang.ref.WeakReference<android.content.Context> f;
    public android.content.Context d;
    public static java.util.Set<java.lang.Integer> e = java.util.Collections.synchronizedSet(new java.util.HashSet());
    public static final java.util.concurrent.ThreadFactory g = new com.amap.api.col.s.cj.AnonymousClass2();

    /* renamed from: com.amap.api.col.s.cj$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.col.s.ec {
        public final /* synthetic */ com.amap.api.col.s.bt t;
        public final /* synthetic */ boolean u;

        public AnonymousClass1(com.amap.api.col.s.bt btVar, boolean z) {
            this.t = btVar;
            this.u = z;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            try {
                synchronized (android.os.Looper.getMainLooper()) {
                    com.amap.api.col.s.ch.a(this.t);
                }
                if (this.u) {
                    com.amap.api.col.s.ck.d(com.amap.api.col.s.cj.this.d);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.col.s.cj$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.ThreadFactory {
        public final java.util.concurrent.atomic.AtomicInteger n = new java.util.concurrent.atomic.AtomicInteger(1);

        /* renamed from: com.amap.api.col.s.cj$2$1, reason: invalid class name */
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
            return new com.amap.api.col.s.cj.AnonymousClass2.AnonymousClass1(runnable, "pama#" + this.n.getAndIncrement());
        }
    }

    public cj(android.content.Context context) {
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

    public static synchronized com.amap.api.col.s.cj a(android.content.Context context, com.amap.api.col.s.bt btVar) throws com.amap.api.col.s.bh {
        synchronized (com.amap.api.col.s.cj.class) {
            try {
                if (btVar == null) {
                    throw new com.amap.api.col.s.bh("sdk info is null");
                }
                if (btVar.b() == null || "".equals(btVar.b())) {
                    throw new com.amap.api.col.s.bh("sdk name is invalid");
                }
                try {
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (!e.add(java.lang.Integer.valueOf(btVar.hashCode()))) {
                    return (com.amap.api.col.s.cj) com.amap.api.col.s.cg.a;
                }
                com.amap.api.col.s.cg cgVar = com.amap.api.col.s.cg.a;
                if (cgVar == null) {
                    com.amap.api.col.s.cg.a = new com.amap.api.col.s.cj(context);
                } else {
                    cgVar.c = false;
                }
                com.amap.api.col.s.cg cgVar2 = com.amap.api.col.s.cg.a;
                cgVar2.a(btVar, cgVar2.c);
                return (com.amap.api.col.s.cj) com.amap.api.col.s.cg.a;
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(com.amap.api.col.s.bt btVar, java.lang.String str, com.amap.api.col.s.bh bhVar) {
        a(btVar, str, bhVar.c(), bhVar.d(), bhVar.e(), bhVar.b());
    }

    public static void a(com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(btVar, str, str2, str3, "", str4);
    }

    public static void a(com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        try {
            if (com.amap.api.col.s.cg.a != null) {
                com.amap.api.col.s.cg.a.a(btVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void b() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = f;
        if (weakReference != null && weakReference.get() != null) {
            com.amap.api.col.s.ch.a(f.get());
            return;
        }
        com.amap.api.col.s.cg cgVar = com.amap.api.col.s.cg.a;
        if (cgVar != null) {
            cgVar.a();
        }
    }

    public static void b(com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2) {
        try {
            com.amap.api.col.s.cg cgVar = com.amap.api.col.s.cg.a;
            if (cgVar != null) {
                cgVar.a(btVar, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized com.amap.api.col.s.cj c() {
        com.amap.api.col.s.cj cjVar;
        synchronized (com.amap.api.col.s.cj.class) {
            cjVar = (com.amap.api.col.s.cj) com.amap.api.col.s.cg.a;
        }
        return cjVar;
    }

    public static void c(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        try {
            com.amap.api.col.s.cg cgVar = com.amap.api.col.s.cg.a;
            if (cgVar != null) {
                cgVar.a(th, 1, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.amap.api.col.s.cg
    public final void a() {
        com.amap.api.col.s.ch.a(this.d);
    }

    @Override // com.amap.api.col.s.cg
    public final void a(com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2) {
        com.amap.api.col.s.ck.g(btVar, this.d, str2, str);
    }

    @Override // com.amap.api.col.s.cg
    public final void a(com.amap.api.col.s.bt btVar, boolean z) {
        try {
            com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.cj.AnonymousClass1(btVar, z));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.s.cg
    public final void a(java.lang.Throwable th, int i, java.lang.String str, java.lang.String str2) {
        com.amap.api.col.s.ck.a(this.d, th, i, str, str2);
    }

    public final void b(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        if (th == null) {
            return;
        }
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
