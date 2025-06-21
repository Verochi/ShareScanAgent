package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class WebNodesManager extends com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager {
    private static final java.lang.String TAG = "SA.Visual.WebNodesManager";
    private java.lang.String mWebViewUrl;

    private com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo parsePageInfo(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject("data");
            return com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.createPageInfo(jSONObject.optString("$title"), jSONObject.optString("$url"));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public void handlerVisualizedFailure(java.lang.String str, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list) {
        com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sNodesCache.put(str, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.createAlertInfo(list));
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public void handlerVisualizedPageInfo(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo parsePageInfo = parsePageInfo(str);
        if (parsePageInfo == null) {
            return;
        }
        this.mWebViewUrl = parsePageInfo.getUrl();
        if (com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sPageInfoCache == null) {
            com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sPageInfoCache = new android.util.LruCache<>(10);
        }
        java.lang.String url = parsePageInfo.getUrl();
        if (android.text.TextUtils.isEmpty(url)) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sPageInfoCache.put(url, parsePageInfo);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public void handlerVisualizedTrack(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list) {
        if (android.text.TextUtils.isEmpty(this.mWebViewUrl)) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.sNodesCache.put(this.mWebViewUrl, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.createNodesInfo(list));
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager
    public com.sensorsdata.analytics.android.sdk.visual.model.CommonNode parseExtraNodesInfo(org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.visual.model.WebNode webNode = new com.sensorsdata.analytics.android.sdk.visual.model.WebNode();
        webNode.set$element_selector(jSONObject.optString(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_SELECTOR));
        webNode.setTagName(jSONObject.optString("tagName"));
        webNode.set$url(jSONObject.optString("$url"));
        webNode.setzIndex(jSONObject.optInt("zIndex"));
        webNode.set$title(jSONObject.optString("$title"));
        webNode.setList_selector(jSONObject.optString("list_selector"));
        webNode.setScale((float) jSONObject.optDouble("scale"));
        webNode.setVisibility(jSONObject.optBoolean(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY));
        webNode.setLib_version(jSONObject.optString("lib_version"));
        return webNode;
    }
}
