package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public interface ActionHolder {
    void addAction(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);

    void applyBuilder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);

    void applyBuilder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder) throws android.hardware.camera2.CameraAccessException;

    @androidx.annotation.NonNull
    android.hardware.camera2.CaptureRequest.Builder getBuilder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);

    @androidx.annotation.NonNull
    android.hardware.camera2.CameraCharacteristics getCharacteristics(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);

    @androidx.annotation.Nullable
    android.hardware.camera2.TotalCaptureResult getLastResult(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);

    void removeAction(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);
}
