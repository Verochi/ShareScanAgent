package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0019\u001a\u00060\u0013j\u0002`\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011¨\u0006\""}, d2 = {"Lcom/otaliastudios/opengl/draw/GlDrawable;", "Lcom/otaliastudios/opengl/core/GlViewportAware;", "", com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "notifyVertexArrayChange", "release", "", "d", "[F", "getModelMatrix", "()[F", "modelMatrix", "", "<set-?>", "e", "I", "getVertexArrayVersion", "()I", "vertexArrayVersion", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "getCoordsPerVertex", "coordsPerVertex", "getVertexStride", "vertexStride", "getVertexCount", "vertexCount", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public abstract class GlDrawable extends com.otaliastudios.opengl.core.GlViewportAware {

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final float[] modelMatrix = com.otaliastudios.opengl.internal.MiscKt.matrixClone(com.otaliastudios.opengl.core.Egloo.IDENTITY_MATRIX);

    /* renamed from: e, reason: from kotlin metadata */
    public int vertexArrayVersion;

    public abstract void draw();

    public abstract int getCoordsPerVertex();

    @org.jetbrains.annotations.NotNull
    public final float[] getModelMatrix() {
        return this.modelMatrix;
    }

    @org.jetbrains.annotations.NotNull
    public abstract java.nio.FloatBuffer getVertexArray();

    public final int getVertexArrayVersion() {
        return this.vertexArrayVersion;
    }

    public int getVertexCount() {
        return getVertexArray().limit() / getCoordsPerVertex();
    }

    public int getVertexStride() {
        return getCoordsPerVertex() * 4;
    }

    public final void notifyVertexArrayChange() {
        this.vertexArrayVersion++;
    }

    public void release() {
        com.otaliastudios.opengl.types.BuffersKt.dispose(getVertexArray());
    }

    public abstract void setVertexArray(@org.jetbrains.annotations.NotNull java.nio.FloatBuffer floatBuffer);
}
