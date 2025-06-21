package org.webrtc.ali.svideo;

@android.annotation.TargetApi(18)
/* loaded from: classes26.dex */
public class EglBase14 extends org.webrtc.ali.svideo.EglBase {
    private static final int CURRENT_SDK_VERSION = android.os.Build.VERSION.SDK_INT;
    private static final int EGLExt_SDK_VERSION = 18;
    private static final java.lang.String TAG = "EglBase14";
    private android.opengl.EGLConfig eglConfig;
    private android.opengl.EGLContext eglContext;
    private android.opengl.EGLDisplay eglDisplay;
    private android.opengl.EGLSurface eglSurface = android.opengl.EGL14.EGL_NO_SURFACE;

    public static class Context extends org.webrtc.ali.svideo.EglBase.Context {
        private final android.opengl.EGLContext egl14Context;

        public Context(android.opengl.EGLContext eGLContext) {
            this.egl14Context = eGLContext;
        }

        @Override // org.webrtc.ali.svideo.EglBase.Context
        public long getNativeEglContext() {
            return org.webrtc.ali.svideo.EglBase14.CURRENT_SDK_VERSION >= 21 ? this.egl14Context.getNativeHandle() : this.egl14Context.getHandle();
        }
    }

    public EglBase14(org.webrtc.ali.svideo.EglBase14.Context context, int[] iArr) {
        android.opengl.EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        android.opengl.EGLConfig eglConfig = getEglConfig(eglDisplay, iArr);
        this.eglConfig = eglConfig;
        this.eglContext = createEglContext(context, this.eglDisplay, eglConfig);
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == android.opengl.EGL14.EGL_NO_DISPLAY || this.eglContext == android.opengl.EGL14.EGL_NO_CONTEXT || this.eglConfig == null) {
            throw new java.lang.RuntimeException("This object has been released");
        }
    }

    private static android.opengl.EGLContext createEglContext(org.webrtc.ali.svideo.EglBase14.Context context, android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig) {
        android.opengl.EGLContext eglCreateContext;
        if (context != null && context.egl14Context == android.opengl.EGL14.EGL_NO_CONTEXT) {
            throw new java.lang.RuntimeException("Invalid sharedContext");
        }
        int[] iArr = {12440, 2, 12344};
        android.opengl.EGLContext eGLContext = context == null ? android.opengl.EGL14.EGL_NO_CONTEXT : context.egl14Context;
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            eglCreateContext = android.opengl.EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
        }
        if (eglCreateContext != android.opengl.EGL14.EGL_NO_CONTEXT) {
            return eglCreateContext;
        }
        throw new java.lang.RuntimeException("Failed to create EGL context: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
    }

    private void createSurfaceInternal(java.lang.Object obj) {
        if (!(obj instanceof android.view.Surface) && !(obj instanceof android.graphics.SurfaceTexture)) {
            throw new java.lang.IllegalStateException("Input must be either a Surface or SurfaceTexture");
        }
        checkIsNotReleased();
        if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("Already has an EGLSurface");
        }
        android.opengl.EGLSurface eglCreateWindowSurface = android.opengl.EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{12344}, 0);
        this.eglSurface = eglCreateWindowSurface;
        if (eglCreateWindowSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            return;
        }
        throw new java.lang.RuntimeException("Failed to create window surface: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
    }

    private static android.opengl.EGLConfig getEglConfig(android.opengl.EGLDisplay eGLDisplay, int[] iArr) {
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        int[] iArr2 = new int[1];
        if (!android.opengl.EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, iArr2, 0)) {
            throw new java.lang.RuntimeException("eglChooseConfig failed: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
        }
        if (iArr2[0] <= 0) {
            throw new java.lang.RuntimeException("Unable to find any matching EGL config");
        }
        android.opengl.EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLConfig != null) {
            return eGLConfig;
        }
        throw new java.lang.RuntimeException("eglChooseConfig returned null");
    }

    private static android.opengl.EGLDisplay getEglDisplay() {
        android.opengl.EGLDisplay eglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
        if (eglGetDisplay == android.opengl.EGL14.EGL_NO_DISPLAY) {
            throw new java.lang.RuntimeException("Unable to get EGL14 display: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
        }
        int[] iArr = new int[2];
        if (android.opengl.EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            return eglGetDisplay;
        }
        throw new java.lang.RuntimeException("Unable to initialize EGL14: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
    }

    public static boolean isEGL14Supported() {
        return CURRENT_SDK_VERSION >= 18;
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createPbufferSurface(int i, int i2) {
        checkIsNotReleased();
        if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("Already has an EGLSurface");
        }
        android.opengl.EGLSurface eglCreatePbufferSurface = android.opengl.EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
        this.eglSurface = eglCreatePbufferSurface;
        if (eglCreatePbufferSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            return;
        }
        throw new java.lang.RuntimeException("Failed to create pixel buffer surface with size " + i + "x" + i2 + ": 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createSurface(android.graphics.SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture);
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createSurface(android.view.Surface surface) {
        createSurfaceInternal(surface);
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void detachCurrent() {
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            android.opengl.EGLDisplay eGLDisplay = this.eglDisplay;
            android.opengl.EGLSurface eGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
            if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, android.opengl.EGL14.EGL_NO_CONTEXT)) {
                throw new java.lang.RuntimeException("eglDetachCurrent failed: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public org.webrtc.ali.svideo.EglBase14.Context getEglBaseContext() {
        return new org.webrtc.ali.svideo.EglBase14.Context(this.eglContext);
    }

    public android.opengl.EGLContext getEglContext() {
        return this.eglContext;
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public long getNativeEglContext() {
        return CURRENT_SDK_VERSION >= 21 ? this.eglContext.getNativeHandle() : this.eglContext.getHandle();
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public boolean hasSurface() {
        return this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == android.opengl.EGL14.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("No EGLSurface - can't make current");
        }
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            android.opengl.EGLDisplay eGLDisplay = this.eglDisplay;
            android.opengl.EGLSurface eGLSurface = this.eglSurface;
            if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                throw new java.lang.RuntimeException("eglMakeCurrent failed: 0x" + java.lang.Integer.toHexString(android.opengl.EGL14.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        android.opengl.EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        android.opengl.EGL14.eglReleaseThread();
        android.opengl.EGL14.eglTerminate(this.eglDisplay);
        this.eglContext = android.opengl.EGL14.EGL_NO_CONTEXT;
        this.eglDisplay = android.opengl.EGL14.EGL_NO_DISPLAY;
        this.eglConfig = null;
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void releaseSurface() {
        android.opengl.EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            android.opengl.EGL14.eglDestroySurface(this.eglDisplay, eGLSurface);
            this.eglSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public int surfaceHeight() {
        int[] iArr = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr, 0);
        return iArr[0];
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public int surfaceWidth() {
        int[] iArr = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr, 0);
        return iArr[0];
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        if (this.eglSurface == android.opengl.EGL14.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("No EGLSurface - can't swap buffers");
        }
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            android.opengl.EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        }
    }

    public void swapBuffers(long j) {
        checkIsNotReleased();
        if (this.eglSurface == android.opengl.EGL14.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("No EGLSurface - can't swap buffers");
        }
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            android.opengl.EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, j);
            android.opengl.EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        }
    }
}
