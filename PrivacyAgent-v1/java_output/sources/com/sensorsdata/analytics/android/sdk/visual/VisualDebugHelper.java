package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class VisualDebugHelper {
    private static final java.lang.String TAG = "SA.VP.VisualDebugHelper";
    private org.json.JSONArray mJsonArray;
    private com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.TrackEventAdapter mEventListener = null;
    private final java.lang.Object object = new java.lang.Object();

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.TrackEventAdapter {
        final /* synthetic */ java.util.concurrent.ExecutorService val$executorService;

        /* renamed from: com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04421 implements java.lang.Runnable {
            final /* synthetic */ org.json.JSONObject val$jsonObject;

            public RunnableC04421(org.json.JSONObject jSONObject) {
                this.val$jsonObject = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.this.handlerEvent(this.val$jsonObject);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.util.concurrent.ExecutorService executorService) {
            super(null);
            this.val$executorService = executorService;
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAEventListener
        public void trackEvent(org.json.JSONObject jSONObject) {
            this.val$executorService.execute(new com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.AnonymousClass1.RunnableC04421(jSONObject));
        }
    }

    public static abstract class TrackEventAdapter implements com.sensorsdata.analytics.android.sdk.listener.SAEventListener {
        private TrackEventAdapter() {
        }

        public /* synthetic */ TrackEventAdapter(com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.AnonymousClass1 anonymousClass1) {
            this();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handlerEvent(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning()) {
            java.lang.String optString = jSONObject.optString("event");
            if (!android.text.TextUtils.equals("$AppClick", optString) && !android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.WEB_CLICK_EVENT_NAME, optString)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "eventName is " + optString + " filter");
                return;
            }
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("properties");
            if (optJSONObject == null) {
                return;
            }
            if (com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().checkAppIdAndProject()) {
                com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig visualConfig = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualConfig();
                if (visualConfig == null) {
                    return;
                }
                java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> list = visualConfig.events;
                if (list != null && list.size() != 0) {
                    if (android.text.TextUtils.equals("$AppClick", optString)) {
                        java.lang.String optString2 = optJSONObject.optString("$screen_name");
                        if (android.text.TextUtils.isEmpty(optString2)) {
                            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "screenName is empty ");
                            return;
                        }
                        java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> matchEventConfigList = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getMatchEventConfigList(list, com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType.getVisualEventType(optString), optString2, optJSONObject.optString(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_PATH), optJSONObject.optString(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_POSITION), optJSONObject.optString(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT));
                        if (matchEventConfigList.size() > 0) {
                            synchronized (this.object) {
                                for (com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig visualPropertiesConfig : matchEventConfigList) {
                                    try {
                                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
                                        jSONObject2.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME, visualPropertiesConfig.eventName);
                                        if (this.mJsonArray == null) {
                                            this.mJsonArray = new org.json.JSONArray();
                                        }
                                        this.mJsonArray.put(jSONObject2);
                                    } catch (java.lang.Exception e2) {
                                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                                    }
                                }
                            }
                        }
                    } else if (android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.WEB_CLICK_EVENT_NAME, optString)) {
                        try {
                            org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("sensorsdata_web_visual_eventName");
                            if (optJSONArray == null) {
                                int hashCode = jSONObject.hashCode();
                                org.json.JSONArray eventName = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().getEventName(hashCode);
                                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().clearCache(hashCode);
                                optJSONArray = eventName;
                            }
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                synchronized (this.object) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        try {
                                            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                                            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject3);
                                            jSONObject3.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME, optJSONArray.optString(i));
                                            if (this.mJsonArray == null) {
                                                this.mJsonArray = new org.json.JSONArray();
                                            }
                                            this.mJsonArray.put(jSONObject3);
                                        } catch (java.lang.Exception e3) {
                                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                                        }
                                    }
                                }
                            }
                        } catch (java.lang.Exception e4) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                        }
                    }
                    return;
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "propertiesConfigs is empty ");
            }
        }
    }

    public java.lang.String getDebugInfo() {
        synchronized (this.object) {
            org.json.JSONArray jSONArray = this.mJsonArray;
            if (jSONArray == null) {
                return null;
            }
            java.lang.String jSONArray2 = jSONArray.toString();
            this.mJsonArray = null;
            return jSONArray2;
        }
    }

    public void startMonitor() {
        try {
            if (this.mEventListener == null) {
                this.mEventListener = new com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.AnonymousClass1(com.sensorsdata.analytics.android.sdk.util.ThreadUtils.getSinglePool());
            }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().addEventListener(this.mEventListener);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void stopMonitor() {
        try {
            if (this.mEventListener != null) {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().removeEventListener(this.mEventListener);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
