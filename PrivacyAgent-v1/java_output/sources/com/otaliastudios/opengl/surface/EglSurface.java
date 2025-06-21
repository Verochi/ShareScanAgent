package com.otaliastudios.opengl.surface;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\u0015"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglSurface;", "Lcom/otaliastudios/opengl/surface/EglNativeSurface;", "eglCore", "Lcom/otaliastudios/opengl/core/EglCore;", "eglSurface", "Landroid/opengl/EGLSurface;", "(Lcom/otaliastudios/opengl/core/EglCore;Landroid/opengl/EGLSurface;)V", "Lcom/otaliastudios/opengl/internal/EglSurface;", "(Lcom/otaliastudios/opengl/core/EglCore;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "toByteArray", "", "format", "Landroid/graphics/Bitmap$CompressFormat;", "toFile", "", "file", "Ljava/io/File;", "toOutputStream", "stream", "Ljava/io/OutputStream;", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public abstract class EglSurface extends com.otaliastudios.opengl.surface.EglNativeSurface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final com.otaliastudios.opengl.surface.EglSurface.Companion INSTANCE = new com.otaliastudios.opengl.surface.EglSurface.Companion(null);

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String e;

    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglSurface$Companion;", "", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getTAG$annotations() {
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTAG() {
            return com.otaliastudios.opengl.surface.EglSurface.e;
        }
    }

    static {
        java.lang.String simpleName = com.otaliastudios.opengl.internal.EglSurface.class.getSimpleName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleName, "EglSurface::class.java.simpleName");
        e = simpleName;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EglSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull android.opengl.EGLSurface eglSurface) {
        this(eglCore, new com.otaliastudios.opengl.internal.EglSurface(eglSurface));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EglSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.internal.EglSurface eglSurface) {
        super(eglCore, eglSurface);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
    }

    public static /* synthetic */ byte[] toByteArray$default(com.otaliastudios.opengl.surface.EglSurface eglSurface, android.graphics.Bitmap.CompressFormat compressFormat, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toByteArray");
        }
        if ((i & 1) != 0) {
            compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
        }
        return eglSurface.toByteArray(compressFormat);
    }

    public static /* synthetic */ void toFile$default(com.otaliastudios.opengl.surface.EglSurface eglSurface, java.io.File file, android.graphics.Bitmap.CompressFormat compressFormat, int i, java.lang.Object obj) throws java.io.IOException {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toFile");
        }
        if ((i & 2) != 0) {
            compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
        }
        eglSurface.toFile(file, compressFormat);
    }

    public static /* synthetic */ void toOutputStream$default(com.otaliastudios.opengl.surface.EglSurface eglSurface, java.io.OutputStream outputStream, android.graphics.Bitmap.CompressFormat compressFormat, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toOutputStream");
        }
        if ((i & 2) != 0) {
            compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
        }
        eglSurface.toOutputStream(outputStream, compressFormat);
    }

    @org.jetbrains.annotations.NotNull
    public final byte[] toByteArray(@org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            toOutputStream(byteArrayOutputStream, format);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
            kotlin.io.CloseableKt.closeFinally(byteArrayOutputStream, null);
            return byteArray;
        } finally {
        }
    }

    public final void toFile(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat format) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file.toString()));
            try {
                toOutputStream(bufferedOutputStream2, format);
                bufferedOutputStream2.close();
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void toOutputStream(@org.jetbrains.annotations.NotNull java.io.OutputStream stream, @org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stream, "stream");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        if (!isCurrent()) {
            throw new java.lang.RuntimeException("Expected EGL context/surface is not current");
        }
        int width = getWidth();
        int height = getHeight();
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(width * height * 4);
        allocateDirect.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        android.opengl.GLES20.glReadPixels(0, 0, width, height, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, allocateDirect);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glReadPixels");
        allocateDirect.rewind();
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        createBitmap.compress(format, 90, stream);
        createBitmap.recycle();
    }
}
