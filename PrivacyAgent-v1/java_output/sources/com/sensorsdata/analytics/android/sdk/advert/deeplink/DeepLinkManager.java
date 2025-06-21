package com.sensorsdata.analytics.android.sdk.advert.deeplink;

/* loaded from: classes19.dex */
public class DeepLinkManager {
    public static final java.lang.String IS_ANALYTICS_DEEPLINK = "is_analytics_deeplink";
    private static org.json.JSONObject mCacheProperties;
    private static com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback mDeepLinkCallback;
    private static com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor mDeepLinkProcessor;
    private static com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback mDeferredDeepLinkCallback;
    private static boolean mEnableDeepLinkInstallSource;
    private static boolean mIsDeepLink;

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ boolean val$isDeepLinkInstallSource;
        final /* synthetic */ org.json.JSONObject val$properties;

        public AnonymousClass1(boolean z, org.json.JSONObject jSONObject, android.content.Context context) {
            this.val$isDeepLinkInstallSource = z;
            this.val$properties = jSONObject;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$isDeepLinkInstallSource) {
                try {
                    org.json.JSONObject jSONObject = this.val$properties;
                    android.content.Context context = this.val$context;
                    jSONObject.put("$ios_install_source", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(context, com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(context), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(this.val$context), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(this.val$context)));
                } catch (org.json.JSONException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.DEEPLINK_LAUNCH).setProperties(this.val$properties));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback {
        final /* synthetic */ boolean val$isSaveDeepLinkInfo;

        public AnonymousClass2(boolean z) {
            this.val$isSaveDeepLinkInfo = z;
        }

        @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback
        public void onFinish(com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.DeepLinkType deepLinkType, java.lang.String str, org.json.JSONObject jSONObject, boolean z, long j) {
            if (this.val$isSaveDeepLinkInfo) {
                com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.saveDeepLinkInfo();
            }
            com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus.getInstance().post(com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBusConstants.Tag.DEEPLINK_LAUNCH, com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getLatestUtmProperties());
            if (deepLinkType == com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.DeepLinkType.SENSORSDATA) {
                try {
                    if (com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.mDeferredDeepLinkCallback != null) {
                        com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.mDeferredDeepLinkCallback.onReceive(new com.sensorsdata.analytics.android.sdk.deeplink.SADeepLinkObject(str, jSONObject, "", z, j));
                    } else if (com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.mDeepLinkCallback != null) {
                        com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.mDeepLinkCallback.onReceive(str, z, j);
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    public enum DeepLinkType {
        CHANNEL,
        SENSORSDATA
    }

    public interface OnDeepLinkParseFinishCallback {
        void onFinish(com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.DeepLinkType deepLinkType, java.lang.String str, org.json.JSONObject jSONObject, boolean z, long j);
    }

    private static void cacheProperties() {
        if (mCacheProperties == null) {
            mCacheProperties = new org.json.JSONObject();
        }
        mergeDeepLinkProperty(mCacheProperties);
    }

    private static com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor createDeepLink(android.content.Intent intent, java.lang.String str, java.lang.String str2) {
        if (intent == null) {
            return null;
        }
        if (isSensorsDataDeepLink(intent, new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(str).getHost(), com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getHost(str2))) {
            return new com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink(intent, str, str2);
        }
        if (isUtmDeepLink(intent)) {
            return new com.sensorsdata.analytics.android.sdk.advert.deeplink.ChannelDeepLink(intent);
        }
        return null;
    }

    public static void enableDeepLinkInstallSource(boolean z) {
        mEnableDeepLinkInstallSource = z;
    }

    public static boolean isDeepLink(android.content.Intent intent) {
        return (intent == null || !"android.intent.action.VIEW".equals(intent.getAction()) || intent.getData() == null) ? false : true;
    }

    private static boolean isParsedDeepLink(android.app.Activity activity) {
        android.content.Intent intent;
        try {
            if ((!com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isUniApp() || !com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isDeepLinkBlackList(activity)) && (intent = activity.getIntent()) != null && intent.getData() != null) {
                return intent.getBooleanExtra(IS_ANALYTICS_DEEPLINK, false);
            }
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, th.getMessage());
        }
        return false;
    }

    private static boolean isSensorsDataDeepLink(android.content.Intent intent, java.lang.String str, java.lang.String str2) {
        android.net.Uri data;
        java.util.List<java.lang.String> pathSegments;
        if (!isDeepLink(intent) || (pathSegments = (data = intent.getData()).getPathSegments()) == null || pathSegments.isEmpty()) {
            return false;
        }
        java.lang.String host = data.getHost();
        if (pathSegments.get(0).equals("slink")) {
            if (android.text.TextUtils.isEmpty(host) || android.text.TextUtils.isEmpty(str2)) {
                return false;
            }
            return com.sensorsdata.analytics.android.sdk.util.NetworkUtils.compareMainDomain(str2, host) || host.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.DATABASE_NAME);
        }
        if (!pathSegments.get(0).equals(com.getui.gtc.extension.distribution.gbd.f.h.f331s) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(host)) {
            return false;
        }
        return host.equals(str) || host.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.DATABASE_NAME);
    }

    private static boolean isUtmDeepLink(android.content.Intent intent) {
        if (!isDeepLink(intent)) {
            return false;
        }
        android.net.Uri data = intent.getData();
        if (data.isOpaque()) {
            com.sensorsdata.analytics.android.sdk.SALog.d("ChannelDeepLink", data + " isOpaque");
            return false;
        }
        java.util.Set<java.lang.String> queryParameterNames = data.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.size() <= 0) {
            return false;
        }
        return com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasLinkUtmProperties(queryParameterNames);
    }

    public static void mergeCacheProperties(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        if (jSONObject == null || (jSONObject2 = mCacheProperties) == null || jSONObject2.length() == 0) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(mCacheProperties, jSONObject);
        mCacheProperties = null;
    }

    public static void mergeDeepLinkProperty(org.json.JSONObject jSONObject) {
        try {
            com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor deepLinkProcessor = mDeepLinkProcessor;
            if (deepLinkProcessor != null) {
                deepLinkProcessor.mergeDeepLinkProperty(jSONObject);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void parseDeepLink(android.app.Activity activity, boolean z) {
        try {
            if (isDeepLink(activity.getIntent()) && !isParsedDeepLink(activity)) {
                android.content.Intent intent = activity.getIntent();
                com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor createDeepLink = createDeepLink(intent, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl(), com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getCustomADChannelUrl());
                mDeepLinkProcessor = createDeepLink;
                if (createDeepLink == null) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.clearUtm();
                mIsDeepLink = true;
                mDeepLinkProcessor.setDeepLinkParseFinishCallback(new com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.AnonymousClass2(z));
                mDeepLinkProcessor.parseDeepLink(intent);
                cacheProperties();
                trackDeepLinkLaunchEvent(activity.getApplicationContext(), mDeepLinkProcessor);
                activity.getIntent().putExtra(IS_ANALYTICS_DEEPLINK, true);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void requestDeferredDeepLink(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject2, java.lang.String str3, boolean z) {
        java.lang.String deviceInfo;
        if (mIsDeepLink) {
            return;
        }
        try {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            java.lang.String openAdIdentifierByReflection = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(context);
            if (jSONObject != null) {
                if (jSONObject.has("$oaid")) {
                    str2 = jSONObject.optString("$oaid");
                    openAdIdentifierByReflection = "";
                    jSONObject.remove("$oaid");
                }
                deviceInfo = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(context, str, str2, openAdIdentifierByReflection);
                if (jSONObject.has("$gaid")) {
                    deviceInfo = java.lang.String.format("%s##gaid=%s", deviceInfo, jSONObject.optString("$gaid"));
                    jSONObject.remove("$gaid");
                }
                if (jSONObject.has("$user_agent")) {
                    jSONObject3.put("ua", jSONObject.optString("$user_agent"));
                    jSONObject.remove("$user_agent");
                }
                jSONObject3.put("app_parameter", jSONObject.toString());
            } else {
                deviceInfo = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(context, str, str2, openAdIdentifierByReflection);
            }
            jSONObject3.put("ids", com.sensorsdata.analytics.android.sdk.util.Base64Coder.encodeString(deviceInfo));
            jSONObject3.put("model", jSONObject2.optString("$model"));
            jSONObject3.put("os", jSONObject2.optString("$os"));
            jSONObject3.put("os_version", jSONObject2.optString("$os_version"));
            jSONObject3.put("network", jSONObject2.optString("$network_type"));
            jSONObject3.put("app_id", jSONObject2.optString("$app_id"));
            jSONObject3.put("app_version", jSONObject2.optString("$app_version"));
            jSONObject3.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            jSONObject3.put("project", new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl()).getProject());
            com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper.request(jSONObject3, mDeferredDeepLinkCallback, str3, z);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void resetDeepLinkProcessor() {
        mDeepLinkProcessor = null;
    }

    public static void setDeepLinkCallback(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        mDeepLinkCallback = sensorsDataDeepLinkCallback;
    }

    public static void setDeferredDeepLinkCallback(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        mDeferredDeepLinkCallback = sensorsDataDeferredDeepLinkCallback;
    }

    private static void trackDeepLinkLaunchEvent(android.content.Context context, com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor deepLinkProcessor) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        boolean z = (deepLinkProcessor instanceof com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink) && mEnableDeepLinkInstallSource;
        try {
            jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_URL, deepLinkProcessor.getDeepLinkUrl());
            jSONObject.put("$time", new java.util.Date(java.lang.System.currentTimeMillis()));
            jSONObject.put("$sat_has_installed_app", com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.isInstallationTracked());
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getLatestUtmProperties(), jSONObject);
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getUtmProperties(), jSONObject);
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.AnonymousClass1(z, jSONObject, context));
    }
}
