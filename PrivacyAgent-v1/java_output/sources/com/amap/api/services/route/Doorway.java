package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class Doorway implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.Doorway> CREATOR = new com.amap.api.services.route.Doorway.AnonymousClass1();
    private java.lang.String a;
    private com.amap.api.services.core.LatLonPoint b;

    /* renamed from: com.amap.api.services.route.Doorway$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.Doorway> {
        private static com.amap.api.services.route.Doorway a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.Doorway createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.Doorway[] newArray(int i) {
            return null;
        }
    }

    public Doorway() {
    }

    public Doorway(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.core.LatLonPoint getLatLonPoint() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public void setLatLonPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
