package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class TextOptionsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.TextOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.TextOptions createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.TextOptions textOptions = new com.amap.api.maps.model.TextOptions();
        textOptions.a = parcel.readString();
        android.os.Bundle readBundle = parcel.readBundle();
        textOptions.position(new com.amap.api.maps.model.LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        textOptions.text(parcel.readString());
        textOptions.typeface(android.graphics.Typeface.defaultFromStyle(parcel.readInt()));
        textOptions.rotate(parcel.readFloat());
        textOptions.align(parcel.readInt(), parcel.readInt());
        textOptions.backgroundColor(parcel.readInt());
        textOptions.fontColor(parcel.readInt());
        textOptions.fontSize(parcel.readInt());
        textOptions.zIndex(parcel.readFloat());
        textOptions.visible(parcel.readByte() == 1);
        try {
            android.os.Parcelable parcelable = parcel.readBundle().getParcelable("obj");
            if (parcelable != null) {
                textOptions.setObject(parcelable);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return textOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.TextOptions[] newArray(int i) {
        return new com.amap.api.maps.model.TextOptions[i];
    }
}
