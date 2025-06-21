package com.sensorsdata.analytics.android.sdk.core.business.exposure;

/* loaded from: classes19.dex */
public class SAExposureData {
    private java.lang.String event;
    private com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig exposureConfig;
    private final java.lang.String exposureIdentifier;
    private com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener exposureListener;
    private org.json.JSONObject properties;

    public SAExposureData(java.lang.String str) {
        this(str, null, null, null);
    }

    public SAExposureData(java.lang.String str, java.lang.String str2) {
        this(str, null, str2, null);
    }

    public SAExposureData(java.lang.String str, org.json.JSONObject jSONObject) {
        this(str, jSONObject, null, null);
    }

    public SAExposureData(java.lang.String str, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig) {
        this(str, jSONObject, null, sAExposureConfig);
    }

    public SAExposureData(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        this(str, jSONObject, str2, null);
    }

    public SAExposureData(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig) {
        this.event = str;
        try {
            this.properties = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        this.exposureIdentifier = str2;
        this.exposureConfig = sAExposureConfig;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData = (com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData) obj;
        return this.exposureConfig.equals(sAExposureData.exposureConfig) && this.properties.toString().equals(sAExposureData.properties.toString()) && this.event.equals(sAExposureData.event) && this.exposureIdentifier.equals(sAExposureData.exposureIdentifier);
    }

    public java.lang.String getEvent() {
        return this.event;
    }

    public com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig getExposureConfig() {
        return this.exposureConfig;
    }

    public com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener getExposureListener() {
        return this.exposureListener;
    }

    public java.lang.String getIdentifier() {
        return this.exposureIdentifier;
    }

    public org.json.JSONObject getProperties() {
        return this.properties;
    }

    public void setEvent(java.lang.String str) {
        this.event = str;
    }

    public void setExposureConfig(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig) {
        this.exposureConfig = sAExposureConfig;
    }

    public void setExposureListener(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener sAExposureListener) {
        this.exposureListener = sAExposureListener;
    }

    public void setProperties(org.json.JSONObject jSONObject) {
        try {
            this.properties = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public java.lang.String toString() {
        return "SAExposureData{exposureConfig=" + this.exposureConfig + ", properties=" + this.properties + ", event='" + this.event + "', exposureIdentifier='" + this.exposureIdentifier + "'}";
    }
}
