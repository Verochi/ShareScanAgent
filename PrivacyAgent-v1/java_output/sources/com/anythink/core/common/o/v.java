package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class v {
    public static java.util.List<com.anythink.core.common.f.ay.a> a(java.lang.String str, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.av a;
        if (auVar == null || (a = com.anythink.core.common.a.a().a(str, auVar)) == null) {
            return null;
        }
        java.util.List<com.anythink.core.common.f.ay.a> f = a.a((com.anythink.core.common.f.q) null).f();
        com.anythink.core.common.f.q a2 = com.anythink.core.b.f.a().a(str, auVar);
        if (a2 != null && !a2.a()) {
            if (f == null) {
                f = new java.util.ArrayList<>();
            }
            f.add(new com.anythink.core.common.f.ay.a(auVar, a2));
        }
        return f;
    }

    public static boolean a(com.anythink.core.common.f.au auVar) {
        return auVar.d() == 15 && !auVar.k();
    }

    public static boolean a(java.util.List<com.anythink.core.common.f.au> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.anythink.core.common.f.au auVar = list.get(i);
                if (auVar != null && auVar.Z()) {
                    return true;
                }
            }
        }
        return false;
    }
}
