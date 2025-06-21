package com.alipay.sdk.app;

/* loaded from: classes29.dex */
public class APayEntranceActivity extends android.app.Activity {
    public static final java.lang.String d = "ap_order_info";
    public static final java.lang.String e = "ap_target_packagename";
    public static final java.lang.String f = "ap_session";
    public static final java.lang.String g = "ap_local_info";
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.sdk.app.APayEntranceActivity.a> h = new java.util.concurrent.ConcurrentHashMap<>();
    public java.lang.String a;
    public java.lang.String b;
    public com.alipay.sdk.m.s.a c;

    public interface a {
        void a(java.lang.String str);
    }

    @Override // android.app.Activity
    public void finish() {
        java.lang.String str = this.b;
        com.alipay.sdk.m.k.a.a(this.c, com.alipay.sdk.m.k.b.l, "BSAFinish", str + "|" + android.text.TextUtils.isEmpty(this.a));
        if (android.text.TextUtils.isEmpty(this.a)) {
            this.a = com.alipay.sdk.m.j.b.a();
            com.alipay.sdk.m.s.a aVar = this.c;
            if (aVar != null) {
                aVar.b(true);
            }
        }
        if (str != null) {
            com.alipay.sdk.app.APayEntranceActivity.a remove = h.remove(str);
            if (remove != null) {
                remove.a(this.a);
            } else {
                com.alipay.sdk.m.k.a.b(this.c, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(this.c, "wr", "APStartFinish", th);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.alipay.sdk.m.k.a.a(this.c, com.alipay.sdk.m.k.b.l, "BSAOnAR", this.b + "|" + i + "," + i2);
        if (i == 1000) {
            if (intent != null) {
                try {
                    this.a = intent.getStringExtra("result");
                } catch (java.lang.Throwable unused) {
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            android.os.Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            java.lang.String string = extras.getString(d);
            java.lang.String string2 = extras.getString(e);
            this.b = extras.getString(f);
            java.lang.String string3 = extras.getString(g, "{}");
            if (!android.text.TextUtils.isEmpty(this.b)) {
                com.alipay.sdk.m.s.a a2 = com.alipay.sdk.m.s.a.C0043a.a(this.b);
                this.c = a2;
                com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, "BSAEntryCreate", this.b + "|" + android.os.SystemClock.elapsedRealtime());
            }
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.k.a.a(this.c, "wr", "APStartEx", th);
                finish();
            }
            if (this.c != null) {
                android.content.Context applicationContext = getApplicationContext();
                com.alipay.sdk.m.s.a aVar = this.c;
                com.alipay.sdk.m.k.a.a(applicationContext, aVar, string, aVar.d);
                this.c.a(true);
            }
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
