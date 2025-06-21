package com.sensorsdata.analytics.android.autotrack.utils;

/* loaded from: classes19.dex */
public class AopUtil {
    private static final java.lang.String TAG = "SA.AopUtil";

    /* JADX WARN: Multi-variable type inference failed */
    public static org.json.JSONObject buildTitleNoAutoTrackerProperties(android.app.Activity activity) {
        org.json.JSONObject trackProperties;
        try {
            org.json.JSONObject buildTitleAndScreenName = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.buildTitleAndScreenName(activity);
            if ((activity instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) && (trackProperties = ((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) activity).getTrackProperties()) != null) {
                if (trackProperties.has("$screen_name")) {
                    buildTitleAndScreenName.put("$screen_name", trackProperties.optString("$screen_name"));
                }
                if (trackProperties.has("$title")) {
                    buildTitleAndScreenName.put("$title", trackProperties.optString("$title"));
                }
            }
            return buildTitleAndScreenName;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new org.json.JSONObject();
        }
    }

    public static org.json.JSONObject injectClickInfo(com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext viewContext, org.json.JSONObject jSONObject, boolean z) {
        android.view.View view = viewContext.view;
        if (view == null) {
            return jSONObject;
        }
        try {
            if (!isTrackEvent(view, z)) {
                return null;
            }
            android.content.Context context = viewContext.view.getContext();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            java.lang.String viewId = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewId(viewContext.view);
            if (!android.text.TextUtils.isEmpty(viewId)) {
                jSONObject2.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, viewId);
            }
            java.lang.String viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(viewContext.view);
            if (!android.text.TextUtils.isEmpty(viewContent)) {
                jSONObject2.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, viewContent);
            }
            jSONObject2.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewType(viewContext.view));
            android.app.Activity activity = viewContext.activity;
            if (activity == null) {
                activity = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(context, viewContext.view);
            }
            if (activity != null) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activity), jSONObject2);
            }
            java.lang.Object obj = viewContext.fragment;
            if (obj == null) {
                obj = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(viewContext.view, activity);
            }
            if (obj != null) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(activity, obj), jSONObject2);
            }
            org.json.JSONObject jSONObject3 = (org.json.JSONObject) viewContext.view.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties);
            if (jSONObject3 != null) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject3, jSONObject2);
            }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDistinctProperty(jSONObject2, jSONObject);
            return jSONObject;
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return jSONObject;
        }
    }

    public static boolean isTrackEvent(android.view.View view, boolean z) {
        if (view instanceof android.widget.CheckBox) {
            if (!z) {
                return false;
            }
        } else if (view instanceof android.widget.RadioButton) {
            if (!z) {
                return false;
            }
        } else if (view instanceof android.widget.ToggleButton) {
            if (!z) {
                return false;
            }
        } else if ((view instanceof android.widget.CompoundButton) && !z) {
            return false;
        }
        if (view instanceof android.widget.RatingBar) {
            return z;
        }
        return true;
    }
}
