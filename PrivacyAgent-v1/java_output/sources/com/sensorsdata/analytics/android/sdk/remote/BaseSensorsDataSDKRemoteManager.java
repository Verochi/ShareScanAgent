package com.sensorsdata.analytics.android.sdk.remote;

/* loaded from: classes19.dex */
public abstract class BaseSensorsDataSDKRemoteManager {
    protected static final java.lang.String TAG = "SA.SensorsDataSDKRemoteConfigBase";
    protected static com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig mSDKRemoteConfig;
    protected com.sensorsdata.analytics.android.sdk.core.SAContextManager mContextManager;
    protected boolean mDisableDefaultRemoteConfig;
    protected com.sensorsdata.analytics.android.sdk.SensorsDataAPI mSensorsDataAPI;

    public enum RandomTimeType {
        RandomTimeTypeWrite,
        RandomTimeTypeClean,
        RandomTimeTypeNone
    }

    public BaseSensorsDataSDKRemoteManager(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSensorsDataAPI = sensorsDataAPI;
        this.mContextManager = sAContextManager;
        this.mDisableDefaultRemoteConfig = sensorsDataAPI.isDisableDefaultRemoteConfig();
    }

    public static boolean isSDKDisabledByRemote() {
        com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig == null) {
            return false;
        }
        return sensorsDataSDKRemoteConfig.isDisableSDK();
    }

    public abstract void applySDKConfigFromCache();

    public java.lang.String buildRemoteUrl(boolean z) {
        java.lang.String str;
        java.lang.String serverUrl = this.mSensorsDataAPI.getServerUrl();
        java.lang.String str2 = null;
        java.lang.String remoteConfigUrl = this.mContextManager.getInternalConfigs().saConfigOptions != null ? this.mContextManager.getInternalConfigs().saConfigOptions.getRemoteConfigUrl() : null;
        if (!android.text.TextUtils.isEmpty(remoteConfigUrl) && android.util.Patterns.WEB_URL.matcher(remoteConfigUrl).matches()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SAConfigOptions remote url is " + remoteConfigUrl);
        } else {
            if (android.text.TextUtils.isEmpty(serverUrl) || !android.util.Patterns.WEB_URL.matcher(serverUrl).matches()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "ServerUlr: %s, SAConfigOptions remote url: %s", serverUrl, remoteConfigUrl));
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Remote config url verification failed");
                return null;
            }
            int lastIndexOf = serverUrl.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (lastIndexOf != -1) {
                remoteConfigUrl = serverUrl.substring(0, lastIndexOf) + "/config/Android.conf";
            } else {
                remoteConfigUrl = null;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SensorsDataAPI remote url is " + remoteConfigUrl);
        }
        if (z && (com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.checkVersionIsNew(this.mContextManager.getContext(), this.mSensorsDataAPI.getSDKVersion()) || !isSecretKeyValid())) {
            z = false;
        }
        if (android.text.TextUtils.isEmpty(remoteConfigUrl)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote request url is empty");
            return "";
        }
        android.net.Uri parse = android.net.Uri.parse(remoteConfigUrl);
        android.net.Uri.Builder buildUpon = parse.buildUpon();
        if (!android.text.TextUtils.isEmpty(remoteConfigUrl) && z) {
            com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
            if (sensorsDataSDKRemoteConfig != null) {
                str2 = sensorsDataSDKRemoteConfig.getOldVersion();
                str = sensorsDataSDKRemoteConfig.getNewVersion();
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The current config: " + sensorsDataSDKRemoteConfig);
            } else {
                str = null;
            }
            if (!android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(parse.getQueryParameter("v"))) {
                buildUpon.appendQueryParameter("v", str2);
            }
            if (!android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(parse.getQueryParameter("nv"))) {
                buildUpon.appendQueryParameter("nv", str);
            }
        }
        if (!android.text.TextUtils.isEmpty(serverUrl) && android.text.TextUtils.isEmpty(parse.getQueryParameter("project"))) {
            java.lang.String queryParameter = android.net.Uri.parse(serverUrl).getQueryParameter("project");
            if (!android.text.TextUtils.isEmpty(queryParameter)) {
                buildUpon.appendQueryParameter("project", queryParameter);
            }
        }
        if (android.text.TextUtils.isEmpty(parse.getQueryParameter("app_id"))) {
            buildUpon.appendQueryParameter("app_id", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getProcessName(this.mContextManager.getContext()));
        }
        buildUpon.build();
        java.lang.String builder = buildUpon.toString();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Android remote config url is " + builder);
        return builder;
    }

    public boolean ignoreEvent(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig != null && sensorsDataSDKRemoteConfig.getEventBlacklist() != null) {
            try {
                int length = mSDKRemoteConfig.getEventBlacklist().length();
                for (int i = 0; i < length; i++) {
                    if (str.equals(mSDKRemoteConfig.getEventBlacklist().get(i))) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: " + str + " is ignored by remote config");
                        return true;
                    }
                }
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        return false;
    }

    public java.lang.Boolean isAutoTrackEnabled() {
        com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig == null) {
            return null;
        }
        if (sensorsDataSDKRemoteConfig.getAutoTrackMode() == 0) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remote config: AutoTrackMode is closing by remote config");
            return java.lang.Boolean.FALSE;
        }
        if (mSDKRemoteConfig.getAutoTrackMode() > 0) {
            return java.lang.Boolean.TRUE;
        }
        return null;
    }

    public java.lang.Boolean isAutoTrackEventTypeIgnored(int i) {
        com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig == null || sensorsDataSDKRemoteConfig.getAutoTrackMode() == -1) {
            return null;
        }
        return mSDKRemoteConfig.getAutoTrackMode() == 0 ? java.lang.Boolean.TRUE : java.lang.Boolean.valueOf(mSDKRemoteConfig.isAutoTrackEventTypeIgnored(i));
    }

    public boolean isSecretKeyValid() {
        if (!this.mContextManager.getInternalConfigs().saConfigOptions.isEnableEncrypt() || !com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().hasModuleByName(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME)) {
            return true;
        }
        java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_LOAD_SECRET_KEY, new java.lang.Object[0]);
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("key")) {
                if (!android.text.TextUtils.isEmpty(jSONObject.optString("key"))) {
                    return true;
                }
            }
            return false;
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public abstract void pullSDKConfigFromServer();

    public abstract void requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z);

    public void requestRemoteConfig(boolean z, com.sensorsdata.analytics.android.sdk.network.HttpCallback.StringCallback stringCallback) {
        try {
            java.lang.String buildRemoteUrl = buildRemoteUrl(z);
            if (android.text.TextUtils.isEmpty(buildRemoteUrl)) {
                return;
            }
            new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET, buildRemoteUrl).callback(stringCallback).execute();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public abstract void resetPullSDKConfigTimer();

    public abstract void setSDKRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig);

    public com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig toSDKRemoteConfig(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = new com.sensorsdata.analytics.android.sdk.remote.SensorsDataSDKRemoteConfig();
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                sensorsDataSDKRemoteConfig.setOldVersion(jSONObject.optString("v"));
                java.lang.String optString = jSONObject.optString("configs");
                if (android.text.TextUtils.isEmpty(optString)) {
                    sensorsDataSDKRemoteConfig.setDisableDebugMode(false);
                    sensorsDataSDKRemoteConfig.setDisableSDK(false);
                    sensorsDataSDKRemoteConfig.setAutoTrackMode(-1);
                    sensorsDataSDKRemoteConfig.setEventBlacklist(new org.json.JSONArray());
                    sensorsDataSDKRemoteConfig.setNewVersion("");
                    sensorsDataSDKRemoteConfig.setEffectMode(0);
                } else {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString);
                    sensorsDataSDKRemoteConfig.setDisableDebugMode(jSONObject2.optBoolean("disableDebugMode", false));
                    sensorsDataSDKRemoteConfig.setDisableSDK(jSONObject2.optBoolean("disableSDK", false));
                    sensorsDataSDKRemoteConfig.setAutoTrackMode(jSONObject2.optInt("autoTrackMode", -1));
                    sensorsDataSDKRemoteConfig.setEventBlacklist(jSONObject2.optJSONArray("event_blacklist"));
                    sensorsDataSDKRemoteConfig.setNewVersion(jSONObject2.optString("nv", ""));
                    sensorsDataSDKRemoteConfig.setEffectMode(jSONObject2.optInt("effect_mode", 0));
                }
                return sensorsDataSDKRemoteConfig;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return sensorsDataSDKRemoteConfig;
    }
}
