package com.sensorsdata.analytics.android.sdk.advert;

/* loaded from: classes19.dex */
public class SASlinkCreator {
    private java.lang.String mChannelName;
    private java.lang.String mCommonRedirectURI;
    private com.sensorsdata.analytics.android.sdk.advert.model.SATLandingPageType mLandingPageType;
    private java.lang.String mRouteParam;
    private java.lang.String mTemplateID;
    private java.lang.String mToken;
    private java.lang.String mName = "";
    private java.lang.String mChannelType = "";
    private java.lang.String mUriSchemeSuffix = "";
    private java.lang.String mRedirectURLOnOtherDevice = "";
    private java.lang.String mUtmSource = "";
    private java.lang.String mUtmCampaign = "";
    private java.lang.String mUtmMedium = "";
    private java.lang.String mUtmTerm = "";
    private java.lang.String mUtmContent = "";
    private org.json.JSONObject mCustomParams = new org.json.JSONObject();
    private org.json.JSONObject mSystemParams = new org.json.JSONObject();
    private java.util.Map<java.lang.String, java.lang.String> mLandingPage = new java.util.HashMap();

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback val$callback;
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback, android.content.Context context) {
            this.val$callback = sensorsDataCreateSLinkCallback;
            this.val$context = context;
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onFailure(int i, java.lang.String str) {
            if (i == 0) {
                i = 10006;
            }
            com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator.this.trackSlinkCreate(i, str, this.val$callback);
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onResponse(org.json.JSONObject jSONObject) {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            int i;
            java.lang.String str4;
            java.lang.String stringResource = com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.val$context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_response_data_error);
            java.lang.String str5 = "";
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("code", 10004);
                if (optInt == 0) {
                    java.lang.String optString = jSONObject.optString("msg", com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.val$context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_success));
                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        java.lang.String optString2 = optJSONObject.optString("slink_id");
                        str4 = optJSONObject.optString("short_url");
                        str5 = optString2;
                    } else {
                        str4 = "";
                    }
                    str3 = str4;
                    str = optString;
                    str2 = str5;
                } else {
                    if (optInt != 10004) {
                        stringResource = jSONObject.optString("msg");
                    }
                    str = stringResource;
                    str2 = "";
                    str3 = str2;
                }
                i = optInt;
            } else {
                str = stringResource;
                str2 = "";
                str3 = str2;
                i = 10004;
            }
            com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator.this.trackSlinkCreate(i, str, str2, str3, this.val$callback);
        }
    }

    public SASlinkCreator(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.mTemplateID = "";
        this.mToken = "";
        this.mChannelName = "";
        this.mCommonRedirectURI = "";
        this.mTemplateID = str;
        this.mChannelName = str2;
        this.mCommonRedirectURI = str3;
        this.mToken = str4;
    }

    private boolean checkInfo(android.content.Context context, com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback, java.lang.String str) {
        if (sensorsDataCreateSLinkCallback == null) {
            trackSlinkCreate(10005, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_callback_missing), null);
            return false;
        }
        if (!com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isNetworkAvailable(context)) {
            trackSlinkCreate(10002, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_no_network), sensorsDataCreateSLinkCallback);
            return false;
        }
        if (android.text.TextUtils.isEmpty(str) || !(str.startsWith("http://") || str.startsWith("https://"))) {
            trackSlinkCreate(10003, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_custom_url_error), sensorsDataCreateSLinkCallback);
            return false;
        }
        if (android.text.TextUtils.isEmpty(this.mToken)) {
            trackSlinkCreate(10001, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_token_missing), sensorsDataCreateSLinkCallback);
            return false;
        }
        if (android.text.TextUtils.isEmpty(this.mTemplateID)) {
            trackSlinkCreate(10001, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_template_id_missing), sensorsDataCreateSLinkCallback);
            return false;
        }
        if (android.text.TextUtils.isEmpty(this.mChannelName)) {
            trackSlinkCreate(10001, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_channel_name_missing), sensorsDataCreateSLinkCallback);
            return false;
        }
        if (!android.text.TextUtils.isEmpty(this.mCommonRedirectURI)) {
            return true;
        }
        trackSlinkCreate(10001, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.advert.R.string.sensors_analytics_ad_create_link_common_redirect_url_missing), sensorsDataCreateSLinkCallback);
        return false;
    }

    private java.lang.String getChannelType() {
        return this.mChannelType;
    }

    private com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setChannelType(java.lang.String str) {
        this.mChannelType = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackSlinkCreate(int i, java.lang.String str, com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback) {
        trackSlinkCreate(i, str, "", "", sensorsDataCreateSLinkCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackSlinkCreate(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback) {
        com.sensorsdata.analytics.android.sdk.advert.model.SASlinkResponse sASlinkResponse = new com.sensorsdata.analytics.android.sdk.advert.model.SASlinkResponse();
        sASlinkResponse.slink = str3;
        sASlinkResponse.statusCode = i;
        sASlinkResponse.message = str;
        sASlinkResponse.slinkID = str2;
        sASlinkResponse.commonRedirectURI = this.mCommonRedirectURI;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject put = jSONObject.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_CHANNEL_TYPE, "app_share").put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_SOURCE, "Android").put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_CHANNEL_NAME, this.mChannelName).put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_DATA, "").put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_SHORT_URL, str3).put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_STATUS, i);
            if (str.length() > 200) {
                str = str.substring(0, 200);
            }
            put.put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.DYNAMIC_SLINK_MSG, str).put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_ID, str2).put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, this.mTemplateID).put(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.Properties.SLINK_TYPE, "dynamic");
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track(com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.DYNAMIC_SLINK_CREATE, jSONObject);
        if (sensorsDataCreateSLinkCallback != null) {
            sensorsDataCreateSLinkCallback.onReceive(sASlinkResponse);
        }
    }

    public void createSLink(android.content.Context context, com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback) {
        java.lang.String requestUrl = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getRequestUrl(com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getCustomADChannelUrl(), "slink/dynamic/links");
        try {
            if (checkInfo(context, sensorsDataCreateSLinkCallback, requestUrl)) {
                java.lang.String project = new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl()).getProject();
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("token", this.mToken);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("project_name", project);
                jSONObject.put("slink_template_id", this.mTemplateID);
                jSONObject.put("name", getName());
                jSONObject.put("channel_type", "app_share");
                jSONObject.put("channel_name", this.mChannelName);
                jSONObject.put("custom_param", getCustomParams());
                jSONObject.put("system_param", getSystemParams());
                jSONObject.put("route_param", getRouteParam());
                jSONObject.put("fixed_param", new org.json.JSONObject().put("channel_utm_campaign", getUtmCampaign()).put("channel_utm_content", getUtmContent()).put("channel_utm_medium", getUtmMedium()).put("channel_utm_source", getUtmSource()).put("channel_utm_term", getUtmTerm()));
                jSONObject.put("uri_scheme_suffix", getUriSchemeSuffix());
                if (getLandingPageType() != null) {
                    jSONObject.put("landing_page_type", getLandingPageType().getTypeName());
                }
                jSONObject.put("other_landing_page_map", new org.json.JSONObject(getLandingPage()));
                jSONObject.put("jump_address", this.mRedirectURLOnOtherDevice);
                new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST, requestUrl).header(hashMap).jsonData(jSONObject.toString()).callback(new com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator.AnonymousClass1(sensorsDataCreateSLinkCallback, context)).execute();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public org.json.JSONObject getCustomParams() {
        return this.mCustomParams;
    }

    public java.util.Map<java.lang.String, java.lang.String> getLandingPage() {
        return this.mLandingPage;
    }

    public com.sensorsdata.analytics.android.sdk.advert.model.SATLandingPageType getLandingPageType() {
        return this.mLandingPageType;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getRedirectURLOnOtherDevice() {
        return this.mRedirectURLOnOtherDevice;
    }

    public java.lang.String getRouteParam() {
        return this.mRouteParam;
    }

    public org.json.JSONObject getSystemParams() {
        return this.mSystemParams;
    }

    public java.lang.String getUriSchemeSuffix() {
        return this.mUriSchemeSuffix;
    }

    public java.lang.String getUtmCampaign() {
        return this.mUtmCampaign;
    }

    public java.lang.String getUtmContent() {
        return this.mUtmContent;
    }

    public java.lang.String getUtmMedium() {
        return this.mUtmMedium;
    }

    public java.lang.String getUtmSource() {
        return this.mUtmSource;
    }

    public java.lang.String getUtmTerm() {
        return this.mUtmTerm;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setCustomParams(org.json.JSONObject jSONObject) {
        this.mCustomParams = jSONObject;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setLandingPage(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mLandingPage = map;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setLandingPageType(com.sensorsdata.analytics.android.sdk.advert.model.SATLandingPageType sATLandingPageType) {
        this.mLandingPageType = sATLandingPageType;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setName(java.lang.String str) {
        this.mName = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setRedirectURLOnOtherDevice(java.lang.String str) {
        this.mRedirectURLOnOtherDevice = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setRouteParam(java.lang.String str) {
        this.mRouteParam = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setSystemParams(org.json.JSONObject jSONObject) {
        this.mSystemParams = jSONObject;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setUriSchemeSuffix(java.lang.String str) {
        this.mUriSchemeSuffix = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setUtmCampaign(java.lang.String str) {
        this.mUtmCampaign = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setUtmContent(java.lang.String str) {
        this.mUtmContent = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setUtmMedium(java.lang.String str) {
        this.mUtmMedium = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setUtmSource(java.lang.String str) {
        this.mUtmSource = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.advert.SASlinkCreator setUtmTerm(java.lang.String str) {
        this.mUtmTerm = str;
        return this;
    }
}
