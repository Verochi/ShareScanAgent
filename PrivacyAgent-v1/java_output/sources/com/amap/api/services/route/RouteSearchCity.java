package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class RouteSearchCity extends com.amap.api.services.route.SearchCity {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearchCity> CREATOR = new com.amap.api.services.route.RouteSearchCity.AnonymousClass1();
    java.util.List<com.amap.api.services.route.District> a;

    /* renamed from: com.amap.api.services.route.RouteSearchCity$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearchCity> {
        private static com.amap.api.services.route.RouteSearchCity a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.RouteSearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.RouteSearchCity createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.RouteSearchCity[] newArray(int i) {
            return null;
        }
    }

    public RouteSearchCity() {
        this.a = new java.util.ArrayList();
    }

    public RouteSearchCity(android.os.Parcel parcel) {
        super(parcel);
        this.a = new java.util.ArrayList();
        this.a = parcel.createTypedArrayList(com.amap.api.services.route.District.CREATOR);
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.services.route.District> getDistricts() {
        return this.a;
    }

    public void setDistricts(java.util.List<com.amap.api.services.route.District> list) {
        this.a = list;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }
}
