package com.otaliastudios.cameraview.gesture;

/* loaded from: classes19.dex */
public class ScrollGestureFinder extends com.otaliastudios.cameraview.gesture.GestureFinder {
    public static final com.otaliastudios.cameraview.CameraLogger h = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.gesture.ScrollGestureFinder.class.getSimpleName());
    public android.view.GestureDetector e;
    public boolean f;
    public float g;

    /* renamed from: com.otaliastudios.cameraview.gesture.ScrollGestureFinder$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ com.otaliastudios.cameraview.gesture.GestureFinder.Controller n;

        public AnonymousClass1(com.otaliastudios.cameraview.gesture.GestureFinder.Controller controller) {
            this.n = controller;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            boolean z = false;
            com.otaliastudios.cameraview.gesture.ScrollGestureFinder.h.i("onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() != com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.getPoint(0).x || motionEvent.getY() != com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.getPoint(0).y) {
                boolean z2 = java.lang.Math.abs(f) >= java.lang.Math.abs(f2);
                com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.setGesture(z2 ? com.otaliastudios.cameraview.gesture.Gesture.SCROLL_HORIZONTAL : com.otaliastudios.cameraview.gesture.Gesture.SCROLL_VERTICAL);
                com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.getPoint(0).set(motionEvent.getX(), motionEvent.getY());
                z = z2;
            } else if (com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.getGesture() == com.otaliastudios.cameraview.gesture.Gesture.SCROLL_HORIZONTAL) {
                z = true;
            }
            com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.getPoint(1).set(motionEvent2.getX(), motionEvent2.getY());
            com.otaliastudios.cameraview.gesture.ScrollGestureFinder scrollGestureFinder = com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this;
            com.otaliastudios.cameraview.gesture.GestureFinder.Controller controller = this.n;
            scrollGestureFinder.g = z ? f / controller.getWidth() : f2 / controller.getHeight();
            com.otaliastudios.cameraview.gesture.ScrollGestureFinder scrollGestureFinder2 = com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this;
            float f3 = scrollGestureFinder2.g;
            if (z) {
                f3 = -f3;
            }
            scrollGestureFinder2.g = f3;
            com.otaliastudios.cameraview.gesture.ScrollGestureFinder.this.f = true;
            return true;
        }
    }

    public ScrollGestureFinder(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureFinder.Controller controller) {
        super(controller, 2);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(controller.getContext(), new com.otaliastudios.cameraview.gesture.ScrollGestureFinder.AnonymousClass1(controller));
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    public float getFactor() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public float getValue(float f, float f2, float f3) {
        return f + (getFactor() * (f3 - f2) * 2.0f);
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public boolean handleTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            h.i("Notifying a gesture of type", getGesture().name());
        }
        return this.f;
    }
}
