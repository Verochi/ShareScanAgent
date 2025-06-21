package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public abstract class CameraListener {
    @androidx.annotation.UiThread
    public void onAutoFocusEnd(boolean z, @androidx.annotation.NonNull android.graphics.PointF pointF) {
    }

    @androidx.annotation.UiThread
    public void onAutoFocusStart(@androidx.annotation.NonNull android.graphics.PointF pointF) {
    }

    @androidx.annotation.UiThread
    public void onCameraClosed() {
    }

    @androidx.annotation.UiThread
    public void onCameraError(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraException cameraException) {
    }

    @androidx.annotation.UiThread
    public void onCameraOpened(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraOptions cameraOptions) {
    }

    @androidx.annotation.UiThread
    public void onExposureCorrectionChanged(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr) {
    }

    @androidx.annotation.UiThread
    public void onOrientationChanged(int i) {
    }

    @androidx.annotation.UiThread
    public void onPictureTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult pictureResult) {
    }

    @androidx.annotation.UiThread
    public void onVideoRecordingEnd() {
    }

    @androidx.annotation.UiThread
    public void onVideoRecordingStart() {
    }

    @androidx.annotation.UiThread
    public void onVideoTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult videoResult) {
    }

    @androidx.annotation.UiThread
    public void onZoomChanged(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr) {
    }
}
