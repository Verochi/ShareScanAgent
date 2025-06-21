package com.sensorsdata.analytics.android.sdk.visual.bridge;

/* loaded from: classes19.dex */
public class JSBridgeHelper implements com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge {
    private static final java.lang.String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    private static final java.lang.String CALL_TYPE_GET_VISUAL_PROPERTIES = "getJSVisualProperties";
    private java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback> mCallbacks = new java.util.HashMap();
    private com.sensorsdata.analytics.android.sdk.listener.SAJSListener mSAJSListener;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.listener.SAJSListener {
        public AnonymousClass1() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAJSListener
        public void onReceiveJSMessage(java.lang.ref.WeakReference<android.view.View> weakReference, java.lang.String str) {
            com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback onBridgeCallback;
            org.json.JSONObject optJSONObject;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper.CALL_TYPE_GET_VISUAL_PROPERTIES, jSONObject.optString("callType"))) {
                    java.lang.String optString = jSONObject.optString("message_id");
                    if (android.text.TextUtils.isEmpty(optString) || (onBridgeCallback = (com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback) com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper.this.mCallbacks.remove(optString)) == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                        return;
                    }
                    onBridgeCallback.onCallBack(optJSONObject.toString());
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$methodName;
        final /* synthetic */ org.json.JSONObject val$obj;
        final /* synthetic */ android.view.View val$webView;

        public AnonymousClass2(java.lang.String str, org.json.JSONObject jSONObject, android.view.View view) {
            this.val$methodName = str;
            this.val$obj = jSONObject;
            this.val$webView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str = "'" + this.val$methodName + "','" + android.util.Base64.encodeToString(this.val$obj.toString().getBytes(), 0) + "'";
            com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper.invokeWebViewLoad(this.val$webView, "loadUrl", new java.lang.Object[]{"javascript:window.sensorsdata_app_call_js(" + str + ")"}, new java.lang.Class[]{java.lang.String.class});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeWebViewLoad(android.view.View view, java.lang.String str, java.lang.Object[] objArr, java.lang.Class[] clsArr) {
        try {
            view.getClass().getMethod(str, clsArr).invoke(view, objArr);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void addSAJSListener() {
        if (this.mSAJSListener == null) {
            this.mSAJSListener = new com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper.AnonymousClass1();
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().addSAJSListener(this.mSAJSListener);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge
    public void sendToWeb(android.view.View view, java.lang.String str, java.lang.Object obj) {
        sendToWeb(view, str, obj, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    @Override // com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void sendToWeb(android.view.View view, java.lang.String str, java.lang.Object obj, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback onBridgeCallback) {
        org.json.JSONObject jSONObject;
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.visual.bridge.JSRequest jSRequest = new com.sensorsdata.analytics.android.sdk.visual.bridge.JSRequest();
        jSRequest.methodName = str;
        if (onBridgeCallback != null) {
            java.lang.String format = java.lang.String.format(CALLBACK_ID_FORMAT, java.lang.Long.valueOf(android.os.SystemClock.currentThreadTimeMillis()));
            this.mCallbacks.put(format, onBridgeCallback);
            jSRequest.messageId = format;
        }
        if (obj instanceof java.lang.String) {
            if (!android.text.TextUtils.isEmpty((java.lang.String) obj)) {
                jSONObject = new org.json.JSONObject((java.lang.String) obj);
                if (jSONObject != null) {
                    return;
                }
                if (view != null) {
                    view.post(new com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper.AnonymousClass2(str, jSONObject, view));
                }
                return;
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
        } else {
            if (obj instanceof org.json.JSONObject) {
                jSONObject = new org.json.JSONObject();
                jSONObject.put("message_id", jSRequest.messageId);
                jSONObject.put("platform", "Android");
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) obj, jSONObject);
                if (jSONObject != null) {
                }
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
        }
    }
}
