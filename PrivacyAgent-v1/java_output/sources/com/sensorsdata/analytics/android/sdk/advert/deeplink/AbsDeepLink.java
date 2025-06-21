package com.sensorsdata.analytics.android.sdk.advert.deeplink;

/* loaded from: classes19.dex */
public abstract class AbsDeepLink implements com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor {
    private java.lang.String deepLinkUrl;
    protected com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback mCallBack;

    public AbsDeepLink(android.content.Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        setDeepLinkUrl(intent.getData().toString());
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public java.lang.String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public void setDeepLinkParseFinishCallback(com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback) {
        this.mCallBack = onDeepLinkParseFinishCallback;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public void setDeepLinkUrl(java.lang.String str) {
        this.deepLinkUrl = str;
    }
}
