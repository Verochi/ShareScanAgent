package com.amap.api.services.poisearch;

/* loaded from: classes12.dex */
public class IndoorData implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.poisearch.IndoorData> CREATOR = new com.amap.api.services.poisearch.IndoorData.AnonymousClass1();
    private java.lang.String a;
    private int b;
    private java.lang.String c;

    /* renamed from: com.amap.api.services.poisearch.IndoorData$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.poisearch.IndoorData> {
        private static com.amap.api.services.poisearch.IndoorData a(android.os.Parcel parcel) {
            return new com.amap.api.services.poisearch.IndoorData(parcel);
        }

        private static com.amap.api.services.poisearch.IndoorData[] a(int i) {
            return new com.amap.api.services.poisearch.IndoorData[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.poisearch.IndoorData createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.poisearch.IndoorData[] newArray(int i) {
            return a(i);
        }
    }

    public IndoorData(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
    }

    public IndoorData(java.lang.String str, int i, java.lang.String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.b;
    }

    public java.lang.String getFloorName() {
        return this.c;
    }

    public java.lang.String getPoiId() {
        return this.a;
    }

    public void setFloor(int i) {
        this.b = i;
    }

    public void setFloorName(java.lang.String str) {
        this.c = str;
    }

    public void setPoiId(java.lang.String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
    }
}
