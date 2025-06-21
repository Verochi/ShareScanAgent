package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class GroundOverlayOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.GroundOverlayOptions createFromParcel(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = (com.amap.api.maps.model.BitmapDescriptor) parcel.readParcelable(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader());
        com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions = new com.amap.api.maps.model.GroundOverlayOptions(readInt, (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), (com.amap.api.maps.model.LatLngBounds) parcel.readParcelable(com.amap.api.maps.model.LatLngBounds.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), parcel.readByte() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        groundOverlayOptions.image(bitmapDescriptor);
        return groundOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.GroundOverlayOptions[] newArray(int i) {
        return new com.amap.api.maps.model.GroundOverlayOptions[i];
    }
}
