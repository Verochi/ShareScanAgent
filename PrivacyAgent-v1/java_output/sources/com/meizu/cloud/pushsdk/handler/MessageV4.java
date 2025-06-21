package com.meizu.cloud.pushsdk.handler;

/* loaded from: classes23.dex */
public class MessageV4 extends com.meizu.cloud.pushsdk.handler.MessageV3 {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.MessageV3> CREATOR = new com.meizu.cloud.pushsdk.handler.MessageV4.AnonymousClass1();
    private static final java.lang.String TAG = "MessageV4";
    private com.meizu.cloud.pushsdk.notification.model.ActVideoSetting actVideoSetting;

    /* renamed from: com.meizu.cloud.pushsdk.handler.MessageV4$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.MessageV3> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.MessageV4 createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.MessageV4(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.MessageV4[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.MessageV4[i];
        }
    }

    public MessageV4() {
    }

    public MessageV4(android.os.Parcel parcel) {
        super(parcel);
        this.actVideoSetting = (com.meizu.cloud.pushsdk.notification.model.ActVideoSetting) parcel.readParcelable(com.meizu.cloud.pushsdk.notification.model.ActVideoSetting.class.getClassLoader());
    }

    public static com.meizu.cloud.pushsdk.handler.MessageV4 parse(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.MessageV4 messageV4 = new com.meizu.cloud.pushsdk.handler.MessageV4();
        if (!android.text.TextUtils.isEmpty(messageV3.getNotificationMessage())) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(messageV3.getNotificationMessage()).getJSONObject("data");
                if (!jSONObject.isNull("extra")) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.notification.model.ActVideoSetting.ACT_VIDEO_SETTING)) {
                        messageV4.setActVideoSetting(com.meizu.cloud.pushsdk.notification.model.ActVideoSetting.parse(jSONObject2.getJSONObject(com.meizu.cloud.pushsdk.notification.model.ActVideoSetting.ACT_VIDEO_SETTING)));
                    }
                }
            } catch (org.json.JSONException e) {
                com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "parse messageV4 error " + e.getMessage());
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.i(TAG, "MessageV4 " + messageV4);
        return messageV4;
    }

    public com.meizu.cloud.pushsdk.notification.model.ActVideoSetting getActVideoSetting() {
        return this.actVideoSetting;
    }

    public void setActVideoSetting(com.meizu.cloud.pushsdk.notification.model.ActVideoSetting actVideoSetting) {
        this.actVideoSetting = actVideoSetting;
    }

    @Override // com.meizu.cloud.pushsdk.handler.MessageV3
    public java.lang.String toString() {
        return "MessageV4{actVideoSetting=" + this.actVideoSetting + '}' + super.toString();
    }

    @Override // com.meizu.cloud.pushsdk.handler.MessageV3, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.actVideoSetting, i);
    }
}
