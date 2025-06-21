package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class CircleOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable, java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.CircleOptionsCreator CREATOR = new com.amap.api.maps.model.CircleOptionsCreator();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    java.lang.String a;
    private com.amap.api.maps.model.LatLng point = null;
    private double radius = 0.0d;
    private float strokeWidth = 10.0f;
    private int strokeColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private int fillColor = 0;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int dottedLineType = -1;
    private boolean isUsePolylineStroke = true;
    private com.amap.api.maps.model.CircleOptions.CircleUpdateFlags updateFlags = new com.amap.api.maps.model.CircleOptions.CircleUpdateFlags();
    private java.util.List<com.amap.api.maps.model.BaseHoleOptions> holeOptions = new java.util.ArrayList();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class CircleUpdateFlags extends com.amap.api.maps.model.BaseOptions.BaseUpdateFlags {
        protected boolean isCenterUpdated = false;
        protected boolean isRadiusUpdated = false;
        protected boolean isHoleOptionsUpdated = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public CircleOptions() {
        this.type = "CircleOptions";
    }

    private void a() {
        if (this.holeOptions != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> list = this.holeOptions;
            for (int i = 0; i < list.size(); i++) {
                com.amap.api.maps.model.BaseHoleOptions baseHoleOptions = list.get(i);
                if (baseHoleOptions instanceof com.amap.api.maps.model.PolygonHoleOptions) {
                    com.amap.api.maps.model.PolygonHoleOptions polygonHoleOptions = (com.amap.api.maps.model.PolygonHoleOptions) baseHoleOptions;
                    if (com.amap.api.mapcore.util.dl.a(getRadius(), getCenter(), arrayList, polygonHoleOptions) && !com.amap.api.mapcore.util.dl.a(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof com.amap.api.maps.model.CircleHoleOptions) {
                    com.amap.api.maps.model.CircleHoleOptions circleHoleOptions = (com.amap.api.maps.model.CircleHoleOptions) baseHoleOptions;
                    if (com.amap.api.mapcore.util.dl.a(getRadius(), getCenter(), circleHoleOptions) && !com.amap.api.mapcore.util.dl.a(arrayList, circleHoleOptions)) {
                        arrayList.add(circleHoleOptions);
                    }
                }
            }
            this.holeOptions.clear();
            this.holeOptions.addAll(arrayList);
            this.updateFlags.isHoleOptionsUpdated = true;
        }
    }

    public final com.amap.api.maps.model.CircleOptions addHoles(java.lang.Iterable<com.amap.api.maps.model.BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                java.util.Iterator<com.amap.api.maps.model.BaseHoleOptions> it = iterable.iterator();
                while (it.hasNext()) {
                    this.holeOptions.add(it.next());
                }
                a();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.CircleOptions addHoles(com.amap.api.maps.model.BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.holeOptions.addAll(java.util.Arrays.asList(baseHoleOptionsArr));
                a();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.CircleOptions center(com.amap.api.maps.model.LatLng latLng) {
        this.point = latLng;
        this.updateFlags.isCenterUpdated = true;
        a();
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.CircleOptions m18clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
        }
        com.amap.api.maps.model.CircleOptions circleOptions = new com.amap.api.maps.model.CircleOptions();
        circleOptions.a = this.a;
        circleOptions.point = this.point;
        circleOptions.radius = this.radius;
        circleOptions.strokeWidth = this.strokeWidth;
        circleOptions.strokeColor = this.strokeColor;
        circleOptions.fillColor = this.fillColor;
        circleOptions.zIndex = this.zIndex;
        circleOptions.isVisible = this.isVisible;
        circleOptions.holeOptions = this.holeOptions;
        circleOptions.dottedLineType = this.dottedLineType;
        circleOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        circleOptions.updateFlags = this.updateFlags;
        return circleOptions;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.CircleOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final com.amap.api.maps.model.LatLng getCenter() {
        return this.point;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final java.util.List<com.amap.api.maps.model.BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final com.amap.api.maps.model.CircleOptions.CircleUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final com.amap.api.maps.model.CircleOptions radius(double d) {
        this.radius = d;
        this.updateFlags.isRadiusUpdated = true;
        a();
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final com.amap.api.maps.model.CircleOptions setStrokeDottedLineType(int i) {
        this.dottedLineType = i;
        return this;
    }

    public final com.amap.api.maps.model.CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final com.amap.api.maps.model.CircleOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public final com.amap.api.maps.model.CircleOptions usePolylineStroke(boolean z) {
        this.isUsePolylineStroke = z;
        return this;
    }

    public final com.amap.api.maps.model.CircleOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        android.os.Bundle bundle = new android.os.Bundle();
        com.amap.api.maps.model.LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public final com.amap.api.maps.model.CircleOptions zIndex(float f) {
        if (this.zIndex != f) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }
}
