package com.sensorsdata.analytics.android.sdk.jsbridge;

/* loaded from: classes19.dex */
public class AppWebViewInterface {
    private static final java.lang.String TAG = "SA.AppWebViewInterface";
    private final boolean enableVerify;
    private final android.content.Context mContext;
    private java.lang.ref.WeakReference<android.view.View> mWebView;
    private org.json.JSONObject properties;

    public AppWebViewInterface(android.content.Context context, org.json.JSONObject jSONObject, boolean z) {
        this(context, jSONObject, z, null);
    }

    public AppWebViewInterface(android.content.Context context, org.json.JSONObject jSONObject, boolean z, android.view.View view) {
        this.mContext = context;
        this.properties = jSONObject;
        this.enableVerify = z;
        if (view != null) {
            this.mWebView = new java.lang.ref.WeakReference<>(view);
        }
    }

    @android.webkit.JavascriptInterface
    public boolean sensorsdata_abtest_module() {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_abtest_module");
            return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callStaticMethod(com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(new java.lang.String[]{"com.sensorsdata.abtest.SensorsABTest"}), "shareInstance", new java.lang.Object[0]) != null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String sensorsdata_call_app() {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_call_app");
            if (this.properties == null) {
                this.properties = new org.json.JSONObject();
            }
            this.properties.put("type", "Android");
            java.lang.String loginId = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(this.mContext).getLoginId();
            if (android.text.TextUtils.isEmpty(loginId)) {
                this.properties.put("distinct_id", com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(this.mContext).getAnonymousId());
                this.properties.put("is_login", false);
            } else {
                this.properties.put("distinct_id", loginId);
                this.properties.put("is_login", true);
            }
            return this.properties.toString();
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e.getMessage());
            return null;
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String sensorsdata_get_app_visual_config() {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_get_app_visual_config");
            return (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_H5_GET_APPVISUAL_CONFIG, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String sensorsdata_get_server_url() {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_get_server_url");
            return com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isAutoTrackWebView() ? com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getServerUrl() : "";
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @android.webkit.JavascriptInterface
    public void sensorsdata_js_call_app(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_js_call_app, content = " + str);
            java.lang.ref.WeakReference<android.view.View> weakReference = this.mWebView;
            if (weakReference != null) {
                com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.handleJsMessage(weakReference, str);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @android.webkit.JavascriptInterface
    public void sensorsdata_track(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_track event = " + str);
            com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.trackEventFromH5(str, this.enableVerify);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_track event = exception = " + str);
        }
    }

    @android.webkit.JavascriptInterface
    public boolean sensorsdata_verify(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_verify event = " + str + ", enableVerify = " + this.enableVerify);
            if (this.enableVerify) {
                return com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.verifyEventFromH5(str);
            }
            sensorsdata_track(str);
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sensorsdata_verify return false,exception = " + e.getMessage());
            return false;
        }
    }

    @android.webkit.JavascriptInterface
    public boolean sensorsdata_visual_verify(java.lang.String str) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (!this.enableVerify) {
            return true;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String optString = new org.json.JSONObject(str).optString("server_url");
        if (!android.text.TextUtils.isEmpty(optString)) {
            return new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(optString).check(new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getServerUrl()));
        }
        return false;
    }
}
