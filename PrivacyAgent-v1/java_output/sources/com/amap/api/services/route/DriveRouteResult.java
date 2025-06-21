package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DriveRouteResult extends com.amap.api.services.route.RouteResult {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DriveRouteResult> CREATOR = new com.amap.api.services.route.DriveRouteResult.AnonymousClass1();
    private float a;
    private java.util.List<com.amap.api.services.route.DrivePath> b;
    private com.amap.api.services.route.RouteSearch.DriveRouteQuery c;

    /* renamed from: com.amap.api.services.route.DriveRouteResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DriveRouteResult> {
        private static com.amap.api.services.route.DriveRouteResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DriveRouteResult(parcel);
        }

        private static com.amap.api.services.route.DriveRouteResult[] a(int i) {
            return new com.amap.api.services.route.DriveRouteResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DriveRouteResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DriveRouteResult[] newArray(int i) {
            return a(i);
        }
    }

    public DriveRouteResult() {
        this.b = new java.util.ArrayList();
    }

    public DriveRouteResult(android.os.Parcel parcel) {
        super(parcel);
        this.b = new java.util.ArrayList();
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.DrivePath.CREATOR);
        this.c = (com.amap.api.services.route.RouteSearch.DriveRouteQuery) parcel.readParcelable(com.amap.api.services.route.RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.route.RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.c;
    }

    public java.util.List<com.amap.api.services.route.DrivePath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setDriveQuery(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.c = driveRouteQuery;
    }

    public void setPaths(java.util.List<com.amap.api.services.route.DrivePath> list) {
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
