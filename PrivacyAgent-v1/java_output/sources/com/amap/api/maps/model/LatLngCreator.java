package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class LatLngCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.LatLng createFromParcel(android.os.Parcel parcel) {
        return new com.amap.api.maps.model.LatLng(parcel.readDouble(), parcel.readDouble());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.LatLng[] newArray(int i) {
        return new com.amap.api.maps.model.LatLng[i];
    }
}
