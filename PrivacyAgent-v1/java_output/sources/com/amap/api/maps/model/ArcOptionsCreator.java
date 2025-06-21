package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class ArcOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.ArcOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.ArcOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.ArcOptions arcOptions = new com.amap.api.maps.model.ArcOptions();
        android.os.Bundle readBundle = parcel.readBundle();
        arcOptions.point(new com.amap.api.maps.model.LatLng(readBundle.getDouble("startlat"), readBundle.getDouble("startlng")), new com.amap.api.maps.model.LatLng(readBundle.getDouble("passedlat"), readBundle.getDouble("passedlng")), new com.amap.api.maps.model.LatLng(readBundle.getDouble("endlat"), readBundle.getDouble("endlng")));
        arcOptions.strokeWidth(parcel.readFloat());
        arcOptions.strokeColor(parcel.readInt());
        arcOptions.zIndex(parcel.readFloat());
        arcOptions.visible(parcel.readByte() == 1);
        arcOptions.a = parcel.readString();
        return arcOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.ArcOptions[] newArray(int i) {
        return new com.amap.api.maps.model.ArcOptions[i];
    }
}
