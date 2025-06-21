package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class AdvertisementOption implements android.os.Parcelable {
    public static final java.lang.String ADVERTISEMENT_OPTION = "ado";
    public static final java.lang.String AD_INSTALL_PACKAGE = "aip";
    public static final java.lang.String AD_PACKAGE = "ap";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AdvertisementOption> CREATOR = new com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.AnonymousClass1();
    public static final java.lang.String PRIORITY_VALID_TIME = "pt";
    public static final java.lang.String TAG = "AdvertisementOption";
    private java.lang.String mAdInstallPackage;
    private java.lang.String mAdPackage;
    private int mPriorityValidTime;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.AdvertisementOption$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AdvertisementOption> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AdvertisementOption createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.AdvertisementOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AdvertisementOption[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.AdvertisementOption[i];
        }
    }

    public AdvertisementOption() {
    }

    public AdvertisementOption(android.os.Parcel parcel) {
        this.mAdPackage = parcel.readString();
        this.mPriorityValidTime = parcel.readInt();
        this.mAdInstallPackage = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.AdvertisementOption parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.AdvertisementOption parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.AdvertisementOption advertisementOption = new com.meizu.cloud.pushsdk.notification.model.AdvertisementOption();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("ap")) {
                    advertisementOption.setAdPackage(jSONObject.getString("ap"));
                }
                if (!jSONObject.isNull(PRIORITY_VALID_TIME)) {
                    advertisementOption.setPriorityValidTime(jSONObject.getInt(PRIORITY_VALID_TIME));
                }
                if (!jSONObject.isNull(AD_INSTALL_PACKAGE)) {
                    advertisementOption.setAdInstallPackage(jSONObject.getString(AD_INSTALL_PACKAGE));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return advertisementOption;
        }
        str = "no such tag AdvertisementOption";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return advertisementOption;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAdInstallPackage() {
        return this.mAdInstallPackage;
    }

    public java.lang.String getAdPackage() {
        return this.mAdPackage;
    }

    public int getPriorityValidTime() {
        return this.mPriorityValidTime;
    }

    public void setAdInstallPackage(java.lang.String str) {
        this.mAdInstallPackage = str;
    }

    public void setAdPackage(java.lang.String str) {
        this.mAdPackage = str;
    }

    public void setPriorityValidTime(int i) {
        this.mPriorityValidTime = i;
    }

    public java.lang.String toString() {
        return "AdvertisementOption{mAdPackage=" + this.mAdPackage + "mPriorityValidTime=" + this.mPriorityValidTime + "mAdInstallPackage=" + this.mAdInstallPackage + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mAdPackage);
        parcel.writeInt(this.mPriorityValidTime);
        parcel.writeString(this.mAdInstallPackage);
    }
}
