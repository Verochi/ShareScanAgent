package com.otaliastudios.opengl.core;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/otaliastudios/opengl/core/EglConfigChooser;", "Lcom/otaliastudios/opengl/core/EglNativeConfigChooser;", "()V", "GLES2", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "getGLES2$annotations", "GLES3", "getGLES3$annotations", "getConfig", "Landroid/opengl/EGLConfig;", "display", "Landroid/opengl/EGLDisplay;", "version", "", "recordable", "", "Chooser", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class EglConfigChooser extends com.otaliastudios.opengl.core.EglNativeConfigChooser {
    public static final com.otaliastudios.opengl.core.EglConfigChooser INSTANCE = new com.otaliastudios.opengl.core.EglConfigChooser();

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final android.opengl.GLSurfaceView.EGLConfigChooser GLES2 = new com.otaliastudios.opengl.core.EglConfigChooser.Chooser(2);

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final android.opengl.GLSurfaceView.EGLConfigChooser GLES3 = new com.otaliastudios.opengl.core.EglConfigChooser.Chooser(3);

    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J/\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0010\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/otaliastudios/opengl/core/EglConfigChooser$Chooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "Ljavax/microedition/khronos/egl/EGL10;", "egl", "Ljavax/microedition/khronos/egl/EGLDisplay;", "display", "Ljavax/microedition/khronos/egl/EGLConfig;", "chooseConfig", "", "configs", "a", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "config", "", "attribute", "defaultValue", "b", "I", "version", "<init>", "(I)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Chooser implements android.opengl.GLSurfaceView.EGLConfigChooser {

        /* renamed from: a, reason: from kotlin metadata */
        public final int version;

        public Chooser(int i) {
            this.version = i;
        }

        public final javax.microedition.khronos.egl.EGLConfig a(javax.microedition.khronos.egl.EGL10 egl, javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig[] configs) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : configs) {
                int b = b(egl, display, eGLConfig, 12325, 0);
                int b2 = b(egl, display, eGLConfig, 12326, 0);
                if (b >= 0 && b2 >= 0) {
                    int b3 = b(egl, display, eGLConfig, 12324, 0);
                    int b4 = b(egl, display, eGLConfig, 12323, 0);
                    int b5 = b(egl, display, eGLConfig, 12322, 0);
                    int b6 = b(egl, display, eGLConfig, 12321, 0);
                    if (b3 == 8 && b4 == 8 && b5 == 8 && b6 == 8) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int b(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i, int i2) {
            int[] iArr = new int[1];
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr) ? iArr[0] : i2;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        @org.jetbrains.annotations.NotNull
        public javax.microedition.khronos.egl.EGLConfig chooseConfig(@org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGL10 egl, @org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGLDisplay display) {
            java.util.List filterNotNull;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(egl, "egl");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(display, "display");
            int[] iArr = new int[1];
            int[] configSpec$egloo_metadata_release = com.otaliastudios.opengl.core.EglConfigChooser.INSTANCE.getConfigSpec$egloo_metadata_release(this.version, true);
            if (!egl.eglChooseConfig(display, configSpec$egloo_metadata_release, null, 0, iArr)) {
                throw new java.lang.IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("No configs match configSpec");
            }
            javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i];
            if (!egl.eglChooseConfig(display, configSpec$egloo_metadata_release, eGLConfigArr, i, iArr)) {
                throw new java.lang.IllegalArgumentException("eglChooseConfig#2 failed");
            }
            filterNotNull = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(eGLConfigArr);
            java.lang.Object[] array = filterNotNull.toArray(new javax.microedition.khronos.egl.EGLConfig[0]);
            if (array == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            javax.microedition.khronos.egl.EGLConfig a = a(egl, display, (javax.microedition.khronos.egl.EGLConfig[]) array);
            if (a != null) {
                return a;
            }
            throw new java.lang.IllegalArgumentException("No config chosen");
        }
    }

    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.Nullable
    public static final android.opengl.EGLConfig getConfig(@org.jetbrains.annotations.NotNull android.opengl.EGLDisplay display, int version, boolean recordable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(display, "display");
        com.otaliastudios.opengl.internal.EglConfig config$egloo_metadata_release = super.getConfig$egloo_metadata_release(new com.otaliastudios.opengl.internal.EglDisplay(display), version, recordable);
        if (config$egloo_metadata_release != null) {
            return config$egloo_metadata_release.getNative();
        }
        return null;
    }

    public static /* synthetic */ void getGLES2$annotations() {
    }

    public static /* synthetic */ void getGLES3$annotations() {
    }
}
