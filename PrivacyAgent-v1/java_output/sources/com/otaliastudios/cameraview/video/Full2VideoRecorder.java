package com.otaliastudios.cameraview.video;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Full2VideoRecorder extends com.otaliastudios.cameraview.video.FullVideoRecorder {
    public com.otaliastudios.cameraview.engine.action.ActionHolder h;
    public final java.lang.String i;
    public android.view.Surface j;

    /* renamed from: com.otaliastudios.cameraview.video.Full2VideoRecorder$1, reason: invalid class name */
    public class AnonymousClass1 extends com.otaliastudios.cameraview.engine.action.BaseAction {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest) {
            super.onCaptureStarted(actionHolder, captureRequest);
            java.lang.Object tag = actionHolder.getBuilder(this).build().getTag();
            java.lang.Object tag2 = captureRequest.getTag();
            if (tag == null) {
                if (tag2 != null) {
                    return;
                }
            } else if (!tag.equals(tag2)) {
                return;
            }
            setState(Integer.MAX_VALUE);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.video.Full2VideoRecorder$2, reason: invalid class name */
    public class AnonymousClass2 extends com.otaliastudios.cameraview.engine.action.CompletionCallback {
        public AnonymousClass2() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
            com.otaliastudios.cameraview.video.Full2VideoRecorder.super.onStart();
        }
    }

    public class PrepareException extends java.lang.Exception {
        private PrepareException(java.lang.Throwable th) {
            super(th);
        }

        public /* synthetic */ PrepareException(com.otaliastudios.cameraview.video.Full2VideoRecorder full2VideoRecorder, java.lang.Throwable th, com.otaliastudios.cameraview.video.Full2VideoRecorder.AnonymousClass1 anonymousClass1) {
            this(th);
        }
    }

    public Full2VideoRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine, @androidx.annotation.NonNull java.lang.String str) {
        super(camera2Engine);
        this.h = camera2Engine;
        this.i = str;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    public void applyVideoSource(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull android.media.MediaRecorder mediaRecorder) {
        mediaRecorder.setVideoSource(2);
    }

    @androidx.annotation.NonNull
    public android.view.Surface createInputSurface(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) throws com.otaliastudios.cameraview.video.Full2VideoRecorder.PrepareException {
        if (!prepareMediaRecorder(stub)) {
            throw new com.otaliastudios.cameraview.video.Full2VideoRecorder.PrepareException(this, this.mError, null);
        }
        android.view.Surface surface = this.mMediaRecorder.getSurface();
        this.j = surface;
        return surface;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    @androidx.annotation.NonNull
    public android.media.CamcorderProfile getCamcorderProfile(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        int i = stub.rotation % 180;
        com.otaliastudios.cameraview.size.Size size = stub.size;
        if (i != 0) {
            size = size.flip();
        }
        return com.otaliastudios.cameraview.internal.CamcorderProfiles.get(this.i, size);
    }

    @androidx.annotation.Nullable
    public android.view.Surface getInputSurface() {
        return this.j;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder, com.otaliastudios.cameraview.video.VideoRecorder
    public void onStart() {
        com.otaliastudios.cameraview.video.Full2VideoRecorder.AnonymousClass1 anonymousClass1 = new com.otaliastudios.cameraview.video.Full2VideoRecorder.AnonymousClass1();
        anonymousClass1.addCallback(new com.otaliastudios.cameraview.video.Full2VideoRecorder.AnonymousClass2());
        anonymousClass1.start(this.h);
    }
}
