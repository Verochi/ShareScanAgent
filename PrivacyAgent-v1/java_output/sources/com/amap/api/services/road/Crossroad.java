package com.amap.api.services.road;

/* loaded from: classes12.dex */
public final class Crossroad extends com.amap.api.services.road.Road {
    public static final android.os.Parcelable.Creator<com.amap.api.services.road.Crossroad> CREATOR = new com.amap.api.services.road.Crossroad.AnonymousClass1();
    private float a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;

    /* renamed from: com.amap.api.services.road.Crossroad$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.road.Crossroad> {
        private static com.amap.api.services.road.Crossroad a(android.os.Parcel parcel) {
            return new com.amap.api.services.road.Crossroad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.road.Crossroad createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.road.Crossroad[] newArray(int i) {
            return null;
        }
    }

    public Crossroad() {
    }

    private Crossroad(android.os.Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }

    public /* synthetic */ Crossroad(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String getDirection() {
        return this.b;
    }

    public final float getDistance() {
        return this.a;
    }

    public final java.lang.String getFirstRoadId() {
        return this.c;
    }

    public final java.lang.String getFirstRoadName() {
        return this.d;
    }

    public final java.lang.String getSecondRoadId() {
        return this.e;
    }

    public final java.lang.String getSecondRoadName() {
        return this.f;
    }

    public final void setDirection(java.lang.String str) {
        this.b = str;
    }

    public final void setDistance(float f) {
        this.a = f;
    }

    public final void setFirstRoadId(java.lang.String str) {
        this.c = str;
    }

    public final void setFirstRoadName(java.lang.String str) {
        this.d = str;
    }

    public final void setSecondRoadId(java.lang.String str) {
        this.e = str;
    }

    public final void setSecondRoadName(java.lang.String str) {
        this.f = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
