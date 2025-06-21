package com.otaliastudios.cameraview.video;

/* loaded from: classes19.dex */
public abstract class VideoRecorder {
    public static final com.otaliastudios.cameraview.CameraLogger e = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.VideoRecorder.class.getSimpleName());

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.otaliastudios.cameraview.VideoResult.Stub a;
    public final com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener b;
    protected java.lang.Exception mError;
    public final java.lang.Object d = new java.lang.Object();
    public int c = 0;

    public interface VideoResultListener {
        void onVideoRecordingEnd();

        void onVideoRecordingStart();

        void onVideoResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc);
    }

    public VideoRecorder(@androidx.annotation.Nullable com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener videoResultListener) {
        this.b = videoResultListener;
    }

    public final void dispatchResult() {
        synchronized (this.d) {
            if (!isRecording()) {
                e.w("dispatchResult:", "Called, but not recording! Aborting.");
                return;
            }
            com.otaliastudios.cameraview.CameraLogger cameraLogger = e;
            cameraLogger.i("dispatchResult:", "Changed state to STATE_IDLE.");
            this.c = 0;
            onDispatchResult();
            cameraLogger.i("dispatchResult:", "About to dispatch result:", this.a, this.mError);
            com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener videoResultListener = this.b;
            if (videoResultListener != null) {
                videoResultListener.onVideoResult(this.a, this.mError);
            }
            this.a = null;
            this.mError = null;
        }
    }

    @androidx.annotation.CallSuper
    public void dispatchVideoRecordingEnd() {
        e.i("dispatchVideoRecordingEnd:", "About to dispatch.");
        com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener videoResultListener = this.b;
        if (videoResultListener != null) {
            videoResultListener.onVideoRecordingEnd();
        }
    }

    @androidx.annotation.CallSuper
    public void dispatchVideoRecordingStart() {
        e.i("dispatchVideoRecordingStart:", "About to dispatch.");
        com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener videoResultListener = this.b;
        if (videoResultListener != null) {
            videoResultListener.onVideoRecordingStart();
        }
    }

    public boolean isRecording() {
        boolean z;
        synchronized (this.d) {
            z = this.c != 0;
        }
        return z;
    }

    public void onDispatchResult() {
    }

    public abstract void onStart();

    public abstract void onStop(boolean z);

    public final void start(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        synchronized (this.d) {
            int i = this.c;
            if (i != 0) {
                e.e("start:", "called twice, or while stopping! Ignoring. state:", java.lang.Integer.valueOf(i));
                return;
            }
            e.i("start:", "Changed state to STATE_RECORDING");
            this.c = 1;
            this.a = stub;
            onStart();
        }
    }

    public final void stop(boolean z) {
        synchronized (this.d) {
            if (this.c == 0) {
                e.e("stop:", "called twice, or called before start! Ignoring. isCameraShutdown:", java.lang.Boolean.valueOf(z));
                return;
            }
            e.i("stop:", "Changed state to STATE_STOPPING");
            this.c = 2;
            onStop(z);
        }
    }
}
