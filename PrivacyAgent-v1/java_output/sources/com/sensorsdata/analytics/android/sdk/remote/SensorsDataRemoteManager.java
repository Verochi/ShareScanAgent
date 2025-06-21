package com.sensorsdata.analytics.android.sdk.remote;

/* loaded from: classes19.dex */
public class SensorsDataRemoteManager extends com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager {
    private static final java.lang.String SHARED_PREF_REQUEST_TIME = "sensorsdata.request.time";
    private static final java.lang.String SHARED_PREF_REQUEST_TIME_RANDOM = "sensorsdata.request.time.random";
    private static final java.lang.String TAG = "SA.SensorsDataRemoteManager";
    private volatile boolean mIsInit;
    private volatile android.os.CountDownTimer mPullSDKConfigCountDownTimer;
    private final com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager mStorageManager;

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ boolean val$enableConfigV;

        public AnonymousClass1(boolean z) {
            this.val$enableConfigV = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.pullSDKConfigCount(this.val$enableConfigV);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.CountDownTimer {
        final /* synthetic */ boolean val$enableConfigV;

        /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.StringCallback {
            public AnonymousClass1() {
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onAfter() {
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onFailure(int i, java.lang.String str) {
                if (i == 304 || i == 404) {
                    com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.TAG, "Remote request failed,responseCode is " + i + ",errorMessage is " + str);
            }

            @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
            public void onResponse(java.lang.String str) {
                com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                if (!android.text.TextUtils.isEmpty(str)) {
                    com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sDKRemoteConfig = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.toSDKRemoteConfig(str);
                    com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_STORE_SECRET_KEY, str);
                    if (com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().isRemoteConfigEnabled) {
                        com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.setSDKRemoteConfig(sDKRemoteConfig);
                    }
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.TAG, "Remote request was successful,response data is " + str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2, boolean z) {
            super(j, j2);
            this.val$enableConfigV = z;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.mSensorsDataAPI;
            if ((sensorsDataAPI == null || sensorsDataAPI.isNetworkRequestEnable()) && !com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().saConfigOptions.isDisableSDK() && (com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().isRemoteConfigEnabled || com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.mContextManager.getInternalConfigs().saConfigOptions.isEnableEncrypt())) {
                com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.requestRemoteConfig(this.val$enableConfigV, new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass2.AnonymousClass1());
            } else {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.TAG, "Close network request or sdk is disable");
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$eventProperties;

        public AnonymousClass3(org.json.JSONObject jSONObject) {
            this.val$eventProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.this.mContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppRemoteConfigChanged").setProperties(this.val$eventProperties).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType;

        static {
            int[] iArr = new int[com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.values().length];
            $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType = iArr;
            try {
                iArr[com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType[com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public SensorsDataRemoteManager(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        super(sensorsDataAPI, sAContextManager);
        this.mIsInit = true;
        this.mStorageManager = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Construct a SensorsDataRemoteManager");
    }

    private void cleanRemoteRequestRandomTime() {
        this.mStorageManager.remove(SHARED_PREF_REQUEST_TIME);
        this.mStorageManager.remove(SHARED_PREF_REQUEST_TIME_RANDOM);
    }

    private boolean isRequestValid() {
        try {
            long longValue = this.mStorageManager.getLong(SHARED_PREF_REQUEST_TIME, 0L).longValue();
            int integer = this.mStorageManager.getInteger(SHARED_PREF_REQUEST_TIME_RANDOM, 0);
            if (longValue == 0 || integer == 0) {
                return true;
            }
            float elapsedRealtime = android.os.SystemClock.elapsedRealtime() - longValue;
            return elapsedRealtime <= 0.0f || elapsedRealtime / 1000.0f >= ((float) (integer * com.anythink.expressad.d.a.b.ck));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pullSDKConfigCount(boolean z) {
        if (this.mPullSDKConfigCountDownTimer != null) {
            this.mPullSDKConfigCountDownTimer.cancel();
            this.mPullSDKConfigCountDownTimer = null;
        }
        this.mPullSDKConfigCountDownTimer = new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass2(90000L, 30000L, z);
        this.mPullSDKConfigCountDownTimer.start();
    }

    private void writeRemoteRequestRandomTime() {
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = this.mContextManager.getInternalConfigs().saConfigOptions;
        if (sAConfigOptions == null || !this.mContextManager.getInternalConfigs().isRemoteConfigEnabled) {
            return;
        }
        int minRequestInterval = sAConfigOptions.getMinRequestInterval();
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (sAConfigOptions.getMaxRequestInterval() > sAConfigOptions.getMinRequestInterval()) {
            minRequestInterval += new java.security.SecureRandom().nextInt((sAConfigOptions.getMaxRequestInterval() - sAConfigOptions.getMinRequestInterval()) + 1);
        }
        this.mStorageManager.setLong(SHARED_PREF_REQUEST_TIME, elapsedRealtime);
        this.mStorageManager.setInteger(SHARED_PREF_REQUEST_TIME_RANDOM, minRequestInterval);
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void applySDKConfigFromCache() {
        java.lang.String remoteConfig;
        try {
            if (this.mIsInit) {
                remoteConfig = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getRemoteConfigFromLocal();
                this.mIsInit = false;
            } else {
                remoteConfig = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getRemoteConfig();
            }
            com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sDKRemoteConfig = toSDKRemoteConfig(remoteConfig);
            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Cache remote config is " + sDKRemoteConfig.toString());
            }
            if (this.mSensorsDataAPI != null) {
                if (sDKRemoteConfig.isDisableDebugMode()) {
                    this.mSensorsDataAPI.setDebugMode(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Set DebugOff Mode");
                }
                if (sDKRemoteConfig.isDisableSDK()) {
                    try {
                        this.mContextManager.getAnalyticsMessages().flush();
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "DisableSDK is true");
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            }
            com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sDKRemoteConfig;
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void pullSDKConfigFromServer() {
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = this.mContextManager.getInternalConfigs().saConfigOptions;
        if (sAConfigOptions == null || sAConfigOptions.isDisableSDK()) {
            return;
        }
        if (this.mContextManager.getInternalConfigs().isRemoteConfigEnabled || this.mContextManager.getInternalConfigs().saConfigOptions.isEnableEncrypt()) {
            if (sAConfigOptions.isDisableRandomTimeRequestRemoteConfig() || sAConfigOptions.getMinRequestInterval() > sAConfigOptions.getMaxRequestInterval()) {
                requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean, true);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Request remote config because disableRandomTimeRequestRemoteConfig or minHourInterval greater than maxHourInterval");
            } else if (!isSecretKeyValid()) {
                requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Request remote config because encrypt key is null");
            } else if (isRequestValid()) {
                requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, true);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: Request remote config because satisfy the random request condition");
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z) {
        if (this.mDisableDefaultRemoteConfig) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "disableDefaultRemoteConfig is true");
            return;
        }
        int i = com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass4.$SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType[randomTimeType.ordinal()];
        if (i == 1) {
            writeRemoteRequestRandomTime();
        } else if (i == 2) {
            cleanRemoteRequestRandomTime();
        }
        com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().post(new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass1(z));
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void resetPullSDKConfigTimer() {
        try {
            try {
                if (this.mPullSDKConfigCountDownTimer != null) {
                    this.mPullSDKConfigCountDownTimer.cancel();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        } finally {
            this.mPullSDKConfigCountDownTimer = null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager
    public void setSDKRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.String jSONObject2 = sensorsDataSDKRemoteConfig.toJson().toString();
            jSONObject.put("$app_remote_config", jSONObject2);
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass3(jSONObject));
            this.mContextManager.getAnalyticsMessages().flush();
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitRemoteConfig(jSONObject2);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Save remote data");
            if (1 == sensorsDataSDKRemoteConfig.getEffectMode()) {
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sensorsDataSDKRemoteConfig;
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The remote configuration takes effect immediately");
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
