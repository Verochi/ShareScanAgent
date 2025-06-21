package com.otaliastudios.cameraview.picture;

/* loaded from: classes19.dex */
public abstract class PictureRecorder {
    protected java.lang.Exception mError;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.otaliastudios.cameraview.PictureResult.Stub n;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener t;

    public interface PictureResultListener {
        void onPictureResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc);

        void onPictureShutter(boolean z);
    }

    public PictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.Nullable com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener pictureResultListener) {
        this.n = stub;
        this.t = pictureResultListener;
    }

    public void dispatchOnShutter(boolean z) {
        com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener pictureResultListener = this.t;
        if (pictureResultListener != null) {
            pictureResultListener.onPictureShutter(z);
        }
    }

    public void dispatchResult() {
        com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener pictureResultListener = this.t;
        if (pictureResultListener != null) {
            pictureResultListener.onPictureResult(this.n, this.mError);
            this.t = null;
            this.n = null;
        }
    }

    public abstract void take();
}
