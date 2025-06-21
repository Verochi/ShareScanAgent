package com.anythink.core.a;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.core.a.b c;
    final java.lang.String a = com.anythink.core.a.b.class.getSimpleName();
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.d> b = new java.util.concurrent.ConcurrentHashMap<>();

    public static com.anythink.core.a.b a() {
        if (c == null) {
            synchronized (com.anythink.core.a.b.class) {
                if (c == null) {
                    c = new com.anythink.core.a.b();
                }
            }
        }
        return c;
    }

    public final boolean a(android.content.Context context, java.lang.String str, com.anythink.core.d.e eVar) {
        if (eVar.at() <= 0) {
            return false;
        }
        com.anythink.core.common.f.d dVar = this.b.get(str);
        if (dVar == null) {
            java.lang.String b = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.w, str, "");
            dVar = new com.anythink.core.common.f.d();
            if (!android.text.TextUtils.isEmpty(b)) {
                dVar.a(b);
            }
            this.b.put(str, dVar);
        }
        dVar.toString();
        return dVar.a >= eVar.at() && java.lang.System.currentTimeMillis() - dVar.b <= eVar.au();
    }

    public final void b(android.content.Context context, java.lang.String str, com.anythink.core.d.e eVar) {
        com.anythink.core.common.f.d dVar = this.b.get(str);
        if (dVar == null) {
            java.lang.String b = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.w, str, "");
            com.anythink.core.common.f.d dVar2 = new com.anythink.core.common.f.d();
            if (!android.text.TextUtils.isEmpty(b)) {
                dVar2.a(b);
            }
            this.b.put(str, dVar2);
            dVar = dVar2;
        }
        if (java.lang.System.currentTimeMillis() - dVar.b > eVar.au()) {
            dVar.b = java.lang.System.currentTimeMillis();
            dVar.a = 0;
        }
        dVar.a++;
        dVar.toString();
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.w, str, dVar.toString());
    }
}
