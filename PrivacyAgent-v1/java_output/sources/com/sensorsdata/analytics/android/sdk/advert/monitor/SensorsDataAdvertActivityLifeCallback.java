package com.sensorsdata.analytics.android.sdk.advert.monitor;

/* loaded from: classes19.dex */
public class SensorsDataAdvertActivityLifeCallback implements com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private com.sensorsdata.analytics.android.sdk.SAConfigOptions mOptions;

    public SensorsDataAdvertActivityLifeCallback(com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions) {
        this.mOptions = sAConfigOptions;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        try {
            com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper.handleAdMarket(activity, this.mOptions.getAdvertConfig());
            com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        try {
            com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper.handleAdMarket(activity, this.mOptions.getAdvertConfig());
            com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks
    public void onNewIntent(android.content.Intent intent) {
    }
}
