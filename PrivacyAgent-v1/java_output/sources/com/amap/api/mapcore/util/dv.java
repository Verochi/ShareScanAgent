package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dv extends android.view.ViewGroup implements com.amap.api.mapcore.util.dw {
    com.amap.api.mapcore.util.dx a;
    com.amap.api.mapcore.util.aj b;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate c;
    private com.amap.api.maps.interfaces.IGlOverlayLayer d;
    private android.content.Context e;
    private com.amap.api.mapcore.util.dz f;
    private com.amap.api.mapcore.util.du g;
    private com.amap.api.mapcore.util.ds h;
    private com.amap.api.mapcore.util.dy i;
    private com.amap.api.mapcore.util.dr j;
    private com.amap.api.mapcore.util.dt k;
    private com.amap.api.mapcore.util.ea l;
    private android.view.View m;
    private com.amap.api.maps.model.BasePointOverlay n;
    private android.graphics.drawable.Drawable o;
    private boolean p;
    private android.view.View q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f123s;
    private boolean t;

    /* renamed from: com.amap.api.mapcore.util.dv$1, reason: invalid class name */
    public class AnonymousClass1 implements com.autonavi.base.ae.gmap.listener.AMapWidgetListener {

        /* renamed from: com.amap.api.mapcore.util.dv$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01211 implements java.lang.Runnable {
            public RunnableC01211() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.dv.this.i.b();
            }
        }

        /* renamed from: com.amap.api.mapcore.util.dv$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.dv.this.h.b();
            }
        }

        /* renamed from: com.amap.api.mapcore.util.dv$1$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ float a;

            public AnonymousClass3(float f) {
                this.a = f;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.dv.this.l.a(this.a);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateCompassView() {
            if (com.amap.api.mapcore.util.dv.this.h == null) {
                return;
            }
            com.amap.api.mapcore.util.dv.this.h.post(new com.amap.api.mapcore.util.dv.AnonymousClass1.AnonymousClass2());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateScaleView() {
            if (com.amap.api.mapcore.util.dv.this.i == null) {
                return;
            }
            com.amap.api.mapcore.util.dv.this.i.post(new com.amap.api.mapcore.util.dv.AnonymousClass1.RunnableC01211());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateZoomController(float f) {
            if (com.amap.api.mapcore.util.dv.this.l == null) {
                return;
            }
            com.amap.api.mapcore.util.dv.this.l.post(new com.amap.api.mapcore.util.dv.AnonymousClass1.AnonymousClass3(f));
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void setFrontViewVisibility(boolean z) {
        }
    }

    /* renamed from: com.amap.api.mapcore.util.dv$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.mapcore.util.dv.this.m != null) {
                com.amap.api.mapcore.util.dv.this.m.clearFocus();
                com.amap.api.mapcore.util.dv dvVar = com.amap.api.mapcore.util.dv.this;
                dvVar.removeView(dvVar.m);
                com.amap.api.mapcore.util.dl.a(com.amap.api.mapcore.util.dv.this.m.getBackground());
                com.amap.api.mapcore.util.dl.a(com.amap.api.mapcore.util.dv.this.o);
                com.amap.api.mapcore.util.dv.f(com.amap.api.mapcore.util.dv.this);
            }
        }
    }

    public static class a extends android.view.ViewGroup.LayoutParams {
        public com.autonavi.base.amap.mapcore.FPoint a;
        public boolean b;
        public int c;
        public int d;
        public int e;

        public a(int i, int i2, float f, float f2, int i3, int i4, int i5) {
            super(i, i2);
            com.autonavi.base.amap.mapcore.FPoint fPoint = new com.autonavi.base.amap.mapcore.FPoint();
            this.a = fPoint;
            this.b = false;
            ((android.graphics.PointF) fPoint).x = f;
            ((android.graphics.PointF) fPoint).y = f2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public a(com.autonavi.base.amap.mapcore.FPoint fPoint, int i) {
            this(-2, -2, ((android.graphics.PointF) fPoint).x, ((android.graphics.PointF) fPoint).y, 0, 0, i);
        }
    }

    public dv(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.o = null;
        int i = 1;
        this.p = true;
        this.f123s = true;
        this.t = true;
        try {
            this.d = iGlOverlayLayer;
            this.c = iAMapDelegate;
            this.e = context;
            this.a = new com.amap.api.mapcore.util.dx();
            this.j = new com.amap.api.mapcore.util.dr(context);
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            if (this.c.getGLMapView() != null) {
                addView(this.c.getGLMapView(), 0, layoutParams);
            } else {
                i = 0;
            }
            addView(this.j, i, layoutParams);
            if (this.f123s) {
                return;
            }
            a(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    private android.view.View a(com.amap.api.maps.model.BasePointOverlay basePointOverlay) throws android.os.RemoteException {
        android.view.View view;
        android.view.View view2;
        android.view.View view3 = null;
        if (basePointOverlay instanceof com.amap.api.maps.model.Marker) {
            try {
                if (this.o == null) {
                    this.o = com.amap.api.mapcore.util.da.a(this.e, "infowindow_bg.9.png");
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.r) {
                    view = this.b.a(basePointOverlay);
                    if (view == null) {
                        try {
                            view = this.b.b(basePointOverlay);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            view3 = view;
                            com.amap.api.mapcore.util.gd.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.q = view;
                    this.r = false;
                } else {
                    view = this.q;
                }
                if (view != null) {
                    view3 = view;
                } else {
                    if (!this.b.a()) {
                        return null;
                    }
                    view3 = this.b.a(basePointOverlay);
                }
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.o);
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.o == null) {
                    this.o = com.amap.api.mapcore.util.da.a(this.e, "infowindow_bg.9.png");
                }
            } catch (java.lang.Throwable th4) {
                com.amap.api.mapcore.util.gd.c(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                if (this.r) {
                    view2 = this.b.a(basePointOverlay);
                    if (view2 == null) {
                        try {
                            view2 = this.b.b(basePointOverlay);
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            view3 = view2;
                            com.amap.api.mapcore.util.gd.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.q = view2;
                    this.r = false;
                } else {
                    view2 = this.q;
                }
                if (view2 != null) {
                    view3 = view2;
                } else {
                    if (!this.b.a()) {
                        return null;
                    }
                    view3 = this.b.a(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view3.setBackground(this.o);
                }
                return view3;
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        }
        return view3;
    }

    private void a(android.content.Context context) {
        com.amap.api.mapcore.util.dz dzVar = new com.amap.api.mapcore.util.dz(context);
        this.f = dzVar;
        dzVar.c(this.t);
        this.i = new com.amap.api.mapcore.util.dy(context, this.c);
        this.k = new com.amap.api.mapcore.util.dt(context);
        this.l = new com.amap.api.mapcore.util.ea(context, this.c);
        this.g = new com.amap.api.mapcore.util.du(context, this.c);
        this.h = new com.amap.api.mapcore.util.ds(context, this.c);
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        addView(this.f, layoutParams);
        addView(this.i, layoutParams);
        addView(this.k, new android.view.ViewGroup.LayoutParams(-2, -2));
        addView(this.l, new com.amap.api.mapcore.util.dv.a(new com.autonavi.base.amap.mapcore.FPoint(0.0f, 0.0f), 83));
        addView(this.g, new com.amap.api.mapcore.util.dv.a(com.autonavi.base.amap.mapcore.FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.h, new com.amap.api.mapcore.util.dv.a(com.autonavi.base.amap.mapcore.FPoint.obtain(0.0f, 0.0f), 51));
        this.h.setVisibility(8);
        this.c.setMapWidgetListener(new com.amap.api.mapcore.util.dv.AnonymousClass1());
        try {
            if (this.c.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.g.setVisibility(8);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    private void a(android.view.View view, int i, int i2, int i3, int i4) throws android.os.RemoteException {
        int i5;
        int i6;
        if (view == null) {
            return;
        }
        android.view.View view2 = this.m;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.m);
        }
        this.m = view;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.m.setDrawingCacheEnabled(true);
        this.m.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i7 = layoutParams.width;
            i6 = layoutParams.height;
            i5 = i7;
        } else {
            i5 = -2;
            i6 = -2;
        }
        addView(this.m, new com.amap.api.mapcore.util.dv.a(i5, i6, i, i2, i3, i4, 81));
    }

    private void a(android.view.View view, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i5 & 7;
        int i8 = i5 & 112;
        if (i7 == 5) {
            i3 -= i;
        } else if (i7 == 1) {
            i3 -= i / 2;
        }
        if (i8 == 80) {
            i4 -= i2;
        } else {
            if (i8 == 17) {
                i6 = i2 / 2;
            } else if (i8 == 16) {
                i4 /= 2;
                i6 = i2 / 2;
            }
            i4 -= i6;
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
        if (view instanceof com.autonavi.base.amap.api.mapcore.IGLSurfaceView) {
            this.c.changeSize(i, i2);
        }
    }

    private void a(android.view.View view, int i, int i2, int[] iArr) {
        android.view.View view2;
        if ((view instanceof android.widget.ListView) && (view2 = (android.view.View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void a(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof com.amap.api.mapcore.util.dt) {
            a(view, iArr[0], iArr[1], 20, (this.c.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    private void a(android.view.View view, com.amap.api.mapcore.util.dv.a aVar) {
        int[] iArr = new int[2];
        a(view, ((android.view.ViewGroup.LayoutParams) aVar).width, ((android.view.ViewGroup.LayoutParams) aVar).height, iArr);
        if (view instanceof com.amap.api.mapcore.util.ea) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), aVar.e);
            return;
        }
        if (view instanceof com.amap.api.mapcore.util.du) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], aVar.e);
            return;
        }
        if (view instanceof com.amap.api.mapcore.util.ds) {
            a(view, iArr[0], iArr[1], 0, 0, aVar.e);
            return;
        }
        if (aVar.a != null) {
            com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.c.getMapConfig();
            com.autonavi.base.ae.gmap.GLMapState mapProjection = this.c.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                com.autonavi.base.amap.mapcore.FPoint fPoint = aVar.a;
                ((android.graphics.Point) obtain).x = (int) ((android.graphics.PointF) fPoint).x;
                ((android.graphics.Point) obtain).y = (int) ((android.graphics.PointF) fPoint).y;
            }
            int i = ((android.graphics.Point) obtain).x + aVar.c;
            ((android.graphics.Point) obtain).x = i;
            int i2 = ((android.graphics.Point) obtain).y + aVar.d;
            ((android.graphics.Point) obtain).y = i2;
            a(view, iArr[0], iArr[1], i, i2, aVar.e);
            obtain.recycle();
        }
    }

    public static /* synthetic */ android.view.View f(com.amap.api.mapcore.util.dv dvVar) {
        dvVar.m = null;
        return null;
    }

    private void k() {
        com.amap.api.mapcore.util.dy dyVar = this.i;
        if (dyVar == null) {
            this.a.a(this, new java.lang.Object[0]);
        } else {
            if (dyVar == null || dyVar.getVisibility() != 0) {
                return;
            }
            this.i.postInvalidate();
        }
    }

    private void l() {
        com.amap.api.mapcore.util.ea eaVar = this.l;
        if (eaVar != null) {
            eaVar.a();
        }
        com.amap.api.mapcore.util.dy dyVar = this.i;
        if (dyVar != null) {
            dyVar.a();
        }
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar != null) {
            dzVar.a();
        }
        com.amap.api.mapcore.util.du duVar = this.g;
        if (duVar != null) {
            duVar.a();
        }
        com.amap.api.mapcore.util.ds dsVar = this.h;
        if (dsVar != null) {
            dsVar.a();
        }
        com.amap.api.mapcore.util.dt dtVar = this.k;
        if (dtVar != null) {
            dtVar.a();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final float a(int i) {
        if (this.f == null) {
            return 0.0f;
        }
        k();
        return this.f.d(i);
    }

    @Override // com.amap.api.mapcore.util.dw
    public final android.graphics.Point a() {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            return null;
        }
        return dzVar.b();
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(android.graphics.Canvas canvas) {
        android.graphics.Bitmap drawingCache;
        android.view.View view = this.m;
        if (view == null || this.n == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.m.getLeft(), this.m.getTop(), new android.graphics.Paint());
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(com.amap.api.mapcore.util.dt.a aVar) {
        com.amap.api.mapcore.util.dt dtVar = this.k;
        if (dtVar == null) {
            this.a.a(this, aVar);
        } else {
            dtVar.a(aVar);
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(com.amap.api.maps.model.CameraPosition cameraPosition) {
        if (this.f == null) {
            this.a.a(this, cameraPosition);
            return;
        }
        if (this.c.getUiSettings().isLogoEnable()) {
            if (com.amap.api.maps.MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                com.amap.api.maps.model.LatLng latLng = cameraPosition.target;
                if (!com.amap.api.mapcore.util.de.a(latLng.latitude, latLng.longitude)) {
                    this.f.setVisibility(8);
                    return;
                }
            }
            if (this.c.getMaskLayerType() == -1) {
                this.f.setVisibility(0);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.dt dtVar = this.k;
        if (dtVar == null) {
            this.a.a(this, bool);
        } else if (dtVar != null && bool.booleanValue() && this.c.canShowIndoorSwitch()) {
            this.k.a(true);
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(java.lang.Float f) {
        com.amap.api.mapcore.util.ea eaVar = this.l;
        if (eaVar == null) {
            this.a.a(this, f);
        } else if (eaVar != null) {
            eaVar.a(f.floatValue());
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(java.lang.Integer num) {
        com.amap.api.mapcore.util.ea eaVar = this.l;
        if (eaVar == null) {
            this.a.a(this, num);
        } else if (eaVar != null) {
            eaVar.a(num.intValue());
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(java.lang.Integer num, java.lang.Float f) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar != null) {
            this.a.a(this, num, f);
        } else if (dzVar != null) {
            dzVar.a(num.intValue(), f.floatValue());
            k();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(java.lang.String str, java.lang.Boolean bool, java.lang.Integer num) {
        if (this.f == null) {
            this.a.a(this, str, bool, num);
            return;
        }
        if (num.intValue() == 2) {
            this.f.b(bool.booleanValue());
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.f.a(str, num.intValue());
            this.f.d(bool.booleanValue());
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void a(boolean z) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar != null) {
            dzVar.c(z);
        }
        this.t = z;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void b(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.ea eaVar = this.l;
        if (eaVar == null) {
            this.a.a(this, bool);
        } else {
            eaVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void b(java.lang.Integer num) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            this.a.a(this, num);
        } else if (dzVar != null) {
            dzVar.a(num.intValue());
            this.f.postInvalidate();
            k();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final boolean b() {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar != null) {
            return dzVar.d();
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void c() {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            this.a.a(this, new java.lang.Object[0]);
        } else if (dzVar != null) {
            dzVar.c();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void c(java.lang.Boolean bool) {
        if (this.g == null) {
            this.a.a(this, bool);
        } else if (bool.booleanValue()) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void c(java.lang.Integer num) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            this.a.a(this, num);
        } else if (dzVar != null) {
            dzVar.b(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final com.amap.api.mapcore.util.dr d() {
        return this.j;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void d(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.ds dsVar = this.h;
        if (dsVar == null) {
            this.a.a(this, bool);
        } else {
            dsVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void d(java.lang.Integer num) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            this.a.a(this, num);
        } else if (dzVar != null) {
            dzVar.c(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final com.amap.api.mapcore.util.dt e() {
        return this.k;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void e(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.dy dyVar = this.i;
        if (dyVar == null) {
            this.a.a(this, bool);
        } else {
            dyVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final com.amap.api.mapcore.util.dz f() {
        return this.f;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void f(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            this.a.a(this, bool);
        } else {
            dzVar.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void g() {
        hideInfoWindow();
        com.amap.api.mapcore.util.dl.a(this.o);
        l();
        removeAllViews();
        this.q = null;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void g(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.dz dzVar = this.f;
        if (dzVar == null) {
            this.a.a(this, bool);
            return;
        }
        if (dzVar != null && bool.booleanValue()) {
            this.f.a(true);
            return;
        }
        com.amap.api.mapcore.util.dz dzVar2 = this.f;
        if (dzVar2 != null) {
            dzVar2.a(false);
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void h() {
        com.amap.api.mapcore.util.ds dsVar = this.h;
        if (dsVar == null) {
            this.a.a(this, new java.lang.Object[0]);
        } else {
            dsVar.b();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void h(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.du duVar = this.g;
        if (duVar == null) {
            this.a.a(this, bool);
        } else {
            duVar.a(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void hideInfoWindow() {
        try {
            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.c;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.c.getMainHandler().post(new com.amap.api.mapcore.util.dv.AnonymousClass2());
            com.amap.api.maps.model.BasePointOverlay basePointOverlay = this.n;
            if (basePointOverlay != null) {
                this.d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new java.lang.Object[]{java.lang.Boolean.FALSE});
            }
            this.n = null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void i() {
        android.content.Context context;
        if (!this.f123s || (context = this.e) == null) {
            return;
        }
        a(context);
        com.amap.api.mapcore.util.dx dxVar = this.a;
        if (dxVar != null) {
            dxVar.a();
        }
    }

    @Override // com.amap.api.mapcore.util.dw
    public final void i(java.lang.Boolean bool) {
        com.amap.api.mapcore.util.dt dtVar = this.k;
        if (dtVar == null) {
            this.a.a(this, bool);
        } else {
            dtVar.a(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.mapcore.util.dw
    public final android.view.View j() {
        return this;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(android.view.MotionEvent motionEvent) {
        return (this.m == null || this.n == null || !com.amap.api.mapcore.util.dl.a(new android.graphics.Rect(this.m.getLeft(), this.m.getTop(), this.m.getRight(), this.m.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                android.view.View childAt = getChildAt(i5);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof com.amap.api.mapcore.util.dv.a) {
                        a(childAt, (com.amap.api.mapcore.util.dv.a) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
            }
            com.amap.api.mapcore.util.dz dzVar = this.f;
            if (dzVar != null) {
                dzVar.c();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        try {
            com.amap.api.maps.model.BasePointOverlay basePointOverlay = this.n;
            if (basePointOverlay == null || !this.d.checkInBounds(basePointOverlay.getId())) {
                android.view.View view = this.m;
                if (view == null || view.getVisibility() != 0) {
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            if (this.p) {
                com.autonavi.base.amap.mapcore.FPoint obtain = com.autonavi.base.amap.mapcore.FPoint.obtain();
                this.d.getMarkerInfoWindowOffset(this.n.getId(), obtain);
                int i = (int) ((android.graphics.PointF) obtain).x;
                int i2 = (int) (((android.graphics.PointF) obtain).y + 2.0f);
                obtain.recycle();
                android.view.View a2 = a(this.n);
                if (a2 == null) {
                    android.view.View view2 = this.m;
                    if (view2 == null || view2.getVisibility() != 0) {
                        return;
                    }
                    hideInfoWindow();
                    return;
                }
                com.autonavi.base.amap.mapcore.FPoint obtain2 = com.autonavi.base.amap.mapcore.FPoint.obtain();
                this.d.getOverlayScreenPos(this.n.getId(), obtain2);
                a(a2, (int) ((android.graphics.PointF) obtain2).x, (int) ((android.graphics.PointF) obtain2).y, i, i2);
                android.view.View view3 = this.m;
                if (view3 != null) {
                    com.amap.api.mapcore.util.dv.a aVar = (com.amap.api.mapcore.util.dv.a) view3.getLayoutParams();
                    if (aVar != null) {
                        aVar.a = com.autonavi.base.amap.mapcore.FPoint.obtain(((android.graphics.PointF) obtain2).x, ((android.graphics.PointF) obtain2).y);
                        aVar.c = i;
                        aVar.d = i2;
                    }
                    onLayout(false, 0, 0, 0, 0);
                    if (this.b.a()) {
                        this.b.a(this.n.getTitle(), this.n.getSnippet());
                    }
                    if (this.m.getVisibility() == 8) {
                        this.m.setVisibility(0);
                    }
                }
                obtain2.recycle();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "MapOverlayViewGroup", "redrawInfoWindow");
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(com.amap.api.mapcore.util.aj ajVar) {
        this.b = ajVar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(com.amap.api.maps.model.BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.aj ajVar = this.b;
            if (!(ajVar != null && ajVar.a() && basePointOverlay.getTitle() == null && basePointOverlay.getSnippet() == null) && basePointOverlay.isInfoWindowEnable()) {
                com.amap.api.maps.model.BasePointOverlay basePointOverlay2 = this.n;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.b != null) {
                    this.n = basePointOverlay;
                    this.r = true;
                    this.d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new java.lang.Object[]{java.lang.Boolean.TRUE});
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(com.autonavi.base.amap.api.mapcore.BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.aj ajVar = this.b;
            if (!(ajVar != null && ajVar.a() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                com.amap.api.maps.model.BasePointOverlay basePointOverlay = this.n;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.b != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.r = true;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
