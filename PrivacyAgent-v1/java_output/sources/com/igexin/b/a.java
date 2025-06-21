package com.igexin.b;

/* loaded from: classes22.dex */
public final class a {
    private static java.lang.String b = "GTSDK-thread-pool | ";
    public final java.util.concurrent.ThreadPoolExecutor a;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ThreadPoolExecutor> c;
    private java.util.concurrent.ScheduledThreadPoolExecutor d;
    private final java.util.concurrent.atomic.AtomicInteger e;
    private final java.util.concurrent.atomic.AtomicInteger f;
    private int g;

    /* renamed from: com.igexin.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.igexin.b.a$1$1, reason: invalid class name and collision with other inner class name */
        public class C03651 implements java.lang.Thread.UncaughtExceptionHandler {
            public C03651() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(com.igexin.b.a.b + "| caught an exception from " + thread.getName(), th);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable, "gt-thread-multiple " + com.igexin.b.a.this.e.getAndIncrement());
            thread.setUncaughtExceptionHandler(new com.igexin.b.a.AnonymousClass1.C03651());
            return thread;
        }
    }

    /* renamed from: com.igexin.b.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.RejectedExecutionHandler {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            if (com.igexin.push.core.ServiceManager.b != null) {
                com.igexin.c.a.c.a.a(com.igexin.b.a.b + "|gtsdk-multiple-thread rejected task tasknum = " + threadPoolExecutor.getActiveCount(), new java.lang.Object[0]);
            }
        }
    }

    /* renamed from: com.igexin.b.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.ThreadFactory {
        final /* synthetic */ java.lang.String a;

        /* renamed from: com.igexin.b.a$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Thread.UncaughtExceptionHandler {
            public AnonymousClass1() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(com.igexin.b.a.b + "| caught an exception from " + thread.getName(), th);
            }
        }

        public AnonymousClass3(java.lang.String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable, this.a);
            thread.setUncaughtExceptionHandler(new com.igexin.b.a.AnonymousClass3.AnonymousClass1());
            return thread;
        }
    }

    /* renamed from: com.igexin.b.a$4, reason: invalid class name */
    public class AnonymousClass4 implements java.util.concurrent.RejectedExecutionHandler {
        public AnonymousClass4() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            if (com.igexin.push.core.ServiceManager.b != null) {
                com.igexin.c.a.c.a.a(com.igexin.b.a.b + "singleThread rejected task tasknum = " + threadPoolExecutor.getActiveCount(), new java.lang.Object[0]);
            }
        }
    }

    /* renamed from: com.igexin.b.a$5, reason: invalid class name */
    public class AnonymousClass5 implements java.util.concurrent.ThreadFactory {
        final /* synthetic */ java.lang.String a;

        /* renamed from: com.igexin.b.a$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Thread.UncaughtExceptionHandler {
            public AnonymousClass1() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(com.igexin.b.a.b + "| caught an exception from " + thread.getName(), th);
            }
        }

        public AnonymousClass5(java.lang.String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable, this.a);
            thread.setUncaughtExceptionHandler(new com.igexin.b.a.AnonymousClass5.AnonymousClass1());
            return thread;
        }
    }

    /* renamed from: com.igexin.b.a$a, reason: collision with other inner class name */
    public static class C0366a {
        private static final com.igexin.b.a a = new com.igexin.b.a((byte) 0);

        private C0366a() {
        }
    }

    private a() {
        this.c = new java.util.concurrent.ConcurrentHashMap<>();
        this.e = new java.util.concurrent.atomic.AtomicInteger(0);
        this.f = new java.util.concurrent.atomic.AtomicInteger(0);
        this.g = 30;
        this.a = new java.util.concurrent.ThreadPoolExecutor(0, java.lang.Runtime.getRuntime().availableProcessors() * 2, this.g, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.igexin.b.a.AnonymousClass1(), new com.igexin.b.a.AnonymousClass2());
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static com.igexin.b.a a() {
        return com.igexin.b.a.C0366a.a;
    }

    private java.util.concurrent.ThreadPoolExecutor d() {
        return this.a;
    }

    public final java.util.concurrent.ThreadPoolExecutor a(java.lang.String str) {
        java.lang.String concat = android.text.TextUtils.isEmpty(str) ? "gt-thread" : "gt-thread-".concat(java.lang.String.valueOf(str));
        if (this.c.containsKey(concat)) {
            return this.c.get(concat);
        }
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 1, this.g, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.igexin.b.a.AnonymousClass3(concat), new com.igexin.b.a.AnonymousClass4());
        this.c.put(concat, threadPoolExecutor);
        return threadPoolExecutor;
    }

    public final java.util.concurrent.ScheduledThreadPoolExecutor b() {
        if (this.d == null) {
            this.d = new java.util.concurrent.ScheduledThreadPoolExecutor(0, new com.igexin.b.a.AnonymousClass5("gt-thread-delay"));
        }
        return this.d;
    }
}
