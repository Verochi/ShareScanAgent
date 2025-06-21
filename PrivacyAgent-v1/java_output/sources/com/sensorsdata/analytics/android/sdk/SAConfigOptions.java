package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public final class SAConfigOptions extends com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions implements java.lang.Cloneable {
    boolean mInvokeHeatMapEnabled;
    boolean mInvokeLog;
    boolean mInvokeVisualizedEnabled;

    private SAConfigOptions() {
    }

    public SAConfigOptions(java.lang.String str) {
        this.mServerUrl = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.sensorsdata.analytics.android.sdk.SAConfigOptions m94clone() {
        try {
            return (com.sensorsdata.analytics.android.sdk.SAConfigOptions) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return this;
        }
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions disableAppEndTimer() {
        this.mDisableAppEndTimer = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions disableDebugAssistant() {
        this.mDisableDebugAssistant = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions disableDeviceId() {
        this.mDisableDeviceId = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions disableRandomTimeRequestRemoteConfig() {
        this.mDisableRandomTimeRequestRemoteConfig = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions disableSDK(boolean z) {
        this.isDisableSDK = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableAutoAddChannelCallbackEvent(boolean z) {
        this.isAutoAddChannelCallbackEvent = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableEncrypt(boolean z) {
        this.mEnableEncrypt = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableHeatMap(boolean z) {
        this.mHeatMapEnabled = z;
        this.mInvokeHeatMapEnabled = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableJavaScriptBridge(boolean z) {
        this.isAutoTrackWebView = true;
        this.isWebViewSupportJellyBean = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableLog(boolean z) {
        this.mLogEnabled = z;
        this.mInvokeLog = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableSaveDeepLinkInfo(boolean z) {
        this.mEnableSaveDeepLinkInfo = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableSession(boolean z) {
        this.mEnableSession = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableSubProcessFlushData() {
        this.isSubProcessFlushData = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableTrackAppCrash() {
        this.mEnableTrackAppCrash = true;
        return this;
    }

    @java.lang.Deprecated
    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableTrackPageLeave(boolean z) {
        return enableTrackPageLeave(z, false);
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableTrackPageLeave(boolean z, boolean z2) {
        this.mIsTrackPageLeave = z;
        this.mIsTrackFragmentPageLeave = z2;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableTrackPush(boolean z) {
        this.mEnableTrackPush = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableTrackScreenOrientation(boolean z) {
        this.mTrackScreenOrientationEnabled = z;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableTransportEncrypt() {
        this.mTransportEncrypt = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableVisualizedAutoTrack(boolean z) {
        this.mVisualizedEnabled = z;
        this.mInvokeVisualizedEnabled = true;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions enableVisualizedProperties(boolean z) {
        this.mVisualizedPropertiesEnabled = z;
        return this;
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig getAdvertConfig() {
        return super.getAdvertConfig();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.lang.String getAnonymousId() {
        return super.getAnonymousId();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ int getAutoTrackEventType() {
        return super.getAutoTrackEventType();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.lang.String getCustomADChannelUrl() {
        return super.getCustomADChannelUrl();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback getDeeplinkCallback() {
        return super.getDeeplinkCallback();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.util.List getEncryptors() {
        return super.getEncryptors();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ int getEventSessionTimeout() {
        return super.getEventSessionTimeout();
    }

    public com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig getExposureConfig() {
        return this.mExposureConfig;
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ int getFlushBulkSize() {
        return super.getFlushBulkSize();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.util.List getIgnorePageLeave() {
        return super.getIgnorePageLeave();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.util.List getInstantEvents() {
        return super.getInstantEvents();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.util.Map getLimitKeys() {
        return super.getLimitKeys();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ int getMaxRequestInterval() {
        return super.getMaxRequestInterval();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ int getMinRequestInterval() {
        return super.getMinRequestInterval();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey getPersistentSecretKey() {
        return super.getPersistentSecretKey();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.util.List getPropertyPlugins() {
        return super.getPropertyPlugins();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.lang.String getRemoteConfigUrl() {
        return super.getRemoteConfigUrl();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ javax.net.ssl.SSLSocketFactory getSSLSocketFactory() {
        return super.getSSLSocketFactory();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.lang.String getServerUrl() {
        return super.getServerUrl();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ java.util.List getStorePlugins() {
        return super.getStorePlugins();
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions ignorePageLeave(java.util.List<java.lang.Class<?>> list) {
        this.mIgnorePageLeave = list;
        return this;
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isAutoAddChannelCallbackEvent() {
        return super.isAutoAddChannelCallbackEvent();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isAutoTrackWebView() {
        return super.isAutoTrackWebView();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ boolean isDataCollectEnable() {
        return super.isDataCollectEnable();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isDisableAppEndTimer() {
        return super.isDisableAppEndTimer();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isDisableDebugAssistant() {
        return super.isDisableDebugAssistant();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isDisableDeviceId() {
        return super.isDisableDeviceId();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isDisableRandomTimeRequestRemoteConfig() {
        return super.isDisableRandomTimeRequestRemoteConfig();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isDisableSDK() {
        return super.isDisableSDK();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isEnableEncrypt() {
        return super.isEnableEncrypt();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isEnableSession() {
        return super.isEnableSession();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isEnableTrackPush() {
        return super.isEnableTrackPush();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isMultiProcessFlush() {
        return super.isMultiProcessFlush();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isSaveDeepLinkInfo() {
        return super.isSaveDeepLinkInfo();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isTrackFragmentPageLeave() {
        return super.isTrackFragmentPageLeave();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isTrackPageLeave() {
        return super.isTrackPageLeave();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isTransportEncrypt() {
        return super.isTransportEncrypt();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isVisualizedPropertiesEnabled() {
        return super.isVisualizedPropertiesEnabled();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSAConfigOptions
    public /* bridge */ /* synthetic */ boolean isWebViewSupportJellyBean() {
        return super.isWebViewSupportJellyBean();
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions persistentSecretKey(com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey iPersistentSecretKey) {
        this.mPersistentSecretKey = iPersistentSecretKey;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions registerEncryptor(com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener sAEncryptListener) {
        if (sAEncryptListener != null && !android.text.TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) && !android.text.TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType()) && !this.mEncryptors.contains(sAEncryptListener)) {
            this.mEncryptors.add(0, sAEncryptListener);
        }
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions registerLimitKeys(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mLimitKeys = map;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions registerPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
        if (this.mPropertyPlugins == null) {
            this.mPropertyPlugins = new java.util.ArrayList();
        }
        this.mPropertyPlugins.add(sAPropertyPlugin);
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions registerStorePlugin(com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin storePlugin) {
        if (this.mStorePlugins == null) {
            this.mStorePlugins = new java.util.ArrayList();
        }
        this.mStorePlugins.add(storePlugin);
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setAdvertConfig(com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig sAAdvertisingConfig) {
        this.mSATConfig = sAAdvertisingConfig;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setAnonymousId(java.lang.String str) {
        this.mAnonymousId = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setAutoTrackEventType(int i) {
        this.mAutoTrackEventType = i;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setCustomAdChannelUrl(java.lang.String str) {
        this.mCustomADChannelUrl = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setDeepLinkCompletion(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        this.mDeeplinkCallback = sensorsDataDeferredDeepLinkCallback;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setEventSessionTimeout(int i) {
        this.mEventSessionTimeout = i;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setExposureConfig(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig) {
        this.mExposureConfig = sAExposureConfig;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setFlushBulkSize(int i) {
        this.mFlushBulkSize = java.lang.Math.max(50, i);
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setFlushInterval(int i) {
        this.mFlushInterval = java.lang.Math.max(5000, i);
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setInstantEvents(java.util.List<java.lang.String> list) {
        this.mListInstantEvents = list;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setMaxCacheSize(long j) {
        this.mMaxCacheSize = java.lang.Math.max(16777216L, j);
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setMaxRequestInterval(int i) {
        if (i > 0) {
            this.mMaxRequestInterval = java.lang.Math.min(i, 168);
        }
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setMinRequestInterval(int i) {
        if (i > 0) {
            this.mMinRequestInterval = java.lang.Math.min(i, 168);
        }
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setNetworkTypePolicy(int i) {
        this.mNetworkTypePolicy = i;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setRemoteConfigUrl(java.lang.String str) {
        this.mRemoteConfigUrl = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        this.mSSLSocketFactory = sSLSocketFactory;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setServerUrl(java.lang.String str) {
        this.mServerUrl = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.SAConfigOptions setSourceChannels(java.lang.String... strArr) {
        this.channelSourceKeys = strArr;
        return this;
    }
}
