package com.amap.api.maps;

/* loaded from: classes12.dex */
public class AMapOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.AMapOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.AMapOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.AMapOptions aMapOptions = new com.amap.api.maps.AMapOptions();
        com.amap.api.maps.model.CameraPosition cameraPosition = (com.amap.api.maps.model.CameraPosition) parcel.readParcelable(com.amap.api.maps.model.CameraPosition.class.getClassLoader());
        aMapOptions.mapType(parcel.readInt());
        aMapOptions.logoPosition(parcel.readInt());
        aMapOptions.camera(cameraPosition);
        boolean[] createBooleanArray = parcel.createBooleanArray();
        if (createBooleanArray != null && createBooleanArray.length >= 6) {
            aMapOptions.rotateGesturesEnabled(createBooleanArray[0]);
            aMapOptions.scrollGesturesEnabled(createBooleanArray[1]);
            aMapOptions.tiltGesturesEnabled(createBooleanArray[2]);
            aMapOptions.zoomGesturesEnabled(createBooleanArray[3]);
            aMapOptions.zoomControlsEnabled(createBooleanArray[4]);
            aMapOptions.zOrderOnTop(createBooleanArray[5]);
            aMapOptions.compassEnabled(createBooleanArray[6]);
            aMapOptions.scaleControlsEnabled(createBooleanArray[7]);
        }
        return aMapOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.AMapOptions[] newArray(int i) {
        return new com.amap.api.maps.AMapOptions[i];
    }
}
