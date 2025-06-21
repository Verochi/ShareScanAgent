package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
class TimeoutAction extends com.otaliastudios.cameraview.engine.action.ActionWrapper {
    public long e;
    public long f;
    public com.otaliastudios.cameraview.engine.action.BaseAction g;

    public TimeoutAction(long j, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.BaseAction baseAction) {
        this.f = j;
        this.g = baseAction;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.action.BaseAction getAction() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        if (isCompleted() || java.lang.System.currentTimeMillis() <= this.e + this.f) {
            return;
        }
        getAction().abort(actionHolder);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        this.e = java.lang.System.currentTimeMillis();
        super.onStart(actionHolder);
    }
}
