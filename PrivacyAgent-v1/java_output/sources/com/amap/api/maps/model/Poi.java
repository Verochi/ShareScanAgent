package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class Poi implements android.os.Parcelable {
    public static final com.amap.api.maps.model.PoiCreator CREATOR = new com.amap.api.maps.model.PoiCreator();
    private final com.amap.api.maps.model.LatLng coordinate;
    private final java.lang.String name;
    private final java.lang.String poiid;

    public Poi(java.lang.String str, com.amap.api.maps.model.LatLng latLng, java.lang.String str2) {
        this.name = str;
        this.coordinate = latLng;
        this.poiid = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof com.amap.api.maps.model.Poi)) {
            com.amap.api.maps.model.Poi poi = (com.amap.api.maps.model.Poi) obj;
            if (poi.getName().equals(this.name) && poi.getCoordinate().equals(this.coordinate) && poi.getPoiId().equals(this.poiid)) {
                return true;
            }
        }
        return false;
    }

    public com.amap.api.maps.model.LatLng getCoordinate() {
        return this.coordinate;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getPoiId() {
        return this.poiid;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public java.lang.String toString() {
        return "poiid " + this.poiid + " name:" + this.name + "  coordinate:" + this.coordinate.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.coordinate, i);
        parcel.writeString(this.poiid);
    }
}
