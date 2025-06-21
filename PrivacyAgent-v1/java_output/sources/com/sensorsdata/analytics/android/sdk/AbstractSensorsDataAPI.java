package com.sensorsdata.analytics.android.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public abstract class AbstractSensorsDataAPI implements com.sensorsdata.analytics.android.sdk.ISensorsDataAPI {
    protected static final java.lang.String TAG = "SA.SensorsDataAPI";
    static final java.lang.String VERSION = "6.8.0";
    protected static com.sensorsdata.analytics.android.sdk.SAConfigOptions mSAConfigOptions;
    protected static final java.util.Map<android.content.Context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI> sInstanceMap = new java.util.concurrent.ConcurrentHashMap();
    protected com.sensorsdata.analytics.android.sdk.SensorsDataDynamicSuperProperties mDynamicSuperPropertiesCallBack;
    protected java.util.List<java.lang.Integer> mHeatMapActivities;
    protected com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions mInternalConfigs;
    protected final java.lang.Object mLoginIdLock = new java.lang.Object();
    protected java.lang.String mOriginServerUrl;
    protected com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;
    protected boolean mSDKConfigInit;
    protected java.lang.String mServerUrl;
    protected com.sensorsdata.analytics.android.sdk.TrackTaskManager mTrackTaskManager;
    protected com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread mTrackTaskManagerThread;
    protected java.util.List<java.lang.Integer> mVisualizedAutoTrackActivities;

    /* renamed from: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener val$functionListener;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
            this.val$functionListener = sAFunctionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().addFunctionListener(this.val$functionListener);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener val$functionListener;

        public AnonymousClass2(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
            this.val$functionListener = sAFunctionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().removeFunctionListener(this.val$functionListener);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass3(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.util.NetworkUtils.registerNetworkListener(this.val$context);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass4(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.util.NetworkUtils.unregisterNetworkListener(this.val$context);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass5(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.this.registerObserver(this.val$context);
                com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.this.registerNetworkListener(this.val$context);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public AbstractSensorsDataAPI() {
    }

    public AbstractSensorsDataAPI(android.content.Context context, com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
        com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions = new com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions();
        this.mInternalConfigs = internalConfigOptions;
        internalConfigOptions.context = context;
        setDebugMode(debugMode);
        this.mHeatMapActivities = new java.util.ArrayList();
        this.mVisualizedAutoTrackActivities = new java.util.ArrayList();
        try {
            mSAConfigOptions = sAConfigOptions.m94clone();
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.preInit(context);
            this.mTrackTaskManager = com.sensorsdata.analytics.android.sdk.TrackTaskManager.getInstance();
            this.mTrackTaskManagerThread = new com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread();
            new java.lang.Thread(this.mTrackTaskManagerThread, com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_TASK_QUEUE).start();
            com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.init();
            initSAConfig(mSAConfigOptions.mServerUrl);
            this.mSAContextManager = new com.sensorsdata.analytics.android.sdk.core.SAContextManager((com.sensorsdata.analytics.android.sdk.SensorsDataAPI) this, this.mInternalConfigs);
            registerLifecycleCallbacks((com.sensorsdata.analytics.android.sdk.SensorsDataAPI) this, context);
            delayInitTask(context.getApplicationContext());
            com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.getInstance(context).migratingDB(context.getApplicationContext());
            enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", this.mServerUrl, java.lang.Integer.valueOf(mSAConfigOptions.mFlushInterval), debugMode));
            }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.initUniAppStatus();
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th.getMessage());
        }
    }

    public static com.sensorsdata.analytics.android.sdk.SAConfigOptions getConfigOptions() {
        return mSAConfigOptions;
    }

    private static boolean isSDKDisableByLocal() {
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions != null) {
            return sAConfigOptions.isDisableSDK;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SAConfigOptions is null");
        return true;
    }

    public static boolean isSDKDisabled() {
        return isSDKDisableByLocal() || isSDKDisabledByRemote();
    }

    private static boolean isSDKDisabledByRemote() {
        boolean isSDKDisabledByRemote = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.isSDKDisabledByRemote();
        if (isSDKDisabledByRemote) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: SDK is disabled");
        }
        return isSDKDisabledByRemote;
    }

    private void registerLifecycleCallbacks(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.content.Context context) {
        try {
            android.app.Application application = (android.app.Application) context.getApplicationContext();
            com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance());
            com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().addAppStateListener(new com.sensorsdata.analytics.android.sdk.core.business.DefaultAppState(sensorsDataAPI));
            com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().delayInit(context);
            application.registerActivityLifecycleCallbacks(com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().getCallback());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerObserver(android.content.Context context) {
        com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver sensorsDataContentObserver = new com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver();
        android.content.ContentResolver contentResolver = context.getContentResolver();
        contentResolver.registerContentObserver(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getSessionTimeUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getLoginIdUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getDisableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getEnableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getUserIdentities(), false, sensorsDataContentObserver);
    }

    public void addEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        this.mSAContextManager.addEventListener(sAEventListener);
    }

    public void addFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.AnonymousClass1(sAFunctionListener));
    }

    public void addSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
        com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.addSAJSListener(sAJSListener);
    }

    public void applySAConfigOptions() {
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.enableAppCrash();
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions.mInvokeLog) {
            enableLog(sAConfigOptions.mLogEnabled);
        }
        enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions2 = mSAConfigOptions;
        if (sAConfigOptions2.mVisualizedEnabled || !sAConfigOptions2.mVisualizedPropertiesEnabled) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The VisualizedProperties is enabled, and visualizedEnable is false");
        mSAConfigOptions.enableVisualizedAutoTrack(true);
    }

    public void delayInitTask(android.content.Context context) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.AnonymousClass5(context));
    }

    public com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode getDebugMode() {
        return this.mInternalConfigs.debugMode;
    }

    public org.json.JSONObject getDynamicProperty() {
        org.json.JSONObject jSONObject = null;
        try {
            com.sensorsdata.analytics.android.sdk.SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties = this.mDynamicSuperPropertiesCallBack;
            if (sensorsDataDynamicSuperProperties == null) {
                return null;
            }
            jSONObject = sensorsDataDynamicSuperProperties.getDynamicSuperProperties();
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(jSONObject);
            return jSONObject;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return jSONObject;
        }
    }

    public com.sensorsdata.analytics.android.sdk.core.SAContextManager getSAContextManager() {
        return this.mSAContextManager;
    }

    public void initSAConfig(java.lang.String str) {
        android.os.Bundle appInfoBundle = com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppInfoBundle(this.mInternalConfigs.context);
        if (mSAConfigOptions == null) {
            this.mSDKConfigInit = false;
            mSAConfigOptions = new com.sensorsdata.analytics.android.sdk.SAConfigOptions(str);
        } else {
            this.mSDKConfigInit = true;
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions.mInvokeLog) {
            enableLog(sAConfigOptions.mLogEnabled);
        } else {
            enableLog(appInfoBundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", this.mInternalConfigs.debugMode != com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF));
        }
        com.sensorsdata.analytics.android.sdk.SALog.setDisableSDK(mSAConfigOptions.isDisableSDK);
        setServerUrl(str);
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.enableAppCrash();
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions2 = mSAConfigOptions;
        if (sAConfigOptions2.mFlushInterval == 0) {
            sAConfigOptions2.setFlushInterval(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushInterval", 15000));
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions3 = mSAConfigOptions;
        if (sAConfigOptions3.mFlushBulkSize == 0) {
            sAConfigOptions3.setFlushBulkSize(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100));
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions4 = mSAConfigOptions;
        if (sAConfigOptions4.mMaxCacheSize == 0) {
            sAConfigOptions4.setMaxCacheSize(33554432L);
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions5 = mSAConfigOptions;
        if (!sAConfigOptions5.mInvokeHeatMapEnabled) {
            sAConfigOptions5.mHeatMapEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.HeatMap", false);
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions6 = mSAConfigOptions;
        if (!sAConfigOptions6.mInvokeVisualizedEnabled) {
            sAConfigOptions6.mVisualizedEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.VisualizedAutoTrack", false);
        }
        com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions = this.mInternalConfigs;
        internalConfigOptions.saConfigOptions = mSAConfigOptions;
        internalConfigOptions.isShowDebugView = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.ShowDebugInfoView", true);
        this.mInternalConfigs.isDefaultRemoteConfigEnable = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableDefaultRemoteConfig", false);
        com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions2 = this.mInternalConfigs;
        internalConfigOptions2.isMainProcess = com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.isMainProcess(internalConfigOptions2.context, appInfoBundle);
        this.mInternalConfigs.isTrackDeviceId = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableTrackDeviceId", false);
        if (mSAConfigOptions.getLimitKeys() != null) {
            com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.getInstance().registerLimitKeys(mSAConfigOptions.getLimitKeys());
        }
    }

    public boolean isDisableDefaultRemoteConfig() {
        return this.mInternalConfigs.isDefaultRemoteConfigEnable;
    }

    public void registerNetworkListener(android.content.Context context) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.AnonymousClass3(context));
    }

    public void removeEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        this.mSAContextManager.removeEventListener(sAEventListener);
    }

    public void removeFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.AnonymousClass2(sAFunctionListener));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void removeSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
        com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.removeSAJSListener(sAJSListener);
    }

    public void setDebugMode(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
        this.mInternalConfigs.debugMode = debugMode;
        if (debugMode == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF) {
            enableLog(false);
            com.sensorsdata.analytics.android.sdk.SALog.setDebug(false);
            this.mServerUrl = this.mOriginServerUrl;
        } else {
            enableLog(true);
            com.sensorsdata.analytics.android.sdk.SALog.setDebug(true);
            setServerUrl(this.mOriginServerUrl);
        }
    }

    public void unregisterNetworkListener(android.content.Context context) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.AnonymousClass4(context));
    }
}
