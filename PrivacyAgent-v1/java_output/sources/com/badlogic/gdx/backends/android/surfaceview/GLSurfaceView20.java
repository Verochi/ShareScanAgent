package com.badlogic.gdx.backends.android.surfaceview;

/* loaded from: classes12.dex */
public class GLSurfaceView20 extends com.badlogic.gdx.backends.android.surfaceview.GLTextureView {
    public static int t;
    public final com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy n;

    /* renamed from: com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.inputmethod.BaseInputConnection {
        public AnonymousClass1(android.view.View view, boolean z) {
            super(view, z);
        }

        @android.annotation.TargetApi(16)
        public final void a(int i) {
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            super.sendKeyEvent(new android.view.KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0, 0, -1, 0, 6));
            super.sendKeyEvent(new android.view.KeyEvent(android.os.SystemClock.uptimeMillis(), uptimeMillis, 1, i, 0, 0, -1, 0, 6));
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i != 1 || i2 != 0) {
                return super.deleteSurroundingText(i, i2);
            }
            a(67);
            return true;
        }
    }

    public static class ConfigChooser implements com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser {
        public static int[] h = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int[] g = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : eGLConfigArr) {
                int b = b(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int b2 = b(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (b >= this.e && b2 >= this.f) {
                    int b3 = b(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int b4 = b(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int b5 = b(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int b6 = b(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (b3 == this.a && b4 == this.b && b5 == this.c && b6 == this.d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int b(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.g) ? this.g[0] : i2;
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser
        public javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, h, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("No configs match configSpec");
            }
            javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, h, eGLConfigArr, i, iArr);
            return a(egl10, eGLDisplay, eGLConfigArr);
        }
    }

    public static class ContextFactory implements com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory {
        public static int a = 12440;

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory
        public javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            int i = com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("creating OpenGL ES ");
            sb.append(com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t);
            sb.append(".0 context");
            com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.k("Before eglCreateContext " + com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t, egl10);
            javax.microedition.khronos.egl.EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT, new int[]{a, com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t, 12344});
            if ((!com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.k("After eglCreateContext " + com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t, egl10) || eglCreateContext == null) && com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t > 2) {
                int i2 = com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t;
                com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t = 2;
                return createContext(egl10, eGLDisplay, eGLConfig);
            }
            int i3 = com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Returning a GLES ");
            sb2.append(com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.t);
            sb2.append(" context");
            return eglCreateContext;
        }

        @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLContextFactory
        public void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public GLSurfaceView20(android.content.Context context, com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy) {
        this(context, resolutionStrategy, 2);
    }

    public GLSurfaceView20(android.content.Context context, com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy, int i) {
        super(context);
        t = i;
        this.n = resolutionStrategy;
        l(false, 16, 0);
    }

    public GLSurfaceView20(android.content.Context context, boolean z, int i, int i2, com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy) {
        super(context);
        this.n = resolutionStrategy;
        l(z, i, i2);
    }

    public static boolean k(java.lang.String str, javax.microedition.khronos.egl.EGL10 egl10) {
        boolean z = true;
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return z;
            }
            java.lang.String.format("%s: EGL error: 0x%x", str, java.lang.Integer.valueOf(eglGetError));
            z = false;
        }
    }

    public final void l(boolean z, int i, int i2) {
        setEGLContextFactory(new com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.ContextFactory());
        setEGLConfigChooser(z ? new com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.ConfigChooser(8, 8, 8, 8, i, i2) : new com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.ConfigChooser(5, 6, 5, 0, i, i2));
    }

    @Override // android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        if (editorInfo != null) {
            editorInfo.imeOptions |= 268435456;
        }
        return new com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.AnonymousClass1(this, false);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy.MeasuredDimension calcMeasures = this.n.calcMeasures(i, i2);
        setMeasuredDimension(calcMeasures.width, calcMeasures.height);
    }
}
