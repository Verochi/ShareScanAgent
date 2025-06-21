package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class PolylineOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.PolylineOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.PolylineOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.PolylineOptions polylineOptions = new com.amap.api.maps.model.PolylineOptions();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        parcel.readTypedList(arrayList, com.amap.api.maps.model.LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        float readFloat3 = parcel.readFloat();
        polylineOptions.a = parcel.readString();
        polylineOptions.lineCapType(com.amap.api.maps.model.PolylineOptions.LineCapType.valueOf(parcel.readInt()));
        polylineOptions.lineJoinType(com.amap.api.maps.model.PolylineOptions.LineJoinType.valueOf(parcel.readInt()));
        boolean[] zArr = new boolean[5];
        parcel.readBooleanArray(zArr);
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = (com.amap.api.maps.model.BitmapDescriptor) parcel.readParcelable(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader());
        polylineOptions.addAll(arrayList);
        polylineOptions.width(readFloat);
        polylineOptions.color(readInt);
        polylineOptions.setDottedLineType(readInt2);
        polylineOptions.zIndex(readFloat2);
        polylineOptions.transparency(readFloat3);
        polylineOptions.visible(zArr[0]);
        polylineOptions.setDottedLine(zArr[1]);
        polylineOptions.geodesic(zArr[2]);
        polylineOptions.useGradient(zArr[3]);
        polylineOptions.aboveMaskLayer(zArr[4]);
        polylineOptions.setCustomTexture(bitmapDescriptor);
        polylineOptions.setCustomTextureList(parcel.readArrayList(com.amap.api.maps.model.BitmapDescriptor.class.getClassLoader()));
        polylineOptions.setCustomTextureIndex(parcel.readArrayList(java.lang.Integer.class.getClassLoader()));
        polylineOptions.colorValues(parcel.readArrayList(java.lang.Integer.class.getClassLoader()));
        polylineOptions.setShownRatio(parcel.readFloat());
        return polylineOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.PolylineOptions[] newArray(int i) {
        return new com.amap.api.maps.model.PolylineOptions[i];
    }
}
