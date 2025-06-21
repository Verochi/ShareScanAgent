package com.otaliastudios.cameraview.gesture;

/* loaded from: classes19.dex */
public class TapGestureFinder extends com.otaliastudios.cameraview.gesture.GestureFinder {
    public android.view.GestureDetector e;
    public boolean f;

    /* renamed from: com.otaliastudios.cameraview.gesture.TapGestureFinder$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            com.otaliastudios.cameraview.gesture.TapGestureFinder.this.f = true;
            com.otaliastudios.cameraview.gesture.TapGestureFinder.this.setGesture(com.otaliastudios.cameraview.gesture.Gesture.LONG_TAP);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            com.otaliastudios.cameraview.gesture.TapGestureFinder.this.f = true;
            com.otaliastudios.cameraview.gesture.TapGestureFinder.this.setGesture(com.otaliastudios.cameraview.gesture.Gesture.TAP);
            return true;
        }
    }

    public TapGestureFinder(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureFinder.Controller controller) {
        super(controller, 1);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(controller.getContext(), new com.otaliastudios.cameraview.gesture.TapGestureFinder.AnonymousClass1());
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public float getValue(float f, float f2, float f3) {
        return 0.0f;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public boolean handleTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (!this.f) {
            return false;
        }
        getPoint(0).x = motionEvent.getX();
        getPoint(0).y = motionEvent.getY();
        return true;
    }
}
