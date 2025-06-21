package com.igexin.push.c;

/* loaded from: classes23.dex */
public class f extends com.igexin.push.g.b.f {
    private static com.igexin.push.c.f c;
    private boolean e;
    private static final java.lang.String b = com.igexin.push.c.b.a + com.igexin.push.c.f.class.getName();
    public static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    private f() {
        super(10L, (byte) 0);
        this.p = true;
    }

    private void a(long j) {
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static synchronized com.igexin.push.c.f g() {
        com.igexin.push.c.f fVar;
        synchronized (com.igexin.push.c.f.class) {
            if (c == null) {
                c = new com.igexin.push.c.f();
            }
            fVar = c;
        }
        return fVar;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 20150607;
    }

    @Override // com.igexin.push.g.b.f
    public final void h() {
        long j = com.igexin.push.c.b.c;
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (this.e) {
            java.lang.String str = b;
            com.igexin.c.a.c.a.a(str, "detect task already stop");
            com.igexin.c.a.c.a.a(str + "|detect task already stop", new java.lang.Object[0]);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = b;
        sb.append(str2);
        sb.append("|");
        sb.append(j / 1000);
        sb.append("s passed, do task method, start redect ~~~~");
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        boolean e = com.igexin.push.h.c.e();
        com.igexin.push.core.e.n = e;
        if (e) {
            com.igexin.push.c.c.a().c();
            return;
        }
        com.igexin.c.a.c.a.a(str2 + "|" + (j / 1000) + "s passed, network is unavailable, stop ###", new java.lang.Object[0]);
    }

    public final void i() {
        this.p = false;
        this.e = true;
        l();
    }
}
