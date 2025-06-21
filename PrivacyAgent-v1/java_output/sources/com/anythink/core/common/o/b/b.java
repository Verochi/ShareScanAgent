package com.anythink.core.common.o.b;

/* loaded from: classes12.dex */
public class b {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    private static volatile com.anythink.core.common.o.b.b q;
    private final com.anythink.core.common.o.b.a r = new com.anythink.core.common.o.b.a();

    /* renamed from: com.anythink.core.common.o.b.b$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
        final /* synthetic */ long a;
        final /* synthetic */ java.lang.Runnable b;

        public AnonymousClass1(long j, java.lang.Runnable runnable) {
            this.a = j;
            this.b = runnable;
        }

        @Override // com.anythink.core.common.o.b.d
        public final void a() {
            long j = this.a;
            if (j > 0) {
                try {
                    java.lang.Thread.sleep(j);
                } catch (java.lang.InterruptedException unused) {
                }
            }
            b();
            this.b.run();
        }
    }

    /* renamed from: com.anythink.core.common.o.b.b$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.core.common.o.b.d {
        final /* synthetic */ java.lang.Runnable a;

        public AnonymousClass2(java.lang.Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.anythink.core.common.o.b.d
        public final void a() {
            this.a.run();
        }
    }

    private b() {
    }

    public static com.anythink.core.common.o.b.b a() {
        if (q == null) {
            synchronized (com.anythink.core.common.o.b.b.class) {
                if (q == null) {
                    q = new com.anythink.core.common.o.b.b();
                }
            }
        }
        return q;
    }

    private void a(java.lang.Runnable runnable, long j2, int i2) {
        if (runnable != null) {
            com.anythink.core.common.o.b.b.AnonymousClass1 anonymousClass1 = new com.anythink.core.common.o.b.b.AnonymousClass1(j2, runnable);
            anonymousClass1.a(java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000).intValue());
            a((com.anythink.core.common.o.b.d) anonymousClass1, i2);
        }
    }

    public static boolean b() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    private static void c() {
    }

    private void d(java.lang.Runnable runnable) {
        a(runnable, 13);
    }

    public final android.os.Handler a(int i2) {
        return this.r.a(i2);
    }

    public final void a(com.anythink.core.common.o.b.d dVar, int i2) {
        try {
            this.r.a(dVar, i2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.Runnable runnable) {
        a(runnable, 2, true);
    }

    public final void a(java.lang.Runnable runnable, int i2) {
        if (b()) {
            a(runnable, i2, true);
        } else {
            runnable.run();
        }
    }

    public final void a(java.lang.Runnable runnable, int i2, boolean z) {
        if (z) {
            a(runnable, 0L, i2);
        } else if (b()) {
            a(runnable, 0L, i2);
        } else {
            runnable.run();
        }
    }

    public final void a(java.lang.Runnable runnable, long j2) {
        a(runnable, j2, 2);
    }

    public final void b(java.lang.Runnable runnable) {
        a(runnable, 13, true);
    }

    public final void c(java.lang.Runnable runnable) {
        if (android.text.TextUtils.equals(java.lang.Thread.currentThread().getName(), com.anythink.core.common.o.b.a.b(6))) {
            runnable.run();
        } else if (runnable != null) {
            com.anythink.core.common.o.b.b.AnonymousClass2 anonymousClass2 = new com.anythink.core.common.o.b.b.AnonymousClass2(runnable);
            anonymousClass2.a(java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000).intValue());
            a((com.anythink.core.common.o.b.d) anonymousClass2, 6);
        }
    }
}
