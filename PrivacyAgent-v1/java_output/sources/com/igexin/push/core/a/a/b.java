package com.igexin.push.core.a.a;

/* loaded from: classes23.dex */
public final class b extends com.igexin.push.core.a.a {
    private static final java.lang.String b = "KeyNegotiateResultAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if (obj instanceof com.igexin.push.d.c.h) {
            com.igexin.push.d.c.h hVar = (com.igexin.push.d.c.h) obj;
            boolean z = hVar.b == 0;
            com.igexin.c.a.c.a.a("KeyNegotiateResultAction|KeyNego result = " + ((int) hVar.b), new java.lang.Object[0]);
            if (z) {
                com.igexin.c.a.c.a.a("KeyNegotiateResultAction|KeyNego success and login", new java.lang.Object[0]);
                com.igexin.push.core.k.a();
                com.igexin.push.core.k.c();
            }
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
