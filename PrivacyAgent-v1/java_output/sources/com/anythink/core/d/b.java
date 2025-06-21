package com.anythink.core.d;

/* loaded from: classes12.dex */
public class b {
    public static final java.lang.String a = "b";
    private static volatile com.anythink.core.d.b c;
    private static volatile com.anythink.core.d.a d;
    private android.content.Context e;
    private java.lang.String h;
    private java.lang.Object g = new java.lang.Object();
    private boolean f = false;
    java.util.List<com.anythink.core.d.b.a> b = java.util.Collections.synchronizedList(new java.util.ArrayList(3));

    /* renamed from: com.anythink.core.d.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ org.json.JSONObject c;
        final /* synthetic */ com.anythink.core.d.a d;

        public AnonymousClass1(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, com.anythink.core.d.a aVar) {
            this.a = context;
            this.b = str;
            this.c = jSONObject;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(this.a)).a(this.b, this.c.toString(), com.anythink.core.d.b.this.h);
            com.anythink.core.common.o.r.a(this.a, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.l, this.d.ae());
        }
    }

    /* renamed from: com.anythink.core.d.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.h.k {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.core.d.b.b(com.anythink.core.d.b.this);
            com.anythink.core.d.b.this.e();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.core.d.b.b(com.anythink.core.d.b.this);
            com.anythink.core.d.b.this.e();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            com.anythink.core.d.b.b(com.anythink.core.d.b.this);
            com.anythink.core.d.b bVar = com.anythink.core.d.b.this;
            com.anythink.core.d.b.a(bVar, bVar.e, obj, this.a);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.core.d.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.h.k {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.core.d.b.this.e();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.core.d.b.this.e();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            com.anythink.core.d.b.a(com.anythink.core.d.b.this, this.a, obj, this.b);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.core.d.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.l.a().a(com.anythink.core.d.b.d.k());
            com.anythink.core.common.i.e.a().a(com.anythink.core.d.b.d);
        }
    }

    public interface a {
        void a();

        void b();
    }

    private b(android.content.Context context) {
        this.e = context;
        if (com.anythink.core.common.e.c.a().b()) {
            this.h = com.anythink.core.common.b.h.u.b;
        } else {
            this.h = com.anythink.core.common.b.h.u.a;
        }
    }

    public static long a() {
        if (d == null || d.R() == 0) {
            return 51200L;
        }
        return d.R();
    }

    private com.anythink.core.d.a a(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.f.ar arVar;
        java.util.List<com.anythink.core.common.f.ar> a2 = com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(context)).a(str, this.h);
        if (a2 != null && a2.size() > 0 && (arVar = a2.get(0)) != null) {
            try {
                com.anythink.core.d.a a3 = com.anythink.core.d.a.a(new org.json.JSONObject(arVar.d()));
                if (a3 != null) {
                    a3.a(java.lang.Long.parseLong(arVar.a()));
                }
                return a3;
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    private com.anythink.core.d.a a(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.anythink.core.d.a b = a(context).b(str);
            if (!b.O()) {
                b.a(jSONObject, null);
            }
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.core.d.a a2 = com.anythink.core.d.a.a(jSONObject);
        a2.a(java.lang.System.currentTimeMillis());
        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.d.b.AnonymousClass1(context, str, jSONObject, a2));
        return a2;
    }

    public static com.anythink.core.d.b a(android.content.Context context) {
        if (c == null) {
            synchronized (com.anythink.core.d.b.class) {
                if (c == null) {
                    c = new com.anythink.core.d.b(context);
                }
            }
        }
        return c;
    }

    private static void a(android.content.Context context, com.anythink.core.d.a aVar) {
        if (aVar == null) {
            return;
        }
        java.lang.String v = aVar.v();
        if (android.text.TextUtils.isEmpty(v)) {
            return;
        }
        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, v), (com.anythink.core.common.res.b.a) null);
    }

    private void a(android.content.Context context, java.lang.Object obj, java.lang.String str) {
        if (obj instanceof org.json.JSONObject) {
            com.anythink.core.d.a a2 = a(context, str, (org.json.JSONObject) obj);
            if (a2 != null) {
                d = a2;
                java.lang.String A = a2.A();
                if (!android.text.TextUtils.isEmpty(A) && android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().y())) {
                    com.anythink.core.common.b.o.a().j(A);
                }
                com.anythink.core.common.q.a(context).a(d);
                com.anythink.core.d.a aVar = d;
                if (aVar != null) {
                    java.lang.String v = aVar.v();
                    if (!android.text.TextUtils.isEmpty(v)) {
                        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, v), (com.anythink.core.common.res.b.a) null);
                    }
                }
                com.anythink.core.common.o.b.b.a().a(new com.anythink.core.d.b.AnonymousClass4());
                com.anythink.core.common.w.a().a(d.b());
                com.anythink.core.common.c.a().a(d.d());
            }
            e();
        }
    }

    private void a(com.anythink.core.d.b.a aVar) {
        synchronized (this.g) {
            if (this.g != null) {
                this.b.add(aVar);
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.core.d.b bVar, android.content.Context context, java.lang.Object obj, java.lang.String str) {
        if (obj instanceof org.json.JSONObject) {
            com.anythink.core.d.a a2 = bVar.a(context, str, (org.json.JSONObject) obj);
            if (a2 != null) {
                d = a2;
                java.lang.String A = a2.A();
                if (!android.text.TextUtils.isEmpty(A) && android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().y())) {
                    com.anythink.core.common.b.o.a().j(A);
                }
                com.anythink.core.common.q.a(context).a(d);
                com.anythink.core.d.a aVar = d;
                if (aVar != null) {
                    java.lang.String v = aVar.v();
                    if (!android.text.TextUtils.isEmpty(v)) {
                        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, v), (com.anythink.core.common.res.b.a) null);
                    }
                }
                com.anythink.core.common.o.b.b.a().a(bVar.new AnonymousClass4());
                com.anythink.core.common.w.a().a(d.b());
                com.anythink.core.common.c.a().a(d.d());
            }
            bVar.e();
        }
    }

    private void a(org.json.JSONObject jSONObject) {
        org.json.JSONObject aw;
        try {
            com.anythink.core.d.a b = b(com.anythink.core.common.b.o.a().o());
            if (b == null || (aw = b.aw()) == null) {
                return;
            }
            jSONObject.put("a_c", aw);
        } catch (java.lang.Exception unused) {
        }
    }

    private void b(android.content.Context context) {
        this.e = context;
    }

    private void b(com.anythink.core.d.b.a aVar) {
        synchronized (this.g) {
            if (aVar != null) {
                this.b.remove(aVar);
            }
        }
    }

    public static /* synthetic */ boolean b(com.anythink.core.d.b bVar) {
        bVar.f = false;
        return false;
    }

    private android.content.Context d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.g) {
            java.util.Iterator<com.anythink.core.d.b.a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.b.clear();
        }
    }

    private static com.anythink.core.d.a f() {
        com.anythink.core.d.a aVar = new com.anythink.core.d.a();
        aVar.b = true;
        aVar.aa();
        aVar.b("0");
        aVar.a(0L);
        aVar.ag();
        aVar.aj();
        aVar.al();
        aVar.c("");
        aVar.ao();
        aVar.aq();
        aVar.d("");
        aVar.Y();
        aVar.S();
        aVar.K();
        aVar.M();
        aVar.a("[\"com.anythink\"]");
        aVar.G();
        aVar.m();
        aVar.q();
        aVar.o();
        aVar.s();
        return aVar;
    }

    private boolean g() {
        return this.f;
    }

    private static void h() {
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2) {
        if (this.f) {
            return;
        }
        this.f = true;
        new com.anythink.core.common.h.d(this.e, str, str2, d.az()).a(0, (com.anythink.core.common.h.k) new com.anythink.core.d.b.AnonymousClass2(str));
    }

    public final boolean a(java.lang.String str) {
        com.anythink.core.d.a b = b(str);
        if (b != null) {
            com.anythink.core.d.d a2 = b.a();
            long Z = b.Z();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            boolean z = b.T() + Z <= currentTimeMillis;
            boolean z2 = a2 != null && b.T() + a2.a() <= currentTimeMillis;
            boolean z3 = b.c != null ? !r11.equals(r4) : com.anythink.core.common.b.o.a().l() != null;
            if (!z && !z2 && !z3) {
                return false;
            }
        }
        return true;
    }

    public final com.anythink.core.d.a b(java.lang.String str) {
        if (d == null) {
            synchronized (this) {
                if (d == null) {
                    try {
                        if (this.e == null) {
                            this.e = com.anythink.core.common.b.o.a().f();
                        }
                        d = a(this.e, str);
                    } catch (java.lang.Throwable unused) {
                    }
                    if (d == null) {
                        com.anythink.core.d.a aVar = new com.anythink.core.d.a();
                        aVar.b = true;
                        aVar.aa();
                        aVar.b("0");
                        aVar.a(0L);
                        aVar.ag();
                        aVar.aj();
                        aVar.al();
                        aVar.c("");
                        aVar.ao();
                        aVar.aq();
                        aVar.d("");
                        aVar.Y();
                        aVar.S();
                        aVar.K();
                        aVar.M();
                        aVar.a("[\"com.anythink\"]");
                        aVar.G();
                        aVar.m();
                        aVar.q();
                        aVar.o();
                        aVar.s();
                        d = aVar;
                    }
                }
            }
        }
        return d;
    }

    public final void b() {
        com.anythink.core.common.b.o a2 = com.anythink.core.common.b.o.a();
        java.lang.String o = a2.o();
        java.lang.String p = a2.p();
        android.content.Context context = this.e;
        if (context == null || android.text.TextUtils.isEmpty(o) || android.text.TextUtils.isEmpty(p)) {
            return;
        }
        com.anythink.core.d.a b = b(o);
        java.util.Map<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        if (!b.b) {
            hashMap = b.az();
        }
        new com.anythink.core.common.h.g(context, o, p, hashMap).a(0, (com.anythink.core.common.h.k) new com.anythink.core.d.b.AnonymousClass3(context, o));
    }
}
