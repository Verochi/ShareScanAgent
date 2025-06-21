package com.anythink.core.common;

/* loaded from: classes12.dex */
public class x {
    private static final java.lang.String c = "x";
    private static volatile com.anythink.core.common.x d;
    java.util.Map<java.lang.String, com.anythink.core.common.f.ay> a;
    android.content.Context b;

    private x(android.content.Context context) {
        this.b = context.getApplicationContext();
        a();
    }

    public static com.anythink.core.common.x a(android.content.Context context) {
        if (d == null) {
            synchronized (com.anythink.core.common.x.class) {
                if (d == null) {
                    d = new com.anythink.core.common.x(context);
                }
            }
        }
        return d;
    }

    private void a() {
        if (this.a == null) {
            this.a = new java.util.concurrent.ConcurrentHashMap(5);
            try {
                java.util.Map<java.lang.String, ?> a = com.anythink.core.common.o.r.a(this.b, com.anythink.core.common.b.h.F);
                if (a != null) {
                    for (java.util.Map.Entry<java.lang.String, ?> entry : a.entrySet()) {
                        java.lang.String key = entry.getKey();
                        java.lang.Object value = entry.getValue();
                        if (value instanceof java.lang.String) {
                            this.a.put(key, com.anythink.core.common.f.ay.a((java.lang.String) value));
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private com.anythink.core.common.f.ay b(java.lang.String str) {
        java.util.Map<java.lang.String, com.anythink.core.common.f.ay> map = this.a;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }

    private static void b() {
    }

    public final void a(java.lang.String str) {
        java.util.Map<java.lang.String, com.anythink.core.common.f.ay> map = this.a;
        if (map == null) {
            return;
        }
        try {
            com.anythink.core.common.f.ay ayVar = map.get(str);
            if (ayVar != null) {
                com.anythink.core.common.o.r.a(this.b, com.anythink.core.common.b.h.F, str, ayVar.a().toString());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.ay.a aVar, com.anythink.core.common.f.ay.a aVar2) {
        java.util.Map<java.lang.String, com.anythink.core.common.f.ay> map = this.a;
        if (map == null) {
            return;
        }
        com.anythink.core.common.f.ay ayVar = map.get(str);
        if (ayVar == null) {
            synchronized (this) {
                ayVar = this.a.get(str);
                if (ayVar == null) {
                    ayVar = new com.anythink.core.common.f.ay();
                    ayVar.b(str2);
                    this.a.put(str, ayVar);
                }
            }
        }
        if (android.text.TextUtils.equals(str2, ayVar.b())) {
            if (aVar != null) {
                ayVar.a(aVar);
                ayVar.a(java.lang.System.currentTimeMillis());
            }
            if (aVar2 != null) {
                ayVar.b(aVar2);
            }
        }
    }
}
