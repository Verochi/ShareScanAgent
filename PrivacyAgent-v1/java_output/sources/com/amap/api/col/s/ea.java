package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ea implements java.util.concurrent.ThreadFactory {
    public static final int C;
    public static final int D;
    public static final int E;
    public final java.util.concurrent.BlockingQueue<java.lang.Runnable> A;
    public final int B;
    public final java.util.concurrent.atomic.AtomicLong n;
    public final java.util.concurrent.ThreadFactory t;
    public final java.lang.Thread.UncaughtExceptionHandler u;
    public final java.lang.String v;
    public final java.lang.Integer w;
    public final java.lang.Boolean x;
    public final int y;
    public final int z;

    /* renamed from: com.amap.api.col.s.ea$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Runnable n;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.n = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.n.run();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        public java.util.concurrent.ThreadFactory a;
        public java.lang.Thread.UncaughtExceptionHandler b;
        public java.lang.String c;
        public java.lang.Integer d;
        public java.lang.Boolean e;
        public int f = com.amap.api.col.s.ea.D;
        public int g = com.amap.api.col.s.ea.E;
        public int h = 30;
        public java.util.concurrent.BlockingQueue<java.lang.Runnable> i;

        public final com.amap.api.col.s.ea.a a(java.lang.String str) {
            this.c = str;
            return this;
        }

        public final com.amap.api.col.s.ea a() {
            com.amap.api.col.s.ea eaVar = new com.amap.api.col.s.ea(this, (byte) 0);
            d();
            return eaVar;
        }

        public final void d() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        C = availableProcessors;
        D = java.lang.Math.max(2, java.lang.Math.min(availableProcessors - 1, 4));
        E = (availableProcessors * 2) + 1;
    }

    public ea(com.amap.api.col.s.ea.a aVar) {
        if (aVar.a == null) {
            this.t = java.util.concurrent.Executors.defaultThreadFactory();
        } else {
            this.t = aVar.a;
        }
        int i = aVar.f;
        this.y = i;
        int i2 = E;
        this.z = i2;
        if (i2 < i) {
            throw new java.lang.NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.B = aVar.h;
        if (aVar.i == null) {
            this.A = new java.util.concurrent.LinkedBlockingQueue(256);
        } else {
            this.A = aVar.i;
        }
        if (android.text.TextUtils.isEmpty(aVar.c)) {
            this.v = "amap-threadpool";
        } else {
            this.v = aVar.c;
        }
        this.w = aVar.d;
        this.x = aVar.e;
        this.u = aVar.b;
        this.n = new java.util.concurrent.atomic.AtomicLong();
    }

    public /* synthetic */ ea(com.amap.api.col.s.ea.a aVar, byte b) {
        this(aVar);
    }

    public final int a() {
        return this.y;
    }

    public final int b() {
        return this.z;
    }

    public final java.util.concurrent.BlockingQueue<java.lang.Runnable> c() {
        return this.A;
    }

    public final int d() {
        return this.B;
    }

    public final java.util.concurrent.ThreadFactory g() {
        return this.t;
    }

    public final java.lang.String h() {
        return this.v;
    }

    public final java.lang.Boolean i() {
        return this.x;
    }

    public final java.lang.Integer j() {
        return this.w;
    }

    public final java.lang.Thread.UncaughtExceptionHandler k() {
        return this.u;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        new com.amap.api.col.s.ea.AnonymousClass1(runnable);
        java.lang.Thread newThread = g().newThread(runnable);
        if (h() != null) {
            newThread.setName(java.lang.String.format(h() + "-%d", java.lang.Long.valueOf(this.n.incrementAndGet())));
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
