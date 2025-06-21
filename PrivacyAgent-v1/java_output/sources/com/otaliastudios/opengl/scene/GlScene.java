package com.otaliastudios.opengl.scene;

@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u001d\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/otaliastudios/opengl/scene/GlScene;", "Lcom/otaliastudios/opengl/core/GlViewportAware;", "Lcom/otaliastudios/opengl/program/GlProgram;", "program", "Lcom/otaliastudios/opengl/draw/GlDrawable;", com.anythink.expressad.foundation.h.i.c, "", com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "a", "", "d", "[F", "getProjectionMatrix", "()[F", "getProjectionMatrix$annotations", "()V", "projectionMatrix", "e", "getViewMatrix", "getViewMatrix$annotations", "viewMatrix", "f", "modelViewMatrix", "g", "modelViewProjectionMatrix", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlScene extends com.otaliastudios.opengl.core.GlViewportAware {

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final float[] projectionMatrix;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final float[] viewMatrix;

    /* renamed from: f, reason: from kotlin metadata */
    public final float[] modelViewMatrix;

    /* renamed from: g, reason: from kotlin metadata */
    public final float[] modelViewProjectionMatrix;

    public GlScene() {
        float[] fArr = com.otaliastudios.opengl.core.Egloo.IDENTITY_MATRIX;
        this.projectionMatrix = com.otaliastudios.opengl.internal.MiscKt.matrixClone(fArr);
        this.viewMatrix = com.otaliastudios.opengl.internal.MiscKt.matrixClone(fArr);
        this.modelViewMatrix = new float[16];
        this.modelViewProjectionMatrix = new float[16];
    }

    public static /* synthetic */ void getProjectionMatrix$annotations() {
    }

    public static /* synthetic */ void getViewMatrix$annotations() {
    }

    public final void a(com.otaliastudios.opengl.draw.GlDrawable drawable) {
        com.otaliastudios.opengl.internal.MiscKt.matrixMultiply(this.modelViewMatrix, this.viewMatrix, drawable.getModelMatrix());
        com.otaliastudios.opengl.internal.MiscKt.matrixMultiply(this.modelViewProjectionMatrix, this.projectionMatrix, this.modelViewMatrix);
    }

    public final void draw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.program.GlProgram program, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(program, "program");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        ensureViewportSize();
        drawable.setViewportSize(getViewportWidth(), getViewportHeight());
        a(drawable);
        program.draw(drawable, this.modelViewProjectionMatrix);
    }

    @org.jetbrains.annotations.NotNull
    public final float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    @org.jetbrains.annotations.NotNull
    public final float[] getViewMatrix() {
        return this.viewMatrix;
    }
}
