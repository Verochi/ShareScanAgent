package com.sensorsdata.sf.ui.track;

/* loaded from: classes19.dex */
public class SFTrackHelper {
    private static final java.lang.String CHANNEL_CATEGORY = "POPUP";
    private static final java.lang.String CHANNEL_SERVICE_NAME = "SENSORS_FOCUS";
    private static final java.lang.String EVENT_CLICK = "$PlanPopupClick";
    private static final java.lang.String EVENT_DISPLAY = "$PlanPopupDisplay";
    private static final java.lang.String MSG_ACTION_ID = "id";
    private static final java.lang.String MSG_TYPE = "type";
    private static final java.lang.String PLAN_SECTION_TYPE = "新资源位";
    private static final java.lang.String PLAN_TYPE = "运营计划";
    private static final java.lang.String PLATFORM_TAG = "ANDROID";
    private static final java.lang.String SF_AUDIENCE_ID = "$sf_audience_id";
    private static final java.lang.String SF_CHANNEL_CATEGORY = "$sf_channel_category";
    private static final java.lang.String SF_CHANNEL_SERVICE_NAME = "$sf_channel_service_name";
    private static final java.lang.String SF_CLOSE_TYPE = "$sf_close_type";
    private static final java.lang.String SF_FAIL_REASON = "$sf_fail_reason";
    private static final java.lang.String SF_LIB_VERSION = "$sf_lib_version";
    private static final java.lang.String SF_MSG_ACTION_ID = "$sf_msg_action_id";
    private static final java.lang.String SF_MSG_CONTENT = "$sf_msg_content";
    private static final java.lang.String SF_MSG_ELEMENT_ACTION = "$sf_msg_element_action";
    private static final java.lang.String SF_MSG_ELEMENT_CONTENT = "$sf_msg_element_content";
    private static final java.lang.String SF_MSG_ELEMENT_TYPE = "$sf_msg_element_type";
    private static final java.lang.String SF_MSG_ID = "$sf_msg_id";
    private static final java.lang.String SF_MSG_IMAGE_URL = "$sf_msg_image_url";
    private static final java.lang.String SF_MSG_TITLE = "$sf_msg_title";
    private static final java.lang.String SF_PLAN_ID = "$sf_plan_id";
    private static final java.lang.String SF_PLAN_STRATEGY_ID = "$sf_plan_strategy_id";
    private static final java.lang.String SF_PLAN_TYPE = "$sf_plan_type";
    private static final java.lang.String SF_PLATFORM_TAG = "$sf_platform_tag";
    private static final java.lang.String SF_SECTION_ID = "$sf_section_id";
    private static final java.lang.String SF_SUCCEED = "$sf_succeed";
    private static final java.lang.String TAG = "SFTrackHelper";
    public static java.util.Date sDisplayEventTime;

