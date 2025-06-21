package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class o implements com.amap.api.maps.interfaces.IGlOverlayLayer, com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener {
    com.autonavi.base.amap.api.mapcore.IAMapDelegate a;
    private android.content.Context d;
    private com.amap.api.mapcore.util.ca j;
    private int e = 0;
    private final java.lang.Object f = new java.lang.Object();
    private com.amap.api.maps.model.BitmapDescriptor k = null;
    private com.amap.api.maps.model.BitmapDescriptor l = null;
    private com.amap.api.maps.model.BitmapDescriptor m = null;
    private com.amap.api.maps.model.BitmapDescriptor n = null;
    private com.amap.api.maps.model.BitmapDescriptor o = null;
    private com.amap.api.maps.model.BitmapDescriptor p = null;
    private com.amap.api.maps.model.BitmapDescriptor q = null;
    private com.amap.api.maps.model.BitmapDescriptor r = null;
    boolean b = false;
    java.util.List<java.lang.String> c = new java.util.ArrayList();
    private final java.util.Map<java.lang.String, com.amap.api.maps.model.BaseOverlay> h = new java.util.HashMap();
    private java.util.ArrayList<android.util.Pair<com.amap.api.maps.model.BaseOverlay, com.amap.api.maps.model.BaseOptions>> i = new java.util.ArrayList<>();
    private com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer g = new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer();

    public o(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, android.content.Context context) {
        this.a = iAMapDelegate;
        this.d = context;
        this.j = new com.amap.api.mapcore.util.ca(iAMapDelegate);
    }

    private com.amap.api.maps.model.BitmapDescriptor a(android.view.View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof android.widget.RelativeLayout) && this.d != null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.d);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(com.amap.api.mapcore.util.dl.a(view));
    }

    private void a(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions) {
        try {
            this.g.createOverlay(str, baseOptions);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            new java.lang.StringBuilder("GlOverlayLayer addOverlay error:").append(th.getMessage());
        }
    }

    private void a(java.lang.String str, com.amap.api.maps.model.BaseOverlay baseOverlay, com.amap.api.maps.model.BaseOptions baseOptions) {
        a(str, baseOptions);
        synchronized (this.h) {
            this.h.put(str, baseOverlay);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsCircleContainPoint(com.amap.api.maps.model.CircleOptions circleOptions, com.amap.api.maps.model.LatLng latLng) {
        if (latLng != null && circleOptions != null) {
            try {
                synchronized (circleOptions) {
                    java.util.List<com.amap.api.maps.model.BaseHoleOptions> holeOptions = circleOptions.getHoleOptions();
                    if (holeOptions != null && holeOptions.size() > 0) {
                        java.util.Iterator<com.amap.api.maps.model.BaseHoleOptions> it = holeOptions.iterator();
                        while (it.hasNext()) {
                            if (com.amap.api.mapcore.util.dl.a(it.next(), latLng)) {
                                return false;
                            }
                        }
                    }
                    return circleOptions.getRadius() >= ((double) com.amap.api.maps.AMapUtils.calculateLineDistance(circleOptions.getCenter(), latLng));
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsPolygonContainsPoint(com.amap.api.maps.model.PolygonOptions polygonOptions, com.amap.api.maps.model.LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        try {
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> holeOptions = polygonOptions.getHoleOptions();
            if (holeOptions != null && holeOptions.size() > 0) {
                java.util.Iterator<com.amap.api.maps.model.BaseHoleOptions> it = holeOptions.iterator();
                while (it.hasNext()) {
                    if (com.amap.api.mapcore.util.dl.a(it.next(), latLng)) {
                        return false;
                    }
                }
            }
            return com.amap.api.mapcore.util.dl.a(latLng, polygonOptions.getPoints());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final com.amap.api.maps.model.BaseOverlay addOverlayObject(java.lang.String str, com.amap.api.maps.model.BaseOverlay baseOverlay, com.amap.api.maps.model.BaseOptions baseOptions) {
        a(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void changeOverlayIndex() {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean checkInBounds(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            java.lang.Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "checkInBounds", new java.lang.Object[]{str});
            if (nativeProperties instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) nativeProperties).booleanValue();
            }
        }
        return true;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void clear(java.lang.String... strArr) {
        try {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
            if (aMapNativeGlOverlayLayer != null && strArr != null) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.h) {
                if (strArr != null) {
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, com.amap.api.maps.model.BaseOverlay>> it = this.h.entrySet().iterator();
                    while (it.hasNext()) {
                        java.util.Map.Entry<java.lang.String, com.amap.api.maps.model.BaseOverlay> next = it.next();
                        int length = strArr.length;
                        boolean z = false;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                java.lang.String str = strArr[i];
                                if (str != null && str.equals(next.getKey())) {
                                    z = true;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                        if (!z) {
                            it.remove();
                        }
                    }
                } else {
                    this.h.clear();
                }
            }
            synchronized (this.i) {
                this.i.clear();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "GlOverlayLayer", "clear");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearTileCache() {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final java.lang.String createId(java.lang.String str) {
        java.lang.String str2;
        synchronized (this.f) {
            this.e++;
            str2 = str + this.e;
        }
        return str2;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void destroy() {
        try {
            if (this.g == null) {
                return;
            }
            synchronized (this.h) {
                this.h.clear();
            }
            synchronized (this.i) {
                this.i.clear();
            }
            this.g.clear("");
            this.g.destroy();
            this.g = null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "GlOverlayLayer", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized boolean draw(int i, int i2, boolean z) {
        boolean z2 = false;
        try {
            com.amap.api.mapcore.util.ca caVar = this.j;
            if (caVar != null) {
                caVar.a();
            }
        } finally {
            return z2;
        }
        if (this.a.getMapConfig() == null) {
            return false;
        }
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.render(i, i2, z);
        }
        z2 = true;
        return z2;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final com.amap.api.maps.model.BitmapDescriptor getBuildInImageData(int i) {
        try {
            switch (i) {
                case 0:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = this.k;
                    if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                        this.k = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(com.amap.api.mapcore.util.dl.a(this.d, "amap_sdk_lineTexture.png"));
                    }
                    return this.k;
                case 1:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor2 = this.n;
                    if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                        this.n = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(com.amap.api.mapcore.util.dl.a(this.d, "amap_sdk_lineTexture.png"));
                    }
                    return this.n;
                case 2:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor3 = this.m;
                    if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                        this.m = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(com.amap.api.mapcore.util.dl.a(this.d, "amap_sdk_lineDashTexture_circle.png"));
                    }
                    return this.m;
                case 3:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor4 = this.l;
                    if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                        this.l = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(com.amap.api.mapcore.util.dl.a(this.d, "amap_sdk_lineDashTexture_square.png"));
                    }
                    return this.l;
                case 4:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor5 = this.o;
                    if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                        this.o = com.amap.api.maps.model.BitmapDescriptorFactory.defaultMarker();
                    }
                    return this.o;
                case 5:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor6 = this.p;
                    if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                        this.p = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                    }
                    return this.p;
                case 6:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor7 = this.q;
                    if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                        this.q = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                    }
                    return this.q;
                case 7:
                    com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor8 = this.r;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.r = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.r;
                default:
                    return null;
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final int getCurrentParticleNum(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final com.amap.api.maps.model.BaseOverlay getHitBaseOverlay(android.view.MotionEvent motionEvent, int i) {
        if (this.a == null) {
            return null;
        }
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        this.a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(obtain.y, obtain.x);
        obtain.recycle();
        return getHitBaseOverlay(latLng, i);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized com.amap.api.maps.model.BaseOverlay getHitBaseOverlay(com.amap.api.maps.model.LatLng latLng, int i) {
        com.amap.api.maps.model.BaseOverlay baseOverlay;
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer == null) {
            return null;
        }
        java.lang.String contain = aMapNativeGlOverlayLayer.contain(latLng, i);
        if (android.text.TextUtils.isEmpty(contain)) {
            return null;
        }
        synchronized (this.h) {
            baseOverlay = this.h.get(contain);
        }
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized com.amap.api.maps.model.Polyline getHitOverlay(com.amap.api.maps.model.LatLng latLng, int i) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            java.lang.String contain = aMapNativeGlOverlayLayer.contain(latLng, i);
            if (android.text.TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.h) {
                com.amap.api.maps.model.BaseOverlay baseOverlay = this.h.get(contain);
                r1 = baseOverlay instanceof com.amap.api.maps.model.Polyline ? (com.amap.api.maps.model.Polyline) baseOverlay : null;
            }
        }
        return r1;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final com.amap.api.maps.model.BitmapDescriptor getInfoContents(java.lang.String str) {
        com.amap.api.mapcore.util.aj infoWindowDelegate;
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        com.amap.api.maps.model.BaseOverlay baseOverlay = this.h.get(str);
        if (baseOverlay instanceof com.amap.api.maps.model.BasePointOverlay) {
            return a(infoWindowDelegate.b((com.amap.api.maps.model.BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final com.amap.api.maps.model.BitmapDescriptor getInfoWindow(java.lang.String str) {
        com.amap.api.mapcore.util.aj infoWindowDelegate;
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        com.amap.api.maps.model.BaseOverlay baseOverlay = this.h.get(str);
        if (baseOverlay instanceof com.amap.api.maps.model.BasePointOverlay) {
            return a(infoWindowDelegate.a((com.amap.api.maps.model.BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final com.amap.api.maps.model.BitmapDescriptor getInfoWindowClick(java.lang.String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final long getInfoWindowUpdateOffsetTime(java.lang.String str) {
        com.amap.api.mapcore.util.aj infoWindowDelegate;
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0L;
        }
        com.amap.api.maps.model.BaseOverlay baseOverlay = this.h.get(str);
        if (baseOverlay instanceof com.amap.api.maps.model.BasePointOverlay) {
            return infoWindowDelegate.c((com.amap.api.maps.model.BasePointOverlay) baseOverlay);
        }
        return 0L;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final com.autonavi.base.amap.api.mapcore.IAMapDelegate getMap() {
        return this.a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final java.util.List<com.amap.api.maps.model.Marker> getMapScreenMarkers() {
        if (this.g == null) {
            return null;
        }
        this.c.clear();
        this.g.getNativeProperties("", "getMapScreenOverlays", new java.lang.Object[]{this.c});
        if (this.c.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : this.c) {
            if (str != null && str.contains("MARKER")) {
                arrayList.add((com.amap.api.maps.model.Marker) this.h.get(str));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getMarkerInfoWindowOffset(java.lang.String str, com.autonavi.base.amap.mapcore.FPoint fPoint) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            java.lang.Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "getMarkerInfoWindowOffset", null);
            if (nativeProperties instanceof android.graphics.Point) {
                android.graphics.Point point = (android.graphics.Point) nativeProperties;
                ((android.graphics.PointF) fPoint).x = point.x;
                ((android.graphics.PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final com.amap.api.maps.model.MultiPointItem getMultiPointItem(com.amap.api.maps.model.LatLng latLng) {
        java.util.List<com.amap.api.maps.model.MultiPointItem> items;
        try {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
            if (aMapNativeGlOverlayLayer == null) {
                return null;
            }
            java.lang.Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new com.amap.api.maps.model.LatLng[]{latLng});
            if (!(nativeProperties instanceof com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest)) {
                return null;
            }
            com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest multiPointItemHitTest = (com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest) nativeProperties;
            if (multiPointItemHitTest.index == -1) {
                return null;
            }
            com.amap.api.maps.model.BaseOverlay baseOverlay = this.h.get(multiPointItemHitTest.overlayName);
            if (!(baseOverlay instanceof com.amap.api.maps.model.MultiPointOverlay) || (items = ((com.amap.api.maps.model.MultiPointOverlay) baseOverlay).getItems()) == null) {
                return null;
            }
            int size = items.size();
            int i = multiPointItemHitTest.index;
            if (size > i) {
                return items.get(i);
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final java.lang.Object getNativeProperties(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final com.amap.api.maps.model.LatLng getNearestLatLng(com.amap.api.maps.model.PolylineOptions polylineOptions, com.amap.api.maps.model.LatLng latLng) {
        java.util.List<com.amap.api.maps.model.LatLng> points;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            int i = 0;
            float f = 0.0f;
            for (int i2 = 0; i2 < points.size(); i2++) {
                try {
                    if (i2 == 0) {
                        f = com.amap.api.maps.AMapUtils.calculateLineDistance(latLng, points.get(i2));
                    } else {
                        float calculateLineDistance = com.amap.api.maps.AMapUtils.calculateLineDistance(latLng, points.get(i2));
                        if (f > calculateLineDistance) {
                            i = i2;
                            f = calculateLineDistance;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getOverlayScreenPos(java.lang.String str, com.autonavi.base.amap.mapcore.FPoint fPoint) {
        if (this.h.get(str) instanceof com.amap.api.maps.model.BasePointOverlay) {
            java.lang.Object nativeProperties = this.g.getNativeProperties(str, "getMarkerScreenPos", null);
            if (nativeProperties instanceof android.graphics.Point) {
                android.graphics.Point point = (android.graphics.Point) nativeProperties;
                ((android.graphics.PointF) fPoint).x = point.x;
                ((android.graphics.PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final com.amap.api.maps.model.BitmapDescriptor getOverturnInfoWindow(java.lang.String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final com.amap.api.maps.model.BitmapDescriptor getOverturnInfoWindowClick(java.lang.String str) {
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void hideInfoWindow(java.lang.String str) {
        if (this.g != null) {
            this.a.hideInfoWindow();
            this.g.getNativeProperties(str, "setInfoWindowShown", new java.lang.Object[]{java.lang.Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void onCreateAMapInstance() {
        if (this.g == null) {
            this.g = new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer();
        }
        this.g.createNative(this.a.getGLMapEngine().getNativeInstance());
        this.g.setNativeFunCallListener(this);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onRedrawInfowindow() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onSetRunLowFrame(boolean z) {
        setRunLowFrame(z);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(java.lang.String str) {
        boolean z;
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z = true;
        } else {
            z = false;
        }
        synchronized (this.h) {
            this.h.remove(str);
        }
        return z;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(java.lang.String str, boolean z) {
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void set2Top(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setFlingState(boolean z) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new java.lang.Object[]{java.lang.Boolean.valueOf(z)});
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setRunLowFrame(boolean z) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void showInfoWindow(java.lang.String str) {
        java.util.Map<java.lang.String, com.amap.api.maps.model.BaseOverlay> map;
        if (this.g == null || (map = this.h) == null) {
            return;
        }
        try {
            this.a.showInfoWindow(map.get(str));
            setRunLowFrame(false);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void updateOption(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions) {
        try {
            if (this.g == null) {
                return;
            }
            setRunLowFrame(false);
            this.g.updateOptions(str, baseOptions);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }
}
