package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class LogAction extends com.otaliastudios.cameraview.engine.action.BaseAction {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.CameraEngine.class.getSimpleName());
    public java.lang.String e;

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_MODE);
        java.lang.Integer num2 = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
        java.lang.Integer num3 = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_STATE);
        java.lang.String str = "aeMode: " + num + " aeLock: " + ((java.lang.Boolean) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + num2 + " aeTriggerState: " + ((java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + num3 + " afTriggerState: " + ((java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_TRIGGER));
        if (str.equals(this.e)) {
            return;
        }
        this.e = str;
        f.i(str);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onCompleted(actionHolder);
        setState(0);
        start(actionHolder);
    }
}
