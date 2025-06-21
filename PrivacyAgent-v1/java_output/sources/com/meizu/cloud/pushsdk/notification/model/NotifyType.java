package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class NotifyType implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.NotifyType> CREATOR = new com.meizu.cloud.pushsdk.notification.model.NotifyType.AnonymousClass1();
    public static final java.lang.String LIGHTS = "l";
    public static final java.lang.String NOTIFY_TYPE = "nt";
    public static final java.lang.String SOUND = "s";
    public static final java.lang.String TAG = "notify_type";
    public static final java.lang.String VIBRATE = "v";
    boolean lights;
    boolean sound;
    boolean vibrate;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.NotifyType$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.NotifyType> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.NotifyType createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.NotifyType(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.NotifyType[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.NotifyType[i];
        }
    }

    public NotifyType() {
    }

    public NotifyType(android.os.Parcel parcel) {
        this.vibrate = parcel.readByte() != 0;
        this.lights = parcel.readByte() != 0;
        this.sound = parcel.readByte() != 0;
    }

    public static com.meizu.cloud.pushsdk.notification.model.NotifyType parse(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                jSONObject = new org.json.JSONObject(str);
            } catch (org.json.JSONException e) {
                com.meizu.cloud.pushinternal.DebugLogger.e("notify_type", "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static com.meizu.cloud.pushsdk.notification.model.NotifyType parse(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.NotifyType notifyType = new com.meizu.cloud.pushsdk.notification.model.NotifyType();
        if (jSONObject != null) {
            try {
                boolean z = true;
                if (!jSONObject.isNull("v")) {
                    notifyType.setVibrate(jSONObject.getInt("v") != 0);
                }
                if (!jSONObject.isNull("l")) {
                    notifyType.setLights(jSONObject.getInt("l") != 0);
                }
                if (!jSONObject.isNull("s")) {
                    if (jSONObject.getInt("s") == 0) {
                        z = false;
                    }
                    notifyType.setSound(z);
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return notifyType;
        }
        str = "no such tag notify_type";
        com.meizu.cloud.pushinternal.DebugLogger.e("notify_type", str);
        return notifyType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isLights() {
        return this.lights;
    }

    public boolean isSound() {
        return this.sound;
    }

    public boolean isVibrate() {
        return this.vibrate;
    }

    public void setLights(boolean z) {
        this.lights = z;
    }

    public void setSound(boolean z) {
        this.sound = z;
    }

    public void setVibrate(boolean z) {
        this.vibrate = z;
    }

    public java.lang.String toString() {
        return "NotifyType{vibrate=" + this.vibrate + ", lights=" + this.lights + ", sound=" + this.sound + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.vibrate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.lights ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.sound ? (byte) 1 : (byte) 0);
    }
}
