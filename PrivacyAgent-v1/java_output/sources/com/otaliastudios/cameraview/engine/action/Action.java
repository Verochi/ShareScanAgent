package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public interface Action {
    public static final int STATE_COMPLETED = Integer.MAX_VALUE;

    void abort(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);

    void addCallback(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionCallback actionCallback);

    int getState();

    void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult);

    void onCaptureProgressed(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.CaptureResult captureResult);

    void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest);

    void removeCallback(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionCallback actionCallback);

    void start(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);
}
