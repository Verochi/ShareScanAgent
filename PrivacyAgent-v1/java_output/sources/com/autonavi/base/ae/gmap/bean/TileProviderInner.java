package com.autonavi.base.ae.gmap.bean;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class TileProviderInner {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.util.List<com.amap.api.maps.model.TileOverlaySource> mTileSource;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.lang.String overlayName;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ij> reqTaskHandleHashMap = new java.util.HashMap<>();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final com.amap.api.maps.model.TileProvider tileProvider;

    /* renamed from: com.autonavi.base.ae.gmap.bean.TileProviderInner$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ java.lang.String val$key;
        final /* synthetic */ com.autonavi.base.ae.gmap.bean.TileSourceReq val$req;
        final /* synthetic */ com.autonavi.base.ae.gmap.bean.TileReqTaskHandle val$reqTask;

        public AnonymousClass1(java.lang.String str, com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle tileReqTaskHandle) {
            this.val$key = str;
            this.val$req = tileSourceReq;
            this.val$reqTask = tileReqTaskHandle;
        }

        @Override // com.amap.api.mapcore.util.ij
        public void runTask() {
            try {
                synchronized (com.autonavi.base.ae.gmap.bean.TileProviderInner.this.reqTaskHandleHashMap) {
                    if (com.autonavi.base.ae.gmap.bean.TileProviderInner.this.reqTaskHandleHashMap.containsKey(this.val$key)) {
                        if (com.autonavi.base.ae.gmap.bean.TileProviderInner.this.tileProvider != null) {
                            com.amap.api.maps.model.Tile tile = com.amap.api.maps.model.TileProvider.NO_TILE;
                            try {
                                if (com.autonavi.base.ae.gmap.bean.TileProviderInner.this.tileProvider instanceof com.autonavi.base.ae.gmap.bean.TileSourceProvider) {
                                    tile = ((com.autonavi.base.ae.gmap.bean.TileSourceProvider) com.autonavi.base.ae.gmap.bean.TileProviderInner.this.tileProvider).getTile(this.val$req);
                                } else {
                                    com.amap.api.maps.model.TileProvider tileProvider = com.autonavi.base.ae.gmap.bean.TileProviderInner.this.tileProvider;
                                    com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq = this.val$req;
                                    tile = tileProvider.getTile(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom);
                                }
                            } catch (java.lang.Throwable unused) {
                            }
                            com.autonavi.base.ae.gmap.bean.TileProviderInner.this.finishDownload(tile, this.val$reqTask, this.val$key);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.autonavi.base.ae.gmap.bean.TileProviderInner.this.finishDownload(com.amap.api.maps.model.TileProvider.NO_TILE, this.val$reqTask, this.val$key);
                th.printStackTrace();
            }
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public TileProviderInner(com.amap.api.maps.model.TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.lang.Object callNativeFunction(java.lang.String str, java.lang.Object[] objArr) {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private java.lang.String createKey(int i, int i2, int i3, long j) {
        return i + " " + i2 + " " + i3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload(com.amap.api.maps.model.Tile tile, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle tileReqTaskHandle, java.lang.String str) {
        boolean z;
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(str)) {
                if (this.reqTaskHandleHashMap.containsKey(str)) {
                    this.reqTaskHandleHashMap.remove(str);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    tileReqTaskHandle.finish(tile);
                    callNativeFunction("finishTileReqTask", new java.lang.Object[]{tileReqTaskHandle});
                }
            }
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void cancelTile(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle tileReqTaskHandle) {
        java.lang.String createKey = createKey(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                com.amap.api.mapcore.util.ij ijVar = this.reqTaskHandleHashMap.get(createKey);
                if (ijVar != null) {
                    com.amap.api.mapcore.util.dj.a();
                    com.amap.api.mapcore.util.dj.b(ijVar);
                }
                tileReqTaskHandle.status = 1;
                finishDownload(com.amap.api.maps.model.TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                try {
                    com.amap.api.maps.model.TileProvider tileProvider = this.tileProvider;
                    if (tileProvider instanceof com.autonavi.base.ae.gmap.bean.TileSourceProvider) {
                        ((com.autonavi.base.ae.gmap.bean.TileSourceProvider) tileProvider).cancel(tileSourceReq);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void getTile(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle tileReqTaskHandle) {
        java.lang.String createKey = createKey(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        com.autonavi.base.ae.gmap.bean.TileProviderInner.AnonymousClass1 anonymousClass1 = new com.autonavi.base.ae.gmap.bean.TileProviderInner.AnonymousClass1(createKey, tileSourceReq, tileReqTaskHandle);
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                return;
            }
            this.reqTaskHandleHashMap.put(createKey, anonymousClass1);
            com.amap.api.mapcore.util.dj.a().a(anonymousClass1);
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public int getTileHeight() {
        com.amap.api.maps.model.TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileHeight();
        }
        return 0;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public int getTileWidth() {
        com.amap.api.maps.model.TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileWidth();
        }
        return 0;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public void init(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, java.lang.String str) {
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(java.util.List<com.amap.api.maps.model.TileOverlaySource> list) {
        this.mTileSource = list;
    }
}
