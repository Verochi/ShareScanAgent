package com.amap.api.maps.offlinemap;

/* loaded from: classes12.dex */
public class City implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.maps.offlinemap.City> CREATOR = new com.amap.api.maps.offlinemap.City.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;

    /* renamed from: com.amap.api.maps.offlinemap.City$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.maps.offlinemap.City> {
        private static com.amap.api.maps.offlinemap.City a(android.os.Parcel parcel) {
            return new com.amap.api.maps.offlinemap.City(parcel);
        }

        private static com.amap.api.maps.offlinemap.City[] a(int i) {
            return new com.amap.api.maps.offlinemap.City[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.offlinemap.City createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.offlinemap.City[] newArray(int i) {
            return a(i);
        }
    }

    public City() {
        this.a = "";
        this.b = "";
        this.e = "";
    }

    public City(android.os.Parcel parcel) {
        this.a = "";
        this.b = "";
        this.e = "";
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAdcode() {
        return this.e;
    }

    public java.lang.String getCity() {
        return this.a;
    }

    public java.lang.String getCode() {
        return this.b;
    }

    public java.lang.String getJianpin() {
        return this.c;
    }

    public java.lang.String getPinyin() {
        return this.d;
    }

    public void setAdcode(java.lang.String str) {
        this.e = str;
    }

    public void setCity(java.lang.String str) {
        this.a = str;
    }

    public void setCode(java.lang.String str) {
        if (str == null || "[]".equals(str)) {
            return;
        }
        this.b = str;
    }

    public void setJianpin(java.lang.String str) {
        this.c = str;
    }

    public void setPinyin(java.lang.String str) {
        this.d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
