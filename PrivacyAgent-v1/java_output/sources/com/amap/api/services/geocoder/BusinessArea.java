package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public class BusinessArea implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.geocoder.BusinessArea> CREATOR = new com.amap.api.services.geocoder.BusinessArea.AnonymousClass1();
    private com.amap.api.services.core.LatLonPoint a;
    private java.lang.String b;

    /* renamed from: com.amap.api.services.geocoder.BusinessArea$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.geocoder.BusinessArea> {
        private static com.amap.api.services.geocoder.BusinessArea a(android.os.Parcel parcel) {
            return new com.amap.api.services.geocoder.BusinessArea(parcel);
        }

        private static com.amap.api.services.geocoder.BusinessArea[] a(int i) {
            return new com.amap.api.services.geocoder.BusinessArea[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.geocoder.BusinessArea createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.geocoder.BusinessArea[] newArray(int i) {
            return a(i);
        }
    }

    public BusinessArea() {
    }

    public BusinessArea(android.os.Parcel parcel) {
        this.a = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.core.LatLonPoint getCenterPoint() {
        return this.a;
    }

    public java.lang.String getName() {
        return this.b;
    }

    public void setCenterPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setName(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
    }
}
