package com.anythink.china.common.a.a;

/* loaded from: classes12.dex */
public final class a {
    public static final int a = 1;
    public static final int b = 2;
    private static com.anythink.china.common.a.a.a c;
    private java.util.concurrent.ExecutorService d;

    /* renamed from: com.anythink.china.common.a.a.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
        final /* synthetic */ long a = 0;
        final /* synthetic */ java.lang.Runnable b;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.b = runnable;
        }

        @Override // com.anythink.core.common.o.b.d
        public final void a() {
            try {
                java.lang.Thread.sleep(this.a);
            } catch (java.lang.InterruptedException unused) {
            }
            b();
            this.b.run();
        }
    }

    public a() {
        this.d = null;
        this.d = java.util.concurrent.Executors.newSingleThreadExecutor();
    }

    public static com.anythink.china.common.a.a.a a() {
        if (c == null) {
            c = new com.anythink.china.common.a.a.a();
        }
        return c;
    }

    private static void a(com.anythink.china.common.a.a.a aVar) {
        c = aVar;
    }

    private void a(java.lang.Runnable runnable) {
        if (runnable != null) {
            com.anythink.china.common.a.a.a.AnonymousClass1 anonymousClass1 = new com.anythink.china.common.a.a.a.AnonymousClass1(runnable);
            anonymousClass1.a(java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000).intValue());
            a((com.anythink.core.common.o.b.d) anonymousClass1);
        }
    }

    private void b() {
        this.d.shutdown();
    }

    private void b(com.anythink.core.common.o.b.d dVar) {
        a(dVar);
    }

    private void b(java.lang.Runnable runnable) {
        if (runnable != null) {
            com.anythink.china.common.a.a.a.AnonymousClass1 anonymousClass1 = new com.anythink.china.common.a.a.a.AnonymousClass1(runnable);
            anonymousClass1.a(java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000).intValue());
            a((com.anythink.core.common.o.b.d) anonymousClass1);
        }
    }

    public final void a(com.anythink.core.common.o.b.d dVar) {
        this.d.execute(dVar);
    }
}
