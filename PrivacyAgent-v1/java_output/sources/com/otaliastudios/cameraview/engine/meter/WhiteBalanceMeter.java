package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class WhiteBalanceMeter extends com.otaliastudios.cameraview.engine.meter.BaseMeter {
    public static final com.otaliastudios.cameraview.CameraLogger i = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.WhiteBalanceMeter.class.getSimpleName());

    public WhiteBalanceMeter(@androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        boolean z = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        java.lang.Integer num = (java.lang.Integer) actionHolder.getBuilder(this).get(android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE);
        boolean z2 = z && num != null && num.intValue() == 1;
        i.i("checkIsSupported:", java.lang.Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            i.i("checkShouldSkip: false - lastResult is null.");
            return false;
        }
        java.lang.Integer num = (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AWB_STATE);
        boolean z = num != null && num.intValue() == 2;
        i.i("checkShouldSkip:", java.lang.Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AWB_STATE);
        i.i("onCaptureCompleted:", "awbState:", num);
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 2) {
            setSuccessful(true);
            setState(Integer.MAX_VALUE);
        } else {
            if (intValue != 3) {
                return;
            }
            setSuccessful(false);
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list) {
        i.i("onStarted:", "with areas:", list);
        int intValue = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (list.isEmpty() || intValue <= 0) {
            return;
        }
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AWB_REGIONS, list.subList(0, java.lang.Math.min(intValue, list.size())).toArray(new android.hardware.camera2.params.MeteringRectangle[0]));
        actionHolder.applyBuilder(this);
    }
}
