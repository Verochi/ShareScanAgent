package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class b implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.b> CREATOR = new com.meizu.cloud.pushsdk.handler.a.c.b.AnonymousClass1();
    private java.lang.String a;
    private com.meizu.cloud.pushsdk.handler.a.c.a b;
    private com.meizu.cloud.pushsdk.handler.a.c.f c;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.b> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.b createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.a.c.b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.b[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.a.c.b[i];
        }
    }

    public b() {
    }

    public b(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = (com.meizu.cloud.pushsdk.handler.a.c.a) parcel.readParcelable(com.meizu.cloud.pushsdk.handler.a.c.a.class.getClassLoader());
        this.c = (com.meizu.cloud.pushsdk.handler.a.c.f) parcel.readParcelable(com.meizu.cloud.pushsdk.handler.a.c.f.class.getClassLoader());
    }

    public b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        if (android.text.TextUtils.isEmpty(str)) {
            this.b = new com.meizu.cloud.pushsdk.handler.a.c.a();
            this.c = new com.meizu.cloud.pushsdk.handler.a.c.f();
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.b = com.meizu.cloud.pushsdk.handler.a.c.a.a(jSONObject.getJSONObject("ctl"));
            com.meizu.cloud.pushsdk.handler.a.c.f a = com.meizu.cloud.pushsdk.handler.a.c.f.a(jSONObject.getJSONObject("statics"));
            this.c = a;
            a.c(str2);
            this.c.d(str3);
        } catch (org.json.JSONException e) {
            this.b = new com.meizu.cloud.pushsdk.handler.a.c.a();
            this.c = new com.meizu.cloud.pushsdk.handler.a.c.f();
            com.meizu.cloud.pushinternal.DebugLogger.e("ControlMessage", "parse control message error " + e.getMessage());
        }
    }

    public static com.meizu.cloud.pushsdk.handler.a.c.b a(java.lang.String str) {
        com.meizu.cloud.pushsdk.handler.a.c.b bVar = new com.meizu.cloud.pushsdk.handler.a.c.b();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            bVar.a(com.meizu.cloud.pushsdk.handler.a.c.a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(com.meizu.cloud.pushsdk.handler.a.c.f.a(jSONObject.getJSONObject("statics")));
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("ControlMessage", "parse control message error " + e.getMessage());
            bVar.a(new com.meizu.cloud.pushsdk.handler.a.c.f());
            bVar.a(new com.meizu.cloud.pushsdk.handler.a.c.a());
        }
        return bVar;
    }

    public com.meizu.cloud.pushsdk.handler.a.c.a a() {
        return this.b;
    }

    public void a(com.meizu.cloud.pushsdk.handler.a.c.a aVar) {
        this.b = aVar;
    }

    public void a(com.meizu.cloud.pushsdk.handler.a.c.f fVar) {
        this.c = fVar;
    }

    public com.meizu.cloud.pushsdk.handler.a.c.f b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "ControlMessage{controlMessage='" + this.a + "', control=" + this.b + ", statics=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }
}
