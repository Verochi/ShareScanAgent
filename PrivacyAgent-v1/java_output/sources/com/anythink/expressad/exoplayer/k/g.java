package com.anythink.expressad.exoplayer.k;

@android.annotation.TargetApi(17)
/* loaded from: classes12.dex */
public final class g implements android.graphics.SurfaceTexture.OnFrameAvailableListener, java.lang.Runnable {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final int[] d = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private static final int e = 12992;
    private final android.os.Handler f;
    private final int[] g = new int[1];

    @androidx.annotation.Nullable
    private android.opengl.EGLDisplay h;

    @androidx.annotation.Nullable
    private android.opengl.EGLContext i;

    @androidx.annotation.Nullable
    private android.opengl.EGLSurface j;

    @androidx.annotation.Nullable
    private android.graphics.SurfaceTexture k;

    public static final class a extends java.lang.RuntimeException {
        private a(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ a(java.lang.String str, byte b) {
            this(str);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    public g(android.os.Handler handler) {
        this.f = handler;
    }

    private static android.opengl.EGLConfig a(android.opengl.EGLDisplay eGLDisplay) {
        android.opengl.EGLConfig eGLConfig;
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = android.opengl.EGL14.eglChooseConfig(eGLDisplay, d, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!eglChooseConfig || iArr[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            throw new com.anythink.expressad.exoplayer.k.g.a(com.anythink.expressad.exoplayer.k.af.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", java.lang.Boolean.valueOf(eglChooseConfig), java.lang.Integer.valueOf(iArr[0]), eGLConfigArr[0]), (byte) 0);
        }
        return eGLConfig;
    }

    private static android.opengl.EGLContext a(android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig, int i) {
        android.opengl.EGLContext eglCreateContext = android.opengl.EGL14.eglCreateContext(eGLDisplay, eGLConfig, android.opengl.EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, e, 1, 12344}, 0);
        if (eglCreateContext != null) {
            return eglCreateContext;
        }
        throw new com.anythink.expressad.exoplayer.k.g.a("eglCreateContext failed", (byte) 0);
    }

    private static android.opengl.EGLSurface a(android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig, android.opengl.EGLContext eGLContext, int i) {
        android.opengl.EGLSurface eglCreatePbufferSurface;
        if (i == 1) {
            eglCreatePbufferSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = android.opengl.EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, e, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eglCreatePbufferSurface == null) {
                throw new com.anythink.expressad.exoplayer.k.g.a("eglCreatePbufferSurface failed", (byte) 0);
            }
        }
        if (android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eGLContext)) {
            return eglCreatePbufferSurface;
        }
        throw new com.anythink.expressad.exoplayer.k.g.a("eglMakeCurrent failed", (byte) 0);
    }

    private static void a(int[] iArr) {
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        int glGetError = android.opengl.GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new com.anythink.expressad.exoplayer.k.g.a("glGenTextures failed. Error: " + java.lang.Integer.toHexString(glGetError), (byte) 0);
    }

    private static android.opengl.EGLDisplay c() {
        android.opengl.EGLDisplay eglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
        if (eglGetDisplay == null) {
            throw new com.anythink.expressad.exoplayer.k.g.a("eglGetDisplay failed", (byte) 0);
        }
        int[] iArr = new int[2];
        if (android.opengl.EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            return eglGetDisplay;
        }
        throw new com.anythink.expressad.exoplayer.k.g.a("eglInitialize failed", (byte) 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        this.f.removeCallbacks(this);
        try {
            android.graphics.SurfaceTexture surfaceTexture = this.k;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                android.opengl.GLES20.glDeleteTextures(1, this.g, 0);
            }
        } finally {
            android.opengl.EGLDisplay eGLDisplay = this.h;
            if (eGLDisplay != null && !eGLDisplay.equals(android.opengl.EGL14.EGL_NO_DISPLAY)) {
                android.opengl.EGLDisplay eGLDisplay2 = this.h;
                android.opengl.EGLSurface eGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
                android.opengl.EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, android.opengl.EGL14.EGL_NO_CONTEXT);
            }
            android.opengl.EGLSurface eGLSurface2 = this.j;
            if (eGLSurface2 != null && !eGLSurface2.equals(android.opengl.EGL14.EGL_NO_SURFACE)) {
                android.opengl.EGL14.eglDestroySurface(this.h, this.j);
            }
            android.opengl.EGLContext eGLContext = this.i;
            if (eGLContext != null) {
                android.opengl.EGL14.eglDestroyContext(this.h, eGLContext);
            }
            if (com.anythink.expressad.exoplayer.k.af.a >= 19) {
                android.opengl.EGL14.eglReleaseThread();
            }
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
        }
    }

    public final void a(int i) {
        android.opengl.EGLConfig eGLConfig;
        android.opengl.EGLSurface eglCreatePbufferSurface;
        android.opengl.EGLDisplay eglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
        if (eglGetDisplay == null) {
            throw new com.anythink.expressad.exoplayer.k.g.a("eglGetDisplay failed", (byte) 0);
        }
        int[] iArr = new int[2];
        if (!android.opengl.EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            throw new com.anythink.expressad.exoplayer.k.g.a("eglInitialize failed", (byte) 0);
        }
        this.h = eglGetDisplay;
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        int[] iArr2 = new int[1];
        boolean eglChooseConfig = android.opengl.EGL14.eglChooseConfig(eglGetDisplay, d, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (!eglChooseConfig || iArr2[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            throw new com.anythink.expressad.exoplayer.k.g.a(com.anythink.expressad.exoplayer.k.af.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", java.lang.Boolean.valueOf(eglChooseConfig), java.lang.Integer.valueOf(iArr2[0]), eGLConfigArr[0]), (byte) 0);
        }
        android.opengl.EGLContext eglCreateContext = android.opengl.EGL14.eglCreateContext(this.h, eGLConfig, android.opengl.EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, e, 1, 12344}, 0);
        if (eglCreateContext == null) {
            throw new com.anythink.expressad.exoplayer.k.g.a("eglCreateContext failed", (byte) 0);
        }
        this.i = eglCreateContext;
        android.opengl.EGLDisplay eGLDisplay = this.h;
        if (i == 1) {
            eglCreatePbufferSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = android.opengl.EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, e, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eglCreatePbufferSurface == null) {
                throw new com.anythink.expressad.exoplayer.k.g.a("eglCreatePbufferSurface failed", (byte) 0);
            }
        }
        if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
            throw new com.anythink.expressad.exoplayer.k.g.a("eglMakeCurrent failed", (byte) 0);
        }
        this.j = eglCreatePbufferSurface;
        android.opengl.GLES20.glGenTextures(1, this.g, 0);
        int glGetError = android.opengl.GLES20.glGetError();
        if (glGetError != 0) {
            throw new com.anythink.expressad.exoplayer.k.g.a("glGenTextures failed. Error: " + java.lang.Integer.toHexString(glGetError), (byte) 0);
        }
        android.graphics.SurfaceTexture surfaceTexture = new android.graphics.SurfaceTexture(this.g[0]);
        this.k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public final android.graphics.SurfaceTexture b() {
        return (android.graphics.SurfaceTexture) com.anythink.expressad.exoplayer.k.a.a(this.k);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        this.f.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.graphics.SurfaceTexture surfaceTexture = this.k;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }
}
