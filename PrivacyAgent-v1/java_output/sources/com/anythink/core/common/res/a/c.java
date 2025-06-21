package com.anythink.core.common.res.a;

/* loaded from: classes12.dex */
public class c {
    private static volatile com.anythink.core.common.res.a.c a;
    private final java.util.Map<java.lang.String, com.anythink.core.common.res.a.a> b = new java.util.HashMap();

    private c() {
    }

    public static com.anythink.core.common.res.a.c a() {
        if (a == null) {
            synchronized (com.anythink.core.common.res.a.c.class) {
                if (a == null) {
                    a = new com.anythink.core.common.res.a.c();
                }
            }
        }
        return a;
    }

    public final com.anythink.core.common.res.a.a a(java.lang.String str) {
        com.anythink.core.common.res.a.a aVar = this.b.get(str);
        if (aVar != null) {
            return aVar;
        }
        com.anythink.core.common.res.a.a aVar2 = new com.anythink.core.common.res.a.a(str);
        this.b.put(str, aVar2);
        return aVar2;
    }

    public final void b(java.lang.String str) {
        if (this.b == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }
}
