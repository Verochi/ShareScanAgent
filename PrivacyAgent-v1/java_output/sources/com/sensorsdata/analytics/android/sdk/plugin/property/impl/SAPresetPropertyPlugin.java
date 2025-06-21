package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

/* loaded from: classes19.dex */
public final class SAPresetPropertyPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    private final android.content.Context mContext;
    private final boolean mDisableAndroidId;
    private final boolean mDisableTrackDeviceId;
    private org.json.JSONObject presetProperty;

    public SAPresetPropertyPlugin(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mContext = sAContextManager.getContext();
        this.mDisableTrackDeviceId = sAContextManager.getInternalConfigs().isTrackDeviceId;
        this.mDisableAndroidId = sAContextManager.getInternalConfigs().saConfigOptions.isDisableDeviceId();
    }

    private org.json.JSONObject getPreset() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String harmonyOSVersion = com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getHarmonyOSVersion();
            if (android.text.TextUtils.isEmpty(harmonyOSVersion)) {
                jSONObject.put("$os", "Android");
                jSONObject.put("$os_version", com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getOS());
            } else {
                jSONObject.put("$os", "HarmonyOS");
                jSONObject.put("$os_version", harmonyOSVersion);
            }
            jSONObject.put("$lib", "Android");
            jSONObject.put("$lib_version", com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSDKVersion());
            jSONObject.put("$manufacturer", com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getManufacturer());
            jSONObject.put("$model", com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getModel());
            jSONObject.put("$brand", com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getBrand());
            jSONObject.put("$app_version", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppVersionName(this.mContext));
            int[] deviceSize = com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getDeviceSize(this.mContext);
            jSONObject.put("$screen_width", deviceSize[0]);
            jSONObject.put("$screen_height", deviceSize[1]);
            java.lang.Integer zoneOffset = com.sensorsdata.analytics.android.sdk.util.TimeUtils.getZoneOffset();
            if (zoneOffset != null) {
                jSONObject.put("$timezone_offset", zoneOffset);
            }
            jSONObject.put("$app_id", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getProcessName(this.mContext));
            jSONObject.put("$app_name", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppName(this.mContext));
            java.lang.String identifier = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(this.mContext);
            if (!this.mDisableTrackDeviceId && !android.text.TextUtils.isEmpty(identifier)) {
                if (this.mDisableAndroidId) {
                    jSONObject.put("$anonymization_id", com.sensorsdata.analytics.android.sdk.util.Base64Coder.encodeString(identifier));
                } else {
                    jSONObject.put("$device_id", identifier);
                }
            }
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public org.json.JSONObject getPresetProperties() {
        try {
            if (this.presetProperty == null) {
                this.presetProperty = new org.json.JSONObject(getPreset().toString());
            }
            java.lang.String networkType = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(this.mContext);
            this.presetProperty.put("$wifi", "WIFI".equals(networkType));
            this.presetProperty.put("$network_type", networkType);
            return new org.json.JSONObject(this.presetProperty.toString());
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new org.json.JSONObject();
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return sAPropertyFilter.getType().isTrack();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        try {
            org.json.JSONObject presetProperties = getPresetProperties();
            if (sAPropertiesFetcher.getProperties().has("$lib_version")) {
                presetProperties.remove("$lib_version");
            }
            if (sAPropertiesFetcher.getProperties().has("$lib")) {
                presetProperties.remove("$lib");
            }
            if (sAPropertiesFetcher.getProperties().has("$app_version")) {
                presetProperties.remove("$app_version");
            }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(presetProperties, sAPropertiesFetcher.getProperties());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
