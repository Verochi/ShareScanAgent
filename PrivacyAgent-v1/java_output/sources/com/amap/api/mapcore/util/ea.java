package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
final class ea extends android.widget.LinearLayout {
    private android.graphics.Bitmap a;
    private android.graphics.Bitmap b;
    private android.graphics.Bitmap c;
    private android.graphics.Bitmap d;
    private android.graphics.Bitmap e;
    private android.graphics.Bitmap f;
    private android.graphics.Bitmap g;
    private android.graphics.Bitmap h;
    private android.graphics.Bitmap i;
    private android.graphics.Bitmap j;
    private android.graphics.Bitmap k;
    private android.graphics.Bitmap l;
    private android.widget.ImageView m;
    private android.widget.ImageView n;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate o;

    /* renamed from: com.amap.api.mapcore.util.ea$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            try {
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (com.amap.api.mapcore.util.ea.this.o.getZoomLevel() < com.amap.api.mapcore.util.ea.this.o.getMaxZoomLevel() && com.amap.api.mapcore.util.ea.this.o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    com.amap.api.mapcore.util.ea.this.m.setImageBitmap(com.amap.api.mapcore.util.ea.this.e);
                } else if (motionEvent.getAction() == 1) {
                    com.amap.api.mapcore.util.ea.this.m.setImageBitmap(com.amap.api.mapcore.util.ea.this.a);
                    try {
                        com.amap.api.mapcore.util.ea.this.o.animateCamera(com.amap.api.mapcore.util.z.a());
                    } catch (android.os.RemoteException e) {
                        com.amap.api.mapcore.util.gd.c(e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ea$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnTouchListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            try {
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "ZoomControllerView", "zoomout ontouch");
                th.printStackTrace();
            }
            if (com.amap.api.mapcore.util.ea.this.o.getZoomLevel() > com.amap.api.mapcore.util.ea.this.o.getMinZoomLevel() && com.amap.api.mapcore.util.ea.this.o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    com.amap.api.mapcore.util.ea.this.n.setImageBitmap(com.amap.api.mapcore.util.ea.this.f);
                } else if (motionEvent.getAction() == 1) {
                    com.amap.api.mapcore.util.ea.this.n.setImageBitmap(com.amap.api.mapcore.util.ea.this.c);
                    com.amap.api.mapcore.util.ea.this.o.animateCamera(com.amap.api.mapcore.util.z.b());
                }
                return false;
            }
            return false;
        }
    }

    public ea(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        super(context);
        this.o = iAMapDelegate;
        try {
            android.graphics.Bitmap a = com.amap.api.mapcore.util.dl.a(context, "zoomin_selected.png");
            this.g = a;
            this.a = com.amap.api.mapcore.util.dl.a(a, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a2 = com.amap.api.mapcore.util.dl.a(context, "zoomin_unselected.png");
            this.h = a2;
            this.b = com.amap.api.mapcore.util.dl.a(a2, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a3 = com.amap.api.mapcore.util.dl.a(context, "zoomout_selected.png");
            this.i = a3;
            this.c = com.amap.api.mapcore.util.dl.a(a3, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a4 = com.amap.api.mapcore.util.dl.a(context, "zoomout_unselected.png");
            this.j = a4;
            this.d = com.amap.api.mapcore.util.dl.a(a4, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a5 = com.amap.api.mapcore.util.dl.a(context, "zoomin_pressed.png");
            this.k = a5;
            this.e = com.amap.api.mapcore.util.dl.a(a5, com.amap.api.mapcore.util.l.a);
            android.graphics.Bitmap a6 = com.amap.api.mapcore.util.dl.a(context, "zoomout_pressed.png");
            this.l = a6;
            this.f = com.amap.api.mapcore.util.dl.a(a6, com.amap.api.mapcore.util.l.a);
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            this.m = imageView;
            imageView.setImageBitmap(this.a);
            this.m.setClickable(true);
            android.widget.ImageView imageView2 = new android.widget.ImageView(context);
            this.n = imageView2;
            imageView2.setImageBitmap(this.c);
            this.n.setClickable(true);
            this.m.setOnTouchListener(new com.amap.api.mapcore.util.ea.AnonymousClass1());
            this.n.setOnTouchListener(new com.amap.api.mapcore.util.ea.AnonymousClass2());
            this.m.setPadding(0, 0, 20, -2);
            this.n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.m);
            addView(this.n);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            com.amap.api.mapcore.util.dl.a(this.a);
            com.amap.api.mapcore.util.dl.a(this.b);
            com.amap.api.mapcore.util.dl.a(this.c);
            com.amap.api.mapcore.util.dl.a(this.d);
            com.amap.api.mapcore.util.dl.a(this.e);
            com.amap.api.mapcore.util.dl.a(this.f);
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            android.graphics.Bitmap bitmap = this.g;
            if (bitmap != null) {
                com.amap.api.mapcore.util.dl.a(bitmap);
                this.g = null;
            }
            android.graphics.Bitmap bitmap2 = this.h;
            if (bitmap2 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap2);
                this.h = null;
            }
            android.graphics.Bitmap bitmap3 = this.i;
            if (bitmap3 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap3);
                this.i = null;
            }
            android.graphics.Bitmap bitmap4 = this.j;
            if (bitmap4 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap4);
                this.g = null;
            }
            android.graphics.Bitmap bitmap5 = this.k;
            if (bitmap5 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap5);
                this.k = null;
            }
            android.graphics.Bitmap bitmap6 = this.l;
            if (bitmap6 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap6);
                this.l = null;
            }
            this.m = null;
            this.n = null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(float f) {
        try {
            if (f < this.o.getMaxZoomLevel() && f > this.o.getMinZoomLevel()) {
                this.m.setImageBitmap(this.a);
                this.n.setImageBitmap(this.c);
            } else if (f == this.o.getMinZoomLevel()) {
                this.n.setImageBitmap(this.d);
                this.m.setImageBitmap(this.a);
            } else if (f == this.o.getMaxZoomLevel()) {
                this.m.setImageBitmap(this.b);
                this.n.setImageBitmap(this.c);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        try {
            com.amap.api.mapcore.util.dv.a aVar = (com.amap.api.mapcore.util.dv.a) getLayoutParams();
            if (i == 1) {
                aVar.e = 16;
            } else if (i == 2) {
                aVar.e = 80;
            }
            setLayoutParams(aVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
