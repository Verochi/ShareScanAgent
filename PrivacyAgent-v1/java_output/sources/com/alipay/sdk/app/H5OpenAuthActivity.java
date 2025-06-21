package com.alipay.sdk.app;

/* loaded from: classes29.dex */
public class H5OpenAuthActivity extends com.alipay.sdk.app.H5PayActivity {
    public boolean i = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.i) {
            try {
                com.alipay.sdk.m.s.a a = com.alipay.sdk.m.s.a.C0043a.a(getIntent());
                if (a != null) {
                    com.alipay.sdk.m.k.a.b(this, a, "", a.d);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        try {
            com.alipay.sdk.m.s.a a = com.alipay.sdk.m.s.a.C0043a.a(intent);
            try {
                super.startActivity(intent);
                android.net.Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (java.lang.Throwable th) {
                java.lang.String uri = (intent == null || intent.getData() == null) ? com.igexin.push.core.b.m : intent.getData().toString();
                if (a != null) {
                    com.alipay.sdk.m.k.a.a(a, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.p0, th, uri);
                }
                this.i = true;
                throw th;
            }
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }
}
