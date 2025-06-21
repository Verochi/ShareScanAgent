package com.anythink.core.common.a;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.core.common.a.b b;
    private final java.lang.String a = getClass().getSimpleName();
    private java.util.Map<java.lang.String, com.anythink.core.common.a.b.a> c = new java.util.concurrent.ConcurrentHashMap();

    public class a {
        private com.anythink.core.common.f.au b;
        private com.anythink.core.api.ATBaseAdAdapter c;
        private com.anythink.core.api.BaseAd d;
        private com.anythink.core.common.f.b e;
        private java.lang.String f;
        private com.anythink.core.common.f.h g;

        public a() {
        }

        private void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            this.c = aTBaseAdAdapter;
        }

        private void a(com.anythink.core.api.BaseAd baseAd) {
            this.d = baseAd;
        }

        private void a(com.anythink.core.common.f.au auVar) {
            this.b = auVar;
        }

        private void a(com.anythink.core.common.f.b bVar) {
            this.e = bVar;
        }

        public final synchronized com.anythink.core.common.f.b a() {
            boolean internalIsAdReady;
            java.lang.String unused = com.anythink.core.common.a.b.this.a;
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.c;
            com.anythink.core.common.f.h hVar = this.g;
            if (aTBaseAdAdapter == null) {
                return null;
            }
            if (hVar == null) {
                return null;
            }
            if (this.e != null) {
                java.lang.String unused2 = com.anythink.core.common.a.b.this.a;
                return this.e;
            }
            this.d = null;
            hVar.E(12);
            if (android.text.TextUtils.equals(this.g.ae(), "0")) {
                com.anythink.core.api.BaseAd baseAdObject = this.c.getBaseAdObject(com.anythink.core.common.b.o.a().f());
                this.d = baseAdObject;
                internalIsAdReady = baseAdObject != null;
            } else {
                internalIsAdReady = this.c.internalIsAdReady();
            }
            java.lang.String unused3 = com.anythink.core.common.a.b.this.a;
            if (internalIsAdReady) {
                com.anythink.core.common.o.u.a(this.c, this.g, this.b);
                com.anythink.core.api.BaseAd baseAd = this.d;
                if (baseAd != null) {
                    baseAd.setTrackingInfo(this.c.getTrackingInfo().S());
                }
                this.b.M().b(this.f);
                com.anythink.core.b.d.b.a(this.c, this.b, this.g, this.d);
                com.anythink.core.common.f.b bVar = new com.anythink.core.common.f.b();
                this.e = bVar;
                bVar.a(this.c);
                this.e.c(java.lang.System.currentTimeMillis());
                this.e.b(this.b.q());
                this.e.a(this.b.B());
                this.e.a("3");
                com.anythink.core.api.BaseAd baseAd2 = this.d;
                if (baseAd2 != null) {
                    this.e.a(baseAd2);
                }
            }
            return this.e;
        }

        public final synchronized void a(java.lang.String str, com.anythink.core.common.f.h hVar) {
            java.lang.String unused = com.anythink.core.common.a.b.this.a;
            this.f = str;
            this.g = hVar;
        }

        public final synchronized void b() {
            java.lang.String unused = com.anythink.core.common.a.b.this.a;
            com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.c;
            com.anythink.core.common.f.h hVar = this.g;
            a();
        }

        public final synchronized void c() {
            java.lang.String unused = com.anythink.core.common.a.b.this.a;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        public final synchronized double d() {
            return com.anythink.core.common.o.h.a(this.b);
        }

        public final com.anythink.core.common.f.au e() {
            return this.b;
        }

        public final com.anythink.core.common.f.b f() {
            return this.e;
        }
    }

    private b() {
    }

    public static com.anythink.core.common.a.b a() {
        if (b == null) {
            synchronized (com.anythink.core.common.a.b.class) {
                if (b == null) {
                    b = new com.anythink.core.common.a.b();
                }
            }
        }
        return b;
    }

    public final com.anythink.core.common.a.b.a a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar, com.anythink.core.d.e eVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (android.text.TextUtils.isEmpty(str) || auVar == null) {
            return null;
        }
        com.anythink.core.common.f.av a2 = com.anythink.core.common.a.a().a(str, auVar);
        if (a2 != null && a2.a((com.anythink.core.common.f.q) null).b() != null) {
            return null;
        }
        com.anythink.core.common.a.b.a aVar = this.c.get(str);
        if (aVar != null && aVar.c != null) {
            return aVar;
        }
        com.anythink.core.common.f.q a3 = com.anythink.core.b.f.a().a(str, auVar);
        if (a3 != null) {
            a3.a();
        }
        if (a3 != null && !a3.a()) {
            auVar.a(a3, 0, 2, 1);
            com.anythink.core.api.ATBaseAdAdapter a4 = com.anythink.core.common.o.j.a(auVar);
            if (a4 != null && a4.internalInitNetworkObjectByPlacementId(context, eVar.a(str, str2, auVar), map)) {
                com.anythink.core.common.a.b.a aVar2 = new com.anythink.core.common.a.b.a();
                aVar2.c = a4;
                aVar2.b = auVar;
                this.c.put(str, aVar2);
                return aVar2;
            }
        }
        return null;
    }

    public final com.anythink.core.common.f.b a(java.lang.String str) {
        com.anythink.core.common.a.b.a aVar;
        if (android.text.TextUtils.isEmpty(str) || (aVar = this.c.get(str)) == null || aVar.c == null || aVar.e == null || !aVar.e.j()) {
            return null;
        }
        aVar.d();
        return aVar.e;
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.a.b.a aVar;
        if (android.text.TextUtils.isEmpty(str) || (aVar = this.c.get(str)) == null || aVar.b == null || !aVar.b.u().equals(str2)) {
            return;
        }
        aVar.c();
    }
}
