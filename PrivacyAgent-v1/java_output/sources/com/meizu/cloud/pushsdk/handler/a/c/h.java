package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class h implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.h> CREATOR = new com.meizu.cloud.pushsdk.handler.a.c.h.AnonymousClass1();
    private com.meizu.cloud.pushsdk.handler.a.c.b a;
    private java.lang.String b;
    private int c;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.h$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.h> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.h createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.a.c.h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.h[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.a.c.h[i];
        }
    }

    public h(android.os.Parcel parcel) {
        this.a = (com.meizu.cloud.pushsdk.handler.a.c.b) parcel.readParcelable(com.meizu.cloud.pushsdk.handler.a.c.b.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readInt();
    }

    public h(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.b = str2;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.isNull(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID)) {
                this.c = jSONObject.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID);
            }
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("WithDrawMessage", "parse WithDrawMessage error " + e.getMessage());
        }
        this.a = new com.meizu.cloud.pushsdk.handler.a.c.b(str3, str4, str5);
    }

    public com.meizu.cloud.pushsdk.handler.a.c.b a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public java.lang.String c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "WithDrawMessage{controlMessage=" + this.a + ", revokePackageName='" + this.b + "', notifyId=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }
}
