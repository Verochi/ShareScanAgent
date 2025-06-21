package com.alipay.sdk.app;

/* loaded from: classes29.dex */
public class H5PayActivity extends android.app.Activity {
    public com.alipay.sdk.m.x.c a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public boolean f;
    public java.lang.String g;
    public java.lang.ref.WeakReference<com.alipay.sdk.m.s.a> h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
    }

    public void a() {
        java.lang.Object obj = com.alipay.sdk.app.PayTask.h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            com.alipay.sdk.m.j.d.a((com.alipay.sdk.m.s.a) com.alipay.sdk.m.u.n.a(this.h), i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.m.x.c cVar = this.a;
        if (cVar == null) {
            finish();
            return;
        }
        if (cVar.a()) {
            cVar.b();
            return;
        }
        if (!cVar.b()) {
            super.onBackPressed();
        }
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            com.alipay.sdk.m.s.a a = com.alipay.sdk.m.s.a.C0043a.a(getIntent());
            if (a == null) {
                finish();
                return;
            }
            this.h = new java.lang.ref.WeakReference<>(a);
            if (com.alipay.sdk.m.m.a.D().y()) {
                setRequestedOrientation(3);
            } else {
                setRequestedOrientation(1);
            }
            try {
                android.os.Bundle extras = getIntent().getExtras();
                java.lang.String string = extras.getString("url", null);
                this.b = string;
                if (!com.alipay.sdk.m.u.n.f(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString("cookie", null);
                this.c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", com.alipay.sdk.m.x.c.c);
                this.f = extras.getBoolean("backisexit", false);
                try {
                    com.alipay.sdk.m.x.d dVar = new com.alipay.sdk.m.x.d(this, a, this.g);
                    setContentView(dVar);
                    dVar.a(this.e, this.c, this.f);
                    dVar.a(this.b, this.d);
                    dVar.a(this.b);
                    this.a = dVar;
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.k.a.a(a, com.alipay.sdk.m.k.b.l, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (java.lang.Exception unused) {
                finish();
            }
        } catch (java.lang.Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.alipay.sdk.m.x.c cVar = this.a;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (java.lang.Throwable th) {
            try {
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) com.alipay.sdk.m.u.n.a(this.h), com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th);
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
