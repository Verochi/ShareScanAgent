package com.anythink.core.common.a;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.core.common.a.a b;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.r> a;
    private com.anythink.core.common.c.k c;

    /* renamed from: com.anythink.core.common.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.q a;

        public AnonymousClass1(com.anythink.core.common.f.q qVar) {
            this.a = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.common.a.a.this.c == null) {
                com.anythink.core.common.a.a.this.c = com.anythink.core.common.c.k.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
            }
            com.anythink.core.common.a.a.this.c.a(this.a);
        }
    }

    /* renamed from: com.anythink.core.common.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.common.a.a.this.c == null) {
                com.anythink.core.common.a.a.this.c = com.anythink.core.common.c.k.a(com.anythink.core.common.c.c.a(this.a.getApplicationContext()));
            }
            com.anythink.core.common.a.a.this.c.a(this.b);
        }
    }

    private a() {
        if (com.anythink.core.common.b.o.a().f() != null) {
            this.c = com.anythink.core.common.c.k.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
        }
        this.a = new java.util.concurrent.ConcurrentHashMap<>(3);
    }

    public static com.anythink.core.common.a.a a() {
        if (b == null) {
            synchronized (com.anythink.core.common.a.a.class) {
                if (b == null) {
                    b = new com.anythink.core.common.a.a();
                }
            }
        }
        return b;
    }

    private static void b(com.anythink.core.common.f.q qVar) {
        if (android.text.TextUtils.isEmpty(qVar.i)) {
            return;
        }
        try {
            com.anythink.core.common.f.j a = com.anythink.core.common.a.d.a(qVar.token, new org.json.JSONObject(qVar.i), qVar.d);
            if (a == null) {
                qVar.i = "";
                return;
            }
            a.c(qVar.f);
            if (qVar.d == 67) {
                com.anythink.core.common.d.c.a(com.anythink.core.common.b.o.a().f()).a(a.s(), a.V());
                com.anythink.core.common.d.b.a(com.anythink.core.common.b.o.a().f()).a(a.t(), a.V());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.C, str + com.anythink.core.common.b.h.u.p, 1);
    }

    private static boolean d(android.content.Context context, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(com.anythink.core.common.b.h.u.p);
        return com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.C, sb.toString(), 0) == 1;
    }

    public final com.anythink.core.common.f.ag a(android.content.Context context, java.lang.String str) {
        if (this.c == null) {
            this.c = com.anythink.core.common.c.k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
        }
        return this.c.c(str);
    }

    public final com.anythink.core.common.f.q a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.r rVar = this.a.get(str);
        if (rVar == null) {
            rVar = this.c.b(str);
            this.a.put(str, rVar);
        }
        return rVar.a(str2);
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.c == null) {
            this.c = com.anythink.core.common.c.k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
        }
        this.c.a(str, str2, str3);
    }

    public final void a(com.anythink.core.common.f.q qVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.a.AnonymousClass1(qVar), 2, true);
    }

    public final void a(java.lang.String str, com.anythink.core.common.f.q qVar) {
        if (this.c == null) {
            this.c = com.anythink.core.common.c.k.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
        }
        if (!android.text.TextUtils.isEmpty(qVar.i)) {
            try {
                com.anythink.core.common.f.j a = com.anythink.core.common.a.d.a(qVar.token, new org.json.JSONObject(qVar.i), qVar.d);
                if (a == null) {
                    qVar.i = "";
                } else {
                    a.c(qVar.f);
                    if (qVar.d == 67) {
                        com.anythink.core.common.d.c.a(com.anythink.core.common.b.o.a().f()).a(a.s(), a.V());
                        com.anythink.core.common.d.b.a(com.anythink.core.common.b.o.a().f()).a(a.t(), a.V());
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        this.c.a(str, qVar);
    }

    public final void b(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.a.a.AnonymousClass2(context, str), 2, true);
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.C, str + com.anythink.core.common.b.h.u.p);
    }
}
