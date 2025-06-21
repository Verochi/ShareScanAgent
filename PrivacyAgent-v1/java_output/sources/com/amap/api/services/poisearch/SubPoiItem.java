package com.amap.api.services.poisearch;

/* loaded from: classes12.dex */
public class SubPoiItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.poisearch.SubPoiItem> CREATOR = new com.amap.api.services.poisearch.SubPoiItem.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private int d;
    private com.amap.api.services.core.LatLonPoint e;
    private java.lang.String f;
    private java.lang.String g;

    /* renamed from: com.amap.api.services.poisearch.SubPoiItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.poisearch.SubPoiItem> {
        private static com.amap.api.services.poisearch.SubPoiItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.poisearch.SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.poisearch.SubPoiItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.poisearch.SubPoiItem[] newArray(int i) {
            return null;
        }
    }

    public SubPoiItem(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
    }

    public SubPoiItem(java.lang.String str, com.amap.api.services.core.LatLonPoint latLonPoint, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.e = latLonPoint;
        this.b = str2;
        this.f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.d;
    }

    public com.amap.api.services.core.LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public java.lang.String getPoiId() {
        return this.a;
    }

    public java.lang.String getSnippet() {
        return this.f;
    }

    public java.lang.String getSubName() {
        return this.c;
    }

    public java.lang.String getSubTypeDes() {
        return this.g;
    }

    public java.lang.String getTitle() {
        return this.b;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public void setLatLonPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setPoiId(java.lang.String str) {
        this.a = str;
    }

    public void setSnippet(java.lang.String str) {
        this.f = str;
    }

    public void setSubName(java.lang.String str) {
        this.c = str;
    }

    public void setSubTypeDes(java.lang.String str) {
        this.g = str;
    }

    public void setTitle(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }
}
