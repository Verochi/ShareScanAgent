package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class WalkRouteResult extends com.amap.api.services.route.RouteResult {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.WalkRouteResult> CREATOR = new com.amap.api.services.route.WalkRouteResult.AnonymousClass1();
    private java.util.List<com.amap.api.services.route.WalkPath> a;
    private com.amap.api.services.route.RouteSearch.WalkRouteQuery b;

    /* renamed from: com.amap.api.services.route.WalkRouteResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.WalkRouteResult> {
        private static com.amap.api.services.route.WalkRouteResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.WalkRouteResult(parcel);
        }

        private static com.amap.api.services.route.WalkRouteResult[] a(int i) {
            return new com.amap.api.services.route.WalkRouteResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.WalkRouteResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.WalkRouteResult[] newArray(int i) {
            return a(i);
        }
    }

    public WalkRouteResult() {
        this.a = new java.util.ArrayList();
    }

    public WalkRouteResult(android.os.Parcel parcel) {
        super(parcel);
        this.a = new java.util.ArrayList();
        this.a = parcel.createTypedArrayList(com.amap.api.services.route.WalkPath.CREATOR);
        this.b = (com.amap.api.services.route.RouteSearch.WalkRouteQuery) parcel.readParcelable(com.amap.api.services.route.RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.WalkPath> getPaths() {
        return this.a;
    }

    public com.amap.api.services.route.RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.b;
    }

    public void setPaths(java.util.List<com.amap.api.services.route.WalkPath> list) {
        this.a = list;
    }

    public void setWalkQuery(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
