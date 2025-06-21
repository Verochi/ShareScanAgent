package com.umeng.commonsdk.internal.crash;

/* loaded from: classes19.dex */
public class UMCrashManager {
    private static final java.lang.String CM_VERSION = "2.0";
    private static boolean isReportCrash;
    private static java.lang.Object mObject = new java.lang.Object();

    public static void buildEnvelope(android.content.Context context, java.lang.Object obj) {
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> UMCrashManager.buildEnvelope enter.");
        try {
            synchronized (mObject) {
                if (context == null || obj == null) {
                    return;
                }
                java.lang.String str = (java.lang.String) obj;
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String str2 = context.getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.f;
                    java.io.File file = new java.io.File(str2);
                    if (!file.isDirectory()) {
                        file.mkdir();
                    }
                    com.umeng.commonsdk.stateless.d.a(context, str2, "c", 10);
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put(com.umeng.analytics.pro.bo.aU, "2.0");
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        jSONObject2.put("content", str);
                        jSONObject2.put("ts", java.lang.System.currentTimeMillis());
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        jSONObject3.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EVENT_ID_CRASH, jSONObject2);
                        org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                        jSONObject4.put("tp", jSONObject3);
                        com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject4, com.umeng.commonsdk.statistics.UMServerURL.PATH_INNER_CRASH, "c", "2.0");
                    } catch (org.json.JSONException unused) {
                    }
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static void reportCrash(android.content.Context context, java.lang.Throwable th) {
        synchronized (mObject) {
            if (!isReportCrash) {
                isReportCrash = true;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.u, com.umeng.commonsdk.internal.b.a(context).a(), com.umeng.commonsdk.internal.crash.a.a(th));
            }
        }
    }
}
