package com.meizu.cloud.pushsdk.platform.message;

/* loaded from: classes23.dex */
public class PushSwitchStatus extends com.meizu.cloud.pushsdk.platform.message.BasicPushStatus {
    private java.lang.String pushId;
    private boolean switchNotificationMessage;
    private boolean switchThroughMessage;

    public PushSwitchStatus() {
    }

    public PushSwitchStatus(java.lang.String str) {
        super(str);
    }

    public java.lang.String getPushId() {
        return this.pushId;
    }

    public boolean isSwitchNotificationMessage() {
        return this.switchNotificationMessage;
    }

    public boolean isSwitchThroughMessage() {
        return this.switchThroughMessage;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID));
        }
        if (!jSONObject.isNull("barTypeSwitch")) {
            setSwitchNotificationMessage(jSONObject.getInt("barTypeSwitch") == 1);
        }
        if (jSONObject.isNull("directTypeSwitch")) {
            return;
        }
        setSwitchThroughMessage(jSONObject.getInt("directTypeSwitch") == 1);
    }

    public void setPushId(java.lang.String str) {
        this.pushId = str;
    }

    public void setSwitchNotificationMessage(boolean z) {
        this.switchNotificationMessage = z;
    }

    public void setSwitchThroughMessage(boolean z) {
        this.switchThroughMessage = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public java.lang.String toString() {
        return super.toString() + "PushSwitchStatus{switchNotificationMessage=" + this.switchNotificationMessage + ", switchThroughMessage=" + this.switchThroughMessage + ", pushId='" + this.pushId + "'}";
    }
}
