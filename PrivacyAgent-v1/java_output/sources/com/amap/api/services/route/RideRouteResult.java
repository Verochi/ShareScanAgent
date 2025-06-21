package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class RideRouteResult extends com.amap.api.services.route.RouteResult {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.RideRouteResult> CREATOR = new com.amap.api.services.route.RideRouteResult.AnonymousClass1();
    private java.util.List<com.amap.api.services.route.RidePath> a;
    private com.amap.api.services.route.RouteSearch.RideRouteQuery b;

    /* renamed from: com.amap.api.services.route.RideRouteResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RideRouteResult> {
        private static com.amap.api.services.route.RideRouteResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.RideRouteResult(parcel);
        }

        private static com.amap.api.services.route.RideRouteResult[] a(int i) {
            return new com.amap.api.services.route.RideRouteResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RideRouteResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RideRouteResult[] newArray(int i) {
            return a(i);
        }
    }

    public RideRouteResult() {
        this.a = new java.util.ArrayList();
    }

    public RideRouteResult(android.os.Parcel parcel) {
        super(parcel);
        this.a = new java.util.ArrayList();
        this.a = parcel.createTypedArrayList(com.amap.api.services.route.RidePath.CREATOR);
        this.b = (com.amap.api.services.route.RouteSearch.RideRouteQuery) parcel.readParcelable(com.amap.api.services.route.RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.RidePath> getPaths() {
        return this.a;
    }

    public com.amap.api.services.route.RouteSearch.RideRouteQuery getRideQuery() {
        return this.b;
    }

    public void setPaths(java.util.List<com.amap.api.services.route.RidePath> list) {
        this.a = list;
    }

    public void setRideQuery(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) {
        this.b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
