package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class aj {
    android.content.Context c;
    private android.view.View e;
    private android.widget.TextView f;
    private android.widget.TextView g;
    private com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction i;
    private com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction j;
    private com.amap.api.maps.model.BaseOverlay k;
    com.amap.api.maps.AMap.InfoWindowAdapter a = null;
    com.amap.api.maps.AMap.CommonInfoWindowAdapter b = null;
    private boolean d = true;
    private android.graphics.drawable.Drawable h = null;
    private com.amap.api.maps.AMap.InfoWindowAdapter l = new com.amap.api.mapcore.util.aj.AnonymousClass1();
    private com.amap.api.maps.AMap.CommonInfoWindowAdapter m = new com.amap.api.mapcore.util.aj.AnonymousClass2();

    /* renamed from: com.amap.api.mapcore.util.aj$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.maps.AMap.InfoWindowAdapter {
        public AnonymousClass1() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final android.view.View getInfoContents(com.amap.api.maps.model.Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final android.view.View getInfoWindow(com.amap.api.maps.model.Marker marker) {
            try {
                if (com.amap.api.mapcore.util.aj.this.h == null) {
                    com.amap.api.mapcore.util.aj ajVar = com.amap.api.mapcore.util.aj.this;
                    ajVar.h = com.amap.api.mapcore.util.da.a(ajVar.c, "infowindow_bg.9.png");
                }
                if (com.amap.api.mapcore.util.aj.this.e == null) {
                    com.amap.api.mapcore.util.aj.this.e = new android.widget.LinearLayout(com.amap.api.mapcore.util.aj.this.c);
                    com.amap.api.mapcore.util.aj.this.e.setBackground(com.amap.api.mapcore.util.aj.this.h);
                    com.amap.api.mapcore.util.aj.this.f = new android.widget.TextView(com.amap.api.mapcore.util.aj.this.c);
                    com.amap.api.mapcore.util.aj.this.f.setText(marker.getTitle());
                    com.amap.api.mapcore.util.aj.this.f.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                    com.amap.api.mapcore.util.aj.this.g = new android.widget.TextView(com.amap.api.mapcore.util.aj.this.c);
                    com.amap.api.mapcore.util.aj.this.g.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                    com.amap.api.mapcore.util.aj.this.g.setText(marker.getSnippet());
                    ((android.widget.LinearLayout) com.amap.api.mapcore.util.aj.this.e).setOrientation(1);
                    ((android.widget.LinearLayout) com.amap.api.mapcore.util.aj.this.e).addView(com.amap.api.mapcore.util.aj.this.f);
                    ((android.widget.LinearLayout) com.amap.api.mapcore.util.aj.this.e).addView(com.amap.api.mapcore.util.aj.this.g);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return com.amap.api.mapcore.util.aj.this.e;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.aj$2, reason: invalid class name */
    public class AnonymousClass2 implements com.amap.api.maps.AMap.CommonInfoWindowAdapter {
        private com.amap.api.maps.InfoWindowParams b = null;

        public AnonymousClass2() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final com.amap.api.maps.InfoWindowParams getInfoWindowParams(com.amap.api.maps.model.BasePointOverlay basePointOverlay) {
            try {
                if (this.b == null) {
                    this.b = new com.amap.api.maps.InfoWindowParams();
                    if (com.amap.api.mapcore.util.aj.this.h == null) {
                        com.amap.api.mapcore.util.aj ajVar = com.amap.api.mapcore.util.aj.this;
                        ajVar.h = com.amap.api.mapcore.util.da.a(ajVar.c, "infowindow_bg.9.png");
                    }
                    com.amap.api.mapcore.util.aj.this.e = new android.widget.LinearLayout(com.amap.api.mapcore.util.aj.this.c);
                    com.amap.api.mapcore.util.aj.this.e.setBackground(com.amap.api.mapcore.util.aj.this.h);
                    com.amap.api.mapcore.util.aj.this.f = new android.widget.TextView(com.amap.api.mapcore.util.aj.this.c);
                    com.amap.api.mapcore.util.aj.this.f.setText("标题");
                    com.amap.api.mapcore.util.aj.this.f.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                    com.amap.api.mapcore.util.aj.this.g = new android.widget.TextView(com.amap.api.mapcore.util.aj.this.c);
                    com.amap.api.mapcore.util.aj.this.g.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                    com.amap.api.mapcore.util.aj.this.g.setText("内容");
                    ((android.widget.LinearLayout) com.amap.api.mapcore.util.aj.this.e).setOrientation(1);
                    ((android.widget.LinearLayout) com.amap.api.mapcore.util.aj.this.e).addView(com.amap.api.mapcore.util.aj.this.f);
                    ((android.widget.LinearLayout) com.amap.api.mapcore.util.aj.this.e).addView(com.amap.api.mapcore.util.aj.this.g);
                    this.b.setInfoWindowType(2);
                    this.b.setInfoWindow(com.amap.api.mapcore.util.aj.this.e);
                }
                return this.b;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    }

    public aj(android.content.Context context) {
        this.c = context;
    }

    private static void a(android.view.View view, com.amap.api.maps.model.BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !com.amap.api.mapcore.util.cz.c()) {
            return;
        }
        java.lang.String b = com.amap.api.mapcore.util.dl.b(view);
        if (android.text.TextUtils.isEmpty(b)) {
            return;
        }
        com.amap.api.mapcore.util.cz.a().a(basePointOverlay.getPosition(), b, "");
    }

    private static boolean b(com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        com.amap.api.maps.model.Marker marker = new com.amap.api.maps.model.Marker(null, new com.amap.api.maps.model.MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    private synchronized com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction d() {
        com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof com.amap.api.maps.AMap.ImageInfoWindowAdapter) {
                return this.j;
            }
            if (infoWindowAdapter instanceof com.amap.api.maps.AMap.MultiPositionInfoWindowAdapter) {
                return this.j;
            }
        }
        com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter == null || commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() != 1) {
            return this.i;
        }
        return this.j;
    }

    public final android.view.View a(com.amap.api.maps.model.BasePointOverlay basePointOverlay) {
        com.amap.api.maps.InfoWindowParams infoWindowParams;
        com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            android.view.View infoWindow = infoWindowAdapter.getInfoWindow((com.amap.api.maps.model.Marker) basePointOverlay);
            a(infoWindow, basePointOverlay);
            return infoWindow;
        }
        com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            android.view.View infoWindow2 = infoWindowParams.getInfoWindow();
            a(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        com.amap.api.maps.InfoWindowParams infoWindowParams2 = this.m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final com.amap.api.maps.model.BaseOverlay a(android.view.MotionEvent motionEvent) {
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction d = d();
        if (d == null || !d.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.k;
    }

    public final synchronized void a(com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.b = commonInfoWindowAdapter;
        this.a = null;
        if (commonInfoWindowAdapter == null) {
            this.b = this.m;
            this.d = true;
        } else {
            this.d = false;
        }
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction iInfoWindowAction = this.j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction iInfoWindowAction2 = this.i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final synchronized void a(com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter) {
        this.a = infoWindowAdapter;
        this.b = null;
        if (b(infoWindowAdapter)) {
            this.a = this.l;
            this.d = true;
        } else {
            this.d = false;
        }
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction iInfoWindowAction = this.j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction iInfoWindowAction2 = this.i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final void a(com.amap.api.maps.model.BaseOverlay baseOverlay) throws android.os.RemoteException {
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction d = d();
        if (d == null || !(baseOverlay instanceof com.amap.api.maps.model.BasePointOverlay)) {
            return;
        }
        d.showInfoWindow((com.amap.api.maps.model.BasePointOverlay) baseOverlay);
        this.k = baseOverlay;
    }

    public final void a(com.autonavi.base.amap.api.mapcore.BaseOverlayImp baseOverlayImp) throws android.os.RemoteException {
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction d = d();
        if (d != null) {
            d.showInfoWindow(baseOverlayImp);
        }
    }

    public final void a(com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        android.widget.TextView textView = this.f;
        if (textView != null) {
            textView.requestLayout();
            this.f.setText(str);
        }
        android.widget.TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.requestLayout();
            this.g.setText(str2);
        }
        android.view.View view = this.e;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final synchronized boolean a() {
        return this.d;
    }

    public final android.view.View b(com.amap.api.maps.model.BasePointOverlay basePointOverlay) {
        com.amap.api.maps.InfoWindowParams infoWindowParams;
        com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            android.view.View infoContents = infoWindowAdapter.getInfoContents((com.amap.api.maps.model.Marker) basePointOverlay);
            a(infoContents, basePointOverlay);
            return infoContents;
        }
        com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            android.view.View infoContents2 = infoWindowParams.getInfoContents();
            a(infoContents2, basePointOverlay);
            return infoContents2;
        }
        com.amap.api.maps.InfoWindowParams infoWindowParams2 = this.m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final void b() {
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction d = d();
        if (d != null) {
            d.redrawInfoWindow();
        }
    }

    public final void b(com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final long c(com.amap.api.maps.model.BasePointOverlay basePointOverlay) {
        com.amap.api.maps.InfoWindowParams infoWindowParams;
        com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof com.amap.api.maps.AMap.ImageInfoWindowAdapter)) {
            return ((com.amap.api.maps.AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public final void c() {
        com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction d = d();
        if (d != null) {
            d.hideInfoWindow();
        }
    }
}
