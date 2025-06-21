package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class ActVideoSetting implements android.os.Parcelable {
    public static final java.lang.String ACT_URL = "au";
    public static final java.lang.String ACT_VIDEO_SETTING = "acts";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.ActVideoSetting> CREATOR = new com.meizu.cloud.pushsdk.notification.model.ActVideoSetting.AnonymousClass1();
    public static final java.lang.String TAG = "ActVideoSetting";
    public static final java.lang.String WIFI_DISPLAY = "wd";
    private java.lang.String actUrl;
    private boolean wifiDisplay;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.ActVideoSetting$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.ActVideoSetting> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.ActVideoSetting createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.ActVideoSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.ActVideoSetting[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.ActVideoSetting[i];
        }
    }

    public ActVideoSetting() {
    }

    public ActVideoSetting(android.os.Parcel parcel) {
        this.wifiDisplay = parcel.readByte() != 0;
        this.actUrl = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.ActVideoSetting parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.ActVideoSetting parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.ActVideoSetting actVideoSetting = new com.meizu.cloud.pushsdk.notification.model.ActVideoSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("wd")) {
                    actVideoSetting.setWifiDisplay(jSONObject.getInt("wd") != 0);
                }
                if (!jSONObject.isNull(ACT_URL)) {
                    actVideoSetting.setActUrl(jSONObject.getString(ACT_URL));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return actVideoSetting;
        }
        str = "no such tag ActVideoSetting";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return actVideoSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getActUrl() {
        return this.actUrl;
    }

    public boolean isWifiDisplay() {
        return this.wifiDisplay;
    }

    public void setActUrl(java.lang.String str) {
        this.actUrl = str;
    }

    public void setWifiDisplay(boolean z) {
        this.wifiDisplay = z;
    }

    public java.lang.String toString() {
        return "ActVideoSetting{wifiDisplay=" + this.wifiDisplay + ", actUrl='" + this.actUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.wifiDisplay ? (byte) 1 : (byte) 0);
        parcel.writeString(this.actUrl);
    }
}
