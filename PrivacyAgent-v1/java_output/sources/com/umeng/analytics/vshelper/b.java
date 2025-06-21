package com.umeng.analytics.vshelper;

/* loaded from: classes19.dex */
public class b implements com.umeng.analytics.pro.by {
    private static final java.lang.String a = "RealTimeDebugSwitch";
    private static volatile int b;

    public static boolean d() {
        return b > 0;
    }

    @Override // com.umeng.analytics.pro.by
    public void a() {
    }

    @Override // com.umeng.analytics.pro.by
    public void a(android.app.Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    @Override // com.umeng.analytics.pro.by
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(android.app.Activity activity, android.os.Bundle bundle) {
        long longValue;
        if (b != 0) {
            return;
        }
        android.content.Intent intent = activity.getIntent();
        if (intent == null) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> intent: " + intent);
            return;
        }
        android.net.Uri data = intent.getData();
        if (data == null) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> uri: " + data);
            return;
        }
        java.lang.String scheme = data.getScheme();
        if (scheme == null || !scheme.startsWith("um.")) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> scheme: " + scheme);
            return;
        }
        java.lang.String queryParameter = data.getQueryParameter("debugkey");
        java.lang.String queryParameter2 = data.getQueryParameter(com.umeng.analytics.AnalyticsConfig.DEBUG_MODE_PERIOD);
        if (android.text.TextUtils.isEmpty(queryParameter)) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(queryParameter2)) {
            try {
                longValue = java.lang.Long.valueOf(queryParameter2).longValue();
            } catch (java.lang.Throwable unused) {
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("debugkey", queryParameter);
            if (longValue >= 0) {
                if (!com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Not currently in RealTimeDebug mode and doing nothing.");
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> call turnOffRealTimeDebug because sendaging < 0");
                com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug();
                android.content.Context applicationContext = activity.getApplicationContext();
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext, com.umeng.analytics.pro.q.a.G, com.umeng.analytics.CoreProtocol.getInstance(applicationContext), null);
                return;
            }
            if (longValue <= 0) {
                com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                android.content.Context applicationContext2 = activity.getApplicationContext();
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext2, com.umeng.analytics.pro.q.a.G, com.umeng.analytics.CoreProtocol.getInstance(applicationContext2), null);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[non-persistent] dk: " + queryParameter);
                return;
            }
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(hashMap);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.System.currentTimeMillis());
                if (longValue < 60) {
                    longValue = 60;
                }
                if (longValue > 240) {
                    longValue = 240;
                }
                jSONObject.put(com.umeng.analytics.AnalyticsConfig.RTD_PERIOD, longValue);
                jSONObject.put("debugkey", queryParameter);
            } catch (java.lang.Throwable unused2) {
            }
            android.content.Context applicationContext3 = activity.getApplicationContext();
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(applicationContext3, com.umeng.analytics.pro.q.a.F, com.umeng.analytics.CoreProtocol.getInstance(applicationContext3), jSONObject);
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[persistent] dk: " + queryParameter + "; period: " + longValue);
            return;
        }
        longValue = 0;
        java.util.HashMap hashMap2 = new java.util.HashMap();
        hashMap2.put("debugkey", queryParameter);
        if (longValue >= 0) {
        }
    }

    @Override // com.umeng.analytics.pro.by
    public void b() {
    }

    @Override // com.umeng.analytics.pro.by
    public void b(android.app.Activity activity) {
    }

    @Override // com.umeng.analytics.pro.by
    public void b(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.by
    public void c() {
    }

    @Override // com.umeng.analytics.pro.by
    public void c(android.app.Activity activity) {
        b++;
    }

    @Override // com.umeng.analytics.pro.by
    public void d(android.app.Activity activity) {
        b--;
    }

    @Override // com.umeng.analytics.pro.by
    public void e(android.app.Activity activity) {
    }
}
