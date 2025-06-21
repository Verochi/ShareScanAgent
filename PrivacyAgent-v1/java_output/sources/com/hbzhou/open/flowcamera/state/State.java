package com.hbzhou.open.flowcamera.state;

/* loaded from: classes22.dex */
public interface State {
    void cancle(android.view.SurfaceHolder surfaceHolder, float f);

    void capture();

    void confirm();

    void flash(java.lang.String str);

    void foucs(float f, float f2, com.hbzhou.open.flowcamera.CameraInterface.FocusCallback focusCallback);

    void record(android.view.Surface surface, float f);

    void restart();

    void start(android.view.SurfaceHolder surfaceHolder, float f);

    void stop();

    void stopRecord(boolean z, long j);

    void swtich(android.view.SurfaceHolder surfaceHolder, float f);

    void zoom(float f, int i);
}
