package com.anythink.core.common.a;

/* loaded from: classes12.dex */
public class k {
    private static volatile com.anythink.core.common.a.k b;
    private long e;
    final java.lang.String a = com.anythink.core.common.a.k.class.getSimpleName();
    private long f = 0;
    private com.anythink.core.common.c.m c = com.anythink.core.common.c.m.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
    private java.util.Map<java.lang.String, java.lang.Integer> d = new java.util.HashMap();

    /* renamed from: com.anythink.core.common.a.k$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            new java.util.ArrayList();
            com.anythink.core.common.a.k kVar = com.anythink.core.common.a.k.this;
            kVar.f = kVar.c.c();
            long unused = com.anythink.core.common.a.k.this.f;
            long unused2 = com.anythink.core.common.a.k.this.e;
            if (com.anythink.core.common.a.k.this.f > com.anythink.core.common.a.k.this.e) {
                java.util.List<com.anythink.core.common.a.j> d = com.anythink.core.common.a.k.this.c.d();
                d.size();
                for (com.anythink.core.common.a.j jVar : d) {
                    try {
                        java.io.File file = new java.io.File(jVar.b());
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (java.lang.Throwable unused3) {
                    }
                    try {
                        if (!android.text.TextUtils.isEmpty(jVar.a())) {
                            java.lang.String a = jVar.a();
                            com.anythink.core.common.a.k.this.d.remove(a);
                            com.anythink.core.common.res.a.c.a().b(a);
                        }
                    } catch (java.lang.Throwable unused4) {
                    }
                }
            }
        }
    }

    /* renamed from: com.anythink.core.common.a.k$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.a.j a;

        public AnonymousClass2(com.anythink.core.common.a.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.io.File file = new java.io.File(this.a.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (java.lang.Throwable unused) {
            }
            com.anythink.core.common.a.k.this.c.c(this.a.a());
        }
    }

    /* renamed from: com.anythink.core.common.a.k$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ int e;

        public AnonymousClass3(java.lang.String str, java.lang.String str2, long j, long j2, int i) {
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = j2;
            this.e = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.a.k.this.c.a(this.a, this.b, this.c, this.d, this.e);
        }
    }

    private k() {
        this.e = 209715200L;
        this.e = com.anythink.core.common.b.o.a().d(4);
    }

    public static com.anythink.core.common.a.k a() {
        if (b == null) {
            synchronized (com.anythink.core.common.a.k.class) {
                if (b == null) {
                    b = new com.anythink.core.common.a.k();
                }
            }
        }
        return b;
    }

    private void a(com.anythink.core.common.a.j jVar) {
        if (jVar == null) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.k.AnonymousClass2(jVar), 13, true);
    }

    public final com.anythink.core.common.a.j a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.a(str);
    }

    public final void a(java.lang.String str, java.lang.String str2, long j, long j2, int i, boolean z) {
        this.d.put(str, java.lang.Integer.valueOf(i));
        if (z) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.k.AnonymousClass3(str, str2, j, j2, i), 13, true);
        }
    }

    public final synchronized boolean a(java.lang.String str, int i) {
        return b(str) >= i;
    }

    public final synchronized int b(java.lang.String str) {
        if (this.d.containsKey(str) && this.d.get(str) != null) {
            return this.d.get(str).intValue();
        }
        com.anythink.core.common.a.j a = this.c.a(str);
        if (a == null || a.c() <= 0) {
            return 0;
        }
        java.io.File file = new java.io.File(a.b());
        if (!file.exists() || file.length() < a.e()) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.k.AnonymousClass2(a), 13, true);
            return 0;
        }
        this.d.put(str, java.lang.Integer.valueOf(a.c()));
        this.c.b(str);
        return a.c();
    }

    public final void b() {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.k.AnonymousClass1(), 13);
    }

    public final long c() {
        return this.e;
    }

    public final long d() {
        return this.f;
    }
}
