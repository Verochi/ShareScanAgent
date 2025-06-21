package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class TimeDisplaySetting implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting> CREATOR = new com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.AnonymousClass1();
    public static final java.lang.String END_SHOW_TIME = "et";
    public static final java.lang.String START_SHOW_TIME = "st";
    public static final java.lang.String TAG = "time_display_setting";
    public static final java.lang.String TIME_DISPLAY = "td";
    public static final java.lang.String TIME_DISPLAY_SETTING = "ts";
    private java.lang.String endShowTime;
    private boolean isTimeDisplay;
    private java.lang.String startShowTime;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting[i];
        }
    }

    public TimeDisplaySetting() {
    }

    public TimeDisplaySetting(android.os.Parcel parcel) {
        this.isTimeDisplay = parcel.readByte() != 0;
        this.startShowTime = parcel.readString();
        this.endShowTime = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting timeDisplaySetting = new com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(TIME_DISPLAY)) {
                    timeDisplaySetting.setIsTimeDisplay(jSONObject.getInt(TIME_DISPLAY) != 0);
                }
                if (!jSONObject.isNull("st")) {
                    timeDisplaySetting.setStartShowTime(jSONObject.getString("st"));
                }
                if (!jSONObject.isNull("et")) {
                    timeDisplaySetting.setEndShowTime(jSONObject.getString("et"));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return timeDisplaySetting;
        }
        str = "no such tag time_display_setting";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return timeDisplaySetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getEndShowTime() {
        return this.endShowTime;
    }

    public java.lang.String getStartShowTime() {
        return this.startShowTime;
    }

    public boolean isTimeDisplay() {
        return this.isTimeDisplay;
    }

    public void setEndShowTime(java.lang.String str) {
        this.endShowTime = str;
    }

    public void setIsTimeDisplay(boolean z) {
        this.isTimeDisplay = z;
    }

    public void setStartShowTime(java.lang.String str) {
        this.startShowTime = str;
    }

    public java.lang.String toString() {
        return "TimeDisplaySetting{isTimeDisplay=" + this.isTimeDisplay + ", startShowTime='" + this.startShowTime + "', endShowTime='" + this.endShowTime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.isTimeDisplay ? (byte) 1 : (byte) 0);
        parcel.writeString(this.startShowTime);
        parcel.writeString(this.endShowTime);
    }
}
