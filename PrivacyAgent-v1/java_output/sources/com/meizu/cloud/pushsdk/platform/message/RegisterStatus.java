package com.meizu.cloud.pushsdk.platform.message;

/* loaded from: classes23.dex */
public class RegisterStatus extends com.meizu.cloud.pushsdk.platform.message.BasicPushStatus {
    private int expireTime;
    private java.lang.String pushId;

    public RegisterStatus() {
    }

    public RegisterStatus(java.lang.String str) {
        super(str);
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public java.lang.String getPushId() {
        return this.pushId;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull("expireTime")) {
            return;
        }
        setExpireTime(jSONObject.getInt("expireTime"));
    }

    public void setExpireTime(int i) {
        this.expireTime = i;
    }

    public void setPushId(java.lang.String str) {
        this.pushId = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public java.lang.String toString() {
        return super.toString() + "pushId='" + this.pushId + "', Become invalid after " + this.expireTime + " seconds }";
    }
}
