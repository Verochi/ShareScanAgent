package com.sensorsdata.analytics.android.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public abstract class AbstractSAConfigOptions {
    public java.lang.String[] channelSourceKeys;
    boolean isAutoAddChannelCallbackEvent;
    boolean isAutoTrackWebView;
    boolean isWebViewSupportJellyBean;
    java.lang.String mAnonymousId;
    int mAutoTrackEventType;
    java.lang.String mCustomADChannelUrl;
    com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback mDeeplinkCallback;
    boolean mDisableDebugAssistant;
    boolean mDisableRandomTimeRequestRemoteConfig;
    boolean mEnableTrackAppCrash;
    boolean mEnableTrackPush;
    int mEventSessionTimeout;
    public com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig mExposureConfig;
    int mFlushBulkSize;
    int mFlushInterval;
    boolean mHeatMapEnabled;
    java.util.List<java.lang.Class<?>> mIgnorePageLeave;
    java.util.Map<java.lang.String, java.lang.String> mLimitKeys;
    java.util.List<java.lang.String> mListInstantEvents;
    boolean mLogEnabled;
    com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey mPersistentSecretKey;
    java.util.List<com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin> mPropertyPlugins;
    java.lang.String mRemoteConfigUrl;
    com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig mSATConfig;
    javax.net.ssl.SSLSocketFactory mSSLSocketFactory;
    java.lang.String mServerUrl;
    java.util.List<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> mStorePlugins;
    boolean mTrackScreenOrientationEnabled;
    boolean mVisualizedEnabled;
    boolean mVisualizedPropertiesEnabled;
    int mMinRequestInterval = 24;
    int mMaxRequestInterval = 48;
    long mMaxCacheSize = 33554432;
    int mNetworkTypePolicy = 31;
    boolean mEnableSaveDeepLinkInfo = false;
    boolean isSubProcessFlushData = false;
    boolean mEnableEncrypt = false;
    boolean mTransportEncrypt = false;
    boolean isDisableSDK = false;
    boolean mEnableSession = false;
    java.util.List<com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener> mEncryptors = new java.util.ArrayList();
    protected boolean mIsTrackPageLeave = false;
    protected boolean mIsTrackFragmentPageLeave = false;
    boolean mDisableDeviceId = false;
    boolean mDisableAppEndTimer = false;

    public com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig getAdvertConfig() {
        return this.mSATConfig;
    }

    public java.lang.String getAnonymousId() {
        return this.mAnonymousId;
    }

    public int getAutoTrackEventType() {
        return this.mAutoTrackEventType;
    }

    public java.lang.String getCustomADChannelUrl() {
        return this.mCustomADChannelUrl;
    }

    public com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback getDeeplinkCallback() {
        return this.mDeeplinkCallback;
    }

    public java.util.List<com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener> getEncryptors() {
        return this.mEncryptors;
    }

    public int getEventSessionTimeout() {
        return this.mEventSessionTimeout;
    }

    public int getFlushBulkSize() {
        return this.mFlushBulkSize;
    }

    public java.util.List<java.lang.Class<?>> getIgnorePageLeave() {
        return this.mIgnorePageLeave;
    }

    public java.util.List<java.lang.String> getInstantEvents() {
        return this.mListInstantEvents;
    }

    public java.util.Map<java.lang.String, java.lang.String> getLimitKeys() {
        return this.mLimitKeys;
    }

    public int getMaxRequestInterval() {
        return this.mMaxRequestInterval;
    }

    public int getMinRequestInterval() {
        return this.mMinRequestInterval;
    }

    public com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey getPersistentSecretKey() {
        return this.mPersistentSecretKey;
    }

    public java.util.List<com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin> getPropertyPlugins() {
        return this.mPropertyPlugins;
    }

    public java.lang.String getRemoteConfigUrl() {
        return this.mRemoteConfigUrl;
    }

    public javax.net.ssl.SSLSocketFactory getSSLSocketFactory() {
        return this.mSSLSocketFactory;
    }

    public java.lang.String getServerUrl() {
        return this.mServerUrl;
    }

    public java.util.List<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> getStorePlugins() {
        return this.mStorePlugins;
    }

    public boolean isAutoAddChannelCallbackEvent() {
        return this.isAutoAddChannelCallbackEvent;
    }

    public boolean isAutoTrackWebView() {
        return this.isAutoTrackWebView;
    }

    @java.lang.Deprecated
    public boolean isDataCollectEnable() {
        return true;
    }

    public boolean isDisableAppEndTimer() {
        return this.mDisableAppEndTimer;
    }

    public boolean isDisableDebugAssistant() {
        return this.mDisableDebugAssistant;
    }

    public boolean isDisableDeviceId() {
        return this.mDisableDeviceId;
    }

    public boolean isDisableRandomTimeRequestRemoteConfig() {
        return this.mDisableRandomTimeRequestRemoteConfig;
    }

    public boolean isDisableSDK() {
        return this.isDisableSDK;
    }

    public boolean isEnableEncrypt() {
        return this.mEnableEncrypt;
    }

    public boolean isEnableSession() {
        return this.mEnableSession;
    }

    public boolean isEnableTrackPush() {
        return this.mEnableTrackPush;
    }

    public boolean isMultiProcessFlush() {
        return this.isSubProcessFlushData;
    }

    public boolean isSaveDeepLinkInfo() {
        return this.mEnableSaveDeepLinkInfo;
    }

    public boolean isTrackFragmentPageLeave() {
        return this.mIsTrackPageLeave && this.mIsTrackFragmentPageLeave;
    }

    public boolean isTrackPageLeave() {
        return this.mIsTrackPageLeave;
    }

    public boolean isTransportEncrypt() {
        return this.mTransportEncrypt;
    }

    public boolean isVisualizedPropertiesEnabled() {
        return this.mVisualizedPropertiesEnabled;
    }

    public boolean isWebViewSupportJellyBean() {
        return this.isWebViewSupportJellyBean;
    }
}
