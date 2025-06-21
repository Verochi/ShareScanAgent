package com.sensorsdata.analytics.android.sdk.visual.utils;

/* loaded from: classes19.dex */
public class VisualUtil {
    public static com.sensorsdata.analytics.android.sdk.util.visual.ViewNode addViewPathProperties(android.app.Activity activity, android.view.View view, org.json.JSONObject jSONObject) {
        if (view != null && activity != null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new org.json.JSONObject();
                } catch (org.json.JSONException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().getViewNode(view);
            if ((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled() && com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isVisualizedAutoTrackActivity(activity.getClass())) || (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isHeatMapEnabled() && com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isHeatMapActivity(activity.getClass()))) {
                java.lang.String elementSelector = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getElementSelector(view);
                if (!android.text.TextUtils.isEmpty(elementSelector)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_SELECTOR, elementSelector);
                }
                if (viewNode != null && !android.text.TextUtils.isEmpty(viewNode.getViewPath())) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_PATH, viewNode.getViewPath());
                }
            }
            if (viewNode != null && !android.text.TextUtils.isEmpty(viewNode.getViewPosition())) {
                jSONObject.put(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_POSITION, viewNode.getViewPosition());
            }
            return viewNode;
        }
        return null;
    }

    public static org.json.JSONObject getScreenNameAndTitle(android.view.View view, com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo) {
        org.json.JSONObject activityPageInfo;
        if (view == null) {
            return null;
        }
        android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view);
        if (activityOfView == null) {
            activityOfView = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        }
        if (activityOfView == null || activityOfView.getWindow() == null || !activityOfView.getWindow().isActive()) {
            return null;
        }
        java.lang.Object fragmentFromView = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(view, activityOfView);
        if (fragmentFromView != null) {
            activityPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(activityOfView, fragmentFromView);
            if (snapInfo != null && !snapInfo.hasFragment) {
                snapInfo.hasFragment = true;
            }
        } else {
            activityPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activityOfView);
        }
        org.json.JSONObject jSONObject = activityPageInfo;
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDuplicateProperty(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getRNPageInfo(), jSONObject);
        return jSONObject;
    }

    public static int getVisibility(android.view.View view) {
        return (!(view instanceof android.widget.Spinner) && com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible(view) && view.isShown()) ? 0 : 8;
    }

    public static boolean isForbiddenClick(android.view.View view) {
        if (com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfWebView(view) || (view instanceof android.widget.AdapterView)) {
            return true;
        }
        if (!(view instanceof android.widget.TextView)) {
            return false;
        }
        android.widget.TextView textView = (android.widget.TextView) view;
        return textView.isTextSelectable() && !textView.hasOnClickListeners();
    }

    public static boolean isSupportClick(android.view.View view) {
        android.view.ViewParent parent = view.getParent();
        return (parent instanceof android.widget.AdapterView) || com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfRecyclerView(parent) || (view instanceof android.widget.RatingBar) || (view instanceof android.widget.SeekBar);
    }

    public static boolean isSupportElementContent(android.view.View view) {
        return ((view instanceof android.widget.SeekBar) || (view instanceof android.widget.RatingBar) || (view instanceof android.widget.Switch)) ? false : true;
    }
}
