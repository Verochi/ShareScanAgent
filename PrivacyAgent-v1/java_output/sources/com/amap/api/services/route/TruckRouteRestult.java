package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class TruckRouteRestult implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.TruckRouteRestult> CREATOR = new com.amap.api.services.route.TruckRouteRestult.AnonymousClass1();
    private com.amap.api.services.route.RouteSearch.TruckRouteQuery a;
    private java.util.List<com.amap.api.services.route.TruckPath> b;
    private com.amap.api.services.core.LatLonPoint c;
    private com.amap.api.services.core.LatLonPoint d;

    /* renamed from: com.amap.api.services.route.TruckRouteRestult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.TruckRouteRestult> {
        private static com.amap.api.services.route.TruckRouteRestult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.TruckRouteRestult(parcel);
        }

        private static com.amap.api.services.route.TruckRouteRestult[] a(int i) {
            return new com.amap.api.services.route.TruckRouteRestult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TruckRouteRestult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TruckRouteRestult[] newArray(int i) {
            return a(i);
        }
    }

    public TruckRouteRestult() {
    }

    public TruckRouteRestult(android.os.Parcel parcel) {
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.TruckPath.CREATOR);
        this.c = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.d = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.TruckPath> getPaths() {
        return this.b;
    }

    public com.amap.api.services.core.LatLonPoint getStartPos() {
        return this.c;
    }

    public com.amap.api.services.core.LatLonPoint getTargetPos() {
        return this.d;
    }

    public com.amap.api.services.route.RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.a;
    }

    public void setPaths(java.util.List<com.amap.api.services.route.TruckPath> list) {
        this.b = list;
    }

    public void setStartPos(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setTargetPos(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public void setTruckQuery(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }
}
