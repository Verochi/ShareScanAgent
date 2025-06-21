package com.google.android.exoplayer2.ui.spherical;

/* loaded from: classes22.dex */
class TouchTracker extends android.view.GestureDetector.SimpleOnGestureListener implements android.view.View.OnTouchListener, com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener {
    public final com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener u;
    public final float v;
    public final android.view.GestureDetector w;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.spherical.SingleTapListener y;
    public final android.graphics.PointF n = new android.graphics.PointF();
    public final android.graphics.PointF t = new android.graphics.PointF();
    public volatile float x = 3.1415927f;

    public interface Listener {
        void a(android.graphics.PointF pointF);
    }

    public TouchTracker(android.content.Context context, com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener listener, float f) {
        this.u = listener;
        this.v = f;
        this.w = new android.view.GestureDetector(context, this);
    }

    public void a(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.spherical.SingleTapListener singleTapListener) {
        this.y = singleTapListener;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(android.view.MotionEvent motionEvent) {
        this.n.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener
    @androidx.annotation.BinderThread
    public void onOrientationChange(float[] fArr, float f) {
        this.x = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        float x = (motionEvent2.getX() - this.n.x) / this.v;
        float y = motionEvent2.getY();
        android.graphics.PointF pointF = this.n;
        float f3 = (y - pointF.y) / this.v;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.x;
        float cos = (float) java.lang.Math.cos(d);
        float sin = (float) java.lang.Math.sin(d);
        android.graphics.PointF pointF2 = this.t;
        pointF2.x -= (cos * x) - (sin * f3);
        float f4 = pointF2.y + (sin * x) + (cos * f3);
        pointF2.y = f4;
        pointF2.y = java.lang.Math.max(-45.0f, java.lang.Math.min(45.0f, f4));
        this.u.a(this.t);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.google.android.exoplayer2.ui.spherical.SingleTapListener singleTapListener = this.y;
        if (singleTapListener != null) {
            return singleTapListener.onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return this.w.onTouchEvent(motionEvent);
    }
}
