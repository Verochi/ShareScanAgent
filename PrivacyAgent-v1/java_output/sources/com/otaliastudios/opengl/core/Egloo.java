package com.otaliastudios.opengl.core;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0007J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/otaliastudios/opengl/core/Egloo;", "", "()V", "IDENTITY_MATRIX", "", "SIZE_OF_BYTE", "", "SIZE_OF_FLOAT", "SIZE_OF_INT", "SIZE_OF_SHORT", "checkEglError", "", "opName", "", "checkGlError", "checkGlProgramLocation", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, "label", "logCurrent", "msg", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class Egloo {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final float[] IDENTITY_MATRIX;
    public static final com.otaliastudios.opengl.core.Egloo INSTANCE = new com.otaliastudios.opengl.core.Egloo();
    public static final int SIZE_OF_BYTE = 1;
    public static final int SIZE_OF_FLOAT = 4;
    public static final int SIZE_OF_INT = 4;
    public static final int SIZE_OF_SHORT = 2;

    static {
        float[] fArr = new float[16];
        com.otaliastudios.opengl.extensions.MatrixKt.makeIdentity(fArr);
        IDENTITY_MATRIX = fArr;
    }

    @kotlin.jvm.JvmStatic
    public static final void checkEglError(@org.jetbrains.annotations.NotNull java.lang.String opName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(opName, "opName");
        int eglGetError = android.opengl.EGL14.eglGetError();
        if (eglGetError == com.otaliastudios.opengl.internal.EglKt.getEGL_SUCCESS()) {
            return;
        }
        throw new java.lang.RuntimeException("Error during " + opName + ": EGL error 0x" + com.otaliastudios.opengl.internal.MiscKt.intToHexString(eglGetError));
    }

    @kotlin.jvm.JvmStatic
    public static final void checkGlError(@org.jetbrains.annotations.NotNull java.lang.String opName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(opName, "opName");
        int m191constructorimpl = kotlin.UInt.m191constructorimpl(android.opengl.GLES20.glGetError());
        if (m191constructorimpl == com.otaliastudios.opengl.internal.GlKt.getGL_NO_ERROR()) {
            return;
        }
        throw new java.lang.RuntimeException("Error during " + opName + ": glError 0x" + com.otaliastudios.opengl.internal.MiscKt.intToHexString(m191constructorimpl) + ": " + com.otaliastudios.opengl.internal.MiscKt.gluErrorString(m191constructorimpl));
    }

    @kotlin.jvm.JvmStatic
    public static final void checkGlProgramLocation(int location, @org.jetbrains.annotations.NotNull java.lang.String label) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(label, "label");
        if (location >= 0) {
            return;
        }
        throw new java.lang.RuntimeException("Unable to locate " + label + " in program");
    }

    @kotlin.jvm.JvmStatic
    public static final void logCurrent(@org.jetbrains.annotations.NotNull java.lang.String msg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(msg, "msg");
        com.otaliastudios.opengl.internal.EglDisplay eglDisplay = new com.otaliastudios.opengl.internal.EglDisplay(android.opengl.EGL14.eglGetCurrentDisplay());
        com.otaliastudios.opengl.internal.EglContext eglContext = new com.otaliastudios.opengl.internal.EglContext(android.opengl.EGL14.eglGetCurrentContext());
        com.otaliastudios.opengl.internal.EglSurface eglSurface = new com.otaliastudios.opengl.internal.EglSurface(android.opengl.EGL14.eglGetCurrentSurface(com.otaliastudios.opengl.internal.EglKt.getEGL_DRAW()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Current EGL (");
        sb.append(msg);
        sb.append("): display=");
        sb.append(eglDisplay);
        sb.append(", context=");
        sb.append(eglContext);
        sb.append(", surface=");
        sb.append(eglSurface);
    }
}
