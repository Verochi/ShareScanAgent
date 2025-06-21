package com.hbzhou.open.flowcamera.state;

/* loaded from: classes22.dex */
public class CameraMachine implements com.hbzhou.open.flowcamera.state.State {
    public android.content.Context a;
    public com.hbzhou.open.flowcamera.view.CameraView c;
    public com.hbzhou.open.flowcamera.state.State d = new com.hbzhou.open.flowcamera.state.PreviewState(this);
    public com.hbzhou.open.flowcamera.state.State e = new com.hbzhou.open.flowcamera.state.BorrowPictureState(this);
    public com.hbzhou.open.flowcamera.state.State f = new com.hbzhou.open.flowcamera.state.BorrowVideoState(this);
    public com.hbzhou.open.flowcamera.state.State b = this.d;

    public CameraMachine(android.content.Context context, com.hbzhou.open.flowcamera.view.CameraView cameraView, com.hbzhou.open.flowcamera.CameraInterface.CameraOpenOverCallback cameraOpenOverCallback) {
        this.a = context;
        this.c = cameraView;
    }

    public com.hbzhou.open.flowcamera.state.State a() {
        return this.e;
    }

    public com.hbzhou.open.flowcamera.state.State b() {
        return this.f;
    }

    public com.hbzhou.open.flowcamera.state.State c() {
        return this.d;
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void cancle(android.view.SurfaceHolder surfaceHolder, float f) {
        this.b.cancle(surfaceHolder, f);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void capture() {
        this.b.capture();
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void confirm() {
        this.b.confirm();
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void flash(java.lang.String str) {
        this.b.flash(str);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void foucs(float f, float f2, com.hbzhou.open.flowcamera.CameraInterface.FocusCallback focusCallback) {
        this.b.foucs(f, f2, focusCallback);
    }

    public android.content.Context getContext() {
        return this.a;
    }

    public com.hbzhou.open.flowcamera.state.State getState() {
        return this.b;
    }

    public com.hbzhou.open.flowcamera.view.CameraView getView() {
        return this.c;
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void record(android.view.Surface surface, float f) {
        this.b.record(surface, f);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void restart() {
        this.b.restart();
    }

    public void setState(com.hbzhou.open.flowcamera.state.State state) {
        this.b = state;
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void start(android.view.SurfaceHolder surfaceHolder, float f) {
        this.b.start(surfaceHolder, f);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void stop() {
        this.b.stop();
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void stopRecord(boolean z, long j) {
        this.b.stopRecord(z, j);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void swtich(android.view.SurfaceHolder surfaceHolder, float f) {
        this.b.swtich(surfaceHolder, f);
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void zoom(float f, int i) {
        this.b.zoom(f, i);
    }
}
