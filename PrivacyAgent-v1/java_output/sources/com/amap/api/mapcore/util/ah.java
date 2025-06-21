package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ah extends com.amap.api.mapcore.util.ab {
    private static final android.graphics.PointF p = new android.graphics.PointF();
    private final com.amap.api.mapcore.util.ah.a n;
    private boolean o;
    private android.graphics.PointF q;
    private android.graphics.PointF r;

    /* renamed from: s, reason: collision with root package name */
    private android.graphics.PointF f120s;
    private android.graphics.PointF t;

    public interface a {
        void a(com.amap.api.mapcore.util.ah ahVar);
    }

    public static class b implements com.amap.api.mapcore.util.ah.a {
        @Override // com.amap.api.mapcore.util.ah.a
        public void a(com.amap.api.mapcore.util.ah ahVar) {
        }
    }

    public ah(android.content.Context context, com.amap.api.mapcore.util.ah.a aVar) {
        super(context);
        this.f120s = new android.graphics.PointF();
        this.t = new android.graphics.PointF();
        this.n = aVar;
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a() {
        super.a();
        this.o = false;
        android.graphics.PointF pointF = this.f120s;
        pointF.x = 0.0f;
        android.graphics.PointF pointF2 = this.t;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(int i, android.view.MotionEvent motionEvent) {
        if (i == 3) {
            a();
        } else {
            if (i != 6) {
                return;
            }
            a(motionEvent);
            if (!this.o) {
                this.n.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.mapcore.util.ac
    public final void a(int i, android.view.MotionEvent motionEvent, int i2, int i3) {
        if (i != 5) {
            return;
        }
        a();
        this.g = android.view.MotionEvent.obtain(motionEvent);
        this.k = 0L;
        a(motionEvent);
        boolean a2 = a(motionEvent, i2, i3);
        this.o = a2;
        if (a2) {
            return;
        }
        this.f = true;
    }

    @Override // com.amap.api.mapcore.util.ab, com.amap.api.mapcore.util.ac
    public final void a(android.view.MotionEvent motionEvent) {
        android.graphics.PointF pointF;
        super.a(motionEvent);
        android.view.MotionEvent motionEvent2 = this.g;
        this.q = com.amap.api.mapcore.util.ac.b(motionEvent);
        this.r = com.amap.api.mapcore.util.ac.b(motionEvent2);
        if (this.g.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = p;
        } else {
            android.graphics.PointF pointF2 = this.q;
            float f = pointF2.x;
            android.graphics.PointF pointF3 = this.r;
            pointF = new android.graphics.PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.t = pointF;
        android.graphics.PointF pointF4 = this.f120s;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    public final float d() {
        return this.f120s.x;
    }

    public final float e() {
        return this.f120s.y;
    }
}
