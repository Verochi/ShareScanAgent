package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class f implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.f> CREATOR = new com.meizu.cloud.pushsdk.handler.a.c.f.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private boolean c;
    private java.lang.String d;
    private java.lang.String e;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.f$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.f> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.f createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.a.c.f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.f[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.a.c.f[i];
        }
    }

    public f() {
        this.c = false;
    }

    public f(android.os.Parcel parcel) {
        this.c = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public static com.meizu.cloud.pushsdk.handler.a.c.f a(org.json.JSONObject jSONObject) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.handler.a.c.f fVar = new com.meizu.cloud.pushsdk.handler.a.c.f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(com.ss.android.socialbase.downloader.constants.DBDefinition.TASK_ID)) {
                    fVar.a(jSONObject.getString(com.ss.android.socialbase.downloader.constants.DBDefinition.TASK_ID));
                }
                if (!jSONObject.isNull("time")) {
                    fVar.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    fVar.a(jSONObject.getInt("pushExtra") == 0);
                }
            } catch (org.json.JSONException e) {
                str = " parse statics message error " + e.getMessage();
            }
            return fVar;
        }
        str = "no control statics can parse ";
        com.meizu.cloud.pushinternal.DebugLogger.e("statics", str);
        return fVar;
    }

    public java.lang.String a() {
        return this.a;
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public java.lang.String b() {
        return this.b;
    }

    public void b(java.lang.String str) {
        this.b = str;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public boolean c() {
        return this.c;
    }

    public java.lang.String d() {
        return this.d;
    }

    public void d(java.lang.String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String e() {
        return this.e;
    }

    public java.lang.String toString() {
        return "Statics{taskId='" + this.a + "', time='" + this.b + "', pushExtra=" + this.c + ", deviceId='" + this.d + "', seqId='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
