package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class ek implements com.otaliastudios.cameraview.frame.FrameProcessor {
    public final /* synthetic */ com.moji.camera2.CameraAndVideoActivity a;

    public /* synthetic */ ek(com.moji.camera2.CameraAndVideoActivity cameraAndVideoActivity) {
        this.a = cameraAndVideoActivity;
    }

    @Override // com.otaliastudios.cameraview.frame.FrameProcessor
    public final void process(com.otaliastudios.cameraview.frame.Frame frame) {
        com.moji.camera2.CameraAndVideoActivity.c(this.a, frame);
    }
}
