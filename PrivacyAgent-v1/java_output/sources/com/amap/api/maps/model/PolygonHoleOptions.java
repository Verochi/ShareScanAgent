package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class PolygonHoleOptions extends com.amap.api.maps.model.BaseHoleOptions implements android.os.Parcelable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final android.os.Parcelable.Creator<com.amap.api.maps.model.PolygonHoleOptions> CREATOR = new com.amap.api.maps.model.PolygonHoleOptions.AnonymousClass1();
    private final java.util.List<com.amap.api.maps.model.LatLng> points;

    /* renamed from: com.amap.api.maps.model.PolygonHoleOptions$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.maps.model.PolygonHoleOptions> {
        private static com.amap.api.maps.model.PolygonHoleOptions a(android.os.Parcel parcel) {
            return new com.amap.api.maps.model.PolygonHoleOptions(parcel);
        }

        private static com.amap.api.maps.model.PolygonHoleOptions[] a(int i) {
            return new com.amap.api.maps.model.PolygonHoleOptions[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.model.PolygonHoleOptions createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.model.PolygonHoleOptions[] newArray(int i) {
            return a(i);
        }
    }

    public PolygonHoleOptions() {
        this.points = new java.util.ArrayList();
        this.isPolygonHoleOptions = true;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public PolygonHoleOptions(android.os.Parcel parcel) {
        this.points = parcel.createTypedArrayList(com.amap.api.maps.model.LatLng.CREATOR);
        this.isPolygonHoleOptions = true;
    }

    public com.amap.api.maps.model.PolygonHoleOptions addAll(java.lang.Iterable<com.amap.api.maps.model.LatLng> iterable) {
        try {
            java.util.Iterator<com.amap.api.maps.model.LatLng> it = iterable.iterator();
            while (it.hasNext()) {
                this.points.add(it.next());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.amap.api.maps.model.LatLng> getPoints() {
        return this.points;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
    }
}
