package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class MarkerOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.MarkerOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.MarkerOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.MarkerOptions markerOptions = new com.amap.api.maps.model.MarkerOptions();
        markerOptions.position((com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader()));
        markerOptions.title(parcel.readString());
        markerOptions.snippet(parcel.readString());
        markerOptions.anchor(parcel.readFloat(), parcel.readFloat());
        markerOptions.setInfoWindowOffset(parcel.readInt(), parcel.readInt());
        boolean[] zArr = new boolean[8];
        parcel.readBooleanArray(zArr);
        markerOptions.visible(zArr[0]);
        markerOptions.draggable(zArr[1]);
        markerOptions.setGps(zArr[2]);
        markerOptions.setFlat(zArr[3]);
        markerOptions.autoOverturnInfoWindow(zArr[4]);
        markerOptions.infoWindowEnable(zArr[5]);
        markerOptions.belowMaskLayer(zArr[6]);
        markerOptions.setRotatingMode(zArr[7]);
        markerOptions.a = parcel.readString();
        markerOptions.period(parcel.readInt());
        markerOptions.icons(parcel.readArrayList(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader()));
        markerOptions.zIndex(parcel.readFloat());
        markerOptions.alpha(parcel.readFloat());
        markerOptions.displayLevel(parcel.readInt());
        markerOptions.rotateAngle(parcel.readFloat());
        markerOptions.setScreenPosition(parcel.readInt(), parcel.readInt());
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = (com.amap.api.maps.model.BitmapDescriptor) parcel.readParcelable(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader());
        if (bitmapDescriptor != null) {
            markerOptions.icon(bitmapDescriptor);
        }
        return markerOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.MarkerOptions[] newArray(int i) {
        return new com.amap.api.maps.model.MarkerOptions[i];
    }
}
