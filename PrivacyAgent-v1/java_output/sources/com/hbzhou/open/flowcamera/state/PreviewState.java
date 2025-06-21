package com.hbzhou.open.flowcamera.state;

/* loaded from: classes22.dex */
class PreviewState implements com.hbzhou.open.flowcamera.state.State {
    public com.hbzhou.open.flowcamera.state.CameraMachine a;

    /* renamed from: com.hbzhou.open.flowcamera.state.PreviewState$1, reason: invalid class name */
    public class AnonymousClass1 implements com.hbzhou.open.flowcamera.CameraInterface.TakePictureCallback {
        public AnonymousClass1() {
        }

        @Override // com.hbzhou.open.flowcamera.CameraInterface.TakePictureCallback
        public void captureResult(android.graphics.Bitmap bitmap, boolean z) {
            com.hbzhou.open.flowcamera.state.PreviewState.this.a.getView().showPicture(bitmap, z);
            com.hbzhou.open.flowcamera.state.PreviewState.this.a.setState(com.hbzhou.open.flowcamera.state.PreviewState.this.a.a());
            com.hbzhou.open.flowcamera.util.LogUtil.i("capture");
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.state.PreviewState$2, reason: invalid class name */
    public class AnonymousClass2 implements com.hbzhou.open.flowcamera.CameraInterface.StopRecordCallback {
        public final /* synthetic */ boolean a;

        public AnonymousClass2(boolean z) {
            this.a = z;
        }

        @Override // com.hbzhou.open.flowcamera.CameraInterface.StopRecordCallback
        public void recordResult(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (this.a) {
                com.hbzhou.open.flowcamera.state.PreviewState.this.a.getView().resetState(3);
            } else {
                com.hbzhou.open.flowcamera.state.PreviewState.this.a.getView().playVideo(bitmap, str);
                com.hbzhou.open.flowcamera.state.PreviewState.this.a.setState(com.hbzhou.open.flowcamera.state.PreviewState.this.a.b());
            }
        }
    }

    public PreviewState(com.hbzhou.open.flowcamera.state.CameraMachine cameraMachine) {
        this.a = cameraMachine;
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void cancle(android.view.SurfaceHolder surfaceHolder, float f) {
        com.hbzhou.open.flowcamera.util.LogUtil.i("浏览状态下,没有 cancle 事件");
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void capture() {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().takePicture(new com.hbzhou.open.flowcamera.state.PreviewState.AnonymousClass1());
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void confirm() {
        com.hbzhou.open.flowcamera.util.LogUtil.i("浏览状态下,没有 confirm 事件");
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void flash(java.lang.String str) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().setFlashMode(str);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void foucs(float f, float f2, com.hbzhou.open.flowcamera.CameraInterface.FocusCallback focusCallback) {
        com.hbzhou.open.flowcamera.util.LogUtil.i("preview state foucs");
        if (this.a.getView().handlerFoucs(f, f2)) {
            com.hbzhou.open.flowcamera.CameraInterface.getInstance().handleFocus(this.a.getContext(), f, f2, focusCallback);
        }
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void record(android.view.Surface surface, float f) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().startRecord(surface, f, null);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void restart() {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void start(android.view.SurfaceHolder surfaceHolder, float f) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void stop() {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().doStopPreview();
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void stopRecord(boolean z, long j) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().stopRecord(z, new com.hbzhou.open.flowcamera.state.PreviewState.AnonymousClass2(z));
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void swtich(android.view.SurfaceHolder surfaceHolder, float f) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().switchCamera(surfaceHolder, f);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void zoom(float f, int i) {
        com.hbzhou.open.flowcamera.util.LogUtil.i("PreviewState", "zoom");
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().setZoom(f, i);
    }
}
