package com.anythink.core.common.m;

/* loaded from: classes12.dex */
public final class c {
    long a;
    long b;
    java.lang.Runnable c;
    boolean d;
    boolean e;
    com.anythink.core.common.m.b f;
    private final com.anythink.core.common.m.a g;

    /* renamed from: com.anythink.core.common.m.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.m.c cVar = com.anythink.core.common.m.c.this;
            cVar.d = false;
            cVar.b = -1L;
            if (cVar.e) {
                com.anythink.core.common.b.o.a().b(com.anythink.core.common.m.c.this.c);
            } else {
                com.anythink.core.common.b.o.a();
                com.anythink.core.common.b.o.c(com.anythink.core.common.m.c.this.c);
            }
        }
    }

    public c(long j, java.lang.Runnable runnable) {
        this.d = false;
        this.e = true;
        this.g = com.anythink.core.common.m.d.a();
        this.f = new com.anythink.core.common.m.c.AnonymousClass1();
        this.b = j;
        this.c = runnable;
    }

    public c(long j, java.lang.Runnable runnable, byte b) {
        this(j, runnable);
        this.e = false;
    }

    public final synchronized void a() {
        if (this.b >= 0 && !this.d) {
            this.d = true;
            this.a = android.os.SystemClock.elapsedRealtime();
            this.g.a(this.f, this.b, false);
        }
    }

    public final synchronized void b() {
        if (this.d) {
            this.d = false;
            this.b -= android.os.SystemClock.elapsedRealtime() - this.a;
            this.g.b(this.f);
        }
    }

    public final synchronized void c() {
        this.d = false;
        this.g.b(this.f);
        this.b = -1L;
    }
}
