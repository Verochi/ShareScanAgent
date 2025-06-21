package com.otaliastudios.opengl.extensions;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0003\u001a\u00020\u0004\"\u00020\u0005\u001a\u0014\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0016\u0010\b\u001a\u00060\tj\u0002`\n2\n\u0010\u0003\u001a\u00020\u000b\"\u00020\f\u001a\u0014\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0016\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0003\u001a\u00020\u0010\"\u00020\u0007\u001a\u0016\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\n\u0010\u0003\u001a\u00020\u0014\"\u00020\u0015\u001a\u000e\u0010\u0016\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0004\u001a\u000e\u0010\u0016\u001a\u00060\tj\u0002`\n*\u00020\u000b\u001a\u000e\u0010\u0016\u001a\u00060\u000ej\u0002`\u000f*\u00020\u0010\u001a\u000e\u0010\u0016\u001a\u00060\u0012j\u0002`\u0013*\u00020\u0014¨\u0006\u0017"}, d2 = {"byteBufferOf", "Ljava/nio/ByteBuffer;", "Lcom/otaliastudios/opengl/types/ByteBuffer;", "elements", "", "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "floatBufferOf", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "", "", "intBufferOf", "Ljava/nio/IntBuffer;", "Lcom/otaliastudios/opengl/types/IntBuffer;", "", "shortBufferOf", "Ljava/nio/ShortBuffer;", "Lcom/otaliastudios/opengl/types/ShortBuffer;", "", "", "toBuffer", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class BuffersKt {
    @kotlin.Deprecated(message = "Do not use this.", replaceWith = @kotlin.ReplaceWith(expression = "ByteBuffer(size)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final java.nio.ByteBuffer byteBufferOf(int i) {
        return com.otaliastudios.opengl.types.BuffersJvmKt.byteBuffer(i);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.ByteBuffer byteBufferOf(@org.jetbrains.annotations.NotNull byte... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return toBuffer(java.util.Arrays.copyOf(elements, elements.length));
    }

    @kotlin.Deprecated(message = "Do not use this.", replaceWith = @kotlin.ReplaceWith(expression = "FloatBuffer(size)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final java.nio.FloatBuffer floatBufferOf(int i) {
        return com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(i);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.FloatBuffer floatBufferOf(@org.jetbrains.annotations.NotNull float... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return toBuffer(java.util.Arrays.copyOf(elements, elements.length));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.IntBuffer intBufferOf(@org.jetbrains.annotations.NotNull int... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return toBuffer(java.util.Arrays.copyOf(elements, elements.length));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.ShortBuffer shortBufferOf(@org.jetbrains.annotations.NotNull short... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return toBuffer(java.util.Arrays.copyOf(elements, elements.length));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.ByteBuffer toBuffer(@org.jetbrains.annotations.NotNull byte[] toBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toBuffer, "$this$toBuffer");
        java.nio.ByteBuffer byteBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.byteBuffer(toBuffer.length);
        byteBuffer.put(toBuffer);
        byteBuffer.flip();
        return byteBuffer;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.FloatBuffer toBuffer(@org.jetbrains.annotations.NotNull float[] toBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toBuffer, "$this$toBuffer");
        java.nio.FloatBuffer floatBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(toBuffer.length);
        floatBuffer.put(toBuffer);
        floatBuffer.flip();
        return floatBuffer;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.IntBuffer toBuffer(@org.jetbrains.annotations.NotNull int[] toBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toBuffer, "$this$toBuffer");
        java.nio.IntBuffer intBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.intBuffer(toBuffer.length);
        intBuffer.put(toBuffer);
        intBuffer.flip();
        return intBuffer;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.ShortBuffer toBuffer(@org.jetbrains.annotations.NotNull short[] toBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toBuffer, "$this$toBuffer");
        java.nio.ShortBuffer shortBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.shortBuffer(toBuffer.length);
        shortBuffer.put(toBuffer);
        shortBuffer.flip();
        return shortBuffer;
    }
}
