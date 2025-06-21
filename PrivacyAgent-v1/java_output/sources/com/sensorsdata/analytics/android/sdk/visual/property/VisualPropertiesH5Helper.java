package com.sensorsdata.analytics.android.sdk.visual.property;

/* loaded from: classes19.dex */
public class VisualPropertiesH5Helper implements com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge {
    private com.sensorsdata.analytics.android.sdk.listener.SAEventListener mSAEventListener;
    private android.util.SparseArray<org.json.JSONArray> mSparseArray = new android.util.SparseArray<>();
    private com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper mJSBridgeHelper = new com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper();

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback {
        final /* synthetic */ java.util.concurrent.CountDownLatch val$latch;
        final /* synthetic */ org.json.JSONObject val$srcObject;

        public AnonymousClass1(org.json.JSONObject jSONObject, java.util.concurrent.CountDownLatch countDownLatch) {
            this.val$srcObject = jSONObject;
            this.val$latch = countDownLatch;
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback
        public void onCallBack(java.lang.String str) {
            try {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        java.lang.String optString = jSONObject.optString(next);
                        if (!android.text.TextUtils.isEmpty(next)) {
                            this.val$srcObject.put(next, optString);
                        }
                    }
                } catch (org.json.JSONException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            } finally {
                this.val$latch.countDown();
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper$2, reason: invalid class name */
    public class AnonymousClass2 implements com.sensorsdata.analytics.android.sdk.listener.SAEventListener {
        public AnonymousClass2() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAEventListener
        public void identify() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAEventListener
        public void login() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAEventListener
        public void logout() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAEventListener
        public void resetAnonymousId() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAEventListener
        public void trackEvent(org.json.JSONObject jSONObject) {
            org.json.JSONObject optJSONObject;
            try {
                if (android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.WEB_CLICK_EVENT_NAME, jSONObject.optString("event")) && (optJSONObject = jSONObject.optJSONObject("properties")) != null) {
                    if (optJSONObject.has("sensorsdata_web_visual_eventName")) {
                        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper.this.mSparseArray.put(jSONObject.hashCode(), optJSONObject.optJSONArray("sensorsdata_web_visual_eventName"));
                        optJSONObject.remove("sensorsdata_web_visual_eventName");
                    }
                    java.lang.String optString = optJSONObject.optString("sensorsdata_app_visual_properties");
                    optJSONObject.remove("sensorsdata_app_visual_properties");
                    if (!android.text.TextUtils.isEmpty(optString) && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                        java.lang.String decodeString = com.sensorsdata.analytics.android.sdk.util.Base64Coder.decodeString(optString);
                        if (android.text.TextUtils.isEmpty(decodeString)) {
                            return;
                        }
                        try {
                            org.json.JSONArray jSONArray = new org.json.JSONArray(decodeString);
                            com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().clearViewNodeCache();
                            if (jSONArray.length() > 0) {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                    com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty visualProperty = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty();
                                    visualProperty.elementPath = jSONObject2.optString("element_path");
                                    visualProperty.elementPosition = jSONObject2.optString("element_position");
                                    visualProperty.screenName = jSONObject2.optString("screen_name");
                                    visualProperty.name = jSONObject2.optString("name");
                                    visualProperty.regular = jSONObject2.optString("regular");
                                    visualProperty.isH5 = jSONObject2.optBoolean("h5");
                                    visualProperty.type = jSONObject2.optString("type");
                                    visualProperty.webViewElementPath = jSONObject2.optString("webview_element_path");
                                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().mergeAppVisualProperty(visualProperty, null, optJSONObject, null);
                                }
                            }
                        } catch (org.json.JSONException e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                    }
                }
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }
    }

    private static java.lang.String Base642string(java.lang.String str) {
        return new java.lang.String(android.util.Base64.decode(str.getBytes(), 0));
    }

    private void addSAEventListener() {
        if (this.mSAEventListener == null) {
            this.mSAEventListener = new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper.AnonymousClass2();
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().addEventListener(this.mSAEventListener);
        }
    }

    private void getJSVisualProperties(android.view.View view, java.lang.String str, java.lang.String str2, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback onBridgeCallback) {
        try {
            org.json.JSONArray h5JsonArrayFromCache = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualPropertiesCache().getH5JsonArrayFromCache(str2, str);
            if (h5JsonArrayFromCache == null) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("sensorsdata_js_visual_properties", h5JsonArrayFromCache);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            sendToWeb(view, "getJSVisualProperties", jSONObject, onBridgeCallback);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public void clearCache(int i) {
        try {
            this.mSparseArray.remove(i);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public org.json.JSONArray getEventName(int i) {
        try {
            return this.mSparseArray.get(i);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public void mergeJSVisualProperties(org.json.JSONObject jSONObject, java.util.HashSet<java.lang.String> hashSet, java.lang.String str) {
        android.view.View view;
        if (hashSet != null) {
            try {
                if (hashSet.size() == 0) {
                    return;
                }
                java.util.Iterator<java.lang.String> it = hashSet.iterator();
                java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(hashSet.size());
                while (it.hasNext()) {
                    com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().getViewNode(it.next());
                    if (viewNode != null && viewNode.getView() != null && (view = viewNode.getView().get()) != null) {
                        getJSVisualProperties(view, viewNode.getViewPath(), str, new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper.AnonymousClass1(jSONObject, countDownLatch));
                    }
                }
                try {
                    countDownLatch.await(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (java.lang.InterruptedException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }
    }

    public void registerListeners() {
        try {
            this.mJSBridgeHelper.addSAJSListener();
            addSAEventListener();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge
    public void sendToWeb(android.view.View view, java.lang.String str, java.lang.Object obj) {
        this.mJSBridgeHelper.sendToWeb(view, str, obj);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge
    public void sendToWeb(android.view.View view, java.lang.String str, java.lang.Object obj, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback onBridgeCallback) {
        this.mJSBridgeHelper.sendToWeb(view, str, obj, onBridgeCallback);
    }
}
