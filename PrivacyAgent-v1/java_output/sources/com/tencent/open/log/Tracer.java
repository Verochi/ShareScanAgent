package com.tencent.open.log;

/* loaded from: classes19.dex */
public abstract class Tracer {
    private volatile int a;
    private volatile boolean b;
    private com.tencent.open.log.g c;

    public Tracer() {
        this(com.tencent.open.log.c.a, true, com.tencent.open.log.g.a);
    }

    public Tracer(int i, boolean z, com.tencent.open.log.g gVar) {
        this.a = com.tencent.open.log.c.a;
        this.b = true;
        this.c = com.tencent.open.log.g.a;
        a(i);
        a(z);
        a(gVar);
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (d() && com.tencent.open.log.d.a.a(this.a, i)) {
            doTrace(i, thread, j, str, str2, th);
        }
    }

    public void a(com.tencent.open.log.g gVar) {
        this.c = gVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean d() {
        return this.b;
    }

    public abstract void doTrace(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    public com.tencent.open.log.g e() {
        return this.c;
    }
}