    /* JADX WARN: Removed duplicated region for block: B:24:0x007b A[Catch: Exception -> 0x00b4, TryCatch #0 {Exception -> 0x00b4, blocks: (B:3:0x0003, B:5:0x000a, B:7:0x0024, B:8:0x003a, B:11:0x0044, B:14:0x004d, B:16:0x0051, B:18:0x0058, B:21:0x0065, B:22:0x0074, B:24:0x007b, B:25:0x007f, B:28:0x0087, B:29:0x0097, B:33:0x0092, B:35:0x006c), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087 A[Catch: Exception -> 0x00b4, TRY_ENTER, TryCatch #0 {Exception -> 0x00b4, blocks: (B:3:0x0003, B:5:0x000a, B:7:0x0024, B:8:0x003a, B:11:0x0044, B:14:0x004d, B:16:0x0051, B:18:0x0058, B:21:0x0065, B:22:0x0074, B:24:0x007b, B:25:0x007f, B:28:0x0087, B:29:0x0097, B:33:0x0092, B:35:0x006c), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092 A[Catch: Exception -> 0x00b4, TryCatch #0 {Exception -> 0x00b4, blocks: (B:3:0x0003, B:5:0x000a, B:7:0x0024, B:8:0x003a, B:11:0x0044, B:14:0x004d, B:16:0x0051, B:18:0x0058, B:21:0x0065, B:22:0x0074, B:24:0x007b, B:25:0x007f, B:28:0x0087, B:29:0x0097, B:33:0x0092, B:35:0x006c), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static org.json.JSONObject buildPlanProperty(com.sensorsdata.sf.core.entity.PopupPlan popupPlan) {
        java.lang.String uuid;
        java.lang.String str;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (popupPlan != null) {
                jSONObject.put(SF_PLAN_ID, popupPlan.planId + "");
                if (popupPlan.audienceId != null) {
                    jSONObject.put(SF_AUDIENCE_ID, popupPlan.audienceId + "");
                }
                if (android.text.TextUtils.isEmpty(popupPlan.strategyId)) {
                    jSONObject.put(SF_PLAN_STRATEGY_ID, popupPlan.isControlGroup ? "-1" : "0");
                } else {
                    jSONObject.put(SF_PLAN_STRATEGY_ID, popupPlan.strategyId);
                }
            }
            if (popupPlan != null && !android.text.TextUtils.isEmpty(popupPlan.convertWindow.getUUID())) {
                uuid = popupPlan.convertWindow.getUUID();
                jSONObject.put(SF_MSG_ID, uuid);
                str = popupPlan == null ? popupPlan.section_id : null;
                if (android.text.TextUtils.isEmpty(str)) {
                    jSONObject.put(SF_SECTION_ID, str);
                    jSONObject.put(SF_PLAN_TYPE, PLAN_SECTION_TYPE);
                } else {
                    jSONObject.put(SF_PLAN_TYPE, PLAN_TYPE);
                }
                jSONObject.put(SF_CHANNEL_SERVICE_NAME, CHANNEL_SERVICE_NAME);
                jSONObject.put(SF_CHANNEL_CATEGORY, CHANNEL_CATEGORY);
                jSONObject.put(SF_PLATFORM_TAG, "ANDROID");
                jSONObject.put(SF_LIB_VERSION, com.sensorsdata.sf.android.sdk.BuildConfig.VERSION_NAME);
                return jSONObject;
            }
            uuid = java.util.UUID.randomUUID().toString();
            jSONObject.put(SF_MSG_ID, uuid);
            if (popupPlan == null) {
            }
            if (android.text.TextUtils.isEmpty(str)) {
            }
            jSONObject.put(SF_CHANNEL_SERVICE_NAME, CHANNEL_SERVICE_NAME);
            jSONObject.put(SF_CHANNEL_CATEGORY, CHANNEL_CATEGORY);
            jSONObject.put(SF_PLATFORM_TAG, "ANDROID");
            jSONObject.put(SF_LIB_VERSION, com.sensorsdata.sf.android.sdk.BuildConfig.VERSION_NAME);
            return jSONObject;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public static void trackPlanPopupClick(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        try {
            org.json.JSONObject jSONObject3 = jSONObject2 != null ? new org.json.JSONObject(jSONObject2.toString()) : new org.json.JSONObject();
            if (!android.text.TextUtils.isEmpty(str)) {
                jSONObject3.put(SF_MSG_TITLE, str);
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                jSONObject3.put(SF_MSG_CONTENT, str2);
            }
            if (!android.text.TextUtils.isEmpty(str4)) {
                jSONObject3.put(SF_MSG_ELEMENT_CONTENT, str4);
            }
            if (!android.text.TextUtils.isEmpty(str5)) {
                jSONObject3.put(SF_MSG_IMAGE_URL, str5);
            }
            jSONObject3.put(SF_MSG_ELEMENT_TYPE, str3);
            if (jSONObject != null) {
                if (jSONObject.has("type")) {
                    jSONObject3.put(SF_MSG_ELEMENT_ACTION, jSONObject.optString("type"));
                }
                if (jSONObject.has("id")) {
                    jSONObject3.put(SF_MSG_ACTION_ID, jSONObject.optString("id"));
                }
                if (jSONObject.has("$sf_close_type")) {
                    jSONObject3.put("$sf_close_type", jSONObject.optString("$sf_close_type"));
                }
            }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track(EVENT_CLICK, jSONObject3);
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private static void trackPlanPopupDisplay(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, java.lang.String str4, org.json.JSONObject jSONObject, java.lang.String str5, java.lang.String str6) {
        try {
            org.json.JSONObject jSONObject2 = jSONObject != null ? new org.json.JSONObject(jSONObject.toString()) : new org.json.JSONObject();
            if (!android.text.TextUtils.isEmpty(str)) {
                jSONObject2.put(SF_MSG_TITLE, str);
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                jSONObject2.put(SF_MSG_CONTENT, str2);
            }
            if (!android.text.TextUtils.isEmpty(str3)) {
                jSONObject2.put(SF_MSG_IMAGE_URL, str3);
            }
            jSONObject2.put(SF_SUCCEED, z);
            if (!android.text.TextUtils.isEmpty(str4)) {
                jSONObject2.put(SF_FAIL_REASON, str4);
            }
            if (android.text.TextUtils.isEmpty(str5)) {
                str5 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getAnonymousId();
            }
            jSONObject2.put("$sf_internal_anonymous_id", str5);
            jSONObject2.put("$sf_internal_login_id", str6);
            java.util.Date date = sDisplayEventTime;
            if (date != null) {
                jSONObject2.put("$time", date);
            }
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "propertyJson is " + jSONObject2.toString());
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track(EVENT_DISPLAY, jSONObject2);
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public static void trackPlanPopupDisplayFailed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, org.json.JSONObject jSONObject, java.lang.String str5, java.lang.String str6) {
        trackPlanPopupDisplay(str, str2, str3, false, str4, jSONObject, str5, str6);
    }

    public static void trackPlanPopupDisplaySuccess(java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject, java.lang.String str4, java.lang.String str5) {
        trackPlanPopupDisplay(str, str2, str3, true, null, jSONObject, str4, str5);
    }
}
