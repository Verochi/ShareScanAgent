package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class AdvanceSettingEx implements android.os.Parcelable {
    public static final java.lang.String ADVANCE_SETTING_EX = "as";
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx> CREATOR = new com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx.AnonymousClass1();
    public static final int MZ_PUSH_PRIORITY_DEFAULT = 0;
    public static final int MZ_PUSH_PRIORITY_HIGH = 1;
    public static final int MZ_PUSH_PRIORITY_LOW = -1;
    public static final int MZ_PUSH_PRIORITY_MAX = 2;
    public static final int MZ_PUSH_PRIORITY_MIN = -2;
    public static final java.lang.String PRIORITY_DISPLAY = "pd";
    public static final java.lang.String SOUND_TITLE = "st";
    public static final java.lang.String TAG = "AdvanceSettingEx";
    private int priorityDisplay;
    private java.lang.String soundTitle;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx[i];
        }
    }

    public AdvanceSettingEx() {
        this.priorityDisplay = 0;
    }

    public AdvanceSettingEx(android.os.Parcel parcel) {
        this.priorityDisplay = 0;
        this.priorityDisplay = parcel.readInt();
        this.soundTitle = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx parse(java.lang.String str) {
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

    public static com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx advanceSettingEx = new com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("pd")) {
                    advanceSettingEx.setPriorityDisplay(jSONObject.getInt("pd"));
                }
                if (!jSONObject.isNull("st")) {
                    advanceSettingEx.setSoundTitle(jSONObject.getString("st"));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return advanceSettingEx;
        }
        str = "no such tag AdvanceSettingEx";
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, str);
        return advanceSettingEx;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPriorityDisplay() {
        return this.priorityDisplay;
    }

    public java.lang.String getSoundTitle() {
        return this.soundTitle;
    }

    public void setPriorityDisplay(int i) {
        if (i < -2 || i > 2) {
            i = 0;
        }
        this.priorityDisplay = i;
    }

    public void setSoundTitle(java.lang.String str) {
        this.soundTitle = str;
    }

    public java.lang.String toString() {
        return "AdvanceSettingEx{, priorityDisplay=" + this.priorityDisplay + ", soundTitle=" + this.soundTitle + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.priorityDisplay);
        parcel.writeString(this.soundTitle);
    }
}
