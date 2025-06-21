package com.google.android.exoplayer2.util;

@androidx.annotation.RequiresApi(17)
/* loaded from: classes22.dex */
public final class EGLSurfaceTexture implements android.graphics.SurfaceTexture.OnFrameAvailableListener, java.lang.Runnable {
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    public static final int[] z = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    public final android.os.Handler n;
    public final int[] t;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.util.EGLSurfaceTexture.TextureImageListener u;

    @androidx.annotation.Nullable
    public android.opengl.EGLDisplay v;

    @androidx.annotation.Nullable
    public android.opengl.EGLContext w;

    @androidx.annotation.Nullable
    public android.opengl.EGLSurface x;

    @androidx.annotation.Nullable
    public android.graphics.SurfaceTexture y;

    public static final class GlException extends java.lang.RuntimeException {
        private GlException(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ GlException(java.lang.String str, com.google.android.exoplayer2.util.EGLSurfaceTexture.AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    public interface TextureImageListener {
        void onFrameAvailable();
    }

    public EGLSurfaceTexture(android.os.Handler handler) {
        this(handler, null);
    }

    public EGLSurfaceTexture(android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.util.EGLSurfaceTexture.TextureImageListener textureImageListener) {
        this.n = handler;
        this.u = textureImageListener;
        this.t = new int[1];
    }

    public static android.opengl.EGLConfig a(android.opengl.EGLDisplay eGLDisplay) {
        android.opengl.EGLConfig eGLConfig;
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = android.opengl.EGL14.eglChooseConfig(eGLDisplay, z, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!eglChooseConfig || iArr[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException(com.google.android.exoplayer2.util.Util.formatInvariant("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", java.lang.Boolean.valueOf(eglChooseConfig), java.lang.Integer.valueOf(iArr[0]), eGLConfigArr[0]), null);
        }
        return eGLConfig;
    }

    public static android.opengl.EGLContext b(android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig, int i) {
        android.opengl.EGLContext eglCreateContext = android.opengl.EGL14.eglCreateContext(eGLDisplay, eGLConfig, android.opengl.EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eglCreateContext != null) {
            return eglCreateContext;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglCreateContext failed", null);
    }

    public static android.opengl.EGLSurface c(android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig, android.opengl.EGLContext eGLContext, int i) {
        android.opengl.EGLSurface eglCreatePbufferSurface;
        if (i == 1) {
            eglCreatePbufferSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = android.opengl.EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eglCreatePbufferSurface == null) {
                throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglCreatePbufferSurface failed", null);
            }
        }
        if (android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eGLContext)) {
            return eglCreatePbufferSurface;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglMakeCurrent failed", null);
    }

    public static void e(int[] iArr) {
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
    }

    public static android.opengl.EGLDisplay f() {
        android.opengl.EGLDisplay eglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
        if (eglGetDisplay == null) {
            throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglGetDisplay failed", null);
        }
        int[] iArr = new int[2];
        if (android.opengl.EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            return eglGetDisplay;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglInitialize failed", null);
    }

    public final void d() {
        com.google.android.exoplayer2.util.EGLSurfaceTexture.TextureImageListener textureImageListener = this.u;
        if (textureImageListener != null) {
            textureImageListener.onFrameAvailable();
        }
    }

    public android.graphics.SurfaceTexture getSurfaceTexture() {
        return (android.graphics.SurfaceTexture) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.y);
    }

    public void init(int i) {
        android.opengl.EGLDisplay f = f();
        this.v = f;
        android.opengl.EGLConfig a = a(f);
        android.opengl.EGLContext b = b(this.v, a, i);
        this.w = b;
        this.x = c(this.v, a, b, i);
        e(this.t);
        android.graphics.SurfaceTexture surfaceTexture = new android.graphics.SurfaceTexture(this.t[0]);
        this.y = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        this.n.post(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release() {
        this.n.removeCallbacks(this);
        try {
            android.graphics.SurfaceTexture surfaceTexture = this.y;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                android.opengl.GLES20.glDeleteTextures(1, this.t, 0);
            }
        } finally {
            android.opengl.EGLDisplay eGLDisplay = this.v;
            if (eGLDisplay != null && !eGLDisplay.equals(android.opengl.EGL14.EGL_NO_DISPLAY)) {
                android.opengl.EGLDisplay eGLDisplay2 = this.v;
                android.opengl.EGLSurface eGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
                android.opengl.EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, android.opengl.EGL14.EGL_NO_CONTEXT);
            }
            android.opengl.EGLSurface eGLSurface2 = this.x;
            if (eGLSurface2 != null && !eGLSurface2.equals(android.opengl.EGL14.EGL_NO_SURFACE)) {
                android.opengl.EGL14.eglDestroySurface(this.v, this.x);
            }
            android.opengl.EGLContext eGLContext = this.w;
            if (eGLContext != null) {
                android.opengl.EGL14.eglDestroyContext(this.v, eGLContext);
            }
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 19) {
                android.opengl.EGL14.eglReleaseThread();
            }
            android.opengl.EGLDisplay eGLDisplay3 = this.v;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(android.opengl.EGL14.EGL_NO_DISPLAY)) {
                android.opengl.EGL14.eglTerminate(this.v);
            }
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
        android.graphics.SurfaceTexture surfaceTexture = this.y;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (java.lang.RuntimeException unused) {
            }
        }
    }
}
