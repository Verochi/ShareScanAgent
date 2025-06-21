package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DriveRoutePlanResult extends com.amap.api.services.route.RoutePlanResult {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DriveRoutePlanResult> CREATOR = new com.amap.api.services.route.DriveRoutePlanResult.AnonymousClass1();
    private java.util.List<com.amap.api.services.route.DrivePlanPath> a;
    private java.util.List<com.amap.api.services.route.TimeInfo> b;
    private com.amap.api.services.route.RouteSearch.DrivePlanQuery c;

    /* renamed from: com.amap.api.services.route.DriveRoutePlanResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DriveRoutePlanResult> {
        private static com.amap.api.services.route.DriveRoutePlanResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DriveRoutePlanResult(parcel);
        }

        private static com.amap.api.services.route.DriveRoutePlanResult[] a(int i) {
            return new com.amap.api.services.route.DriveRoutePlanResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DriveRoutePlanResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DriveRoutePlanResult[] newArray(int i) {
            return a(i);
        }
    }

    public DriveRoutePlanResult() {
        this.a = new java.util.ArrayList();
        this.b = new java.util.ArrayList();
    }

    public DriveRoutePlanResult(android.os.Parcel parcel) {
        super(parcel);
        this.a = new java.util.ArrayList();
        this.b = new java.util.ArrayList();
        this.a = parcel.createTypedArrayList(com.amap.api.services.route.DrivePlanPath.CREATOR);
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.TimeInfo.CREATOR);
        this.c = (com.amap.api.services.route.RouteSearch.DrivePlanQuery) parcel.readParcelable(com.amap.api.services.route.RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.DrivePlanPath> getPaths() {
        return this.a;
    }

    public java.util.List<com.amap.api.services.route.TimeInfo> getTimeInfos() {
        return this.b;
    }

    public void setDrivePlanQuery(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.c = drivePlanQuery;
        com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(java.util.List<com.amap.api.services.route.DrivePlanPath> list) {
        this.a = list;
    }

    public void setTimeInfos(java.util.List<com.amap.api.services.route.TimeInfo> list) {
        this.b = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }
}
