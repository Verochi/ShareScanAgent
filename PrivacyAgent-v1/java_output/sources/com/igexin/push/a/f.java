package com.igexin.push.a;

/* loaded from: classes.dex */
public final class f extends com.igexin.push.a.b {
    private java.lang.String a = "NotiClickAct";

    @Override // com.igexin.push.a.b
    public final void a(android.app.Activity activity) {
    }

    @Override // com.igexin.push.a.b
    public final boolean a() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void b(android.app.Activity activity) {
        try {
            android.content.Context applicationContext = activity.getApplicationContext();
            com.igexin.push.core.a.b.d();
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.igexin.push.core.a.b.a(applicationContext));
            android.content.Intent intent2 = activity.getIntent();
            if (intent2 != null && intent2.hasExtra("action") && intent2.hasExtra("broadcast_intent")) {
                intent.putExtra("action", intent2.getStringExtra("action"));
                intent.putExtra("broadcast_intent", (android.content.Intent) intent2.getParcelableExtra("broadcast_intent"));
            }
            com.igexin.push.core.ServiceManager.getInstance().b(applicationContext, intent);
            com.igexin.c.a.c.a.a(this.a + "|GetuiActivity create " + intent.toString(), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(this.a + "|put GetuiActivity exception" + th.toString(), new java.lang.Object[0]);
        }
        activity.finish();
    }

    @Override // com.igexin.push.a.b
    public final boolean b() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void c() {
    }

    @Override // com.igexin.push.a.b
    public final void d() {
    }

    @Override // com.igexin.push.a.b
    public final void e() {
    }

    @Override // com.igexin.push.a.b
    public final void f() {
    }

    @Override // com.igexin.push.a.b
    public final void g() {
    }

    @Override // com.igexin.push.a.b
    public final void h() {
    }

    @Override // com.igexin.push.a.b
    public final void i() {
    }

    @Override // com.igexin.push.a.b
    public final void j() {
    }

    @Override // com.igexin.push.a.b
    public final void k() {
    }
}
