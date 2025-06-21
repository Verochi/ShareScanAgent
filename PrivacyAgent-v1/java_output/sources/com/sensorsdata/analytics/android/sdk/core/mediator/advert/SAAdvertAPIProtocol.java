package com.sensorsdata.analytics.android.sdk.core.mediator.advert;

/* loaded from: classes19.dex */
public interface SAAdvertAPIProtocol {
    void enableDeepLinkInstallSource(boolean z);

    void requestDeferredDeepLink(org.json.JSONObject jSONObject);

    @java.lang.Deprecated
    void setDeepLinkCallback(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback);

    void setDeepLinkCompletion(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback);

    void trackAppInstall();

    void trackAppInstall(org.json.JSONObject jSONObject);

    void trackAppInstall(org.json.JSONObject jSONObject, boolean z);

    void trackChannelEvent(java.lang.String str);

    void trackChannelEvent(java.lang.String str, org.json.JSONObject jSONObject);

    void trackDeepLinkLaunch(java.lang.String str);

    void trackDeepLinkLaunch(java.lang.String str, java.lang.String str2);

    void trackInstallation(java.lang.String str);

    void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject);

    void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject, boolean z);
}
