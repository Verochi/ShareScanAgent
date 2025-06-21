package com.anythink.expressad.foundation.b;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String g = "SDKController";
    private static volatile com.anythink.expressad.foundation.b.b h;
    private android.content.Context i;
    private java.lang.String m;
    private int n;
    private java.lang.String j = "";
    private java.lang.String k = "";
    private boolean l = false;
    public final int a = 1;
    public final int b = 2;
    public final int c = 3;
    public final int d = 4;
    public final int e = 5;
    public final int f = 6;

    /* renamed from: com.anythink.expressad.foundation.b.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.foundation.h.k.i(this.a);
        }
    }

    private b() {
    }

    public static com.anythink.expressad.foundation.b.b a() {
        if (h == null) {
            synchronized (com.anythink.expressad.foundation.b.b.class) {
                if (h == null) {
                    h = new com.anythink.expressad.foundation.b.b();
                }
            }
        }
        return h;
    }

    private static void a(android.content.Context context) {
        java.lang.String str;
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.anythink.core.common.b.h.A, 0);
            java.lang.String str2 = "";
            if (sharedPreferences != null) {
                java.lang.String string = sharedPreferences.getString(com.anythink.core.common.b.h.u.n, "");
                str = sharedPreferences.getString(com.anythink.core.common.b.h.u.o, "");
                str2 = string;
            } else {
                str = "";
            }
            if (android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.g.a.co) && android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.g.a.cp)) {
                com.anythink.expressad.foundation.g.a.co = str2;
                com.anythink.expressad.foundation.g.a.cp = str;
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private static java.lang.String b() {
        return com.anythink.expressad.out.b.a;
    }

    private void c() {
        com.anythink.expressad.foundation.b.a.b().a(this.j);
        com.anythink.expressad.foundation.b.a.b().b(this.k);
        com.anythink.expressad.foundation.b.a.b().c();
        a(this.i.getApplicationContext());
        com.anythink.expressad.foundation.h.r.a(this.i);
        this.l = true;
    }

    private static void d() {
    }

    private void e() {
        com.anythink.expressad.foundation.b.a.b().a(this.j);
        com.anythink.expressad.foundation.b.a.b().b(this.k);
        com.anythink.expressad.foundation.b.a.b().c();
    }

    public final void a(java.util.Map map, android.content.Context context) {
        if (context != null) {
            this.i = context.getApplicationContext();
            com.anythink.expressad.foundation.b.a.b().a(this.i);
            try {
                com.anythink.expressad.foundation.g.f.m.a(this.i);
            } catch (java.lang.Exception unused) {
            }
            com.anythink.core.common.b.o.a().a(new com.anythink.expressad.foundation.b.b.AnonymousClass1(context), 300L);
            if (map != null) {
                if (map.containsKey(com.anythink.expressad.a.d)) {
                    this.j = (java.lang.String) map.get(com.anythink.expressad.a.d);
                }
                if (map.containsKey(com.anythink.expressad.a.e)) {
                    this.k = (java.lang.String) map.get(com.anythink.expressad.a.e);
                }
                com.anythink.expressad.foundation.b.a.b().a(this.j);
                com.anythink.expressad.foundation.b.a.b().b(this.k);
                com.anythink.expressad.foundation.b.a.b().c();
                a(this.i.getApplicationContext());
                com.anythink.expressad.foundation.h.r.a(this.i);
                this.l = true;
            }
        }
    }
}
