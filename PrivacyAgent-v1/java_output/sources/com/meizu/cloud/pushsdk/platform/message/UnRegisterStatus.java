package com.meizu.cloud.pushsdk.platform.message;

/* loaded from: classes23.dex */
public class UnRegisterStatus extends com.meizu.cloud.pushsdk.platform.message.BasicPushStatus {
    private boolean isUnRegisterSuccess;

    public UnRegisterStatus() {
    }

    public UnRegisterStatus(java.lang.String str) {
        super(str);
    }

    public boolean isUnRegisterSuccess() {
        return this.isUnRegisterSuccess;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject.isNull("result")) {
            return;
        }
        setIsUnRegisterSuccess(jSONObject.getBoolean("result"));
    }

    public void setIsUnRegisterSuccess(boolean z) {
        this.isUnRegisterSuccess = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public java.lang.String toString() {
        return super.toString() + " UnRegisterStatus{isUnRegisterSuccess=" + this.isUnRegisterSuccess + '}';
    }
}
