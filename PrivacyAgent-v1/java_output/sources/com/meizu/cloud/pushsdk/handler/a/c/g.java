package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class g implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.g> CREATOR = new com.meizu.cloud.pushsdk.handler.a.c.g.AnonymousClass1();
    private int a;
    private boolean b;
    private java.util.List<java.lang.String> c;
    private com.meizu.cloud.pushsdk.handler.a.c.b d;
    private java.lang.String e;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.g$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.a.c.g> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.g createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.a.c.g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.a.c.g[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.a.c.g[i];
        }
    }

    public g(android.os.Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readByte() != 0;
        this.c = parcel.createStringArrayList();
        this.d = (com.meizu.cloud.pushsdk.handler.a.c.b) parcel.readParcelable(com.meizu.cloud.pushsdk.handler.a.c.b.class.getClassLoader());
        this.e = parcel.readString();
    }

    public g(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.e = str;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.isNull("max_size")) {
                this.a = jSONObject.getInt("max_size");
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                org.json.JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.c = new java.util.ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.c.add(jSONArray.getString(i));
                }
            }
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("UploadLogMessage", "parse upload message error " + e.getMessage());
        }
        this.d = new com.meizu.cloud.pushsdk.handler.a.c.b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public java.util.List<java.lang.String> c() {
        return this.c;
    }

    public com.meizu.cloud.pushsdk.handler.a.c.b d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.b + ", fileList=" + this.c + ", controlMessage=" + this.d + ", uploadMessage='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
    }
}
