package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class BrightRemindSetting implements android.os.Parcelable {
    public static final java.lang.String BRIGHT_REMIND = "br";
    public static final java.lang.String BRIGHT_REMIND_SETTING = "bs";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting> CREATOR = new com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting.AnonymousClass1();
    public static final java.lang.String TAG = "BrightRemindSetting";
    private boolean isBrightRemind;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting[i];
        }
    }

    public BrightRemindSetting() {
    }

    public BrightRemindSetting(android.os.Parcel parcel) {
        this.isBrightRemind = parcel.readByte() == 1;
    }

    public static com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting brightRemindSetting = new com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("br")) {
                    brightRemindSetting.setIsBrightRemind(jSONObject.getInt("br") != 0);
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return brightRemindSetting;
        }
        str = "no such tag BrightRemindSetting";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return brightRemindSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getIsBrightRemind() {
        return this.isBrightRemind;
    }

    public void setIsBrightRemind(boolean z) {
        this.isBrightRemind = z;
    }

    public java.lang.String toString() {
        return "BrightRemindSetting{isBrightRemind=" + this.isBrightRemind + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.isBrightRemind ? (byte) 1 : (byte) 0);
    }
}
