package com.badlogic.gdx.backends.android.surfaceview;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class GLTextureView extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener, android.view.View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final java.lang.String TAG = "GLTextureView";
    private static final com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThreadManager sGLThreadManager = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThreadManager(null);
    private int mDebugFlags;
    private boolean mDetached;
    private com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory mEGLContextFactory;
    private com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread mGLThread;
    private com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private com.badlogic.gdx.backends.android.surfaceview.GLTextureView.Renderer mRenderer;
    private androidx.lifecycle.MutableLiveData<com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv> mShareEGLEnvMutableLiveData;
    private final java.lang.ref.WeakReference<com.badlogic.gdx.backends.android.surfaceview.GLTextureView> mThisWeakRef;

    public abstract class BaseConfigChooser implements com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser {
        public int[] a;

        public BaseConfigChooser(int[] iArr) {
            this.a = b(iArr);
        }

        public abstract javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr);

        public final int[] b(int[] iArr) {
            if (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.this.mEGLContextClientVersion != 2 && com.badlogic.gdx.backends.android.surfaceview.GLTextureView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser
        public javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                throw new java.lang.IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("No configs match configSpec");
            }
            javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                throw new java.lang.IllegalArgumentException("eglChooseConfig#2 failed");
            }
            javax.microedition.khronos.egl.EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
            if (a != null) {
                return a;
            }
            throw new java.lang.IllegalArgumentException("No config chosen");
        }
    }

    public class ComponentSizeChooser extends com.badlogic.gdx.backends.android.surfaceview.GLTextureView.BaseConfigChooser {
        public int[] c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.BaseConfigChooser
        public javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : eGLConfigArr) {
                int c = c(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int c2 = c(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (c >= this.h && c2 >= this.i) {
                    int c3 = c(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int c4 = c(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int c5 = c(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int c6 = c(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (c3 == this.d && c4 == this.e && c5 == this.f && c6 == this.g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int c(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.c) ? this.c[0] : i2;
        }
    }

    public class DefaultContextFactory implements com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory {
        public int a;

        public DefaultContextFactory() {
            this.a = 12440;
        }

        public /* synthetic */ DefaultContextFactory(com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView, defpackage.kj0 kj0Var) {
            this();
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory
        public javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            int[] iArr = {this.a, com.badlogic.gdx.backends.android.surfaceview.GLTextureView.this.mEGLContextClientVersion, 12344};
            javax.microedition.khronos.egl.EGLContext eGLContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
            if (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory
        public void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("display:");
            sb.append(eGLDisplay);
            sb.append(" context: ");
            sb.append(eGLContext);
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EglHelper.k("eglDestroyContex", egl10.eglGetError());
        }
    }

    public static class DefaultWindowSurfaceFactory implements com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLWindowSurfaceFactory {
        public DefaultWindowSurfaceFactory() {
        }

        public /* synthetic */ DefaultWindowSurfaceFactory(defpackage.lj0 lj0Var) {
            this();
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLWindowSurfaceFactory
        public javax.microedition.khronos.egl.EGLSurface createWindowSurface(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface EGLConfigChooser {
        javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig);

        void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        javax.microedition.khronos.egl.EGLSurface createWindowSurface(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj);

        void destroySurface(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface);
    }

    public static class EglHelper {
        public java.lang.ref.WeakReference<com.badlogic.gdx.backends.android.surfaceview.GLTextureView> a;
        public javax.microedition.khronos.egl.EGL10 b;
        public javax.microedition.khronos.egl.EGLDisplay c;
        public javax.microedition.khronos.egl.EGLSurface d;
        public javax.microedition.khronos.egl.EGLConfig e;
        public javax.microedition.khronos.egl.EGLContext f;

        public EglHelper(java.lang.ref.WeakReference<com.badlogic.gdx.backends.android.surfaceview.GLTextureView> weakReference) {
            this.a = weakReference;
        }

        public static java.lang.String f(java.lang.String str, int i) {
            return str + " failed: " + i;
        }

        public static void g(java.lang.String str, java.lang.String str2, int i) {
            f(str2, i);
        }

        public static void k(java.lang.String str, int i) {
            throw new java.lang.RuntimeException(f(str, i));
        }

        public javax.microedition.khronos.opengles.GL a() {
            javax.microedition.khronos.opengles.GL gl = this.f.getGL();
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.mGLWrapper != null) {
                gl = gLTextureView.mGLWrapper.wrap(gl);
            }
            if ((gLTextureView.mDebugFlags & 3) != 0) {
                return android.opengl.GLDebugHelper.wrap(gl, (gLTextureView.mDebugFlags & 1) == 0 ? 0 : 1, (gLTextureView.mDebugFlags & 2) != 0 ? new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.LogWriter() : null);
            }
            return gl;
        }

        public boolean b() {
            if (this.b == null) {
                throw new java.lang.RuntimeException("egl not initialized");
            }
            if (this.c == null) {
                throw new java.lang.RuntimeException("eglDisplay not initialized");
            }
            if (this.e == null) {
                throw new java.lang.RuntimeException("mEglConfig not initialized");
            }
            d();
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView != null) {
                this.d = gLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.b, this.c, this.e, gLTextureView.getSurfaceTexture());
            } else {
                this.d = null;
            }
            javax.microedition.khronos.egl.EGLSurface eGLSurface = this.d;
            if (eGLSurface == null || eGLSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                this.b.eglGetError();
                return false;
            }
            if (this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, this.f)) {
                return true;
            }
            g("EGLHelper", "eglMakeCurrent", this.b.eglGetError());
            return false;
        }

        public void c() {
            d();
        }

        public final void d() {
            javax.microedition.khronos.egl.EGLSurface eGLSurface;
            javax.microedition.khronos.egl.EGLSurface eGLSurface2 = this.d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView != null) {
                gLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.b, this.c, this.d);
            }
            this.d = null;
        }

        public void e() {
            if (this.f != null) {
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView = this.a.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLContextFactory.destroyContext(this.b, this.c, this.f);
                }
                this.f = null;
            }
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.c;
            if (eGLDisplay != null) {
                this.b.eglTerminate(eGLDisplay);
                this.c = null;
            }
        }

        public void h() {
            javax.microedition.khronos.egl.EGL10 egl10 = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
            this.b = egl10;
            javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = egl10.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
            this.c = eglGetDisplay;
            if (eglGetDisplay == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) {
                throw new java.lang.RuntimeException("eglGetDisplay failed");
            }
            if (!this.b.eglInitialize(eglGetDisplay, new int[2])) {
                throw new java.lang.RuntimeException("eglInitialize failed");
            }
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView == null) {
                this.e = null;
                this.f = null;
            } else {
                this.e = gLTextureView.mEGLConfigChooser.chooseConfig(this.b, this.c);
                this.f = gLTextureView.mEGLContextFactory.createContext(this.b, this.c, this.e);
                if (gLTextureView.mShareEGLEnvMutableLiveData != null) {
                    gLTextureView.mShareEGLEnvMutableLiveData.postValue(new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv(this.f, this.e));
                }
            }
            javax.microedition.khronos.egl.EGLContext eGLContext = this.f;
            if (eGLContext == null || eGLContext == javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) {
                this.f = null;
                j("createContext");
            }
            this.d = null;
        }

        public int i() {
            return !this.b.eglSwapBuffers(this.c, this.d) ? this.b.eglGetError() : com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_BASE;
        }

        public final void j(java.lang.String str) {
            k(str, this.b.eglGetError());
        }
    }

    public static class GLThread extends java.lang.Thread {
        public boolean A;
        public boolean B;
        public boolean C;
        public boolean H;
        public com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EglHelper K;
        public java.lang.ref.WeakReference<com.badlogic.gdx.backends.android.surfaceview.GLTextureView> L;
        public boolean n;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;
        public java.util.ArrayList<java.lang.Runnable> I = new java.util.ArrayList<>();
        public boolean J = true;
        public int D = 0;
        public int E = 0;
        public boolean G = true;
        public int F = 1;

        public GLThread(java.lang.ref.WeakReference<com.badlogic.gdx.backends.android.surfaceview.GLTextureView> weakReference) {
            this.L = weakReference;
        }

        public boolean b() {
            return this.z && this.A && i();
        }

        public int c() {
            int i;
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                i = this.F;
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:179:0x0225 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void d() throws java.lang.InterruptedException {
            boolean z;
            this.K = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EglHelper(this.L);
            this.z = false;
            this.A = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            javax.microedition.khronos.opengles.GL10 gl10 = null;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int i = 0;
            int i2 = 0;
            boolean z9 = false;
            while (true) {
                java.lang.Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                            while (!this.n) {
                                if (this.I.isEmpty()) {
                                    boolean z10 = this.v;
                                    boolean z11 = this.u;
                                    if (z10 != z11) {
                                        this.v = z11;
                                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                                    } else {
                                        z11 = false;
                                    }
                                    if (this.C) {
                                        o();
                                        n();
                                        this.C = false;
                                        z4 = true;
                                    }
                                    if (z2) {
                                        o();
                                        n();
                                        z2 = false;
                                    }
                                    if (z11 && this.A) {
                                        o();
                                    }
                                    if (z11 && this.z) {
                                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView = this.L.get();
                                        if (!(gLTextureView != null && gLTextureView.mPreserveEGLContextOnPause) || com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.d()) {
                                            n();
                                        }
                                    }
                                    if (z11 && com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.e()) {
                                        this.K.e();
                                    }
                                    if (!this.w && !this.y) {
                                        if (this.A) {
                                            o();
                                        }
                                        this.y = true;
                                        this.x = false;
                                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                                    }
                                    if (this.w && this.y) {
                                        this.y = false;
                                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                                    }
                                    if (z3) {
                                        this.H = true;
                                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                                        z3 = false;
                                        z9 = false;
                                    }
                                    if (i()) {
                                        if (!this.z) {
                                            if (z4) {
                                                z4 = false;
                                            } else if (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.g(this)) {
                                                try {
                                                    this.K.h();
                                                    this.z = true;
                                                    com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                                                    z5 = true;
                                                } catch (java.lang.RuntimeException e) {
                                                    com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.c(this);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.z && !this.A) {
                                            this.A = true;
                                            z6 = true;
                                            z7 = true;
                                            z8 = true;
                                        }
                                        if (this.A) {
                                            if (this.J) {
                                                int i3 = this.D;
                                                int i4 = this.E;
                                                this.J = false;
                                                i = i3;
                                                i2 = i4;
                                                z = false;
                                                z6 = true;
                                                z8 = true;
                                                z9 = true;
                                            } else {
                                                z = false;
                                            }
                                            this.G = z;
                                            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                                        }
                                    }
                                    com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                                } else {
                                    runnable = this.I.remove(0);
                                }
                            }
                            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                                o();
                                n();
                            }
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                        }
                    }
                    if (runnable != null) {
                        break;
                    }
                    if (z6) {
                        if (this.K.b()) {
                            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                                this.B = true;
                                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                            }
                            z6 = false;
                        } else {
                            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                                this.B = true;
                                this.x = true;
                                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                            }
                        }
                        synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                            o();
                            n();
                            throw th;
                        }
                    }
                    if (z7) {
                        gl10 = (javax.microedition.khronos.opengles.GL10) this.K.a();
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.a(gl10);
                        z7 = false;
                    }
                    if (z5) {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView2 = this.L.get();
                        if (gLTextureView2 != null) {
                            gLTextureView2.mRenderer.onSurfaceCreated(gl10, this.K.e);
                        }
                        z5 = false;
                    }
                    if (z8) {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView3 = this.L.get();
                        if (gLTextureView3 != null) {
                            gLTextureView3.mRenderer.onSurfaceChanged(gl10, i, i2);
                        }
                        z8 = false;
                    }
                    com.badlogic.gdx.backends.android.surfaceview.GLTextureView gLTextureView4 = this.L.get();
                    if (gLTextureView4 != null) {
                        gLTextureView4.mRenderer.onDrawFrame(gl10);
                    }
                    int i5 = this.K.i();
                    if (i5 != 12288) {
                        if (i5 != 12302) {
                            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EglHelper.g("GLThread", "eglSwapBuffers", i5);
                            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                                this.x = true;
                                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                            }
                        } else {
                            z2 = true;
                        }
                    }
                    if (z9) {
                        z3 = true;
                    }
                }
                runnable.run();
            }
        }

        public void e() {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.u = true;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                while (!this.t && !this.v) {
                    try {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.u = false;
                this.G = true;
                this.H = false;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                while (!this.t && this.v && !this.H) {
                    try {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g(int i, int i2) {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.D = i;
                this.E = i2;
                this.J = true;
                this.G = true;
                this.H = false;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                while (!this.t && !this.v && !this.H && b()) {
                    try {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h(java.lang.Runnable runnable) {
            if (runnable == null) {
                throw new java.lang.IllegalArgumentException("r must not be null");
            }
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.I.add(runnable);
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public final boolean i() {
            return !this.v && this.w && !this.x && this.D > 0 && this.E > 0 && (this.G || this.F == 1);
        }

        public void j() {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.n = true;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                while (!this.t) {
                    try {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void k() {
            this.C = true;
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
        }

        public void l() {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.G = true;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public void m(int i) {
            if (i < 0 || i > 1) {
                throw new java.lang.IllegalArgumentException("renderMode");
            }
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.F = i;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public final void n() {
            if (this.z) {
                this.K.e();
                this.z = false;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.c(this);
            }
        }

        public final void o() {
            if (this.A) {
                this.A = false;
                this.K.c();
            }
        }

        public void p() {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.w = true;
                this.B = false;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                while (this.y && !this.B && !this.t) {
                    try {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void q() {
            synchronized (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager) {
                this.w = false;
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.notifyAll();
                while (!this.y && !this.t) {
                    try {
                        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                d();
            } catch (java.lang.InterruptedException unused) {
            } catch (java.lang.Throwable th) {
                com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.f(this);
                throw th;
            }
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.sGLThreadManager.f(this);
        }
    }

    public static class GLThreadManager {
        public boolean a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread f;

        public GLThreadManager() {
        }

        public /* synthetic */ GLThreadManager(defpackage.mj0 mj0Var) {
            this();
        }

        public synchronized void a(javax.microedition.khronos.opengles.GL10 gl10) {
            if (!this.c) {
                b();
                java.lang.String glGetString = gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER);
                if (this.b < 131072) {
                    this.d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.e = this.d ? false : true;
                this.c = true;
            }
        }

        public final void b() {
            if (this.a) {
                return;
            }
            this.a = true;
        }

        public void c(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread) {
            if (this.f == gLThread) {
                this.f = null;
            }
            notifyAll();
        }

        public synchronized boolean d() {
            return this.e;
        }

        public synchronized boolean e() {
            b();
            return !this.d;
        }

        public synchronized void f(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread) {
            gLThread.t = true;
            if (this.f == gLThread) {
                this.f = null;
            }
            notifyAll();
        }

        public boolean g(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread) {
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread2 = this.f;
            if (gLThread2 == gLThread || gLThread2 == null) {
                this.f = gLThread;
                notifyAll();
                return true;
            }
            b();
            if (this.d) {
                return true;
            }
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread3 = this.f;
            if (gLThread3 == null) {
                return false;
            }
            gLThread3.k();
            return false;
        }
    }

    public interface GLWrapper {
        javax.microedition.khronos.opengles.GL wrap(javax.microedition.khronos.opengles.GL gl);
    }

    public static class LogWriter extends java.io.Writer {
        public java.lang.StringBuilder n = new java.lang.StringBuilder();

        public final void a() {
            if (this.n.length() > 0) {
                this.n.toString();
                java.lang.StringBuilder sb = this.n;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.n.append(c);
                }
            }
        }
    }

    public interface Renderer {
        void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10);

        void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2);

        void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig);
    }

    public static class ShareEGLEnv {
        public javax.microedition.khronos.egl.EGLConfig mEGLConfig;
        public javax.microedition.khronos.egl.EGLContext mEGLContext;

        public ShareEGLEnv(javax.microedition.khronos.egl.EGLContext eGLContext, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            this.mEGLContext = eGLContext;
            this.mEGLConfig = eGLConfig;
        }
    }

    public class SimpleEGLConfigChooser extends com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(android.content.Context context) {
        super(context);
        this.mThisWeakRef = new java.lang.ref.WeakReference<>(this);
        init();
    }

    public GLTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThisWeakRef = new java.lang.ref.WeakReference<>(this);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new java.lang.IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void finalize() throws java.lang.Throwable {
        try {
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.j();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.c();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread = this.mGLThread;
            int c = gLThread != null ? gLThread.c() : 1;
            com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread2 = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (c != 1) {
                gLThread2.m(c);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.j();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        surfaceChanged(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    public void onPause() {
        this.mGLThread.e();
    }

    public void onResume() {
        this.mGLThread.f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceChanged(surfaceTexture, 0, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(java.lang.Runnable runnable) {
        this.mGLThread.h(runnable);
    }

    public void requestRender() {
        this.mGLThread.l();
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void setEGLConfigChooser(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.SimpleEGLConfigChooser(z));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setEGLContextFactory(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public void setRenderMode(int i) {
        this.mGLThread.m(i);
    }

    public void setRenderer(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.DefaultContextFactory(this, null);
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.DefaultWindowSurfaceFactory(null);
        }
        this.mRenderer = renderer;
        com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread gLThread = new com.badlogic.gdx.backends.android.surfaceview.GLTextureView.GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void setShareEGLEnvMutableLiveData(androidx.lifecycle.MutableLiveData<com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv> mutableLiveData) {
        this.mShareEGLEnvMutableLiveData = mutableLiveData;
    }

    public void surfaceChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.mGLThread.g(i2, i3);
    }

    public void surfaceCreated(android.graphics.SurfaceTexture surfaceTexture) {
        this.mGLThread.p();
    }

    public void surfaceDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        this.mGLThread.q();
    }
}
