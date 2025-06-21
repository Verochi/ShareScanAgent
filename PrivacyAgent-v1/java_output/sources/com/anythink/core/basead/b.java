package com.anythink.core.basead;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.core.basead.b a;

    private b() {
    }

    public static com.anythink.core.basead.b a() {
        if (a == null) {
            synchronized (com.anythink.core.basead.b.class) {
                if (a == null) {
                    a = new com.anythink.core.basead.b();
                }
            }
        }
        return a;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        return com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.z, str, "");
    }

    public static java.lang.String a(com.anythink.core.common.f.m mVar) {
        return mVar == null ? "" : a(mVar.b, mVar.c, mVar.f);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, int i) {
        return str + "_" + str2 + "_" + i;
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.z, str, str2);
    }

    public static void b(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.z, str);
    }
}
