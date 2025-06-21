package com.amap.api.mapcore.util;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public class m extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener {
    private static final com.amap.api.mapcore.util.m.j a = new com.amap.api.mapcore.util.m.j((byte) 0);
    private final java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> b;
    private com.amap.api.mapcore.util.m.i c;
    private android.opengl.GLSurfaceView.Renderer d;
    private boolean e;
    private com.amap.api.mapcore.util.m.e f;
    private com.amap.api.mapcore.util.m.f g;
    private com.amap.api.mapcore.util.m.g h;
    private com.amap.api.mapcore.util.m.k i;
    private int j;
    private int k;
    private boolean l;

    public abstract class a implements com.amap.api.mapcore.util.m.e {
        protected int[] a;

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (com.amap.api.mapcore.util.m.this.k != 2 && com.amap.api.mapcore.util.m.this.k != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (com.amap.api.mapcore.util.m.this.k == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.mapcore.util.m.e
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

    public class b extends com.amap.api.mapcore.util.m.a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
            this.j = new int[1];
            this.c = 8;
            this.d = 8;
            this.e = 8;
            this.f = 0;
            this.g = 16;
            this.h = 0;
        }

        private int a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
                return this.j[0];
            }
            return 0;
        }

        @Override // com.amap.api.mapcore.util.m.a
        public final javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    public class c implements com.amap.api.mapcore.util.m.f {
        private c() {
        }

        public /* synthetic */ c(com.amap.api.mapcore.util.m mVar, byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.m.f
        public final javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            int[] iArr = {12440, com.amap.api.mapcore.util.m.this.k, 12344};
            javax.microedition.khronos.egl.EGLContext eGLContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
            if (com.amap.api.mapcore.util.m.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.mapcore.util.m.f
        public final void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("display:");
            sb.append(eGLDisplay);
            sb.append(" context: ");
            sb.append(eGLContext);
            com.amap.api.mapcore.util.m.h.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    public static class d implements com.amap.api.mapcore.util.m.g {
        private d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.m.g
        public final javax.microedition.khronos.egl.EGLSurface a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }

        @Override // com.amap.api.mapcore.util.m.g
        public final void a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface e {
        javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay);
    }

    public interface f {
        javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig);

        void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext);
    }

    public interface g {
        javax.microedition.khronos.egl.EGLSurface a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj);

        void a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface);
    }

    public static class h {
        javax.microedition.khronos.egl.EGL10 a;
        javax.microedition.khronos.egl.EGLDisplay b;
        javax.microedition.khronos.egl.EGLSurface c;
        javax.microedition.khronos.egl.EGLConfig d;
        javax.microedition.khronos.egl.EGLContext e;
        private java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> f;

        public h(java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> weakReference) {
            this.f = weakReference;
        }

        private void a(java.lang.String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(java.lang.String str, int i) {
            throw new java.lang.RuntimeException(b(str, i));
        }

        public static void a(java.lang.String str, java.lang.String str2, int i) {
            b(str2, i);
        }

        private static java.lang.String b(java.lang.String str, int i) {
            return str + " failed: " + i;
        }

        private void g() {
            javax.microedition.khronos.egl.EGLSurface eGLSurface;
            javax.microedition.khronos.egl.EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
            com.amap.api.mapcore.util.m mVar = this.f.get();
            if (mVar != null) {
                mVar.h.a(this.a, this.b, this.c);
            }
            this.c = null;
        }

        public final void a() {
            javax.microedition.khronos.egl.EGL10 egl10 = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
            this.a = egl10;
            javax.microedition.khronos.egl.EGLDisplay eglGetDisplay = egl10.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) {
                throw new java.lang.RuntimeException("eglGetDisplay failed");
            }
            if (!this.a.eglInitialize(eglGetDisplay, new int[2])) {
                throw new java.lang.RuntimeException("eglInitialize failed");
            }
            com.amap.api.mapcore.util.m mVar = this.f.get();
            if (mVar == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = mVar.f.chooseConfig(this.a, this.b);
                this.e = mVar.g.createContext(this.a, this.b, this.d);
            }
            javax.microedition.khronos.egl.EGLContext eGLContext = this.e;
            if (eGLContext == null || eGLContext == javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            this.c = null;
        }

        public final boolean b() {
            if (this.a == null) {
                throw new java.lang.RuntimeException("egl not initialized");
            }
            if (this.b == null) {
                throw new java.lang.RuntimeException("eglDisplay not initialized");
            }
            if (this.d == null) {
                throw new java.lang.RuntimeException("mEglConfig not initialized");
            }
            g();
            com.amap.api.mapcore.util.m mVar = this.f.get();
            if (mVar != null) {
                this.c = mVar.h.a(this.a, this.b, this.d, mVar.getSurfaceTexture());
            } else {
                this.c = null;
            }
            javax.microedition.khronos.egl.EGLSurface eGLSurface = this.c;
            if (eGLSurface == null || eGLSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                this.a.eglGetError();
                return false;
            }
            if (this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                return true;
            }
            a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
            return false;
        }

        public final javax.microedition.khronos.opengles.GL c() {
            javax.microedition.khronos.opengles.GL gl = this.e.getGL();
            com.amap.api.mapcore.util.m mVar = this.f.get();
            if (mVar == null) {
                return gl;
            }
            if (mVar.i != null) {
                gl = mVar.i.a();
            }
            if ((mVar.j & 3) != 0) {
                return android.opengl.GLDebugHelper.wrap(gl, (mVar.j & 1) == 0 ? 0 : 1, (mVar.j & 2) != 0 ? new com.amap.api.mapcore.util.m.l() : null);
            }
            return gl;
        }

        public final int d() {
            return !this.a.eglSwapBuffers(this.b, this.c) ? this.a.eglGetError() : com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_BASE;
        }

        public final void e() {
            g();
        }

        public final void f() {
            if (this.e != null) {
                com.amap.api.mapcore.util.m mVar = this.f.get();
                if (mVar != null) {
                    mVar.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }
    }

    public static class i extends java.lang.Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean p;

        /* renamed from: s, reason: collision with root package name */
        private com.amap.api.mapcore.util.m.h f138s;
        private java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> t;
        private java.util.ArrayList<java.lang.Runnable> q = new java.util.ArrayList<>();
        private boolean r = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;

        public i(java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> weakReference) {
            this.t = weakReference;
        }

        public static /* synthetic */ boolean a(com.amap.api.mapcore.util.m.i iVar) {
            iVar.b = true;
            return true;
        }

        private void k() {
            if (this.i) {
                this.i = false;
                this.f138s.e();
            }
        }

        private void l() {
            if (this.h) {
                this.f138s.f();
                this.h = false;
                com.amap.api.mapcore.util.m.a.c(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:177:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m() throws java.lang.InterruptedException {
            boolean z;
            this.f138s = new com.amap.api.mapcore.util.m.h(this.t);
            this.h = false;
            this.i = false;
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
                        synchronized (com.amap.api.mapcore.util.m.a) {
                            while (!this.a) {
                                if (this.q.isEmpty()) {
                                    boolean z10 = this.d;
                                    boolean z11 = this.c;
                                    if (z10 != z11) {
                                        this.d = z11;
                                        com.amap.api.mapcore.util.m.a.notifyAll();
                                    } else {
                                        z11 = false;
                                    }
                                    if (this.k) {
                                        k();
                                        l();
                                        this.k = false;
                                        z4 = true;
                                    }
                                    if (z2) {
                                        k();
                                        l();
                                        z2 = false;
                                    }
                                    if (z11 && this.i) {
                                        k();
                                    }
                                    if (z11 && this.h) {
                                        com.amap.api.mapcore.util.m mVar = this.t.get();
                                        if (!(mVar == null ? false : mVar.l) || com.amap.api.mapcore.util.m.a.a()) {
                                            l();
                                        }
                                    }
                                    if (z11 && com.amap.api.mapcore.util.m.a.b()) {
                                        this.f138s.f();
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            k();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        com.amap.api.mapcore.util.m.a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        com.amap.api.mapcore.util.m.a.notifyAll();
                                    }
                                    if (z3) {
                                        this.p = true;
                                        com.amap.api.mapcore.util.m.a.notifyAll();
                                        z3 = false;
                                        z9 = false;
                                    }
                                    if (o()) {
                                        if (!this.h) {
                                            if (z4) {
                                                z4 = false;
                                            } else if (com.amap.api.mapcore.util.m.a.b(this)) {
                                                try {
                                                    this.f138s.a();
                                                    this.h = true;
                                                    com.amap.api.mapcore.util.m.a.notifyAll();
                                                    z5 = true;
                                                } catch (java.lang.RuntimeException e) {
                                                    com.amap.api.mapcore.util.m.a.c(this);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.h && !this.i) {
                                            this.i = true;
                                            z6 = true;
                                            z7 = true;
                                            z8 = true;
                                        }
                                        if (this.i) {
                                            if (this.r) {
                                                int i3 = this.l;
                                                int i4 = this.m;
                                                this.r = false;
                                                i = i3;
                                                i2 = i4;
                                                z = false;
                                                z6 = true;
                                                z8 = true;
                                                z9 = true;
                                            } else {
                                                z = false;
                                            }
                                            this.o = z;
                                            com.amap.api.mapcore.util.m.a.notifyAll();
                                        }
                                    }
                                    com.amap.api.mapcore.util.m.a.wait();
                                } else {
                                    runnable = this.q.remove(0);
                                }
                            }
                            synchronized (com.amap.api.mapcore.util.m.a) {
                                k();
                                l();
                            }
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        synchronized (com.amap.api.mapcore.util.m.a) {
                        }
                    }
                    if (runnable != null) {
                        break;
                    }
                    if (z6) {
                        if (this.f138s.b()) {
                            synchronized (com.amap.api.mapcore.util.m.a) {
                                this.j = true;
                                com.amap.api.mapcore.util.m.a.notifyAll();
                            }
                            z6 = false;
                        } else {
                            synchronized (com.amap.api.mapcore.util.m.a) {
                                this.j = true;
                                this.f = true;
                                com.amap.api.mapcore.util.m.a.notifyAll();
                            }
                        }
                        synchronized (com.amap.api.mapcore.util.m.a) {
                            k();
                            l();
                            throw th;
                        }
                    }
                    if (z7) {
                        gl10 = (javax.microedition.khronos.opengles.GL10) this.f138s.c();
                        com.amap.api.mapcore.util.m.a.a(gl10);
                        z7 = false;
                    }
                    if (z5) {
                        com.amap.api.mapcore.util.m mVar2 = this.t.get();
                        if (mVar2 != null) {
                            mVar2.d.onSurfaceCreated(gl10, this.f138s.d);
                        }
                        z5 = false;
                    }
                    if (z8) {
                        com.amap.api.mapcore.util.m mVar3 = this.t.get();
                        if (mVar3 != null) {
                            mVar3.d.onSurfaceChanged(gl10, i, i2);
                        }
                        z8 = false;
                    }
                    com.amap.api.mapcore.util.m mVar4 = this.t.get();
                    if (mVar4 != null) {
                        mVar4.d.onDrawFrame(gl10);
                    }
                    int d = this.f138s.d();
                    if (d != 12288) {
                        if (d != 12302) {
                            com.amap.api.mapcore.util.m.h.a("GLThread", "eglSwapBuffers", d);
                            synchronized (com.amap.api.mapcore.util.m.a) {
                                this.f = true;
                                com.amap.api.mapcore.util.m.a.notifyAll();
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

        private boolean n() {
            return this.h && this.i && o();
        }

        private boolean o() {
            if (this.d || !this.e || this.f || this.l <= 0 || this.m <= 0) {
                return false;
            }
            return this.o || this.n == 1;
        }

        public final int a() {
            int i;
            synchronized (com.amap.api.mapcore.util.m.a) {
                i = this.n;
            }
            return i;
        }

        public final void a(int i) {
            if (i < 0 || i > 1) {
                throw new java.lang.IllegalArgumentException("renderMode");
            }
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.n = i;
                com.amap.api.mapcore.util.m.a.notifyAll();
            }
        }

        public final void a(int i, int i2) {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.l = i;
                this.m = i2;
                this.r = true;
                this.o = true;
                this.p = false;
                com.amap.api.mapcore.util.m.a.notifyAll();
                while (!this.b && !this.d && !this.p && n()) {
                    try {
                        com.amap.api.mapcore.util.m.a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void a(java.lang.Runnable runnable) {
            if (runnable == null) {
                throw new java.lang.IllegalArgumentException("r must not be null");
            }
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.q.add(runnable);
                com.amap.api.mapcore.util.m.a.notifyAll();
            }
        }

        public final void b() {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.o = true;
                com.amap.api.mapcore.util.m.a.notifyAll();
            }
        }

        public final void c() {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.e = true;
                this.j = false;
                com.amap.api.mapcore.util.m.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        com.amap.api.mapcore.util.m.a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void d() {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.e = false;
                com.amap.api.mapcore.util.m.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        if (com.amap.api.maps.MapsInitializer.getTextureViewDestorySync()) {
                            com.amap.api.mapcore.util.m.a.wait();
                        } else {
                            com.amap.api.mapcore.util.m.a.wait(2000L);
                        }
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void e() {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.c = true;
                com.amap.api.mapcore.util.m.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        if (com.amap.api.maps.MapsInitializer.getTextureViewDestorySync()) {
                            com.amap.api.mapcore.util.m.a.wait();
                        } else {
                            com.amap.api.mapcore.util.m.a.wait(2000L);
                        }
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void f() {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.c = false;
                this.o = true;
                this.p = false;
                com.amap.api.mapcore.util.m.a.notifyAll();
                while (!this.b && this.d && !this.p) {
                    try {
                        com.amap.api.mapcore.util.m.a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void g() {
            synchronized (com.amap.api.mapcore.util.m.a) {
                this.a = true;
                com.amap.api.mapcore.util.m.a.notifyAll();
                while (!this.b) {
                    try {
                        com.amap.api.mapcore.util.m.a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void h() {
            this.k = true;
            com.amap.api.mapcore.util.m.a.notifyAll();
        }

        public final int i() {
            int i;
            synchronized (com.amap.api.mapcore.util.m.a) {
                i = this.l;
            }
            return i;
        }

        public final int j() {
            int i;
            synchronized (com.amap.api.mapcore.util.m.a) {
                i = this.m;
            }
            return i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                m();
            } catch (java.lang.InterruptedException unused) {
            } finally {
                com.amap.api.mapcore.util.m.a.a(this);
            }
        }
    }

    public static class j {
        private static java.lang.String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private com.amap.api.mapcore.util.m.i g;

        private j() {
        }

        public /* synthetic */ j(byte b) {
            this();
        }

        private void c() {
            if (this.b) {
                return;
            }
            this.c = 131072;
            this.e = true;
            this.b = true;
        }

        public final synchronized void a(com.amap.api.mapcore.util.m.i iVar) {
            com.amap.api.mapcore.util.m.i.a(iVar);
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public final synchronized void a(javax.microedition.khronos.opengles.GL10 gl10) {
            if (!this.d && gl10 != null) {
                c();
                java.lang.String glGetString = gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER);
                if (this.c < 131072) {
                    this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f = this.e ? false : true;
                this.d = true;
            }
        }

        public final synchronized boolean a() {
            return this.f;
        }

        public final synchronized boolean b() {
            c();
            return !this.e;
        }

        public final boolean b(com.amap.api.mapcore.util.m.i iVar) {
            com.amap.api.mapcore.util.m.i iVar2 = this.g;
            if (iVar2 == iVar || iVar2 == null) {
                this.g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.e) {
                return true;
            }
            com.amap.api.mapcore.util.m.i iVar3 = this.g;
            if (iVar3 == null) {
                return false;
            }
            iVar3.h();
            return false;
        }

        public final void c(com.amap.api.mapcore.util.m.i iVar) {
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }
    }

    public interface k {
        javax.microedition.khronos.opengles.GL a();
    }

    public static class l extends java.io.Writer {
        private java.lang.StringBuilder a = new java.lang.StringBuilder();

        private void a() {
            if (this.a.length() > 0) {
                this.a.toString();
                java.lang.StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.a.append(c);
                }
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.m$m, reason: collision with other inner class name */
    public class C0125m extends com.amap.api.mapcore.util.m.b {
        public C0125m() {
            super();
        }
    }

    public m(android.content.Context context) {
        super(context, null);
        this.b = new java.lang.ref.WeakReference<>(this);
        a();
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void e() {
        if (this.c != null) {
            throw new java.lang.IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static boolean f() {
        return android.os.Build.VERSION.SDK_INT < 23;
    }

    public final void a(com.amap.api.mapcore.util.m.e eVar) {
        e();
        this.f = eVar;
    }

    public final void a(com.amap.api.mapcore.util.m.f fVar) {
        e();
        this.g = fVar;
    }

    public void b() {
        this.c.e();
    }

    public void c() {
        this.c.f();
    }

    public void finalize() throws java.lang.Throwable {
        try {
            com.amap.api.mapcore.util.m.i iVar = this.c;
            if (iVar != null) {
                iVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.c.a();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            com.amap.api.mapcore.util.m.i iVar = this.c;
            int a2 = iVar != null ? iVar.a() : 1;
            com.amap.api.mapcore.util.m.i iVar2 = new com.amap.api.mapcore.util.m.i(this.b);
            this.c = iVar2;
            if (a2 != 1) {
                iVar2.a(a2);
            }
            this.c.start();
        }
        this.e = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        com.amap.api.mapcore.util.m.i iVar = this.c;
        if (iVar != null) {
            iVar.g();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.c();
        if (f() || com.amap.api.maps.MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        } else {
            if (this.c.i() == i2 && this.c.j() == i3) {
                return;
            }
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        this.c.d();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.a(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(java.lang.Runnable runnable) {
        this.c.a(runnable);
    }

    public void requestRender() {
        this.c.b();
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer) {
        e();
        if (this.f == null) {
            this.f = new com.amap.api.mapcore.util.m.C0125m();
        }
        if (this.g == null) {
            this.g = new com.amap.api.mapcore.util.m.c(this, (byte) 0);
        }
        if (this.h == null) {
            this.h = new com.amap.api.mapcore.util.m.d((byte) 0);
        }
        this.d = renderer;
        com.amap.api.mapcore.util.m.i iVar = new com.amap.api.mapcore.util.m.i(this.b);
        this.c = iVar;
        iVar.start();
    }
}
