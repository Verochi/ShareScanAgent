package com.otaliastudios.opengl.core;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/otaliastudios/opengl/core/EglNativeConfigChooser;", "", "()V", "getConfig", "Lcom/otaliastudios/opengl/internal/EglConfig;", "display", "Lcom/otaliastudios/opengl/internal/EglDisplay;", "version", "", "recordable", "", "getConfig$egloo_metadata_release", "getConfigSpec", "", "getConfigSpec$egloo_metadata_release", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class EglNativeConfigChooser {
    @org.jetbrains.annotations.Nullable
    public final com.otaliastudios.opengl.internal.EglConfig getConfig$egloo_metadata_release(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.internal.EglDisplay display, int version, boolean recordable) {
        kotlin.ranges.IntRange indices;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(display, "display");
        com.otaliastudios.opengl.internal.EglConfig[] eglConfigArr = new com.otaliastudios.opengl.internal.EglConfig[1];
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        boolean eglChooseConfig = android.opengl.EGL14.eglChooseConfig(display.getNative(), getConfigSpec$egloo_metadata_release(version, recordable), 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (eglChooseConfig) {
            indices = kotlin.collections.ArraysKt___ArraysKt.getIndices(eglConfigArr);
            java.util.Iterator<java.lang.Integer> it = indices.iterator();
            while (it.hasNext()) {
                int nextInt = ((kotlin.collections.IntIterator) it).nextInt();
                android.opengl.EGLConfig eGLConfig = eGLConfigArr[nextInt];
                eglConfigArr[nextInt] = eGLConfig != null ? new com.otaliastudios.opengl.internal.EglConfig(eGLConfig) : null;
            }
        }
        if (eglChooseConfig) {
            return eglConfigArr[0];
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Unable to find RGB8888 / ");
        sb.append(version);
        sb.append(" EGLConfig");
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public final int[] getConfigSpec$egloo_metadata_release(int version, boolean recordable) {
        int egl_opengl_es2_bit = version >= 3 ? com.otaliastudios.opengl.internal.EglKt.getEGL_OPENGL_ES2_BIT() | com.otaliastudios.opengl.internal.EglKt.getEGL_OPENGL_ES3_BIT_KHR() : com.otaliastudios.opengl.internal.EglKt.getEGL_OPENGL_ES2_BIT();
        int[] iArr = new int[15];
        iArr[0] = com.otaliastudios.opengl.internal.EglKt.getEGL_RED_SIZE();
        iArr[1] = 8;
        iArr[2] = com.otaliastudios.opengl.internal.EglKt.getEGL_GREEN_SIZE();
        iArr[3] = 8;
        iArr[4] = com.otaliastudios.opengl.internal.EglKt.getEGL_BLUE_SIZE();
        iArr[5] = 8;
        iArr[6] = com.otaliastudios.opengl.internal.EglKt.getEGL_ALPHA_SIZE();
        iArr[7] = 8;
        iArr[8] = com.otaliastudios.opengl.internal.EglKt.getEGL_SURFACE_TYPE();
        iArr[9] = com.otaliastudios.opengl.internal.EglKt.getEGL_WINDOW_BIT() | com.otaliastudios.opengl.internal.EglKt.getEGL_PBUFFER_BIT();
        iArr[10] = com.otaliastudios.opengl.internal.EglKt.getEGL_RENDERABLE_TYPE();
        iArr[11] = egl_opengl_es2_bit;
        iArr[12] = recordable ? 12610 : com.otaliastudios.opengl.internal.EglKt.getEGL_NONE();
        iArr[13] = recordable ? 1 : 0;
        iArr[14] = com.otaliastudios.opengl.internal.EglKt.getEGL_NONE();
        return iArr;
    }
}
