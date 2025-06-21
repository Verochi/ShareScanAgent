package com.umeng.commonsdk.vchannel;

/* loaded from: classes19.dex */
public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final java.lang.String VCHANNEL_VERSION = "1.0.0";
    private static java.util.Map<java.lang.String, java.lang.String> customHeader;
    private static long lastTriggerTime;

    public static void handleEvent(android.content.Context context, com.umeng.commonsdk.vchannel.b bVar) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.bo.aV, "1.0.0");
                java.util.Map<java.lang.String, java.lang.String> map = customHeader;
                if (map != null && map.size() > 0) {
                    for (java.lang.String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("analytics", bVar.d());
            com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, com.umeng.commonsdk.vchannel.a.c, "v", "1.0.0");
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static void onEvent(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
            return;
        }
        if (map == null) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
            return;
        }
        if (!com.umeng.commonsdk.framework.UMFrUtils.isOnline(context)) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
            return;
        }
        if (java.lang.System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
            return;
        }
        com.umeng.commonsdk.vchannel.b bVar = new com.umeng.commonsdk.vchannel.b(context);
        bVar.a(str);
        bVar.a(java.lang.System.currentTimeMillis());
        bVar.a(map);
        try {
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 32779, com.umeng.commonsdk.internal.b.a(context).a(), bVar);
        } catch (java.lang.Throwable unused) {
        }
        lastTriggerTime = java.lang.System.currentTimeMillis();
    }

    public static void setCustomHeader(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
