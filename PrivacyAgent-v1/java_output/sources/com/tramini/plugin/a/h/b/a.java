package com.tramini.plugin.a.h.b;

/* loaded from: classes19.dex */
public final class a {
    private static com.tramini.plugin.a.h.b.a a;
    private final java.util.concurrent.ExecutorService b = new java.util.concurrent.ThreadPoolExecutor(0, 50, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.tramini.plugin.a.h.b.a.AnonymousClass1());

    /* renamed from: com.tramini.plugin.a.h.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread newThread = java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("tramini_plugin");
            return newThread;
        }
    }

    /* renamed from: com.tramini.plugin.a.h.b.a$2, reason: invalid class name */
    public class AnonymousClass2 extends com.tramini.plugin.a.h.b.b {
        final /* synthetic */ long a;
        final /* synthetic */ java.lang.Runnable b;

        public AnonymousClass2(long j, java.lang.Runnable runnable) {
            this.a = j;
            this.b = runnable;
        }

        @Override // com.tramini.plugin.a.h.b.b
        public final void a() {
            try {
                long j = this.a;
                if (j > 0) {
                    java.lang.Thread.sleep(j);
                }
            } catch (java.lang.InterruptedException unused) {
            }
            this.b.run();
        }
    }

    public static com.tramini.plugin.a.h.b.a a() {
        if (a == null) {
            a = new com.tramini.plugin.a.h.b.a();
        }
        return a;
    }

    public final void a(com.tramini.plugin.a.h.b.b bVar) {
        java.util.concurrent.ExecutorService executorService = this.b;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.b.execute(bVar);
    }

    public final void a(java.lang.Runnable runnable) {
        a(runnable, 0L);
    }

    public final void a(java.lang.Runnable runnable, long j) {
        if (runnable != null) {
            com.tramini.plugin.a.h.b.a.AnonymousClass2 anonymousClass2 = new com.tramini.plugin.a.h.b.a.AnonymousClass2(j, runnable);
            anonymousClass2.a(java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000).intValue());
            a((com.tramini.plugin.a.h.b.b) anonymousClass2);
        }
    }
}
