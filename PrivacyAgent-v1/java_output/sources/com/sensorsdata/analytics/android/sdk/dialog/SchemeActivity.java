package com.sensorsdata.analytics.android.sdk.dialog;

/* loaded from: classes19.dex */
public class SchemeActivity extends android.app.Activity {
    public static final java.lang.String SCHEME_ACTIVITY_SIGN = "#*#scheme_activity_sign#*#";
    private static final java.lang.String TAG = "SA.SchemeActivity";
    public static boolean isPopWindow;
    private boolean isStartApp = false;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onCreate");
        try {
            requestWindowFeature(1);
            setTheme(android.R.style.Theme.DeviceDefault.Light);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance() instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onCreate SensorsDataAPIEmptyImplementation");
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this);
        } else {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onCreate handleSchemeUrl");
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.handleSchemeUrl(this, getIntent());
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNewIntent intent = " + intent);
            if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance() instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNewIntent SensorsDataAPIEmptyImplementation");
                com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this);
            } else {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNewIntent handleSchemeUrl");
                com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.handleSchemeUrl(this, getIntent());
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onPause");
        if (isPopWindow) {
            isPopWindow = false;
            this.isStartApp = true;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onResume");
        if (this.isStartApp) {
            this.isStartApp = false;
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this);
        }
    }
}
