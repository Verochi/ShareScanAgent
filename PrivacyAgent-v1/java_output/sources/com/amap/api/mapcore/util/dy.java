package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dy extends android.view.View {
    private java.lang.String a;
    private int b;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate c;
    private android.graphics.Paint d;
    private android.graphics.Paint e;
    private android.graphics.Rect f;
    private com.autonavi.amap.mapcore.IPoint g;
    private float h;
    private final int[] i;

    public dy(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        super(context);
        this.a = "";
        this.b = 0;
        this.h = 0.0f;
        this.i = new int[]{com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION, com.google.android.gms.common.util.GmsVersion.VERSION_LONGHORN, com.hbzhou.open.flowcamera.JCameraView.MEDIA_QUALITY_HIGH, 1000000, 500000, com.hbzhou.open.flowcamera.JCameraView.MEDIA_QUALITY_DESPAIR, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.c = iAMapDelegate;
        this.d = new android.graphics.Paint();
        this.f = new android.graphics.Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.d.setStrokeWidth(com.amap.api.mapcore.util.l.a * 2.0f);
        this.d.setStyle(android.graphics.Paint.Style.STROKE);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.e.setTextSize(com.amap.api.mapcore.util.l.a * 20.0f);
        this.h = com.amap.api.mapcore.util.df.b(context);
        this.g = new com.autonavi.amap.mapcore.IPoint();
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(java.lang.String str) {
        this.a = str;
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.g = null;
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
        } else {
            a("");
            a(0);
            setVisibility(8);
        }
    }

    public final void b() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.c.getPreciseLevel(engineIDWithType);
            this.c.getGeoCenter(engineIDWithType, this.g);
            if (this.g == null) {
                return;
            }
            com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(((android.graphics.Point) r0).x, ((android.graphics.Point) r0).y, 20);
            float mapZoomScale = this.c.getMapZoomScale();
            double cos = (float) ((((java.lang.Math.cos((pixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (java.lang.Math.pow(2.0d, preciseLevel) * 256.0d));
            int i = this.i[(int) preciseLevel];
            int i2 = (int) (i / (cos * mapZoomScale));
            java.lang.String a = com.amap.api.mapcore.util.dl.a(i);
            a(i2);
            a(a);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public final void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Point waterMarkerPositon;
        java.lang.String str = this.a;
        if (str == null || "".equals(str) || this.b == 0 || (waterMarkerPositon = this.c.getWaterMarkerPositon()) == null) {
            return;
        }
        android.graphics.Paint paint = this.e;
        java.lang.String str2 = this.a;
        paint.getTextBounds(str2, 0, str2.length(), this.f);
        int i = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f.height()) + 5;
        canvas.drawText(this.a, ((this.b - this.f.width()) / 2) + i, height, this.e);
        float f = i;
        float height2 = height + (this.f.height() - 5);
        canvas.drawLine(f, height2 - (this.h * 2.0f), f, height2 + com.amap.api.mapcore.util.l.a, this.d);
        canvas.drawLine(f, height2, this.b + i, height2, this.d);
        int i2 = this.b;
        canvas.drawLine(i + i2, height2 - (this.h * 2.0f), i + i2, height2 + com.amap.api.mapcore.util.l.a, this.d);
    }
}
