package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class BasicRenderer {
    private float[] mVertex = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private float[] mCoord = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private java.lang.String mVertexShader = "attribute vec3 a_position;\n    attribute vec2 a_texcoord;\n    \n    varying vec2 v_texcoord;\n    void main()\n    {\n        gl_Position = vec4(a_position.xyz, 1.0);\n        v_texcoord  = a_texcoord;\n    }";
    private java.lang.String mFragShader = "#ifdef GL_ES\n    precision mediump float;\n#endif\n    uniform sampler2D RACE_Tex0;\n    varying vec2 v_texcoord;\n    void main()\n    {\n        gl_FragColor = texture2D(RACE_Tex0, v_texcoord);\n    }";
    private int mProgram = createProgram();
    private java.nio.FloatBuffer mVertexBuffer = allocBuffer(this.mVertex);
    private java.nio.FloatBuffer mCoordBuffer = allocBuffer(this.mCoord);

    private java.nio.FloatBuffer allocBuffer(float[] fArr) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private void check() {
        int glGetError = android.opengl.GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("gl error ");
        sb.append(glGetError);
        throw new java.lang.AssertionError();
    }

    private int compileShader(int i, java.lang.String str) {
        int glCreateShader = android.opengl.GLES20.glCreateShader(i);
        android.opengl.GLES20.glShaderSource(glCreateShader, str);
        android.opengl.GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    private int createProgram() {
        this.mProgram = android.opengl.GLES20.glCreateProgram();
        int compileShader = compileShader(com.badlogic.gdx.graphics.GL20.GL_VERTEX_SHADER, this.mVertexShader);
        int compileShader2 = compileShader(com.badlogic.gdx.graphics.GL20.GL_FRAGMENT_SHADER, this.mFragShader);
        android.opengl.GLES20.glAttachShader(this.mProgram, compileShader);
        android.opengl.GLES20.glAttachShader(this.mProgram, compileShader2);
        android.opengl.GLES20.glLinkProgram(this.mProgram);
        android.opengl.GLES20.glDeleteShader(compileShader);
        android.opengl.GLES20.glDeleteShader(compileShader2);
        return this.mProgram;
    }

    public void destroy() {
        android.opengl.GLES20.glDeleteProgram(this.mProgram);
    }

    public void draw(int i) {
        android.opengl.GLES20.glUseProgram(this.mProgram);
        int glGetAttribLocation = android.opengl.GLES20.glGetAttribLocation(this.mProgram, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE);
        android.opengl.GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        android.opengl.GLES20.glVertexAttribPointer(glGetAttribLocation, 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) this.mVertexBuffer);
        int glGetAttribLocation2 = android.opengl.GLES20.glGetAttribLocation(this.mProgram, "a_texcoord");
        android.opengl.GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        android.opengl.GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) this.mCoordBuffer);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.mProgram, "RACE_Tex0");
        android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i);
        android.opengl.GLES20.glUniform1i(glGetUniformLocation, 0);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
    }
}
