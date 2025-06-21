package com.meizu.cloud.pushsdk.platform.message;

/* loaded from: classes23.dex */
public abstract class BasicPushStatus implements java.io.Serializable {
    public static final java.lang.String SUCCESS_CODE = "200";
    public static final java.lang.String TAG = "BasicPushStatus";
    public java.lang.String code;
    public java.lang.String message;

    public BasicPushStatus() {
    }

    public BasicPushStatus(java.lang.String str) {
        org.json.JSONObject parse = parse(str);
        if (parse == null || !SUCCESS_CODE.equals(this.code) || parse.isNull("value")) {
            return;
        }
        try {
            parseValueData(parse.getJSONObject("value"));
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "parse value data error " + e.getMessage() + " json " + str);
        }
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public org.json.JSONObject parse(java.lang.String str) {
        org.json.JSONObject jSONObject = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
            try {
                if (!jSONObject2.isNull("code")) {
                    setCode(jSONObject2.getString("code"));
                }
                if (!jSONObject2.isNull("message")) {
                    setMessage(jSONObject2.getString("message"));
                }
                return jSONObject2;
            } catch (org.json.JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "covert json error " + e.getMessage());
                return jSONObject;
            }
        } catch (org.json.JSONException e2) {
            e = e2;
        }
    }

    public abstract void parseValueData(org.json.JSONObject jSONObject) throws org.json.JSONException;

    public void setCode(java.lang.String str) {
        this.code = str;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public java.lang.String toString() {
        return "BasicPushStatus{code='" + this.code + "', message='" + this.message + "'}";
    }
}
