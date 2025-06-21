package com.alipay.sdk.app;

/* loaded from: classes29.dex */
public final class PayResultActivity extends android.app.Activity {
    public static final java.lang.String b = "{\"isLogin\":\"false\"}";
    public static final java.util.HashMap<java.lang.String, java.lang.Object> c = new java.util.HashMap<>();
    public static final java.lang.String d = "hk.alipay.wallet";
    public static final java.lang.String e = "phonecashier.pay.hash";
    public static final java.lang.String f = "orderSuffix";
    public static final java.lang.String g = "externalPkgName";
    public static final java.lang.String h = "phonecashier.pay.result";
    public static final java.lang.String i = "phonecashier.pay.resultOrderHash";
    public com.alipay.sdk.m.s.a a = null;

    public static class a implements java.lang.Runnable {
        public final /* synthetic */ android.app.Activity a;

        public a(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.finish();
        }
    }

    public static final class b {
        public static volatile java.lang.String a;
        public static volatile java.lang.String b;
    }

    public static void a(android.app.Activity activity, int i2) {
        new android.os.Handler().postDelayed(new com.alipay.sdk.app.PayResultActivity.a(activity), i2);
    }

    public static void a(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        try {
            intent.setPackage(d);
            intent.setData(android.net.Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + java.net.URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + java.net.URLEncoder.encode(str2, "UTF-8") + "&packageName=" + java.net.URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + java.net.URLEncoder.encode(str3, "UTF-8")));
        } catch (java.io.UnsupportedEncodingException e2) {
            com.alipay.sdk.m.u.e.a(e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (java.lang.Throwable unused) {
                activity.finish();
            }
        }
    }

    public static void a(java.lang.String str) {
        com.alipay.sdk.app.PayResultActivity.b.b = com.alipay.sdk.m.j.b.a();
        a(c, str);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        com.alipay.sdk.app.PayResultActivity.b.b = str;
        a(c, str2);
    }

    public static boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str) {
        java.lang.Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            android.content.Intent intent = getIntent();
            if (!android.text.TextUtils.isEmpty(intent.getStringExtra(f))) {
                com.alipay.sdk.app.PayResultActivity.b.a = intent.getStringExtra(e);
                java.lang.String stringExtra = intent.getStringExtra(f);
                java.lang.String stringExtra2 = intent.getStringExtra(g);
                com.alipay.sdk.m.s.a a2 = com.alipay.sdk.m.s.a.C0043a.a(intent);
                this.a = a2;
                if (a2 == null) {
                    finish();
                }
                a(this, com.alipay.sdk.app.PayResultActivity.b.a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.a == null) {
                finish();
            }
            java.lang.String stringExtra3 = intent.getStringExtra(h);
            int intExtra = intent.getIntExtra(i, 0);
            if (intExtra != 0 && android.text.TextUtils.equals(com.alipay.sdk.app.PayResultActivity.b.a, java.lang.String.valueOf(intExtra))) {
                if (android.text.TextUtils.isEmpty(stringExtra3)) {
                    a(com.alipay.sdk.app.PayResultActivity.b.a);
                } else {
                    a(stringExtra3, com.alipay.sdk.app.PayResultActivity.b.a);
                }
                com.alipay.sdk.app.PayResultActivity.b.a = "";
                a(this, 300);
                return;
            }
            com.alipay.sdk.m.k.a.b(this.a, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.l0, "Expected " + com.alipay.sdk.app.PayResultActivity.b.a + ", got " + intExtra);
            a(com.alipay.sdk.app.PayResultActivity.b.a);
            a(this, 300);
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
