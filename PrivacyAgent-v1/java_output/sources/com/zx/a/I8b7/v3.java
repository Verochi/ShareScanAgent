package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class v3 {
    public java.util.concurrent.ThreadPoolExecutor a;
    public java.util.concurrent.ThreadPoolExecutor b;
    public java.util.concurrent.ThreadPoolExecutor c;
    public java.util.concurrent.ThreadPoolExecutor d;
    public java.util.concurrent.ThreadPoolExecutor e;

    public class a implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.zx.a.I8b7.v3$a$a, reason: collision with other inner class name */
        public class C0540a implements java.lang.Thread.UncaughtExceptionHandler {
            public C0540a(com.zx.a.I8b7.v3.a aVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("caught an exception from ");
                a.append(thread.getName());
                com.zx.a.I8b7.r2.a(a.toString(), th);
            }
        }

        public a(com.zx.a.I8b7.v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ZX-Api-Thread");
            thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.v3.a.C0540a(this));
            return thread;
        }
    }

    public class b implements java.util.concurrent.ThreadFactory {

        public class a implements java.lang.Thread.UncaughtExceptionHandler {
            public a(com.zx.a.I8b7.v3.b bVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("caught an exception from ");
                a.append(thread.getName());
                com.zx.a.I8b7.r2.a(a.toString(), th);
            }
        }

        public b(com.zx.a.I8b7.v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ZX-Api-ThreadV2");
            thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.v3.b.a(this));
            return thread;
        }
    }

    public class c implements java.util.concurrent.ThreadFactory {

        public class a implements java.lang.Thread.UncaughtExceptionHandler {
            public a(com.zx.a.I8b7.v3.c cVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("caught an exception from ");
                a.append(thread.getName());
                com.zx.a.I8b7.r2.a(a.toString(), th);
            }
        }

        public c(com.zx.a.I8b7.v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ZX-Api-ThreadV3");
            thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.v3.c.a(this));
            return thread;
        }
    }

    public class d implements java.util.concurrent.ThreadFactory {

        public class a implements java.lang.Thread.UncaughtExceptionHandler {
            public a(com.zx.a.I8b7.v3.d dVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("caught an exception from ");
                a.append(thread.getName());
                com.zx.a.I8b7.r2.a(a.toString(), th);
            }
        }

        public d(com.zx.a.I8b7.v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ZX-Api-ThreadV4");
            thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.v3.d.a(this));
            return thread;
        }
    }

    public class e implements java.util.concurrent.ThreadFactory {

        public class a implements java.lang.Thread.UncaughtExceptionHandler {
            public a(com.zx.a.I8b7.v3.e eVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("caught an exception from ");
                a.append(thread.getName());
                com.zx.a.I8b7.r2.a(a.toString(), th);
            }
        }

        public e(com.zx.a.I8b7.v3 v3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ZX-Api-ThreadV5");
            thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.v3.e.a(this));
            return thread;
        }
    }

    public static class f {
        public static final com.zx.a.I8b7.v3 a = new com.zx.a.I8b7.v3();
    }

    public v3() {
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        this.a = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.zx.a.I8b7.v3.a(this));
        this.b = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.zx.a.I8b7.v3.b(this));
        this.c = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.zx.a.I8b7.v3.c(this));
        this.d = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.zx.a.I8b7.v3.d(this));
        this.e = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.zx.a.I8b7.v3.e(this));
    }
}
