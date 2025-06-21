package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidGraphics implements com.badlogic.gdx.Graphics, com.badlogic.gdx.backends.android.surfaceview.GLTextureView.Renderer {
    public static volatile boolean x;
    public final android.view.View a;
    public int b;
    public int c;
    protected final com.badlogic.gdx.backends.android.AndroidApplicationConfiguration config;
    public com.badlogic.gdx.backends.android.AndroidApplicationBase d;
    protected float deltaTime;
    public com.badlogic.gdx.graphics.GL20 e;
    public com.badlogic.gdx.graphics.GL30 f;
    protected int fps;
    protected long frameId;
    protected long frameStart;
    protected int frames;
    public javax.microedition.khronos.egl.EGLContext g;
    public com.badlogic.gdx.graphics.glutils.GLVersion h;
    public java.lang.String i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    protected long lastFrameTime;
    public volatile boolean m;
    protected com.badlogic.gdx.math.WindowedMean mean;
    public volatile boolean n;
    public float o;
    public float p;
    public float q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f286s;
    public com.badlogic.gdx.Graphics.BufferFormat t;
    public boolean u;
    public int[] v;
    public final java.lang.Object w;

    public class AndroidDisplayMode extends com.badlogic.gdx.Graphics.DisplayMode {
        public AndroidDisplayMode(int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
        }
    }

    public class AndroidMonitor extends com.badlogic.gdx.Graphics.Monitor {
        public AndroidMonitor(int i, int i2, java.lang.String str) {
            super(i, i2, str);
        }
    }

    public AndroidGraphics(com.badlogic.gdx.backends.android.AndroidApplicationBase androidApplicationBase, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration, com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy) {
        this(androidApplicationBase, androidApplicationConfiguration, resolutionStrategy, true);
    }

    public AndroidGraphics(com.badlogic.gdx.backends.android.AndroidApplicationBase androidApplicationBase, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration, com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy, boolean z) {
        this.lastFrameTime = java.lang.System.nanoTime();
        this.deltaTime = 0.0f;
        this.frameStart = java.lang.System.nanoTime();
        this.frameId = -1L;
        this.frames = 0;
        this.mean = new com.badlogic.gdx.math.WindowedMean(5);
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.f286s = 1.0f;
        this.t = new com.badlogic.gdx.Graphics.BufferFormat(5, 6, 5, 0, 16, 0, 0, false);
        this.u = true;
        this.v = new int[1];
        this.w = new java.lang.Object();
        this.config = androidApplicationConfiguration;
        this.d = androidApplicationBase;
        android.view.View createGLSurfaceView = createGLSurfaceView(androidApplicationBase, resolutionStrategy);
        this.a = createGLSurfaceView;
        preserveEGLContextOnPause();
        if (z) {
            createGLSurfaceView.setFocusable(true);
            createGLSurfaceView.setFocusableInTouchMode(true);
        }
    }

    public void a() {
        synchronized (this.w) {
            this.k = false;
            this.n = true;
            if (this.j) {
                while (this.n) {
                    try {
                        this.w.wait();
                    } catch (java.lang.InterruptedException unused) {
                        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "waiting for destroy synchronization failed!");
                    }
                }
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("AndroidGraphics pause: destroy:");
                sb.append(this.j);
                sb.append(" return");
            }
        }
    }

    public void b() {
        if (this.j) {
            ((com.badlogic.gdx.backends.android.surfaceview.GLTextureView) this.a).requestRender();
        }
    }

    public final int c(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i, int i2) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.v) ? this.v[0] : i2;
    }

    public boolean checkGL20() {
        javax.microedition.khronos.egl.EGL10 egl10 = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
        javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = egl10.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, new javax.microedition.khronos.egl.EGLConfig[10], 10, iArr);
        egl10.eglTerminate(eglGetDisplay);
        return iArr[0] > 0;
    }

    public void clearManagedCaches() {
        com.badlogic.gdx.graphics.Mesh.clearAllMeshes(this.d);
        com.badlogic.gdx.graphics.Texture.clearAllTextures(this.d);
        com.badlogic.gdx.graphics.Cubemap.clearAllCubemaps(this.d);
        com.badlogic.gdx.graphics.TextureArray.clearAllTextureArrays(this.d);
        com.badlogic.gdx.graphics.glutils.ShaderProgram.clearAllShaderPrograms(this.d);
        com.badlogic.gdx.graphics.glutils.GLFrameBuffer.clearAllFrameBuffers(this.d);
        logManagedCachesStatus();
    }

    public android.view.View createGLSurfaceView(com.badlogic.gdx.backends.android.AndroidApplicationBase androidApplicationBase, com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy) {
        if (!checkGL20()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser eglConfigChooser = getEglConfigChooser();
        com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20 gLSurfaceView20 = new com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20(androidApplicationBase.getContext(), resolutionStrategy, this.config.useGL30 ? 3 : 2);
        if (eglConfigChooser != null) {
            gLSurfaceView20.setEGLConfigChooser(eglConfigChooser);
        } else {
            com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration = this.config;
            gLSurfaceView20.setEGLConfigChooser(androidApplicationConfiguration.r, androidApplicationConfiguration.g, androidApplicationConfiguration.b, androidApplicationConfiguration.a, androidApplicationConfiguration.depth, androidApplicationConfiguration.stencil);
        }
        gLSurfaceView20.setRenderer(this);
        return gLSurfaceView20;
    }

    public final void d(javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        javax.microedition.khronos.egl.EGL10 egl10 = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
        javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = egl10.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
        int c = c(egl10, eglGetDisplay, eGLConfig, 12324, 0);
        int c2 = c(egl10, eglGetDisplay, eGLConfig, 12323, 0);
        int c3 = c(egl10, eglGetDisplay, eGLConfig, 12322, 0);
        int c4 = c(egl10, eglGetDisplay, eGLConfig, 12321, 0);
        int c5 = c(egl10, eglGetDisplay, eGLConfig, 12325, 0);
        int c6 = c(egl10, eglGetDisplay, eGLConfig, 12326, 0);
        int max = java.lang.Math.max(c(egl10, eglGetDisplay, eGLConfig, 12337, 0), c(egl10, eglGetDisplay, eGLConfig, com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser.EGL_COVERAGE_SAMPLES_NV, 0));
        boolean z = c(egl10, eglGetDisplay, eGLConfig, com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser.EGL_COVERAGE_SAMPLES_NV, 0) != 0;
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "framebuffer: (" + c + ", " + c2 + ", " + c3 + ", " + c4 + ")");
        com.badlogic.gdx.Application application = com.badlogic.gdx.Gdx.app;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("depthbuffer: (");
        sb.append(c5);
        sb.append(")");
        application.log("AndroidGraphics", sb.toString());
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "stencilbuffer: (" + c6 + ")");
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "samples: (" + max + ")");
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "coverage sampling: (" + z + ")");
        this.t = new com.badlogic.gdx.Graphics.BufferFormat(c, c2, c3, c4, c5, c6, max, z);
    }

    @android.annotation.TargetApi(18)
    public final void e(javax.microedition.khronos.opengles.GL10 gl10) {
        com.badlogic.gdx.graphics.glutils.GLVersion gLVersion = new com.badlogic.gdx.graphics.glutils.GLVersion(com.badlogic.gdx.Application.ApplicationType.Android, gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_VERSION), gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_VENDOR), gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER));
        this.h = gLVersion;
        if (!this.config.useGL30 || gLVersion.getMajorVersion() <= 2) {
            if (this.e != null) {
                return;
            }
            com.badlogic.gdx.backends.android.AndroidGL20 androidGL20 = new com.badlogic.gdx.backends.android.AndroidGL20();
            this.e = androidGL20;
            com.badlogic.gdx.Gdx.gl = androidGL20;
            com.badlogic.gdx.Gdx.gl20 = androidGL20;
        } else {
            if (this.f != null) {
                return;
            }
            com.badlogic.gdx.backends.android.AndroidGL30 androidGL30 = new com.badlogic.gdx.backends.android.AndroidGL30();
            this.f = androidGL30;
            this.e = androidGL30;
            com.badlogic.gdx.Gdx.gl = androidGL30;
            com.badlogic.gdx.Gdx.gl20 = androidGL30;
            com.badlogic.gdx.Gdx.gl30 = androidGL30;
        }
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "OGL renderer: " + gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER));
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "OGL vendor: " + gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_VENDOR));
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "OGL version: " + gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_VERSION));
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "OGL extensions: " + gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_EXTENSIONS));
    }

    public final void f() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        this.d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.xdpi;
        this.o = f;
        float f2 = displayMetrics.ydpi;
        this.p = f2;
        this.q = f / 2.54f;
        this.r = f2 / 2.54f;
        this.f286s = displayMetrics.density;
    }

    @Override // com.badlogic.gdx.Graphics
    public int getBackBufferHeight() {
        return this.c;
    }

    @Override // com.badlogic.gdx.Graphics
    public int getBackBufferWidth() {
        return this.b;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.BufferFormat getBufferFormat() {
        return this.t;
    }

    @Override // com.badlogic.gdx.Graphics
    public float getDeltaTime() {
        return this.mean.getMean() == 0.0f ? this.deltaTime : this.mean.getMean();
    }

    @Override // com.badlogic.gdx.Graphics
    public float getDensity() {
        return this.f286s;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.DisplayMode getDisplayMode() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        this.d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new com.badlogic.gdx.backends.android.AndroidGraphics.AndroidDisplayMode(displayMetrics.widthPixels, displayMetrics.heightPixels, 0, 0);
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.DisplayMode getDisplayMode(com.badlogic.gdx.Graphics.Monitor monitor) {
        return getDisplayMode();
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.DisplayMode[] getDisplayModes() {
        return new com.badlogic.gdx.Graphics.DisplayMode[]{getDisplayMode()};
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.DisplayMode[] getDisplayModes(com.badlogic.gdx.Graphics.Monitor monitor) {
        return getDisplayModes();
    }

    public com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser getEglConfigChooser() {
        com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration = this.config;
        return new com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser(androidApplicationConfiguration.r, androidApplicationConfiguration.g, androidApplicationConfiguration.b, androidApplicationConfiguration.a, androidApplicationConfiguration.depth, androidApplicationConfiguration.stencil, androidApplicationConfiguration.numSamples);
    }

    @Override // com.badlogic.gdx.Graphics
    public long getFrameId() {
        return this.frameId;
    }

    @Override // com.badlogic.gdx.Graphics
    public int getFramesPerSecond() {
        return this.fps;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.graphics.GL20 getGL20() {
        return this.e;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.graphics.GL30 getGL30() {
        return this.f;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.graphics.glutils.GLVersion getGLVersion() {
        return this.h;
    }

    @Override // com.badlogic.gdx.Graphics
    public int getHeight() {
        return this.c;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.Monitor getMonitor() {
        return getPrimaryMonitor();
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.Monitor[] getMonitors() {
        return new com.badlogic.gdx.Graphics.Monitor[]{getPrimaryMonitor()};
    }

    @Override // com.badlogic.gdx.Graphics
    public float getPpcX() {
        return this.q;
    }

    @Override // com.badlogic.gdx.Graphics
    public float getPpcY() {
        return this.r;
    }

    @Override // com.badlogic.gdx.Graphics
    public float getPpiX() {
        return this.o;
    }

    @Override // com.badlogic.gdx.Graphics
    public float getPpiY() {
        return this.p;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.Monitor getPrimaryMonitor() {
        return new com.badlogic.gdx.backends.android.AndroidGraphics.AndroidMonitor(0, 0, "Primary Monitor");
    }

    @Override // com.badlogic.gdx.Graphics
    public float getRawDeltaTime() {
        return this.deltaTime;
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.Graphics.GraphicsType getType() {
        return com.badlogic.gdx.Graphics.GraphicsType.AndroidGL;
    }

    public android.view.View getView() {
        return this.a;
    }

    @Override // com.badlogic.gdx.Graphics
    public int getWidth() {
        return this.b;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean isContinuousRendering() {
        return this.u;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean isFullscreen() {
        return true;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean isGL30Available() {
        return this.f != null;
    }

    public void logManagedCachesStatus() {
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", com.badlogic.gdx.graphics.Mesh.getManagedStatus());
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", com.badlogic.gdx.graphics.Texture.getManagedStatus());
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", com.badlogic.gdx.graphics.Cubemap.getManagedStatus());
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", com.badlogic.gdx.graphics.glutils.ShaderProgram.getManagedStatus());
        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", com.badlogic.gdx.graphics.glutils.GLFrameBuffer.getManagedStatus());
    }

    @Override // com.badlogic.gdx.Graphics
    public com.badlogic.gdx.graphics.Cursor newCursor(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2) {
        return null;
    }

    @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long nanoTime = java.lang.System.nanoTime();
        this.deltaTime = (nanoTime - this.lastFrameTime) / 1.0E9f;
        this.lastFrameTime = nanoTime;
        if (this.m) {
            this.deltaTime = 0.0f;
        } else {
            this.mean.addValue(this.deltaTime);
        }
        synchronized (this.w) {
            z = this.k;
            z2 = this.l;
            z3 = this.n;
            z4 = this.m;
            if (this.m) {
                this.m = false;
            }
            if (this.l) {
                this.l = false;
                this.w.notifyAll();
            }
            if (this.n) {
                this.n = false;
                this.w.notifyAll();
            }
        }
        if (z2) {
            com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> lifecycleListeners = this.d.getLifecycleListeners();
            synchronized (lifecycleListeners) {
                com.badlogic.gdx.LifecycleListener[] begin = lifecycleListeners.begin();
                int i = lifecycleListeners.size;
                for (int i2 = 0; i2 < i; i2++) {
                    begin[i2].pause();
                }
            }
            this.d.getApplicationListener().pause();
            com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "paused");
        }
        if (z4) {
            com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> lifecycleListeners2 = this.d.getLifecycleListeners();
            synchronized (lifecycleListeners2) {
                com.badlogic.gdx.LifecycleListener[] begin2 = lifecycleListeners2.begin();
                int i3 = lifecycleListeners2.size;
                for (int i4 = 0; i4 < i3; i4++) {
                    begin2[i4].resume();
                }
                lifecycleListeners2.end();
            }
            this.d.getApplicationListener().resume();
            com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "resumed");
        }
        if (z) {
            synchronized (this.d.getRunnables()) {
                this.d.getExecutedRunnables().clear();
                this.d.getExecutedRunnables().addAll(this.d.getRunnables());
                this.d.getRunnables().clear();
            }
            for (int i5 = 0; i5 < this.d.getExecutedRunnables().size; i5++) {
                try {
                    this.d.getExecutedRunnables().get(i5).run();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            this.frameId++;
            this.d.getApplicationListener().render();
        }
        if (z3) {
            com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> lifecycleListeners3 = this.d.getLifecycleListeners();
            synchronized (lifecycleListeners3) {
                com.badlogic.gdx.LifecycleListener[] begin3 = lifecycleListeners3.begin();
                int i6 = lifecycleListeners3.size;
                for (int i7 = 0; i7 < i6; i7++) {
                    begin3[i7].dispose();
                }
            }
            this.d.getApplicationListener().dispose();
            com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "destroyed");
        }
        if (nanoTime - this.frameStart > 1000000000) {
            this.fps = this.frames;
            this.frames = 0;
            this.frameStart = nanoTime;
        }
        this.frames++;
    }

    public void onPauseGLSurfaceView() {
        android.view.View view = this.a;
        if (view == null || !(view instanceof com.badlogic.gdx.backends.android.surfaceview.GLTextureView)) {
            return;
        }
        ((com.badlogic.gdx.backends.android.surfaceview.GLTextureView) view).onPause();
    }

    public void onResumeGLSurfaceView() {
        android.view.View view = this.a;
        if (view == null || !(view instanceof com.badlogic.gdx.backends.android.surfaceview.GLTextureView)) {
            return;
        }
        ((com.badlogic.gdx.backends.android.surfaceview.GLTextureView) view).onResume();
    }

    @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
        this.b = i;
        this.c = i2;
        f();
        gl10.glViewport(0, 0, this.b, this.c);
        if (!this.j) {
            this.d.getApplicationListener().create();
            this.j = true;
            synchronized (this) {
                this.k = true;
            }
        }
        this.d.getApplicationListener().resize(i, i2);
    }

    @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onSurfaceCreated() called with: gl = [");
        sb.append(gl10);
        sb.append("], config = [");
        sb.append(eGLConfig);
        sb.append("]");
        this.g = ((javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL()).eglGetCurrentContext();
        e(gl10);
        d(eGLConfig);
        f();
        com.badlogic.gdx.graphics.Mesh.invalidateAllMeshes(this.d);
        com.badlogic.gdx.graphics.Texture.invalidateAllTextures(this.d);
        com.badlogic.gdx.graphics.Cubemap.invalidateAllCubemaps(this.d);
        com.badlogic.gdx.graphics.TextureArray.invalidateAllTextureArrays(this.d);
        com.badlogic.gdx.graphics.glutils.ShaderProgram.invalidateAllShaderPrograms(this.d);
        com.badlogic.gdx.graphics.glutils.GLFrameBuffer.invalidateAllFrameBuffers(this.d);
        logManagedCachesStatus();
        android.view.Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
        this.b = defaultDisplay.getWidth();
        this.c = defaultDisplay.getHeight();
        this.mean = new com.badlogic.gdx.math.WindowedMean(5);
        this.lastFrameTime = java.lang.System.nanoTime();
        gl10.glViewport(0, 0, this.b, this.c);
    }

    public void pause() {
        synchronized (this.w) {
            if (this.k) {
                if (!this.j) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("AndroidGraphics pause: created:");
                    sb.append(this.j);
                    sb.append(" return");
                    return;
                }
                this.k = false;
                this.l = true;
                if (this.m) {
                    return;
                }
                while (this.l) {
                    try {
                        this.w.wait(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
                        if (this.l) {
                            com.badlogic.gdx.Gdx.app.error("AndroidGraphics", "waiting for pause synchronization took too long; assuming deadlock and killing");
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    } catch (java.lang.InterruptedException unused) {
                        com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "waiting for pause synchronization failed!");
                    }
                }
            }
        }
    }

    public void preserveEGLContextOnPause() {
        android.view.View view = this.a;
        if (view instanceof com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20) {
            try {
                view.getClass().getMethod("setPreserveEGLContextOnPause", java.lang.Boolean.TYPE).invoke(this.a, java.lang.Boolean.TRUE);
            } catch (java.lang.Exception unused) {
                com.badlogic.gdx.Gdx.app.log("AndroidGraphics", "Method GLSurfaceView.setPreserveEGLContextOnPause not found");
            }
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public void requestRendering() {
        android.view.View view = this.a;
        if (view == null || !(view instanceof com.badlogic.gdx.backends.android.surfaceview.GLTextureView)) {
            return;
        }
        ((com.badlogic.gdx.backends.android.surfaceview.GLTextureView) view).requestRender();
    }

    public void resume() {
        synchronized (this.w) {
            this.k = true;
            this.m = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // com.badlogic.gdx.Graphics
    public void setContinuousRendering(boolean z) {
        if (this.a != null) {
            ?? r3 = (x || z) ? 1 : 0;
            this.u = r3;
            android.view.View view = this.a;
            if (view instanceof com.badlogic.gdx.backends.android.surfaceview.GLTextureView) {
                ((com.badlogic.gdx.backends.android.surfaceview.GLTextureView) view).setRenderMode(r3);
            }
            this.mean.clear();
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public void setCursor(com.badlogic.gdx.graphics.Cursor cursor) {
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean setFullscreenMode(com.badlogic.gdx.Graphics.DisplayMode displayMode) {
        return false;
    }

    @Override // com.badlogic.gdx.Graphics
    public void setResizable(boolean z) {
    }

    @Override // com.badlogic.gdx.Graphics
    public void setSystemCursor(com.badlogic.gdx.graphics.Cursor.SystemCursor systemCursor) {
    }

    @Override // com.badlogic.gdx.Graphics
    public void setTitle(java.lang.String str) {
    }

    @Override // com.badlogic.gdx.Graphics
    public void setUndecorated(boolean z) {
        this.d.getApplicationWindow().setFlags(1024, z ? 1 : 0);
    }

    @Override // com.badlogic.gdx.Graphics
    public void setVSync(boolean z) {
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean setWindowedMode(int i, int i2) {
        return false;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean supportsDisplayModeChange() {
        return false;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean supportsExtension(java.lang.String str) {
        if (this.i == null) {
            this.i = com.badlogic.gdx.Gdx.gl.glGetString(com.badlogic.gdx.graphics.GL20.GL_EXTENSIONS);
        }
        return this.i.contains(str);
    }
}
