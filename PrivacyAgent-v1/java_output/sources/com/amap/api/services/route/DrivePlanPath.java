package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DrivePlanPath implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DrivePlanPath> CREATOR = new com.amap.api.services.route.DrivePlanPath.AnonymousClass1();
    float a;
    int b;
    private java.util.List<com.amap.api.services.route.DrivePlanStep> c;

    /* renamed from: com.amap.api.services.route.DrivePlanPath$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DrivePlanPath> {
        private static com.amap.api.services.route.DrivePlanPath a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DrivePlanPath createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.DrivePlanPath[] newArray(int i) {
            return null;
        }
    }

    public DrivePlanPath() {
        this.c = new java.util.ArrayList();
    }

    public DrivePlanPath(android.os.Parcel parcel) {
        this.c = new java.util.ArrayList();
        this.a = parcel.readFloat();
        this.b = parcel.readInt();
        this.c = parcel.createTypedArrayList(com.amap.api.services.route.DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.a;
    }

    public java.util.List<com.amap.api.services.route.DrivePlanStep> getSteps() {
        return this.c;
    }

    public float getTrafficLights() {
        return this.b;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setSteps(java.util.List<com.amap.api.services.route.DrivePlanStep> list) {
        this.c = list;
    }

    public void setTrafficLights(int i) {
        this.b = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeInt(this.b);
        parcel.writeTypedList(this.c);
    }
}
