package com.meizu.cloud.pushsdk.platform.message;

/* loaded from: classes23.dex */
public class SubAliasStatus extends com.meizu.cloud.pushsdk.platform.message.BasicPushStatus {
    private java.lang.String alias;
    private java.lang.String pushId;

    public SubAliasStatus() {
    }

    public SubAliasStatus(java.lang.String str) {
        super(str);
    }

    public java.lang.String getAlias() {
        return this.alias;
    }

    public java.lang.String getPushId() {
        return this.pushId;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME)) {
            return;
        }
        setAlias(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME));
    }

    public void setAlias(java.lang.String str) {
        this.alias = str;
    }

    public void setPushId(java.lang.String str) {
        this.pushId = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public java.lang.String toString() {
        return super.toString() + " SubAliasStatus{pushId='" + this.pushId + "', alias='" + this.alias + "'}";
    }
}
