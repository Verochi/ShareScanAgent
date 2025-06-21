package com.otaliastudios.cameraview.video;

/* loaded from: classes19.dex */
public class Full1VideoRecorder extends com.otaliastudios.cameraview.video.FullVideoRecorder {
    public final com.otaliastudios.cameraview.engine.Camera1Engine h;
    public final android.hardware.Camera i;
    public final int j;

    public Full1VideoRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.Camera1Engine camera1Engine, @androidx.annotation.NonNull android.hardware.Camera camera, int i) {
        super(camera1Engine);
        this.i = camera;
        this.h = camera1Engine;
        this.j = i;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    public void applyVideoSource(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull android.media.MediaRecorder mediaRecorder) {
        mediaRecorder.setCamera(this.i);
        mediaRecorder.setVideoSource(1);
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    @androidx.annotation.NonNull
    public android.media.CamcorderProfile getCamcorderProfile(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        int i = stub.rotation % 180;
        com.otaliastudios.cameraview.size.Size size = stub.size;
        if (i != 0) {
            size = size.flip();
        }
        return com.otaliastudios.cameraview.internal.CamcorderProfiles.get(this.j, size);
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onDispatchResult() {
        this.i.setPreviewCallbackWithBuffer(this.h);
        super.onDispatchResult();
    }
}
