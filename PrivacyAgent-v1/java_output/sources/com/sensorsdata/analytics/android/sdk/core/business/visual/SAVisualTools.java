package com.sensorsdata.analytics.android.sdk.core.business.visual;

/* loaded from: classes19.dex */
public class SAVisualTools {
    private static boolean checkProjectIsValid(java.lang.String str) {
        android.net.Uri parse;
        android.net.Uri parse2;
        java.lang.String serverUrl = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl();
        java.lang.String str2 = null;
        java.lang.String queryParameter = (android.text.TextUtils.isEmpty(str) || (parse2 = android.net.Uri.parse(str)) == null) ? null : parse2.getQueryParameter("project");
        if (!android.text.TextUtils.isEmpty(serverUrl) && (parse = android.net.Uri.parse(serverUrl)) != null) {
            str2 = parse.getQueryParameter("project");
        }
        return (android.text.TextUtils.isEmpty(queryParameter) || android.text.TextUtils.isEmpty(str2) || !android.text.TextUtils.equals(queryParameter, str2)) ? false : true;
    }

    public static void showOpenHeatMapDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        if (!checkProjectIsValid(str2)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_visual_dialog_error));
            return;
        }
        if (!com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().hasModuleByName(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_heatmap_sdk_fail));
            return;
        }
        if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_heatmap_network_fail));
        } else if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isHeatMapEnabled()) {
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SHOW_OPEN_HEATMAP_DIALOG, activity, str, str2);
        } else {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_heatmap_sdk_fail));
        }
    }

    public static void showOpenVisualizedAutoTrackDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        if (!checkProjectIsValid(str2)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_visual_dialog_error));
            return;
        }
        if (!com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().hasModuleByName(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME)) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_visual_sdk_fail));
            return;
        }
        if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_visual_network_fail));
        } else if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) {
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SHOW_OPEN_VISUALIZED_AUTOTRACK_DIALOG, activity, str, str2);
        } else {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_visual_sdk_fail));
        }
    }

    public static void showPairingCodeInputDialog(android.content.Context context) {
        if (com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().hasModuleByName(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME)) {
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SHOW_PAIRING_CODE_INPUTDIALOG, context);
        } else {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(context, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_visual_heatmap_sdk_fail));
        }
    }
}
