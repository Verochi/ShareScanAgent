package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cx {

    public static class a extends com.amap.api.mapcore.util.cv {
        private static int g = 4;
        private int[] h = new int[1];
        protected int a = 5;
        protected int b = 6;
        protected int c = 5;
        protected int d = 0;
        protected int e = 16;
        protected int f = 8;

        private int a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.h)) {
                return this.h[0];
            }
            return 0;
        }

        private com.amap.api.mapcore.util.cx.c a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            com.amap.api.mapcore.util.cx.c cVar = new com.amap.api.mapcore.util.cx.c((byte) 0);
            int[] a = a(true);
            cVar.a = a;
            egl10.eglChooseConfig(eGLDisplay, a, null, 0, cVar.b);
            if (cVar.b[0] <= 0) {
                int[] a2 = a(false);
                cVar.a = a2;
                egl10.eglChooseConfig(eGLDisplay, a2, null, 0, cVar.b);
                if (cVar.b[0] <= 0) {
                    return null;
                }
            }
            return cVar;
        }

        private javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.e && a2 >= this.f) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a3 == this.a && a4 == this.b && a5 == this.c && a6 == this.d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int[] a(boolean z) {
            return new int[]{12324, this.a, 12323, this.b, 12322, this.c, 12321, this.d, 12325, this.e, 12326, this.f, 12338, z ? 1 : 0, 12352, g, 12344};
        }

        @Override // com.amap.api.mapcore.util.cv, android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.mapcore.util.m.e
        public final javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            int[] iArr;
            int[] iArr2;
            com.amap.api.mapcore.util.cx.c a = a(egl10, eGLDisplay);
            if (a == null || (iArr = a.a) == null) {
                return null;
            }
            int[] iArr3 = a.b;
            int i = iArr3[0];
            javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr3);
            javax.microedition.khronos.egl.EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a2 != null) {
                return a2;
            }
            this.a = 8;
            this.b = 8;
            this.c = 8;
            com.amap.api.mapcore.util.cx.c a3 = a(egl10, eGLDisplay);
            if (a3 == null || (iArr2 = a3.a) == null) {
                return a2;
            }
            int[] iArr4 = a3.b;
            int i2 = iArr4[0];
            javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr2 = new javax.microedition.khronos.egl.EGLConfig[i2];
            egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr2, i2, iArr4);
            return a(egl10, eGLDisplay, eGLConfigArr2);
        }
    }

    public static class b extends com.amap.api.mapcore.util.cw {
        @Override // com.amap.api.mapcore.util.cw, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.m.f
        public final javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.mapcore.util.cw, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.m.f
        public final void destroyContext(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public static class c {
        public int[] a;
        public int[] b;

        private c() {
            this.a = null;
            this.b = new int[1];
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    public static void a(com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView) {
        iGLSurfaceView.setEGLContextFactory(new com.amap.api.mapcore.util.cx.b());
        iGLSurfaceView.setEGLConfigChooser(new com.amap.api.mapcore.util.cx.a());
    }
}
