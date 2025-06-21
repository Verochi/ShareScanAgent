package com.anythink.basead.d.a;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.basead.d.a.a d;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> a = new java.util.concurrent.ConcurrentHashMap<>(3);
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.a.h> b = new java.util.concurrent.ConcurrentHashMap<>(2);
    private android.content.Context c;

    /* renamed from: com.anythink.basead.d.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.a.a.InterfaceC0133a b;

        public AnonymousClass1(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
            this.a = mVar;
            this.b = interfaceC0133a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.d.a.a.a(com.anythink.basead.d.a.a.this, this.a, this.b);
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.a.a.InterfaceC0133a b;

        public AnonymousClass2(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
            this.a = mVar;
            this.b = interfaceC0133a;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.b;
            if (interfaceC0133a != null) {
                interfaceC0133a.a((com.anythink.core.common.f.j) null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.b;
            if (interfaceC0133a != null) {
                interfaceC0133a.a((com.anythink.core.common.f.j) null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, str));
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            com.anythink.core.common.f.j jVar;
            try {
                com.anythink.core.common.f.m mVar = this.a;
                jVar = com.anythink.core.common.a.d.a(mVar.a, (org.json.JSONObject) obj, mVar.f);
            } catch (java.lang.Exception unused) {
                jVar = null;
            }
            if (jVar == null) {
                com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.b;
                if (interfaceC0133a != null) {
                    interfaceC0133a.a((com.anythink.core.common.f.j) null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, obj != null ? obj.toString() : "No Ad Return."));
                    return;
                }
                return;
            }
            jVar.c(this.a.m);
            jVar.h(this.a.d);
            com.anythink.basead.d.c.c.a(jVar);
            com.anythink.basead.d.c.a.a(this.a, jVar);
            if (this.a.f == 67) {
                com.anythink.core.common.d.c.a(com.anythink.basead.d.a.a.this.c).a(jVar.s(), jVar.V());
                com.anythink.core.common.d.b.a(com.anythink.basead.d.a.a.this.c).a(jVar.t(), jVar.V());
            }
            com.anythink.core.common.a.a a = com.anythink.core.common.a.a.a();
            android.content.Context context = com.anythink.basead.d.a.a.this.c;
            com.anythink.core.common.f.m mVar2 = this.a;
            a.a(context, mVar2.c, mVar2.a, obj.toString());
            com.anythink.expressad.foundation.d.d a2 = com.anythink.basead.d.a.a.this.a(jVar, this.a);
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a2 = this.b;
            if (interfaceC0133a2 != null) {
                interfaceC0133a2.a(jVar);
            }
            com.anythink.basead.d.a.a.this.a(jVar, this.a, a2, this.b);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.ai a;
        final /* synthetic */ com.anythink.core.common.f.m b;
        final /* synthetic */ com.anythink.basead.d.a.a.InterfaceC0133a c;

        public AnonymousClass3(com.anythink.core.common.f.ai aiVar, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
            this.a = aiVar;
            this.b = mVar;
            this.c = interfaceC0133a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.f.ai aiVar = this.a;
            if (aiVar == null || !(aiVar instanceof com.anythink.core.common.f.j) || android.text.TextUtils.isEmpty(((com.anythink.core.common.f.j) aiVar).a())) {
                return;
            }
            com.anythink.basead.d.a.b.a();
            com.anythink.basead.d.a.b.a((com.anythink.core.common.f.j) this.a);
            com.anythink.basead.d.a.a.this.a((com.anythink.core.common.f.j) this.a, this.b, this.c, true);
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.basead.d.a.b.a {
        final /* synthetic */ com.anythink.basead.d.a.a.InterfaceC0133a a;
        final /* synthetic */ com.anythink.core.common.f.m b;
        final /* synthetic */ com.anythink.core.common.f.j c;

        public AnonymousClass4(com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.j jVar) {
            this.a = interfaceC0133a;
            this.b = mVar;
            this.c = jVar;
        }

        @Override // com.anythink.basead.d.a.b.a
        public final void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.d.a.a.this.a.put(this.b.b + this.b.a, java.lang.Boolean.FALSE);
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.a;
            if (interfaceC0133a != null) {
                interfaceC0133a.a(this.c, eVar);
            }
        }

        @Override // com.anythink.basead.d.a.b.a
        public final void a(com.anythink.core.common.a.h hVar) {
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.a;
            if (interfaceC0133a != null) {
                interfaceC0133a.a(hVar);
            }
        }

        @Override // com.anythink.basead.d.a.b.a
        public final void b(com.anythink.core.common.a.h hVar) {
            com.anythink.basead.d.a.a.this.a.put(this.b.b + this.b.a, java.lang.Boolean.FALSE);
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.a;
            if (interfaceC0133a != null) {
                interfaceC0133a.a(this.c, hVar);
            }
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.basead.a.b.b.InterfaceC0129b {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.a.a.InterfaceC0133a b;
        final /* synthetic */ com.anythink.core.common.f.j c;

        public AnonymousClass5(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a, com.anythink.core.common.f.j jVar) {
            this.a = mVar;
            this.b = interfaceC0133a;
            this.c = jVar;
        }

        @Override // com.anythink.basead.a.b.b.InterfaceC0129b
        public final void a() {
            com.anythink.basead.d.a.a.this.a.put(this.a.b + this.a.a, java.lang.Boolean.FALSE);
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.b;
            if (interfaceC0133a != null) {
                interfaceC0133a.a(this.c, (com.anythink.core.common.a.h) null);
            }
        }

        @Override // com.anythink.basead.a.b.b.InterfaceC0129b
        public final void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.d.a.a.this.a.put(this.a.b + this.a.a, java.lang.Boolean.FALSE);
            com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a = this.b;
            if (interfaceC0133a != null) {
                interfaceC0133a.a(this.c, eVar);
            }
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0133a {
        void a(com.anythink.core.common.a.h hVar);

        void a(com.anythink.core.common.f.j jVar);

        void a(com.anythink.core.common.f.j jVar, com.anythink.basead.c.e eVar);

        void a(com.anythink.core.common.f.j jVar, com.anythink.core.common.a.h hVar);
    }

    private a(android.content.Context context) {
        this.c = context.getApplicationContext();
    }

    public static com.anythink.basead.d.a.a a(android.content.Context context) {
        if (d == null) {
            synchronized (com.anythink.basead.d.a.a.class) {
                if (d == null) {
                    d = new com.anythink.basead.d.a.a(context);
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.anythink.expressad.foundation.d.d a(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar) {
        if (android.text.TextUtils.isEmpty(jVar.a())) {
            return null;
        }
        com.anythink.expressad.foundation.d.d a = com.anythink.expressad.foundation.d.d.a(jVar.a());
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList = a.J;
        com.anythink.basead.d.a.b.a(jVar, arrayList.get(0));
        com.anythink.basead.d.a.b.a(jVar, arrayList);
        com.anythink.basead.d.a.b.a(mVar, arrayList);
        return a;
    }

    public static /* synthetic */ void a(com.anythink.basead.d.a.a aVar, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
        com.anythink.core.common.f.j jVar;
        try {
            jVar = aVar.a(mVar);
            try {
                jVar.c(mVar.m);
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            jVar = null;
        }
        if (jVar == null) {
            new com.anythink.basead.g.a(mVar).a(0, (com.anythink.core.common.h.k) aVar.new AnonymousClass2(mVar, interfaceC0133a));
        } else {
            aVar.a(jVar, mVar, interfaceC0133a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a, boolean z) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList2;
        jVar.h(mVar.d);
        com.anythink.expressad.foundation.d.d a = a(jVar, mVar);
        if (interfaceC0133a != null) {
            interfaceC0133a.a(jVar);
        }
        if (!z) {
            a(jVar, mVar, a, interfaceC0133a);
            return;
        }
        boolean z2 = true;
        if (!java.lang.String.valueOf(mVar.j).equals("0") && !java.lang.String.valueOf(mVar.j).equals("2")) {
            z2 = false;
            if (java.lang.String.valueOf(mVar.j).equals("4")) {
                if (a != null && (arrayList2 = a.J) != null && arrayList2.size() > 0) {
                    z2 = com.anythink.expressad.splash.c.b.a(a.J.get(0));
                }
            } else if (a != null && (arrayList = a.J) != null && arrayList.size() > 0) {
                z2 = com.anythink.expressad.videocommon.b.n.b(a.J);
            }
        }
        if (z2) {
            a(jVar, mVar, a, interfaceC0133a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
        if (!android.text.TextUtils.isEmpty(jVar.a())) {
            com.anythink.basead.d.a.b.a().a(jVar, mVar, dVar, new com.anythink.basead.d.a.a.AnonymousClass4(interfaceC0133a, mVar, jVar));
        } else {
            com.anythink.basead.a.e.a();
            com.anythink.basead.a.e.a(mVar.b, jVar, mVar, new com.anythink.basead.d.a.a.AnonymousClass5(mVar, interfaceC0133a, jVar));
        }
    }

    private void b(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
        com.anythink.core.common.f.j jVar;
        try {
            jVar = a(mVar);
            try {
                jVar.c(mVar.m);
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            jVar = null;
        }
        if (jVar == null) {
            new com.anythink.basead.g.a(mVar).a(0, (com.anythink.core.common.h.k) new com.anythink.basead.d.a.a.AnonymousClass2(mVar, interfaceC0133a));
        } else {
            a(jVar, mVar, interfaceC0133a, false);
        }
    }

    public final com.anythink.core.common.f.j a(com.anythink.core.common.f.m mVar) {
        com.anythink.core.common.f.ag a = com.anythink.core.common.a.a.a().a(this.c, mVar.a);
        com.anythink.core.common.f.j jVar = null;
        if (a != null && !android.text.TextUtils.isEmpty(a.a())) {
            try {
                jVar = com.anythink.core.common.a.d.a(mVar.a, new org.json.JSONObject(a.a()), mVar.f);
                jVar.c(a.b());
            } catch (java.lang.Throwable unused) {
            }
            if (jVar != null) {
                com.anythink.basead.d.c.c.a(jVar);
                com.anythink.basead.d.c.a.a(mVar, jVar);
            }
        }
        return jVar;
    }

    public final void a(com.anythink.core.common.f.ai aiVar, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
        com.anythink.core.common.o.b.b.a().c(new com.anythink.basead.d.a.a.AnonymousClass3(aiVar, mVar, interfaceC0133a));
    }

    public final void a(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.a.InterfaceC0133a interfaceC0133a) {
        if (this.a.contains(mVar.b + mVar.a)) {
            if (this.a.get(mVar.b + mVar.a).booleanValue()) {
                interfaceC0133a.a((com.anythink.core.common.f.j) null, com.anythink.basead.c.f.a(com.anythink.basead.c.f.g, com.anythink.basead.c.f.r));
                return;
            }
        }
        this.a.put(mVar.b + mVar.a, java.lang.Boolean.TRUE);
        com.anythink.core.common.o.b.b.a().c(new com.anythink.basead.d.a.a.AnonymousClass1(mVar, interfaceC0133a));
    }
}
