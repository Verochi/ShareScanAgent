package com.github.chrisbanes.photoview;

/* loaded from: classes22.dex */
class CustomGestureDetector {
    public int a = -1;
    public int b = 0;
    public final android.view.ScaleGestureDetector c;
    public android.view.VelocityTracker d;
    public boolean e;
    public float f;
    public float g;
    public final float h;
    public final float i;
    public com.github.chrisbanes.photoview.OnGestureListener j;

    /* renamed from: com.github.chrisbanes.photoview.CustomGestureDetector$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ScaleGestureDetector.OnScaleGestureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (java.lang.Float.isNaN(scaleFactor) || java.lang.Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            com.github.chrisbanes.photoview.CustomGestureDetector.this.j.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(android.view.ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(android.view.ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public CustomGestureDetector(android.content.Context context, com.github.chrisbanes.photoview.OnGestureListener onGestureListener) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = viewConfiguration.getScaledTouchSlop();
        this.j = onGestureListener;
        this.c = new android.view.ScaleGestureDetector(context, new com.github.chrisbanes.photoview.CustomGestureDetector.AnonymousClass1());
    }

    public final float b(android.view.MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (java.lang.Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float c(android.view.MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (java.lang.Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.c.isInProgress();
    }

    public boolean f(android.view.MotionEvent motionEvent) {
        try {
            this.c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (java.lang.IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean g(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            android.view.VelocityTracker obtain = android.view.VelocityTracker.obtain();
            this.d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.e && this.d != null) {
                this.f = b(motionEvent);
                this.g = c(motionEvent);
                this.d.addMovement(motionEvent);
                this.d.computeCurrentVelocity(1000);
                float xVelocity = this.d.getXVelocity();
                float yVelocity = this.d.getYVelocity();
                if (java.lang.Math.max(java.lang.Math.abs(xVelocity), java.lang.Math.abs(yVelocity)) >= this.i) {
                    this.j.a(this.f, this.g, -xVelocity, -yVelocity);
                }
            }
            android.view.VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.d = null;
            }
        } else if (action == 2) {
            float b = b(motionEvent);
            float c = c(motionEvent);
            float f = b - this.f;
            float f2 = c - this.g;
            if (!this.e) {
                this.e = java.lang.Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.h);
            }
            if (this.e) {
                this.j.onDrag(f, f2);
                this.f = b;
                this.g = c;
                android.view.VelocityTracker velocityTracker2 = this.d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            android.view.VelocityTracker velocityTracker3 = this.d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.d = null;
            }
        } else if (action == 6) {
            int b2 = com.github.chrisbanes.photoview.Util.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b2) == this.a) {
                int i = b2 == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i);
                this.f = motionEvent.getX(i);
                this.g = motionEvent.getY(i);
            }
        }
        int i2 = this.a;
        this.b = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return true;
    }
}
