package com.tencent.open.utils;

/* loaded from: classes19.dex */
public final class j {
    private static android.os.Handler c;
    private static android.os.HandlerThread d;
    private static java.lang.Object b = new java.lang.Object();
    public static final java.util.concurrent.Executor a = c();

    public static class a implements java.util.concurrent.Executor {
        final java.util.Queue<java.lang.Runnable> a;
        java.lang.Runnable b;

        /* renamed from: com.tencent.open.utils.j$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Runnable a;

            public AnonymousClass1(java.lang.Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.a.run();
                } finally {
                    com.tencent.open.utils.j.a.this.a();
                }
            }
        }

        private a() {
            this.a = new java.util.LinkedList();
        }

        public /* synthetic */ a(com.tencent.open.utils.j.AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void a() {
            java.lang.Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                com.tencent.open.utils.j.a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(java.lang.Runnable runnable) {
            this.a.offer(new com.tencent.open.utils.j.a.AnonymousClass1(runnable));
            if (this.b == null) {
                a();
            }
        }
    }

    public static android.os.Handler a() {
        if (c == null) {
            synchronized (com.tencent.open.utils.j.class) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new android.os.Handler(d.getLooper());
            }
        }
        return c;
    }

    public static void a(java.lang.Runnable runnable) {
        a().post(runnable);
    }

    public static java.util.concurrent.Executor b() {
        return new com.tencent.open.utils.j.a(null);
    }

    private static java.util.concurrent.Executor c() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        threadPoolExecutor.setCorePoolSize(3);
        return threadPoolExecutor;
    }
}
