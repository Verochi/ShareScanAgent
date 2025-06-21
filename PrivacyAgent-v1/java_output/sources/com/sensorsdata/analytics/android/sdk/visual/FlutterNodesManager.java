package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class FlutterNodesManager extends com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager {
    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public void handlerVisualizedFailure(java.lang.String str, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list) {
        com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sNodesCache.put(str, com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.createAlertInfo(list));
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public void handlerVisualizedPageInfo(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo parsePageInfo = parsePageInfo(str);
        if (com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sPageInfoCache == null) {
            com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sPageInfoCache = new android.util.LruCache<>(10);
        }
        android.app.Activity foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        if (foregroundActivity == null) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sPageInfoCache.put(com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(foregroundActivity.getClass()), parsePageInfo);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public void handlerVisualizedTrack(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list) {
        android.app.Activity foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        java.lang.String canonicalName = foregroundActivity != null ? foregroundActivity.getClass().getCanonicalName() : "";
        if (android.text.TextUtils.isEmpty(canonicalName)) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sNodesCache.put(canonicalName, com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.createNodesInfo(list));
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public com.sensorsdata.analytics.android.sdk.visual.model.CommonNode parseExtraNodesInfo(org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode flutterNode = new com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode();
        flutterNode.setTitle(jSONObject.optString("title"));
        flutterNode.setScreen_name(jSONObject.optString("screen_name"));
        flutterNode.setVisibility(true);
        return flutterNode;
    }

    public com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo parsePageInfo(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject("data");
            return com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.createPageInfo(jSONObject.optString("title"), jSONObject.optString("screen_name"), jSONObject.optString("lib_version"));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
