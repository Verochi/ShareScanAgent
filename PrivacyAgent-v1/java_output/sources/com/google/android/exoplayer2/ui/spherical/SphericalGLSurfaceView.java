package com.google.android.exoplayer2.ui.spherical;

/* loaded from: classes22.dex */
public final class SphericalGLSurfaceView extends android.opengl.GLSurfaceView {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.VideoComponent A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final android.hardware.SensorManager n;

    @androidx.annotation.Nullable
    public final android.hardware.Sensor t;
    public final com.google.android.exoplayer2.ui.spherical.OrientationListener u;
    public final android.os.Handler v;
    public final com.google.android.exoplayer2.ui.spherical.TouchTracker w;
    public final com.google.android.exoplayer2.ui.spherical.SceneRenderer x;

    @androidx.annotation.Nullable
    public android.graphics.SurfaceTexture y;

    @androidx.annotation.Nullable
    public android.view.Surface z;

    @androidx.annotation.VisibleForTesting
    public class Renderer implements android.opengl.GLSurfaceView.Renderer, com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener, com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener {
        public final com.google.android.exoplayer2.ui.spherical.SceneRenderer n;
        public final float[] v;
        public final float[] w;
        public final float[] x;
        public float y;
        public float z;
        public final float[] t = new float[16];
        public final float[] u = new float[16];
        public final float[] A = new float[16];
        public final float[] B = new float[16];

        public Renderer(com.google.android.exoplayer2.ui.spherical.SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.v = fArr;
            float[] fArr2 = new float[16];
            this.w = fArr2;
            float[] fArr3 = new float[16];
            this.x = fArr3;
            this.n = sceneRenderer;
            android.opengl.Matrix.setIdentityM(fArr, 0);
            android.opengl.Matrix.setIdentityM(fArr2, 0);
            android.opengl.Matrix.setIdentityM(fArr3, 0);
            this.z = 3.1415927f;
        }

        @Override // com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener
        @androidx.annotation.UiThread
        public synchronized void a(android.graphics.PointF pointF) {
            this.y = pointF.y;
            c();
            android.opengl.Matrix.setRotateM(this.x, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final float b(float f) {
            if (f > 1.0f) {
                return (float) (java.lang.Math.toDegrees(java.lang.Math.atan(java.lang.Math.tan(java.lang.Math.toRadians(45.0d)) / f)) * 2.0d);
            }
            return 90.0f;
        }

        @androidx.annotation.AnyThread
        public final void c() {
            android.opengl.Matrix.setRotateM(this.w, 0, -this.y, (float) java.lang.Math.cos(this.z), (float) java.lang.Math.sin(this.z), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
            synchronized (this) {
                android.opengl.Matrix.multiplyMM(this.B, 0, this.v, 0, this.x, 0);
                android.opengl.Matrix.multiplyMM(this.A, 0, this.w, 0, this.B, 0);
            }
            android.opengl.Matrix.multiplyMM(this.u, 0, this.t, 0, this.A, 0);
            this.n.b(this.u, false);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener
        @androidx.annotation.BinderThread
        public synchronized void onOrientationChange(float[] fArr, float f) {
            float[] fArr2 = this.v;
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.z = -f;
            c();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
            android.opengl.GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            android.opengl.Matrix.perspectiveM(this.t, 0, b(f), f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView.this.f(this.n.c());
        }
    }

    public SphericalGLSurfaceView(android.content.Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = new android.os.Handler(android.os.Looper.getMainLooper());
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(context.getSystemService(com.umeng.analytics.pro.bo.ac));
        this.n = sensorManager;
        android.hardware.Sensor defaultSensor = com.google.android.exoplayer2.util.Util.SDK_INT >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.t = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        com.google.android.exoplayer2.ui.spherical.SceneRenderer sceneRenderer = new com.google.android.exoplayer2.ui.spherical.SceneRenderer();
        this.x = sceneRenderer;
        com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView.Renderer renderer = new com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView.Renderer(sceneRenderer);
        com.google.android.exoplayer2.ui.spherical.TouchTracker touchTracker = new com.google.android.exoplayer2.ui.spherical.TouchTracker(context, renderer, 25.0f);
        this.w = touchTracker;
        this.u = new com.google.android.exoplayer2.ui.spherical.OrientationListener(((android.view.WindowManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.view.WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker, renderer);
        this.B = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        android.view.Surface surface = this.z;
        if (surface != null) {
            com.google.android.exoplayer2.Player.VideoComponent videoComponent = this.A;
            if (videoComponent != null) {
                videoComponent.clearVideoSurface(surface);
            }
            g(this.y, this.z);
            this.y = null;
            this.z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(android.graphics.SurfaceTexture surfaceTexture) {
        android.graphics.SurfaceTexture surfaceTexture2 = this.y;
        android.view.Surface surface = this.z;
        this.y = surfaceTexture;
        android.view.Surface surface2 = new android.view.Surface(surfaceTexture);
        this.z = surface2;
        com.google.android.exoplayer2.Player.VideoComponent videoComponent = this.A;
        if (videoComponent != null) {
            videoComponent.setVideoSurface(surface2);
        }
        g(surfaceTexture2, surface);
    }

    public static void g(@androidx.annotation.Nullable android.graphics.SurfaceTexture surfaceTexture, @androidx.annotation.Nullable android.view.Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public final void f(android.graphics.SurfaceTexture surfaceTexture) {
        this.v.post(new defpackage.yn2(this, surfaceTexture));
    }

    public final void h() {
        boolean z = this.B && this.C;
        android.hardware.Sensor sensor = this.t;
        if (sensor == null || z == this.D) {
            return;
        }
        if (z) {
            this.n.registerListener(this.u, sensor, 0);
        } else {
            this.n.unregisterListener(this.u);
        }
        this.D = z;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.v.post(new defpackage.xn2(this));
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.C = false;
        h();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.C = true;
        h();
    }

    public void setDefaultStereoMode(int i) {
        this.x.e(i);
    }

    public void setSingleTapListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.spherical.SingleTapListener singleTapListener) {
        this.w.a(singleTapListener);
    }

    public void setUseSensorRotation(boolean z) {
        this.B = z;
        h();
    }

    public void setVideoComponent(@androidx.annotation.Nullable com.google.android.exoplayer2.Player.VideoComponent videoComponent) {
        com.google.android.exoplayer2.Player.VideoComponent videoComponent2 = this.A;
        if (videoComponent == videoComponent2) {
            return;
        }
        if (videoComponent2 != null) {
            android.view.Surface surface = this.z;
            if (surface != null) {
                videoComponent2.clearVideoSurface(surface);
            }
            this.A.clearVideoFrameMetadataListener(this.x);
            this.A.clearCameraMotionListener(this.x);
        }
        this.A = videoComponent;
        if (videoComponent != null) {
            videoComponent.setVideoFrameMetadataListener(this.x);
            this.A.setCameraMotionListener(this.x);
            this.A.setVideoSurface(this.z);
        }
    }
}
