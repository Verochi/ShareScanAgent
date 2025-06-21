package com.otaliastudios.cameraview.gesture;

/* loaded from: classes19.dex */
public class PinchGestureFinder extends com.otaliastudios.cameraview.gesture.GestureFinder {
    public android.view.ScaleGestureDetector e;
    public boolean f;
    public float g;

    /* renamed from: com.otaliastudios.cameraview.gesture.PinchGestureFinder$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
            com.otaliastudios.cameraview.gesture.PinchGestureFinder.this.f = true;
            com.otaliastudios.cameraview.gesture.PinchGestureFinder.this.g = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public PinchGestureFinder(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureFinder.Controller controller) {
        super(controller, 2);
        this.g = 0.0f;
        setGesture(com.otaliastudios.cameraview.gesture.Gesture.PINCH);
        android.view.ScaleGestureDetector scaleGestureDetector = new android.view.ScaleGestureDetector(controller.getContext(), new com.otaliastudios.cameraview.gesture.PinchGestureFinder.AnonymousClass1());
        this.e = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    public float getFactor() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public float getValue(float f, float f2, float f3) {
        return f + (getFactor() * (f3 - f2));
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public boolean handleTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            getPoint(0).x = motionEvent.getX(0);
            getPoint(0).y = motionEvent.getY(0);
            z = true;
            if (motionEvent.getPointerCount() > 1) {
                getPoint(1).x = motionEvent.getX(1);
                getPoint(1).y = motionEvent.getY(1);
            }
        }
        return z;
    }
}
