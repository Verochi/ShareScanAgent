package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public abstract class EglBase {
    private static final int EGL_OPENGL_ES2_BIT = 4;
    public static final java.lang.Object lock = new java.lang.Object();
    public static final int[] CONFIG_PLAIN = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
    public static final int[] CONFIG_RGBA = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
    public static final int[] CONFIG_PIXEL_BUFFER = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int[] CONFIG_RECORDABLE = {12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};

    public static abstract class Context {
        public abstract long getNativeEglContext();
    }

    public static org.webrtc.ali.svideo.EglBase create() {
        return create(null, CONFIG_PLAIN);
    }

    public static org.webrtc.ali.svideo.EglBase create(org.webrtc.ali.svideo.EglBase.Context context) {
        return create(context, CONFIG_PLAIN);
    }

    public static org.webrtc.ali.svideo.EglBase create(org.webrtc.ali.svideo.EglBase.Context context, int[] iArr) {
        return (org.webrtc.ali.svideo.EglBase14.isEGL14Supported() && (context == null || (context instanceof org.webrtc.ali.svideo.EglBase14.Context))) ? new org.webrtc.ali.svideo.EglBase14((org.webrtc.ali.svideo.EglBase14.Context) context, iArr) : new org.webrtc.ali.svideo.EglBase10((org.webrtc.ali.svideo.EglBase10.Context) context, iArr);
    }

    public static org.webrtc.ali.svideo.EglBase createEgl10(javax.microedition.khronos.egl.EGLContext eGLContext, int[] iArr) {
        return new org.webrtc.ali.svideo.EglBase10(new org.webrtc.ali.svideo.EglBase10.Context(eGLContext), iArr);
    }

    public static org.webrtc.ali.svideo.EglBase createEgl10(int[] iArr) {
        return new org.webrtc.ali.svideo.EglBase10(null, iArr);
    }

    public static org.webrtc.ali.svideo.EglBase createEgl14(android.opengl.EGLContext eGLContext, int[] iArr) {
        return new org.webrtc.ali.svideo.EglBase14(new org.webrtc.ali.svideo.EglBase14.Context(eGLContext), iArr);
    }

    public static org.webrtc.ali.svideo.EglBase createEgl14(int[] iArr) {
        return new org.webrtc.ali.svideo.EglBase14(null, iArr);
    }

    public abstract void createDummyPbufferSurface();

    public abstract void createPbufferSurface(int i, int i2);

    public abstract void createSurface(android.graphics.SurfaceTexture surfaceTexture);

    public abstract void createSurface(android.view.Surface surface);

    public abstract void detachCurrent();

    public abstract org.webrtc.ali.svideo.EglBase.Context getEglBaseContext();

    public abstract long getNativeEglContext();

    public abstract boolean hasSurface();

    public abstract void makeCurrent();

    public abstract void release();

    public abstract void releaseSurface();

    public abstract int surfaceHeight();

    public abstract int surfaceWidth();

    public abstract void swapBuffers();
}
