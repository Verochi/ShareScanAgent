package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.expressad.videocommon.b.a a;
    private final com.anythink.core.common.res.a.c b = com.anythink.core.common.res.a.c.a();

    private a() {
    }

    public static com.anythink.expressad.videocommon.b.a a() {
        if (a == null) {
            synchronized (com.anythink.expressad.videocommon.b.a.class) {
                if (a == null) {
                    a = new com.anythink.expressad.videocommon.b.a();
                }
            }
        }
        return a;
    }

    public static java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).c(4, com.anythink.core.common.o.g.a(str));
    }

    public static com.anythink.core.common.a.j b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return com.anythink.core.common.a.k.a().a(str);
    }
}
