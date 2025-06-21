package com.huawei.hms.activity.internal;

/* loaded from: classes22.dex */
public class ForegroundInnerHeader {
    private static final java.lang.String TAG = "ForegroundInnerHeader";
    private java.lang.String action;
    private int apkVersion;
    private java.lang.String responseCallbackKey;

    public void fromJson(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.apkVersion = com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.action = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "action");
            this.responseCallbackKey = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
        }
    }

    public java.lang.String getAction() {
        return this.action;
    }

    public int getApkVersion() {
        return this.apkVersion;
    }

    public java.lang.String getResponseCallbackKey() {
        return this.responseCallbackKey;
    }

    public void setAction(java.lang.String str) {
        this.action = str;
    }

    public void setApkVersion(int i) {
        this.apkVersion = i;
    }

    public void setResponseCallbackKey(java.lang.String str) {
        this.responseCallbackKey = str;
    }

    public java.lang.String toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("apkVersion", this.apkVersion);
            jSONObject.put("action", this.action);
            jSONObject.put("responseCallbackKey", this.responseCallbackKey);
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "ForegroundInnerHeader toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public java.lang.String toString() {
        return "apkVersion:" + this.apkVersion + ", action:" + this.action + ", responseCallbackKey:" + this.responseCallbackKey;
    }
}
