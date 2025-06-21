package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SAPageInfoUtils {
    public static final java.lang.String SCREEN_NAME = "$screen_name";
    public static final java.lang.String TITLE = "$title";

    /* JADX WARN: Multi-variable type inference failed */
    public static org.json.JSONObject getActivityPageInfo(android.app.Activity activity) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("$screen_name", activity.getClass().getCanonicalName());
            java.lang.String activityTitle = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(activity);
            if (!android.text.TextUtils.isEmpty(activityTitle)) {
                jSONObject.put("$title", activityTitle);
            }
            if (activity instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) activity).getTrackProperties(), jSONObject);
            }
            return jSONObject;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new org.json.JSONObject();
        }
    }

    public static org.json.JSONObject getFragmentPageInfo(android.app.Activity activity, java.lang.Object obj) {
        java.lang.String str;
        com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle sensorsDataFragmentTitle;
        org.json.JSONObject trackProperties;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (!(obj instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) || (trackProperties = ((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) obj).getTrackProperties()) == null) {
                str = null;
            } else {
                str = trackProperties.has("$screen_name") ? trackProperties.optString("$screen_name") : null;
                r3 = trackProperties.has("$title") ? trackProperties.optString("$title") : null;
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(trackProperties, jSONObject);
            }
            boolean isEmpty = android.text.TextUtils.isEmpty(r3);
            boolean isEmpty2 = android.text.TextUtils.isEmpty(str);
            if (isEmpty && obj.getClass().isAnnotationPresent(com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class) && (sensorsDataFragmentTitle = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) obj.getClass().getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class)) != null) {
                r3 = sensorsDataFragmentTitle.title();
            }
            boolean isEmpty3 = android.text.TextUtils.isEmpty(r3);
            if (isEmpty3 || isEmpty2) {
                if (activity == null) {
                    activity = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getActivityFromFragment(obj);
                }
                if (activity != null) {
                    if (isEmpty3) {
                        r3 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(activity);
                    }
                    if (isEmpty2) {
                        str = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "%s|%s", activity.getClass().getCanonicalName(), obj.getClass().getCanonicalName());
                    }
                }
            }
            if (!android.text.TextUtils.isEmpty(r3)) {
                jSONObject.put("$title", r3);
            }
            if (android.text.TextUtils.isEmpty(str)) {
                str = obj.getClass().getCanonicalName();
            }
            jSONObject.put("$screen_name", str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public static org.json.JSONObject getRNPageInfo() {
        return getRNPageInfo(null);
    }

    public static org.json.JSONObject getRNPageInfo(android.view.View view) {
        java.lang.Object tag;
        try {
            java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callStaticMethod(com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(new java.lang.String[]{"com.sensorsdata.analytics.utils.RNViewUtils"}), "getVisualizeProperties", new java.lang.Object[0]);
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (view != null && jSONObject.optBoolean("isSetRNViewTag", false) && ((tag = view.getTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_rn_key)) == null || !((java.lang.Boolean) tag).booleanValue())) {
                    return null;
                }
                java.lang.String optString = jSONObject.optString("$screen_name");
                java.lang.String optString2 = jSONObject.optString("$title");
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("$screen_name", optString);
                jSONObject2.put("$title", optString2);
                return jSONObject2;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return null;
    }
}
