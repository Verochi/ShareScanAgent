package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class NotificationStyle implements android.os.Parcelable {
    public static final java.lang.String BANNER_IMAGE_URL = "bi";
    public static final java.lang.String BASE_STYLE = "bs";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.NotificationStyle> CREATOR = new com.meizu.cloud.pushsdk.notification.model.NotificationStyle.AnonymousClass1();
    public static final java.lang.String EXPANDABLE_IMAGE_URL = "ei";
    public static final java.lang.String EXPANDABLE_TEXT = "et";
    public static final java.lang.String INNER_STYLE = "is";
    public static final java.lang.String NOTIFICATION_STYLE = "ns";
    public static final java.lang.String TAG = "notification_style";
    private java.lang.String bannerImageUrl;
    private int baseStyle;
    private java.lang.String expandableImageUrl;
    private java.lang.String expandableText;
    private int innerStyle;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.NotificationStyle$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.NotificationStyle> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.NotificationStyle createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.NotificationStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.NotificationStyle[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.NotificationStyle[i];
        }
    }

    public NotificationStyle() {
        this.baseStyle = 0;
        this.innerStyle = 0;
    }

    public NotificationStyle(android.os.Parcel parcel) {
        this.baseStyle = 0;
        this.innerStyle = 0;
        this.baseStyle = parcel.readInt();
        this.innerStyle = parcel.readInt();
        this.expandableText = parcel.readString();
        this.expandableImageUrl = parcel.readString();
        this.bannerImageUrl = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.NotificationStyle parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.NotificationStyle parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.NotificationStyle notificationStyle = new com.meizu.cloud.pushsdk.notification.model.NotificationStyle();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("bs")) {
                    notificationStyle.setBaseStyle(jSONObject.getInt("bs"));
                }
                if (!jSONObject.isNull("is")) {
                    notificationStyle.setInnerStyle(jSONObject.getInt("is"));
                }
                if (!jSONObject.isNull("et")) {
                    notificationStyle.setExpandableText(jSONObject.getString("et"));
                }
                if (!jSONObject.isNull(EXPANDABLE_IMAGE_URL)) {
                    notificationStyle.setExpandableImageUrl(jSONObject.getString(EXPANDABLE_IMAGE_URL));
                }
                if (!jSONObject.isNull("bi")) {
                    notificationStyle.setBannerImageUrl(jSONObject.getString("bi"));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return notificationStyle;
        }
        str = "no such tag notification_style";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return notificationStyle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getBannerImageUrl() {
        return this.bannerImageUrl;
    }

    public int getBaseStyle() {
        return this.baseStyle;
    }

    public java.lang.String getExpandableImageUrl() {
        return this.expandableImageUrl;
    }

    public java.lang.String getExpandableText() {
        return this.expandableText;
    }

    public int getInnerStyle() {
        return this.innerStyle;
    }

    public void setBannerImageUrl(java.lang.String str) {
        this.bannerImageUrl = str;
    }

    public void setBaseStyle(int i) {
        this.baseStyle = i;
    }

    public void setExpandableImageUrl(java.lang.String str) {
        this.expandableImageUrl = str;
    }

    public void setExpandableText(java.lang.String str) {
        this.expandableText = str;
    }

    public void setInnerStyle(int i) {
        this.innerStyle = i;
    }

    public java.lang.String toString() {
        return "NotificationStyle{baseStyle=" + this.baseStyle + ", innerStyle=" + this.innerStyle + ", expandableText='" + this.expandableText + "', expandableImageUrl='" + this.expandableImageUrl + "', bannerImageUrl='" + this.bannerImageUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.baseStyle);
        parcel.writeInt(this.innerStyle);
        parcel.writeString(this.expandableText);
        parcel.writeString(this.expandableImageUrl);
        parcel.writeString(this.bannerImageUrl);
    }
}
