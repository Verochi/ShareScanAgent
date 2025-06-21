package com.anythink.core.common;

/* loaded from: classes12.dex */
public class d {
    private static final java.lang.String a = "d";
    private static volatile com.anythink.core.common.d d;
    private android.content.Context b;
    private final java.util.Map<java.lang.String, com.anythink.core.common.f.p> c = new java.util.concurrent.ConcurrentHashMap(8);

    private d() {
    }

    public static com.anythink.core.common.d a() {
        if (d == null) {
            synchronized (com.anythink.core.common.d.class) {
                if (d == null) {
                    d = new com.anythink.core.common.d();
                }
            }
        }
        return d;
    }

    public final com.anythink.core.common.f.p a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.anythink.core.common.f.p remove = this.c.remove(str);
        java.util.Objects.toString(remove);
        if (remove != null) {
            com.anythink.core.common.o.r.a(this.b, com.anythink.core.common.b.h.N, str);
        }
        return remove;
    }

    public final void a(android.content.Context context) {
        com.anythink.core.common.f.p a2;
        this.b = context;
        try {
            java.util.Map<java.lang.String, ?> a3 = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.N);
            if (a3 != null) {
                for (java.util.Map.Entry<java.lang.String, ?> entry : a3.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.lang.Object value = entry.getValue();
                    if ((value instanceof java.lang.String) && (a2 = com.anythink.core.common.f.p.a((java.lang.String) value)) != null) {
                        this.c.put(key, a2);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.String str, com.anythink.core.common.f.p pVar) {
        java.util.Objects.toString(pVar);
        this.c.put(str, pVar);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.anythink.core.common.f.au a2;
        com.anythink.core.common.f.p pVar = this.c.get(str);
        if (pVar == null || (a2 = pVar.a()) == null || !android.text.TextUtils.equals(a2.u(), str3) || !android.text.TextUtils.equals(pVar.b(), str2)) {
            return;
        }
        pVar.c();
        b(str);
    }

    public final void b(java.lang.String str) {
        try {
            com.anythink.core.common.f.p pVar = this.c.get(str);
            if (pVar != null) {
                com.anythink.core.common.o.r.a(this.b, com.anythink.core.common.b.h.N, str, pVar.g().toString());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.anythink.core.common.f.au a2;
        com.anythink.core.common.f.p pVar = this.c.get(str);
        if (pVar == null || (a2 = pVar.a()) == null || !android.text.TextUtils.equals(a2.u(), str3) || !android.text.TextUtils.equals(pVar.b(), str2)) {
            return;
        }
        pVar.d();
        b(str);
    }
}
