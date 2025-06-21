package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class MyLocationStyleCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.MyLocationStyle> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.MyLocationStyle createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.MyLocationStyle myLocationStyle = new com.amap.api.maps.model.MyLocationStyle();
        myLocationStyle.myLocationIcon((com.amap.api.maps.model.BitmapDescriptor) parcel.readParcelable(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader()));
        myLocationStyle.anchor(parcel.readFloat(), parcel.readFloat());
        myLocationStyle.radiusFillColor(parcel.readInt());
        myLocationStyle.strokeColor(parcel.readInt());
        myLocationStyle.strokeWidth(parcel.readFloat());
        myLocationStyle.myLocationType(parcel.readInt());
        myLocationStyle.interval(parcel.readLong());
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        myLocationStyle.showMyLocation(zArr[0]);
        return myLocationStyle;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.MyLocationStyle[] newArray(int i) {
        return new com.amap.api.maps.model.MyLocationStyle[i];
    }
}
