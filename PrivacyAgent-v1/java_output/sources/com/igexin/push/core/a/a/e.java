package com.igexin.push.core.a.a;

/* loaded from: classes23.dex */
public final class e extends com.igexin.push.core.a.a {
    private static final java.lang.String b = com.igexin.push.config.c.a + "_RegisterFailResultAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if ((obj instanceof com.igexin.push.d.c.q) && ((com.igexin.push.d.c.q) obj).b == 1) {
            java.lang.String str = b;
            com.igexin.c.a.c.a.a(str, "Register failed because of the wrong appid");
            com.igexin.c.a.c.a.a(str + "|Register failed because of the wrong appid", new java.lang.Object[0]);
            com.igexin.c.a.c.a.d.a().a("Register failed because of the wrong appid = " + com.igexin.push.core.e.a);
            com.igexin.push.core.e.q = true;
            com.igexin.push.core.d.a.a.h.b();
        }
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
