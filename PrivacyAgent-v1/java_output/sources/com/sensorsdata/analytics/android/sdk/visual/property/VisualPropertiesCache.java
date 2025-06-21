package com.sensorsdata.analytics.android.sdk.visual.property;

/* loaded from: classes19.dex */
public class VisualPropertiesCache {
    private static final java.lang.String TAG = "SA.VP.VisualPropertiesCache";

    private void doOnSaveCache(java.lang.String str) {
        try {
            java.util.List<android.view.View> currentWebView = com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().getCurrentWebView();
            if (currentWebView != null && currentWebView.size() != 0) {
                java.util.Iterator<android.view.View> it = currentWebView.iterator();
                while (it.hasNext()) {
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().sendToWeb(it.next(), "updateH5VisualConfig", str);
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public org.json.JSONArray getH5JsonArrayFromCache(java.lang.String str, java.lang.String str2) {
        org.json.JSONArray optJSONArray;
        java.lang.String str3 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getVisualConfigPst().get();
        if (android.text.TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("events");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    org.json.JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                    if (optJSONObject != null) {
                        com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig visualPropertiesConfig = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig();
                        java.lang.String optString = optJSONObject.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME);
                        visualPropertiesConfig.eventName = optString;
                        if (android.text.TextUtils.equals(optString, str) && (optJSONArray = optJSONObject.optJSONArray("properties")) != null && optJSONArray.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                org.json.JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty visualProperty = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty();
                                java.lang.String optString2 = optJSONObject2.optString("webview_element_path");
                                visualProperty.webViewElementPath = optString2;
                                if (android.text.TextUtils.equals(optString2, str2)) {
                                    jSONArray.put(optJSONObject2);
                                }
                            }
                        }
                    }
                }
                return jSONArray;
            }
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
        return null;
    }

    public java.lang.String getVisualCache() {
        return com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getVisualConfigPst().get();
    }

    public com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig getVisualConfig() {
        java.lang.String str = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getVisualConfigPst().get();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "local visual config is :" + str);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig visualConfig = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            visualConfig.appId = jSONObject.optString("app_id");
            visualConfig.os = jSONObject.optString("os");
            visualConfig.project = jSONObject.optString("project");
            visualConfig.version = jSONObject.optString("version");
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("events");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig visualPropertiesConfig = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig();
                        visualPropertiesConfig.eventName = optJSONObject.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME);
                        visualPropertiesConfig.eventType = optJSONObject.optString(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE);
                        org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("event");
                        if (optJSONObject2 != null) {
                            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent visualEvent = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent();
                            visualEvent.elementPath = optJSONObject2.optString("element_path");
                            visualEvent.elementPosition = optJSONObject2.optString("element_position");
                            visualEvent.elementContent = optJSONObject2.optString("element_content");
                            visualEvent.screenName = optJSONObject2.optString("screen_name");
                            visualEvent.limitElementPosition = optJSONObject2.optBoolean("limit_element_position");
                            visualEvent.limitElementContent = optJSONObject2.optBoolean("limit_element_content");
                            visualEvent.isH5 = optJSONObject2.optBoolean("h5");
                            visualPropertiesConfig.event = visualEvent;
                        }
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray("properties");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                org.json.JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty visualProperty = new com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty();
                                visualProperty.elementPath = optJSONObject3.optString("element_path");
                                visualProperty.elementPosition = optJSONObject3.optString("element_position");
                                visualProperty.screenName = optJSONObject3.optString("screen_name");
                                visualProperty.name = optJSONObject3.optString("name");
                                visualProperty.regular = optJSONObject3.optString("regular");
                                visualProperty.isH5 = optJSONObject3.optBoolean("h5");
                                visualProperty.type = optJSONObject3.optString("type");
                                visualProperty.webViewElementPath = optJSONObject3.optString("webview_element_path");
                                arrayList2.add(visualProperty);
                            }
                            visualPropertiesConfig.properties = arrayList2;
                        }
                        arrayList.add(visualPropertiesConfig);
                    }
                }
                visualConfig.events = arrayList;
            }
            return visualConfig;
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public void save2Cache(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "save2Cache config is:" + str);
        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getVisualConfigPst().commit(str);
        doOnSaveCache(str);
        com.sensorsdata.analytics.android.sdk.visual.utils.FlutterUtils.visualizedPropertiesConfigChanged();
    }
}
