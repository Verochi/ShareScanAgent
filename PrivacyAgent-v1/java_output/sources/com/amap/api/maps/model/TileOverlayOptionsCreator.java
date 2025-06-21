package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class TileOverlayOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.TileOverlayOptions createFromParcel(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        com.amap.api.maps.model.TileProvider tileProvider = (com.amap.api.maps.model.TileProvider) parcel.readValue(com.amap.api.maps.model.TileProvider.class.getClassLoader());
        boolean z = parcel.readByte() != 0;
        float readFloat = parcel.readFloat();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        java.lang.String readString = parcel.readString();
        boolean z2 = parcel.readByte() != 0;
        boolean z3 = parcel.readByte() != 0;
        com.amap.api.maps.model.TileOverlayOptions tileOverlayOptions = new com.amap.api.maps.model.TileOverlayOptions(readInt, z, readFloat);
        if (tileProvider != null) {
            tileOverlayOptions.tileProvider(tileProvider);
        }
        tileOverlayOptions.memCacheSize(readInt2);
        tileOverlayOptions.diskCacheSize(readInt3);
        tileOverlayOptions.diskCacheDir(readString);
        tileOverlayOptions.memoryCacheEnabled(z2);
        tileOverlayOptions.diskCacheEnabled(z3);
        return tileOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.TileOverlayOptions[] newArray(int i) {
        return new com.amap.api.maps.model.TileOverlayOptions[i];
    }
}
