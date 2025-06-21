package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SASchemeHelper {
    private static final java.lang.String TAG = "SA.SASchemeUtil";

    public static void handleSchemeUrl(android.app.Activity activity, android.content.Intent intent) {
        android.net.Uri uri;
        if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.isSDKDisabled()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SDK is disabled,scan code function has been turned off");
            return;
        }
        if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance() instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SDK is not init");
            return;
        }
        if (activity == null || intent == null) {
            uri = null;
        } else {
            try {
                uri = intent.getData();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "handleSchemeUrl uri = " + uri + ", intent = " + intent);
        if (uri != null) {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
            java.lang.String host = uri.getHost();
            if (!"channeldebug".equals(host) && !"adsScanDeviceInfo".equals(host)) {
                if ("heatmap".equals(host)) {
                    com.sensorsdata.analytics.android.sdk.core.business.visual.SAVisualTools.showOpenHeatMapDialog(activity, uri.getQueryParameter("feature_code"), uri.getQueryParameter("url"));
                    intent.setData(null);
                    return;
                }
                if ("debugmode".equals(host)) {
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDebugModeSelectDialog(activity, uri.getQueryParameter("info_id"), uri.getQueryParameter("sf_push_distinct_id"), uri.getQueryParameter("project"));
                    intent.setData(null);
                    return;
                }
                if ("visualized".equals(host)) {
                    com.sensorsdata.analytics.android.sdk.core.business.visual.SAVisualTools.showOpenVisualizedAutoTrackDialog(activity, uri.getQueryParameter("feature_code"), uri.getQueryParameter("url"));
                    intent.setData(null);
                    return;
                }
                if ("popupwindow".equals(host)) {
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showPopupWindowDialog(activity, uri);
                    intent.setData(null);
                    return;
                }
                if ("encrypt".equals(host)) {
                    java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_VERIFY_SECRET_KEY, uri);
                    if (android.text.TextUtils.isEmpty(str)) {
                        str = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_encrypt_sdk_fail);
                    }
                    com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(activity, str);
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
                    intent.setData(null);
                    return;
                }
                if ("abtest".equals(host)) {
                    try {
                        com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callStaticMethod(java.lang.Class.forName("com.sensorsdata.abtest.core.SensorsABTestSchemeHandler"), "handleSchemeUrl", uri.toString());
                    } catch (java.lang.Exception e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
                    intent.setData(null);
                    return;
                }
                if ("sensorsdataremoteconfig".equals(host)) {
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().enableLog(true);
                    com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager remoteManager = sharedInstance.getSAContextManager().getRemoteManager();
                    if (remoteManager != null) {
                        remoteManager.resetPullSDKConfigTimer();
                    }
                    com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug sensorsDataRemoteManagerDebug = new com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug(sharedInstance, activity.getBaseContext());
                    sharedInstance.getSAContextManager().setRemoteManager(sensorsDataRemoteManagerDebug);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Start debugging remote config");
                    sensorsDataRemoteManagerDebug.checkRemoteConfig(uri, activity);
                    intent.setData(null);
                    return;
                }
                if (!"assistant".equals(host)) {
                    com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(activity);
                    return;
                }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions configOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions();
                if ((configOptions == null || !configOptions.isDisableDebugAssistant()) && "pairingCode".equals(uri.getQueryParameter("service"))) {
                    com.sensorsdata.analytics.android.sdk.core.business.visual.SAVisualTools.showPairingCodeInputDialog(activity);
                    return;
                }
                return;
            }
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_HANDLER_SCAN_URI, activity, uri);
            intent.setData(null);
        }
    }
}
