package com.alipay.sdk.app;

/* loaded from: classes29.dex */
public class AlipayResultActivity extends android.app.Activity {
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.sdk.app.AlipayResultActivity.a> a = new java.util.concurrent.ConcurrentHashMap<>();

    public interface a {
        void a(int i, java.lang.String str, java.lang.String str2);
    }

    private void a(java.lang.String str, android.os.Bundle bundle) {
        com.alipay.sdk.app.AlipayResultActivity.a remove = a.remove(str);
        if (remove == null) {
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(com.alipay.sdk.m.u.l.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        java.lang.Throwable th;
        super.onCreate(bundle);
        try {
            android.content.Intent intent = getIntent();
            try {
                java.lang.String stringExtra = intent.getStringExtra(com.umeng.analytics.pro.f.aC);
                android.os.Bundle bundleExtra = intent.getBundleExtra("result");
                java.lang.String stringExtra2 = intent.getStringExtra(com.umeng.ccg.a.j);
                com.alipay.sdk.m.s.a a2 = com.alipay.sdk.m.s.a.C0043a.a(stringExtra);
                if (a2 == null) {
                    finish();
                    return;
                }
                com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, "BSPSession", stringExtra + "|" + android.os.SystemClock.elapsedRealtime());
                if (android.text.TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((android.text.TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        stringExtra = jSONObject.getString(com.umeng.analytics.pro.f.aC);
                        com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, "BSPUriSession", stringExtra);
                        android.os.Bundle bundle2 = new android.os.Bundle();
                        try {
                            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                java.lang.String next = keys.next();
                                bundle2.putString(next, jSONObject2.getString(next));
                            }
                            bundleExtra = bundle2;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            bundleExtra = bundle2;
                            com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, "BSPResEx", th);
                            com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.s0, th);
                            if (android.text.TextUtils.isEmpty(stringExtra)) {
                            }
                            com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                            finish();
                            return;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                    }
                }
                if (!android.text.TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                    finish();
                    return;
                }
                try {
                    com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + android.os.SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(com.alipay.sdk.m.u.l.b, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                    com.alipay.sdk.app.OpenAuthTask.a(stringExtra, 9000, com.baidu.mobads.sdk.internal.bz.k, bundleExtra);
                    com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                    finish();
                } catch (java.lang.Throwable th4) {
                    com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                    finish();
                    throw th4;
                }
            } catch (java.lang.Throwable th5) {
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) null, com.alipay.sdk.m.k.b.l, "BSPSerError", th5);
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) null, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.r0, th5);
                finish();
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
