package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class FocusMeter extends com.otaliastudios.cameraview.engine.meter.BaseMeter {
    public static final com.otaliastudios.cameraview.CameraLogger i = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.FocusMeter.class.getSimpleName());

    public FocusMeter(@androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        java.lang.Integer num = (java.lang.Integer) actionHolder.getBuilder(this).get(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE);
        boolean z = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        i.i("checkIsSupported:", java.lang.Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            i.i("checkShouldSkip: false - lastResult is null.");
            return false;
        }
        java.lang.Integer num = (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_STATE);
        boolean z = num != null && (num.intValue() == 4 || num.intValue() == 2);
        i.i("checkShouldSkip:", java.lang.Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_STATE);
        i.i("onCaptureCompleted:", "afState:", num);
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 4) {
            setSuccessful(true);
            setState(Integer.MAX_VALUE);
        } else {
            if (intValue != 5) {
                return;
            }
            setSuccessful(false);
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onCompleted(actionHolder);
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list) {
        i.i("onStarted:", "with areas:", list);
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int intValue = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS, list.subList(0, java.lang.Math.min(intValue, list.size())).toArray(new android.hardware.camera2.params.MeteringRectangle[0]));
        }
        actionHolder.applyBuilder(this);
    }
}
