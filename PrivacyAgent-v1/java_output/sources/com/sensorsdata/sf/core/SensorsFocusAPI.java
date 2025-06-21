package com.sensorsdata.sf.core;

/* loaded from: classes19.dex */
public class SensorsFocusAPI implements com.sensorsdata.sf.core.ISensorsFocusAPI {
    private static final java.lang.String TAG = "SensorsFocusAPI";
    private static com.sensorsdata.sf.core.SensorsFocusAPI instance;
    com.sensorsdata.sf.core.SFContextManger mSFContextManger;

    public SensorsFocusAPI() {
    }

    private SensorsFocusAPI(android.content.Context context, com.sensorsdata.sf.core.SFConfigOptions sFConfigOptions) {
        try {
            java.lang.String apiBaseUrl = sFConfigOptions.getApiBaseUrl();
            if (apiBaseUrl == null) {
                com.sensorsdata.sf.core.utils.SFLog.e(TAG, "The baseUrl of SFConfigOptions is null.");
                return;
            }
            if (apiBaseUrl.trim().equals("")) {
                com.sensorsdata.sf.core.utils.SFLog.e(TAG, "The baseUrl of SFConfigOptions is empty.");
                return;
            }
            com.sensorsdata.sf.core.http.HttpRequestHelper.shareInstance(apiBaseUrl);
            setSFConfig(context, sFConfigOptions);
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "SF SDK init success,SFConfigOptions = " + sFConfigOptions.toString());
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void setSFConfig(android.content.Context context, com.sensorsdata.sf.core.SFConfigOptions sFConfigOptions) {
        this.mSFContextManger = com.sensorsdata.sf.core.SFContextManger.getInstance();
        if (sFConfigOptions.getSplashActivity() != null && sFConfigOptions.getSplashActivity().size() > 0) {
            sFConfigOptions.enablePopup(false);
        }
        this.mSFContextManger.setSFConfigOptions(sFConfigOptions);
        try {
            this.mSFContextManger.setContext(context.getApplicationContext());
            this.mSFContextManger.initDbAdapter();
            this.mSFContextManger.registerActivityLifecycleCallbacks();
            this.mSFContextManger.loadConfig();
            this.mSFContextManger.setSAListener();
            if (context instanceof android.app.Activity) {
                this.mSFContextManger.delayExecution((android.app.Activity) context);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public static com.sensorsdata.sf.core.ISensorsFocusAPI sharedInstance() {
        com.sensorsdata.sf.core.SensorsFocusAPI sensorsFocusAPI = instance;
        if (sensorsFocusAPI != null) {
            return sensorsFocusAPI;
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "You should call startWithConfigOptions(Context context, SFConfig sfConfig) first.");
        return new com.sensorsdata.sf.core.SensorsFocusAPIEmpty();
    }

    public static void startWithConfigOptions(android.content.Context context, com.sensorsdata.sf.core.SFConfigOptions sFConfigOptions) {
        if (context == null || sFConfigOptions == null) {
            com.sensorsdata.sf.core.utils.SFLog.e(TAG, "initialization failed, Context or SFConfigOptions is null");
        } else if (com.sensorsdata.sf.core.utils.VersionUtils.checkSAVersion() && instance == null) {
            instance = new com.sensorsdata.sf.core.SensorsFocusAPI(context, sFConfigOptions);
        }
    }

    @Override // com.sensorsdata.sf.core.ISensorsFocusAPI
    @java.lang.Deprecated
    public void enablePopup() {
        try {
            this.mSFContextManger.enablePopup();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
