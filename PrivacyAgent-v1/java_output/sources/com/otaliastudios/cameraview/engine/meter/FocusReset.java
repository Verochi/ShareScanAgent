package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class FocusReset extends com.otaliastudios.cameraview.engine.meter.BaseReset {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.FocusReset.class.getSimpleName());

    public FocusReset() {
        super(true);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.Nullable android.hardware.camera2.params.MeteringRectangle meteringRectangle) {
        boolean z;
        int intValue = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z2 = true;
        if (meteringRectangle == null || intValue <= 0) {
            z = false;
        } else {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS, new android.hardware.camera2.params.MeteringRectangle[]{meteringRectangle});
            z = true;
        }
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        java.lang.Integer num = lastResult == null ? null : (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_TRIGGER);
        f.w("onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z2 = z;
        } else {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z2) {
            actionHolder.applyBuilder(this);
        }
        setState(Integer.MAX_VALUE);
    }
}
