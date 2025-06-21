package com.sensorsdata.analytics.android.sdk.core.business;

/* loaded from: classes19.dex */
public class SAPluginVersion {
    private static final java.lang.String TAG = "SA.SAPluginVersion";
    private static boolean isTrackEventWithPluginVersion;

    public static void appendPluginVersion(org.json.JSONObject jSONObject) {
        if (isTrackEventWithPluginVersion || jSONObject.has("$lib_plugin_version")) {
            return;
        }
        org.json.JSONArray pluginVersion = getPluginVersion();
        if (pluginVersion == null) {
            isTrackEventWithPluginVersion = true;
            return;
        }
        try {
            jSONObject.put("$lib_plugin_version", pluginVersion);
            isTrackEventWithPluginVersion = true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static org.json.JSONArray getPluginVersion() {
        try {
            if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.ANDROID_PLUGIN_VERSION)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "android plugin version: " + com.sensorsdata.analytics.android.sdk.SensorsDataAPI.ANDROID_PLUGIN_VERSION);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put("android:" + com.sensorsdata.analytics.android.sdk.SensorsDataAPI.ANDROID_PLUGIN_VERSION);
            return jSONArray;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }
}
