package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bx implements android.os.Parcelable {
    public static final java.lang.String a = "MD5";
    public static final android.os.Parcelable.Creator<com.baidu.mobads.sdk.internal.bx> b = new com.baidu.mobads.sdk.internal.by();
    private org.json.JSONObject c;
    private double d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private int h;
    private int i;

    private bx(android.os.Parcel parcel) {
        this.f = parcel.readString();
        this.i = parcel.readInt();
        this.e = parcel.readString();
        this.d = parcel.readDouble();
        this.g = parcel.readString();
        this.h = parcel.readInt();
    }

    public /* synthetic */ bx(android.os.Parcel parcel, com.baidu.mobads.sdk.internal.by byVar) {
        this(parcel);
    }

    public bx(com.baidu.mobads.sdk.internal.bx bxVar, java.lang.String str, java.lang.Boolean bool) {
        this.d = bxVar.b();
        this.e = bxVar.c();
        this.f = bxVar.d();
        this.i = bxVar.a().booleanValue() ? 1 : 0;
        this.g = str;
        this.h = bool.booleanValue() ? 1 : 0;
    }

    public bx(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.c = jSONObject;
            this.d = jSONObject.getDouble("version");
            this.e = this.c.getString("url");
            this.f = this.c.getString("sign");
            this.i = 1;
            this.g = "";
            this.h = 0;
        } catch (org.json.JSONException unused) {
            this.i = 0;
        }
        this.i = c() == null ? 0 : 1;
    }

    public java.lang.Boolean a() {
        return java.lang.Boolean.valueOf(this.i == 1);
    }

    public double b() {
        return this.d;
    }

    public java.lang.String c() {
        return com.baidu.mobads.sdk.internal.cq.a().c(this.e);
    }

    public java.lang.String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String e() {
        return this.g;
    }

    public java.lang.Boolean f() {
        return java.lang.Boolean.valueOf(this.h == 1);
    }

    public java.lang.String toString() {
        return this.c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeInt(this.i);
        parcel.writeString(this.e);
        parcel.writeDouble(this.d);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
    }
}
