package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public interface ISensorsDataAPI extends com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol, com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol {
    void addHeatMapActivities(java.util.List<java.lang.Class<?>> list);

    void addHeatMapActivity(java.lang.Class<?> cls);

    void addVisualizedAutoTrackActivities(java.util.List<java.lang.Class<?>> list);

    void addVisualizedAutoTrackActivity(java.lang.Class<?> cls);

    void clearGPSLocation();

    void clearSuperProperties();

    void clearTrackTimer();

    void deleteAll();

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    void enableDeepLinkInstallSource(boolean z);

    void enableLog(boolean z);

    void enableNetworkRequest(boolean z);

    void enableRemoteConfig(boolean z);

    void enableTrackScreenOrientation(boolean z);

    void flush();

    void flushScheduled();

    void flushSync();

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    java.lang.String getAnonymousId();

    java.lang.String getCookie(boolean z);

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    java.lang.String getDistinctId();

    int getFlushBulkSize();

    int getFlushInterval();

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    java.lang.String getLoginId();

    long getMaxCacheSize();

    org.json.JSONObject getPresetProperties();

    java.lang.String getScreenOrientation();

    java.lang.String getServerUrl();

    int getSessionIntervalTime();

    org.json.JSONObject getSuperProperties();

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    void identify(java.lang.String str);

    boolean isDebugMode();

    boolean isHeatMapActivity(java.lang.Class<?> cls);

    boolean isHeatMapEnabled();

    boolean isNetworkRequestEnable();

    boolean isVisualizedAutoTrackActivity(java.lang.Class<?> cls);

    boolean isVisualizedAutoTrackEnabled();

    void itemDelete(java.lang.String str, java.lang.String str2);

    void itemSet(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject);

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    void login(java.lang.String str);

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    void login(java.lang.String str, org.json.JSONObject jSONObject);

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    void logout();

    void profileAppend(java.lang.String str, java.lang.String str2);

    void profileAppend(java.lang.String str, java.util.Set<java.lang.String> set);

    void profileDelete();

    void profileIncrement(java.lang.String str, java.lang.Number number);

    void profileIncrement(java.util.Map<java.lang.String, ? extends java.lang.Number> map);

    void profilePushId(java.lang.String str, java.lang.String str2);

    void profileSet(java.lang.String str, java.lang.Object obj);

    void profileSet(org.json.JSONObject jSONObject);

    void profileSetOnce(java.lang.String str, java.lang.Object obj);

    void profileSetOnce(org.json.JSONObject jSONObject);

    void profileUnset(java.lang.String str);

    void profileUnsetPushId(java.lang.String str);

    void registerDynamicSuperProperties(com.sensorsdata.analytics.android.sdk.SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties);

    void registerLimitKeys(java.util.Map<java.lang.String, java.lang.String> map);

    void registerPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin);

    void registerSuperProperties(org.json.JSONObject jSONObject);

    void removeTimer(java.lang.String str);

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    @java.lang.Deprecated
    void resetAnonymousId();

    void resumeTrackScreenOrientation();

    void setCookie(java.lang.String str, boolean z);

    void setFlushBulkSize(int i);

    void setFlushInterval(int i);

    void setFlushNetworkPolicy(int i);

    void setGPSLocation(double d, double d2);

    void setGPSLocation(double d, double d2, java.lang.String str);

    void setMaxCacheSize(long j);

    void setServerUrl(java.lang.String str);

    void setServerUrl(java.lang.String str, boolean z);

    void setSessionIntervalTime(int i);

    void setTrackEventCallBack(com.sensorsdata.analytics.android.sdk.SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack);

    @java.lang.Deprecated
    void showUpWebView(android.webkit.WebView webView, org.json.JSONObject jSONObject, boolean z, boolean z2);

    void showUpWebView(android.webkit.WebView webView, boolean z);

    @java.lang.Deprecated
    void showUpWebView(android.webkit.WebView webView, boolean z, org.json.JSONObject jSONObject);

    void showUpWebView(android.webkit.WebView webView, boolean z, boolean z2);

    void showUpX5WebView(java.lang.Object obj);

    @java.lang.Deprecated
    void showUpX5WebView(java.lang.Object obj, org.json.JSONObject jSONObject, boolean z, boolean z2);

    void showUpX5WebView(java.lang.Object obj, boolean z);

    void startTrackThread();

    void stopTrackScreenOrientation();

    void stopTrackThread();

    void track(java.lang.String str);

    void track(java.lang.String str, org.json.JSONObject jSONObject);

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    void trackDeepLinkLaunch(java.lang.String str);

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    void trackDeepLinkLaunch(java.lang.String str, java.lang.String str2);

    @java.lang.Deprecated
    void trackTimer(java.lang.String str, java.util.concurrent.TimeUnit timeUnit);

    void trackTimerEnd(java.lang.String str);

    void trackTimerEnd(java.lang.String str, org.json.JSONObject jSONObject);

    void trackTimerPause(java.lang.String str);

    void trackTimerResume(java.lang.String str);

    java.lang.String trackTimerStart(java.lang.String str);

    void unregisterPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin);

    void unregisterSuperProperty(java.lang.String str);
}
