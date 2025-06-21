package com.loc;

/* loaded from: classes23.dex */
public final class cs implements java.util.concurrent.ThreadFactory {
    private static final int k;
    private static final int l;
    private static final int m;
    private final java.util.concurrent.atomic.AtomicLong a;
    private final java.util.concurrent.ThreadFactory b;
    private final java.lang.Thread.UncaughtExceptionHandler c;
    private final java.lang.String d;
    private final java.lang.Integer e;
    private final java.lang.Boolean f;
    private final int g;
    private final int h;
    private final java.util.concurrent.BlockingQueue<java.lang.Runnable> i;
    private final int j;

    /* renamed from: com.loc.cs$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Runnable a;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.run();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        private java.util.concurrent.ThreadFactory a;
        private java.lang.Thread.UncaughtExceptionHandler b;
        private java.lang.String c;
        private java.lang.Integer d;
        private java.lang.Boolean e;
        private int f = com.loc.cs.l;
        private int g = com.loc.cs.m;
        private int h = 30;
        private java.util.concurrent.BlockingQueue<java.lang.Runnable> i;

        private void b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        public final com.loc.cs.a a(java.lang.String str) {
            this.c = str;
            return this;
        }

        public final com.loc.cs.a a(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler == null) {
                throw new java.lang.NullPointerException("Uncaught exception handler must not be null!");
            }
            this.b = uncaughtExceptionHandler;
            return this;
        }

        public final com.loc.cs a() {
            com.loc.cs csVar = new com.loc.cs(this, (byte) 0);
            b();
            return csVar;
        }
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        k = availableProcessors;
        l = java.lang.Math.max(2, java.lang.Math.min(availableProcessors - 1, 4));
        m = (availableProcessors * 2) + 1;
    }

    private cs(com.loc.cs.a aVar) {
        this.b = aVar.a == null ? java.util.concurrent.Executors.defaultThreadFactory() : aVar.a;
        int i = aVar.f;
        this.g = i;
        int i2 = m;
        this.h = i2;
        if (i2 < i) {
            throw new java.lang.NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.j = aVar.h;
        this.i = aVar.i == null ? new java.util.concurrent.LinkedBlockingQueue<>(256) : aVar.i;
        this.d = android.text.TextUtils.isEmpty(aVar.c) ? "amap-threadpool" : aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.c = aVar.b;
        this.a = new java.util.concurrent.atomic.AtomicLong();
    }

    public /* synthetic */ cs(com.loc.cs.a aVar, byte b) {
        this(aVar);
    }

    private java.util.concurrent.ThreadFactory g() {
        return this.b;
    }

    private java.lang.String h() {
        return this.d;
    }

    private java.lang.Boolean i() {
        return this.f;
    }

    private java.lang.Integer j() {
        return this.e;
    }

    private java.lang.Thread.UncaughtExceptionHandler k() {
        return this.c;
    }

    public final int a() {
        return this.g;
    }

    public final int b() {
        return this.h;
    }

    public final java.util.concurrent.BlockingQueue<java.lang.Runnable> c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        new com.loc.cs.AnonymousClass1(runnable);
        java.lang.Thread newThread = g().newThread(runnable);
        if (h() != null) {
            newThread.setName(java.lang.String.format(h() + "-%d", java.lang.Long.valueOf(this.a.incrementAndGet())));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }
}
