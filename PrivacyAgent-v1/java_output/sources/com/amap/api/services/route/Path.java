package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class Path implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.Path> CREATOR = new com.amap.api.services.route.Path.AnonymousClass1();
    private float a;
    private long b;
    private java.util.List<com.amap.api.services.core.LatLonPoint> c;

    /* renamed from: com.amap.api.services.route.Path$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.Path> {
        private static com.amap.api.services.route.Path a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.Path createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.Path[] newArray(int i) {
            return null;
        }
    }

    public Path() {
        this.c = new java.util.ArrayList();
    }

    public Path(android.os.Parcel parcel) {
        this.c = new java.util.ArrayList();
        this.a = parcel.readFloat();
        this.b = parcel.readLong();
        this.c = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.a;
    }

    public long getDuration() {
        return this.b;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getPolyline() {
        return this.c;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void setPolyline(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
        this.c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeLong(this.b);
        parcel.writeTypedList(this.c);
    }
}
