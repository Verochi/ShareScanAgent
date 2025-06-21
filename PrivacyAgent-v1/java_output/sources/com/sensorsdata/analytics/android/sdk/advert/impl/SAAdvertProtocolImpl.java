package com.sensorsdata.analytics.android.sdk.advert.impl;

/* loaded from: classes19.dex */
public class SAAdvertProtocolImpl {
    private com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin mAdEventId;
    private final com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig mAdvertOptions;
    private final android.content.Context mContext;
    private boolean mEnableDeepLinkInstallSource;
    private com.sensorsdata.analytics.android.sdk.advert.plugin.LatestUtmPlugin mLatestUtmPlugin;
    private com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataAdvertActivityLifeCallback mLifecycleCallback;
    private final com.sensorsdata.analytics.android.sdk.SAConfigOptions mOptions;
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;
    private com.sensorsdata.analytics.android.sdk.advert.plugin.SAAdvertAppStartPlugin mStartPlugin;
    private com.sensorsdata.analytics.android.sdk.advert.plugin.SAAdvertAppViewScreenPlugin mViewScreenPlugin;

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
        public AnonymousClass1() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
        public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
            return (com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mAdvertOptions == null || android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mAdvertOptions.serverUrl) || com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mAdvertOptions.eventNames.isEmpty() || android.text.TextUtils.isEmpty(sAPropertyFilter.getEvent()) || !com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mAdvertOptions.eventNames.contains(sAPropertyFilter.getEvent())) ? false : true;
        }

        @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
        public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
            try {
                sAPropertiesFetcher.getProperties().put("$sat_event_track_id", java.util.UUID.randomUUID().toString());
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mOptions.isSaveDeepLinkInfo()) {
                    com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.loadUtmByLocal();
                } else {
                    com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.clearLocalUtm();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$oaid;
        final /* synthetic */ org.json.JSONObject val$properties;

        public AnonymousClass3(java.lang.String str, org.json.JSONObject jSONObject) {
            this.val$oaid = str;
            this.val$properties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mEnableDeepLinkInstallSource) {
                try {
                    java.lang.String str = this.val$oaid;
                    java.lang.String str2 = "";
                    if (android.text.TextUtils.isEmpty(str)) {
                        str = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext);
                        str2 = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext);
                    }
                    this.val$properties.put("$ios_install_source", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext), str, str2));
                } catch (org.json.JSONException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.DEEPLINK_LAUNCH).setProperties(this.val$properties));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ boolean val$disableCallback;
        final /* synthetic */ java.lang.String val$eventName;
        final /* synthetic */ org.json.JSONObject val$eventProperties;

        public AnonymousClass4(boolean z, org.json.JSONObject jSONObject, java.lang.String str) {
            this.val$disableCallback = z;
            this.val$eventProperties = jSONObject;
            this.val$eventName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String openAdIdentifier;
            java.lang.String deviceInfo;
            try {
                if (com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.isFirstTrackInstallation(this.val$disableCallback)) {
                    boolean z = false;
                    try {
                        if (!com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmProperties(this.val$eventProperties)) {
                            com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.mergeUtmByMetaData(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, this.val$eventProperties);
                        }
                        if (!com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmProperties(this.val$eventProperties)) {
                            java.lang.String identifier = com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext);
                            if (this.val$eventProperties.has("$oaid")) {
                                openAdIdentifier = this.val$eventProperties.optString("$oaid");
                                deviceInfo = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, identifier, openAdIdentifier, "");
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, "properties has oaid " + openAdIdentifier);
                            } else {
                                openAdIdentifier = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext);
                                deviceInfo = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, identifier, openAdIdentifier, com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext));
                            }
                            if (this.val$eventProperties.has("$gaid")) {
                                deviceInfo = java.lang.String.format("%s##gaid=%s", deviceInfo, this.val$eventProperties.optString("$gaid"));
                            }
                            z = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isGetDeviceInfo(identifier, openAdIdentifier);
                            this.val$eventProperties.put("$ios_install_source", deviceInfo);
                        }
                        if (this.val$eventProperties.has("$oaid")) {
                            this.val$eventProperties.remove("$oaid");
                        }
                        if (this.val$eventProperties.has("$gaid")) {
                            this.val$eventProperties.remove("$gaid");
                        }
                        boolean z2 = this.val$disableCallback;
                        if (z2) {
                            this.val$eventProperties.put("$ios_install_disable_callback", z2);
                        }
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                    com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(this.val$eventName).setProperties(this.val$eventProperties));
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    this.val$eventProperties.remove("$ios_install_disable_callback");
                    com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(this.val$eventProperties, jSONObject);
                    jSONObject.put("$first_visit_time", new java.util.Date());
                    com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_SET_ONCE).setProperties(jSONObject));
                    com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.setTrackInstallation(this.val$disableCallback);
                    com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.saveCorrectTrackInstallation(z);
                }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventName;
        final /* synthetic */ org.json.JSONObject val$eventProperties;

        public AnonymousClass5(org.json.JSONObject jSONObject, java.lang.String str) {
            this.val$eventProperties = jSONObject;
            this.val$eventName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.val$eventProperties.put("$is_channel_callback_event", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isFirstChannelEvent(this.val$eventName));
                    if (!com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmProperties(this.val$eventProperties)) {
                        com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.mergeUtmByMetaData(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, this.val$eventProperties);
                    }
                    if (!com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmProperties(this.val$eventProperties)) {
                        if (this.val$eventProperties.has("$oaid")) {
                            java.lang.String optString = this.val$eventProperties.optString("$oaid");
                            this.val$eventProperties.put("$channel_device_info", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext), optString, ""));
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, "properties has oaid " + optString);
                        } else {
                            this.val$eventProperties.put("$channel_device_info", com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifierByReflection(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext)));
                        }
                    }
                    if (this.val$eventProperties.has("$oaid")) {
                        this.val$eventProperties.remove("$oaid");
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(this.val$eventName).setProperties(this.val$eventProperties));
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$params;

        public AnonymousClass6(org.json.JSONObject jSONObject) {
            this.val$params = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isRequestDeferredDeeplink()) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.TAG, "do requestDeferredDeepLink");
                    com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.requestDeferredDeepLink(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext, this.val$params, com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.getIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mContext), com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getPresetProperties(), com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mOptions.getCustomADChannelUrl(), com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.this.mOptions.isSaveDeepLinkInfo());
                    com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.commitRequestDeferredDeeplink(false);
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public SAAdvertProtocolImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        this.mContext = sAContextManager.getContext();
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        this.mOptions = sAConfigOptions;
        this.mAdvertOptions = sAConfigOptions.getAdvertConfig();
        init();
    }

    private void enableDeepLinkInstallSource(boolean z) {
        this.mEnableDeepLinkInstallSource = z;
        com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.enableDeepLinkInstallSource(z);
    }

    private void init() {
        this.mStartPlugin = new com.sensorsdata.analytics.android.sdk.advert.plugin.SAAdvertAppStartPlugin();
        this.mViewScreenPlugin = new com.sensorsdata.analytics.android.sdk.advert.plugin.SAAdvertAppViewScreenPlugin();
        this.mLatestUtmPlugin = new com.sensorsdata.analytics.android.sdk.advert.plugin.LatestUtmPlugin();
        this.mAdEventId = new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.AnonymousClass1();
        com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.setSourceChannelKeys(this.mOptions.channelSourceKeys);
        if (com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.isMainProcess(this.mContext, null)) {
            com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.commitRequestDeferredDeeplink(!com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isExistRequestDeferredDeeplink());
        }
    }

    private org.json.JSONObject mergeChannelEventProperties(java.lang.String str, org.json.JSONObject jSONObject) {
        return this.mOptions.isAutoAddChannelCallbackEvent() ? com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.checkOrSetChannelCallbackEvent(str, jSONObject, this.mContext) : jSONObject;
    }

    private void requestDeferredDeepLink(org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.AnonymousClass6(jSONObject));
    }

    private void trackChannelEvent(java.lang.String str, org.json.JSONObject jSONObject) {
        if (this.mOptions.isAutoAddChannelCallbackEvent()) {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track(str, jSONObject);
            return;
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
        com.sensorsdata.analytics.android.sdk.util.SADataHelper.addTimeProperty(jSONObject2);
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.AnonymousClass5(jSONObject2, str));
    }

    private void trackDeepLinkLaunch(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_URL, str);
            jSONObject.put("$time", new java.util.Date(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.AnonymousClass3(str2, jSONObject));
    }

    private void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject, boolean z) {
        try {
            if (com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.isMainProcess(this.mContext, null)) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
                com.sensorsdata.analytics.android.sdk.util.SADataHelper.addTimeProperty(jSONObject2);
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.AnonymousClass4(z, jSONObject2, str));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void delayExecution() {
        com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataAdvertActivityLifeCallback sensorsDataAdvertActivityLifeCallback;
        try {
            if (this.mOptions.getDeeplinkCallback() != null) {
                com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.setDeferredDeepLinkCallback(this.mOptions.getDeeplinkCallback());
                if ((this.mSAContextManager.getInternalConfigs().context instanceof android.app.Activity) && (sensorsDataAdvertActivityLifeCallback = this.mLifecycleCallback) != null) {
                    sensorsDataAdvertActivityLifeCallback.onActivityStarted((android.app.Activity) this.mSAContextManager.getInternalConfigs().context);
                }
            }
            if (this.mSAContextManager.getInternalConfigs().context instanceof android.app.Activity) {
                com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper.handleAdMarket((android.app.Activity) this.mSAContextManager.getInternalConfigs().context, this.mOptions.getAdvertConfig());
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void delayInitTask() {
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl.AnonymousClass2());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        str.hashCode();
        switch (str) {
            case "setDeepLinkCallback":
                com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.setDeepLinkCallback((com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback) objArr[0]);
                return null;
            case "trackInstallation":
                if (objArr.length == 3) {
                    trackInstallation((java.lang.String) objArr[0], (org.json.JSONObject) objArr[1], ((java.lang.Boolean) objArr[2]).booleanValue());
                } else if (objArr.length == 2) {
                    trackInstallation((java.lang.String) objArr[0], (org.json.JSONObject) objArr[1], false);
                } else {
                    trackInstallation((java.lang.String) objArr[0], null, false);
                }
                return null;
            case "commitRequestDeferredDeeplink":
                com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.commitRequestDeferredDeeplink(((java.lang.Boolean) objArr[0]).booleanValue());
                return null;
            case "removeDeepLinkInfo":
                com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.removeDeepLinkInfo((org.json.JSONObject) objArr[0]);
                return null;
            case "trackDeepLinkLaunch":
                if (objArr.length == 2) {
                    trackDeepLinkLaunch((java.lang.String) objArr[0], (java.lang.String) objArr[1]);
                } else {
                    trackDeepLinkLaunch((java.lang.String) objArr[0], null);
                }
                return null;
            case "sendEvent":
                com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig sAAdvertisingConfig = this.mAdvertOptions;
                if (sAAdvertisingConfig != null && !android.text.TextUtils.isEmpty(sAAdvertisingConfig.serverUrl) && !this.mAdvertOptions.eventNames.isEmpty()) {
                    org.json.JSONObject jSONObject = (org.json.JSONObject) objArr[0];
                    java.lang.String optString = jSONObject.optString("event");
                    if (!android.text.TextUtils.isEmpty(optString) && this.mAdvertOptions.eventNames.contains(optString)) {
                        com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.sendData(this.mContext, this.mAdvertOptions.serverUrl, (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA_WITH_KEY, jSONObject, this.mAdvertOptions.secreteKey), jSONObject.toString());
                    }
                }
                return null;
            case "mergeChannelEventProperties":
                return (T) mergeChannelEventProperties((java.lang.String) objArr[0], (org.json.JSONObject) objArr[1]);
            case "trackChannelEvent":
                if (objArr.length == 2) {
                    trackChannelEvent((java.lang.String) objArr[0], (org.json.JSONObject) objArr[1]);
                } else {
                    trackChannelEvent((java.lang.String) objArr[0], null);
                }
                return null;
            case "getLatestUtmProperties":
                return (T) com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getLatestUtmProperties();
            case "requestDeferredDeepLink":
                requestDeferredDeepLink((org.json.JSONObject) objArr[0]);
                return null;
            case "handlerScanUri":
                com.sensorsdata.analytics.android.sdk.advert.scan.SAAdvertScanHelper.scanHandler((android.app.Activity) objArr[0], (android.net.Uri) objArr[1]);
                return null;
            case "setDeepLinkCompletion":
                com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.setDeferredDeepLinkCallback((com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback) objArr[0]);
                return null;
            case "enableDeepLinkInstallSource":
                enableDeepLinkInstallSource(((java.lang.Boolean) objArr[0]).booleanValue());
                return null;
            default:
                return null;
        }
    }

    public void registerLifeCallback() {
        if (this.mLifecycleCallback == null) {
            this.mLifecycleCallback = new com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataAdvertActivityLifeCallback(this.mOptions);
        }
        com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mLifecycleCallback);
    }

    public void registerPropertyPlugin() {
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mStartPlugin);
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mViewScreenPlugin);
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mLatestUtmPlugin);
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mAdEventId);
    }

    public void unregisterLifecycleCallback() {
        if (this.mLifecycleCallback != null) {
            com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().removeActivityLifeCallback(this.mLifecycleCallback);
        }
    }

    public void unregisterPropertyPlugin() {
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mStartPlugin);
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mViewScreenPlugin);
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mLatestUtmPlugin);
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mAdEventId);
    }
}
