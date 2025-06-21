package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
class EglBase10 extends org.webrtc.ali.svideo.EglBase {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private javax.microedition.khronos.egl.EGLConfig eglConfig;
    private javax.microedition.khronos.egl.EGLContext eglContext;
    private javax.microedition.khronos.egl.EGLDisplay eglDisplay;
    private javax.microedition.khronos.egl.EGLSurface eglSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
    private final javax.microedition.khronos.egl.EGL10 egl = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();

    /* renamed from: org.webrtc.ali.svideo.EglBase10$1FakeSurfaceHolder, reason: invalid class name */
    public class C1FakeSurfaceHolder implements android.view.SurfaceHolder {
        private final android.view.Surface surface;

        public C1FakeSurfaceHolder(android.view.Surface surface) {
            this.surface = surface;
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(android.view.SurfaceHolder.Callback callback) {
        }

        @Override // android.view.SurfaceHolder
        public android.view.Surface getSurface() {
            return this.surface;
        }

        @Override // android.view.SurfaceHolder
        public android.graphics.Rect getSurfaceFrame() {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return false;
        }

        @Override // android.view.SurfaceHolder
        public android.graphics.Canvas lockCanvas() {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public android.graphics.Canvas lockCanvas(android.graphics.Rect rect) {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(android.view.SurfaceHolder.Callback callback) {
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i, int i2) {
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int i) {
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z) {
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
        }

        @Override // android.view.SurfaceHolder
        @java.lang.Deprecated
        public void setType(int i) {
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(android.graphics.Canvas canvas) {
        }
    }

    public static class Context extends org.webrtc.ali.svideo.EglBase.Context {
        private final javax.microedition.khronos.egl.EGLContext eglContext;

        public Context(javax.microedition.khronos.egl.EGLContext eGLContext) {
            this.eglContext = eGLContext;
        }

        @Override // org.webrtc.ali.svideo.EglBase.Context
        public long getNativeEglContext() {
            java.lang.reflect.Field declaredField;
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("com.google.android.gles_jni.EGLContextImpl");
                if (!cls.isAssignableFrom(this.eglContext.getClass()) || (declaredField = cls.getDeclaredField("mEGLContext")) == null) {
                    return -1L;
                }
                declaredField.setAccessible(true);
                return declaredField.getLong(this.eglContext);
            } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException e) {
                e.printStackTrace();
                return -1L;
            }
        }
    }

    public EglBase10(org.webrtc.ali.svideo.EglBase10.Context context, int[] iArr) {
        javax.microedition.khronos.egl.EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        javax.microedition.khronos.egl.EGLConfig eglConfig = getEglConfig(eglDisplay, iArr);
        this.eglConfig = eglConfig;
        this.eglContext = createEglContext(context, this.eglDisplay, eglConfig);
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY || this.eglContext == javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT || this.eglConfig == null) {
            throw new java.lang.RuntimeException("This object has been released");
        }
    }

    private javax.microedition.khronos.egl.EGLContext createEglContext(org.webrtc.ali.svideo.EglBase10.Context context, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        javax.microedition.khronos.egl.EGLContext eglCreateContext;
        if (context != null && context.eglContext == javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) {
            throw new java.lang.RuntimeException("Invalid sharedContext");
        }
        int[] iArr = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        javax.microedition.khronos.egl.EGLContext eGLContext = context == null ? javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT : context.eglContext;
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            eglCreateContext = this.egl.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }
        if (eglCreateContext != javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) {
            return eglCreateContext;
        }
        throw new java.lang.RuntimeException("Failed to create EGL context: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
    }

    private void createSurfaceInternal(java.lang.Object obj) {
        if (!(obj instanceof android.view.SurfaceHolder) && !(obj instanceof android.graphics.SurfaceTexture)) {
            throw new java.lang.IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
        }
        checkIsNotReleased();
        if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("Already has an EGLSurface");
        }
        javax.microedition.khronos.egl.EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{12344});
        this.eglSurface = eglCreateWindowSurface;
        if (eglCreateWindowSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            return;
        }
        throw new java.lang.RuntimeException("Failed to create window surface: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
    }

    private javax.microedition.khronos.egl.EGLConfig getEglConfig(javax.microedition.khronos.egl.EGLDisplay eGLDisplay, int[] iArr) {
        javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[1];
        int[] iArr2 = new int[1];
        if (!this.egl.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2)) {
            throw new java.lang.RuntimeException("eglChooseConfig failed: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
        }
        if (iArr2[0] <= 0) {
            throw new java.lang.RuntimeException("Unable to find any matching EGL config");
        }
        javax.microedition.khronos.egl.EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLConfig != null) {
            return eGLConfig;
        }
        throw new java.lang.RuntimeException("eglChooseConfig returned null");
    }

    private javax.microedition.khronos.egl.EGLDisplay getEglDisplay() {
        javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = this.egl.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
        if (eglGetDisplay == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) {
            throw new java.lang.RuntimeException("Unable to get EGL10 display: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
        }
        if (this.egl.eglInitialize(eglGetDisplay, new int[2])) {
            return eglGetDisplay;
        }
        throw new java.lang.RuntimeException("Unable to initialize EGL10: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createPbufferSurface(int i, int i2) {
        checkIsNotReleased();
        if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("Already has an EGLSurface");
        }
        javax.microedition.khronos.egl.EGLSurface eglCreatePbufferSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, i, 12374, i2, 12344});
        this.eglSurface = eglCreatePbufferSurface;
        if (eglCreatePbufferSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            return;
        }
        throw new java.lang.RuntimeException("Failed to create pixel buffer surface with size " + i + "x" + i2 + ": 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createSurface(android.graphics.SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture);
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void createSurface(android.view.Surface surface) {
        createSurfaceInternal(new org.webrtc.ali.svideo.EglBase10.C1FakeSurfaceHolder(surface));
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void detachCurrent() {
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            javax.microedition.khronos.egl.EGL10 egl10 = this.egl;
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
            javax.microedition.khronos.egl.EGLSurface eGLSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT)) {
                throw new java.lang.RuntimeException("eglDetachCurrent failed: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public org.webrtc.ali.svideo.EglBase.Context getEglBaseContext() {
        return new org.webrtc.ali.svideo.EglBase10.Context(this.eglContext);
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public long getNativeEglContext() {
        java.lang.reflect.Field declaredField;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.google.android.gles_jni.EGLContextImpl");
            if (!cls.isAssignableFrom(this.eglContext.getClass()) || (declaredField = cls.getDeclaredField("mEGLContext")) == null) {
                return -1L;
            }
            declaredField.setAccessible(true);
            return declaredField.getLong(this.eglContext);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public boolean hasSurface() {
        return this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("No EGLSurface - can't make current");
        }
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            javax.microedition.khronos.egl.EGL10 egl10 = this.egl;
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.eglDisplay;
            javax.microedition.khronos.egl.EGLSurface eGLSurface = this.eglSurface;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                throw new java.lang.RuntimeException("eglMakeCurrent failed: 0x" + java.lang.Integer.toHexString(this.egl.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        this.eglContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
        this.eglDisplay = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
        this.eglConfig = null;
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void releaseSurface() {
        javax.microedition.khronos.egl.EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            this.egl.eglDestroySurface(this.eglDisplay, eGLSurface);
            this.eglSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        }
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public int surfaceHeight() {
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
        return iArr[0];
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public int surfaceWidth() {
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr);
        return iArr[0];
    }

    @Override // org.webrtc.ali.svideo.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        if (this.eglSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            throw new java.lang.RuntimeException("No EGLSurface - can't swap buffers");
        }
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        }
    }
}
