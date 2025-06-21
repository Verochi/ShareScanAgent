package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class ExposureReset extends com.otaliastudios.cameraview.engine.meter.BaseReset {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.ExposureReset.class.getSimpleName());

    public ExposureReset() {
        super(true);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        if (getState() == 0) {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_LOCK, java.lang.Boolean.FALSE);
            actionHolder.applyBuilder(this);
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.Nullable android.hardware.camera2.params.MeteringRectangle meteringRectangle) {
        int intValue = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS, new android.hardware.camera2.params.MeteringRectangle[]{meteringRectangle});
        }
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        java.lang.Integer num = lastResult == null ? null : (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        com.otaliastudios.cameraview.CameraLogger cameraLogger = f;
        cameraLogger.i("onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            cameraLogger.i("onStarted:", "canceling precapture.");
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT < 23 ? 0 : 2));
        }
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_LOCK, java.lang.Boolean.TRUE);
        actionHolder.applyBuilder(this);
        setState(0);
    }
}
