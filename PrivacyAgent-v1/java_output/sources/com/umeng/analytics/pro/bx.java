package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bx implements com.umeng.analytics.pro.bw {
    private static final java.lang.String a = "cache_domain";
    private static volatile java.lang.String b = "";

    public static class a {
        public static final com.umeng.analytics.pro.bx a = new com.umeng.analytics.pro.bx(null);

        private a() {
        }
    }

    private bx() {
        d();
    }

    public /* synthetic */ bx(com.umeng.analytics.pro.bx.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.bx b() {
        return com.umeng.analytics.pro.bx.a.a;
    }

    private void d() {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            b = sharedPreferences.getString(a, "");
        }
    }

    private void e() {
        try {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(a, b).commit();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.bw
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bw
    public void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                java.lang.String optString = jSONObject.optString("Answer");
                if (android.text.TextUtils.isEmpty(optString)) {
                    return;
                }
                java.lang.String optString2 = jSONObject.has("ip") ? jSONObject.optString("ip") : "";
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + optString);
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + optString2);
                }
                b = optString;
                e();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.bw
    public void a(java.lang.Throwable th) {
    }

    public java.lang.String c() {
        return b;
    }
}
