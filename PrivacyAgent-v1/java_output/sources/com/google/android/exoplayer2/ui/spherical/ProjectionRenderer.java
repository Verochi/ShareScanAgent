package com.google.android.exoplayer2.ui.spherical;

/* loaded from: classes22.dex */
final class ProjectionRenderer {
    public static final java.lang.String[] j = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", com.alipay.sdk.m.u.i.d};
    public static final java.lang.String[] k = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", com.alipay.sdk.m.u.i.d};
    public static final float[] l = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] m = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    public static final float[] n = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] o = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] p = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};
    public int a;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.MeshData b;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.MeshData c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public static class MeshData {
        public final int a;
        public final java.nio.FloatBuffer b;
        public final java.nio.FloatBuffer c;
        public final int d;

        public MeshData(com.google.android.exoplayer2.video.spherical.Projection.SubMesh subMesh) {
            this.a = subMesh.getVertexCount();
            this.b = com.google.android.exoplayer2.util.GlUtil.createBuffer(subMesh.vertices);
            this.c = com.google.android.exoplayer2.util.GlUtil.createBuffer(subMesh.textureCoords);
            int i = subMesh.mode;
            if (i == 1) {
                this.d = 5;
            } else if (i != 2) {
                this.d = 4;
            } else {
                this.d = 6;
            }
        }
    }

    public static boolean c(com.google.android.exoplayer2.video.spherical.Projection projection) {
        com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh = projection.leftMesh;
        com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh2 = projection.rightMesh;
        return mesh.getSubMeshCount() == 1 && mesh.getSubMesh(0).textureId == 0 && mesh2.getSubMeshCount() == 1 && mesh2.getSubMesh(0).textureId == 0;
    }

    public void a(int i, float[] fArr, boolean z) {
        com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.MeshData meshData = z ? this.c : this.b;
        if (meshData == null) {
            return;
        }
        android.opengl.GLES20.glUseProgram(this.d);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        android.opengl.GLES20.glEnableVertexAttribArray(this.g);
        android.opengl.GLES20.glEnableVertexAttribArray(this.h);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        int i2 = this.a;
        android.opengl.GLES20.glUniformMatrix3fv(this.f, 1, false, i2 == 1 ? z ? n : m : i2 == 2 ? z ? p : o : l, 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.e, 1, false, fArr, 0);
        android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
        android.opengl.GLES20.glBindTexture(36197, i);
        android.opengl.GLES20.glUniform1i(this.i, 0);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        android.opengl.GLES20.glVertexAttribPointer(this.g, 3, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 12, (java.nio.Buffer) meshData.b);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        android.opengl.GLES20.glVertexAttribPointer(this.h, 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 8, (java.nio.Buffer) meshData.c);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        android.opengl.GLES20.glDrawArrays(meshData.d, 0, meshData.a);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        android.opengl.GLES20.glDisableVertexAttribArray(this.g);
        android.opengl.GLES20.glDisableVertexAttribArray(this.h);
    }

    public void b() {
        int compileProgram = com.google.android.exoplayer2.util.GlUtil.compileProgram(j, k);
        this.d = compileProgram;
        this.e = android.opengl.GLES20.glGetUniformLocation(compileProgram, "uMvpMatrix");
        this.f = android.opengl.GLES20.glGetUniformLocation(this.d, "uTexMatrix");
        this.g = android.opengl.GLES20.glGetAttribLocation(this.d, "aPosition");
        this.h = android.opengl.GLES20.glGetAttribLocation(this.d, "aTexCoords");
        this.i = android.opengl.GLES20.glGetUniformLocation(this.d, "uTexture");
    }

    public void d(com.google.android.exoplayer2.video.spherical.Projection projection) {
        if (c(projection)) {
            this.a = projection.stereoMode;
            com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.MeshData meshData = new com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.MeshData(projection.leftMesh.getSubMesh(0));
            this.b = meshData;
            if (!projection.singleMesh) {
                meshData = new com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.MeshData(projection.rightMesh.getSubMesh(0));
            }
            this.c = meshData;
        }
    }
}
