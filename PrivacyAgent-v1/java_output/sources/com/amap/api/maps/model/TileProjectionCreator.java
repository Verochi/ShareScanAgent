package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class TileProjectionCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.TileProjection> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.TileProjection createFromParcel(android.os.Parcel parcel) {
        return new com.amap.api.maps.model.TileProjection(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.TileProjection[] newArray(int i) {
        return new com.amap.api.maps.model.TileProjection[i];
    }
}
