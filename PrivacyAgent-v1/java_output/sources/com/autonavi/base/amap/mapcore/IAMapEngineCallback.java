package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i, byte[] bArr);

    void cancelRequireMapData(java.lang.Object obj);

    int generateRequestId();

    java.util.List<com.amap.api.maps.model.BitmapDescriptor> getSkyBoxImages();

    com.autonavi.base.ae.gmap.bean.InitStorageParam getStorageInitParam();

    com.autonavi.base.ae.gmap.bean.TileProviderInner getTerrainTileProvider();

    void onMapRender(int i, int i2);

    void reloadMapResource(int i, java.lang.String str, int i2);

    byte[] requireCharBitmap(int i, int i2, int i3);

    byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3);

    @java.lang.Deprecated
    void requireMapData(int i, byte[] bArr);

    int requireMapDataAsyn(int i, byte[] bArr);

    void requireMapRender(int i, int i2, int i3);

    byte[] requireMapResource(int i, java.lang.String str);
}
