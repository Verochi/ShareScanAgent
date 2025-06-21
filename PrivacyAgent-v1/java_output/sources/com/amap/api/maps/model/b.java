package com.amap.api.maps.model;

/* loaded from: classes12.dex */
final class b implements android.os.Parcelable.Creator<com.amap.api.maps.model.Tile> {
    private static com.amap.api.maps.model.Tile a(android.os.Parcel parcel) {
        return new com.amap.api.maps.model.Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    private static com.amap.api.maps.model.Tile[] a(int i) {
        return new com.amap.api.maps.model.Tile[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ com.amap.api.maps.model.Tile createFromParcel(android.os.Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ com.amap.api.maps.model.Tile[] newArray(int i) {
        return a(i);
    }
}
