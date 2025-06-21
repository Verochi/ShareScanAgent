package jp.co.cyberagent.android.gpuimage;

/* loaded from: classes14.dex */
public class GLTextureView extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener, android.view.View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final java.lang.String E = "GLTextureView";
    public static final jp.co.cyberagent.android.gpuimage.GLTextureView.GLThreadManager F = new jp.co.cyberagent.android.gpuimage.GLTextureView.GLThreadManager(null);
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public int A;
    public int B;
    public boolean C;
    public java.util.List<android.view.TextureView.SurfaceTextureListener> D;
    public final java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> n;
    public jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread t;
    public jp.co.cyberagent.android.gpuimage.GLTextureView.Renderer u;
    public boolean v;
    public jp.co.cyberagent.android.gpuimage.GLTextureView.EGLConfigChooser w;
    public jp.co.cyberagent.android.gpuimage.GLTextureView.EGLContextFactory x;
    public jp.co.cyberagent.android.gpuimage.GLTextureView.EGLWindowSurfaceFactory y;
    public jp.co.cyberagent.android.gpuimage.GLTextureView.GLWrapper z;

    public abstract class BaseConfigChooser implements jp.co.cyberagent.android.gpuimage.GLTextureView.EGLConfigChooser {
        public int[] a;

        public BaseConfigChooser(int[] iArr) {
            this.a = b(iArr);
        }

        public abstract javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr);

        public final int[] b(int[] iArr) {
            if (jp.co.cyberagent.android.gpuimage.GLTextureView.this.B != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // jp.co.cyberagent.android.gpuimage.GLTextureView.EGLConfigChooser
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

    public class ComponentSizeChooser extends jp.co.cyberagent.android.gpuimage.GLTextureView.BaseConfigChooser {
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

        @Override // jp.co.cyberagent.android.gpuimage.GLTextureView.BaseConfigChooser
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

    public class DefaultContextFactory implements jp.co.cyberagent.android.gpuimage.GLTextureView.EGLContextFactory {
        public int a;

        public DefaultContextFactory() {
            this.a = 12440;
        }

        public /* synthetic */ DefaultContextFactory(jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView, jp.co.cyberagent.android.gpuimage.GLTextureView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // jp.co.cyberagent.android.gpuimage.GLTextureView.EGLContextFactory
        public javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            int[] iArr = {this.a, jp.co.cyberagent.android.gpuimage.GLTextureView.this.B, 12344};
            javax.microedition.khronos.egl.EGLContext eGLContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
            if (jp.co.cyberagent.android.gpuimage.GLTextureView.this.B == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // jp.co.cyberagent.android.gpuimage.GLTextureView.EGLContextFactory
        public void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("display:");
            sb.append(eGLDisplay);
            sb.append(" context: ");
            sb.append(eGLContext);
            jp.co.cyberagent.android.gpuimage.GLTextureView.EglHelper.k("eglDestroyContex", egl10.eglGetError());
        }
    }

    public static class DefaultWindowSurfaceFactory implements jp.co.cyberagent.android.gpuimage.GLTextureView.EGLWindowSurfaceFactory {
        public DefaultWindowSurfaceFactory() {
        }

        public /* synthetic */ DefaultWindowSurfaceFactory(jp.co.cyberagent.android.gpuimage.GLTextureView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // jp.co.cyberagent.android.gpuimage.GLTextureView.EGLWindowSurfaceFactory
        public javax.microedition.khronos.egl.EGLSurface createWindowSurface(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (java.lang.IllegalArgumentException unused) {
                java.lang.String unused2 = jp.co.cyberagent.android.gpuimage.GLTextureView.E;
                return null;
            }
        }

        @Override // jp.co.cyberagent.android.gpuimage.GLTextureView.EGLWindowSurfaceFactory
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
        public java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> a;
        public javax.microedition.khronos.egl.EGL10 b;
        public javax.microedition.khronos.egl.EGLDisplay c;
        public javax.microedition.khronos.egl.EGLSurface d;
        public javax.microedition.khronos.egl.EGLConfig e;
        public javax.microedition.khronos.egl.EGLContext f;

        public EglHelper(java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> weakReference) {
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
            jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.z != null) {
                gl = gLTextureView.z.wrap(gl);
            }
            if ((gLTextureView.A & 3) != 0) {
                return android.opengl.GLDebugHelper.wrap(gl, (gLTextureView.A & 1) == 0 ? 0 : 1, (gLTextureView.A & 2) != 0 ? new jp.co.cyberagent.android.gpuimage.GLTextureView.LogWriter() : null);
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
                throw new java.lang.RuntimeException("eglConfig not initialized");
            }
            d();
            jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView != null) {
                this.d = gLTextureView.y.createWindowSurface(this.b, this.c, this.e, gLTextureView.getSurfaceTexture());
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
            jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView != null) {
                gLTextureView.y.destroySurface(this.b, this.c, this.d);
            }
            this.d = null;
        }

        public void e() {
            if (this.f != null) {
                jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView = this.a.get();
                if (gLTextureView != null) {
                    gLTextureView.x.destroyContext(this.b, this.c, this.f);
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
            jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView = this.a.get();
            if (gLTextureView == null) {
                this.e = null;
                this.f = null;
            } else {
                this.e = gLTextureView.w.chooseConfig(this.b, this.c);
                this.f = gLTextureView.x.createContext(this.b, this.c, this.e);
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
        public boolean G;
        public jp.co.cyberagent.android.gpuimage.GLTextureView.EglHelper J;
        public java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> K;
        public boolean n;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;
        public java.util.ArrayList<java.lang.Runnable> H = new java.util.ArrayList<>();
        public boolean I = true;
        public int C = 0;
        public int D = 0;
        public boolean F = true;
        public int E = 1;

        public GLThread(java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.GLTextureView> weakReference) {
            this.K = weakReference;
        }

        public boolean a() {
            return this.z && this.A && i();
        }

        public int c() {
            int i;
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                i = this.E;
            }
            return i;
        }

        public final void d() throws java.lang.InterruptedException {
            boolean z;
            this.J = new jp.co.cyberagent.android.gpuimage.GLTextureView.EglHelper(this.K);
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
                        synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                            while (!this.n) {
                                if (this.H.isEmpty()) {
                                    boolean z10 = this.v;
                                    boolean z11 = this.u;
                                    if (z10 != z11) {
                                        this.v = z11;
                                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                    } else {
                                        z11 = false;
                                    }
                                    if (this.B) {
                                        o();
                                        n();
                                        this.B = false;
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
                                        jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView = this.K.get();
                                        if (!(gLTextureView == null ? false : gLTextureView.C) || jp.co.cyberagent.android.gpuimage.GLTextureView.F.d()) {
                                            n();
                                        }
                                    }
                                    if (z11 && jp.co.cyberagent.android.gpuimage.GLTextureView.F.e()) {
                                        this.J.e();
                                    }
                                    if (!this.w && !this.y) {
                                        if (this.A) {
                                            o();
                                        }
                                        this.y = true;
                                        this.x = false;
                                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                    }
                                    if (this.w && this.y) {
                                        this.y = false;
                                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                    }
                                    if (z3) {
                                        this.G = true;
                                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                        z3 = false;
                                        z9 = false;
                                    }
                                    if (i()) {
                                        if (!this.z) {
                                            if (z4) {
                                                z4 = false;
                                            } else if (jp.co.cyberagent.android.gpuimage.GLTextureView.F.g(this)) {
                                                try {
                                                    this.J.h();
                                                    this.z = true;
                                                    jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                                    z5 = true;
                                                } catch (java.lang.RuntimeException e) {
                                                    jp.co.cyberagent.android.gpuimage.GLTextureView.F.c(this);
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
                                            if (this.I) {
                                                int i3 = this.C;
                                                int i4 = this.D;
                                                this.I = false;
                                                i = i3;
                                                i2 = i4;
                                                z = false;
                                                z6 = true;
                                                z8 = true;
                                                z9 = true;
                                            } else {
                                                z = false;
                                            }
                                            this.F = z;
                                            jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                        }
                                    }
                                    jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
                                } else {
                                    runnable = this.H.remove(0);
                                }
                            }
                            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                                o();
                                n();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z6) {
                            if (this.J.b()) {
                                z6 = false;
                            } else {
                                synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                                    this.x = true;
                                    jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                }
                            }
                        }
                        if (z7) {
                            gl10 = (javax.microedition.khronos.opengles.GL10) this.J.a();
                            jp.co.cyberagent.android.gpuimage.GLTextureView.F.a(gl10);
                            z7 = false;
                        }
                        if (z5) {
                            jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView2 = this.K.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.u.onSurfaceCreated(gl10, this.J.e);
                            }
                            z5 = false;
                        }
                        if (z8) {
                            jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView3 = this.K.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.u.onSurfaceChanged(gl10, i, i2);
                            }
                            z8 = false;
                        }
                        jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView4 = this.K.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.u.onDrawFrame(gl10);
                        }
                        int i5 = this.J.i();
                        if (i5 != 12288) {
                            if (i5 != 12302) {
                                jp.co.cyberagent.android.gpuimage.GLTextureView.EglHelper.g("GLThread", "eglSwapBuffers", i5);
                                synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                                    this.x = true;
                                    jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                                }
                            } else {
                                z2 = true;
                            }
                        }
                        if (z9) {
                            z3 = true;
                        }
                    } catch (java.lang.Throwable th) {
                        synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                            o();
                            n();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        public void e() {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.u = true;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                while (!this.t && !this.v) {
                    try {
                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.u = false;
                this.F = true;
                this.G = false;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                while (!this.t && this.v && !this.G) {
                    try {
                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g(int i, int i2) {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.C = i;
                this.D = i2;
                this.I = true;
                this.F = true;
                this.G = false;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                while (!this.t && !this.v && !this.G && a()) {
                    try {
                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
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
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.H.add(runnable);
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
            }
        }

        public final boolean i() {
            return !this.v && this.w && !this.x && this.C > 0 && this.D > 0 && (this.F || this.E == 1);
        }

        public void j() {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.n = true;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                while (!this.t) {
                    try {
                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void k() {
            this.B = true;
            jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
        }

        public void l() {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.F = true;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
            }
        }

        public void m(int i) {
            if (i < 0 || i > 1) {
                throw new java.lang.IllegalArgumentException("renderMode");
            }
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.E = i;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
            }
        }

        public final void n() {
            if (this.z) {
                this.J.e();
                this.z = false;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.c(this);
            }
        }

        public final void o() {
            if (this.A) {
                this.A = false;
                this.J.c();
            }
        }

        public void p() {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.w = true;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                while (this.y && !this.t) {
                    try {
                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void q() {
            synchronized (jp.co.cyberagent.android.gpuimage.GLTextureView.F) {
                this.w = false;
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.notifyAll();
                while (!this.y && !this.t) {
                    try {
                        jp.co.cyberagent.android.gpuimage.GLTextureView.F.wait();
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
                jp.co.cyberagent.android.gpuimage.GLTextureView.F.f(this);
                throw th;
            }
            jp.co.cyberagent.android.gpuimage.GLTextureView.F.f(this);
        }
    }

    public static class GLThreadManager {
        public boolean a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread f;

        public GLThreadManager() {
        }

        public /* synthetic */ GLThreadManager(jp.co.cyberagent.android.gpuimage.GLTextureView.AnonymousClass1 anonymousClass1) {
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

        public void c(jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread) {
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

        public synchronized void f(jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread) {
            gLThread.t = true;
            if (this.f == gLThread) {
                this.f = null;
            }
            notifyAll();
        }

        public boolean g(jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread) {
            jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread2 = this.f;
            if (gLThread2 == gLThread || gLThread2 == null) {
                this.f = gLThread;
                notifyAll();
                return true;
            }
            b();
            if (this.d) {
                return true;
            }
            jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread3 = this.f;
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

    public class SimpleEGLConfigChooser extends jp.co.cyberagent.android.gpuimage.GLTextureView.ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(android.content.Context context) {
        super(context);
        this.n = new java.lang.ref.WeakReference<>(this);
        this.D = new java.util.ArrayList();
        l();
    }

    public GLTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new java.lang.ref.WeakReference<>(this);
        this.D = new java.util.ArrayList();
        l();
    }

    private void l() {
        setSurfaceTextureListener(this);
    }

    public void addSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.D.add(surfaceTextureListener);
    }

    public void finalize() throws java.lang.Throwable {
        try {
            jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread = this.t;
            if (gLThread != null) {
                gLThread.j();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.A;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.C;
    }

    public int getRenderMode() {
        return this.t.c();
    }

    public final void k() {
        if (this.t != null) {
            throw new java.lang.IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.v && this.u != null) {
            jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread = this.t;
            int c = gLThread != null ? gLThread.c() : 1;
            jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread2 = new jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread(this.n);
            this.t = gLThread2;
            if (c != 1) {
                gLThread2.m(c);
            }
            this.t.start();
        }
        this.v = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread = this.t;
        if (gLThread != null) {
            gLThread.j();
        }
        this.v = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        surfaceChanged(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    public void onPause() {
        this.t.e();
    }

    public void onResume() {
        this.t.f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i, i2);
        java.util.Iterator<android.view.TextureView.SurfaceTextureListener> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        java.util.Iterator<android.view.TextureView.SurfaceTextureListener> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureDestroyed(surfaceTexture);
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceChanged(surfaceTexture, 0, i, i2);
        java.util.Iterator<android.view.TextureView.SurfaceTextureListener> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        requestRender();
        java.util.Iterator<android.view.TextureView.SurfaceTextureListener> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void queueEvent(java.lang.Runnable runnable) {
        this.t.h(runnable);
    }

    public void requestRender() {
        this.t.l();
    }

    public void setDebugFlags(int i) {
        this.A = i;
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new jp.co.cyberagent.android.gpuimage.GLTextureView.ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void setEGLConfigChooser(jp.co.cyberagent.android.gpuimage.GLTextureView.EGLConfigChooser eGLConfigChooser) {
        k();
        this.w = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new jp.co.cyberagent.android.gpuimage.GLTextureView.SimpleEGLConfigChooser(z));
    }

    public void setEGLContextClientVersion(int i) {
        k();
        this.B = i;
    }

    public void setEGLContextFactory(jp.co.cyberagent.android.gpuimage.GLTextureView.EGLContextFactory eGLContextFactory) {
        k();
        this.x = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(jp.co.cyberagent.android.gpuimage.GLTextureView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        k();
        this.y = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(jp.co.cyberagent.android.gpuimage.GLTextureView.GLWrapper gLWrapper) {
        this.z = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.C = z;
    }

    public void setRenderMode(int i) {
        this.t.m(i);
    }

    public void setRenderer(jp.co.cyberagent.android.gpuimage.GLTextureView.Renderer renderer) {
        k();
        if (this.w == null) {
            this.w = new jp.co.cyberagent.android.gpuimage.GLTextureView.SimpleEGLConfigChooser(true);
        }
        if (this.x == null) {
            this.x = new jp.co.cyberagent.android.gpuimage.GLTextureView.DefaultContextFactory(this, null);
        }
        if (this.y == null) {
            this.y = new jp.co.cyberagent.android.gpuimage.GLTextureView.DefaultWindowSurfaceFactory(null);
        }
        this.u = renderer;
        jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread gLThread = new jp.co.cyberagent.android.gpuimage.GLTextureView.GLThread(this.n);
        this.t = gLThread;
        gLThread.start();
    }

    public void surfaceChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.t.g(i2, i3);
    }

    public void surfaceCreated(android.graphics.SurfaceTexture surfaceTexture) {
        this.t.p();
    }

    public void surfaceDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        this.t.q();
    }
}
