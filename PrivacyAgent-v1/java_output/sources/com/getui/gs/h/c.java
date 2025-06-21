package com.getui.gs.h;

/* loaded from: classes22.dex */
public final class c {
    private static final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);
    private final java.util.concurrent.ScheduledThreadPoolExecutor b;
    private final java.util.concurrent.ThreadPoolExecutor c;

    /* renamed from: com.getui.gs.h.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.getui.gs.h.c$1$1, reason: invalid class name and collision with other inner class name */
        public class C02901 implements java.lang.Thread.UncaughtExceptionHandler {
            public C02901() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                com.getui.gs.h.b.a("caught an exception from " + thread.getName(), th);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("Gs-Schedule-Thread");
            thread.setUncaughtExceptionHandler(new com.getui.gs.h.c.AnonymousClass1.C02901());
            com.getui.gs.h.b.a(thread.getName() + " created");
            return thread;
        }
    }

    /* renamed from: com.getui.gs.h.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.getui.gs.h.c$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Thread.UncaughtExceptionHandler {
            public AnonymousClass1() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                com.getui.gs.h.b.a("caught an exception from " + thread.getName(), th);
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("Gs-Net-Thread-" + com.getui.gs.h.c.a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new com.getui.gs.h.c.AnonymousClass2.AnonymousClass1());
            com.getui.gs.h.b.a(thread.getName() + " created");
            return thread;
        }
    }

    /* renamed from: com.getui.gs.h.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.RejectedExecutionHandler {
        public AnonymousClass3() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            com.getui.gs.h.b.a.a.a.e("network task rejected");
        }
    }

    public static class a {
        private static final com.getui.gs.h.c a = new com.getui.gs.h.c((byte) 0);
    }

    private c() {
        this.b = new java.util.concurrent.ScheduledThreadPoolExecutor(1, new com.getui.gs.h.c.AnonymousClass1());
        this.c = new java.util.concurrent.ThreadPoolExecutor(1, 3, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(20), new com.getui.gs.h.c.AnonymousClass2(), new com.getui.gs.h.c.AnonymousClass3());
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static java.util.concurrent.ScheduledThreadPoolExecutor a() {
        return com.getui.gs.h.c.a.a.b;
    }

    public static java.util.concurrent.ThreadPoolExecutor b() {
        return com.getui.gs.h.c.a.a.c;
    }
}
