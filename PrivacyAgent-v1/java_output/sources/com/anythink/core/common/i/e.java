package com.anythink.core.common.i;

/* loaded from: classes12.dex */
public class e {
    private static com.anythink.core.common.i.e d;
    long b;
    private android.content.Context f;
    private android.app.ActivityManager g;
    private com.anythink.core.common.i.d h;
    private boolean j;
    private volatile java.lang.Integer k;
    private volatile java.lang.Integer l;
    private volatile java.lang.Long m;
    private boolean e = false;
    private final java.io.File i = android.os.Environment.getDataDirectory();
    final long a = 5000;
    java.util.concurrent.atomic.AtomicInteger c = new java.util.concurrent.atomic.AtomicInteger();

    private e() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        this.f = f;
        this.g = (android.app.ActivityManager) f.getSystemService("activity");
        this.h = new com.anythink.core.common.i.d();
    }

    public static com.anythink.core.common.i.e a() {
        if (d == null) {
            synchronized (com.anythink.core.common.i.e.class) {
                if (d == null) {
                    d = new com.anythink.core.common.i.e();
                }
            }
        }
        return d;
    }

    private void i() {
        com.anythink.core.common.i.d dVar = this.h;
        android.content.Context context = this.f;
        android.app.ActivityManager activityManager = this.g;
        int memoryClass = activityManager.getMemoryClass();
        if ((context.getApplicationContext().getApplicationInfo().flags & 1048576) == 1048576) {
            memoryClass = activityManager.getLargeMemoryClass();
        }
        dVar.d = memoryClass;
        if (com.anythink.core.common.b.o.a().c("t_mem")) {
            return;
        }
        if (this.k == null) {
            this.k = java.lang.Integer.valueOf(com.anythink.core.common.o.r.b(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.J, -1));
        }
        if (this.k.intValue() <= 0) {
            this.k = java.lang.Integer.valueOf(com.anythink.core.common.i.b.a());
            com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.J, this.k.intValue());
        }
        this.h.a = this.k.intValue();
    }

    private void j() {
        if (com.anythink.core.common.b.o.a().c("c_num")) {
            return;
        }
        if (this.l == null) {
            this.l = java.lang.Integer.valueOf(com.anythink.core.common.o.r.b(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.K, -1));
        }
        if (this.l.intValue() <= 0) {
            this.l = java.lang.Integer.valueOf(java.lang.Runtime.getRuntime().availableProcessors());
            com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.K, this.l.intValue());
        }
        this.h.e = this.l.intValue();
    }

    private void k() {
        if (com.anythink.core.common.b.o.a().c("t_store")) {
            return;
        }
        if (this.m == null) {
            this.m = com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.L, (java.lang.Long) (-1L));
        }
        if (this.m.longValue() <= 0) {
            try {
                this.m = java.lang.Long.valueOf((new android.os.StatFs(this.i.getPath()).getBlockCountLong() * r0.getBlockSize()) / 1048576);
            } catch (java.lang.Throwable unused) {
            }
            com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.L, this.m.longValue());
        }
        this.h.f = this.m.longValue();
    }

    private long l() {
        try {
            return (new android.os.StatFs(this.i.getPath()).getAvailableBlocksLong() * r0.getBlockSize()) / 1048576;
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }

    public final void a(com.anythink.core.d.a aVar) {
        this.e = aVar.c();
        synchronized (this) {
            if (!this.j) {
                com.anythink.core.common.i.d dVar = this.h;
                android.content.Context context = this.f;
                android.app.ActivityManager activityManager = this.g;
                int memoryClass = activityManager.getMemoryClass();
                if ((context.getApplicationContext().getApplicationInfo().flags & 1048576) == 1048576) {
                    memoryClass = activityManager.getLargeMemoryClass();
                }
                dVar.d = memoryClass;
                if (!com.anythink.core.common.b.o.a().c("t_mem")) {
                    if (this.k == null) {
                        this.k = java.lang.Integer.valueOf(com.anythink.core.common.o.r.b(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.J, -1));
                    }
                    if (this.k.intValue() <= 0) {
                        this.k = java.lang.Integer.valueOf(com.anythink.core.common.i.b.a());
                        com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.J, this.k.intValue());
                    }
                    this.h.a = this.k.intValue();
                }
                if (!com.anythink.core.common.b.o.a().c("c_num")) {
                    if (this.l == null) {
                        this.l = java.lang.Integer.valueOf(com.anythink.core.common.o.r.b(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.K, -1));
                    }
                    if (this.l.intValue() <= 0) {
                        this.l = java.lang.Integer.valueOf(java.lang.Runtime.getRuntime().availableProcessors());
                        com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.K, this.l.intValue());
                    }
                    this.h.e = this.l.intValue();
                }
                if (!com.anythink.core.common.b.o.a().c("t_store")) {
                    if (this.m == null) {
                        this.m = com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.L, (java.lang.Long) (-1L));
                    }
                    if (this.m.longValue() <= 0) {
                        try {
                            this.m = java.lang.Long.valueOf((new android.os.StatFs(this.i.getPath()).getBlockCountLong() * r5.getBlockSize()) / 1048576);
                        } catch (java.lang.Throwable unused) {
                        }
                        com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.L, this.m.longValue());
                    }
                    this.h.f = this.m.longValue();
                }
                this.j = true;
            }
        }
    }

    public final com.anythink.core.common.i.d b() {
        if (!this.e) {
            return null;
        }
        if (android.os.SystemClock.elapsedRealtime() - this.b <= 5000) {
            return this.h;
        }
        this.b = android.os.SystemClock.elapsedRealtime();
        this.h.h = com.anythink.core.common.i.a.a();
        this.h.b = com.anythink.core.common.i.b.b();
        this.h.g = l();
        this.h.c = com.anythink.core.common.i.b.a(this.g);
        return this.h;
    }

    public final synchronized void c() {
        this.c.incrementAndGet();
    }

    public final synchronized void d() {
        this.c.decrementAndGet();
    }

    public final synchronized int e() {
        return this.c.get();
    }

    public final int f() {
        if (com.anythink.core.common.b.o.a().c("t_mem")) {
            return 0;
        }
        if (this.k == null) {
            this.k = java.lang.Integer.valueOf(com.anythink.core.common.o.r.b(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.J, -1));
        }
        if (this.k.intValue() > 0) {
            return this.k.intValue();
        }
        return 0;
    }

    public final int g() {
        if (com.anythink.core.common.b.o.a().c("c_num")) {
            return 0;
        }
        if (this.l == null) {
            this.l = java.lang.Integer.valueOf(com.anythink.core.common.o.r.b(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.K, -1));
        }
        if (this.l.intValue() > 0) {
            return this.l.intValue();
        }
        return 0;
    }

    public final long h() {
        if (com.anythink.core.common.b.o.a().c("t_store")) {
            return 0L;
        }
        if (this.m == null) {
            this.m = com.anythink.core.common.o.r.a(this.f, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.L, (java.lang.Long) (-1L));
        }
        if (this.m.longValue() > 0) {
            return this.m.longValue();
        }
        return 0L;
    }
}
