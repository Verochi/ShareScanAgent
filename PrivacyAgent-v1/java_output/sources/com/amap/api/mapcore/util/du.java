package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class du extends android.widget.LinearLayout {
    android.graphics.Bitmap a;
    android.graphics.Bitmap b;
    android.graphics.Bitmap c;
    android.graphics.Bitmap d;
    android.graphics.Bitmap e;
    android.graphics.Bitmap f;
    android.widget.ImageView g;
    com.autonavi.base.amap.api.mapcore.IAMapDelegate h;
    boolean i;

    /* renamed from: com.amap.api.mapcore.util.du$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (!com.amap.api.mapcore.util.du.this.i) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                com.amap.api.mapcore.util.du duVar = com.amap.api.mapcore.util.du.this;
                duVar.g.setImageBitmap(duVar.b);
            } else if (motionEvent.getAction() == 1) {
                try {
                    com.amap.api.mapcore.util.du duVar2 = com.amap.api.mapcore.util.du.this;
                    duVar2.g.setImageBitmap(duVar2.a);
                    com.amap.api.mapcore.util.du.this.h.setMyLocationEnabled(true);
                    android.location.Location myLocation = com.amap.api.mapcore.util.du.this.h.getMyLocation();
                    if (myLocation == null) {
                        return false;
                    }
                    com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                    com.amap.api.mapcore.util.du.this.h.showMyLocationOverlay(myLocation);
                    com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = com.amap.api.mapcore.util.du.this.h;
                    iAMapDelegate.moveCamera(com.amap.api.mapcore.util.z.a(latLng, iAMapDelegate.getZoomLevel()));
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "LocationView", "onTouch");
                    th.printStackTrace();
                }
            }
            return false;
        }
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public du(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        super(context);
        this.i = false;
        this.h = iAMapDelegate;
        try {
            android.graphics.Bitmap a = com.amap.api.mapcore.util.dl.a(context, "location_selected.png");
            this.d = a;
            this.a = com.amap.api.mapcore.util.dl.a(a, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a2 = com.amap.api.mapcore.util.dl.a(context, "location_pressed.png");
            this.e = a2;
            this.b = com.amap.api.mapcore.util.dl.a(a2, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a3 = com.amap.api.mapcore.util.dl.a(context, "location_unselected.png");
            this.f = a3;
            this.c = com.amap.api.mapcore.util.dl.a(a3, com.amap.api.mapcore.util.l.a);
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new com.amap.api.mapcore.util.du.AnonymousClass1());
            addView(this.g);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            android.graphics.Bitmap bitmap = this.a;
            if (bitmap != null) {
                com.amap.api.mapcore.util.dl.a(bitmap);
            }
            android.graphics.Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap2);
            }
            if (this.b != null) {
                com.amap.api.mapcore.util.dl.a(this.c);
            }
            this.a = null;
            this.b = null;
            this.c = null;
            android.graphics.Bitmap bitmap3 = this.d;
            if (bitmap3 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap3);
                this.d = null;
            }
            android.graphics.Bitmap bitmap4 = this.e;
            if (bitmap4 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap4);
                this.e = null;
            }
            android.graphics.Bitmap bitmap5 = this.f;
            if (bitmap5 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap5);
                this.f = null;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        this.i = z;
        try {
            if (z) {
                this.g.setImageBitmap(this.a);
            } else {
                this.g.setImageBitmap(this.c);
            }
            this.g.invalidate();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
