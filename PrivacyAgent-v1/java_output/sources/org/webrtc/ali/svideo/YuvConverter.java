package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
class YuvConverter {
    private static final java.lang.String FRAGMENT_2D_SHADER = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final java.lang.String FRAGMENT_OES_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final java.lang.String VERTEX_SHADER = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private final int coeffsLoc;
    private boolean released;
    private final org.webrtc.ali.svideo.GlShader shader;
    private final int texMatrixLoc;
    private final org.webrtc.ali.svideo.GlTextureFrameBuffer textureFrameBuffer;
    private final org.webrtc.ali.svideo.ThreadUtils.ThreadChecker threadChecker;
    private final int xUnitLoc;
    private static final java.nio.FloatBuffer DEVICE_RECTANGLE = org.webrtc.ali.svideo.GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final java.nio.FloatBuffer TEXTURE_RECTANGLE = org.webrtc.ali.svideo.GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});

    public enum TextureType {
        TEXTURE_TYPE_OES,
        TEXTURE_TYPE_2D
    }

    public YuvConverter() {
        this(0);
    }

    public YuvConverter(int i) {
        org.webrtc.ali.svideo.GlShader glShader;
        org.webrtc.ali.svideo.ThreadUtils.ThreadChecker threadChecker = new org.webrtc.ali.svideo.ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.released = false;
        threadChecker.checkIsOnValidThread();
        this.textureFrameBuffer = new org.webrtc.ali.svideo.GlTextureFrameBuffer(com.badlogic.gdx.graphics.GL20.GL_RGBA);
        if (i == org.webrtc.ali.svideo.YuvConverter.TextureType.TEXTURE_TYPE_OES.ordinal()) {
            glShader = new org.webrtc.ali.svideo.GlShader(VERTEX_SHADER, FRAGMENT_OES_SHADER);
        } else {
            if (i != org.webrtc.ali.svideo.YuvConverter.TextureType.TEXTURE_TYPE_2D.ordinal()) {
                throw new java.lang.RuntimeException("new YuvConverter failed with wrong textureType = " + i);
            }
            glShader = new org.webrtc.ali.svideo.GlShader(VERTEX_SHADER, FRAGMENT_2D_SHADER);
        }
        this.shader = glShader;
        this.shader.useProgram();
        this.texMatrixLoc = this.shader.getUniformLocation("texMatrix");
        this.xUnitLoc = this.shader.getUniformLocation("xUnit");
        this.coeffsLoc = this.shader.getUniformLocation("coeffs");
        android.opengl.GLES20.glUniform1i(this.shader.getUniformLocation("oesTex"), 1);
        org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
        this.shader.setVertexAttribArray("in_pos", 2, DEVICE_RECTANGLE);
        this.shader.setVertexAttribArray("in_tc", 2, TEXTURE_RECTANGLE);
    }

    public void convert(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, float[] fArr) {
        this.threadChecker.checkIsOnValidThread();
        if (this.released) {
            throw new java.lang.IllegalStateException("YuvConverter.convert called on released object");
        }
        if (i3 % 8 != 0) {
            throw new java.lang.IllegalArgumentException("Invalid stride, must be a multiple of 8");
        }
        if (i3 < i) {
            throw new java.lang.IllegalArgumentException("Invalid stride, must >= width");
        }
        int i6 = (i + 3) / 4;
        int i7 = (i + 7) / 8;
        int i8 = (i2 + 1) / 2;
        int i9 = i2 + i8;
        if (byteBuffer.capacity() < i3 * i9) {
            throw new java.lang.IllegalArgumentException("YuvConverter.convert called with too small buffer");
        }
        float[] multiplyMatrices = org.webrtc.ali.svideo.RendererCommon.multiplyMatrices(fArr, org.webrtc.ali.svideo.RendererCommon.verticalFlipMatrix());
        int i10 = i3 / 4;
        this.textureFrameBuffer.setSize(i10, i9);
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, this.textureFrameBuffer.getFrameBufferId());
        org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("glBindFramebuffer");
        android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE1);
        org.webrtc.ali.svideo.YuvConverter.TextureType textureType = org.webrtc.ali.svideo.YuvConverter.TextureType.TEXTURE_TYPE_OES;
        if (i5 == textureType.ordinal()) {
            android.opengl.GLES20.glBindTexture(36197, i4);
        } else {
            if (i5 != org.webrtc.ali.svideo.YuvConverter.TextureType.TEXTURE_TYPE_2D.ordinal()) {
                throw new java.lang.RuntimeException("YuvConverter convert failed with wrong textureType = " + i5);
            }
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i4);
        }
        android.opengl.GLES20.glUniformMatrix4fv(this.texMatrixLoc, 1, false, multiplyMatrices, 0);
        android.opengl.GLES20.glViewport(0, 0, i6, i2);
        float f = i;
        android.opengl.GLES20.glUniform2f(this.xUnitLoc, multiplyMatrices[0] / f, multiplyMatrices[1] / f);
        android.opengl.GLES20.glUniform4f(this.coeffsLoc, 0.299f, 0.587f, 0.114f, 0.0f);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glViewport(0, i2, i7, i8);
        android.opengl.GLES20.glUniform2f(this.xUnitLoc, (multiplyMatrices[0] * 2.0f) / f, (multiplyMatrices[1] * 2.0f) / f);
        android.opengl.GLES20.glUniform4f(this.coeffsLoc, -0.169f, -0.331f, 0.499f, 0.5f);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glViewport(i3 / 8, i2, i7, i8);
        android.opengl.GLES20.glUniform4f(this.coeffsLoc, 0.499f, -0.418f, -0.0813f, 0.5f);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glReadPixels(0, 0, i10, i9, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, byteBuffer);
        org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("YuvConverter.convert");
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, 0);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
        if (i5 == textureType.ordinal()) {
            android.opengl.GLES20.glBindTexture(36197, 0);
        } else {
            if (i5 == org.webrtc.ali.svideo.YuvConverter.TextureType.TEXTURE_TYPE_2D.ordinal()) {
                android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
                return;
            }
            throw new java.lang.RuntimeException("YuvConverter convert failed with wrong textureType = " + i5);
        }
    }

    public void convert(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, int i4, float[] fArr) {
        convert(byteBuffer, i, i2, i3, i4, 0, fArr);
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.released = true;
        this.shader.release();
        this.textureFrameBuffer.release();
    }
}
