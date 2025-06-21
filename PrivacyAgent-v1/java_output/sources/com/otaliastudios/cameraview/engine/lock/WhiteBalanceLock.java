package com.otaliastudios.cameraview.engine.lock;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class WhiteBalanceLock extends com.otaliastudios.cameraview.engine.lock.BaseLock {
    public static final com.otaliastudios.cameraview.CameraLogger e = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.lock.WhiteBalanceLock.class.getSimpleName());

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        boolean z = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        java.lang.Integer num = (java.lang.Integer) actionHolder.getBuilder(this).get(android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE);
        boolean z2 = z && num != null && num.intValue() == 1;
        e.i("checkIsSupported:", java.lang.Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            e.i("checkShouldSkip: false - lastResult is null.");
            return false;
        }
        java.lang.Integer num = (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AWB_STATE);
        boolean z = num != null && num.intValue() == 3;
        e.i("checkShouldSkip:", java.lang.Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AWB_STATE);
        e.i("processCapture:", "awbState:", num);
        if (num != null && num.intValue() == 3) {
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, java.lang.Boolean.TRUE);
        actionHolder.applyBuilder(this);
    }
}
