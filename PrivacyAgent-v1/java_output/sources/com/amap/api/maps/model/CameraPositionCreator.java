package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class CameraPositionCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.CameraPosition> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.CameraPosition createFromParcel(android.os.Parcel parcel) {
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        float readFloat3 = parcel.readFloat();
        return new com.amap.api.maps.model.CameraPosition(new com.amap.api.maps.model.LatLng(readFloat2, readFloat3), parcel.readFloat(), parcel.readFloat(), readFloat);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.CameraPosition[] newArray(int i) {
        return new com.amap.api.maps.model.CameraPosition[i];
    }
}
