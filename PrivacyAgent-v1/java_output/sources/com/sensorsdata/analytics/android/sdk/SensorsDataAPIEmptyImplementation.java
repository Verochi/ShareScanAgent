package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class SensorsDataAPIEmptyImplementation extends com.sensorsdata.analytics.android.sdk.SensorsDataAPI {

    public static class EmptySAContext extends com.sensorsdata.analytics.android.sdk.core.SAContextManager {
        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public void addEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public com.sensorsdata.analytics.android.sdk.AnalyticsMessages getAnalyticsMessages() {
            return null;
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public android.content.Context getContext() {
            return null;
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> getEventListenerList() {
            return new java.util.ArrayList();
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions getInternalConfigs() {
            return new com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions();
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector getOrientationDetector() {
            return null;
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager getPluginManager() {
            return null;
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager getRemoteManager() {
            return null;
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public com.sensorsdata.analytics.android.sdk.SensorsDataAPI getSensorsDataAPI() {
            return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public synchronized com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI getUserIdentityAPI() {
            return new com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI(this);
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public boolean isFirstDay(long j) {
            return false;
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public void removeEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public void setOrientationDetector(com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector) {
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public void setRemoteManager(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.SAContextManager
        public void trackEvent(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        }
    }

    public SensorsDataAPIEmptyImplementation() {
        this.mSAContextManager = new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation.EmptySAContext();
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public void addEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void addExposureView(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public void addFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addHeatMapActivities(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addHeatMapActivity(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public void addSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addVisualizedAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addVisualizedAutoTrackActivity(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void clearGPSLocation() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void clearLastScreenUrl() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void clearReferrerWhenAppEnd() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void clearSuperProperties() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void clearTrackTimer() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void deleteAll() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void disableAutoTrack(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void disableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void enableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragment(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void enableDeepLinkInstallSource(boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableLog(boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableNetworkRequest(boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableRemoteConfig(boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableTrackScreenOrientation(boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void flush() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void flushScheduled() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void flushSync() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getAnonymousId() {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String getCookie(boolean z) {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getDistinctId() {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public int getFlushBulkSize() {
        return 100;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public int getFlushInterval() {
        return 15000;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public org.json.JSONObject getIdentities() {
        return new org.json.JSONObject();
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public java.util.List<java.lang.Class<?>> getIgnoredViewTypeList() {
        return new java.util.ArrayList();
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public org.json.JSONObject getLastScreenTrackProperties() {
        return new org.json.JSONObject();
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public java.lang.String getLastScreenUrl() {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getLoginId() {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public long getMaxCacheSize() {
        return 33554432L;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public org.json.JSONObject getPresetProperties() {
        return new org.json.JSONObject();
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String getScreenOrientation() {
        return "";
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String getServerUrl() {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public int getSessionIntervalTime() {
        return 30000;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public org.json.JSONObject getSuperProperties() {
        return new org.json.JSONObject();
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void identify(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreAutoTrackActivity(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragment(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreView(android.view.View view) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreView(android.view.View view, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreViewType(java.lang.Class cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isActivityAutoTrackAppClickIgnored(java.lang.Class<?> cls) {
        return true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isActivityAutoTrackAppViewScreenIgnored(java.lang.Class<?> cls) {
        return true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEnabled() {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEventTypeIgnored(int i) {
        return true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        return true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isDebugMode() {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isFragmentAutoTrackAppViewScreen(java.lang.Class<?> cls) {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isHeatMapActivity(java.lang.Class<?> cls) {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isHeatMapEnabled() {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isNetworkRequestEnable() {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isTrackFragmentAppViewScreenEnabled() {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isVisualizedAutoTrackActivity(java.lang.Class<?> cls) {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isVisualizedAutoTrackEnabled() {
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void itemDelete(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void itemSet(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void login(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void login(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void loginWithKey(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void loginWithKey(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void logout() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileAppend(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileAppend(java.lang.String str, java.util.Set<java.lang.String> set) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileDelete() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileIncrement(java.lang.String str, java.lang.Number number) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileIncrement(java.util.Map<java.lang.String, ? extends java.lang.Number> map) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profilePushId(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSet(java.lang.String str, java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSet(org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSetOnce(java.lang.String str, java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSetOnce(org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileUnset(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileUnsetPushId(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerDynamicSuperProperties(com.sensorsdata.analytics.android.sdk.SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerLimitKeys(java.util.Map<java.lang.String, java.lang.String> map) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerSuperProperties(org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public void removeEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void removeExposureView(android.view.View view) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void removeExposureView(android.view.View view, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public void removeFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void removeTimer(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void requestDeferredDeepLink(org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void resetAnonymousId() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void resumeAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void resumeAutoTrackActivity(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragment(java.lang.Class<?> cls) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void resumeTrackScreenOrientation() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setCookie(java.lang.String str, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public void setDebugMode(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void setDeepLinkCallback(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void setDeepLinkCompletion(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void setExposureIdentifier(android.view.View view, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setFlushBulkSize(int i) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setFlushInterval(int i) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setFlushNetworkPolicy(int i) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setGPSLocation(double d, double d2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setGPSLocation(double d, double d2, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setMaxCacheSize(long j) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setServerUrl(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setServerUrl(java.lang.String str, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setSessionIntervalTime(int i) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setTrackEventCallBack(com.sensorsdata.analytics.android.sdk.SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewActivity(android.view.View view, android.app.Activity activity) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewFragmentName(android.view.View view, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(android.app.Dialog dialog, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(android.view.View view, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewProperties(android.view.View view, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void showUpWebView(android.webkit.WebView webView, org.json.JSONObject jSONObject, boolean z, boolean z2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpWebView(android.webkit.WebView webView, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void showUpWebView(android.webkit.WebView webView, boolean z, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpWebView(android.webkit.WebView webView, boolean z, boolean z2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpX5WebView(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void showUpX5WebView(java.lang.Object obj, org.json.JSONObject jSONObject, boolean z, boolean z2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpX5WebView(java.lang.Object obj, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void startTrackThread() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void stopTrackScreenOrientation() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void stopTrackThread() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void track(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void track(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackAppInstall() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackAppInstall(org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackAppInstall(org.json.JSONObject jSONObject, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackChannelEvent(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackChannelEvent(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackDeepLinkLaunch(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackDeepLinkLaunch(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void trackFragmentAppViewScreen() {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackInstallation(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject, boolean z) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void trackTimer(java.lang.String str, java.util.concurrent.TimeUnit timeUnit) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerEnd(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerEnd(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerPause(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerResume(java.lang.String str) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String trackTimerStart(java.lang.String str) {
        return "";
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewAppClick(android.view.View view) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewAppClick(android.view.View view, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(android.app.Activity activity) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void unregisterPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.SensorsDataAPI, com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void unregisterSuperProperty(java.lang.String str) {
    }
}
