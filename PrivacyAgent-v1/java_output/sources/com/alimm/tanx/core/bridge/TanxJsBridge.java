package com.alimm.tanx.core.bridge;

/* loaded from: classes.dex */
public class TanxJsBridge implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "TanxJsBridge";
    android.content.Context context;
    private final android.webkit.WebView webView;
    private java.lang.Integer uniqueId = 0;
    public java.util.HashMap<java.lang.String, com.alimm.tanx.core.bridge.Callback> responseCallbacks = new java.util.HashMap<>();
    public java.util.HashMap<java.lang.String, com.alimm.tanx.core.bridge.JsHandler> messageHandlers = new java.util.HashMap<>();

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    public TanxJsBridge(android.content.Context context, android.webkit.WebView webView) {
        this.context = context;
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.addJavascriptInterface(this, "normal");
    }

    private void dispatch(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        boolean z = true;
        java.lang.String format = java.lang.String.format("MamaBridge.handleMessageFromNative('%s');", new com.alibaba.fastjson.JSONObject(hashMap).toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029"));
        try {
            try {
                if (com.alimm.tanx.core.ad.base.tanxc_if.tanxc_if(this.webView)) {
                    com.alimm.tanx.core.utils.LogUtils.e(TAG, "webView已经回收，无法分发数据，终止！！！！");
                    z = false;
                } else {
                    this.webView.post(new defpackage.g03(this, format));
                }
                if (z) {
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            }
        } finally {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "jsBridge dispatch failed");
        }
    }

    private void flush(java.lang.String str) {
        if (str == null) {
            java.lang.System.out.println("Javascript give data is null");
            return;
        }
        java.util.HashMap hashMap = (java.util.HashMap) com.alibaba.fastjson.JSON.parseObject(str, java.util.HashMap.class);
        java.lang.String str2 = (java.lang.String) hashMap.get("callbackId");
        com.alimm.tanx.core.bridge.Callback e03Var = str2 != null ? new defpackage.e03(this, str2) : new defpackage.f03();
        com.alimm.tanx.core.utils.LogUtils.d(TAG, str);
        java.lang.String str3 = (java.lang.String) hashMap.get("handlerName");
        com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) hashMap.get("data");
        com.alimm.tanx.core.bridge.JsHandler jsHandler = this.messageHandlers.get(str3);
        if (jsHandler == null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "jsHandler is null");
            e03Var.call(false, null);
            return;
        }
        try {
            java.util.HashMap hashMap2 = new java.util.HashMap();
            if (jSONObject != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : jSONObject.entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            jsHandler.handler(hashMap2, e03Var);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private java.lang.String getFromAssets(android.content.Context context, java.lang.String str) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(context).open(str)));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatch$4(java.lang.String str) {
        this.webView.evaluateJavascript(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flush$2(java.lang.String str, boolean z, java.util.AbstractMap abstractMap) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("responseId", str);
        hashMap.put("responseData", abstractMap);
        hashMap.put("success", java.lang.Boolean.valueOf(z));
        dispatch(hashMap);
    }

    public void call(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap, com.alimm.tanx.core.bridge.Callback callback) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = new java.util.HashMap<>();
        hashMap2.put("handlerName", str);
        if (hashMap != null) {
            hashMap2.put("data", hashMap);
        }
        if (callback != null) {
            this.uniqueId = java.lang.Integer.valueOf(this.uniqueId.intValue() + 1);
            java.lang.String str2 = "native_cb_" + this.uniqueId;
            this.responseCallbacks.put(str2, callback);
            hashMap2.put("callbackId", str2);
        }
        dispatch(hashMap2);
    }

    public void injectJavascript() {
        java.lang.String fromAssets = getFromAssets(this.context, "mama.js");
        android.webkit.WebView webView = this.webView;
        java.lang.String str = "javascript:" + fromAssets;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
        webView.loadUrl(str);
    }

    public void postEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("eventName", str);
        hashMap.put("eventData", map);
        dispatch(hashMap);
    }

    @android.webkit.JavascriptInterface
    public void postMessage(java.lang.String str) {
        flush(str);
    }

    public void ready() {
    }

    public void register(java.lang.String str, com.alimm.tanx.core.bridge.JsHandler jsHandler) {
        this.messageHandlers.put(str, jsHandler);
    }

    public void remove(java.lang.String str) {
        this.messageHandlers.remove(str);
    }
}
