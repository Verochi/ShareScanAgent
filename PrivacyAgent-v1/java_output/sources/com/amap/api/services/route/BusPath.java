package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class BusPath extends com.amap.api.services.route.Path {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.BusPath> CREATOR = new com.amap.api.services.route.BusPath.AnonymousClass1();
    private float a;
    private boolean b;
    private float c;
    private float d;
    private java.util.List<com.amap.api.services.route.BusStep> e;

    /* renamed from: com.amap.api.services.route.BusPath$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.BusPath> {
        private static com.amap.api.services.route.BusPath a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.BusPath createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.BusPath[] newArray(int i) {
            return null;
        }
    }

    public BusPath() {
        this.e = new java.util.ArrayList();
    }

    public BusPath(android.os.Parcel parcel) {
        super(parcel);
        this.e = new java.util.ArrayList();
        this.a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.b = zArr[0];
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.createTypedArrayList(com.amap.api.services.route.BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.d;
    }

    public float getCost() {
        return this.a;
    }

    public java.util.List<com.amap.api.services.route.BusStep> getSteps() {
        return this.e;
    }

    public float getWalkDistance() {
        return this.c;
    }

    public boolean isNightBus() {
        return this.b;
    }

    public void setBusDistance(float f) {
        this.d = f;
    }

    public void setCost(float f) {
        this.a = f;
    }

    public void setNightBus(boolean z) {
        this.b = z;
    }

    public void setSteps(java.util.List<com.amap.api.services.route.BusStep> list) {
        this.e = list;
    }

    public void setWalkDistance(float f) {
        this.c = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeBooleanArray(new boolean[]{this.b});
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeTypedList(this.e);
    }
}
