package com.sensorsdata.analytics.android.sdk.advert.utils;

/* loaded from: classes19.dex */
public class SAAdvertMarketHelper {

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig val$saAdvertisingConfig;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig sAAdvertisingConfig, android.app.Activity activity) {
            this.val$saAdvertisingConfig = sAAdvertisingConfig;
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean z = true;
                android.content.Intent parseUri = !android.text.TextUtils.isEmpty(this.val$saAdvertisingConfig.getWakeupUrl()) ? android.content.Intent.parseUri(this.val$saAdvertisingConfig.getWakeupUrl(), 1) : null;
                android.content.Context applicationContext = this.val$activity.getApplicationContext();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("$ios_install_source", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(applicationContext, com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(applicationContext), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(applicationContext), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(applicationContext)));
                if (!com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.isDeepLink(this.val$activity.getIntent()) && !com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.isDeepLink(parseUri)) {
                    z = false;
                }
                jSONObject.put("$sat_awake_from_deeplink", z);
                jSONObject.put("$sat_has_installed_app", com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.isInstallationTracked());
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.APP_INTERACT).setProperties(jSONObject));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void handleAdMarket(android.app.Activity activity, com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig sAAdvertisingConfig) {
        if (sAAdvertisingConfig != null) {
            try {
                if (sAAdvertisingConfig.isEnableRemarketing() && isDailyFirst()) {
                    com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper.AnonymousClass1(sAAdvertisingConfig, activity));
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static boolean isDailyFirst() {
        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDailyDate dayDatePst = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getDayDatePst();
        java.lang.String formatTime = com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd");
        if (formatTime.equals(dayDatePst.get())) {
            return false;
        }
        dayDatePst.commit(formatTime);
        return true;
    }
}
