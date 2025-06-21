package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class RidePath extends com.amap.api.services.route.Path {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.RidePath> CREATOR = new com.amap.api.services.route.RidePath.AnonymousClass1();
    private java.util.List<com.amap.api.services.route.RideStep> a;

    /* renamed from: com.amap.api.services.route.RidePath$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RidePath> {
        private static com.amap.api.services.route.RidePath a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.RidePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RidePath createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.RidePath[] newArray(int i) {
            return null;
        }
    }

    public RidePath() {
        this.a = new java.util.ArrayList();
    }

    public RidePath(android.os.Parcel parcel) {
        super(parcel);
        this.a = new java.util.ArrayList();
        this.a = parcel.createTypedArrayList(com.amap.api.services.route.RideStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.RideStep> getSteps() {
        return this.a;
    }

    public void setSteps(java.util.List<com.amap.api.services.route.RideStep> list) {
        this.a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }
}
