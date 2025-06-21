package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class PolygonOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.PolygonOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.PolygonOptions polygonOptions = new com.amap.api.maps.model.PolygonOptions();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        parcel.readTypedList(arrayList, com.amap.api.maps.model.LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z = parcel.readByte() == 1;
        com.amap.api.maps.model.LatLng[] latLngArr = new com.amap.api.maps.model.LatLng[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            latLngArr[i] = (com.amap.api.maps.model.LatLng) arrayList.get(i);
        }
        polygonOptions.add(latLngArr);
        polygonOptions.strokeWidth(readFloat);
        polygonOptions.strokeColor(readInt);
        polygonOptions.fillColor(readInt2);
        polygonOptions.zIndex(readFloat2);
        polygonOptions.visible(z);
        polygonOptions.a = parcel.readString();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        parcel.readList(arrayList2, com.amap.api.maps.model.BaseHoleOptions.class.getClassLoader());
        polygonOptions.addHoles(arrayList2);
        polygonOptions.lineJoinType(com.amap.api.maps.model.AMapPara.LineJoinType.valueOf(parcel.readInt()));
        polygonOptions.usePolylineStroke(parcel.readByte() == 1);
        return polygonOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.PolygonOptions[] newArray(int i) {
        return new com.amap.api.maps.model.PolygonOptions[i];
    }
}
