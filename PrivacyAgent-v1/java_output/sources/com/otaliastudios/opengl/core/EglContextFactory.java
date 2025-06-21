package com.otaliastudios.opengl.core;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u0012\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/otaliastudios/opengl/core/EglContextFactory;", "", "", "a", "Ljava/lang/String;", "TAG", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "GLES2", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "getGLES2$annotations", "()V", "GLES3", "getGLES3$annotations", "<init>", "Factory", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class EglContextFactory {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final android.opengl.GLSurfaceView.EGLContextFactory GLES2;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final android.opengl.GLSurfaceView.EGLContextFactory GLES3;
    public static final com.otaliastudios.opengl.core.EglContextFactory INSTANCE = new com.otaliastudios.opengl.core.EglContextFactory();

    /* renamed from: a, reason: from kotlin metadata */
    public static final java.lang.String TAG;

    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/core/EglContextFactory$Factory;", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "Ljavax/microedition/khronos/egl/EGL10;", "egl", "Ljavax/microedition/khronos/egl/EGLDisplay;", "display", "Ljavax/microedition/khronos/egl/EGLConfig;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLContext;", "createContext", "context", "", "destroyContext", "", "a", "I", "version", "<init>", "(I)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Factory implements android.opengl.GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: from kotlin metadata */
        public final int version;

        public Factory(int i) {
            this.version = i;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        @org.jetbrains.annotations.NotNull
        public javax.microedition.khronos.egl.EGLContext createContext(@org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGL10 egl, @org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGLDisplay display, @org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGLConfig eglConfig) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(egl, "egl");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(display, "display");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglConfig, "eglConfig");
            javax.microedition.khronos.egl.EGLContext eglCreateContext = egl.eglCreateContext(display, eglConfig, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT, new int[]{12440, this.version, 12344});
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(eglCreateContext, "egl.eglCreateContext(dis…L_NO_CONTEXT, attributes)");
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(@org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGL10 egl, @org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGLDisplay display, @org.jetbrains.annotations.NotNull javax.microedition.khronos.egl.EGLContext context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(egl, "egl");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(display, "display");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            if (egl.eglDestroyContext(display, context)) {
                return;
            }
            com.otaliastudios.opengl.core.EglContextFactory.access$getTAG$p(com.otaliastudios.opengl.core.EglContextFactory.INSTANCE);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("display:");
            sb.append(display);
            sb.append(" context:");
            sb.append(context);
            throw new java.lang.RuntimeException("eglDestroyContex" + egl.eglGetError());
        }
    }

    static {
        java.lang.String simpleName = com.otaliastudios.opengl.core.EglContextFactory.class.getSimpleName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleName, "EglContextFactory::class.java.simpleName");
        TAG = simpleName;
        GLES2 = new com.otaliastudios.opengl.core.EglContextFactory.Factory(2);
        GLES3 = new com.otaliastudios.opengl.core.EglContextFactory.Factory(3);
    }

    public static final /* synthetic */ java.lang.String access$getTAG$p(com.otaliastudios.opengl.core.EglContextFactory eglContextFactory) {
        return TAG;
    }

    public static /* synthetic */ void getGLES2$annotations() {
    }

    public static /* synthetic */ void getGLES3$annotations() {
    }
}
