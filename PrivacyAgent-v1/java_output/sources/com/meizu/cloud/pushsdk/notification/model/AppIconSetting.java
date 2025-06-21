package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class AppIconSetting implements android.os.Parcelable {
    public static final java.lang.String APP_ICON_SETTING = "is";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AppIconSetting> CREATOR = new com.meizu.cloud.pushsdk.notification.model.AppIconSetting.AnonymousClass1();
    public static final java.lang.String DEFAULT_LARGE_ICON = "di";
    public static final java.lang.String LARGE_ICON_URL = "li";
    public static final java.lang.String TAG = "app_icon_setting";
    private boolean defaultLargeIcon;
    private java.lang.String largeIconUrl;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.AppIconSetting$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AppIconSetting> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AppIconSetting createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.AppIconSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AppIconSetting[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.AppIconSetting[i];
        }
    }

    public AppIconSetting() {
        this.defaultLargeIcon = true;
    }

    public AppIconSetting(android.os.Parcel parcel) {
        this.defaultLargeIcon = true;
        this.defaultLargeIcon = parcel.readByte() != 0;
        this.largeIconUrl = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.AppIconSetting parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.AppIconSetting parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.AppIconSetting appIconSetting = new com.meizu.cloud.pushsdk.notification.model.AppIconSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(DEFAULT_LARGE_ICON)) {
                    appIconSetting.setDefaultLargeIcon(jSONObject.getInt(DEFAULT_LARGE_ICON) != 0);
                }
                if (!jSONObject.isNull(LARGE_ICON_URL)) {
                    appIconSetting.setLargeIconUrl(jSONObject.getString(LARGE_ICON_URL));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return appIconSetting;
        }
        str = "no such tag app_icon_setting";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return appIconSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getLargeIconUrl() {
        return this.largeIconUrl;
    }

    public boolean isDefaultLargeIcon() {
        return this.defaultLargeIcon;
    }

    public void setDefaultLargeIcon(boolean z) {
        this.defaultLargeIcon = z;
    }

    public void setLargeIconUrl(java.lang.String str) {
        this.largeIconUrl = str;
    }

    public java.lang.String toString() {
        return "AppIconSetting{defaultLargeIcon=" + this.defaultLargeIcon + ", largeIconUrl='" + this.largeIconUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.defaultLargeIcon ? (byte) 1 : (byte) 0);
        parcel.writeString(this.largeIconUrl);
    }
}
