package com.sensorsdata.analytics.android.sdk.core;

/* loaded from: classes19.dex */
public class SAContextManager {
    private android.content.Context mContext;
    private java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> mEventListenerList;
    private com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay mFirstDay;
    private com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions mInternalConfigs;
    private com.sensorsdata.analytics.android.sdk.AnalyticsMessages mMessages;
    private com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector mOrientationDetector;
    private com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager mPluginManager;
    com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager mRemoteManager;
    private com.sensorsdata.analytics.android.sdk.SensorsDataAPI mSensorsDataAPI;
    private com.sensorsdata.analytics.android.sdk.core.event.EventProcessor mTrackEventProcessor;
    com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI mUserIdentityAPI;

    /* renamed from: com.sensorsdata.analytics.android.sdk.core.SAContextManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String anonymousId = com.sensorsdata.analytics.android.sdk.core.SAContextManager.this.mInternalConfigs.saConfigOptions.getAnonymousId();
            if (android.text.TextUtils.isEmpty(anonymousId)) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.core.SAContextManager.this.getUserIdentityAPI().identify(anonymousId);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.core.SAContextManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String string = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_START_DATA, "");
                if (android.text.TextUtils.isEmpty(string)) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.core.SAContextManager.this.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppStart").setProperties(com.sensorsdata.analytics.android.sdk.util.SADataHelper.appendLibMethodAutoTrack(new org.json.JSONObject(string))).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().remove(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_START_DATA);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public SAContextManager() {
    }

    public SAContextManager(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions) {
        try {
            this.mSensorsDataAPI = sensorsDataAPI;
            this.mInternalConfigs = internalConfigOptions;
            this.mContext = internalConfigOptions.context.getApplicationContext();
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance(this);
            this.mMessages = com.sensorsdata.analytics.android.sdk.AnalyticsMessages.getInstance(this.mContext, sensorsDataAPI, this.mInternalConfigs);
            this.mTrackEventProcessor = new com.sensorsdata.analytics.android.sdk.core.event.TrackEventProcessor(this);
            this.mFirstDay = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstDayPst();
            this.mPluginManager = new com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager(sensorsDataAPI, this);
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().registerPlugins(this.mInternalConfigs.saConfigOptions.getStorePlugins(), this.mContext);
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().upgrade();
            executeDelayTask();
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().installService(this);
            com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager sensorsDataRemoteManager = new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager(sensorsDataAPI, this);
            this.mRemoteManager = sensorsDataRemoteManager;
            sensorsDataRemoteManager.applySDKConfigFromCache();
            internalConfigOptions.context = this.mContext;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void checkAppStart() {
        if (com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().isExists(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_START_DATA) && com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_START)) {
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.core.SAContextManager.AnonymousClass2());
        }
    }

    private void executeDelayTask() {
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.core.SAContextManager.AnonymousClass1());
    }

    public void addEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        try {
            if (this.mEventListenerList == null) {
                this.mEventListenerList = new java.util.ArrayList();
            }
            this.mEventListenerList.add(sAEventListener);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public com.sensorsdata.analytics.android.sdk.AnalyticsMessages getAnalyticsMessages() {
        return this.mMessages;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> getEventListenerList() {
        return this.mEventListenerList;
    }

    public com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions getInternalConfigs() {
        return this.mInternalConfigs;
    }

    public com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector getOrientationDetector() {
        return this.mOrientationDetector;
    }

    public com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager getPluginManager() {
        return this.mPluginManager;
    }

    public com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager getRemoteManager() {
        return this.mRemoteManager;
    }

    public com.sensorsdata.analytics.android.sdk.SensorsDataAPI getSensorsDataAPI() {
        return this.mSensorsDataAPI;
    }

    public synchronized com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI getUserIdentityAPI() {
        if (this.mUserIdentityAPI == null) {
            this.mUserIdentityAPI = new com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI(this);
        }
        return this.mUserIdentityAPI;
    }

    public boolean isFirstDay(long j) {
        java.lang.String str = this.mFirstDay.get();
        if (str == null) {
            this.mFirstDay.commit(com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd"));
            return true;
        }
        try {
            return str.equals(com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatTime(j, "yyyy-MM-dd"));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    public void removeEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        try {
            java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> list = this.mEventListenerList;
            if (list == null || !list.contains(sAEventListener)) {
                return;
            }
            this.mEventListenerList.remove(sAEventListener);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void setOrientationDetector(com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector) {
        this.mOrientationDetector = sensorsDataScreenOrientationDetector;
    }

    public void setRemoteManager(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        this.mRemoteManager = baseSensorsDataSDKRemoteManager;
    }

    public void trackEvent(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
            checkAppStart();
            this.mTrackEventProcessor.trackEvent(inputData);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
