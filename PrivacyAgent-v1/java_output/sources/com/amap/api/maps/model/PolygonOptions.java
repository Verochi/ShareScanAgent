package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class PolygonOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable, java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.PolygonOptionsCreator CREATOR = new com.amap.api.maps.model.PolygonOptionsCreator();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    java.lang.String a;
    private float strokeWidth = 10.0f;
    private int strokeColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private int fillColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isUsePolylineStroke = true;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.AMapPara.LineJoinType lineJoinType = com.amap.api.maps.model.AMapPara.LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private com.amap.api.maps.model.PolygonOptions.PolygonUpdateFlags updateFlags = new com.amap.api.maps.model.PolygonOptions.PolygonUpdateFlags();
    private final java.util.List<com.amap.api.maps.model.LatLng> points = new java.util.ArrayList();
    private java.util.List<com.amap.api.maps.model.BaseHoleOptions> holeOptions = new java.util.ArrayList();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class PolygonUpdateFlags extends com.amap.api.maps.model.BaseOptions.BaseUpdateFlags {
        protected boolean isPointsUpdated = false;
        protected boolean isHoleOptionsUpdated = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public PolygonOptions() {
        this.type = "PolygonOptions";
    }

    private void a() {
        if (this.holeOptions != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> list = this.holeOptions;
            for (int i = 0; i < list.size(); i++) {
                com.amap.api.maps.model.BaseHoleOptions baseHoleOptions = list.get(i);
                if (baseHoleOptions instanceof com.amap.api.maps.model.PolygonHoleOptions) {
                    com.amap.api.maps.model.PolygonHoleOptions polygonHoleOptions = (com.amap.api.maps.model.PolygonHoleOptions) baseHoleOptions;
                    if (com.amap.api.mapcore.util.dl.b(getPoints(), polygonHoleOptions) && !com.amap.api.mapcore.util.dl.a(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof com.amap.api.maps.model.CircleHoleOptions) {
                    com.amap.api.maps.model.CircleHoleOptions circleHoleOptions = (com.amap.api.maps.model.CircleHoleOptions) baseHoleOptions;
                    if (com.amap.api.mapcore.util.dl.a(getPoints(), arrayList, circleHoleOptions) && !com.amap.api.mapcore.util.dl.a(arrayList, circleHoleOptions)) {
                        arrayList.add(circleHoleOptions);
                    }
                }
            }
            this.holeOptions.clear();
            this.holeOptions.addAll(arrayList);
            this.updateFlags.isHoleOptionsUpdated = true;
        }
    }

    public final com.amap.api.maps.model.PolygonOptions add(com.amap.api.maps.model.LatLng latLng) {
        try {
            this.points.add(latLng);
            this.updateFlags.isPointsUpdated = true;
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions add(com.amap.api.maps.model.LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(java.util.Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
                a();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions addAll(java.lang.Iterable<com.amap.api.maps.model.LatLng> iterable) {
        if (iterable != null) {
            try {
                java.util.Iterator<com.amap.api.maps.model.LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                a();
                this.updateFlags.isPointsUpdated = true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions addHoles(java.lang.Iterable<com.amap.api.maps.model.BaseHoleOptions> iterable) {
        if (iterable == null) {
            return this;
        }
        try {
            java.util.Iterator<com.amap.api.maps.model.BaseHoleOptions> it = iterable.iterator();
            while (it.hasNext()) {
                this.holeOptions.add(it.next());
            }
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions addHoles(com.amap.api.maps.model.BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr == null) {
            return this;
        }
        try {
            this.holeOptions.addAll(java.util.Arrays.asList(baseHoleOptionsArr));
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.PolygonOptions m24clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
        }
        com.amap.api.maps.model.PolygonOptions polygonOptions = new com.amap.api.maps.model.PolygonOptions();
        polygonOptions.points.addAll(this.points);
        polygonOptions.strokeWidth = this.strokeWidth;
        polygonOptions.strokeColor = this.strokeColor;
        polygonOptions.fillColor = this.fillColor;
        polygonOptions.zIndex = this.zIndex;
        polygonOptions.isVisible = this.isVisible;
        polygonOptions.holeOptions = this.holeOptions;
        polygonOptions.a = this.a;
        polygonOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        polygonOptions.lineJoinType = this.lineJoinType;
        polygonOptions.nLineCapType = this.nLineCapType;
        polygonOptions.nLineJoinType = this.nLineJoinType;
        polygonOptions.updateFlags = this.updateFlags;
        return polygonOptions;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final java.util.List<com.amap.api.maps.model.BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final com.amap.api.maps.model.AMapPara.LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public final java.util.List<com.amap.api.maps.model.LatLng> getPoints() {
        return this.points;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final com.amap.api.maps.model.PolygonOptions.PolygonUpdateFlags getUpdateFlags() {
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

    public final com.amap.api.maps.model.PolygonOptions lineJoinType(com.amap.api.maps.model.AMapPara.LineJoinType lineJoinType) {
        if (lineJoinType != null) {
            this.lineJoinType = lineJoinType;
            this.nLineJoinType = lineJoinType.getTypeValue();
        }
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final void setHoleOptions(java.util.List<com.amap.api.maps.model.BaseHoleOptions> list) {
        try {
            this.holeOptions.clear();
            if (list != null) {
                this.holeOptions.addAll(list);
            }
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPoints(java.util.List<com.amap.api.maps.model.LatLng> list) {
        try {
            this.points.clear();
            if (list == null) {
                return;
            }
            this.points.addAll(list);
            a();
            this.updateFlags.isPointsUpdated = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final com.amap.api.maps.model.PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions usePolylineStroke(boolean z) {
        this.isUsePolylineStroke = z;
        return this;
    }

    public final com.amap.api.maps.model.PolygonOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public final com.amap.api.maps.model.PolygonOptions zIndex(float f) {
        float f2 = this.zIndex;
        if (f2 != f2) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }
}
