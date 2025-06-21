package com.anythink.expressad.mbbanner.a.d;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String a = "a";
    private static volatile com.anythink.expressad.mbbanner.a.d.a h;
    private android.content.Context b = com.anythink.core.common.b.o.a().f();
    private com.anythink.expressad.mbbanner.a.e.a c = new com.anythink.expressad.mbbanner.a.e.a();
    private java.util.Map<java.lang.String, com.anythink.expressad.mbbanner.a.b.e> d = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, java.lang.Boolean> e = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, android.os.Handler> f = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, java.lang.Integer> g = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: com.anythink.expressad.mbbanner.a.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.mbbanner.a.c.d {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.mbbanner.a.c.d
        public final void a(java.lang.String str) {
            synchronized (com.anythink.expressad.mbbanner.a.d.a.a()) {
                com.anythink.expressad.mbbanner.a.d.a.this.e.put(str, java.lang.Boolean.FALSE);
            }
        }
    }

    private a() {
    }

    public static com.anythink.expressad.mbbanner.a.d.a a() {
        if (h == null) {
            synchronized (com.anythink.expressad.mbbanner.a.d.a.class) {
                if (h == null) {
                    h = new com.anythink.expressad.mbbanner.a.d.a();
                }
            }
        }
        return h;
    }

    private void a(java.lang.String str, com.anythink.expressad.mbbanner.a.b.d dVar, com.anythink.expressad.mbbanner.a.c.b bVar) {
        if (this.b == null) {
            this.c.a(bVar, "Banner Context == null!", str);
            return;
        }
        if (dVar == null || bVar == null) {
            this.c.a(bVar, "Banner request parameters or callback empty!", str);
            return;
        }
        java.util.Map<java.lang.String, java.lang.Boolean> map = this.e;
        if (map != null && map.containsKey(str) && this.e.get(str).booleanValue()) {
            this.c.a(bVar, "Current unit is loading!", str);
            return;
        }
        this.e.put(str, java.lang.Boolean.TRUE);
        new com.anythink.expressad.mbbanner.a.d.b(this.b, b(str), bVar, this.c);
    }

    private com.anythink.expressad.mbbanner.a.b.e b(java.lang.String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        java.lang.String e = com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(e, str);
        if (c == null) {
            c = com.anythink.expressad.d.c.c(str);
        }
        com.anythink.expressad.mbbanner.a.b.e eVar = new com.anythink.expressad.mbbanner.a.b.e(str, "", c.t() * 1);
        this.d.put(str, eVar);
        return eVar;
    }

    public final void a(int i, java.lang.String str) {
        int intValue = this.g.containsKey(str) ? this.g.get(str).intValue() : 0;
        if (i == 1) {
            if (this.f.containsKey(str)) {
                this.f.get(str).removeCallbacksAndMessages(null);
            }
            this.g.put(str, java.lang.Integer.valueOf(i));
            return;
        }
        if (i == 2) {
            if (intValue == 1) {
                if (this.f.containsKey(str)) {
                    this.f.get(str).removeCallbacksAndMessages(null);
                }
                this.g.put(str, java.lang.Integer.valueOf(i));
                return;
            }
            return;
        }
        if (i == 3) {
            if (intValue == 2 || intValue == 4) {
                this.g.put(str, 1);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        if (intValue == 0) {
            this.g.put(str, 0);
            return;
        }
        if (this.f.containsKey(str)) {
            this.f.get(str).removeCallbacksAndMessages(null);
        }
        this.g.put(str, java.lang.Integer.valueOf(i));
    }

    public final void a(java.lang.String str) {
        if (this.f.containsKey(str)) {
            this.f.get(str).removeCallbacksAndMessages(null);
            this.f.remove(str);
        }
    }

    public final void a(java.lang.String str, com.anythink.expressad.foundation.d.d dVar, com.anythink.expressad.mbbanner.a.c.b bVar) {
        synchronized (a()) {
            java.util.Map<java.lang.String, java.lang.Boolean> map = this.e;
            if (map != null && map.containsKey(str) && this.e.get(str).booleanValue()) {
                this.c.a(bVar, "Current unit is loading!", str);
                return;
            }
            this.e.put(str, java.lang.Boolean.TRUE);
            new com.anythink.expressad.mbbanner.a.d.b(this.b, b(str), bVar, this.c).a(str, dVar, new com.anythink.expressad.mbbanner.a.d.a.AnonymousClass1());
        }
    }

    public final void b() {
        java.util.Map<java.lang.String, com.anythink.expressad.mbbanner.a.b.e> map = this.d;
        if (map != null) {
            map.clear();
        }
        java.util.Map<java.lang.String, java.lang.Boolean> map2 = this.e;
        if (map2 != null) {
            map2.clear();
        }
        java.util.Map<java.lang.String, android.os.Handler> map3 = this.f;
        if (map3 != null) {
            for (java.util.Map.Entry<java.lang.String, android.os.Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f.clear();
        }
        java.util.Map<java.lang.String, java.lang.Integer> map4 = this.g;
        if (map4 != null) {
            map4.clear();
        }
    }
}
