package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public final class m {
    private static com.anythink.expressad.foundation.g.f.m c;
    private com.anythink.expressad.foundation.g.f.j a;
    private com.anythink.expressad.foundation.g.f.d.b b;

    private m() {
    }

    public static com.anythink.expressad.foundation.g.f.d.b a() {
        com.anythink.expressad.foundation.g.f.m mVar = c;
        if (mVar != null) {
            com.anythink.expressad.foundation.g.f.d.b bVar = mVar.b;
            if (bVar != null) {
                return bVar;
            }
            mVar.b = new com.anythink.expressad.foundation.g.f.d.b(b());
            return c.b;
        }
        com.anythink.expressad.foundation.g.f.m mVar2 = new com.anythink.expressad.foundation.g.f.m();
        c = mVar2;
        if (mVar2.b == null) {
            mVar2.b = new com.anythink.expressad.foundation.g.f.d.b(b());
        }
        return c.b;
    }

    public static void a(android.content.Context context) {
        if (c == null) {
            com.anythink.expressad.foundation.g.f.m mVar = new com.anythink.expressad.foundation.g.f.m();
            c = mVar;
            mVar.a = new com.anythink.expressad.foundation.g.f.j(context.getApplicationContext());
            c.b = new com.anythink.expressad.foundation.g.f.d.b(b());
        }
    }

    public static void a(com.anythink.expressad.foundation.g.f.i iVar) {
        b().a(iVar);
    }

    private static com.anythink.expressad.foundation.g.f.j b() {
        com.anythink.expressad.foundation.g.f.m mVar = c;
        if (mVar != null) {
            com.anythink.expressad.foundation.g.f.j jVar = mVar.a;
            if (jVar != null) {
                return jVar;
            }
            mVar.a = new com.anythink.expressad.foundation.g.f.j(com.anythink.core.common.b.o.a().f());
            return c.a;
        }
        com.anythink.expressad.foundation.g.f.m mVar2 = new com.anythink.expressad.foundation.g.f.m();
        c = mVar2;
        if (mVar2.a == null) {
            mVar2.a = new com.anythink.expressad.foundation.g.f.j(com.anythink.core.common.b.o.a().f());
        }
        return c.a;
    }

    private static void c() {
        com.anythink.expressad.foundation.g.f.d.b bVar;
        com.anythink.expressad.foundation.g.f.m mVar = c;
        if (mVar == null || (bVar = mVar.b) == null) {
            return;
        }
        bVar.a();
        c.b = null;
    }
}
