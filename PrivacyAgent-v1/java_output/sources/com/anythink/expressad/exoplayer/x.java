package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public final class x {
    private final com.anythink.expressad.exoplayer.x.b a;
    private final com.anythink.expressad.exoplayer.x.a b;
    private final com.anythink.expressad.exoplayer.ae c;
    private int d;
    private java.lang.Object e;
    private android.os.Handler f;
    private int g;
    private long h = -9223372036854775807L;
    private boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    public interface a {
        void a(com.anythink.expressad.exoplayer.x xVar);
    }

    public interface b {
        void a(int i, java.lang.Object obj);
    }

    public x(com.anythink.expressad.exoplayer.x.a aVar, com.anythink.expressad.exoplayer.x.b bVar, com.anythink.expressad.exoplayer.ae aeVar, int i, android.os.Handler handler) {
        this.b = aVar;
        this.a = bVar;
        this.c = aeVar;
        this.f = handler;
        this.g = i;
    }

    private com.anythink.expressad.exoplayer.x a(int i, long j) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        com.anythink.expressad.exoplayer.k.a.a(j != -9223372036854775807L);
        if (i < 0 || (!this.c.a() && i >= this.c.b())) {
            throw new com.anythink.expressad.exoplayer.o(this.c, i, j);
        }
        this.g = i;
        this.h = j;
        return this;
    }

    private com.anythink.expressad.exoplayer.x a(long j) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.h = j;
        return this;
    }

    private com.anythink.expressad.exoplayer.x a(android.os.Handler handler) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.f = handler;
        return this;
    }

    private com.anythink.expressad.exoplayer.x b(boolean z) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.i = z;
        return this;
    }

    private synchronized com.anythink.expressad.exoplayer.x l() {
        com.anythink.expressad.exoplayer.k.a.b(this.j);
        this.m = true;
        a(false);
        return this;
    }

    public final com.anythink.expressad.exoplayer.ae a() {
        return this.c;
    }

    public final com.anythink.expressad.exoplayer.x a(int i) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.d = i;
        return this;
    }

    public final com.anythink.expressad.exoplayer.x a(@androidx.annotation.Nullable java.lang.Object obj) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.e = obj;
        return this;
    }

    public final synchronized void a(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }

    public final com.anythink.expressad.exoplayer.x.b b() {
        return this.a;
    }

    public final int c() {
        return this.d;
    }

    public final java.lang.Object d() {
        return this.e;
    }

    public final android.os.Handler e() {
        return this.f;
    }

    public final long f() {
        return this.h;
    }

    public final int g() {
        return this.g;
    }

    public final boolean h() {
        return this.i;
    }

    public final com.anythink.expressad.exoplayer.x i() {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        if (this.h == -9223372036854775807L) {
            com.anythink.expressad.exoplayer.k.a.a(this.i);
        }
        this.j = true;
        this.b.a(this);
        return this;
    }

    public final synchronized boolean j() {
        return this.m;
    }

    public final synchronized boolean k() {
        boolean z;
        com.anythink.expressad.exoplayer.k.a.b(this.j);
        com.anythink.expressad.exoplayer.k.a.b(this.f.getLooper().getThread() != java.lang.Thread.currentThread());
        long j = 500;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() + 500;
        while (true) {
            z = this.l;
            if (z || j <= 0) {
                break;
            }
            wait(j);
            j = elapsedRealtime - android.os.SystemClock.elapsedRealtime();
        }
        if (!z) {
            throw new java.util.concurrent.TimeoutException("Message delivery time out");
        }
        return this.k;
    }
}
