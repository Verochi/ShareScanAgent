package com.autonavi.base.ae.gmap;

/* loaded from: classes12.dex */
public class TerrainOverlayProvider {
    private static final int TERRAIN_OVERLAY_SOURCE_BASE_ID = 1;
    private static final int TERRAIN_OVERLAY_SOURCE_HIGH_ID = 0;
    private com.autonavi.base.ae.gmap.bean.TileProviderInner tileProviderInner;

    public TerrainOverlayProvider(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer) {
        com.amap.api.maps.model.TileOverlaySource tileOverlaySource = new com.amap.api.maps.model.TileOverlaySource(0, com.amap.api.maps.model.TileOverlaySource.TILESOURCE_TYPE_IMAGE_DEM, "http://restsdk.amap.com/rest/lbs/dem/data?z=%d&x=%d&y=%d&type=2");
        tileOverlaySource.setMinZoom(3);
        tileOverlaySource.setMaxZoom(10);
        tileOverlaySource.setCacheEnabled(true);
        int i = com.amap.api.maps.model.TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE;
        com.amap.api.maps.model.TileOverlaySource tileOverlaySource2 = new com.amap.api.maps.model.TileOverlaySource(1, i, "http://mst01.is.autonavi.com/appmaptile?z=%d&x=%d&y=%d&lang=zh_cn&size=1&scale=1&style=6");
        tileOverlaySource2.setCacheEnabled(i != com.amap.api.maps.model.TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(tileOverlaySource);
        arrayList.add(tileOverlaySource2);
        com.autonavi.base.ae.gmap.bean.TileProviderInner tileProviderInner = new com.autonavi.base.ae.gmap.bean.TileProviderInner(new com.amap.api.mapcore.util.t(tileOverlaySource, tileOverlaySource2));
        this.tileProviderInner = tileProviderInner;
        tileProviderInner.init(iGlOverlayLayer, "TerrainTileOverlay");
        this.tileProviderInner.setTileSource(arrayList);
    }

    public java.util.List<com.amap.api.maps.model.BitmapDescriptor> getSkyBoxImages() {
        java.lang.String[] strArr = {"map_custom/skybox/right.png", "map_custom/skybox/left.png", "map_custom/skybox/front.png", "map_custom/skybox/back.png", "map_custom/skybox/top.png", "map_custom/skybox/bottom.png"};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add(com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset(strArr[i]));
        }
        return arrayList;
    }

    public com.autonavi.base.ae.gmap.bean.TileProviderInner getTileProvider() {
        return this.tileProviderInner;
    }
}
