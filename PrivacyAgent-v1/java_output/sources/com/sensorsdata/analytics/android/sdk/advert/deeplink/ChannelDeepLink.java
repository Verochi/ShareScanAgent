package com.sensorsdata.analytics.android.sdk.advert.deeplink;

/* loaded from: classes19.dex */
class ChannelDeepLink extends com.sensorsdata.analytics.android.sdk.advert.deeplink.AbsDeepLink {
    public ChannelDeepLink(android.content.Intent intent) {
        super(intent);
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public void mergeDeepLinkProperty(org.json.JSONObject jSONObject) {
        try {
            jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_URL, getDeepLinkUrl());
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getUtmProperties(), jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public void parseDeepLink(android.content.Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        android.net.Uri data = intent.getData();
        if (data.isOpaque()) {
            com.sensorsdata.analytics.android.sdk.SALog.d("ChannelDeepLink", data.toString() + " isOpaque");
            return;
        }
        java.util.Set<java.lang.String> queryParameterNames = data.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.size() <= 0) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str : queryParameterNames) {
            java.lang.String queryParameter = data.getQueryParameter(str);
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                queryParameter = "";
            }
            hashMap.put(str, queryParameter);
        }
        com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.parseParams(hashMap);
        com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback = this.mCallBack;
        if (onDeepLinkParseFinishCallback != null) {
            onDeepLinkParseFinishCallback.onFinish(com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.DeepLinkType.CHANNEL, null, null, true, 0L);
        }
    }
}
