package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class GlRectDrawer implements org.webrtc.ali.svideo.RendererCommon.GlDrawer {
    private static final java.nio.FloatBuffer FULL_RECTANGLE_BUF = org.webrtc.ali.svideo.GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final java.nio.FloatBuffer FULL_RECTANGLE_TEX_BUF = org.webrtc.ali.svideo.GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private static final java.lang.String OES_FRAGMENT_SHADER_STRING = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n";
    private static final java.lang.String RGB_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n";
    private static final java.lang.String VERTEX_SHADER_STRING = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private static final java.lang.String YUV_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n";
    private final java.util.Map<java.lang.String, org.webrtc.ali.svideo.GlRectDrawer.Shader> shaders = new java.util.IdentityHashMap();

    public static class Shader {
        public final org.webrtc.ali.svideo.GlShader glShader;
        public final int texMatrixLocation;

        public Shader(java.lang.String str) {
            org.webrtc.ali.svideo.GlShader glShader = new org.webrtc.ali.svideo.GlShader(org.webrtc.ali.svideo.GlRectDrawer.VERTEX_SHADER_STRING, str);
            this.glShader = glShader;
            this.texMatrixLocation = glShader.getUniformLocation("texMatrix");
        }
    }

    public enum TextureType {
        TEXTURE_TYPE_OES,
        TEXTURE_TYPE_2D
    }

    private void drawRectangle(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glViewport(i, i2, i3, i4);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
    }

    private void prepareShader(java.lang.String str, float[] fArr) {
        org.webrtc.ali.svideo.GlShader glShader;
        java.lang.String str2;
        org.webrtc.ali.svideo.GlRectDrawer.Shader shader;
        if (this.shaders.containsKey(str)) {
            shader = this.shaders.get(str);
        } else {
            org.webrtc.ali.svideo.GlRectDrawer.Shader shader2 = new org.webrtc.ali.svideo.GlRectDrawer.Shader(str);
            this.shaders.put(str, shader2);
            shader2.glShader.useProgram();
            if (str == YUV_FRAGMENT_SHADER_STRING) {
                android.opengl.GLES20.glUniform1i(shader2.glShader.getUniformLocation("y_tex"), 0);
                android.opengl.GLES20.glUniform1i(shader2.glShader.getUniformLocation("u_tex"), 1);
                android.opengl.GLES20.glUniform1i(shader2.glShader.getUniformLocation("v_tex"), 2);
            } else {
                if (str == RGB_FRAGMENT_SHADER_STRING) {
                    glShader = shader2.glShader;
                    str2 = "rgb_tex";
                } else {
                    if (str != OES_FRAGMENT_SHADER_STRING) {
                        throw new java.lang.IllegalStateException("Unknown fragment shader: " + str);
                    }
                    glShader = shader2.glShader;
                    str2 = "oes_tex";
                }
                android.opengl.GLES20.glUniform1i(glShader.getUniformLocation(str2), 0);
            }
            org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            shader2.glShader.setVertexAttribArray("in_pos", 2, FULL_RECTANGLE_BUF);
            shader2.glShader.setVertexAttribArray("in_tc", 2, FULL_RECTANGLE_TEX_BUF);
            shader = shader2;
        }
        shader.glShader.useProgram();
        android.opengl.GLES20.glUniformMatrix4fv(shader.texMatrixLocation, 1, false, fArr, 0);
    }

    @Override // org.webrtc.ali.svideo.RendererCommon.GlDrawer
    public void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(OES_FRAGMENT_SHADER_STRING, fArr);
        android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
        android.opengl.GLES20.glBindTexture(36197, i);
        drawRectangle(i4, i5, i6, i7);
        android.opengl.GLES20.glBindTexture(36197, 0);
    }

    @Override // org.webrtc.ali.svideo.RendererCommon.GlDrawer
    public void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(RGB_FRAGMENT_SHADER_STRING, fArr);
        android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i);
        drawRectangle(i4, i5, i6, i7);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
    }

    @Override // org.webrtc.ali.svideo.RendererCommon.GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6) {
        prepareShader(YUV_FRAGMENT_SHADER_STRING, fArr);
        for (int i7 = 0; i7 < 3; i7++) {
            android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0 + i7);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, iArr[i7]);
        }
        drawRectangle(i3, i4, i5, i6);
        for (int i8 = 0; i8 < 3; i8++) {
            android.opengl.GLES20.glActiveTexture(i8 + com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
        }
    }

    @Override // org.webrtc.ali.svideo.RendererCommon.GlDrawer
    public void release() {
        java.util.Iterator<org.webrtc.ali.svideo.GlRectDrawer.Shader> it = this.shaders.values().iterator();
        while (it.hasNext()) {
            it.next().glShader.release();
        }
        this.shaders.clear();
    }
}
