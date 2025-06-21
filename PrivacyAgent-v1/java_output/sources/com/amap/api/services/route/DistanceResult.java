package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DistanceResult implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DistanceResult> CREATOR = new com.amap.api.services.route.DistanceResult.AnonymousClass1();
    private com.amap.api.services.route.DistanceSearch.DistanceQuery a;
    private java.util.List<com.amap.api.services.route.DistanceItem> b;

    /* renamed from: com.amap.api.services.route.DistanceResult$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DistanceResult> {
        private static com.amap.api.services.route.DistanceResult a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DistanceResult(parcel);
        }

        private static com.amap.api.services.route.DistanceResult[] a(int i) {
            return new com.amap.api.services.route.DistanceResult[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DistanceResult createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DistanceResult[] newArray(int i) {
            return a(i);
        }
    }

    public DistanceResult() {
        this.b = null;
    }

    public DistanceResult(android.os.Parcel parcel) {
        this.b = null;
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.DistanceItem.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.route.DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.a;
    }

    public java.util.List<com.amap.api.services.route.DistanceItem> getDistanceResults() {
        return this.b;
    }

    public void setDistanceQuery(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) {
        this.a = distanceQuery;
    }

    public void setDistanceResults(java.util.List<com.amap.api.services.route.DistanceItem> list) {
        this.b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
    }
}
