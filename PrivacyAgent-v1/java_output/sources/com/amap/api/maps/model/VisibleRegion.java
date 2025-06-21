package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class VisibleRegion implements android.os.Parcelable {
    public static final com.amap.api.maps.model.VisibleRegionCreator CREATOR = new com.amap.api.maps.model.VisibleRegionCreator();
    public final com.amap.api.maps.model.LatLng farLeft;
    public final com.amap.api.maps.model.LatLng farRight;
    public final com.amap.api.maps.model.LatLngBounds latLngBounds;
    private final int mVersionCode;
    public final com.amap.api.maps.model.LatLng nearLeft;
    public final com.amap.api.maps.model.LatLng nearRight;

    public VisibleRegion(int i, com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2, com.amap.api.maps.model.LatLng latLng3, com.amap.api.maps.model.LatLng latLng4, com.amap.api.maps.model.LatLngBounds latLngBounds) {
        this.mVersionCode = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2, com.amap.api.maps.model.LatLng latLng3, com.amap.api.maps.model.LatLng latLng4, com.amap.api.maps.model.LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public final int a() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.amap.api.maps.model.VisibleRegion)) {
            return false;
        }
        com.amap.api.maps.model.VisibleRegion visibleRegion = (com.amap.api.maps.model.VisibleRegion) obj;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    public final int hashCode() {
        return com.amap.api.mapcore.util.dl.a(new java.lang.Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    public final java.lang.String toString() {
        return com.amap.api.mapcore.util.dl.a(com.amap.api.mapcore.util.dl.a("nearLeft", this.nearLeft), com.amap.api.mapcore.util.dl.a("nearRight", this.nearRight), com.amap.api.mapcore.util.dl.a("farLeft", this.farLeft), com.amap.api.mapcore.util.dl.a("farRight", this.farRight), com.amap.api.mapcore.util.dl.a("latLngBounds", this.latLngBounds));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        com.amap.api.maps.model.VisibleRegionCreator.a(this, parcel, i);
    }
}
