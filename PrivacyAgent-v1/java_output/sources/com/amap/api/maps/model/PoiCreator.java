package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class PoiCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.Poi> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.Poi createFromParcel(android.os.Parcel parcel) {
        return new com.amap.api.maps.model.Poi(parcel.readString(), (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader()), parcel.readString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.Poi[] newArray(int i) {
        return new com.amap.api.maps.model.Poi[i];
    }
}
