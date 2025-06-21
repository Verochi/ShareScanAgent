package com.igexin.push.core.a.a;

/* loaded from: classes23.dex */
public final class a extends com.igexin.push.core.a.a {
    private static final java.lang.String b = "HeartbeatAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if (!(obj instanceof com.igexin.push.d.c.f)) {
            return true;
        }
        com.igexin.push.d.c.b.a.d();
        com.igexin.c.a.c.a.a("heartbeatRsp", new java.lang.Object[0]);
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.a);
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
