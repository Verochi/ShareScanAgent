package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class RequestHeader implements com.huawei.hms.core.aidl.IMessageEntity {
    private static final java.lang.String TAG = "RequestHeader";

    @com.huawei.hms.core.aidl.annotation.Packed
    private int apiLevel;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String api_name;

    @com.huawei.hms.core.aidl.annotation.Packed
    private int kitSdkVersion;
    private android.os.Parcelable parcelable;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String pkg_name;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String session_id;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String srv_name;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String transaction_id;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String app_id = "";

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String version = "4.0";

    @com.huawei.hms.core.aidl.annotation.Packed
    private int sdk_version = 60500300;

    public boolean fromJson(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.version = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "version");
            this.srv_name = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "srv_name");
            this.api_name = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "api_name");
            this.app_id = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "app_id");
            this.pkg_name = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "pkg_name");
            this.sdk_version = com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, "sdk_version");
            this.kitSdkVersion = com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, "kitSdkVersion");
            this.apiLevel = com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, "apiLevel");
            this.session_id = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "session_id");
            this.transaction_id = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID);
            return true;
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
            return false;
        }
    }

    public java.lang.String getActualAppID() {
        if (android.text.TextUtils.isEmpty(this.app_id)) {
            return "";
        }
        java.lang.String[] split = this.app_id.split("\\|");
        return split.length == 0 ? "" : split.length == 1 ? split[0] : split[1];
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public java.lang.String getApiName() {
        return this.api_name;
    }

    public java.lang.String getAppID() {
        return this.app_id;
    }

    public int getKitSdkVersion() {
        return this.kitSdkVersion;
    }

    public android.os.Parcelable getParcelable() {
        return this.parcelable;
    }

    public java.lang.String getPkgName() {
        return this.pkg_name;
    }

    public int getSdkVersion() {
        return this.sdk_version;
    }

    public java.lang.String getSessionId() {
        return this.session_id;
    }

    public java.lang.String getSrvName() {
        return this.srv_name;
    }

    public java.lang.String getTransactionId() {
        return this.transaction_id;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setApiName(java.lang.String str) {
        this.api_name = str;
    }

    public void setAppID(java.lang.String str) {
        this.app_id = str;
    }

    public void setKitSdkVersion(int i) {
        this.kitSdkVersion = i;
    }

    public void setParcelable(android.os.Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setPkgName(java.lang.String str) {
        this.pkg_name = str;
    }

    public void setSdkVersion(int i) {
        this.sdk_version = i;
    }

    public void setSessionId(java.lang.String str) {
        this.session_id = str;
    }

    public void setSrvName(java.lang.String str) {
        this.srv_name = str;
    }

    public void setTransactionId(java.lang.String str) {
        this.transaction_id = str;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }

    public java.lang.String toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", this.version);
            jSONObject.put("srv_name", this.srv_name);
            jSONObject.put("api_name", this.api_name);
            jSONObject.put("app_id", this.app_id);
            jSONObject.put("pkg_name", this.pkg_name);
            jSONObject.put("sdk_version", this.sdk_version);
            jSONObject.put("kitSdkVersion", this.kitSdkVersion);
            jSONObject.put("apiLevel", this.apiLevel);
            if (!android.text.TextUtils.isEmpty(this.session_id)) {
                jSONObject.put("session_id", this.session_id);
            }
            jSONObject.put(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public java.lang.String toString() {
        return "api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", sdk_version:" + this.sdk_version + ", session_id:*, transaction_id:" + this.transaction_id + ", kitSdkVersion:" + this.kitSdkVersion + ", apiLevel:" + this.apiLevel;
    }
}
