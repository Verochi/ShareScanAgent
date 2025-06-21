package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ad extends com.amap.api.mapcore.util.ab {
    private static final android.graphics.PointF n = new android.graphics.PointF();
    private final com.amap.api.mapcore.util.ad.a o;
    private boolean p;
    private android.graphics.PointF q;
    private android.graphics.PointF r;

    /* renamed from: s, reason: collision with root package name */
    private android.graphics.PointF f118s;
    private android.graphics.PointF t;

    public interface a {
        boolean a(com.amap.api.mapcore.util.ad adVar);

        boolean b(com.amap.api.mapcore.util.ad adVar);

        void c(com.amap.api.mapcore.util.ad adVar);
    }

    public ad(android.content.Context context, com.amap.api.mapcore.util.ad.a aVar) {
        super(context);
        this.f118s = new android.graphics.PointF();
        this.t = new android.graphics.PointF();
        this.o = aVar;
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a() {
        super.a();
        this.p = false;
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(int i, android.view.MotionEvent motionEvent) {
        if (i == 2) {
            a(motionEvent);
            if (this.i / this.j <= 0.67f || !this.o.a(this)) {
                return;
            }
            this.g.recycle();
            this.g = android.view.MotionEvent.obtain(motionEvent);
            return;
        }
        if (i == 3) {
            if (!this.p) {
                this.o.c(this);
            }
            a();
        } else {
            if (i != 6) {
                return;
            }
            a(motionEvent);
            if (!this.p) {
                this.o.c(this);
            }
            a();
        }
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(int i, android.view.MotionEvent motionEvent, int i2, int i3) {
        if (i == 2) {
            if (this.p) {
                boolean a2 = a(motionEvent, i2, i3);
                this.p = a2;
                if (a2) {
                    return;
                }
                this.f = this.o.b(this);
                return;
            }
            return;
        }
        if (i != 5) {
            return;
        }
        a();
        this.g = android.view.MotionEvent.obtain(motionEvent);
        this.k = 0L;
        a(motionEvent);
        boolean a3 = a(motionEvent, i2, i3);
        this.p = a3;
        if (a3) {
            return;
        }
        this.f = this.o.b(this);
    }

    @Override // com.amap.api.mapcore.util.ab, com.amap.api.mapcore.util.ac
    public final void a(android.view.MotionEvent motionEvent) {
        android.graphics.PointF pointF;
        super.a(motionEvent);
        android.view.MotionEvent motionEvent2 = this.g;
        this.q = com.amap.api.mapcore.util.ac.b(motionEvent);
        this.r = com.amap.api.mapcore.util.ac.b(motionEvent2);
        if (this.g.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = n;
        } else {
            android.graphics.PointF pointF2 = this.q;
            float f = pointF2.x;
            android.graphics.PointF pointF3 = this.r;
            pointF = new android.graphics.PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.t = pointF;
        android.graphics.PointF pointF4 = this.f118s;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    public final android.graphics.PointF d() {
        return this.t;
    }
}
