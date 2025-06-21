package com.igexin.push.g;

/* loaded from: classes23.dex */
public final class e implements com.igexin.push.g.b.c {
    private static final java.lang.String a = "SilentTask";
    private static com.igexin.push.g.e b;
    private boolean c = com.igexin.push.h.c.a(java.lang.System.currentTimeMillis());

    private e() {
    }

    public static com.igexin.push.g.e a() {
        if (b == null) {
            b = new com.igexin.push.g.e();
        }
        return b;
    }

    @Override // com.igexin.push.g.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.g.b.c
    public final void b() {
        d();
    }

    @Override // com.igexin.push.g.b.c
    public final boolean c() {
        return com.igexin.push.config.d.c != 0;
    }

    public final void d() {
        boolean z = this.c;
        boolean a2 = com.igexin.push.h.c.a(java.lang.System.currentTimeMillis());
        this.c = a2;
        if (!z || a2) {
            return;
        }
        com.igexin.c.a.c.a.b(a, "out silence time");
        com.igexin.push.g.a.a().a(false);
    }
}
