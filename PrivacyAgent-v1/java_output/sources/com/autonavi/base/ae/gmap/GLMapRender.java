package com.autonavi.base.ae.gmap;

/* loaded from: classes12.dex */
public class GLMapRender implements android.opengl.GLSurfaceView.Renderer {
    public static final int ANIMATION_TICK_COUNT = 10;
    public static final int LONG_LONG_TICK_COUNT = 30;
    public static final int LONG_TICK_COUNT = 6;
    private static final int MAP_RENDER_MSG_RUNNABLE_ONGLTHREAD = 100;
    private static final int MAP_RENDER_MSG_SURFACE_RENDER = 10;
    public static final int NORMAL_TICK_COUNT = 2;
    public static final int RENDER_FPS_ANIMATION = 30;
    public static final int RENDER_FPS_GESTURE_ACTION = 40;
    static final int RENDER_FPS_MAX = 60;
    public static final int RENDER_FPS_NAVI = 10;
    public static final int RENDER_FPS_NORMAL = 15;
    static final long RENDER_TIMMER_DIFF_MIN = 16;
    static final java.lang.String TAG = "render";
    public com.autonavi.amap.mapcore.interfaces.IAMap mGLMapView;
    private int mTargetFrameDurationMillis = 66;
    private float mTargetRenderFPS = 15.0f;
    private volatile boolean mIsRendPause = false;
    public volatile boolean mSurfacedestoryed = false;
    private android.os.HandlerThread mGLRenderThread = null;
    private android.os.Handler mGLRenderHandler = null;
    private long mLastFrameTime = java.lang.System.currentTimeMillis();
    private boolean mIsTrafficMode = false;
    private volatile java.util.concurrent.atomic.AtomicLong mDrawFrameTickCount = new java.util.concurrent.atomic.AtomicLong(6);

    /* renamed from: com.autonavi.base.ae.gmap.GLMapRender$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.autonavi.amap.mapcore.interfaces.IAMap iAMap;
            int i = message.what;
            if (i != 10) {
                if (i != 100) {
                    return;
                }
                ((java.lang.Runnable) message.obj).run();
            } else {
                if (com.autonavi.base.ae.gmap.GLMapRender.this.mIsRendPause || (iAMap = com.autonavi.base.ae.gmap.GLMapRender.this.mGLMapView) == null || iAMap.getRenderMode() != 0) {
                    return;
                }
                com.autonavi.base.ae.gmap.GLMapRender.this.mGLMapView.requestRender();
            }
        }
    }

    public GLMapRender(com.autonavi.amap.mapcore.interfaces.IAMap iAMap) {
        this.mGLMapView = iAMap;
    }

    private void drawSingleFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        try {
            this.mGLMapView.drawFrame(gl10);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isRenderPause() {
        return this.mIsRendPause;
    }

    public void onAttachedToWindow() {
        if (this.mGLRenderThread == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread(" AMapGlRenderThread");
            this.mGLRenderThread = handlerThread;
            handlerThread.start();
            this.mGLRenderHandler = new com.autonavi.base.ae.gmap.GLMapRender.AnonymousClass1(this.mGLRenderThread.getLooper());
        }
    }

    public void onDetachedFromWindow() {
        android.os.HandlerThread handlerThread = this.mGLRenderThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mGLRenderThread = null;
            this.mGLRenderHandler = null;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        android.os.HandlerThread handlerThread;
        long max;
        android.os.Handler handler;
        if (this.mGLMapView == null) {
            return;
        }
        try {
            this.mLastFrameTime = java.lang.System.currentTimeMillis();
            drawSingleFrame(gl10);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long j = currentTimeMillis - this.mLastFrameTime;
            this.mLastFrameTime = currentTimeMillis;
            long j2 = this.mDrawFrameTickCount.get();
            if (this.mGLMapView.getRenderMode() != 0 || this.mGLRenderHandler == null || (handlerThread = this.mGLRenderThread) == null || !handlerThread.isAlive()) {
                return;
            }
            long j3 = j2 - 1;
            this.mDrawFrameTickCount.set(j3);
            if (j3 > 0) {
                max = java.lang.Math.max(16L, this.mTargetFrameDurationMillis - j);
            } else if (j3 > -5) {
                max = 60;
            } else if (j3 > -7) {
                max = 100;
            } else if (j3 > -9) {
                max = 250;
            } else {
                max = this.mIsTrafficMode ? 10000L : 500L;
                this.mDrawFrameTickCount.set(-9L);
            }
            if (max <= 0 || (handler = this.mGLRenderHandler) == null) {
                return;
            }
            handler.removeMessages(10);
            this.mGLRenderHandler.sendEmptyMessageDelayed(10, max);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "GLMapRender", "onDrawFrame");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
        if (this.mSurfacedestoryed) {
            onSurfaceCreated(gl10, null);
        }
        this.mGLMapView.changeSurface(gl10, i, i2);
        resetTickCount(30);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        this.mIsRendPause = false;
        this.mSurfacedestoryed = false;
        this.mGLMapView.createSurface(gl10, eGLConfig);
    }

    public void onSurfaceDestory() {
        this.mIsRendPause = true;
        android.os.Handler handler = this.mGLRenderHandler;
        if (handler != null && this.mGLRenderThread != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mGLMapView.destroySurface(1);
        this.mSurfacedestoryed = true;
    }

    public void renderPause() {
        android.os.HandlerThread handlerThread;
        if (this.mGLRenderHandler != null && (handlerThread = this.mGLRenderThread) != null && handlerThread.isAlive()) {
            this.mGLRenderHandler.removeMessages(10);
        }
        this.mIsRendPause = true;
    }

    public void renderResume() {
        android.os.HandlerThread handlerThread;
        if (this.mGLRenderHandler != null && (handlerThread = this.mGLRenderThread) != null && handlerThread.isAlive()) {
            this.mGLRenderHandler.removeMessages(10);
        }
        this.mIsRendPause = false;
        this.mDrawFrameTickCount.set(-1L);
        resetTickCount(30);
    }

    public void resetTickCount(int i) {
        android.os.HandlerThread handlerThread;
        long j = this.mDrawFrameTickCount.get();
        if (this.mIsRendPause || (handlerThread = this.mGLRenderThread) == null || this.mGLRenderHandler == null || !handlerThread.isAlive()) {
            long j2 = i;
            if (j < j2) {
                this.mDrawFrameTickCount.set(j2);
                return;
            }
            return;
        }
        if (j <= 0) {
            this.mDrawFrameTickCount.set(i);
            this.mGLRenderHandler.removeMessages(10);
            this.mGLRenderHandler.sendEmptyMessage(10);
        } else {
            long j3 = i;
            if (j < j3) {
                this.mDrawFrameTickCount.set(j3);
            }
        }
    }

    public void sendToRenderEvent(java.lang.Runnable runnable) {
        android.os.HandlerThread handlerThread;
        if (this.mGLRenderHandler == null || (handlerThread = this.mGLRenderThread) == null || !handlerThread.isAlive()) {
            return;
        }
        this.mGLRenderHandler.post(runnable);
    }

    public void setRenderFps(float f) {
        if (this.mTargetRenderFPS == f || f <= 0.0f) {
            return;
        }
        this.mTargetFrameDurationMillis = (int) ((1.0f / f) * 1000.0f);
        this.mTargetRenderFPS = f;
    }

    public void setTrafficMode(boolean z) {
        this.mIsTrafficMode = z;
    }
}
