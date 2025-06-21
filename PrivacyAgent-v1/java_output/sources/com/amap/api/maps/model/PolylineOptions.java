package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class PolylineOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.PolylineOptionsCreator CREATOR = new com.amap.api.maps.model.PolylineOptionsCreator();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    java.lang.String a;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.util.List<java.lang.Integer> colorValues;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.util.List<java.lang.Integer> customIndexs;
    private com.amap.api.maps.model.BitmapDescriptor customTexture;
    private java.util.List<com.amap.api.maps.model.BitmapDescriptor> customTextureList;
    private com.amap.api.maps.model.BitmapDescriptor eraseTexture;
    private com.amap.api.maps.model.BitmapDescriptor footPrintTexture;
    private int[] jniColorValues;
    private int[] jniCustomIndexes;
    private float width = 10.0f;
    private int color = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isUseTexture = true;
    private boolean isGeodesic = false;
    private boolean isDottedLine = false;
    private boolean isGradient = false;
    private float transparency = 1.0f;
    private boolean isAboveMaskLayer = false;
    private int dottedLineType = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.PolylineOptions.LineCapType lineCapType = com.amap.api.maps.model.PolylineOptions.LineCapType.LineCapRound;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.PolylineOptions.LineJoinType lineJoinType = com.amap.api.maps.model.PolylineOptions.LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private float shownRatio = -1.0f;
    private float shownRangeBegin = -1.0f;
    private float shownRangeEnd = -1.0f;
    private float footPrintGap = 0.0f;
    private boolean eraseVisible = false;
    private int eraseColor = -7829368;
    private float shownPolylineRangeBegin = 0.0f;
    private float shownPolylineRangeEnd = 0.0f;
    private boolean showPolylineRangeEnable = false;
    private com.amap.api.maps.model.PolylineOptions.PolylineUpdateFlags updateFlags = new com.amap.api.maps.model.PolylineOptions.PolylineUpdateFlags();
    private final java.util.List<com.amap.api.maps.model.LatLng> points = new java.util.ArrayList();

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        LineCapType(int i) {
            this.type = i;
        }

        public static com.amap.api.maps.model.PolylineOptions.LineCapType valueOf(int i) {
            com.amap.api.maps.model.PolylineOptions.LineCapType[] values = values();
            return values[java.lang.Math.max(0, java.lang.Math.min(i, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i) {
            this.type = i;
        }

        public static com.amap.api.maps.model.PolylineOptions.LineJoinType valueOf(int i) {
            com.amap.api.maps.model.PolylineOptions.LineJoinType[] values = values();
            return values[java.lang.Math.max(0, java.lang.Math.min(i, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class PolylineUpdateFlags extends com.amap.api.maps.model.BaseOptions.BaseUpdateFlags {
        protected boolean isPointsUpdated = false;
        protected boolean isCustomIndexesUpdated = false;
        protected boolean isCustomTextureListUpdated = false;
        protected boolean isColorValuesUpdated = false;
        protected boolean footPrintBDUpdate = false;
        protected boolean eraseUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isCustomIndexesUpdated = false;
            this.isCustomTextureListUpdated = false;
            this.isColorValuesUpdated = false;
            this.footPrintBDUpdate = false;
            this.eraseUpdate = false;
        }
    }

    public PolylineOptions() {
        this.type = "PolylineOptions";
    }

    public final com.amap.api.maps.model.PolylineOptions aboveMaskLayer(boolean z) {
        this.isAboveMaskLayer = z;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions add(com.amap.api.maps.model.LatLng latLng) {
        if (latLng != null) {
            try {
                this.points.add(latLng);
                this.updateFlags.isPointsUpdated = true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions add(com.amap.api.maps.model.LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(java.util.Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions addAll(java.lang.Iterable<com.amap.api.maps.model.LatLng> iterable) {
        if (iterable != null) {
            try {
                java.util.Iterator<com.amap.api.maps.model.LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                this.updateFlags.isPointsUpdated = true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions color(int i) {
        this.color = i;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions colorValues(java.util.List<java.lang.Integer> list) {
        try {
            this.colorValues = list;
            this.jniColorValues = new int[list.size()];
            int i = 0;
            while (true) {
                int[] iArr = this.jniColorValues;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = list.get(i).intValue();
                i++;
            }
            this.updateFlags.isColorValuesUpdated = true;
        } catch (java.lang.Throwable unused) {
        }
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.PolylineOptions geodesic(boolean z) {
        this.isGeodesic = z;
        return this;
    }

    public final int getColor() {
        return this.color;
    }

    public final java.util.List<java.lang.Integer> getColorValues() {
        return this.colorValues;
    }

    public final com.amap.api.maps.model.BitmapDescriptor getCustomTexture() {
        return this.customTexture;
    }

    public final java.util.List<java.lang.Integer> getCustomTextureIndex() {
        return this.customIndexs;
    }

    public final java.util.List<com.amap.api.maps.model.BitmapDescriptor> getCustomTextureList() {
        return this.customTextureList;
    }

    public final int getDottedLineType() {
        return this.dottedLineType;
    }

    public final int getEraseColor() {
        return this.eraseColor;
    }

    public final com.amap.api.maps.model.BitmapDescriptor getEraseTexture() {
        return this.eraseTexture;
    }

    public final boolean getEraseVisible() {
        return this.eraseVisible;
    }

    public final float getFootPrintGap() {
        return this.footPrintGap;
    }

    public final com.amap.api.maps.model.BitmapDescriptor getFootPrintTexture() {
        return this.footPrintTexture;
    }

    public final com.amap.api.maps.model.PolylineOptions.LineCapType getLineCapType() {
        return this.lineCapType;
    }

    public final com.amap.api.maps.model.PolylineOptions.LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public final java.util.List<com.amap.api.maps.model.LatLng> getPoints() {
        return this.points;
    }

    public final float getPolylineShownRangeBegin() {
        return this.shownPolylineRangeBegin;
    }

    public final float getPolylineShownRangeEnd() {
        return this.shownPolylineRangeEnd;
    }

    public final float getShownRangeBegin() {
        return this.shownRangeBegin;
    }

    public final float getShownRangeEnd() {
        return this.shownRangeEnd;
    }

    public final float getShownRatio() {
        return this.shownRatio;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final com.amap.api.maps.model.PolylineOptions.PolylineUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isAboveMaskLayer() {
        return this.isAboveMaskLayer;
    }

    public final boolean isDottedLine() {
        return this.isDottedLine;
    }

    public final boolean isGeodesic() {
        return this.isGeodesic;
    }

    public final boolean isShowPolylineRangeEnable() {
        return this.showPolylineRangeEnable;
    }

    public final boolean isUseGradient() {
        return this.isGradient;
    }

    public final boolean isUseTexture() {
        return this.isUseTexture;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final com.amap.api.maps.model.PolylineOptions lineCapType(com.amap.api.maps.model.PolylineOptions.LineCapType lineCapType) {
        if (lineCapType != null) {
            this.lineCapType = lineCapType;
            this.nLineCapType = lineCapType.getTypeValue();
        }
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions lineJoinType(com.amap.api.maps.model.PolylineOptions.LineJoinType lineJoinType) {
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

    public final com.amap.api.maps.model.PolylineOptions setCustomTexture(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        this.customTexture = bitmapDescriptor;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setCustomTextureIndex(java.util.List<java.lang.Integer> list) {
        try {
            this.customIndexs = list;
            this.jniCustomIndexes = new int[list.size()];
            int i = 0;
            while (true) {
                int[] iArr = this.jniCustomIndexes;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = list.get(i).intValue();
                i++;
            }
            com.amap.api.maps.model.PolylineOptions.PolylineUpdateFlags polylineUpdateFlags = this.updateFlags;
            polylineUpdateFlags.isCustomIndexesUpdated = true;
            polylineUpdateFlags.isCustomTextureListUpdated = true;
        } catch (java.lang.Throwable unused) {
        }
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setCustomTextureList(java.util.List<com.amap.api.maps.model.BitmapDescriptor> list) {
        this.customTextureList = list;
        com.amap.api.maps.model.PolylineOptions.PolylineUpdateFlags polylineUpdateFlags = this.updateFlags;
        polylineUpdateFlags.isCustomTextureListUpdated = true;
        polylineUpdateFlags.isCustomIndexesUpdated = true;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setDottedLine(boolean z) {
        this.isDottedLine = z;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setDottedLineType(int i) {
        this.dottedLineType = i == 0 ? 0 : 1;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setEraseColor(boolean z, int i) {
        this.eraseVisible = z;
        this.eraseColor = i;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setEraseTexture(boolean z, com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        this.eraseVisible = z;
        this.eraseTexture = bitmapDescriptor;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setFootPrintGap(float f) {
        this.footPrintGap = f;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setFootPrintTexture(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        this.footPrintTexture = bitmapDescriptor;
        this.updateFlags.footPrintBDUpdate = true;
        return this;
    }

    public final void setPoints(java.util.List<com.amap.api.maps.model.LatLng> list) {
        java.util.List<com.amap.api.maps.model.LatLng> list2;
        if (list == null || (list2 = this.points) == list) {
            return;
        }
        try {
            list2.clear();
            this.points.addAll(list);
            this.updateFlags.isPointsUpdated = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final com.amap.api.maps.model.PolylineOptions setPolylineShowRange(float f, float f2) {
        this.shownPolylineRangeBegin = f;
        this.shownPolylineRangeEnd = f2;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setShownRange(float f, float f2) {
        this.shownRangeBegin = f;
        this.shownRangeEnd = f2;
        showPolylineRangeEnabled(true);
        setPolylineShowRange(f, f2);
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setShownRatio(float f) {
        this.shownRatio = f;
        setPolylineShowRange(0.0f, f);
        showPolylineRangeEnabled(true);
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions setUseTexture(boolean z) {
        this.isUseTexture = z;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions showPolylineRangeEnabled(boolean z) {
        this.showPolylineRangeEnable = z;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions transparency(float f) {
        this.transparency = f;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions useGradient(boolean z) {
        this.isGradient = z;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final com.amap.api.maps.model.PolylineOptions width(float f) {
        this.width = f;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.color);
        parcel.writeInt(this.dottedLineType);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.transparency);
        parcel.writeString(this.a);
        parcel.writeInt(this.lineCapType.getTypeValue());
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDottedLine, this.isGeodesic, this.isGradient, this.isAboveMaskLayer});
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = this.customTexture;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i);
        }
        java.util.List<com.amap.api.maps.model.BitmapDescriptor> list = this.customTextureList;
        if (list != null) {
            parcel.writeList(list);
        }
        java.util.List<java.lang.Integer> list2 = this.customIndexs;
        if (list2 != null) {
            parcel.writeList(list2);
        }
        java.util.List<java.lang.Integer> list3 = this.colorValues;
        if (list3 != null) {
            parcel.writeList(list3);
        }
        parcel.writeFloat(this.shownRatio);
    }

    public final com.amap.api.maps.model.PolylineOptions zIndex(float f) {
        if (this.zIndex != f) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }
}
