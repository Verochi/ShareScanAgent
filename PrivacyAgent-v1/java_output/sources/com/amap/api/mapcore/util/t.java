package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class t implements com.autonavi.base.ae.gmap.bean.TileSourceProvider {
    private int a = 256;
    private final com.amap.api.maps.model.TileOverlaySource b;
    private final com.amap.api.maps.model.TileOverlaySource c;

    public class a extends com.amap.api.mapcore.util.ct {
        private java.lang.String b;
        private java.lang.String g;

        public a(int i, int i2, int i3, java.lang.String str) {
            this.b = "";
            this.g = "";
            java.lang.String format = java.lang.String.format(str, java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            if (!format.contains("?")) {
                this.b = format + "?";
                return;
            }
            java.lang.String[] split = format.split("\\?");
            if (split.length > 1) {
                this.b = split[0] + "?";
                this.g = split[1];
            }
        }

        @Override // com.amap.api.mapcore.util.ct, com.amap.api.mapcore.util.hi
        public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
            return super.getRequestHead();
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getURL() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append(this.g);
            stringBuffer.append("&key=");
            stringBuffer.append(com.amap.api.mapcore.util.ev.f(com.amap.api.mapcore.util.p.a));
            stringBuffer.append("&channel=amapapi");
            return this.b + com.amap.api.mapcore.util.ct.a(stringBuffer.toString());
        }
    }

    public t(com.amap.api.maps.model.TileOverlaySource tileOverlaySource, com.amap.api.maps.model.TileOverlaySource tileOverlaySource2) {
        this.b = tileOverlaySource;
        this.c = tileOverlaySource2;
    }

    private com.amap.api.maps.model.Tile a(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq) {
        java.lang.String str = com.amap.api.maps.MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i = tileSourceReq.x;
            if (i > 0) {
                i /= 10;
            }
            int i2 = tileSourceReq.y;
            if (i2 > 0) {
                i2 /= 10;
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(str + tileSourceReq.zoom + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + i + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + i2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + tileSourceReq.x + "_" + tileSourceReq.y + ".png"));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            int i3 = this.a;
            com.amap.api.maps.model.Tile tile = new com.amap.api.maps.model.Tile(i3, i3, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (java.io.FileNotFoundException unused) {
            int i4 = tileSourceReq.x;
            int i5 = tileSourceReq.zoom;
            int i6 = i4 >> (i5 - 6);
            int i7 = tileSourceReq.y >> (i5 - 6);
            if (i6 >= 51 && i6 <= 53 && i7 >= 28 && i7 <= 31) {
                try {
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(new java.io.File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    int i8 = this.a;
                    com.amap.api.maps.model.Tile tile2 = new com.amap.api.maps.model.Tile(i8, i8, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return com.amap.api.maps.model.TileProvider.NO_TILE;
                }
            }
            return com.amap.api.maps.model.TileProvider.NO_TILE;
        } catch (java.io.IOException unused2) {
            return com.amap.api.maps.model.TileProvider.NO_TILE;
        }
    }

    private byte[] a(int i, int i2, int i3, java.lang.String str) {
        try {
            return new com.amap.api.mapcore.util.t.a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final void cancel(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final com.amap.api.maps.model.Tile getTile(int i, int i2, int i3) {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final com.amap.api.maps.model.Tile getTile(com.autonavi.base.ae.gmap.bean.TileSourceReq tileSourceReq) {
        if (tileSourceReq == null) {
            return com.amap.api.maps.model.TileProvider.NO_TILE;
        }
        com.amap.api.maps.model.Tile tile = com.amap.api.maps.model.TileProvider.NO_TILE;
        try {
            java.lang.String url = tileSourceReq.sourceType == this.c.getId() ? this.c.getUrl() : this.b.getUrl();
            if (url == null) {
                return tile;
            }
            com.amap.api.maps.model.Tile a2 = com.amap.api.maps.MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null ? a(tileSourceReq) : tile;
            if (a2 != tile) {
                return a2;
            }
            int i = this.a;
            return new com.amap.api.maps.model.Tile(i, i, a(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom, url), true);
        } catch (java.lang.Exception e) {
            com.amap.api.maps.model.Tile tile2 = com.amap.api.maps.model.TileProvider.NO_TILE;
            e.printStackTrace();
            return tile2;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.a;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.a;
    }
}
