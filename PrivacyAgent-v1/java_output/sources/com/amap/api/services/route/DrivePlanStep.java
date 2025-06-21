package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DrivePlanStep implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DrivePlanStep> CREATOR = new com.amap.api.services.route.DrivePlanStep.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private float c;
    private boolean d;
    private java.util.List<com.amap.api.services.core.LatLonPoint> e;

    /* renamed from: com.amap.api.services.route.DrivePlanStep$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DrivePlanStep> {
        private static com.amap.api.services.route.DrivePlanStep a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DrivePlanStep createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.DrivePlanStep[] newArray(int i) {
            return null;
        }
    }

    public DrivePlanStep() {
        this.e = new java.util.ArrayList();
    }

    public DrivePlanStep(android.os.Parcel parcel) {
        this.e = new java.util.ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readInt() == 1;
        this.c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAdCode() {
        return this.b;
    }

    public float getDistance() {
        return this.c;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getPolyline() {
        return this.e;
    }

    public java.lang.String getRoad() {
        return this.a;
    }

    public boolean getToll() {
        return this.d;
    }

    public void setAdCode(java.lang.String str) {
        this.b = str;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public void setPolyline(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
        this.e = list;
    }

    public void setRoad(java.lang.String str) {
        this.a = str;
    }

    public void setToll(boolean z) {
        this.d = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.e);
    }
}
