package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
class VideoDecoderGLFrameRenderer implements android.opengl.GLSurfaceView.Renderer, com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer {
    public static final float[] C = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
    public static final float[] D = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
    public static final float[] E = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
    public static final java.lang.String[] F = {"y_tex", "u_tex", "v_tex"};
    public static final java.nio.FloatBuffer G = com.google.android.exoplayer2.util.GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    public com.google.android.exoplayer2.video.VideoDecoderOutputBuffer B;
    public final android.opengl.GLSurfaceView n;
    public int w;
    public int y;
    public final int[] t = new int[3];
    public final java.util.concurrent.atomic.AtomicReference<com.google.android.exoplayer2.video.VideoDecoderOutputBuffer> u = new java.util.concurrent.atomic.AtomicReference<>();
    public java.nio.FloatBuffer[] v = new java.nio.FloatBuffer[3];
    public int[] x = new int[3];
    public int[] z = new int[3];
    public int[] A = new int[3];

    public VideoDecoderGLFrameRenderer(android.opengl.GLSurfaceView gLSurfaceView) {
        this.n = gLSurfaceView;
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.z;
            this.A[i] = -1;
            iArr[i] = -1;
        }
    }

    public final void a() {
        android.opengl.GLES20.glGenTextures(3, this.t, 0);
        for (int i = 0; i < 3; i++) {
            android.opengl.GLES20.glUniform1i(android.opengl.GLES20.glGetUniformLocation(this.w, F[i]), i);
            android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0 + i);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.t[i]);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, 33071.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, 33071.0f);
        }
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        com.google.android.exoplayer2.video.VideoDecoderOutputBuffer andSet = this.u.getAndSet(null);
        if (andSet == null && this.B == null) {
            return;
        }
        if (andSet != null) {
            com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.B;
            if (videoDecoderOutputBuffer != null) {
                videoDecoderOutputBuffer.release();
            }
            this.B = andSet;
        }
        com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (com.google.android.exoplayer2.video.VideoDecoderOutputBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.B);
        float[] fArr = D;
        int i = videoDecoderOutputBuffer2.colorspace;
        if (i == 1) {
            fArr = C;
        } else if (i == 3) {
            fArr = E;
        }
        android.opengl.GLES20.glUniformMatrix3fv(this.y, 1, false, fArr, 0);
        int[] iArr = (int[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(videoDecoderOutputBuffer2.yuvStrides);
        java.nio.ByteBuffer[] byteBufferArr = (java.nio.ByteBuffer[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(videoDecoderOutputBuffer2.yuvPlanes);
        int i2 = 0;
        while (i2 < 3) {
            int i3 = i2 == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
            android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0 + i2);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.t[i2]);
            android.opengl.GLES20.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_UNPACK_ALIGNMENT, 1);
            android.opengl.GLES20.glTexImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, com.badlogic.gdx.graphics.GL20.GL_LUMINANCE, iArr[i2], i3, 0, com.badlogic.gdx.graphics.GL20.GL_LUMINANCE, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, byteBufferArr[i2]);
            i2++;
        }
        int i4 = videoDecoderOutputBuffer2.width;
        int i5 = (i4 + 1) / 2;
        int[] iArr2 = {i4, i5, i5};
        for (int i6 = 0; i6 < 3; i6++) {
            if (this.z[i6] != iArr2[i6] || this.A[i6] != iArr[i6]) {
                com.google.android.exoplayer2.util.Assertions.checkState(iArr[i6] != 0);
                float f = iArr2[i6] / iArr[i6];
                this.v[i6] = com.google.android.exoplayer2.util.GlUtil.createBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                android.opengl.GLES20.glVertexAttribPointer(this.x[i6], 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) this.v[i6]);
                this.z[i6] = iArr2[i6];
                this.A[i6] = iArr[i6];
            }
        }
        android.opengl.GLES20.glClear(16384);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
        android.opengl.GLES20.glViewport(0, 0, i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        int compileProgram = com.google.android.exoplayer2.util.GlUtil.compileProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.w = compileProgram;
        android.opengl.GLES20.glUseProgram(compileProgram);
        int glGetAttribLocation = android.opengl.GLES20.glGetAttribLocation(this.w, "in_pos");
        android.opengl.GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        android.opengl.GLES20.glVertexAttribPointer(glGetAttribLocation, 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) G);
        this.x[0] = android.opengl.GLES20.glGetAttribLocation(this.w, "in_tc_y");
        android.opengl.GLES20.glEnableVertexAttribArray(this.x[0]);
        this.x[1] = android.opengl.GLES20.glGetAttribLocation(this.w, "in_tc_u");
        android.opengl.GLES20.glEnableVertexAttribArray(this.x[1]);
        this.x[2] = android.opengl.GLES20.glGetAttribLocation(this.w, "in_tc_v");
        android.opengl.GLES20.glEnableVertexAttribArray(this.x[2]);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        this.y = android.opengl.GLES20.glGetUniformLocation(this.w, "mColorConversion");
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        a();
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
    }

    @Override // com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer
    public void setOutputBuffer(com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        com.google.android.exoplayer2.video.VideoDecoderOutputBuffer andSet = this.u.getAndSet(videoDecoderOutputBuffer);
        if (andSet != null) {
            andSet.release();
        }
        this.n.requestRender();
    }
}
