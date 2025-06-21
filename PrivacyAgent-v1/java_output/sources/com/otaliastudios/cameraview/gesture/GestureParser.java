package com.otaliastudios.cameraview.gesture;

/* loaded from: classes19.dex */
public class GestureParser {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public GestureParser(@androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        this.a = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGestureTap, com.otaliastudios.cameraview.gesture.GestureAction.DEFAULT_TAP.value());
        this.b = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGestureLongTap, com.otaliastudios.cameraview.gesture.GestureAction.DEFAULT_LONG_TAP.value());
        this.c = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGesturePinch, com.otaliastudios.cameraview.gesture.GestureAction.DEFAULT_PINCH.value());
        this.d = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGestureScrollHorizontal, com.otaliastudios.cameraview.gesture.GestureAction.DEFAULT_SCROLL_HORIZONTAL.value());
        this.e = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGestureScrollVertical, com.otaliastudios.cameraview.gesture.GestureAction.DEFAULT_SCROLL_VERTICAL.value());
    }

    public final com.otaliastudios.cameraview.gesture.GestureAction a(int i) {
        return com.otaliastudios.cameraview.gesture.GestureAction.fromValue(i);
    }

    public com.otaliastudios.cameraview.gesture.GestureAction getHorizontalScrollAction() {
        return a(this.d);
    }

    public com.otaliastudios.cameraview.gesture.GestureAction getLongTapAction() {
        return a(this.b);
    }

    public com.otaliastudios.cameraview.gesture.GestureAction getPinchAction() {
        return a(this.c);
    }

    public com.otaliastudios.cameraview.gesture.GestureAction getTapAction() {
        return a(this.a);
    }

    public com.otaliastudios.cameraview.gesture.GestureAction getVerticalScrollAction() {
        return a(this.e);
    }
}
