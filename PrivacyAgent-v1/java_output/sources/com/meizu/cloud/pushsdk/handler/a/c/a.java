package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class a implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.a> CREATOR = new com.meizu.cloud.pushsdk.handler.a.c.a.AnonymousClass1();
    private int a;
    private int b;
    private int c;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.a> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.a createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.a.c.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.a[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.a.c.a[i];
        }
    }

    public a() {
    }

    public a(android.os.Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    public static com.meizu.cloud.pushsdk.handler.a.c.a a(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.handler.a.c.a aVar = new com.meizu.cloud.pushsdk.handler.a.c.a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("pushType")) {
                    aVar.a(jSONObject.getInt("pushType"));
                }
                if (!jSONObject.isNull("cached")) {
                    aVar.b(jSONObject.getInt("cached"));
                }
                if (!jSONObject.isNull("cacheNum")) {
                    aVar.c(jSONObject.getInt("cacheNum"));
                }
            } catch (org.json.JSONException e) {
                str = " parse control message error " + e.getMessage();
            }
            return aVar;
        }
        str = "no control message can parse ";
        com.meizu.cloud.pushinternal.DebugLogger.e("ctl", str);
        return aVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "Control{pushType=" + this.a + ", cached=" + this.b + ", cacheNum=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
