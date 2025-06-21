package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class TruckPath implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.TruckPath> CREATOR = new com.amap.api.services.route.TruckPath.AnonymousClass1();
    private float a;
    private long b;
    private java.lang.String c;
    private float d;
    private float e;
    private int f;
    private int g;
    private java.util.List<com.amap.api.services.route.TruckStep> h;

    /* renamed from: com.amap.api.services.route.TruckPath$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.TruckPath> {
        private static com.amap.api.services.route.TruckPath a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.TruckPath(parcel);
        }

        private static com.amap.api.services.route.TruckPath[] a(int i) {
            return new com.amap.api.services.route.TruckPath[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TruckPath createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TruckPath[] newArray(int i) {
            return a(i);
        }
    }

    public TruckPath() {
    }

    public TruckPath(android.os.Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readLong();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.createTypedArrayList(com.amap.api.services.route.TruckStep.CREATOR);
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

    public int getRestriction() {
        return this.g;
    }

    public java.util.List<com.amap.api.services.route.TruckStep> getSteps() {
        return this.h;
    }

    public java.lang.String getStrategy() {
        return this.c;
    }

    public float getTollDistance() {
        return this.e;
    }

    public float getTolls() {
        return this.d;
    }

    public int getTotalTrafficlights() {
        return this.f;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void setRestriction(int i) {
        this.g = i;
    }

    public void setSteps(java.util.List<com.amap.api.services.route.TruckStep> list) {
        this.h = list;
    }

    public void setStrategy(java.lang.String str) {
        this.c = str;
    }

    public void setTollDistance(float f) {
        this.e = f;
    }

    public void setTolls(float f) {
        this.d = f;
    }

    public void setTotalTrafficlights(int i) {
        this.f = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeLong(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeTypedList(this.h);
    }
}
