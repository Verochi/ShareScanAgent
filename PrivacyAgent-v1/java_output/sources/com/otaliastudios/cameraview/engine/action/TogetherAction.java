package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
class TogetherAction extends com.otaliastudios.cameraview.engine.action.BaseAction {
    public final java.util.List<com.otaliastudios.cameraview.engine.action.BaseAction> e;
    public final java.util.List<com.otaliastudios.cameraview.engine.action.BaseAction> f;

    /* renamed from: com.otaliastudios.cameraview.engine.action.TogetherAction$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.engine.action.ActionCallback {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
        public void onActionStateChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action, int i) {
            if (i == Integer.MAX_VALUE) {
                com.otaliastudios.cameraview.engine.action.TogetherAction.this.f.remove(action);
            }
            if (com.otaliastudios.cameraview.engine.action.TogetherAction.this.f.isEmpty()) {
                com.otaliastudios.cameraview.engine.action.TogetherAction.this.setState(Integer.MAX_VALUE);
            }
        }
    }

    public TogetherAction(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.engine.action.BaseAction> list) {
        this.e = new java.util.ArrayList(list);
        this.f = new java.util.ArrayList(list);
        java.util.Iterator<com.otaliastudios.cameraview.engine.action.BaseAction> it = list.iterator();
        while (it.hasNext()) {
            it.next().addCallback(new com.otaliastudios.cameraview.engine.action.TogetherAction.AnonymousClass1());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onAbort(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onAbort(actionHolder);
        for (com.otaliastudios.cameraview.engine.action.BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onAbort(actionHolder);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        for (com.otaliastudios.cameraview.engine.action.BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.CaptureResult captureResult) {
        super.onCaptureProgressed(actionHolder, captureRequest, captureResult);
        for (com.otaliastudios.cameraview.engine.action.BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onCaptureProgressed(actionHolder, captureRequest, captureResult);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest) {
        super.onCaptureStarted(actionHolder, captureRequest);
        for (com.otaliastudios.cameraview.engine.action.BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onCaptureStarted(actionHolder, captureRequest);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onStart(actionHolder);
        for (com.otaliastudios.cameraview.engine.action.BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onStart(actionHolder);
            }
        }
    }
}
