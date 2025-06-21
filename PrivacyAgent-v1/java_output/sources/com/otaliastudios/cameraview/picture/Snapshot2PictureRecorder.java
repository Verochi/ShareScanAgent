package com.otaliastudios.cameraview.picture;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Snapshot2PictureRecorder extends com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder {
    public final com.otaliastudios.cameraview.engine.action.Action A;
    public final com.otaliastudios.cameraview.engine.action.ActionHolder B;
    public final boolean C;
    public java.lang.Integer D;
    public java.lang.Integer E;

    /* renamed from: com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder$1, reason: invalid class name */
    public class AnonymousClass1 extends com.otaliastudios.cameraview.engine.action.CompletionCallback {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
            com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("Taking picture with super.take().");
            com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.super.take();
        }
    }

    public class FlashAction extends com.otaliastudios.cameraview.engine.action.BaseAction {
        public FlashAction() {
        }

        public /* synthetic */ FlashAction(com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder snapshot2PictureRecorder, com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.FLASH_STATE);
            if (num == null) {
                com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.w("FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                setState(Integer.MAX_VALUE);
            } else if (num.intValue() != 3) {
                com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            } else {
                com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                setState(Integer.MAX_VALUE);
            }
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
            super.onStart(actionHolder);
            com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("FlashAction:", "Parameters locked, opening torch.");
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.FLASH_MODE, 2);
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, 1);
            actionHolder.applyBuilder(this);
        }
    }

    public class ResetFlashAction extends com.otaliastudios.cameraview.engine.action.BaseAction {
        public ResetFlashAction() {
        }

        public /* synthetic */ ResetFlashAction(com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder snapshot2PictureRecorder, com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
            super.onStart(actionHolder);
            try {
                com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("ResetFlashAction:", "Reverting the flash changes.");
                android.hardware.camera2.CaptureRequest.Builder builder = actionHolder.getBuilder(this);
                builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(android.hardware.camera2.CaptureRequest.FLASH_MODE, 0);
                actionHolder.applyBuilder(this, builder);
                builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.this.D);
                builder.set(android.hardware.camera2.CaptureRequest.FLASH_MODE, com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.this.E);
                actionHolder.applyBuilder(this);
            } catch (android.hardware.camera2.CameraAccessException unused) {
            }
        }
    }

    public Snapshot2PictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine, @androidx.annotation.NonNull com.otaliastudios.cameraview.preview.RendererCameraPreview rendererCameraPreview, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio) {
        super(stub, camera2Engine, rendererCameraPreview, aspectRatio, camera2Engine.getOverlay());
        this.B = camera2Engine;
        boolean z = false;
        com.otaliastudios.cameraview.engine.action.BaseAction sequence = com.otaliastudios.cameraview.engine.action.Actions.sequence(com.otaliastudios.cameraview.engine.action.Actions.timeout(2500L, new com.otaliastudios.cameraview.engine.lock.LockAction()), new com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.FlashAction(this, null));
        this.A = sequence;
        sequence.addCallback(new com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.AnonymousClass1());
        android.hardware.camera2.TotalCaptureResult lastResult = camera2Engine.getLastResult(sequence);
        if (lastResult == null) {
            com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.w("Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        java.lang.Integer num = lastResult != null ? (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE) : null;
        if (camera2Engine.getPictureSnapshotMetering() && num != null && num.intValue() == 4) {
            z = true;
        }
        this.C = z;
        this.D = (java.lang.Integer) camera2Engine.getBuilder(sequence).get(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE);
        this.E = (java.lang.Integer) camera2Engine.getBuilder(sequence).get(android.hardware.camera2.CaptureRequest.FLASH_MODE);
    }

    @Override // com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder, com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        new com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.ResetFlashAction(this, null).start(this.B);
        super.dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder, com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        if (this.C) {
            com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("take:", "Engine needs flash. Starting action");
            this.A.start(this.B);
        } else {
            com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.take();
        }
    }
}
