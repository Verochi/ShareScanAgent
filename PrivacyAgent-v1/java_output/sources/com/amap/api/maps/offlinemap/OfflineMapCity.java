package com.amap.api.maps.offlinemap;

/* loaded from: classes12.dex */
public class OfflineMapCity extends com.amap.api.maps.offlinemap.City {
    public static final android.os.Parcelable.Creator<com.amap.api.maps.offlinemap.OfflineMapCity> CREATOR = new com.amap.api.maps.offlinemap.OfflineMapCity.AnonymousClass1();
    private java.lang.String a;
    private long b;
    private int c;
    private java.lang.String d;
    private int e;

    /* renamed from: com.amap.api.maps.offlinemap.OfflineMapCity$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.maps.offlinemap.OfflineMapCity> {
        private static com.amap.api.maps.offlinemap.OfflineMapCity a(android.os.Parcel parcel) {
            return new com.amap.api.maps.offlinemap.OfflineMapCity(parcel);
        }

        private static com.amap.api.maps.offlinemap.OfflineMapCity[] a(int i) {
            return new com.amap.api.maps.offlinemap.OfflineMapCity[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.offlinemap.OfflineMapCity createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.offlinemap.OfflineMapCity[] newArray(int i) {
            return a(i);
        }
    }

    public OfflineMapCity() {
        this.a = "";
        this.b = 0L;
        this.c = 6;
        this.d = "";
        this.e = 0;
    }

    public OfflineMapCity(android.os.Parcel parcel) {
        super(parcel);
        this.a = "";
        this.b = 0L;
        this.c = 6;
        this.d = "";
        this.e = 0;
        this.a = parcel.readString();
        this.b = parcel.readLong();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.b;
    }

    public int getState() {
        return this.c;
    }

    public java.lang.String getUrl() {
        return this.a;
    }

    public java.lang.String getVersion() {
        return this.d;
    }

    public int getcompleteCode() {
        return this.e;
    }

    public void setCompleteCode(int i) {
        this.e = i;
    }

    public void setSize(long j) {
        this.b = j;
    }

    public void setState(int i) {
        this.c = i;
    }

    public void setUrl(java.lang.String str) {
        this.a = str;
    }

    public void setVersion(java.lang.String str) {
        this.d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }
}
