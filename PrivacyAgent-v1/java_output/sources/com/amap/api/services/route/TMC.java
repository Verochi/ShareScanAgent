package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class TMC implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.TMC> CREATOR = new com.amap.api.services.route.TMC.AnonymousClass1();
    private int a;
    private java.lang.String b;
    private java.util.List<com.amap.api.services.core.LatLonPoint> c;

    /* renamed from: com.amap.api.services.route.TMC$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.TMC> {
        private static com.amap.api.services.route.TMC a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TMC createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.TMC[] newArray(int i) {
            return null;
        }
    }

    public TMC() {
        this.c = new java.util.ArrayList();
    }

    public TMC(android.os.Parcel parcel) {
        this.c = new java.util.ArrayList();
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.a;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getPolyline() {
        return this.c;
    }

    public java.lang.String getStatus() {
        return this.b;
    }

    public void setDistance(int i) {
        this.a = i;
    }

    public void setPolyline(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
        this.c = list;
    }

    public void setStatus(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
    }
}
