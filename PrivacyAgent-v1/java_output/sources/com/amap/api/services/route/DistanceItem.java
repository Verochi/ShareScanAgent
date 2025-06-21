package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DistanceItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.DistanceItem> CREATOR = new com.amap.api.services.route.DistanceItem.AnonymousClass1();
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;
    private int a;
    private int b;
    private float c;
    private float d;
    private java.lang.String e;
    private int f;

    /* renamed from: com.amap.api.services.route.DistanceItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DistanceItem> {
        private static com.amap.api.services.route.DistanceItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.DistanceItem(parcel);
        }

        private static com.amap.api.services.route.DistanceItem[] a(int i) {
            return new com.amap.api.services.route.DistanceItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DistanceItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.DistanceItem[] newArray(int i) {
            return a(i);
        }
    }

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.a = 1;
        this.b = 1;
        this.c = 0.0f;
        this.d = 0.0f;
    }

    public DistanceItem(android.os.Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.a = 1;
        this.b = 1;
        this.c = 0.0f;
        this.d = 0.0f;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.b;
    }

    public float getDistance() {
        return this.c;
    }

    public float getDuration() {
        return this.d;
    }

    public int getErrorCode() {
        return this.f;
    }

    public java.lang.String getErrorInfo() {
        return this.e;
    }

    public int getOriginId() {
        return this.a;
    }

    public void setDestId(int i) {
        this.b = i;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public void setDuration(float f) {
        this.d = f;
    }

    public void setErrorCode(int i) {
        this.f = i;
    }

    public void setErrorInfo(java.lang.String str) {
        this.e = str;
    }

    public void setOriginId(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
    }
}
