package com.sensorsdata.analytics.android.sdk.advert.deeplink;

/* loaded from: classes19.dex */
public interface DeepLinkProcessor {
    java.lang.String getDeepLinkUrl();

    void mergeDeepLinkProperty(org.json.JSONObject jSONObject);

    void parseDeepLink(android.content.Intent intent);

    void setDeepLinkParseFinishCallback(com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback);

    void setDeepLinkUrl(java.lang.String str);
}
