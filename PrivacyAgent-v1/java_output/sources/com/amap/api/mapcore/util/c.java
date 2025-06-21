package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class c implements com.autonavi.base.amap.api.mapcore.IGLSurfaceView {
    protected boolean a;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;

    public c(android.content.Context context) {
        this(context, (byte) 0);
    }

    private c(android.content.Context context, byte b) {
        this.b = null;
        this.a = false;
        this.b = new com.amap.api.mapcore.util.b(this, context);
    }

    public final com.autonavi.base.amap.api.mapcore.IAMapDelegate a() {
        return this.b;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getHeight() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final android.view.SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final android.view.ViewParent getParent() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getRenderMode() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getWidth() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean isEnabled() {
        return this.b != null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean post(java.lang.Runnable runnable) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean postDelayed(java.lang.Runnable runnable, long j) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void queueEvent(java.lang.Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void requestRender() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setBackgroundColor(int i) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(com.amap.api.mapcore.util.cv cvVar) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(com.amap.api.mapcore.util.cw cwVar) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderMode(int i) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(android.opengl.GLSurfaceView.Renderer renderer) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setVisibility(int i) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z) {
    }
}
