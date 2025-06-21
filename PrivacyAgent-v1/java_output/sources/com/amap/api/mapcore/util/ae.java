package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ae extends com.amap.api.mapcore.util.ac {
    private static final android.graphics.PointF a = new android.graphics.PointF();
    private final com.amap.api.mapcore.util.ae.a b;
    private android.graphics.PointF c;
    private android.graphics.PointF d;
    private android.graphics.PointF n;
    private android.graphics.PointF o;

    public interface a {
        boolean a(com.amap.api.mapcore.util.ae aeVar);

        boolean b(com.amap.api.mapcore.util.ae aeVar);

        void c(com.amap.api.mapcore.util.ae aeVar);
    }

    public ae(android.content.Context context, com.amap.api.mapcore.util.ae.a aVar) {
        super(context);
        this.n = new android.graphics.PointF();
        this.o = new android.graphics.PointF();
        this.b = aVar;
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(int i, android.view.MotionEvent motionEvent) {
        if (i != 1) {
            if (i == 2) {
                a(motionEvent);
                if (this.i / this.j <= 0.67f || motionEvent.getPointerCount() > 1 || !this.b.a(this)) {
                    return;
                }
                this.g.recycle();
                this.g = android.view.MotionEvent.obtain(motionEvent);
                return;
            }
            if (i != 3) {
                return;
            }
        }
        this.b.c(this);
        a();
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(int i, android.view.MotionEvent motionEvent, int i2, int i3) {
        if (i == 0) {
            a();
            this.g = android.view.MotionEvent.obtain(motionEvent);
            this.k = 0L;
            a(motionEvent);
            return;
        }
        if (i == 2) {
            this.f = this.b.b(this);
            return;
        }
        if (i != 5) {
            return;
        }
        android.view.MotionEvent motionEvent2 = this.g;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.g = android.view.MotionEvent.obtain(motionEvent);
        a(motionEvent);
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(android.view.MotionEvent motionEvent) {
        android.graphics.PointF pointF;
        super.a(motionEvent);
        android.view.MotionEvent motionEvent2 = this.g;
        this.c = com.amap.api.mapcore.util.ac.b(motionEvent);
        this.d = com.amap.api.mapcore.util.ac.b(motionEvent2);
        boolean z = this.g.getPointerCount() != motionEvent.getPointerCount();
        if (z) {
            pointF = a;
        } else {
            android.graphics.PointF pointF2 = this.c;
            float f = pointF2.x;
            android.graphics.PointF pointF3 = this.d;
            pointF = new android.graphics.PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.o = pointF;
        if (z) {
            this.g.recycle();
            this.g = android.view.MotionEvent.obtain(motionEvent);
        }
        android.graphics.PointF pointF4 = this.n;
        float f2 = pointF4.x;
        android.graphics.PointF pointF5 = this.o;
        pointF4.x = f2 + pointF5.x;
        pointF4.y += pointF5.y;
    }

    public final android.graphics.PointF d() {
        return this.o;
    }
}
