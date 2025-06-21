package com.anythink.basead.d.b;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.basead.d.b.a c;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> a = new java.util.concurrent.ConcurrentHashMap<>(3);
    private android.content.Context b;

    /* renamed from: com.anythink.basead.d.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.b.a.InterfaceC0135a b;

        public AnonymousClass1(com.anythink.core.common.f.m mVar, com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a) {
            this.a = mVar;
            this.b = interfaceC0135a;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a = this.b;
            if (interfaceC0135a != null) {
                interfaceC0135a.a(null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a = this.b;
            if (interfaceC0135a != null) {
                interfaceC0135a.a(null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, str));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
        @Override // com.anythink.core.common.h.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onLoadFinish(int i, java.lang.Object obj) {
            org.json.JSONObject jSONObject;
            com.anythink.core.common.f.ah ahVar;
            try {
                jSONObject = (org.json.JSONObject) obj;
            } catch (java.lang.Exception unused) {
                jSONObject = null;
            }
            try {
                jSONObject.put(com.anythink.basead.d.b.b.a, java.lang.System.currentTimeMillis());
                ahVar = com.anythink.basead.d.b.b.a(this.a, jSONObject);
            } catch (java.lang.Exception unused2) {
                ahVar = null;
                if (ahVar != null) {
                }
            }
            if (ahVar != null) {
                com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a = this.b;
                if (interfaceC0135a != null) {
                    interfaceC0135a.a(null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, obj != null ? obj.toString() : "No Ad Return."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.c.a(ahVar);
            if (ahVar.b() == 1 && com.anythink.basead.a.a.a(com.anythink.basead.d.b.a.this.b.getApplicationContext(), ahVar.E())) {
                com.anythink.basead.d.c.d a = com.anythink.basead.d.c.d.a();
                android.content.Context context = com.anythink.basead.d.b.a.this.b;
                com.anythink.core.common.f.m mVar = this.a;
                a.a(context, com.anythink.basead.d.c.d.a(mVar.b, mVar.c), ahVar, this.a.n);
                com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a2 = this.b;
                if (interfaceC0135a2 != null) {
                    interfaceC0135a2.a(null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, "Application installed."));
                    return;
                }
                return;
            }
            if (ahVar.b() == 2 && !com.anythink.basead.a.a.a(com.anythink.basead.d.b.a.this.b.getApplicationContext(), ahVar.E())) {
                com.anythink.basead.d.c.d a2 = com.anythink.basead.d.c.d.a();
                android.content.Context context2 = com.anythink.basead.d.b.a.this.b;
                com.anythink.core.common.f.m mVar2 = this.a;
                a2.a(context2, com.anythink.basead.d.c.d.a(mVar2.b, mVar2.c), ahVar, this.a.n);
                com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a3 = this.b;
                if (interfaceC0135a3 != null) {
                    interfaceC0135a3.a(null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, "Application not installed yet."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.a.a(this.a, ahVar);
            com.anythink.basead.a.a.a(10, ahVar, new com.anythink.basead.c.i(this.a.d, ""));
            com.anythink.core.basead.b.a();
            android.content.Context context3 = com.anythink.basead.d.b.a.this.b;
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.a(context3, com.anythink.core.basead.b.a(this.a), jSONObject.toString());
            com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a4 = this.b;
            if (interfaceC0135a4 != null) {
                interfaceC0135a4.a();
            }
            com.anythink.basead.d.b.a.this.a(ahVar, this.a, this.b);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.basead.d.b.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.a.b.b.InterfaceC0129b {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.b.a.InterfaceC0135a b;
        final /* synthetic */ com.anythink.core.common.f.ah c;

        public AnonymousClass2(com.anythink.core.common.f.m mVar, com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a, com.anythink.core.common.f.ah ahVar) {
            this.a = mVar;
            this.b = interfaceC0135a;
            this.c = ahVar;
        }

        @Override // com.anythink.basead.a.b.b.InterfaceC0129b
        public final void a() {
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> concurrentHashMap = com.anythink.basead.d.b.a.this.a;
            com.anythink.core.basead.b.a();
            concurrentHashMap.put(com.anythink.core.basead.b.a(this.a), java.lang.Boolean.FALSE);
            com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a = this.b;
            if (interfaceC0135a != null) {
                interfaceC0135a.a(this.c);
            }
        }

        @Override // com.anythink.basead.a.b.b.InterfaceC0129b
        public final void a(com.anythink.basead.c.e eVar) {
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> concurrentHashMap = com.anythink.basead.d.b.a.this.a;
            com.anythink.core.basead.b.a();
            concurrentHashMap.put(com.anythink.core.basead.b.a(this.a), java.lang.Boolean.FALSE);
            com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a = this.b;
            if (interfaceC0135a != null) {
                interfaceC0135a.a(this.c, eVar);
            }
        }
    }

    /* renamed from: com.anythink.basead.d.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0135a {
        void a();

        void a(com.anythink.core.common.f.ah ahVar);

        void a(com.anythink.core.common.f.ah ahVar, com.anythink.basead.c.e eVar);
    }

    private a(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    public static com.anythink.basead.d.b.a a(android.content.Context context) {
        if (c == null) {
            synchronized (com.anythink.basead.d.b.a.class) {
                if (c == null) {
                    c = new com.anythink.basead.d.b.a(context);
                }
            }
        }
        return c;
    }

    private com.anythink.core.common.f.ah a(com.anythink.core.common.f.m mVar) {
        com.anythink.core.basead.b.a();
        java.lang.String a = com.anythink.core.basead.b.a(mVar);
        com.anythink.core.basead.b.a();
        java.lang.String a2 = com.anythink.core.basead.b.a(this.b, a);
        com.anythink.core.common.f.ah ahVar = null;
        if (android.text.TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            ahVar = com.anythink.basead.d.b.b.a(mVar, new org.json.JSONObject(a2));
        } catch (java.lang.Throwable unused) {
        }
        if (ahVar != null) {
            com.anythink.basead.d.c.c.a(ahVar);
            com.anythink.basead.d.c.a.a(mVar, ahVar);
        }
        return ahVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.f.ah ahVar, com.anythink.core.common.f.m mVar, com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a) {
        com.anythink.basead.a.e.a();
        com.anythink.basead.a.e.a(mVar.b, ahVar, mVar, new com.anythink.basead.d.b.a.AnonymousClass2(mVar, interfaceC0135a, ahVar));
    }

    private void b(com.anythink.core.common.f.m mVar, java.lang.String str, com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a) {
        com.anythink.core.common.f.ah ahVar;
        int i;
        int i2;
        java.lang.String[] split;
        int parseInt;
        try {
            ahVar = a(mVar);
        } catch (java.lang.Throwable unused) {
            ahVar = null;
        }
        if (ahVar != null && !ahVar.U()) {
            if (interfaceC0135a != null) {
                interfaceC0135a.a();
            }
            a(ahVar, mVar, interfaceC0135a);
            return;
        }
        if (!android.text.TextUtils.isEmpty(mVar.n.x())) {
            try {
                split = mVar.n.x().split("x");
                i = java.lang.Integer.parseInt(split[0]);
            } catch (java.lang.Throwable unused2) {
                i = 0;
            }
            try {
                parseInt = java.lang.Integer.parseInt(split[1]);
                i2 = i;
            } catch (java.lang.Throwable unused3) {
                i2 = i;
                parseInt = 0;
                new com.anythink.basead.g.d(mVar, i2, parseInt, com.anythink.basead.d.c.d.a().a(this.b, com.anythink.basead.d.c.d.a(mVar.b, mVar.c)), str).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.b.a.AnonymousClass1(mVar, interfaceC0135a));
            }
            new com.anythink.basead.g.d(mVar, i2, parseInt, com.anythink.basead.d.c.d.a().a(this.b, com.anythink.basead.d.c.d.a(mVar.b, mVar.c)), str).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.b.a.AnonymousClass1(mVar, interfaceC0135a));
        }
        i2 = 0;
        parseInt = 0;
        new com.anythink.basead.g.d(mVar, i2, parseInt, com.anythink.basead.d.c.d.a().a(this.b, com.anythink.basead.d.c.d.a(mVar.b, mVar.c)), str).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.b.a.AnonymousClass1(mVar, interfaceC0135a));
    }

    public final void a(com.anythink.core.common.f.m mVar, java.lang.String str, com.anythink.basead.d.b.a.InterfaceC0135a interfaceC0135a) {
        int i;
        int i2;
        java.lang.String[] split;
        int parseInt;
        com.anythink.core.basead.b.a();
        java.lang.String a = com.anythink.core.basead.b.a(mVar);
        com.anythink.core.common.f.ah ahVar = null;
        if (this.a.contains(a) && this.a.get(a).booleanValue()) {
            interfaceC0135a.a(null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.g, com.anythink.basead.c.f.r));
            return;
        }
        this.a.put(a, java.lang.Boolean.TRUE);
        try {
            ahVar = a(mVar);
        } catch (java.lang.Throwable unused) {
        }
        if (ahVar != null && !ahVar.U()) {
            interfaceC0135a.a();
            a(ahVar, mVar, interfaceC0135a);
            return;
        }
        if (!android.text.TextUtils.isEmpty(mVar.n.x())) {
            try {
                split = mVar.n.x().split("x");
                i = java.lang.Integer.parseInt(split[0]);
            } catch (java.lang.Throwable unused2) {
                i = 0;
            }
            try {
                parseInt = java.lang.Integer.parseInt(split[1]);
                i2 = i;
            } catch (java.lang.Throwable unused3) {
                i2 = i;
                parseInt = 0;
                new com.anythink.basead.g.d(mVar, i2, parseInt, com.anythink.basead.d.c.d.a().a(this.b, com.anythink.basead.d.c.d.a(mVar.b, mVar.c)), str).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.b.a.AnonymousClass1(mVar, interfaceC0135a));
            }
            new com.anythink.basead.g.d(mVar, i2, parseInt, com.anythink.basead.d.c.d.a().a(this.b, com.anythink.basead.d.c.d.a(mVar.b, mVar.c)), str).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.b.a.AnonymousClass1(mVar, interfaceC0135a));
        }
        i2 = 0;
        parseInt = 0;
        new com.anythink.basead.g.d(mVar, i2, parseInt, com.anythink.basead.d.c.d.a().a(this.b, com.anythink.basead.d.c.d.a(mVar.b, mVar.c)), str).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.b.a.AnonymousClass1(mVar, interfaceC0135a));
    }
}
