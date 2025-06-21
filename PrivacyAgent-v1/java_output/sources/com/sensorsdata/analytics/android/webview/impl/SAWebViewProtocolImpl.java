package com.sensorsdata.analytics.android.webview.impl;

/* loaded from: classes19.dex */
public class SAWebViewProtocolImpl {
    private static final java.lang.String TAG = "SA.WebViewProtocolImpl";
    private final java.lang.String JS_BRIDGE = "SensorsData_APP_JS_Bridge";
    private final android.content.Context mContext;

    public SAWebViewProtocolImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mContext = sAContextManager.getContext();
    }

    private void showUpWebView(android.webkit.WebView webView, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new com.sensorsdata.analytics.android.sdk.jsbridge.AppWebViewInterface(this.mContext, jSONObject, z2, webView), "SensorsData_APP_JS_Bridge");
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, webView);
        }
    }

    private void showUpX5WebView(java.lang.Object obj, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        if (obj == null) {
            return;
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod("addJavascriptInterface", java.lang.Object.class, java.lang.String.class);
            if (method == null) {
                return;
            }
            method.invoke(obj, new com.sensorsdata.analytics.android.sdk.jsbridge.AppWebViewInterface(this.mContext, jSONObject, z2), "SensorsData_APP_JS_Bridge");
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, obj);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        str.hashCode();
        if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.METHOD_SHOWUP_X5WEBVIEW)) {
            showUpX5WebView(objArr[0], (org.json.JSONObject) objArr[1], ((java.lang.Boolean) objArr[2]).booleanValue(), ((java.lang.Boolean) objArr[3]).booleanValue());
            return null;
        }
        if (!str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.METHOD_SHOWUP_WEBVIEW)) {
            return null;
        }
        showUpWebView((android.webkit.WebView) objArr[0], (org.json.JSONObject) objArr[1], ((java.lang.Boolean) objArr[2]).booleanValue(), ((java.lang.Boolean) objArr[3]).booleanValue());
        return null;
    }
}
