package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class TimeInfosElement implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.TimeInfosElement> CREATOR = new com.amap.api.services.route.TimeInfosElement.AnonymousClass1();
    int a;
    float b;
    float c;
    int d;
    private java.util.List<com.amap.api.services.route.TMC> e;

    /* renamed from: com.amap.api.services.route.TimeInfosElement$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.TimeInfosElement> {
        private static com.amap.api.services.route.TimeInfosElement a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.TimeInfosElement createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.TimeInfosElement[] newArray(int i) {
            return null;
        }
    }

    public TimeInfosElement() {
        this.e = new java.util.ArrayList();
    }

    public TimeInfosElement(android.os.Parcel parcel) {
        this.e = new java.util.ArrayList();
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(com.amap.api.services.route.TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.b;
    }

    public int getPathindex() {
        return this.a;
    }

    public int getRestriction() {
        return this.d;
    }

    public java.util.List<com.amap.api.services.route.TMC> getTMCs() {
        return this.e;
    }

    public float getTolls() {
        return this.c;
    }

    public void setDuration(float f) {
        this.b = f;
    }

    public void setPathindex(int i) {
        this.a = i;
    }

    public void setRestriction(int i) {
        this.d = i;
    }

    public void setTMCs(java.util.List<com.amap.api.services.route.TMC> list) {
        this.e = list;
    }

    public void setTolls(float f) {
        this.c = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
    }
}
