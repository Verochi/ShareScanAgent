package com.anythink.core.d;

/* loaded from: classes12.dex */
public class f {
    public static final java.lang.String a = "f";
    private static volatile com.anythink.core.d.f b;
    private android.content.Context c;
    private final com.anythink.core.d.h e;
    private final com.anythink.core.d.i d = new com.anythink.core.d.i();
    private final com.anythink.core.d.g f = new com.anythink.core.d.g(this);

    /* renamed from: com.anythink.core.d.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.d.f.c b;
        final /* synthetic */ com.anythink.core.d.e c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ java.util.Map f;
        final /* synthetic */ boolean g;

        /* renamed from: com.anythink.core.d.f$1$1, reason: invalid class name and collision with other inner class name */
        public class C01751 implements com.anythink.core.common.m.b {
            final /* synthetic */ boolean[] a;
            final /* synthetic */ com.anythink.core.d.f.b b;

            public C01751(boolean[] zArr, com.anythink.core.d.f.b bVar) {
                this.a = zArr;
                this.b = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                java.lang.String str = com.anythink.core.d.f.a;
                this.a[0] = true;
                this.b.a(com.anythink.core.d.f.AnonymousClass1.this.c);
            }
        }

        public AnonymousClass1(java.lang.String str, com.anythink.core.d.f.c cVar, com.anythink.core.d.e eVar, java.lang.String str2, java.lang.String str3, java.util.Map map, boolean z) {
            this.a = str;
            this.b = cVar;
            this.c = eVar;
            this.d = str2;
            this.e = str3;
            this.f = map;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.f.b bVar = new com.anythink.core.d.f.b(this.a, this.b);
            com.anythink.core.d.e eVar = this.c;
            java.lang.String Z = eVar != null ? eVar.Z() : "";
            java.util.Map<java.lang.String, java.lang.Object> d = com.anythink.core.common.b.o.a().d(this.a);
            com.anythink.core.common.f.al alVar = new com.anythink.core.common.f.al(this.d, this.e, this.a, Z, d, this.f);
            com.anythink.core.d.e eVar2 = this.c;
            com.anythink.core.d.f.AnonymousClass1.C01751 c01751 = null;
            if (eVar2 == null) {
                com.anythink.core.d.g unused = com.anythink.core.d.f.this.f;
                com.anythink.core.d.g.a(com.anythink.core.d.f.this.c, alVar, com.anythink.core.d.f.this.new a(alVar, bVar, null));
                return;
            }
            alVar.a(eVar2.az());
            if (this.g) {
                com.anythink.core.d.g unused2 = com.anythink.core.d.f.this.f;
                com.anythink.core.d.g.a(com.anythink.core.d.f.this.c, alVar, com.anythink.core.d.f.this.new a(alVar, bVar, this.c));
                return;
            }
            if (this.c.aI()) {
                alVar.a((java.util.Map<java.lang.String, java.lang.String>) null);
                com.anythink.core.d.g unused3 = com.anythink.core.d.f.this.f;
                com.anythink.core.d.g.a(com.anythink.core.d.f.this.c, alVar, com.anythink.core.d.f.this.new a(alVar, bVar, this.c));
                bVar.a(this.c);
                return;
            }
            if (this.c.aL()) {
                bVar.a();
                bVar.a(this.c);
            }
            com.anythink.core.d.e e = com.anythink.core.d.f.this.e(this.a);
            if (e == null) {
                java.lang.String str = com.anythink.core.d.f.a;
                alVar.a((java.util.Map<java.lang.String, java.lang.String>) null);
                com.anythink.core.d.g unused4 = com.anythink.core.d.f.this.f;
                com.anythink.core.d.g.a(com.anythink.core.d.f.this.c, alVar, com.anythink.core.d.f.this.new a(alVar, bVar, this.c));
                return;
            }
            alVar.a(e.az());
            if (!((d.equals(e.W()) ^ true) || e.aU() || com.anythink.core.common.r.a().c(com.anythink.core.d.f.this.c, this.a))) {
                bVar.a(this.c);
                return;
            }
            java.lang.String str2 = com.anythink.core.d.f.a;
            boolean[] zArr = new boolean[1];
            long ah = e.ah();
            com.anythink.core.common.m.a a = com.anythink.core.common.m.d.a();
            if (ah == 0) {
                zArr[0] = true;
                bVar.a(this.c);
            } else {
                c01751 = new com.anythink.core.d.f.AnonymousClass1.C01751(zArr, bVar);
                a.a(c01751, ah, false);
            }
            com.anythink.core.c.b.a().b(this.a);
            com.anythink.core.d.g unused5 = com.anythink.core.d.f.this.f;
            com.anythink.core.d.g.a(com.anythink.core.d.f.this.c, alVar, com.anythink.core.d.f.this.new a(alVar, bVar, this.c, a, c01751, zArr));
        }
    }

    /* renamed from: com.anythink.core.d.f$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.d.e a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(com.anythink.core.d.e eVar, java.lang.String str) {
            this.a = eVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.f.a(com.anythink.core.d.f.this.c, this.a);
            if (this.a.X() == 1) {
                com.anythink.core.common.r.a().a(com.anythink.core.d.f.this.c, this.b);
            }
        }
    }

    public class a implements com.anythink.core.common.h.k {
        private final com.anythink.core.common.f.al b;
        private final com.anythink.core.d.f.c c;
        private final com.anythink.core.d.e d;
        private com.anythink.core.common.m.a e;
        private boolean[] f;
        private com.anythink.core.common.m.b g;

        public a(com.anythink.core.common.f.al alVar, com.anythink.core.d.f.c cVar, com.anythink.core.d.e eVar) {
            this.b = alVar;
            this.c = cVar;
            this.d = eVar;
        }

        public a(com.anythink.core.common.f.al alVar, com.anythink.core.d.f.c cVar, com.anythink.core.d.e eVar, com.anythink.core.common.m.a aVar, com.anythink.core.common.m.b bVar, boolean[] zArr) {
            this.b = alVar;
            this.c = cVar;
            this.e = aVar;
            this.f = zArr;
            this.g = bVar;
            this.d = eVar;
        }

        private void a() {
            com.anythink.core.common.m.b bVar;
            com.anythink.core.common.m.a aVar = this.e;
            if (aVar == null || (bVar = this.g) == null) {
                return;
            }
            aVar.b(bVar);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            a();
            com.anythink.core.d.f.c cVar = this.c;
            if (cVar == null) {
                return;
            }
            com.anythink.core.d.e eVar = this.d;
            if (eVar == null) {
                cVar.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, "", "by canceled"));
            } else {
                cVar.a(eVar);
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.core.d.f.c cVar;
            a();
            if (this.b != null && com.anythink.core.api.ErrorCode.statuError.equals(adError.getCode()) && (com.anythink.core.api.ErrorCode.placementIdError.equals(adError.getPlatformCode()) || com.anythink.core.api.ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                java.lang.String str2 = this.b.a() + this.b.c() + this.b.b();
                java.lang.String str3 = com.anythink.core.d.f.a;
                adError.getPlatformCode();
                adError.getPlatformMSG();
                com.anythink.core.common.o.r.a(com.anythink.core.d.f.this.c, com.anythink.core.common.b.h.E, str2, java.lang.System.currentTimeMillis());
                if (com.anythink.core.common.b.o.a().A()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("Please check these params in your code (AppId: ");
                    sb.append(this.b.a());
                    sb.append(", AppKey: ");
                    sb.append(this.b.b());
                    sb.append(", PlacementId: ");
                    sb.append(this.b.c());
                    sb.append(")");
                }
            }
            com.anythink.core.d.e eVar = this.d;
            if (eVar == null && (cVar = this.c) != null) {
                cVar.a(adError);
                return;
            }
            com.anythink.core.d.f.c cVar2 = this.c;
            if (cVar2 != null) {
                cVar2.a(eVar);
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            a();
            com.anythink.core.d.f.this.a(obj, this.b, this.c, this.f, this.d);
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    public static class b implements com.anythink.core.d.f.c {
        private final java.lang.String a;
        private final com.anythink.core.d.f.c b;
        private boolean c = true;
        private volatile boolean d = false;

        public b(java.lang.String str, com.anythink.core.d.f.c cVar) {
            this.a = str;
            this.b = cVar;
        }

        public final void a() {
            this.c = false;
        }

        @Override // com.anythink.core.d.f.c
        public final void a(com.anythink.core.api.AdError adError) {
            if (this.b == null || this.d) {
                return;
            }
            this.d = true;
            this.b.a(adError);
        }

        @Override // com.anythink.core.d.f.c
        public final void a(com.anythink.core.d.e eVar) {
            if (this.b == null || this.d) {
                return;
            }
            com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.a, eVar.aQ());
            this.d = true;
            this.b.a(eVar);
        }

        @Override // com.anythink.core.d.f.c
        public final void b(com.anythink.core.d.e eVar) {
            com.anythink.core.d.f.c cVar = this.b;
            if (cVar == null || !this.c) {
                return;
            }
            cVar.b(eVar);
        }
    }

    public interface c {
        void a(com.anythink.core.api.AdError adError);

        void a(com.anythink.core.d.e eVar);

        void b(com.anythink.core.d.e eVar);
    }

    private f(android.content.Context context) {
        this.c = context;
        this.e = new com.anythink.core.d.h(context);
    }

    public static com.anythink.core.d.f a(android.content.Context context) {
        if (b == null) {
            synchronized (com.anythink.core.d.f.class) {
                if (b == null) {
                    b = new com.anythink.core.d.f(context);
                }
            }
        }
        return b;
    }

    public static /* synthetic */ void a(android.content.Context context, com.anythink.core.d.e eVar) {
        int p = eVar.p();
        com.anythink.core.common.b.o.a().c(p);
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "r", p);
    }

    private void a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        com.anythink.core.d.e a2;
        org.json.JSONObject aH;
        if (jSONObject != null) {
            if (jSONObject2 == null && android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (jSONObject2 != null) {
                    jSONObject.put(com.anythink.core.d.e.a.ab, jSONObject2);
                } else {
                    if (android.text.TextUtils.isEmpty(str) || (a2 = a(str)) == null || (aH = a2.aH()) == null) {
                        return;
                    }
                    jSONObject.put(com.anythink.core.d.e.a.ab, aH);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void b(android.content.Context context, com.anythink.core.d.e eVar) {
        int p = eVar.p();
        com.anythink.core.common.b.o.a().c(p);
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "r", p);
    }

    public final com.anythink.core.d.e a(java.lang.String str) {
        return this.e.b(com.anythink.core.common.b.o.a().o(), str);
    }

    public final void a() {
        android.content.Context context = this.c;
        if (context != null) {
            try {
                context.getSharedPreferences(com.anythink.core.common.b.h.E, 0).edit().clear().apply();
            } catch (java.lang.Error | java.lang.Exception unused) {
            }
        }
    }

    public final void a(com.anythink.core.d.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.d.f.c cVar) {
        a(eVar, str, str2, str3, map, cVar, false);
    }

    public final void a(com.anythink.core.d.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.d.f.c cVar, boolean z) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.d.f.AnonymousClass1(str3, cVar, eVar, str, str2, map, z), 2);
    }

    public final void a(java.lang.Object obj, com.anythink.core.common.f.al alVar, com.anythink.core.d.f.c cVar, boolean[] zArr, com.anythink.core.d.e eVar) {
        if (!(obj instanceof org.json.JSONObject) || alVar == null) {
            if (cVar != null) {
                if (eVar == null) {
                    cVar.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.placeStrategyError, "", "Placement LoadParams error."));
                    return;
                } else {
                    cVar.a(eVar);
                    return;
                }
            }
            return;
        }
        org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
        try {
            jSONObject.put(com.anythink.core.d.e.a.ad, java.lang.System.currentTimeMillis());
            com.anythink.core.d.e e = e(alVar.c());
            if (e != null) {
                e.a(jSONObject, alVar.c());
            }
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("parse place strategy error:").append(th.getMessage());
        }
        com.anythink.core.d.e a2 = com.anythink.core.d.e.a(jSONObject);
        java.lang.String c2 = alVar.c();
        if (a2 != null) {
            if (a2.ai() != 1) {
                jSONObject = null;
            }
            a(c2, a2, jSONObject, 0);
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.d.f.AnonymousClass2(a2, c2));
            if (!a2.aK() || a2.aL()) {
                this.e.b(alVar.a(), c2, 2);
            } else {
                alVar.a(a2.aJ());
                this.f.a(this.c, alVar);
            }
        }
        if (zArr != null && zArr.length > 0 && zArr[0]) {
            if (cVar == null || a2 == null) {
                return;
            }
            cVar.b(a2);
            return;
        }
        if (cVar != null) {
            if (a2 != null) {
                cVar.a(a2);
            } else {
                cVar.a(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.placeStrategyError, "", "Placement Service error."));
            }
        }
    }

    public final void a(java.lang.String str, int i) {
        this.e.a(str, i);
    }

    public final void a(java.lang.String str, com.anythink.core.d.e eVar, org.json.JSONObject jSONObject, int i) {
        this.e.a(com.anythink.core.common.b.o.a().o(), str, eVar, jSONObject, i);
    }

    public final com.anythink.core.d.e b(java.lang.String str) {
        return a(str);
    }

    public final com.anythink.core.d.e c(java.lang.String str) {
        return this.e.a(com.anythink.core.common.b.o.a().o(), str);
    }

    public final com.anythink.core.d.e d(java.lang.String str) {
        return this.e.a(com.anythink.core.common.b.o.a().o(), str, 2);
    }

    public final com.anythink.core.d.e e(java.lang.String str) {
        return this.e.a(com.anythink.core.common.b.o.a().o(), str, 0);
    }

    public final com.anythink.core.d.e f(java.lang.String str) {
        java.lang.String o = com.anythink.core.common.b.o.a().o();
        if (this.e.a(com.anythink.core.common.b.o.a().o(), str, 0) != null) {
            this.e.b(o, str, 1);
            return null;
        }
        com.anythink.core.d.e a2 = this.e.a(o, str, 1);
        if (a2 == null) {
            a2 = this.d.b(str);
        }
        if (a2 != null) {
            a(str, a2, null, 1);
        }
        return a2;
    }

    public final void g(java.lang.String str) {
        this.e.c(com.anythink.core.common.b.o.a().o(), str);
    }

    public final void h(java.lang.String str) {
        this.d.a(str);
    }
}
