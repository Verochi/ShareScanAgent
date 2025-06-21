package com.anythink.core.common;

/* loaded from: classes12.dex */
public class l {
    private static volatile com.anythink.core.common.l c;
    com.anythink.core.common.c.h a;
    private final java.lang.String b = getClass().getSimpleName();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> d = new java.util.concurrent.ConcurrentHashMap<>(3);

    /* renamed from: com.anythink.core.common.l$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.l.this.a.c();
        }
    }

    public l() {
        com.anythink.core.common.c.h a = com.anythink.core.common.c.h.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
        this.a = a;
        java.util.List<com.anythink.core.common.f.w> d = a.d();
        if (d != null) {
            java.util.Iterator<com.anythink.core.common.f.w> it = d.iterator();
            while (it.hasNext()) {
                this.d.put(it.next().a(), "1");
            }
        }
    }

    public static com.anythink.core.common.l a() {
        if (c == null) {
            synchronized (com.anythink.core.common.l.class) {
                if (c == null) {
                    c = new com.anythink.core.common.l();
                }
            }
        }
        return c;
    }

    public static int b() {
        return com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.r, 0);
    }

    public final void a(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Object> c2 = com.anythink.core.common.o.i.c(com.anythink.core.common.o.d.c(str));
        if (c2.size() == 0) {
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.r, 0);
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : c2.entrySet()) {
            try {
                if (com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), entry.getValue().toString())) {
                    this.d.put(entry.getKey(), "1");
                    this.a.a(entry.getKey());
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.r, b() + c2.size());
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.l.AnonymousClass1(), 13, true);
    }

    public final org.json.JSONArray c() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = this.d.entrySet().iterator();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        while (it.hasNext()) {
            try {
                jSONArray.put(java.lang.Long.parseLong(it.next().getKey()));
            } catch (java.lang.Throwable unused) {
            }
        }
        return jSONArray;
    }
}
