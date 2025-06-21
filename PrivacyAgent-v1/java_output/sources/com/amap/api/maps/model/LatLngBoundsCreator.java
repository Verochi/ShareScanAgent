package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class LatLngBoundsCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void a(com.amap.api.maps.model.LatLngBounds latLngBounds, android.os.Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.LatLngBounds createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.LatLng latLng;
        int readInt = parcel.readInt();
        com.amap.api.maps.model.LatLng latLng2 = null;
        try {
            latLng = (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLngBounds.class.getClassLoader());
            } catch (android.os.BadParcelableException e) {
                e = e;
                e.printStackTrace();
                return new com.amap.api.maps.model.LatLngBounds(readInt, latLng, latLng2);
            }
        } catch (android.os.BadParcelableException e2) {
            e = e2;
            latLng = null;
        }
        return new com.amap.api.maps.model.LatLngBounds(readInt, latLng, latLng2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.LatLngBounds[] newArray(int i) {
        return new com.amap.api.maps.model.LatLngBounds[i];
    }
}
