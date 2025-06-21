package com.autonavi.base.amap.api.mapcore;

/* loaded from: classes12.dex */
public interface IGLSurfaceView {
    int getHeight();

    android.view.SurfaceHolder getHolder();

    android.view.ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(java.lang.Runnable runnable);

    boolean postDelayed(java.lang.Runnable runnable, long j);

    void queueEvent(java.lang.Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i);

    void setEGLConfigChooser(com.amap.api.mapcore.util.cv cvVar);

    void setEGLContextFactory(com.amap.api.mapcore.util.cw cwVar);

    void setRenderMode(int i);

    void setRenderer(android.opengl.GLSurfaceView.Renderer renderer);

    void setVisibility(int i);

    void setZOrderOnTop(boolean z);
}
