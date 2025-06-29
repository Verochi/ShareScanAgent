package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class NavigateArrowOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.NavigateArrowOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.NavigateArrowOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions = new com.amap.api.maps.model.NavigateArrowOptions();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        parcel.readTypedList(arrayList, com.amap.api.maps.model.LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z = parcel.readByte() == 1;
        boolean z2 = parcel.readByte() == 1;
        navigateArrowOptions.addAll(arrayList);
        navigateArrowOptions.width(readFloat);
        navigateArrowOptions.topColor(readInt);
        navigateArrowOptions.sideColor(readInt2);
        navigateArrowOptions.zIndex(readFloat2);
        navigateArrowOptions.visible(z);
        navigateArrowOptions.a = parcel.readString();
        navigateArrowOptions.set3DModel(z2);
        return navigateArrowOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.NavigateArrowOptions[] newArray(int i) {
        return new com.amap.api.maps.model.NavigateArrowOptions[i];
    }
}
