package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class GlTextureDrawer {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.internal.GlTextureDrawer.class.getSimpleName());
    public final com.otaliastudios.opengl.texture.GlTexture a;
    public float[] b;

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.Filter c;
    public com.otaliastudios.cameraview.filter.Filter d;
    public int e;

    public GlTextureDrawer() {
        this(new com.otaliastudios.opengl.texture.GlTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0, 36197));
    }

    public GlTextureDrawer(int i) {
        this(new com.otaliastudios.opengl.texture.GlTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0, 36197, java.lang.Integer.valueOf(i)));
    }

    public GlTextureDrawer(@androidx.annotation.NonNull com.otaliastudios.opengl.texture.GlTexture glTexture) {
        this.b = (float[]) com.otaliastudios.opengl.core.Egloo.IDENTITY_MATRIX.clone();
        this.c = new com.otaliastudios.cameraview.filter.NoFilter();
        this.d = null;
        this.e = -1;
        this.a = glTexture;
    }

    public void draw(long j) {
        if (this.d != null) {
            release();
            this.c = this.d;
            this.d = null;
        }
        if (this.e == -1) {
            int create = com.otaliastudios.opengl.program.GlProgram.create(this.c.getVertexShader(), this.c.getFragmentShader());
            this.e = create;
            this.c.onCreate(create);
            com.otaliastudios.opengl.core.Egloo.checkGlError("program creation");
        }
        android.opengl.GLES20.glUseProgram(this.e);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUseProgram(handle)");
        this.a.bind();
        this.c.draw(j, this.b);
        this.a.unbind();
        android.opengl.GLES20.glUseProgram(0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUseProgram(0)");
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.opengl.texture.GlTexture getTexture() {
        return this.a;
    }

    @androidx.annotation.NonNull
    public float[] getTextureTransform() {
        return this.b;
    }

    public void release() {
        if (this.e == -1) {
            return;
        }
        this.c.onDestroy();
        android.opengl.GLES20.glDeleteProgram(this.e);
        this.e = -1;
    }

    public void setFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        this.d = filter;
    }

    public void setTextureTransform(@androidx.annotation.NonNull float[] fArr) {
        this.b = fArr;
    }
}
