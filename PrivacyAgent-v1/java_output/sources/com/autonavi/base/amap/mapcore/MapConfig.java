package com.autonavi.base.amap.mapcore;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class MapConfig implements com.autonavi.amap.mapcore.interfaces.IMapConfig, java.lang.Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private java.lang.String customTextureResourcePath;
    private boolean isSetLimitZoomLevel;
    com.autonavi.base.amap.mapcore.MapConfig lastMapconfig;
    private com.autonavi.amap.mapcore.IPoint[] limitIPoints;
    private com.amap.api.maps.model.LatLngBounds limitLatLngBounds;
    private java.lang.String mCustomStyleID;
    private java.lang.String mCustomStylePath;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int mapHeight;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mapPerPixelUnitLength;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int mapWidth;
    private float skyHeight;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    private com.autonavi.base.amap.mapcore.FPoint[] mapRect = null;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.autonavi.base.amap.mapcore.Rectangle geoRectangle = new com.autonavi.base.amap.mapcore.Rectangle();
    private boolean isIndoorEnable = false;
    private boolean isBuildingEnable = true;
    private boolean isMapTextEnable = true;
    private boolean isTrafficEnabled = false;
    private boolean isCustomStyleEnabled = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private double sX = 2.21010267E8d;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private double sY = 1.01697799E8d;
    private com.autonavi.amap.mapcore.DPoint mapGeoCenter = new com.autonavi.amap.mapcore.DPoint(this.sX, this.sY);

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float sZ = 10.0f;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float sC = 0.0f;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float sR = 0.0f;
    private boolean isCenterChanged = false;
    private boolean isZoomChanged = false;
    private boolean isTiltChanged = false;
    private boolean isBearingChanged = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private int mMapStyleMode = 0;
    private int mMapStyleTime = 0;
    private int mMapStyleState = 0;
    private int anchorX = 0;
    private java.lang.String mMapLanguage = "zh_cn";
    private boolean isHideLogoEnable = false;
    private boolean isWorldMapEnable = false;
    private boolean isTouchPoiEnable = true;
    private int abroadState = 1;
    private boolean isAbroadEnable = false;
    private boolean isTerrainEnable = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    float[] viewMatrix = new float[16];

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    float[] projectionMatrix = new float[16];

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    float[] mvpMatrix = new float[16];

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int[] tilsIDs = new int[100];
    private boolean mapEnable = true;
    private int anchorY = 0;
    private boolean isProFunctionAuthEnable = true;
    private boolean isUseProFunction = false;
    private int customBackgroundColor = -1;
    private float mapZoomScale = 1.0f;
    private java.util.concurrent.atomic.AtomicInteger changedCounter = new java.util.concurrent.atomic.AtomicInteger(0);
    private volatile double changeRatio = 1.0d;
    private volatile double changeGridRatio = 1.0d;
    private int gridX = 0;
    private int gridY = 0;

    public MapConfig(boolean z) {
        this.lastMapconfig = null;
        if (z) {
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = new com.autonavi.base.amap.mapcore.MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(0.0d);
            this.lastMapconfig.setSY(0.0d);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = java.lang.Math.abs(this.sX - sx) + java.lang.Math.abs(this.sY - sy);
        this.changeRatio = this.changeRatio == 0.0d ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio = this.changeRatio * (sz == this.sZ ? 1.0d : java.lang.Math.abs(sz - r11));
        float f = this.sC;
        float abs = sc == f ? 1.0f : java.lang.Math.abs(sc - f);
        float f2 = this.sR;
        float abs2 = sr != f2 ? java.lang.Math.abs(sr - f2) : 1.0f;
        double d = abs;
        this.changeRatio *= d;
        double d2 = abs2;
        this.changeRatio *= d2;
        this.changeGridRatio = java.lang.Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY);
        this.changeGridRatio = this.changeGridRatio != 0.0d ? this.changeGridRatio * 2.0d : 1.0d;
        this.changeGridRatio *= d;
        this.changeGridRatio *= d2;
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAbroadState() {
        return this.abroadState;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorX() {
        return this.anchorX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public java.lang.String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public java.lang.String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public java.lang.String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public com.autonavi.base.amap.mapcore.Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    public int getGridX() {
        return this.gridX;
    }

    public int getGridY() {
        return this.gridY;
    }

    public com.autonavi.amap.mapcore.IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public com.amap.api.maps.model.LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public com.autonavi.amap.mapcore.DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapHeight() {
        return this.mapHeight;
    }

    public java.lang.String getMapLanguage() {
        return this.mMapLanguage;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleState() {
        return this.mMapStyleState;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapWidth() {
        return this.mapWidth;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapStateChange() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        boolean z = false;
        if (mapConfig != null) {
            double sx = mapConfig.getSX();
            double sy = this.lastMapconfig.getSY();
            float sz = this.lastMapconfig.getSZ();
            float sc = this.lastMapconfig.getSC();
            float sr = this.lastMapconfig.getSR();
            double d = this.sX;
            boolean z2 = sx != d;
            this.isCenterChanged = z2;
            double d2 = this.sY;
            if (sy != d2) {
                z2 = true;
            }
            this.isCenterChanged = z2;
            float f = this.sZ;
            boolean z3 = sz != f;
            this.isZoomChanged = z3;
            if (z3) {
                float f2 = this.minZoomLevel;
                if (sz > f2 && f > f2) {
                    float f3 = this.maxZoomLevel;
                    if (sz < f3 && f < f3) {
                        this.isNeedUpdateZoomControllerState = false;
                    }
                }
                this.isNeedUpdateZoomControllerState = true;
            }
            boolean z4 = sc != this.sC;
            this.isTiltChanged = z4;
            boolean z5 = sr != this.sR;
            this.isBearingChanged = z5;
            boolean z6 = z2 || z3 || z4 || z5 || this.isNeedUpdateMapRectNextFrame;
            if (z6) {
                this.isNeedUpdateMapRectNextFrame = false;
                int i = (20 - ((int) f)) + 8;
                setGridXY(((int) d) >> i, ((int) d2) >> i);
                changeRatio();
            }
            z = z6;
        }
        if (this.sC < 45.0f || this.skyHeight != 0.0f) {
            return z;
        }
        return true;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadEnable(boolean z) {
        this.isAbroadEnable = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int i) {
        this.abroadState = i;
    }

    public void setAnchorX(int i) {
        this.anchorX = i;
    }

    public void setAnchorY(int i) {
        this.anchorY = i;
    }

    public void setBuildingEnable(boolean z) {
        this.isBuildingEnable = z;
    }

    public void setCustomBackgroundColor(int i) {
        this.customBackgroundColor = i;
    }

    public void setCustomStyleEnable(boolean z) {
        this.isCustomStyleEnabled = z;
    }

    public void setCustomStyleID(java.lang.String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(java.lang.String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(java.lang.String str) {
        this.customTextureResourcePath = str;
    }

    public void setGridXY(int i, int i2) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i;
        this.gridY = i2;
    }

    public void setHideLogoEnble(boolean z) {
        this.isHideLogoEnable = z;
    }

    public void setIndoorEnable(boolean z) {
        this.isIndoorEnable = z;
    }

    public void setLimitIPoints(com.autonavi.amap.mapcore.IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapEnable(boolean z) {
        this.mapEnable = z;
    }

    public void setMapHeight(int i) {
        this.mapHeight = i;
    }

    public void setMapLanguage(java.lang.String str) {
        this.mMapLanguage = str;
    }

    public void setMapStyleMode(int i) {
        this.mMapStyleMode = i;
    }

    public void setMapStyleState(int i) {
        this.mMapStyleState = i;
    }

    public void setMapStyleTime(int i) {
        this.mMapStyleTime = i;
    }

    public void setMapTextEnable(boolean z) {
        this.isMapTextEnable = z;
    }

    public void setMapWidth(int i) {
        this.mapWidth = i;
    }

    public void setMapZoomScale(float f) {
        this.mapZoomScale = f;
    }

    public void setMaxZoomLevel(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f < getMinZoomLevel()) {
            f = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f;
    }

    public void setMinZoomLevel(float f) {
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f > getMaxZoomLevel()) {
            f = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f;
    }

    public void setProFunctionAuthEnable(boolean z) {
        this.isProFunctionAuthEnable = z;
    }

    public void setSC(float f) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f;
    }

    public void setSR(float f) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f;
    }

    public void setSX(double d) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = d;
        this.mapGeoCenter.x = d;
    }

    public void setSY(double d) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = d;
        this.mapGeoCenter.x = d;
    }

    public void setSZ(float f) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f;
    }

    public void setSkyHeight(float f) {
        this.skyHeight = f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean z) {
        this.isTerrainEnable = z;
    }

    public void setTouchPoiEnable(boolean z) {
        this.isTouchPoiEnable = z;
    }

    public void setTrafficEnabled(boolean z) {
        this.isTrafficEnabled = z;
    }

    public void setUseProFunction(boolean z) {
        this.isUseProFunction = z;
    }

    public void setWorldMapEnable(boolean z) {
        this.isWorldMapEnable = z;
    }

    public java.lang.String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        android.opengl.Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z) {
        this.isNeedUpdateMapRectNextFrame = z;
    }
}
