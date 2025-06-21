package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bz {
    android.animation.ValueAnimator b;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate e;
    private com.amap.api.maps.model.Marker f;
    private com.amap.api.maps.model.Circle g;
    private com.amap.api.maps.model.LatLng i;
    private double j;
    private android.content.Context k;
    private com.amap.api.mapcore.util.s l;
    private com.amap.api.maps.model.MyLocationStyle h = new com.amap.api.maps.model.MyLocationStyle();
    private int m = 4;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f122s = false;
    com.amap.api.mapcore.util.bz.a a = null;
    android.animation.Animator.AnimatorListener c = new com.amap.api.mapcore.util.bz.AnonymousClass1();
    android.animation.ValueAnimator.AnimatorUpdateListener d = new com.amap.api.mapcore.util.bz.AnonymousClass2();

    /* renamed from: com.amap.api.mapcore.util.bz$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.Animator.AnimatorListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            com.amap.api.mapcore.util.bz.this.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(android.animation.Animator animator) {
        }
    }

    /* renamed from: com.amap.api.mapcore.util.bz$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            try {
                if (com.amap.api.mapcore.util.bz.this.g != null) {
                    com.amap.api.maps.model.LatLng latLng = (com.amap.api.maps.model.LatLng) valueAnimator.getAnimatedValue();
                    com.amap.api.mapcore.util.bz.this.g.setCenter(latLng);
                    com.amap.api.mapcore.util.bz.this.f.setPosition(latLng);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static class a implements android.animation.TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final java.lang.Object evaluate(float f, java.lang.Object obj, java.lang.Object obj2) {
            com.amap.api.maps.model.LatLng latLng = (com.amap.api.maps.model.LatLng) obj;
            com.amap.api.maps.model.LatLng latLng2 = (com.amap.api.maps.model.LatLng) obj2;
            double d = latLng.latitude;
            double d2 = f;
            double d3 = d + ((latLng2.latitude - d) * d2);
            double d4 = latLng.longitude;
            return new com.amap.api.maps.model.LatLng(d3, d4 + (d2 * (latLng2.longitude - d4)));
        }
    }

    public bz(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.e = iAMapDelegate;
        this.l = new com.amap.api.mapcore.util.s(applicationContext, iAMapDelegate);
        a(4, true);
    }

    private void a(int i) {
        a(i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r4 != 7) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, boolean z) {
        this.m = i;
        this.n = false;
        this.p = false;
        this.o = false;
        this.r = false;
        this.f122s = false;
        if (i == 1) {
            this.o = true;
            this.p = true;
            this.q = true;
        } else if (i != 2) {
            if (i == 3) {
                this.o = true;
            } else if (i == 4) {
                this.o = true;
                this.r = true;
                this.q = false;
            } else if (i == 5) {
                this.r = true;
                this.q = false;
            }
            this.f122s = true;
        } else {
            this.o = true;
            this.q = true;
        }
        if (!this.r && !this.f122s) {
            com.amap.api.maps.model.Marker marker = this.f;
            if (marker != null) {
                marker.setFlat(false);
            }
            i();
            h();
            g();
            return;
        }
        if (this.f122s) {
            this.l.a(true);
            if (!z) {
                try {
                    this.e.moveCamera(com.amap.api.mapcore.util.z.a(17.0f));
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            b(45.0f);
        } else {
            this.l.a(false);
        }
        this.l.a();
        com.amap.api.maps.model.Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setFlat(true);
        }
    }

    private void a(com.amap.api.maps.model.LatLng latLng) {
        com.amap.api.maps.model.LatLng position = this.f.getPosition();
        if (position == null) {
            position = new com.amap.api.maps.model.LatLng(0.0d, 0.0d);
        }
        if (this.a == null) {
            this.a = new com.amap.api.mapcore.util.bz.a();
        }
        android.animation.ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null) {
            android.animation.ValueAnimator ofObject = android.animation.ValueAnimator.ofObject(new com.amap.api.mapcore.util.bz.a(), position, latLng);
            this.b = ofObject;
            ofObject.addListener(this.c);
            this.b.addUpdateListener(this.d);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.b.setEvaluator(this.a);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.b.setDuration(1L);
        } else {
            this.b.setDuration(1000L);
        }
        this.b.start();
    }

    private void a(boolean z) {
        com.amap.api.maps.model.Circle circle = this.g;
        if (circle != null && circle.isVisible() != z) {
            this.g.setVisible(z);
        }
        com.amap.api.maps.model.Marker marker = this.f;
        if (marker == null || marker.isVisible() == z) {
            return;
        }
        this.f.setVisible(z);
    }

    private void b(float f) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(com.amap.api.mapcore.util.z.c(f));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(float f) {
        if (this.q) {
            float f2 = f % 360.0f;
            if (f2 > 180.0f) {
                f2 -= 360.0f;
            } else if (f2 < -180.0f) {
                f2 += 360.0f;
            }
            com.amap.api.maps.model.Marker marker = this.f;
            if (marker != null) {
                marker.setRotateAngle(-f2);
            }
        }
    }

    private void g() {
        this.l.b();
    }

    private void h() {
        b(0.0f);
    }

    private void i() {
        j();
    }

    private void j() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(com.amap.api.mapcore.util.z.d(0.0f));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i != null && this.o) {
            if (this.p && this.n) {
                return;
            }
            this.n = true;
            try {
                com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
                com.amap.api.maps.model.LatLng latLng = this.i;
                com.autonavi.base.ae.gmap.GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.e.animateCamera(com.amap.api.mapcore.util.z.a(obtain));
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void l() {
        com.amap.api.maps.model.MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle == null) {
            com.amap.api.maps.model.MyLocationStyle myLocationStyle2 = new com.amap.api.maps.model.MyLocationStyle();
            this.h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null) {
            this.h.myLocationIcon(com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        n();
    }

    private void m() {
        com.amap.api.maps.model.Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.removeGLOverlay(circle.getId());
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        com.amap.api.maps.model.Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f = null;
            this.l.a((com.amap.api.maps.model.Marker) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0115 A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0017, B:7:0x001c, B:9:0x002a, B:10:0x0035, B:12:0x0043, B:13:0x004e, B:15:0x005c, B:16:0x0067, B:18:0x006b, B:19:0x0070, B:20:0x007c, B:22:0x0081, B:23:0x0092, B:25:0x0096, B:27:0x00a4, B:29:0x00c5, B:31:0x00cd, B:34:0x00da, B:36:0x00e2, B:38:0x00fa, B:39:0x0111, B:41:0x0115, B:42:0x0106, B:43:0x00b4, B:44:0x011f), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n() {
        com.amap.api.maps.model.LatLng latLng;
        try {
            if (this.g == null) {
                this.g = this.e.addCircle(new com.amap.api.maps.model.CircleOptions().zIndex(1.0f));
            }
            com.amap.api.maps.model.Circle circle = this.g;
            if (circle != null) {
                if (circle.getStrokeWidth() != this.h.getStrokeWidth()) {
                    this.g.setStrokeWidth(this.h.getStrokeWidth());
                }
                if (this.g.getFillColor() != this.h.getRadiusFillColor()) {
                    this.g.setFillColor(this.h.getRadiusFillColor());
                }
                if (this.g.getStrokeColor() != this.h.getStrokeColor()) {
                    this.g.setStrokeColor(this.h.getStrokeColor());
                }
                com.amap.api.maps.model.LatLng latLng2 = this.i;
                if (latLng2 != null) {
                    this.g.setCenter(latLng2);
                }
                this.g.setRadius(this.j);
                this.g.setVisible(true);
            }
            if (this.f == null) {
                this.f = this.e.addMarker(new com.amap.api.maps.model.MarkerOptions().visible(false));
            }
            com.amap.api.maps.model.Marker marker = this.f;
            if (marker != null) {
                if (marker.getAnchorU() != this.h.getAnchorU() || this.f.getAnchorV() != this.h.getAnchorV()) {
                    this.f.setAnchor(this.h.getAnchorU(), this.h.getAnchorV());
                }
                if (this.f.getIcons() != null && this.f.getIcons().size() != 0) {
                    if (this.h.getMyLocationIcon() != null && !this.f.getIcons().get(0).equals(this.h.getMyLocationIcon())) {
                        this.f.setIcon(this.h.getMyLocationIcon());
                    }
                    latLng = this.i;
                    if (latLng != null) {
                        this.f.setPosition(latLng);
                        this.f.setVisible(true);
                    }
                }
                this.f.setIcon(this.h.getMyLocationIcon());
                latLng = this.i;
                if (latLng != null) {
                }
            }
            k();
            this.l.a(this.f);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }

    public final com.amap.api.maps.model.MyLocationStyle a() {
        return this.h;
    }

    public final void a(float f) {
        com.amap.api.maps.model.Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f);
        }
    }

    public final void a(android.location.Location location) {
        if (location == null) {
            return;
        }
        a(this.h.isMyLocationShowing());
        if (this.h.isMyLocationShowing()) {
            this.i = new com.amap.api.maps.model.LatLng(location.getLatitude(), location.getLongitude());
            this.j = location.getAccuracy();
            if (this.f == null && this.g == null) {
                l();
            }
            com.amap.api.maps.model.Circle circle = this.g;
            if (circle != null) {
                try {
                    double d = this.j;
                    if (d != -1.0d) {
                        circle.setRadius(d);
                    }
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            c(location.getBearing());
            if (this.i.equals(this.f.getPosition())) {
                k();
            } else {
                a(this.i);
            }
        }
    }

    public final void a(com.amap.api.maps.model.MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                this.l.a(false);
                this.m = this.h.getMyLocationType();
                return;
            }
            l();
            com.amap.api.maps.model.Marker marker = this.f;
            if (marker == null && this.g == null) {
                return;
            }
            this.l.a(marker);
            a(this.h.getMyLocationType());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        com.amap.api.mapcore.util.s sVar;
        if (this.m != 3 || (sVar = this.l) == null) {
            return;
        }
        sVar.a();
    }

    public final void c() throws android.os.RemoteException {
        m();
        if (this.l != null) {
            g();
            this.l = null;
        }
    }

    public final java.lang.String d() {
        com.amap.api.maps.model.Marker marker = this.f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final java.lang.String e() throws android.os.RemoteException {
        com.amap.api.maps.model.Circle circle = this.g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void f() {
        this.g = null;
        this.f = null;
    }
}
