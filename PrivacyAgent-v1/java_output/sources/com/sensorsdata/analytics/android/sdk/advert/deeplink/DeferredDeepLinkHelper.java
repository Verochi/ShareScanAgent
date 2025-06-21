package com.sensorsdata.analytics.android.sdk.advert.deeplink;

/* loaded from: classes19.dex */
public class DeferredDeepLinkHelper {

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback {
        private java.lang.String adChannel;
        private java.lang.String adSlinkId;
        private java.lang.String adSlinkTemplateId;
        private java.lang.String adSlinkType;
        private org.json.JSONObject customParams;
        private java.lang.String errorMsg;
        private boolean isSuccess = false;
        private java.lang.String parameter;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback val$callBack;
        final /* synthetic */ boolean val$isSaveDeepLinkInfo;
        final /* synthetic */ org.json.JSONObject val$jsonData;
        final /* synthetic */ long val$requestDeepLinkStartTime;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.SensorsDataAPI val$sensorsDataAPI;

        /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04361 implements java.lang.Runnable {
            final /* synthetic */ org.json.JSONObject val$jsonObject;

            public RunnableC04361(org.json.JSONObject jSONObject) {
                this.val$jsonObject = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.DEFERRED_DEEPLINK_JUMP).setProperties(this.val$jsonObject));
            }
        }

        /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ org.json.JSONObject val$properties;

            public AnonymousClass2(org.json.JSONObject jSONObject) {
                this.val$properties = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.MATCH_RESULT).setProperties(this.val$properties));
            }
        }

        public AnonymousClass1(boolean z, long j, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) {
            this.val$isSaveDeepLinkInfo = z;
            this.val$requestDeepLinkStartTime = j;
            this.val$jsonData = jSONObject;
            this.val$callBack = sensorsDataDeferredDeepLinkCallback;
            this.val$sensorsDataAPI = sensorsDataAPI;
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback, com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onAfter() {
            if (this.val$isSaveDeepLinkInfo) {
                com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.saveDeepLinkInfo();
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.val$requestDeepLinkStartTime;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                if (!android.text.TextUtils.isEmpty(this.parameter)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_OPTIONS, this.parameter);
                }
                if (!android.text.TextUtils.isEmpty(this.errorMsg)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.MATCH_FAIL_REASON, this.errorMsg);
                }
                if (!android.text.TextUtils.isEmpty(this.adChannel)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.CHANNEL_INFO, this.adChannel);
                }
                if (!android.text.TextUtils.isEmpty(this.adSlinkId)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_ID, this.adSlinkId);
                }
                jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.MATCH_TYPE, "deferred deeplink");
                jSONObject.put("$event_duration", com.sensorsdata.analytics.android.sdk.util.TimeUtils.duration(currentTimeMillis));
                jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEVICE_INFO, this.val$jsonData.get("ids"));
                if (!android.text.TextUtils.isEmpty(this.adSlinkTemplateId)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, this.adSlinkTemplateId);
                }
                if (!android.text.TextUtils.isEmpty(this.adSlinkType)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TYPE, this.adSlinkType);
                }
                org.json.JSONObject jSONObject2 = this.customParams;
                if (jSONObject2 != null && jSONObject2.length() > 0) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_CUSTOM_PARAMS, this.customParams.toString());
                }
                com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback = this.val$callBack;
                if (sensorsDataDeferredDeepLinkCallback != null) {
                    try {
                        if (sensorsDataDeferredDeepLinkCallback.onReceive(new com.sensorsdata.analytics.android.sdk.deeplink.SADeepLinkObject(this.parameter, this.customParams, this.adChannel, this.isSuccess, currentTimeMillis)) && this.isSuccess) {
                            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                            jSONObject3.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_OPTIONS, this.parameter);
                            if (!android.text.TextUtils.isEmpty(this.adSlinkId)) {
                                jSONObject3.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_ID, this.adSlinkId);
                            }
                            org.json.JSONObject jSONObject4 = this.customParams;
                            if (jSONObject4 != null && jSONObject4.length() > 0) {
                                jSONObject3.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_CUSTOM_PARAMS, this.customParams.toString());
                            }
                            if (!android.text.TextUtils.isEmpty(this.adSlinkTemplateId)) {
                                jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, this.adSlinkTemplateId);
                            }
                            if (!android.text.TextUtils.isEmpty(this.adSlinkType)) {
                                jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TYPE, this.adSlinkType);
                            }
                            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getUtmProperties(), jSONObject3);
                            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper.AnonymousClass1.RunnableC04361(jSONObject3));
                        }
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                } else if (this.isSuccess) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.MATCH_FAIL_REASON, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.val$sensorsDataAPI.getSAContextManager().getContext(), com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_listener));
                }
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getUtmProperties(), jSONObject);
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper.AnonymousClass1.AnonymousClass2(jSONObject));
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onFailure(int i, java.lang.String str) {
            this.errorMsg = str;
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onResponse(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                this.errorMsg = "response is null";
                return;
            }
            if (jSONObject.optInt("code") != 0) {
                this.errorMsg = jSONObject.optString("msg");
                return;
            }
            this.isSuccess = true;
            com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.parseParams(com.sensorsdata.analytics.android.sdk.util.JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
            this.parameter = jSONObject.optString("parameter");
            this.adChannel = jSONObject.optString("ad_channel");
            this.adSlinkId = jSONObject.optString("ad_slink_id");
            this.adSlinkTemplateId = jSONObject.optString("slink_template_id");
            this.adSlinkType = jSONObject.optString("slink_type");
            this.customParams = jSONObject.optJSONObject("custom_params");
        }
    }

    public static void request(org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback, java.lang.String str, boolean z) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z2 = !android.text.TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
        if (z2 || (!android.text.TextUtils.isEmpty(sharedInstance.getServerUrl()) && sharedInstance.getServerUrl().startsWith(com.alipay.sdk.m.l.a.q))) {
            com.sensorsdata.analytics.android.sdk.network.HttpMethod httpMethod = com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST;
            if (!z2) {
                str = sharedInstance.getServerUrl();
            }
            new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(httpMethod, com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getRequestUrl(str, "slink/ddeeplink")).jsonData(jSONObject.toString()).callback(new com.sensorsdata.analytics.android.sdk.advert.deeplink.DeferredDeepLinkHelper.AnonymousClass1(z, currentTimeMillis, jSONObject, sensorsDataDeferredDeepLinkCallback, sharedInstance)).execute();
        }
    }
}
