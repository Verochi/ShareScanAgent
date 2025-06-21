package com.sensorsdata.analytics.android.sdk.visual.property;

/* loaded from: classes19.dex */
public class VisualPropertiesLog implements com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener {
    private com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesLog.Builder mBuilder;
    private android.content.Context mContext;
    private org.json.JSONArray mJSONArray;
    private final java.lang.Object object = new java.lang.Object();

    public static class Builder {
        private java.lang.String elementContent;
        private java.lang.String elementPath;
        private java.lang.String elementPosition;
        private org.json.JSONObject eventConfig;
        private java.lang.String eventType;
        private java.lang.String localConfig;
        private android.content.Context mContext;
        private org.json.JSONObject otherError;
        private org.json.JSONObject propertyContentParse;
        private org.json.JSONObject propertyElement;
        private java.lang.String screenName;
        private org.json.JSONObject switchControl;
        private org.json.JSONObject visualConfig;

        public Builder(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
            this.mContext = context;
            this.eventType = str;
            this.screenName = str2;
            this.elementPath = str3;
            this.elementPosition = str4;
            this.elementContent = str5;
            this.localConfig = null;
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig visualConfig = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualConfig();
            if (visualConfig != null) {
                this.localConfig = visualConfig.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public org.json.JSONObject build() {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, this.eventType);
                jSONObject.put("element_path", this.elementPath);
                jSONObject.put("element_position", this.elementPosition);
                jSONObject.put("element_content", this.elementContent);
                jSONObject.put("screen_name", this.screenName);
                jSONObject.put("local_config", this.localConfig);
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                org.json.JSONObject jSONObject2 = this.switchControl;
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
                org.json.JSONObject jSONObject3 = this.visualConfig;
                if (jSONObject3 != null) {
                    jSONArray.put(jSONObject3);
                }
                org.json.JSONObject jSONObject4 = this.eventConfig;
                if (jSONObject4 != null) {
                    jSONArray.put(jSONObject4);
                }
                org.json.JSONObject jSONObject5 = this.propertyElement;
                if (jSONObject5 != null) {
                    jSONArray.put(jSONObject5);
                }
                org.json.JSONObject jSONObject6 = this.propertyContentParse;
                if (jSONObject6 != null) {
                    jSONArray.put(jSONObject6);
                }
                org.json.JSONObject jSONObject7 = this.otherError;
                if (jSONObject7 != null) {
                    jSONArray.put(jSONObject7);
                }
                jSONObject.put("message", jSONArray);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildEventConfig() {
            try {
                this.eventConfig = new org.json.JSONObject().put("title", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_event_error)).put("message", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_cache_error));
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildOtherError(java.lang.String str) {
            try {
                this.otherError = new org.json.JSONObject().put("title", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_other_error)).put("message", str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildPropertyContentParse(java.lang.String str) {
            try {
                this.propertyContentParse = new org.json.JSONObject().put("title", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_parseProperty_error)).put("message", str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildPropertyElement(java.lang.String str) {
            try {
                this.propertyElement = new org.json.JSONObject().put("title", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_getProperty_error)).put("message", str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildSwitchControl() {
            try {
                this.switchControl = new org.json.JSONObject().put("title", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_switch_error)).put("message", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_property_switch_error));
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildVisualConfig(java.lang.String str) {
            try {
                this.visualConfig = new org.json.JSONObject().put("title", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_config_error)).put("message", str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    private synchronized void add2JsonArray(org.json.JSONObject jSONObject) {
        synchronized (this.object) {
            if (this.mJSONArray == null) {
                this.mJSONArray = new org.json.JSONArray();
            }
            this.mJSONArray.put(jSONObject);
        }
    }

    public synchronized java.lang.String getVisualPropertiesLog() {
        synchronized (this.object) {
            this.mContext = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
            org.json.JSONArray jSONArray = this.mJSONArray;
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onCheckEventConfigFailure() {
        this.mBuilder.buildEventConfig();
        add2JsonArray(this.mBuilder.build());
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onCheckVisualConfigFailure(java.lang.String str) {
        this.mBuilder.buildVisualConfig(str);
        add2JsonArray(this.mBuilder.build());
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onFindPropertyElementFailure(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mBuilder.buildPropertyElement(java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_property_error), str, str2, str3));
        add2JsonArray(this.mBuilder.build());
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onOtherError(java.lang.String str) {
        this.mBuilder.buildOtherError(str);
        add2JsonArray(this.mBuilder.build());
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onParsePropertyContentFailure(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.mBuilder.buildPropertyContentParse(java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mContext, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_regex_error), str, str3, str4, str2));
        add2JsonArray(this.mBuilder.build());
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onStart(java.lang.String str, java.lang.String str2, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode) {
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (viewNode != null) {
            java.lang.String viewPath = viewNode.getViewPath();
            java.lang.String viewPosition = viewNode.getViewPosition();
            str5 = viewNode.getViewContent();
            str3 = viewPath;
            str4 = viewPosition;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
        }
        this.mBuilder = new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesLog.Builder(this.mContext, str, str2, str3, str4, str5);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener
    public void onSwitchClose() {
        this.mBuilder.buildSwitchControl();
        add2JsonArray(this.mBuilder.build());
    }
}
