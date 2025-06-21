package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ds extends android.widget.LinearLayout {
    android.graphics.Bitmap a;
    android.graphics.Bitmap b;
    android.graphics.Bitmap c;
    android.widget.ImageView d;
    com.autonavi.base.amap.api.mapcore.IAMapDelegate e;
    android.graphics.Matrix f;

    /* renamed from: com.amap.api.mapcore.util.ds$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            try {
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            if (!com.amap.api.mapcore.util.ds.this.e.isMaploaded()) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                com.amap.api.mapcore.util.ds dsVar = com.amap.api.mapcore.util.ds.this;
                dsVar.d.setImageBitmap(dsVar.b);
            } else if (motionEvent.getAction() == 1) {
                com.amap.api.mapcore.util.ds dsVar2 = com.amap.api.mapcore.util.ds.this;
                dsVar2.d.setImageBitmap(dsVar2.a);
                com.amap.api.maps.model.CameraPosition cameraPosition = com.amap.api.mapcore.util.ds.this.e.getCameraPosition();
                com.amap.api.mapcore.util.ds.this.e.animateCamera(com.amap.api.mapcore.util.z.a(new com.amap.api.maps.model.CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
            }
            return false;
        }
    }

    public ds(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        super(context);
        this.f = new android.graphics.Matrix();
        this.e = iAMapDelegate;
        try {
            android.graphics.Bitmap a = com.amap.api.mapcore.util.dl.a(context, "maps_dav_compass_needle_large.png");
            this.c = a;
            this.b = com.amap.api.mapcore.util.dl.a(a, com.amap.api.mapcore.util.l.a * 0.8f);
            android.graphics.Bitmap a2 = com.amap.api.mapcore.util.dl.a(this.c, com.amap.api.mapcore.util.l.a * 0.7f);
            this.c = a2;
            android.graphics.Bitmap bitmap = this.b;
            if (bitmap != null && a2 != null) {
                this.a = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), this.b.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(this.a);
                android.graphics.Paint paint = new android.graphics.Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.c, (this.b.getWidth() - this.c.getWidth()) / 2.0f, (this.b.getHeight() - this.c.getHeight()) / 2.0f, paint);
                android.widget.ImageView imageView = new android.widget.ImageView(context);
                this.d = imageView;
                imageView.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                this.d.setImageBitmap(this.a);
                this.d.setClickable(true);
                b();
                this.d.setOnTouchListener(new com.amap.api.mapcore.util.ds.AnonymousClass1());
                addView(this.d);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CompassView", "create");
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
            android.graphics.Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap3);
            }
            android.graphics.Matrix matrix = this.f;
            if (matrix != null) {
                matrix.reset();
                this.f = null;
            }
            this.c = null;
            this.a = null;
            this.b = null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (!z) {
            setVisibility(8);
        } else {
            setVisibility(0);
            b();
        }
    }

    public final void b() {
        try {
            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.e;
            if (iAMapDelegate == null || this.d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float cameraDegree = this.e.getCameraDegree(engineIDWithType);
            float mapAngle = this.e.getMapAngle(engineIDWithType);
            if (this.f == null) {
                this.f = new android.graphics.Matrix();
            }
            this.f.reset();
            this.f.postRotate(-mapAngle, this.d.getDrawable().getBounds().width() / 2.0f, this.d.getDrawable().getBounds().height() / 2.0f);
            this.f.postScale(1.0f, (float) java.lang.Math.cos((cameraDegree * 3.141592653589793d) / 180.0d), this.d.getDrawable().getBounds().width() / 2.0f, this.d.getDrawable().getBounds().height() / 2.0f);
            this.d.setImageMatrix(this.f);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
