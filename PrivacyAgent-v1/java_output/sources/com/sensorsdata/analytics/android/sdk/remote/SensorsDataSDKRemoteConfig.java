package com.sensorsdata.analytics.android.sdk.remote;

/* loaded from: classes19.dex */
public class SensorsDataSDKRemoteConfig {
    static final int REMOTE_EVENT_TYPE_NO_USE = -1;
    private int effectMode;
    private org.json.JSONArray eventBlacklist;
    private int mAutoTrackEventType;
    private com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey mSecretKey;
    private java.lang.String newVersion;
    private java.lang.String oldVersion;
    private boolean disableDebugMode = false;
    private boolean disableSDK = false;
    private int autoTrackMode = -1;

    public int getAutoTrackEventType() {
        return this.mAutoTrackEventType;
    }

    public int getAutoTrackMode() {
        return this.autoTrackMode;
    }

    public int getEffectMode() {
        return this.effectMode;
    }

    public org.json.JSONArray getEventBlacklist() {
        return this.eventBlacklist;
    }

    public java.lang.String getNewVersion() {
        return this.newVersion;
    }

    public java.lang.String getOldVersion() {
        return this.oldVersion;
    }

    public com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey getSecretKey() {
        return this.mSecretKey;
    }

    public boolean isAutoTrackEventTypeIgnored(int i) {
        int i2 = this.autoTrackMode;
        if (i2 == -1) {
            return false;
        }
        if (i2 == 0) {
            return true;
        }
        int i3 = this.mAutoTrackEventType;
        return (i | i3) != i3;
    }

    public boolean isDisableDebugMode() {
        return this.disableDebugMode;
    }

    public boolean isDisableSDK() {
        return this.disableSDK;
    }

    public void setAutoTrackMode(int i) {
        this.autoTrackMode = i;
        if (i == -1 || i == 0) {
            this.mAutoTrackEventType = 0;
            return;
        }
        if ((i & 1) == 1) {
            this.mAutoTrackEventType |= 1;
        }
        if ((i & 2) == 2) {
            this.mAutoTrackEventType |= 2;
        }
        if ((i & 4) == 4) {
            this.mAutoTrackEventType |= 4;
        }
        if ((i & 8) == 8) {
            this.mAutoTrackEventType |= 8;
        }
    }

    public void setDisableDebugMode(boolean z) {
        this.disableDebugMode = z;
    }

    public void setDisableSDK(boolean z) {
        this.disableSDK = z;
    }

    public void setEffectMode(int i) {
        this.effectMode = i;
    }

    public void setEventBlacklist(org.json.JSONArray jSONArray) {
        this.eventBlacklist = jSONArray;
    }

    public void setNewVersion(java.lang.String str) {
        this.newVersion = str;
    }

    public void setOldVersion(java.lang.String str) {
        this.oldVersion = str;
    }

    public void setSecretKey(com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        this.mSecretKey = secreteKey;
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("v", this.oldVersion);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("disableDebugMode", this.disableDebugMode);
            jSONObject2.put("autoTrackMode", this.autoTrackMode);
            jSONObject2.put("disableSDK", this.disableSDK);
            jSONObject2.put("event_blacklist", this.eventBlacklist);
            jSONObject2.put("nv", this.newVersion);
            jSONObject2.put("effect_mode", this.effectMode);
            jSONObject.put("configs", jSONObject2);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public java.lang.String toString() {
        return "{ v=" + this.oldVersion + ", disableDebugMode=" + this.disableDebugMode + ", disableSDK=" + this.disableSDK + ", autoTrackMode=" + this.autoTrackMode + ", event_blacklist=" + this.eventBlacklist + ", nv=" + this.newVersion + ", effect_mode=" + this.effectMode + com.alipay.sdk.m.u.i.d;
    }
}
