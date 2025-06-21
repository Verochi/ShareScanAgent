package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class BitmapDescriptorCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.BitmapDescriptor> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.BitmapDescriptor createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = new com.amap.api.maps.model.BitmapDescriptor(null, parcel.readString());
        bitmapDescriptor.mBitmap = parcel.readParcelable(android.graphics.Bitmap.class.getClassLoader());
        bitmapDescriptor.a = parcel.readInt();
        bitmapDescriptor.b = parcel.readInt();
        return bitmapDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.BitmapDescriptor[] newArray(int i) {
        return new com.amap.api.maps.model.BitmapDescriptor[i];
    }
}
