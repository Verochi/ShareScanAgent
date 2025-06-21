package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ca {
    private final com.autonavi.base.amap.api.mapcore.IAMapDelegate a;
    private com.amap.api.maps.model.TileOverlay b;
    private com.amap.api.maps.model.TileOverlay c;
    private boolean d = false;
    private boolean e = false;

    public ca(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.a = iAMapDelegate;
    }

    private void b() {
        if (this.b == null) {
            com.amap.api.maps.model.TileOverlayOptions tileProvider = new com.amap.api.maps.model.TileOverlayOptions().tileProvider(new com.amap.api.mapcore.util.cs(this.a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.d);
            try {
                this.b = this.a.addTileOverlay(tileProvider);
                this.c = this.a.addTileOverlay(tileProvider);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void c() {
        boolean e = e();
        if (e) {
            b();
        }
        if (this.d != e) {
            this.d = e;
            com.amap.api.maps.model.TileOverlay tileOverlay = this.b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(e);
            }
        }
    }

    private void d() {
        boolean f = f();
        if (f) {
            b();
        }
        if (this.e != f) {
            this.e = f;
            com.amap.api.maps.model.TileOverlay tileOverlay = this.c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(f);
            }
        }
    }

    private boolean e() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
    }

    private static boolean f() {
        return com.amap.api.maps.MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }
}
