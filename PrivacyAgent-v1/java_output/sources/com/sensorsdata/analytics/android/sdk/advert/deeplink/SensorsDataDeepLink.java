package com.sensorsdata.analytics.android.sdk.advert.deeplink;

/* loaded from: classes19.dex */
class SensorsDataDeepLink extends com.sensorsdata.analytics.android.sdk.advert.deeplink.AbsDeepLink {
    private java.lang.String adSlinkId;
    private java.lang.String adSlinkTemplateId;
    private java.lang.String adSlinkType;
    private final java.lang.String customADChannelUrl;
    private org.json.JSONObject customParams;
    private java.lang.String errorMsg;
    private java.lang.String pageParams;
    private final java.lang.String project;
    private final java.lang.String serverUrl;
    private boolean success;

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback {
        final /* synthetic */ long val$requestDeepLinkStartTime;

        /* renamed from: com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04371 implements java.lang.Runnable {
            final /* synthetic */ org.json.JSONObject val$properties;

            public RunnableC04371(org.json.JSONObject jSONObject) {
                this.val$properties = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setEventName(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.MATCH_RESULT).setProperties(this.val$properties));
            }
        }

        public AnonymousClass1(long j) {
            this.val$requestDeepLinkStartTime = j;
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback, com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onAfter() {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.val$requestDeepLinkStartTime;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                if (!android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.pageParams)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_OPTIONS, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.pageParams);
                }
                if (!android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.MATCH_FAIL_REASON, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg);
                }
                if (!android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkId)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_ID, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkId);
                }
                jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_URL, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.getDeepLinkUrl());
                jSONObject.put("$event_duration", com.sensorsdata.analytics.android.sdk.util.TimeUtils.duration(currentTimeMillis));
                if (!android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkTemplateId)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkTemplateId);
                }
                if (!android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkType)) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TYPE, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkType);
                }
                if (com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.customParams != null && com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.customParams.length() > 0) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_CUSTOM_PARAMS, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.customParams.toString());
                }
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getUtmProperties(), jSONObject);
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink sensorsDataDeepLink = com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this;
            com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback = sensorsDataDeepLink.mCallBack;
            if (onDeepLinkParseFinishCallback != null) {
                onDeepLinkParseFinishCallback.onFinish(com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.DeepLinkType.SENSORSDATA, sensorsDataDeepLink.pageParams, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.customParams, com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.success, currentTimeMillis);
            }
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.AnonymousClass1.RunnableC04371(jSONObject));
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onFailure(int i, java.lang.String str) {
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg = str;
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.success = false;
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onResponse(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.success = false;
                return;
            }
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.success = true;
            com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.parseParams(com.sensorsdata.analytics.android.sdk.util.JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.pageParams = jSONObject.optString("page_params");
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg = jSONObject.optString(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG);
            if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg)) {
                com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg = jSONObject.optString("error_msg");
            }
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkId = jSONObject.optString("ad_slink_id");
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkTemplateId = jSONObject.optString("slink_template_id");
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.adSlinkType = jSONObject.optString("slink_type");
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.customParams = jSONObject.optJSONObject("custom_params");
            if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.errorMsg)) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.this.success = false;
        }
    }

    public SensorsDataDeepLink(android.content.Intent intent, java.lang.String str, java.lang.String str2) {
        super(intent);
        this.serverUrl = str;
        this.customADChannelUrl = str2;
        this.project = new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(str).getProject();
    }

    private java.lang.String getSlinkRequestUrl() {
        return !android.text.TextUtils.isEmpty(this.customADChannelUrl) ? com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getRequestUrl(this.customADChannelUrl, "slink/config/query") : "";
    }

    private boolean isSlink(android.net.Uri uri, java.lang.String str) {
        java.util.List<java.lang.String> pathSegments;
        if (android.text.TextUtils.isEmpty(str) || (pathSegments = uri.getPathSegments()) == null || pathSegments.isEmpty() || !pathSegments.get(0).equals("slink")) {
            return false;
        }
        java.lang.String host = uri.getHost();
        if (android.text.TextUtils.isEmpty(host)) {
            return false;
        }
        return com.sensorsdata.analytics.android.sdk.util.NetworkUtils.compareMainDomain(str, host) || host.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.DATABASE_NAME);
    }

    public java.lang.String getRequestUrl() {
        int lastIndexOf;
        if (android.text.TextUtils.isEmpty(this.serverUrl) || (lastIndexOf = this.serverUrl.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) == -1) {
            return "";
        }
        return this.serverUrl.substring(0, lastIndexOf) + "/sdk/deeplink/param";
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public void mergeDeepLinkProperty(org.json.JSONObject jSONObject) {
        try {
            jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DEEPLINK_URL, getDeepLinkUrl());
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkProcessor
    public void parseDeepLink(android.content.Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        android.net.Uri data = intent.getData();
        java.lang.String lastPathSegment = data.getLastPathSegment();
        if (android.text.TextUtils.isEmpty(lastPathSegment)) {
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("key", lastPathSegment);
        hashMap.put("system_type", com.sensorsdata.sf.ui.view.UIProperty.action_android);
        hashMap.put("project", this.project);
        new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET, isSlink(data, com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getHost(this.customADChannelUrl)) ? getSlinkRequestUrl() : getRequestUrl()).params(hashMap).callback(new com.sensorsdata.analytics.android.sdk.advert.deeplink.SensorsDataDeepLink.AnonymousClass1(currentTimeMillis)).execute();
    }
}
