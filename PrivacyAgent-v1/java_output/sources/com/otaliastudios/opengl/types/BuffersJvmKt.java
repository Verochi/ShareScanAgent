package com.otaliastudios.opengl.types;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0003\u001a\u00020\u0004*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00012\u00020\u0001*\n\u0010\u0011\"\u00020\u00062\u00020\u0006*\n\u0010\u0012\"\u00020\t2\u00020\t*\n\u0010\u0013\"\u00020\f2\u00020\f¨\u0006\u0014"}, d2 = {"byteBuffer", "Ljava/nio/ByteBuffer;", "Lcom/otaliastudios/opengl/types/ByteBuffer;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "floatBuffer", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "intBuffer", "Ljava/nio/IntBuffer;", "Lcom/otaliastudios/opengl/types/IntBuffer;", "shortBuffer", "Ljava/nio/ShortBuffer;", "Lcom/otaliastudios/opengl/types/ShortBuffer;", "Buffer", "Ljava/nio/Buffer;", "ByteBuffer", "FloatBuffer", "IntBuffer", "ShortBuffer", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
@kotlin.jvm.JvmName(name = "BuffersJvmKt")
/* loaded from: classes19.dex */
public final class BuffersJvmKt {
    @org.jetbrains.annotations.NotNull
    public static final java.nio.ByteBuffer byteBuffer(int i) {
        java.nio.ByteBuffer order = java.nio.ByteBuffer.allocateDirect(i * 1).order(java.nio.ByteOrder.nativeOrder());
        order.limit(order.capacity());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(order, "ByteBuffer\n        .allo…it.limit(it.capacity()) }");
        return order;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.FloatBuffer floatBuffer(int i) {
        java.nio.FloatBuffer asFloatBuffer = byteBuffer(i * 4).asFloatBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(asFloatBuffer, "byteBuffer(size * Egloo.…OF_FLOAT).asFloatBuffer()");
        return asFloatBuffer;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.IntBuffer intBuffer(int i) {
        java.nio.IntBuffer asIntBuffer = byteBuffer(i * 4).asIntBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(asIntBuffer, "byteBuffer(size * Egloo.SIZE_OF_INT).asIntBuffer()");
        return asIntBuffer;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.nio.ShortBuffer shortBuffer(int i) {
        java.nio.ShortBuffer asShortBuffer = byteBuffer(i * 2).asShortBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(asShortBuffer, "byteBuffer(size * Egloo.…OF_SHORT).asShortBuffer()");
        return asShortBuffer;
    }
}
