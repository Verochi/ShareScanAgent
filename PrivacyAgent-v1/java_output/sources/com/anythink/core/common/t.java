package com.anythink.core.common;

/* loaded from: classes12.dex */
public class t {
    private static volatile com.anythink.core.common.t c;
    private java.lang.String b = com.anythink.core.common.t.class.getSimpleName();
    java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

    /* renamed from: com.anythink.core.common.t$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        public AnonymousClass1(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.f.u uVar = new com.anythink.core.common.f.u();
            uVar.b = this.a;
            uVar.d = this.b;
            uVar.c = this.c;
            uVar.e = this.d;
            uVar.f = java.lang.System.currentTimeMillis();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.b);
            sb.append(uVar.f);
            sb.append(this.d);
            uVar.a = com.anythink.core.common.o.g.a(sb.toString() != null ? this.d : "");
            uVar.g = this.e;
            java.lang.String unused = com.anythink.core.common.t.this.b;
            uVar.a();
            com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).a(uVar);
        }
    }

    /* renamed from: com.anythink.core.common.t$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.h.a.c.a {
        final /* synthetic */ com.anythink.core.common.f.u a;

        public AnonymousClass2(com.anythink.core.common.f.u uVar) {
            this.a = uVar;
        }

        @Override // com.anythink.core.common.h.a.c.a
        public final void a(java.lang.Object obj) {
            java.lang.String unused = com.anythink.core.common.t.this.b;
            this.a.a();
            com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).b(this.a);
            com.anythink.core.common.t.this.a.decrementAndGet();
        }

        @Override // com.anythink.core.common.h.a.c.a
        public final void a(java.lang.Throwable th) {
            java.lang.String unused = com.anythink.core.common.t.this.b;
            this.a.a();
            th.getMessage();
            com.anythink.core.common.t.this.a.decrementAndGet();
        }
    }

    /* renamed from: com.anythink.core.common.t$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.common.f.u a;
        final /* synthetic */ com.anythink.core.common.h.n b;

        public AnonymousClass3(com.anythink.core.common.f.u uVar, com.anythink.core.common.h.n nVar) {
            this.a = uVar;
            this.b = nVar;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            com.anythink.core.common.t.this.a.decrementAndGet();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            java.lang.String unused = com.anythink.core.common.t.this.b;
            this.a.a();
            com.anythink.core.common.t.this.a.decrementAndGet();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            java.lang.String unused = com.anythink.core.common.t.this.b;
            this.a.a();
            com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).b(this.b.q());
            com.anythink.core.common.t.this.a.decrementAndGet();
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    private t() {
    }

    public static com.anythink.core.common.t a() {
        if (c == null) {
            synchronized (com.anythink.core.common.t.class) {
                if (c == null) {
                    c = new com.anythink.core.common.t();
                }
            }
        }
        return c;
    }

    public final void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.t.AnonymousClass1(i, str, str2, str3, str4), 16, true);
    }

    public final synchronized void b() {
        java.util.List<com.anythink.core.common.f.u> c2;
        int i;
        if (this.a.get() <= 0 && (c2 = com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).c()) != null && c2.size() > 0) {
            this.a.set(c2.size());
            this.a.get();
            for (com.anythink.core.common.f.u uVar : c2) {
                if (java.lang.System.currentTimeMillis() - uVar.f >= 604800000) {
                    this.a.decrementAndGet();
                    com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).b(uVar);
                } else {
                    try {
                        i = new org.json.JSONObject(uVar.g).optInt(com.anythink.core.common.f.u.h);
                    } catch (java.lang.Throwable unused) {
                        i = 1000;
                    }
                    if (uVar.b == 3) {
                        new com.anythink.core.common.h.a.b(uVar.e, i).a(new com.anythink.core.common.t.AnonymousClass2(uVar));
                    } else {
                        com.anythink.core.common.h.n nVar = new com.anythink.core.common.h.n(uVar);
                        if (i == 1001) {
                            nVar.p();
                        }
                        nVar.a(0, (com.anythink.core.common.h.k) new com.anythink.core.common.t.AnonymousClass3(uVar, nVar));
                    }
                }
            }
        }
    }
}
