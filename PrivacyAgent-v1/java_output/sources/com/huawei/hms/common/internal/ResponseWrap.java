package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class ResponseWrap {
    private static final java.lang.String TAG = "ResponseWrap";
    private java.lang.String body;
    private com.huawei.hms.common.internal.ResponseHeader responseHeader;

    public ResponseWrap(com.huawei.hms.common.internal.ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public boolean fromJson(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.responseHeader.setStatusCode(com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE));
            this.responseHeader.setErrorCode(com.huawei.hms.utils.JsonUtil.getIntValue(jSONObject, "error_code"));
            this.responseHeader.setErrorReason(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.responseHeader.setSrvName(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.responseHeader.setApiName(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "api_name"));
            this.responseHeader.setAppID(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "app_id"));
            this.responseHeader.setPkgName(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.responseHeader.setSessionId(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "session_id"));
            this.responseHeader.setTransactionId(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID));
            this.responseHeader.setResolution(com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "resolution"));
            this.body = com.huawei.hms.utils.JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
            return false;
        }
    }

    public java.lang.String getBody() {
        if (android.text.TextUtils.isEmpty(this.body)) {
            this.body = new org.json.JSONObject().toString();
        }
        return this.body;
    }

    public com.huawei.hms.common.internal.ResponseHeader getResponseHeader() {
        return this.responseHeader;
    }

    public void setBody(java.lang.String str) {
        this.body = str;
    }

    public void setResponseHeader(com.huawei.hms.common.internal.ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public java.lang.String toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, this.responseHeader.getStatusCode());
            jSONObject.put("error_code", this.responseHeader.getErrorCode());
            jSONObject.put("error_reason", this.responseHeader.getErrorReason());
            jSONObject.put("srv_name", this.responseHeader.getSrvName());
            jSONObject.put("api_name", this.responseHeader.getApiName());
            jSONObject.put("app_id", this.responseHeader.getAppID());
            jSONObject.put("pkg_name", this.responseHeader.getPkgName());
            jSONObject.put(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, this.responseHeader.getTransactionId());
            jSONObject.put("resolution", this.responseHeader.getResolution());
            java.lang.String sessionId = this.responseHeader.getSessionId();
            if (!android.text.TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!android.text.TextUtils.isEmpty(this.body)) {
                jSONObject.put("body", this.body);
            }
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public java.lang.String toString() {
        return "ResponseWrap{body='" + this.body + "', responseHeader=" + this.responseHeader + '}';
    }
}
