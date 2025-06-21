package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public abstract class ActionWrapper extends com.otaliastudios.cameraview.engine.action.BaseAction {

    /* renamed from: com.otaliastudios.cameraview.engine.action.ActionWrapper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.engine.action.ActionCallback {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
        public void onActionStateChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action, int i) {
            com.otaliastudios.cameraview.engine.action.ActionWrapper.this.setState(i);
            if (i == Integer.MAX_VALUE) {
                action.removeCallback(this);
            }
        }
    }

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.engine.action.BaseAction getAction();

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onAbort(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onAbort(actionHolder);
        getAction().onAbort(actionHolder);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        getAction().onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.CaptureResult captureResult) {
        super.onCaptureProgressed(actionHolder, captureRequest, captureResult);
        getAction().onCaptureProgressed(actionHolder, captureRequest, captureResult);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest) {
        super.onCaptureStarted(actionHolder, captureRequest);
        getAction().onCaptureStarted(actionHolder, captureRequest);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onStart(actionHolder);
        getAction().addCallback(new com.otaliastudios.cameraview.engine.action.ActionWrapper.AnonymousClass1());
        getAction().onStart(actionHolder);
    }
}
