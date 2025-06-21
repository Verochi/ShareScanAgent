package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public abstract class BaseReset extends com.otaliastudios.cameraview.engine.action.BaseAction {
    public boolean e;

    public BaseReset(boolean z) {
        this.e = z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onStart(actionHolder);
        onStarted(actionHolder, this.e ? new android.hardware.camera2.params.MeteringRectangle((android.graphics.Rect) readCharacteristic(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new android.graphics.Rect()), 0) : null);
    }

    public abstract void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.Nullable android.hardware.camera2.params.MeteringRectangle meteringRectangle);
}
