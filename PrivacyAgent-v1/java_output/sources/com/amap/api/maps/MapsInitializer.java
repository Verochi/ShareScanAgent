package com.amap.api.maps;

/* loaded from: classes12.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static java.lang.String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    private static boolean closeTileOverlay = false;
    private static com.amap.api.maps.ExceptionLogger exceptionLogger = null;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = true;
    private static int mProtocol = 1;
    private static java.lang.String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static java.lang.String mWorldVectorOfflineMapStyleFilePath = "";
    public static java.lang.String sdcardDir = "";

    public static void disableCachedMapDataUpdate(boolean z) {
    }

    public static java.lang.String getDeviceId(android.content.Context context) {
        return com.amap.api.mapcore.util.ez.t(context);
    }

    public static com.amap.api.maps.ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static java.lang.String getVersion() {
        return "9.1.0";
    }

    public static java.lang.String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static java.lang.String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initialize(android.content.Context context) throws android.os.RemoteException {
        if (context != null) {
            com.amap.api.mapcore.util.p.a = context.getApplicationContext();
        }
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldGridMap(boolean z) {
        isLoadWorldGridMap = z;
    }

    public static void loadWorldVectorMap(boolean z) {
        isloadWorldVectorMap = z;
    }

    public static void setApiKey(java.lang.String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        com.amap.api.mapcore.util.ew.a(com.amap.api.mapcore.util.p.a, str);
    }

    public static void setBuildingHeight(int i) {
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        isNeedDownloadCoordinateConvertLibrary = z;
    }

    public static void setExceptionLogger(com.amap.api.maps.ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.amap.api.mapcore.util.hb.a = -1;
            com.amap.api.mapcore.util.hb.b = "";
        } else {
            com.amap.api.mapcore.util.hb.a = 1;
            com.amap.api.mapcore.util.hb.b = str;
        }
    }

    public static void setNetWorkEnable(boolean z) {
        isNetWorkEnable = z;
    }

    public static void setPolyline2Enable(boolean z) {
    }

    public static void setProtocol(int i) {
        mProtocol = i;
    }

    public static void setSupportRecycleView(boolean z) {
        isSupportRecycleView = z;
    }

    public static void setTerrainEnable(boolean z) {
        isTerrainEnable = z;
    }

    public static void setTextureDestroyedRender(boolean z) {
        isTextureDestroyedRender = z;
    }

    public static void setTextureSizeChangedInvoked(boolean z) {
        isTextureSizeChangedInvoked = z;
    }

    public static void setTextureViewDestorySync(boolean z) {
        isTextureViewDestorySync = z;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(java.lang.String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(java.lang.String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public static synchronized void updatePrivacyAgree(android.content.Context context, boolean z) {
        synchronized (com.amap.api.maps.MapsInitializer.class) {
            com.amap.api.mapcore.util.fe.a(context, z, com.amap.api.mapcore.util.dl.a());
        }
    }

    public static synchronized void updatePrivacyShow(android.content.Context context, boolean z, boolean z2) {
        synchronized (com.amap.api.maps.MapsInitializer.class) {
            com.amap.api.mapcore.util.fe.a(context, z, z2, com.amap.api.mapcore.util.dl.a());
        }
    }
}
