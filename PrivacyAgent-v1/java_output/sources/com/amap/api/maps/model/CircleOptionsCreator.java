package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class CircleOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.CircleOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.CircleOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.CircleOptions circleOptions = new com.amap.api.maps.model.CircleOptions();
        android.os.Bundle readBundle = parcel.readBundle();
        circleOptions.center(new com.amap.api.maps.model.LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readFloat());
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.a = parcel.readString();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        parcel.readList(arrayList, com.amap.api.maps.model.BaseHoleOptions.class.getClassLoader());
        circleOptions.addHoles(arrayList);
        circleOptions.setStrokeDottedLineType(parcel.readInt());
        circleOptions.usePolylineStroke(parcel.readByte() == 1);
        return circleOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.CircleOptions[] newArray(int i) {
        return new com.amap.api.maps.model.CircleOptions[i];
    }
}
