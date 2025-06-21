package com.sensorsdata.analytics.android.sdk.core.business.instantevent;

/* loaded from: classes19.dex */
public class InstantEventUtils {
    private static boolean instanceEventType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK.getEventType()) || str.equals(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP.getEventType()) || str.equals(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_BIND.getEventType()) || str.equals(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND.getEventType());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r2.contains(r6) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if (r2 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        r1 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int isInstantEvent(org.json.JSONObject jSONObject) {
        int i = 0;
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (jSONObject.optBoolean("_hybrid_h5", false)) {
            boolean optBoolean = jSONObject.optBoolean(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT, false);
            java.lang.String optString = jSONObject.optString("type", "");
            jSONObject.remove(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT);
            if (instanceEventType(optString)) {
            }
            return i;
        }
        java.lang.String optString2 = jSONObject.optString("type", "");
        java.lang.String optString3 = jSONObject.optString("event", "");
        java.util.List instantEvents = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getInstantEvents();
        if (instanceEventType(optString2)) {
            if (!android.text.TextUtils.isEmpty(optString3)) {
                if (instantEvents != null) {
                }
            }
        }
        return i;
        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        return i;
    }

    public static boolean isInstantEvent(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        if (inputData == null) {
            return false;
        }
        try {
            if (android.text.TextUtils.isEmpty(inputData.getExtras())) {
                java.util.List instantEvents = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getInstantEvents();
                if (inputData.getEventType() == null) {
                    return false;
                }
                if (inputData.getEventType().isTrack() && !android.text.TextUtils.isEmpty(inputData.getEventName()) && instantEvents != null && instantEvents.contains(inputData.getEventName())) {
                    return true;
                }
            } else {
                org.json.JSONObject jSONObject = new org.json.JSONObject(inputData.getExtras());
                java.lang.String optString = jSONObject.optString("type", "");
                boolean optBoolean = jSONObject.optBoolean(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT, false);
                if (instanceEventType(optString) && optBoolean) {
                    return true;
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return false;
    }
}
