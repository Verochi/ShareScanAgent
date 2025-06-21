package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class BusRouteResult extends com.amap.api.services.route.RouteResult {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.BusRouteResult> CREATOR = new com.amap.api.services.route.BusRouteResult.AnonymousClass1();
    private float a;
    private java.util.List<com.amap.api.services.route.BusPath> b;
    private com.amap.api.services.route.RouteSearch.BusRouteQuery c;

    /* renamed from: com.amap.api.services.route.BusRouteResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.BusRouteResult> {
        private static com.amap.api.services.route.BusRouteResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.BusRouteResult(parcel);
        }

        private static com.amap.api.services.route.BusRouteResult[] a(int i) {
            return new com.amap.api.services.route.BusRouteResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.BusRouteResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.BusRouteResult[] newArray(int i) {
            return a(i);
        }
    }

    public BusRouteResult() {
        this.b = new java.util.ArrayList();
    }

    public BusRouteResult(android.os.Parcel parcel) {
        super(parcel);
        this.b = new java.util.ArrayList();
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.BusPath.CREATOR);
        this.c = (com.amap.api.services.route.RouteSearch.BusRouteQuery) parcel.readParcelable(com.amap.api.services.route.RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.route.RouteSearch.BusRouteQuery getBusQuery() {
        return this.c;
    }

    public java.util.List<com.amap.api.services.route.BusPath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setBusQuery(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) {
        this.c = busRouteQuery;
    }

    public void setPaths(java.util.List<com.amap.api.services.route.BusPath> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }
}
