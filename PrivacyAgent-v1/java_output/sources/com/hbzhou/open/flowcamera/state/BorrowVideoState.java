package com.hbzhou.open.flowcamera.state;

/* loaded from: classes22.dex */
public class BorrowVideoState implements com.hbzhou.open.flowcamera.state.State {
    public final java.lang.String a = "BorrowVideoState";
    public com.hbzhou.open.flowcamera.state.CameraMachine b;

    public BorrowVideoState(com.hbzhou.open.flowcamera.state.CameraMachine cameraMachine) {
        this.b = cameraMachine;
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void cancle(android.view.SurfaceHolder surfaceHolder, float f) {
        this.b.getView().resetState(2);
        com.hbzhou.open.flowcamera.state.CameraMachine cameraMachine = this.b;
        cameraMachine.setState(cameraMachine.c());
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void capture() {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void confirm() {
        this.b.getView().confirmState(2);
        com.hbzhou.open.flowcamera.state.CameraMachine cameraMachine = this.b;
        cameraMachine.setState(cameraMachine.c());
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void flash(java.lang.String str) {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void foucs(float f, float f2, com.hbzhou.open.flowcamera.CameraInterface.FocusCallback focusCallback) {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void record(android.view.Surface surface, float f) {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void restart() {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void start(android.view.SurfaceHolder surfaceHolder, float f) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
        com.hbzhou.open.flowcamera.state.CameraMachine cameraMachine = this.b;
        cameraMachine.setState(cameraMachine.c());
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void stop() {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void stopRecord(boolean z, long j) {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void swtich(android.view.SurfaceHolder surfaceHolder, float f) {
    }

    @Override // com.hbzhou.open.flowcamera.state.State
    public void zoom(float f, int i) {
        com.hbzhou.open.flowcamera.util.LogUtil.i("BorrowVideoState", "zoom");
    }
}
