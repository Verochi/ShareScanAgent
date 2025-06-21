package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class ab extends com.amap.api.mapcore.util.ac {
    protected float a;
    protected float b;
    protected float c;
    protected float d;
    private final float n;
    private float o;
    private float p;
    private float q;
    private float r;

    /* renamed from: s, reason: collision with root package name */
    private float f117s;
    private float t;
    private float u;
    private float v;

    public ab(android.content.Context context) {
        super(context);
        this.f117s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.n = android.view.ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    private static float a(android.view.MotionEvent motionEvent, int i) {
        float x = (i + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x;
        }
        return 0.0f;
    }

    private static float b(android.view.MotionEvent motionEvent, int i) {
        float y = (i + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y;
        }
        return 0.0f;
    }

    public final android.graphics.PointF a(int i) {
        return i == 0 ? new android.graphics.PointF(this.f117s, this.t) : new android.graphics.PointF(this.u, this.v);
    }

    @Override // com.amap.api.mapcore.util.ac
    public void a(android.view.MotionEvent motionEvent) {
        super.a(motionEvent);
        android.view.MotionEvent motionEvent2 = this.g;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.q = -1.0f;
            this.r = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.a = x2 - x;
            this.b = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.c = x4 - x3;
            this.d = y4 - y3;
            this.f117s = x3 - x;
            this.t = y3 - y;
            this.u = x4 - x2;
            this.v = y4 - y2;
        }
    }

    public final boolean a(android.view.MotionEvent motionEvent, int i, int i2) {
        int i3;
        int i4 = this.l;
        if (i4 == 0 || (i3 = this.m) == 0) {
            float f = this.e.getResources().getDisplayMetrics().widthPixels;
            float f2 = this.n;
            this.o = f - f2;
            this.p = r0.heightPixels - f2;
        } else {
            float f3 = this.n;
            this.o = i4 - f3;
            this.p = i3 - f3;
        }
        float f4 = this.n;
        float f5 = this.o;
        float f6 = this.p;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a = a(motionEvent, i);
        float b = b(motionEvent, i2);
        boolean z = rawX < f4 || rawY < f4 || rawX > f5 || rawY > f6;
        boolean z2 = a < f4 || b < f4 || a > f5 || b > f6;
        return (z && z2) || z || z2;
    }
}
