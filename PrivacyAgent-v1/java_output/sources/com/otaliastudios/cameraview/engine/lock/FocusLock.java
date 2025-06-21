package com.otaliastudios.cameraview.engine.lock;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class FocusLock extends com.otaliastudios.cameraview.engine.lock.BaseLock {
    public static final com.otaliastudios.cameraview.CameraLogger e = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.lock.FocusLock.class.getSimpleName());

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        for (int i : (int[]) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            e.i("checkShouldSkip: false - lastResult is null.");
            return false;
        }
        java.lang.Integer num = (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_STATE);
        boolean z = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
        java.lang.Integer num2 = (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_MODE);
        boolean z2 = z && (num2 != null && num2.intValue() == 1);
        e.i("checkShouldSkip:", java.lang.Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_STATE);
        java.lang.Integer num2 = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_MODE);
        e.i("onCapture:", "afState:", num, "afMode:", num2);
        if (num == null || num2 == null || num2.intValue() != 1) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 2 || intValue == 4 || intValue == 5 || intValue == 6) {
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 1);
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 2);
        actionHolder.applyBuilder(this);
    }
}
