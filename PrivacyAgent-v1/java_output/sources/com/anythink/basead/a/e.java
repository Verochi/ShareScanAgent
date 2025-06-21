package com.anythink.basead.a;

/* loaded from: classes12.dex */
public class e {
    public static final java.lang.String a = "e";
    private static volatile com.anythink.basead.a.e b;

    private e() {
    }

    public static com.anythink.basead.a.e a() {
        if (b == null) {
            synchronized (com.anythink.basead.a.e.class) {
                if (b == null) {
                    b = new com.anythink.basead.a.e();
                }
            }
        }
        return b;
    }

    public static java.lang.String a(int i, java.lang.String str) {
        return com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).c(i, com.anythink.core.common.o.g.a(str));
    }

    public static void a(java.lang.String str, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.basead.a.b.b.InterfaceC0129b interfaceC0129b) {
        a(str, false, lVar, mVar, interfaceC0129b);
    }

    private static void a(java.lang.String str, java.util.List<com.anythink.core.common.f.z> list, com.anythink.core.common.f.ab abVar) {
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.anythink.core.common.f.m mVar = new com.anythink.core.common.f.m();
            mVar.n = abVar;
            a(str, true, list.get(i), mVar, null);
        }
    }

    public static void a(java.lang.String str, boolean z, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.basead.a.b.b.InterfaceC0129b interfaceC0129b) {
        new com.anythink.basead.a.b.b(str, z, lVar, mVar).a(interfaceC0129b);
    }

    public static boolean a(com.anythink.core.common.f.z zVar, int i, com.anythink.core.common.f.n nVar) {
        return com.anythink.basead.a.b.c.a(zVar, i, nVar);
    }

    public static boolean a(com.anythink.core.common.f.z zVar, com.anythink.core.common.f.m mVar) {
        return com.anythink.basead.a.b.c.a(zVar, mVar);
    }

    public static boolean a(java.lang.String str, java.io.InputStream inputStream) {
        if (str == null || inputStream == null) {
            return false;
        }
        return com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(1, com.anythink.core.common.o.g.a(str), inputStream);
    }

    private static java.io.FileInputStream b(int i, java.lang.String str) {
        return com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(i, com.anythink.core.common.o.g.a(str));
    }
}
