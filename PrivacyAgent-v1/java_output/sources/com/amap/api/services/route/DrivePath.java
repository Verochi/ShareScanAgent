package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DrivePath extends com.amap.api.services.route.Path {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DrivePath> CREATOR = new com.amap.api.services.route.DrivePath.AnonymousClass1();
    private java.lang.String a;
    private float b;
    private float c;
    private int d;
    private java.util.List<com.amap.api.services.route.DriveStep> e;
    private int f;

    /* renamed from: com.amap.api.services.route.DrivePath$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DrivePath> {
        private static com.amap.api.services.route.DrivePath a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DrivePath createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.DrivePath[] newArray(int i) {
            return null;
        }
    }

    public DrivePath() {
        this.e = new java.util.ArrayList();
    }

    public DrivePath(android.os.Parcel parcel) {
        super(parcel);
        this.e = new java.util.ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(com.amap.api.services.route.DriveStep.CREATOR);
        this.d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f;
    }

    public java.util.List<com.amap.api.services.route.DriveStep> getSteps() {
        return this.e;
    }

    public java.lang.String getStrategy() {
        return this.a;
    }

    public float getTollDistance() {
        return this.c;
    }

    public float getTolls() {
        return this.b;
    }

    public int getTotalTrafficlights() {
        return this.d;
    }

    public void setRestriction(int i) {
        this.f = i;
    }

    public void setSteps(java.util.List<com.amap.api.services.route.DriveStep> list) {
        this.e = list;
    }

    public void setStrategy(java.lang.String str) {
        this.a = str;
    }

    public void setTollDistance(float f) {
        this.c = f;
    }

    public void setTolls(float f) {
        this.b = f;
    }

    public void setTotalTrafficlights(int i) {
        this.d = i;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.e);
        parcel.writeInt(this.d);
    }
}
