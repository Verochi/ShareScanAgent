package com.bytedance.pangle.d;

/* loaded from: classes12.dex */
public final class e {
    private static java.util.concurrent.Executor a = java.util.concurrent.Executors.newCachedThreadPool(new com.bytedance.pangle.d.e.AnonymousClass1());
    private static final java.lang.Object b = new java.lang.Object();
    private static android.os.Handler c = null;

    /* renamed from: com.bytedance.pangle.d.e$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "pangle-Fast-" + this.a.getAndIncrement());
        }
    }

    /* renamed from: com.bytedance.pangle.d.e$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "pangle-Install-" + this.a.getAndIncrement());
        }
    }

    private static android.os.Handler a() {
        android.os.Handler handler;
        synchronized (b) {
            if (c == null) {
                c = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            handler = c;
        }
        return handler;
    }

    public static java.util.concurrent.ExecutorService a(int i) {
        return java.util.concurrent.Executors.newFixedThreadPool(i, new com.bytedance.pangle.d.e.AnonymousClass2());
    }

    public static void a(java.lang.Runnable runnable) {
        a.execute(runnable);
    }

    public static void b(java.lang.Runnable runnable) {
        if (a().getLooper() == android.os.Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }
}
