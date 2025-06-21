package com.otaliastudios.cameraview.gesture;

/* loaded from: classes19.dex */
public abstract class GestureFinder {
    public boolean a;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.gesture.Gesture b;
    public android.graphics.PointF[] c;
    public com.otaliastudios.cameraview.gesture.GestureFinder.Controller d;

    public interface Controller {
        @androidx.annotation.NonNull
        android.content.Context getContext();

        int getHeight();

        int getWidth();
    }

    public GestureFinder(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureFinder.Controller controller, int i) {
        this.d = controller;
        this.c = new android.graphics.PointF[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.c[i2] = new android.graphics.PointF(0.0f, 0.0f);
        }
    }

    public static float a(float f, float f2, float f3, float f4) {
        if (f2 < f3) {
            f2 = f3;
        }
        if (f2 > f4) {
            f2 = f4;
        }
        float f5 = ((f4 - f3) / 50.0f) / 2.0f;
        return (f2 < f - f5 || f2 > f5 + f) ? f2 : f;
    }

    public final float computeValue(float f, float f2, float f3) {
        return a(f, getValue(f, f2, f3), f2, f3);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.gesture.GestureFinder.Controller getController() {
        return this.d;
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.gesture.Gesture getGesture() {
        return this.b;
    }

    @androidx.annotation.NonNull
    public final android.graphics.PointF getPoint(int i) {
        return this.c[i];
    }

    @androidx.annotation.NonNull
    public final android.graphics.PointF[] getPoints() {
        return this.c;
    }

    public abstract float getValue(float f, float f2, float f3);

    public abstract boolean handleTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent);

    public boolean isActive() {
        return this.a;
    }

    public final boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (this.a) {
            return handleTouchEvent(motionEvent);
        }
        return false;
    }

    public void setActive(boolean z) {
        this.a = z;
    }

    public final void setGesture(com.otaliastudios.cameraview.gesture.Gesture gesture) {
        this.b = gesture;
    }
}
