package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class RouteBusWalkItem extends com.amap.api.services.route.WalkPath {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteBusWalkItem> CREATOR = new com.amap.api.services.route.RouteBusWalkItem.AnonymousClass1();
    private com.amap.api.services.core.LatLonPoint a;
    private com.amap.api.services.core.LatLonPoint b;

    /* renamed from: com.amap.api.services.route.RouteBusWalkItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteBusWalkItem> {
        private static com.amap.api.services.route.RouteBusWalkItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RouteBusWalkItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.RouteBusWalkItem[] newArray(int i) {
            return null;
        }
    }

    public RouteBusWalkItem() {
    }

    public RouteBusWalkItem(android.os.Parcel parcel) {
        super(parcel);
        this.a = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.b = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.core.LatLonPoint getDestination() {
        return this.b;
    }

    public com.amap.api.services.core.LatLonPoint getOrigin() {
        return this.a;
    }

    public void setDestination(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setOrigin(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }
}
