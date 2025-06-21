package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
class SequenceAction extends com.otaliastudios.cameraview.engine.action.BaseAction {
    public final java.util.List<com.otaliastudios.cameraview.engine.action.BaseAction> e;
    public int f = -1;

    /* renamed from: com.otaliastudios.cameraview.engine.action.SequenceAction$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.engine.action.ActionCallback {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
        public void onActionStateChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action, int i) {
            if (i == Integer.MAX_VALUE) {
                action.removeCallback(this);
                com.otaliastudios.cameraview.engine.action.SequenceAction.this.b();
            }
        }
    }

    public SequenceAction(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.engine.action.BaseAction> list) {
        this.e = list;
        b();
    }

    public final void b() {
        int i = this.f;
        boolean z = i == -1;
        if (i == this.e.size() - 1) {
            setState(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f + 1;
        this.f = i2;
        this.e.get(i2).addCallback(new com.otaliastudios.cameraview.engine.action.SequenceAction.AnonymousClass1());
        if (z) {
            return;
        }
        this.e.get(this.f).onStart(getHolder());
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onAbort(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onAbort(actionHolder);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onAbort(actionHolder);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.CaptureResult captureResult) {
        super.onCaptureProgressed(actionHolder, captureRequest, captureResult);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onCaptureProgressed(actionHolder, captureRequest, captureResult);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest) {
        super.onCaptureStarted(actionHolder, captureRequest);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onCaptureStarted(actionHolder, captureRequest);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onStart(actionHolder);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onStart(actionHolder);
        }
    }
}
