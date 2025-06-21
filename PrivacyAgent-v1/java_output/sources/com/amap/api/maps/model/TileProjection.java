package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class TileProjection implements android.os.Parcelable {
    public static final com.amap.api.maps.model.TileProjection CREATOR = new com.amap.api.maps.model.TileProjection(0, 0, 0, 0, 0, 0);
    public final int maxX;
    public final int maxY;
    public final int minX;
    public final int minY;
    public final int offsetX;
    public final int offsetY;

    public TileProjection(int i, int i2, int i3, int i4, int i5, int i6) {
        this.offsetX = i;
        this.offsetY = i2;
        this.minX = i3;
        this.maxX = i4;
        this.minY = i5;
        this.maxY = i6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeInt(this.minX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.maxY);
    }
}
