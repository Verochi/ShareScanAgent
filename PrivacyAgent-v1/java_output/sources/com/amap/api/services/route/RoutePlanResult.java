package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class RoutePlanResult implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.RoutePlanResult> CREATOR = new com.amap.api.services.route.RoutePlanResult.AnonymousClass1();
    private com.amap.api.services.core.LatLonPoint a;
    private com.amap.api.services.core.LatLonPoint b;

    /* renamed from: com.amap.api.services.route.RoutePlanResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RoutePlanResult> {
        private static com.amap.api.services.route.RoutePlanResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.RoutePlanResult(parcel);
        }

        private static com.amap.api.services.route.RoutePlanResult[] a(int i) {
            return new com.amap.api.services.route.RoutePlanResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RoutePlanResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RoutePlanResult[] newArray(int i) {
            return a(i);
        }
    }

    public RoutePlanResult() {
    }

    public RoutePlanResult(android.os.Parcel parcel) {
        this.a = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.b = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.core.LatLonPoint getStartPos() {
        return this.a;
    }

    public com.amap.api.services.core.LatLonPoint getTargetPos() {
        return this.b;
    }

    public void setStartPos(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setTargetPos(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }
}
