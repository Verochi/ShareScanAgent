package com.amap.api.services.routepoisearch;

/* loaded from: classes12.dex */
public class RoutePOIItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.routepoisearch.RoutePOIItem> CREATOR = new com.amap.api.services.routepoisearch.RoutePOIItem.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private com.amap.api.services.core.LatLonPoint c;
    private float d;
    private float e;

    /* renamed from: com.amap.api.services.routepoisearch.RoutePOIItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.routepoisearch.RoutePOIItem> {
        private static com.amap.api.services.routepoisearch.RoutePOIItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.routepoisearch.RoutePOIItem(parcel);
        }

        private static com.amap.api.services.routepoisearch.RoutePOIItem[] a(int i) {
            return new com.amap.api.services.routepoisearch.RoutePOIItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.routepoisearch.RoutePOIItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.routepoisearch.RoutePOIItem[] newArray(int i) {
            return a(i);
        }
    }

    public RoutePOIItem() {
    }

    public RoutePOIItem(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.d;
    }

    public float getDuration() {
        return this.e;
    }

    public java.lang.String getID() {
        return this.a;
    }

    public com.amap.api.services.core.LatLonPoint getPoint() {
        return this.c;
    }

    public java.lang.String getTitle() {
        return this.b;
    }

    public void setDistance(float f) {
        this.d = f;
    }

    public void setDuration(float f) {
        this.e = f;
    }

    public void setID(java.lang.String str) {
        this.a = str;
    }

    public void setPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setTitle(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
    }
}
