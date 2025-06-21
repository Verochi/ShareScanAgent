package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class ResponseHeader implements com.huawei.hms.core.aidl.IMessageEntity, com.huawei.hms.common.internal.ResponseErrorCode {
    private static final java.lang.String TAG = "ResponseHeader";

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String api_name;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String app_id = "";

    @com.huawei.hms.core.aidl.annotation.Packed
    private int error_code;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String error_reason;
    private android.os.Parcelable parcelable;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String pkg_name;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String resolution;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String session_id;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String srv_name;

    @com.huawei.hms.core.aidl.annotation.Packed
    private int status_code;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String transaction_id;

    public ResponseHeader() {
    }

    public ResponseHeader(int i, int i2, java.lang.String str) {
        this.status_code = i;
        this.error_code = i2;
        this.error_reason = str;
    }

    public boolean fromJson(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.status_code = com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE);
            this.error_code = com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, "error_code");
            this.error_reason = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "error_reason");
            this.srv_name = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "srv_name");
            this.api_name = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "api_name");
            this.app_id = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "app_id");
            this.pkg_name = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "pkg_name");
            this.session_id = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "session_id");
            this.transaction_id = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID);
            this.resolution = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "resolution");
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

    public java.lang.String getApiName() {
        return this.api_name;
    }

    public java.lang.String getAppID() {
        return this.app_id;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getErrorCode() {
        return this.error_code;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public java.lang.String getErrorReason() {
        return this.error_reason;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public android.os.Parcelable getParcelable() {
        return this.parcelable;
    }

    public java.lang.String getPkgName() {
        return this.pkg_name;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public java.lang.String getResolution() {
        return this.resolution;
    }

    public java.lang.String getSessionId() {
        return this.session_id;
    }

    public java.lang.String getSrvName() {
        return this.srv_name;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getStatusCode() {
        return this.status_code;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public java.lang.String getTransactionId() {
        return this.transaction_id;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public boolean hasResolution() {
        return this.parcelable != null;
    }

    public boolean isSuccess() {
        return this.status_code == 0;
    }

    public void setApiName(java.lang.String str) {
        this.api_name = str;
    }

    public void setAppID(java.lang.String str) {
        this.app_id = str;
    }

    public void setErrorCode(int i) {
        this.error_code = i;
    }

    public void setErrorReason(java.lang.String str) {
        this.error_reason = str;
    }

    public void setParcelable(android.os.Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setPkgName(java.lang.String str) {
        this.pkg_name = str;
    }

    public void setResolution(java.lang.String str) {
        this.resolution = str;
    }

    public void setSessionId(java.lang.String str) {
        this.session_id = str;
    }

    public void setSrvName(java.lang.String str) {
        this.srv_name = str;
    }

    public void setStatusCode(int i) {
        this.status_code = i;
    }

    public void setTransactionId(java.lang.String str) {
        this.transaction_id = str;
    }

    public java.lang.String toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, this.status_code);
            jSONObject.put("error_code", this.error_code);
            jSONObject.put("error_reason", this.error_reason);
            jSONObject.put("srv_name", this.srv_name);
            jSONObject.put("api_name", this.api_name);
            jSONObject.put("app_id", this.app_id);
            jSONObject.put("pkg_name", this.pkg_name);
            if (!android.text.TextUtils.isEmpty(this.session_id)) {
                jSONObject.put("session_id", this.session_id);
            }
            jSONObject.put(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);
            jSONObject.put("resolution", this.resolution);
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public java.lang.String toString() {
        return "status_code:" + this.status_code + ", error_code:" + this.error_code + ", api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", session_id:*, transaction_id:" + this.transaction_id + ", resolution:" + this.resolution;
    }
}
