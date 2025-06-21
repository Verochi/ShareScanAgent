package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class AdvanceSetting implements android.os.Parcelable {
    public static final java.lang.String ADVANCE_SETTING = "as";
    public static final java.lang.String CLEAR_NOTIFICATION = "cn";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AdvanceSetting> CREATOR = new com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.AnonymousClass1();
    public static final java.lang.String HEAD_UP_NOTIFICATION = "hn";
    public static final java.lang.String NETWORK_TYPE = "it";
    public static final java.lang.String NOTIFY_TYPE = "nt";
    public static final java.lang.String TAG = "advance_setting";
    private boolean clearNotification;
    private boolean headUpNotification;
    private int netWorkType;
    private com.meizu.cloud.pushsdk.notification.model.NotifyType notifyType;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.AdvanceSetting$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AdvanceSetting> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AdvanceSetting createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.AdvanceSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AdvanceSetting[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.AdvanceSetting[i];
        }
    }

    public AdvanceSetting() {
        this.netWorkType = 1;
        this.clearNotification = true;
        this.headUpNotification = true;
    }

    public AdvanceSetting(android.os.Parcel parcel) {
        this.netWorkType = 1;
        this.clearNotification = true;
        this.headUpNotification = true;
        this.netWorkType = parcel.readInt();
        this.notifyType = (com.meizu.cloud.pushsdk.notification.model.NotifyType) parcel.readParcelable(com.meizu.cloud.pushsdk.notification.model.NotifyType.class.getClassLoader());
        this.clearNotification = parcel.readByte() != 0;
        this.headUpNotification = parcel.readByte() != 0;
    }

    public static com.meizu.cloud.pushsdk.notification.model.AdvanceSetting parse(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                jSONObject = new org.json.JSONObject(str);
            } catch (org.json.JSONException e) {
                com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static com.meizu.cloud.pushsdk.notification.model.AdvanceSetting parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.AdvanceSetting advanceSetting = new com.meizu.cloud.pushsdk.notification.model.AdvanceSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("it")) {
                    advanceSetting.setNetWorkType(jSONObject.getInt("it"));
                }
                if (!jSONObject.isNull("nt")) {
                    advanceSetting.setNotifyType(com.meizu.cloud.pushsdk.notification.model.NotifyType.parse(jSONObject.getJSONObject("nt")));
                }
                boolean z = true;
                if (!jSONObject.isNull(CLEAR_NOTIFICATION)) {
                    advanceSetting.setClearNotification(jSONObject.getInt(CLEAR_NOTIFICATION) != 0);
                }
                if (!jSONObject.isNull("hn")) {
                    if (jSONObject.getInt("hn") == 0) {
                        z = false;
                    }
                    advanceSetting.setHeadUpNotification(z);
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return advanceSetting;
        }
        str = "no such tag advance_setting";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return advanceSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getNetWorkType() {
        return this.netWorkType;
    }

    public com.meizu.cloud.pushsdk.notification.model.NotifyType getNotifyType() {
        return this.notifyType;
    }

    public boolean isClearNotification() {
        return this.clearNotification;
    }

    public boolean isHeadUpNotification() {
        return this.headUpNotification;
    }

    public void setClearNotification(boolean z) {
        this.clearNotification = z;
    }

    public void setHeadUpNotification(boolean z) {
        this.headUpNotification = z;
    }

    public void setNetWorkType(int i) {
        this.netWorkType = i;
    }

    public void setNotifyType(com.meizu.cloud.pushsdk.notification.model.NotifyType notifyType) {
        this.notifyType = notifyType;
    }

    public java.lang.String toString() {
        return "AdvanceSetting{netWorkType=" + this.netWorkType + ", notifyType=" + this.notifyType + ", clearNotification=" + this.clearNotification + ", headUpNotification=" + this.headUpNotification + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.netWorkType);
        parcel.writeParcelable(this.notifyType, i);
        parcel.writeByte(this.clearNotification ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.headUpNotification ? (byte) 1 : (byte) 0);
    }
}
