package com.sensorsdata.analytics.android.sdk.jsbridge;

/* loaded from: classes19.dex */
public class JSHookAop {
    private static final java.lang.String TAG = "SA.JSHookAop";

    private static boolean isSupportJellyBean() {
        return true;
    }

    public static void loadData(android.view.View view, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (view == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadDataWithBaseURL(android.view.View view, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        if (view == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadUrl(android.view.View view, java.lang.String str) {
        if (view == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadUrl(android.view.View view, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (view == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void postUrl(android.view.View view, java.lang.String str, byte[] bArr) {
        if (view == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    private static void setupH5Bridge(android.view.View view) {
        if (isSupportJellyBean() && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions() != null && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isAutoTrackWebView()) {
            setupWebView(view);
        }
        if (isSupportJellyBean()) {
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, view);
        }
    }

    private static void setupWebView(android.view.View view) {
        if (view != null) {
            int i = com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_webview;
            if (view.getTag(i) == null) {
                view.setTag(i, new java.lang.Object());
                com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.addJavascriptInterface(view, new com.sensorsdata.analytics.android.sdk.jsbridge.AppWebViewInterface(view.getContext().getApplicationContext(), null, false, view), "SensorsData_APP_New_H5_Bridge");
            }
        }
    }
}
