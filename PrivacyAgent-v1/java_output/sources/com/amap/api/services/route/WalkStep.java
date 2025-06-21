package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class WalkStep implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.WalkStep> CREATOR = new com.amap.api.services.route.WalkStep.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private float d;
    private float e;
    private java.util.List<com.amap.api.services.core.LatLonPoint> f;
    private java.lang.String g;
    private java.lang.String h;

    /* renamed from: com.amap.api.services.route.WalkStep$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.WalkStep> {
        private static com.amap.api.services.route.WalkStep a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.WalkStep createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.WalkStep[] newArray(int i) {
            return null;
        }
    }

    public WalkStep() {
        this.f = new java.util.ArrayList();
    }

    public WalkStep(android.os.Parcel parcel) {
        this.f = new java.util.ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAction() {
        return this.g;
    }

    public java.lang.String getAssistantAction() {
        return this.h;
    }

    public float getDistance() {
        return this.d;
    }

    public float getDuration() {
        return this.e;
    }

    public java.lang.String getInstruction() {
        return this.a;
    }

    public java.lang.String getOrientation() {
        return this.b;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getPolyline() {
        return this.f;
    }

    public java.lang.String getRoad() {
        return this.c;
    }

    public void setAction(java.lang.String str) {
        this.g = str;
    }

    public void setAssistantAction(java.lang.String str) {
        this.h = str;
    }

    public void setDistance(float f) {
        this.d = f;
    }

    public void setDuration(float f) {
        this.e = f;
    }

    public void setInstruction(java.lang.String str) {
        this.a = str;
    }

    public void setOrientation(java.lang.String str) {
        this.b = str;
    }

    public void setPolyline(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
        this.f = list;
    }

    public void setRoad(java.lang.String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
