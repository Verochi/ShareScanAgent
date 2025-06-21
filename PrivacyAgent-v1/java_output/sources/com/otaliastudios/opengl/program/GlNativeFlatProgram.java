package com.otaliastudios.opengl.program;

@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\t\b\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR(\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/otaliastudios/opengl/program/GlNativeFlatProgram;", "Lcom/otaliastudios/opengl/program/GlProgram;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", com.anythink.expressad.foundation.h.i.c, "", "modelViewProjectionMatrix", "", "onPreDraw", "onPostDraw", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "e", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "vertexPositionHandle", "f", "vertexMvpMatrixHandle", "g", "fragmentColorHandle", "h", "[F", "getColor", "()[F", "setColor", "([F)V", "getColor$annotations", "()V", "color", "<init>", "i", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlNativeFlatProgram extends com.otaliastudios.opengl.program.GlProgram {

    /* renamed from: e, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation vertexPositionHandle;

    /* renamed from: f, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation vertexMvpMatrixHandle;

    /* renamed from: g, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation fragmentColorHandle;

    /* renamed from: h, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public float[] color;

    public GlNativeFlatProgram() {
        super("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n}\n", "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n    gl_FragColor = uColor;\n}\n");
        this.vertexPositionHandle = getAttribHandle("aPosition");
        this.vertexMvpMatrixHandle = getUniformHandle("uMVPMatrix");
        this.fragmentColorHandle = getUniformHandle("uColor");
        this.color = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    }

    public static /* synthetic */ void getColor$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public final float[] getColor() {
        return this.color;
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPostDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        super.onPostDraw(drawable);
        android.opengl.GLES20.glDisableVertexAttribArray(this.vertexPositionHandle.getUvalue());
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPreDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable, @org.jetbrains.annotations.NotNull float[] modelViewProjectionMatrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelViewProjectionMatrix, "modelViewProjectionMatrix");
        super.onPreDraw(drawable, modelViewProjectionMatrix);
        android.opengl.GLES20.glUniformMatrix4fv(this.vertexMvpMatrixHandle.getValue(), 1, false, modelViewProjectionMatrix, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniformMatrix4fv");
        android.opengl.GLES20.glUniform4fv(this.fragmentColorHandle.getValue(), 1, this.color, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform4fv");
        android.opengl.GLES20.glEnableVertexAttribArray(this.vertexPositionHandle.getUvalue());
        com.otaliastudios.opengl.core.Egloo.checkGlError("glEnableVertexAttribArray");
        android.opengl.GLES20.glVertexAttribPointer(this.vertexPositionHandle.getUvalue(), drawable.getCoordsPerVertex(), com.otaliastudios.opengl.internal.GlKt.getGL_FLOAT(), false, drawable.getVertexStride(), (java.nio.Buffer) drawable.getVertexArray());
        com.otaliastudios.opengl.core.Egloo.checkGlError("glVertexAttribPointer");
    }

    public final void setColor(@org.jetbrains.annotations.NotNull float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.color = fArr;
    }
}
