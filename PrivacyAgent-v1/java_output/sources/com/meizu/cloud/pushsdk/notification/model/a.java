package com.meizu.cloud.pushsdk.notification.model;

/* loaded from: classes23.dex */
public class a implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.a> CREATOR = new com.meizu.cloud.pushsdk.notification.model.a.AnonymousClass1();
    private int a;
    private java.lang.String b;

    /* renamed from: com.meizu.cloud.pushsdk.notification.model.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.notification.model.a> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.a createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.notification.model.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.notification.model.a[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.notification.model.a[i];
        }
    }

    public a() {
        this.a = 0;
    }

    public a(android.os.Parcel parcel) {
        this.a = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.notification.model.a a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a c;
        try {
            c = !android.text.TextUtils.isEmpty(messageV3.getNotificationMessage()) ? a(new org.json.JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getJSONObject("no")) : null;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("NotifyOption", "parse flyme NotifyOption setting error " + e.getMessage() + " so get from notificationMessage");
            c = c(messageV3.getNotificationMessage());
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("NotifyOption", "current notify option is " + c);
        return c;
    }

    public static com.meizu.cloud.pushsdk.notification.model.a a(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.notification.model.a aVar = new com.meizu.cloud.pushsdk.notification.model.a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(com.getui.gtc.extension.distribution.gbd.f.b.h)) {
                    aVar.a(jSONObject.getInt(com.getui.gtc.extension.distribution.gbd.f.b.h));
                }
                if (!jSONObject.isNull("nk")) {
                    aVar.a(jSONObject.getString("nk"));
                }
            } catch (org.json.JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return aVar;
        }
        str = "no such tag NotifyOption";
        com.meizu.cloud.pushinternal.DebugLogger.e("NotifyOption", str);
        return aVar;
    }

    public static int b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a = a(messageV3);
        if (a != null) {
            return a.a();
        }
        return 0;
    }

    public static com.meizu.cloud.pushsdk.notification.model.a b(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                jSONObject = new org.json.JSONObject(str);
            } catch (org.json.JSONException e) {
                com.meizu.cloud.pushinternal.DebugLogger.e("NotifyOption", "parse json string error " + e.getMessage());
            }
            return a(jSONObject);
        }
        jSONObject = null;
        return a(jSONObject);
    }

    private static com.meizu.cloud.pushsdk.notification.model.a c(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return b(new org.json.JSONObject(str).getString("no"));
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("NotifyOption", "parse notificationMessage error " + e.getMessage());
            return null;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "NotifyOption{notifyId=" + this.a + ", notifyKey='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }
}
