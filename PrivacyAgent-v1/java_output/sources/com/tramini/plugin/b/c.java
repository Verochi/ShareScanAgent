package com.tramini.plugin.b;

/* loaded from: classes19.dex */
public class c {
    public static final java.lang.String a = "c";
    private static volatile com.tramini.plugin.b.c b;
    private static com.tramini.plugin.b.b c;
    private android.content.Context d;
    private long f = -1;
    private boolean e = false;

    /* renamed from: com.tramini.plugin.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tramini.plugin.a.e.b {
        final /* synthetic */ com.tramini.plugin.a.e.c a;

        public AnonymousClass1(com.tramini.plugin.a.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.tramini.plugin.a.e.b
        public final void a() {
            com.tramini.plugin.b.c.this.e = true;
        }

        @Override // com.tramini.plugin.a.e.b
        public final void a(java.lang.Object obj) {
            com.tramini.plugin.b.c.this.e = false;
            if (obj != null) {
                java.lang.String obj2 = obj.toString();
                com.tramini.plugin.b.b b = com.tramini.plugin.b.c.this.b();
                if (b != null) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(com.tramini.plugin.a.h.c.a(obj2));
                        b.a(jSONObject);
                        obj2 = com.tramini.plugin.a.h.c.b(jSONObject.toString());
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.tramini.plugin.a.h.i.a(com.tramini.plugin.b.c.this.d, "tramini", com.tramini.plugin.a.b.a.d.a, obj2);
                com.tramini.plugin.b.c.this.f = java.lang.System.currentTimeMillis();
                android.content.Context context = com.tramini.plugin.b.c.this.d;
                long j = com.tramini.plugin.b.c.this.f;
                if (context != null) {
                    try {
                        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("tramini", 0).edit();
                        edit.putLong(com.tramini.plugin.a.b.a.d.b, j);
                        edit.apply();
                    } catch (java.lang.Error | java.lang.Exception unused2) {
                    }
                }
                com.tramini.plugin.b.b a = com.tramini.plugin.b.b.a(com.tramini.plugin.a.h.c.a(obj2));
                if (a != null) {
                    com.tramini.plugin.b.b unused3 = com.tramini.plugin.b.c.c = a;
                    com.tramini.plugin.a.g.a.a().a(com.tramini.plugin.a.h.g.a(a), a.c());
                    com.tramini.plugin.a.b.c.a().a(a);
                    com.tramini.plugin.a.e.c cVar = this.a;
                    if (cVar != null) {
                        cVar.a(a);
                    }
                }
            }
        }

        @Override // com.tramini.plugin.a.e.b
        public final void b() {
            com.tramini.plugin.b.c.this.e = false;
        }
    }

    private c(android.content.Context context) {
        this.d = context;
    }

    public static com.tramini.plugin.b.c a(android.content.Context context) {
        if (b == null) {
            synchronized (com.tramini.plugin.b.c.class) {
                if (b == null) {
                    b = new com.tramini.plugin.b.c(context);
                }
            }
        }
        return b;
    }

    private void a(com.tramini.plugin.a.e.b bVar) {
        if (this.e || android.text.TextUtils.isEmpty(com.tramini.plugin.a.h.c.a)) {
            return;
        }
        new com.tramini.plugin.a.e.d().a(0, bVar);
    }

    public static com.tramini.plugin.b.b b(android.content.Context context) {
        java.lang.String b2 = com.tramini.plugin.a.h.i.b(context, "tramini", com.tramini.plugin.a.b.a.d.a, "");
        if (android.text.TextUtils.isEmpty(b2)) {
            return null;
        }
        return com.tramini.plugin.b.b.a(com.tramini.plugin.a.h.c.a(b2));
    }

    public final void a(com.tramini.plugin.a.e.c cVar) {
        com.tramini.plugin.b.c.AnonymousClass1 anonymousClass1 = new com.tramini.plugin.b.c.AnonymousClass1(cVar);
        if (this.e || android.text.TextUtils.isEmpty(com.tramini.plugin.a.h.c.a)) {
            return;
        }
        new com.tramini.plugin.a.e.d().a(0, anonymousClass1);
    }

    public final boolean a() {
        if (this.f <= 0) {
            this.f = com.tramini.plugin.a.h.i.a(this.d, "tramini", com.tramini.plugin.a.b.a.d.b, (java.lang.Long) 0L).longValue();
        }
        com.tramini.plugin.b.b b2 = b();
        if (b2 != null) {
            return this.f + b2.d() <= java.lang.System.currentTimeMillis();
        }
        return true;
    }

    public final synchronized com.tramini.plugin.b.b b() {
        if (c == null) {
            try {
                if (this.d == null) {
                    this.d = com.tramini.plugin.a.b.c.a().b();
                }
                c = b(this.d);
            } catch (java.lang.Exception unused) {
            }
            com.tramini.plugin.a.b.c.a().a(c);
        }
        return c;
    }
}
