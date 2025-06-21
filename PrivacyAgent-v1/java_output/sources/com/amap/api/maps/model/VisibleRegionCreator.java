package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class VisibleRegionCreator implements android.os.Parcelable.Creator<com.amap.api.maps.model.VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void a(com.amap.api.maps.model.VisibleRegion visibleRegion, android.os.Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.VisibleRegion createFromParcel(android.os.Parcel parcel) {
        com.amap.api.maps.model.LatLng latLng;
        com.amap.api.maps.model.LatLng latLng2;
        com.amap.api.maps.model.LatLng latLng3;
        com.amap.api.maps.model.LatLng latLng4;
        com.amap.api.maps.model.LatLng latLng5;
        com.amap.api.maps.model.LatLngBounds latLngBounds;
        int readInt = parcel.readInt();
        try {
            latLng2 = (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader());
            try {
                latLng3 = (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader());
                try {
                    latLng4 = (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader());
                    try {
                        latLng = (com.amap.api.maps.model.LatLng) parcel.readParcelable(com.amap.api.maps.model.LatLng.class.getClassLoader());
                    } catch (android.os.BadParcelableException e) {
                        e = e;
                        latLng = null;
                    }
                } catch (android.os.BadParcelableException e2) {
                    e = e2;
                    latLng = null;
                    latLng4 = null;
                }
            } catch (android.os.BadParcelableException e3) {
                e = e3;
                latLng = null;
                latLng3 = null;
                latLng4 = latLng3;
                e.printStackTrace();
                latLng5 = latLng;
                latLngBounds = null;
                return new com.amap.api.maps.model.VisibleRegion(readInt, latLng2, latLng3, latLng4, latLng5, latLngBounds);
            }
            try {
                latLngBounds = (com.amap.api.maps.model.LatLngBounds) parcel.readParcelable(com.amap.api.maps.model.LatLngBounds.class.getClassLoader());
                latLng5 = latLng;
            } catch (android.os.BadParcelableException e4) {
                e = e4;
                e.printStackTrace();
                latLng5 = latLng;
                latLngBounds = null;
                return new com.amap.api.maps.model.VisibleRegion(readInt, latLng2, latLng3, latLng4, latLng5, latLngBounds);
            }
        } catch (android.os.BadParcelableException e5) {
            e = e5;
            latLng = null;
            latLng2 = null;
            latLng3 = null;
        }
        return new com.amap.api.maps.model.VisibleRegion(readInt, latLng2, latLng3, latLng4, latLng5, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.amap.api.maps.model.VisibleRegion[] newArray(int i) {
        return new com.amap.api.maps.model.VisibleRegion[i];
    }
}
