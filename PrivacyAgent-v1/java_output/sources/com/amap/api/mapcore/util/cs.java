package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cs implements com.amap.api.maps.model.TileProvider {
    private com.autonavi.base.amap.mapcore.MapConfig c;
    private final int a = 256;
    private final int b = 256;
    private final boolean d = false;

    public class a extends com.amap.api.mapcore.util.ct {
        java.util.Random a = new java.util.Random();
        private int g;
        private int h;
        private int i;
        private java.lang.String j;
        private java.lang.String k;

        public a(int i, int i2, int i3, java.lang.String str) {
            this.k = "";
            this.g = i;
            this.h = i2;
            this.i = i3;
            this.j = str;
            this.k = c();
        }

        private java.lang.String c() {
            if (com.amap.api.mapcore.util.de.a(this.g, this.h, this.i) || this.i < 6) {
                return java.lang.String.format(java.util.Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", java.lang.Integer.valueOf((this.a.nextInt(100000) % 4) + 1));
            }
            if (com.amap.api.maps.MapsInitializer.isLoadWorldGridMap()) {
                return "http://restsdk.amap.com/v4/gridmap?";
            }
            return null;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getURL() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(com.amap.api.mapcore.util.ev.f(com.amap.api.mapcore.util.p.a));
            stringBuffer.append("&channel=amapapi");
            if (com.amap.api.mapcore.util.de.a(this.g, this.h, this.i) || this.i < 6) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.i);
                stringBuffer.append("&x=");
                stringBuffer.append(this.g);
                stringBuffer.append("&y=");
                stringBuffer.append(this.h);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            } else if (com.amap.api.maps.MapsInitializer.isLoadWorldGridMap()) {
                stringBuffer.append("&x=");
                stringBuffer.append(this.g);
                stringBuffer.append("&y=");
                stringBuffer.append(this.h);
                stringBuffer.append("&z=");
                stringBuffer.append(this.i);
                stringBuffer.append("&ds=0");
                stringBuffer.append("&dpitype=webrd");
                stringBuffer.append("&lang=");
                stringBuffer.append(this.j);
                stringBuffer.append("&scale=2");
            }
            return this.k + com.amap.api.mapcore.util.ct.a(stringBuffer.toString());
        }
    }

    public cs(com.autonavi.base.amap.mapcore.MapConfig mapConfig) {
        this.c = mapConfig;
    }

    private byte[] a(int i, int i2, int i3, java.lang.String str) throws java.io.IOException {
        try {
            return new com.amap.api.mapcore.util.cs.a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final com.amap.api.maps.model.Tile getTile(int i, int i2, int i3) {
        try {
            if (!this.d) {
                if (this.c.getMapLanguage().equals("zh_cn")) {
                    if (!com.amap.api.maps.MapsInitializer.isLoadWorldGridMap()) {
                        return com.amap.api.maps.model.TileProvider.NO_TILE;
                    }
                    if (i3 < 6 || com.amap.api.mapcore.util.de.a(i, i2, i3)) {
                        return com.amap.api.maps.model.TileProvider.NO_TILE;
                    }
                } else if (!com.amap.api.maps.MapsInitializer.isLoadWorldGridMap() && i3 >= 6 && !com.amap.api.mapcore.util.de.a(i, i2, i3)) {
                    return com.amap.api.maps.model.TileProvider.NO_TILE;
                }
            }
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.c;
            byte[] a2 = a(i, i2, i3, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            return a2 == null ? com.amap.api.maps.model.TileProvider.NO_TILE : com.amap.api.maps.model.Tile.obtain(this.a, this.b, a2);
        } catch (java.io.IOException unused) {
            return com.amap.api.maps.model.TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.a;
    }
}
