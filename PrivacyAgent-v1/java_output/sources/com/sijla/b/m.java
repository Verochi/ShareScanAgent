package com.sijla.b;

/* loaded from: classes19.dex */
public final class m implements com.sijla.b.u.b {
    private static java.lang.String i;
    private android.app.Application a;
    private com.sijla.b.u g;
    private boolean j;
    private java.util.HashMap<java.lang.String, java.lang.String> c = new java.util.HashMap<>();
    private java.util.ArrayList<java.lang.Object> d = new java.util.ArrayList<>();
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.util.List<com.sijla.e.c> h = new java.util.ArrayList();
    private java.lang.StringBuilder k = new java.lang.StringBuilder();
    private boolean b = true;

    static {
        new java.util.ArrayList();
    }

    public m(android.app.Application application) {
        this.a = application;
    }

    public static /* synthetic */ boolean a(boolean z) {
        return z;
    }

    public static void b() {
    }

    public final void a() {
        java.lang.String c = com.sijla.h.a.a.c();
        if (i != null) {
            return;
        }
        i = c;
        com.sijla.b.u uVar = new com.sijla.b.u(this.a);
        this.g = uVar;
        uVar.a(this);
        com.sijla.a.a.a(new com.sijla.b.n(this, c));
    }

    public final void a(long j) {
        com.sijla.b.g.a(this.a, "AppPause");
        com.sijla.a.a.a(new com.sijla.b.p(this, j));
    }

    public final void c() {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(com.sijla.h.a.a.c(this.a));
        intentFilter.addAction(com.sijla.h.a.a.b(this.a));
        try {
            com.sijla.f.a.a(this.a).a(new com.sijla.b.q(this), intentFilter);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.sijla.b.u.b
    public final void d() {
        com.sijla.a.a.a(new com.sijla.b.s(this));
    }

    @Override // com.sijla.b.u.b
    public final void e() {
        this.j = false;
        com.sijla.a.a.a(new com.sijla.b.t(this));
    }

    public final void f() {
        com.sijla.b.g.a(this.a, "AppResume");
        com.sijla.a.a.a(new com.sijla.b.o(this));
    }
}
